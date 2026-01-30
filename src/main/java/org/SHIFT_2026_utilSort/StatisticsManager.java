package org.SHIFT_2026_utilSort;

import org.SHIFT_2026_utilSort.Identifier.StateLine;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class StatisticsManager {
    MathContext precision = new MathContext(10, RoundingMode.HALF_UP);

    // Краткая статистика
    private BigInteger countElementsInt = BigInteger.ZERO;
    private BigInteger countElementsFloat = BigInteger.ZERO;
    private BigInteger countElementsString = BigInteger.ZERO;

    // Полная статистика
    private BigInteger maxElementInt, minElementInt;
    private BigDecimal maxElementFloat, minElementFloat;
    private BigInteger sumElementsInt = BigInteger.ZERO;
    private BigDecimal sumElementsFloat = BigDecimal.ZERO;
    private BigDecimal averageElementsInt = BigDecimal.ZERO;
    private BigDecimal averageElementsFloat = BigDecimal.ZERO;
    private BigInteger maxLengthElementsString = BigInteger.ZERO;
    private BigInteger minLengthElementsString;

    public void addElement(String element, StateLine state) {
        switch (state) {
            case StateLine.INT -> addIntElement(element);
            case StateLine.FLOAT -> addFloatElement(element);
            case StateLine.STRING ->addStringElement(element);
        }
    }

    private void addIntElement(String element) {
        countElementsInt = countElementsInt.add(BigInteger.ONE);

        if (ConfigurationUtil.getInstance().getStatisticEnableFull()) {
            if (maxElementInt == null)
                maxElementInt = new BigInteger(element);

            if (minElementInt == null)
                minElementInt = new BigInteger(element);

            if (new BigInteger(element).compareTo(maxElementInt) > 0)
                maxElementInt = new BigInteger(element);

            if (new BigInteger(element).compareTo(minElementInt) < 0)
                minElementInt = new BigInteger(element);

            sumElementsInt = sumElementsInt.add(new BigInteger(element));
            averageElementsInt = new BigDecimal(sumElementsInt.divide(countElementsInt), precision);
        }
    }

    private void addFloatElement(String element) {
        countElementsFloat = countElementsFloat.add(BigInteger.ONE);

        if (ConfigurationUtil.getInstance().getStatisticEnableFull()) {
            if (maxElementFloat == null)
                maxElementFloat = new BigDecimal(element);

            if (minElementFloat == null)
                minElementFloat = new BigDecimal(element);

            if (new BigDecimal(element).compareTo(maxElementFloat) > 0)
                maxElementFloat = new BigDecimal(element);

            if (new BigDecimal(element).compareTo(minElementFloat) < 0)
                minElementFloat = new BigDecimal(element);

            sumElementsFloat = sumElementsFloat.add(new BigDecimal(element));
            averageElementsFloat = new BigDecimal(String.valueOf(sumElementsFloat.divide(new BigDecimal(countElementsFloat), precision)));
        }
    }

    private void addStringElement(String element) {
        countElementsString = countElementsString.add(BigInteger.ONE);

        if (ConfigurationUtil.getInstance().getStatisticEnableFull()) {
            String elementLength = String.valueOf(element.length());

            if (new BigInteger(elementLength).compareTo(maxLengthElementsString) > 0)
                maxLengthElementsString = new BigInteger(elementLength);

            if (minLengthElementsString == null)
                minLengthElementsString = new BigInteger(elementLength);
            else if (new BigInteger(elementLength).compareTo(minLengthElementsString) < 0)
                minLengthElementsString = new BigInteger(elementLength);
        }
    }


    public void printStatistics() {
        if (ConfigurationUtil.getInstance().getStatisticEnableShort()) {
            System.out.println("\nКраткая статистика:");
            if (countElementsInt.compareTo(BigInteger.ZERO) > 0)
                System.out.println("Количество записанных элементов типа INT (" + ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_INT + "): " + countElementsInt);
            if (countElementsFloat.compareTo(BigInteger.ZERO) > 0)
                System.out.println("Количество записанных элементов типа FLOAT (" + ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_FLOAT + "): " + countElementsFloat);
            if (countElementsString.compareTo(BigInteger.ZERO) > 0)
                System.out.println("Количество записанных элементов типа STRING (" + ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_STRING + "): " + countElementsString);

        }

        if (ConfigurationUtil.getInstance().getStatisticEnableFull()) {
            System.out.println("\nПолная статистика:");
            if (countElementsInt.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("\tТип INT " + "(" + ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_INT + ")");
                System.out.println("Количество записанных элементов: " + countElementsInt);
                System.out.println("Минимальное значение: " + minElementInt);
                System.out.println("Максимальное значение: " + maxElementInt);
                System.out.println("Сумма: " + sumElementsInt);
                System.out.println("Среднее: " + averageElementsInt);
                System.out.println();
            }

            if (countElementsFloat.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("\tТип FLOAT " + "(" + ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_FLOAT + ")");
                System.out.println("Количество записанных элементов: " + countElementsFloat);
                System.out.println("Минимальное значение: " + minElementFloat);
                System.out.println("Максимальное значение: " + maxElementFloat);
                System.out.println("Сумма: " + sumElementsFloat);
                System.out.println("Среднее: " + averageElementsFloat);
                System.out.println();
            }

            if (countElementsString.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("\tТип STRING " + "(" + ConfigurationUtil.getInstance().getPrefixFileName() + ConfigurationUtil.FILE_NAME_STRING + ")");
                System.out.println("Количество записанных элементов: " + countElementsString);
                System.out.println("Размер самой короткой строки: " + minLengthElementsString);
                System.out.println("Размер самой длинной строки: " + maxLengthElementsString);
                System.out.println();
            }
        }
    }
}

