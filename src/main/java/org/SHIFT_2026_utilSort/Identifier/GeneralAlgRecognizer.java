package org.SHIFT_2026_utilSort.Identifier;

public class GeneralAlgRecognizer implements Identifier {
    private final int LITTER_E_ENG_CODE = 69;
    private final int LITTER_e_ENG_CODE = 101;

    public StateLine identifyState(String line) {
        StateLine stateLine = StateLine.INT;
        int charIndex = 0;

        // Проверка на пустую строку оптимизирует процесс сортировки и исключает ошибку при проверке на отрицательность числа.
        if (line.length() == 0)
            return StateLine.STRING;

        // Проверка на отрицательность числа.
        if (line.charAt(0) == '-') {
            if (line.length() == 1)
                return StateLine.STRING;

            charIndex++;
        }

        // Если line - число, то line.get(0) должна быть цифрой (или line.get(1), если число отрицательное)
        if (!isDigit(line.charAt(charIndex)))
            return StateLine.STRING;

        boolean exponent = false;
        boolean dot = false;

        for (; charIndex < line.length(); charIndex++) {
            if (isDigit(line.charAt(charIndex)))
                continue;

            if (line.charAt(charIndex) == '.') {
                // В вещественном числе точка не может встречаться после маркера экспоненциальной записи 'Е' - иначе это строка.
                // Если в числе встречается более одной точки, оно считается строкой, а не вещественным числом.
                if (!exponent && !dot) {
                    // Если текущий символ последний - значит это строка.
                    if (charIndex + 1 == line.length()) // Проверка исключает выход за пределы массива при следующей операции.
                        return StateLine.STRING;

                    charIndex++; // Переходим к следующему символу для проверки на число.
                    // В числе после точки должна следовать цифра - иначе это строка.
                    if (isDigit(line.charAt(charIndex))) {
                        dot = true;
                        stateLine = StateLine.FLOAT;
                        continue;
                    }
                }

                return StateLine.STRING;
            }

            // Проверка на экспоненциальную запись по коду ASCII.
            if (line.charAt(charIndex) == LITTER_e_ENG_CODE || line.charAt(charIndex) == LITTER_E_ENG_CODE) {
                // Маркера экспоненциальной записи 'Е' может встречаться лишь один раз в числе - иначе это строка.
                if (!exponent) {
                    exponent = true;

                    // Следующие два символа должны быть +/- и числом, иначе - это строка.
                    if (charIndex + 2 == line.length()) // Проверка исключает выход за пределы массива при следующей операции.
                        return StateLine.STRING;

                    // В экспоненциальной записи числа следующий символ после маркера должен быть '+' или '-'.
                    charIndex++; // Переходим к следующему символу для проверки на '+' или '-'.
                    if (line.charAt(charIndex) == '+' || line.charAt(charIndex) == '-') {
                        charIndex++; // Переходим к следующему символу для проверки на число.
                        if(isDigit(line.charAt(charIndex))) {
                            stateLine = StateLine.FLOAT;
                            continue;
                        }
                    }
                }

                return StateLine.STRING;
            }
            // Если символ не является цифрой, точкой или маркером экспоненциальной записи, значит line - это строка.
            return StateLine.STRING;
        }
        return stateLine;
    }

    private boolean isDigit ( char c) {
        return c >= 48 && c <= 57; // Проверка на цифру по коду ASCII.
    }
}
