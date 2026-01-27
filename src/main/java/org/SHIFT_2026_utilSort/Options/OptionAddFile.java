package org.SHIFT_2026_utilSort.Options;

import org.SHIFT_2026_utilSort.ConfigurationUtil;
import org.SHIFT_2026_utilSort.FileValidator;

public class OptionAddFile implements Option {
    @Override
    public  boolean checkCondition(String arg) {
        return FileValidator.isFile(arg);
    }

    @Override
    public int execute(String[] input, int index) {
        ConfigurationUtil config = ConfigurationUtil.getInstance();
        config.addFileName(input[index]);
        return 1;
    }
}
