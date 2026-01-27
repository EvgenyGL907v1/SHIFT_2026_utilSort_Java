package org.SHIFT_2026_utilSort;

import java.io.File;

public class FileValidator {
    static public boolean isFile(String filePath) {
        File file = new File(filePath);
        return file.isFile();
    }

    static public boolean isDirectory(String directoryPath) {
        File file = new File(directoryPath);
        return file.isDirectory();
    }
}
