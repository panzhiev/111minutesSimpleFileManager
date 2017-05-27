package com.example.panzhiev.a111minutessimplefilemanager.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.panzhiev.a111minutessimplefilemanager.R;
import com.example.panzhiev.a111minutessimplefilemanager.ui.adapters.FilesAdapter;
import com.example.panzhiev.a111minutessimplefilemanager.utils.FileManager;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tim on 27.05.2017.
 */

public class FilesListActivity extends AppCompatActivity {

    ListView listView;
    List<File> filesList;
    FilesAdapter mFilesAdapter;
    private final String FILES_LIST_ACTIVITY_LOG = "FilesListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_list);

        listView = (ListView) findViewById(R.id.list_view);

        FileManager fileManager = new FileManager();
        filesList = Arrays.asList(fileManager.getDirectoryContent(fileManager.getPath()));

        mFilesAdapter = new FilesAdapter(this, filesList);
        listView.setAdapter(mFilesAdapter);
    }
}
