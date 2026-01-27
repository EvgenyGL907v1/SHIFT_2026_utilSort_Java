package org.SHIFT_2026_utilSort.Options;

import org.SHIFT_2026_utilSort.ConfigurationUtil;
import org.SHIFT_2026_utilSort.FileWriteStatus;

public class OptionSetFileWriteStatus implements Option {
    @Override
    public  boolean checkCondition(String arg) {
        return "-a".equals(arg);
    }

    @Override
    public int execute(String[] input, int index) {
        ConfigurationUtil config = ConfigurationUtil.getInstance();
        config.setFileWriteStatus(FileWriteStatus.APPEND);
        return 1;
    }
}
