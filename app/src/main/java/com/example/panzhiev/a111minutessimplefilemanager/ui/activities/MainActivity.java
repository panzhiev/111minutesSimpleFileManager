package com.example.panzhiev.a111minutessimplefilemanager.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.panzhiev.a111minutessimplefilemanager.R;
import com.example.panzhiev.a111minutessimplefilemanager.utils.FileManager;
import com.example.panzhiev.a111minutessimplefilemanager.utils.SharedPrefsHelper;

/**
 * Created by Tim on 27.05.2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etFileName;
    Button btnSaveFile, btnOpenDirectory;
    SharedPrefsHelper sharedPrefsHelper;
    private final String MAIN_ACTIVITY_LOG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefsHelper = new SharedPrefsHelper();
        sharedPrefsHelper.firstRunChecking(this);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save_file:
                FileManager fileManager = new FileManager();
                if (fileManager.isExternalStorageReadable()) {
                    fileManager.saveFileToExternalStorage(etFileName.getText().toString());
                }
                etFileName.setText("");
                break;
            case R.id.btn_open_directory:
                Intent intent = new Intent(this, FilesListActivity.class);
                startActivity(intent);
        }
    }

    private void init()
    {
        etFileName = (EditText) findViewById(R.id.et_file_name);
        btnSaveFile = (Button) findViewById(R.id.btn_save_file);
        btnSaveFile.setOnClickListener(this);
        btnOpenDirectory = (Button) findViewById(R.id.btn_open_directory);
        btnOpenDirectory.setOnClickListener(this);
    }
}
