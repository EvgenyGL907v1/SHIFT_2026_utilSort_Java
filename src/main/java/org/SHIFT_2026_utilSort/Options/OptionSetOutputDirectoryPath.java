package org.SHIFT_2026_utilSort.Options;

import org.SHIFT_2026_utilSort.ConfigurationUtil;
import org.SHIFT_2026_utilSort.FileValidator;

public class OptionSetOutputDirectoryPath implements Option {
    @Override
    public boolean checkCondition(String arg) {
        return "-o".equals(arg);
    }

    @Override
    public int execute(String[] input, int index) {
        if (index + 1 >= input.length) {
            System.out.println("Предупреждение: После опции \"" + input[index] + "\" должен следовать путь для результатов. Опция \"" + input[index] + "\" не будет учтена.");
            return 1;
        }

        if (!FileValidator.isDirectory(input[index + 1])) {
            System.out.println("Предупреждение: Указанный путь выходных файлов \"" + input[index + 1] + "\" не является существующей директорией. Выходные файлы будут перенаправлены в рабочую директорию.");
            return 1;
        }

        ConfigurationUtil config = ConfigurationUtil.getInstance();
        config.setOutputDirectoryPath(input[index + 1]);
        return 2;
    }
}
