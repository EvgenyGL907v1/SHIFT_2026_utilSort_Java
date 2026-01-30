package org.SHIFT_2026_utilSort;

import java.io.*;
import java.util.ArrayList;

public class FileReader {
    public ArrayList<String> readFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();

        try (BufferedReader br= new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null)
                fileData.add(line);
        } catch (IOException e) {
            System.out.println("Ошибка! Не удалось прочитать файл " + fileName);
        }
        return fileData;
    }
}
