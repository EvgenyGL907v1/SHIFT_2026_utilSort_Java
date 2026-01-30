package org.SHIFT_2026_utilSort.Options;

import org.SHIFT_2026_utilSort.ConfigurationUtil;

public class OptionSetStatisticEnableShort implements Option {
    @Override
    public  boolean checkCondition(String arg) {
        return "-s".equals(arg);
    }

    @Override
    public int execute(String[] input, int index) {
        ConfigurationUtil config = ConfigurationUtil.getInstance();
        config.setStatisticEnableShort();
        return 1;
    }
}
