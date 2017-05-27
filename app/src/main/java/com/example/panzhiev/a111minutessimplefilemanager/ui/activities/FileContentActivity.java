package com.example.panzhiev.a111minutessimplefilemanager.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.panzhiev.a111minutessimplefilemanager.R;
import com.example.panzhiev.a111minutessimplefilemanager.utils.FileManager;

public class FileContentActivity extends AppCompatActivity{

    EditText etFileContent;
    Button btnSaveFile;
    TextView tvFileContent;
    private final String FILE_CONTENT_ACTIVITY_LOG = "FileContentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_content);

        init();
        final FileManager fileManager = new FileManager();

        etFileContent.setText(fileManager.readFile(FileManager.selectFileName));

        tvFileContent.setText(fileManager.openFile(FileManager.selectFileName));
        btnSaveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileContent = etFileContent.getText().toString();

                fileManager.writeFile(FileManager.selectFileName, fileContent);
                Log.d(FILE_CONTENT_ACTIVITY_LOG, "File was overwrite successfully");

                tvFileContent.setText(fileManager.openFile(FileManager.selectFileName));
                Log.d(FILE_CONTENT_ACTIVITY_LOG, "File Content added successfully");
            }
        });
    }

    private void init()
    {
        etFileContent = (EditText) findViewById(R.id.et_file_content);
        btnSaveFile = (Button) findViewById(R.id.btn_save_file);
        tvFileContent = (TextView) findViewById(R.id.tv_file_content);
    }
}
