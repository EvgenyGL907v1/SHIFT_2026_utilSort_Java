package org.SHIFT_2026_utilSort.Options;

import org.SHIFT_2026_utilSort.ConfigurationUtil;
import org.SHIFT_2026_utilSort.FileValidator;

public class OptionSetPrefixFileName implements Option {
    @Override
    public  boolean checkCondition(String arg) {
        return "-p".equals(arg);
    }

    @Override
    public int execute(String[] input, int index) {
        if (index + 1 >= input.length || FileValidator.isFile(input[index+1])) {
            System.out.println("Предупреждение: После опции \"" + input[index] + "\" должен следовать префикс имени выходных файлов. Опция \"" + input[index] + "\" не будет учтена.");
            return 1;
        }

        if(!input[index+1].matches("^[^/:*?\"<>\\\\|]+$")) {
            System.out.println("Предупреждение: В заданном прификсе названия выходных файлов присутствует недопустимый символ. Опция \"-p\" и префикс имени не будут учтены. Список недопустимых символов: \\/:*?\"><|");
            return 2;
        }

        ConfigurationUtil config = ConfigurationUtil.getInstance();
        config.setPrefixFileName(input[index+1]);
        return 2;
    }
}
