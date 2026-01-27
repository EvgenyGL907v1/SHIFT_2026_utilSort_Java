package org.SHIFT_2026_utilSort.Options;

public interface Option {
    boolean checkCondition(String arg);
    int execute(String[] input, int index);
}