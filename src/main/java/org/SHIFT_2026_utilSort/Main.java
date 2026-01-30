package org.SHIFT_2026_utilSort;

import org.SHIFT_2026_utilSort.Identifier.GeneralAlgRecognizer;
import org.SHIFT_2026_utilSort.Identifier.Identifier;
import org.SHIFT_2026_utilSort.Identifier.StateLine;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        InputParser parser = new InputParser();
        parser.parce(args);

        ArrayList<String> listInputFileNames = ConfigurationUtil.getInstance().getListInputFileNames();

        Identifier identifier = new GeneralAlgRecognizer();
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        StatisticsManager statisticsManager = new StatisticsManager();
        boolean statisticEnable = (ConfigurationUtil.getInstance().getStatisticEnableShort() || ConfigurationUtil.getInstance().getStatisticEnableFull());

        for (int fileIndex = 0; fileIndex < listInputFileNames.size(); fileIndex++) {
            ArrayList<String> fileData = fileReader.readFileData(listInputFileNames.get(fileIndex));

            for (int stringIndex = 0; stringIndex < fileData.size(); stringIndex++) {
                String line = fileData.get(stringIndex);

                StateLine lineState = identifier.identifyState(line);

                if(statisticEnable)
                    statisticsManager.addElement(line, lineState);

                fileWriter.writeFileData(line, lineState);
            }
        }
        fileWriter.closeBuffers();

        statisticsManager.printStatistics();
        fileWriter.printCountErrorEntry();
    }
}