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
import com.example.panzhiev.a111minutessimplefilemanager.utils.SharedPrefsHelper;

/**
 * Created by Tim on 27.05.2017.
 */

public class FileContentActivity extends AppCompatActivity {

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

        //getting the last used file`s name from the SharedPreferences
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper();
        final String fileName = sharedPrefsHelper.getStringValue(this, "filename");

        etFileContent.setText(fileManager.readFile(fileName));
        tvFileContent.setText(fileManager.openFile(fileName));
        btnSaveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileContent = etFileContent.getText().toString();

                fileManager.writeFile(fileName, fileContent);
                Log.d(FILE_CONTENT_ACTIVITY_LOG, "File was overwrite successfully");

                tvFileContent.setText(fileManager.openFile(fileName));
                Log.d(FILE_CONTENT_ACTIVITY_LOG, "File Content added successfully");
            }
        });
    }

    private void init() {
        etFileContent = (EditText) findViewById(R.id.et_file_content);
        btnSaveFile = (Button) findViewById(R.id.btn_save_file);
        tvFileContent = (TextView) findViewById(R.id.tv_file_content);
    }
}
