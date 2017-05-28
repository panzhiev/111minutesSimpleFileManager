package com.example.panzhiev.a111minutessimplefilemanager.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.panzhiev.a111minutessimplefilemanager.ui.activities.FileContentActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Tim on 28.05.2017.
 */

public class SharedPrefsHelper {

    public static final String PREFS_NAME = "com.example.panzhiev.a111minutessimplefilemanager";

    SharedPreferences prefs = null;

    //check app for first run
    public void firstRunChecking(Context context) {

        prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if (prefs.getBoolean("firstrun", true)) {
            prefs.edit().putBoolean("firstrun", false).apply();
        } else {
            Intent intent = new Intent(context, FileContentActivity.class);
            context.startActivity(intent);
        }
    }

    public void putStringValue(Context context, String key, String value) {
        prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit().putString(key, value);
        editor.apply();
    }

    public String getStringValue(Context context, String key){
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return prefs.getString(key, null);
    }
}
