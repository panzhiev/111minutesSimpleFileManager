package com.example.panzhiev.a111minutessimplefilemanager.utils;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Tim on 27.05.2017.
 */

public class FileManager implements IFileManager{

    public static String selectFileName;
    private final String FILE_MANAGER_LOG = "FileManager";

    //checking is ExternalStorage readable
    @Override
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();

        //checking state of ExternalStorage
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    //saving file to the ExternalStorage
    @Override
    public void saveFileToExternalStorage(String fileName) {

        Log.d(FILE_MANAGER_LOG, "Current Directory: " + Environment.getExternalStorageDirectory());

        //file creating
        File file = new File(getPath(), fileName + ".txt");

        //if the path is missing, create nonexistent parent directories
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            //file will be overwritten, if it exists
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //file opening
    @Override
    public String openFile(String fileName) {
        String openStr = "";
        File file = new File(getPath(), fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int c;
            while ((c = bufferedReader.read()) != -1) {
                openStr += (char) c;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return openStr;
    }

    //writing data into the file
    @Override
    public void writeFile(String fileName, String fileContent) {
        File file = new File(getPath(), fileName);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(fileContent);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //return list of files and folders
    @Override
    public File[] getDirectoryContent(String path) {
        File file = new File(path);
        File[] allFiles = file.listFiles();
        return allFiles;
    }

    //getting path of all files
    @Override
    public String getPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "//allFiles";
    }

    //reading data from the file
    @Override
    public String readFile(String fileName) {
        File file = new File(getPath(), fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            br.close() ;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
