package com.example.panzhiev.a111minutessimplefilemanager.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.panzhiev.a111minutessimplefilemanager.R;
import com.example.panzhiev.a111minutessimplefilemanager.ui.adapters.FilesAdapter;
import com.example.panzhiev.a111minutessimplefilemanager.utils.FileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tim on 27.05.2017.
 */

public class FilesListActivity extends AppCompatActivity {

    ListView mListView;
    TextView mTextView;
    List<File> filesList;
    FilesAdapter mFilesAdapter;
    private final String FILES_LIST_ACTIVITY_LOG = "FilesListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_list);

        mListView = (ListView) findViewById(R.id.list_view);
        mTextView = (TextView) findViewById(R.id.tv_empty);

        //Create list of files from current folder
        FileManager fileManager = new FileManager();
        try {
            filesList = Arrays.asList(fileManager.getDirectoryContent(fileManager.getPath()));
            mTextView.setVisibility(View.INVISIBLE);
        } catch (NullPointerException npe){

            //if path is not exist
            mTextView.setVisibility(View.VISIBLE);
            filesList = new ArrayList<>();
        }

        //setting data in listview
        mFilesAdapter = new FilesAdapter(this, filesList);
        mListView.setAdapter(mFilesAdapter);
    }
}
