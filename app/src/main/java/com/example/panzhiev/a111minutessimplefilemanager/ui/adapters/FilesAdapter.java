package com.example.panzhiev.a111minutessimplefilemanager.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.panzhiev.a111minutessimplefilemanager.R;
import com.example.panzhiev.a111minutessimplefilemanager.ui.activities.FileContentActivity;
import com.example.panzhiev.a111minutessimplefilemanager.utils.SharedPrefsHelper;

import java.io.File;
import java.util.List;

/**
 * Created by Tim on 27.05.2017.
 */

public class FilesAdapter extends BaseAdapter {

    Context mContext;
    List<File> list;
    LayoutInflater inflater;
    private final String FILES_ADAPTER_LOG = "MainActivity";

    public FilesAdapter(Context mContext, List<File> list) {
        this.mContext = mContext;
        this.list = list;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null){
            view = inflater.inflate(R.layout.item_file, viewGroup, false);
        }
        final File file = (File) getItem(i);
        TextView tvFileName = (TextView) view.findViewById(R.id.tv_file_name);
        tvFileName.setText(file.getName());

        CardView cardViewFile = (CardView) view.findViewById(R.id.cv_file);
        cardViewFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fileName = file.getName();
                SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper();
                sharedPrefsHelper.putStringValue(mContext,"filename", fileName);

                Log.d(FILES_ADAPTER_LOG, file.getName());
                Intent intent = new Intent(mContext, FileContentActivity.class);
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
