package com.example.panzhiev.a111minutessimplefilemanager.utils;

import java.io.File;

/**
 * Created by Tim on 27.05.2017.
 */

public interface IFileManager {

    boolean isExternalStorageReadable();

    void saveFileToExternalStorage(String fileName);

    String openFile(String fileName);

    void writeFile(String fileName, String fileContent);

    String readFile(String fileName);

    File[] getDirectoryContent(String path);

    String getPath();
}
