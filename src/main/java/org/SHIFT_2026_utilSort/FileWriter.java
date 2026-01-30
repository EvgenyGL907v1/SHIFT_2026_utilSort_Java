package org.SHIFT_2026_utilSort;

import org.SHIFT_2026_utilSort.Identifier.StateLine;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {
    private BufferedWriter writerInt = null;
    private BufferedWriter writerFloat = null;
    private BufferedWriter writerString = null;

    private int сountErrorEntry = 0;

    public void printCountErrorEntry() {
        if (сountErrorEntry > 0)
            System.out.println("Внимание! Количество незаписанных элементов в файлы составило: " + сountErrorEntry);
    }

    public void writeFileData(String line, StateLine state) {
        switch (state) {
            case StateLine.INT ->
                    writerInt = write(line, writerInt, ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_INT);
            case StateLine.FLOAT ->
                    writerFloat = write(line, writerFloat, ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_FLOAT);
            case StateLine.STRING ->
                    writerString = write(line, writerString, ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_STRING);
        }
    }

    public void closeBuffers() {
        close(writerInt);
        close(writerFloat);
        close(writerString);
    }

    private BufferedWriter write(String element, BufferedWriter bw, String fileName) {
        try {
            File file = new File(ConfigurationUtil.getInstance().getOutputDirectoryPath(), fileName);

            if (bw == null)
                bw = new BufferedWriter(new java.io.FileWriter(file, ConfigurationUtil.getInstance().getFileWriteStatus() == FileWriteStatus.APPEND));

            bw.write(element + System.lineSeparator());

            bw.flush();
        } catch (IOException e) {
            сountErrorEntry++;
        }
        return bw;
    }

    private void close(BufferedWriter bw) {
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Ошибка! Не удалось закрыть поток.");
            }
        }
    }
}
