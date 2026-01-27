package org.SHIFT_2026_utilSort;

import java.util.ArrayList;

public class ConfigurationUtil {
    private static final ConfigurationUtil INSTANCE = new ConfigurationUtil();

    public static final String FILE_NAME_INT = "integers.txt";
    public static final String FILE_NAME_FLOAT = "floats.txt";
    public static final String FILE_NAME_STRING = "strings.txt";

    private String outputDirectoryPath = ".";
    private String prefixFileName = "";
    private FileWriteStatus fileWriteStatus = FileWriteStatus.REWRITE;
    private ArrayList<String> listInputFileNames = new ArrayList<String>();

    private ConfigurationUtil() {}

    public static ConfigurationUtil getInstance() {
        return INSTANCE;
    }

    public String getOutputDirectoryPath() {
        return outputDirectoryPath;
    }

    public String getPrefixFileName() {
        return prefixFileName;
    }

    public String getFileWriteStatus() {
        return fileWriteStatus.toString();
    }

    public ArrayList<String> getListInputFileNames() {
        return listInputFileNames;
    }

    public void setOutputDirectoryPath(String path){
        outputDirectoryPath = path;
    }

    public void setPrefixFileName(String prefix){
        prefixFileName = prefix;
    }

    public void setFileWriteStatus(FileWriteStatus status){
        fileWriteStatus = status;
    }

    public void addFileName(String fileName){
        listInputFileNames.add(fileName);
    }

    public void print() {
        System.out.println("outputDirectoryPath: " + outputDirectoryPath + "\n" +
            "prefixFileName: " + prefixFileName + "\n" +
            "fileWriteStatus: " + fileWriteStatus + "\n" +
            "файлы: " + listInputFileNames);
    }
}
