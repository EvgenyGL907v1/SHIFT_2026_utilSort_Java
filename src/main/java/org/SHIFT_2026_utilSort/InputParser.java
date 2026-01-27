package org.SHIFT_2026_utilSort;

import org.SHIFT_2026_utilSort.Options.*;

import java.util.ArrayList;

public class InputParser {
    private final ArrayList<Option> options = new ArrayList<>();

    public InputParser() {
        options.add(new OptionSetOutputDirectoryPath());
        options.add(new OptionSetPrefixFileName());
        options.add(new OptionSetFileWriteStatus());
        options.add(new OptionAddFile());
    }

    public void parce(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String arg = input[i];
            Option option = recognizeOption(arg);

            if(option != null) {
                int processedArgs = option.execute(input, i);
                i += (processedArgs - 1);
            } else {
                System.out.println("Предупреждение: Неизвестная опция \"" + arg +"\"." + " Опция \"" + arg + "\" не будет учтена.");
            }
        }
    }

    private Option recognizeOption(String arg) {
        for (Option option : options) {
            if (option.checkCondition(arg))
                return option;
        }
        return null;
    }
}
