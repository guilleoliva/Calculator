package com.prog;

/**
 * Класс "движок" калькулятора.
 */
public class CalculatorEngine {
    /**
     * Метод деления.
     * Так же метод отлавливает исключение.
     *
     * @param valueA - данные введенные в поле "Делимое А:".
     * @param valueB - данные введенные в поле "Делитель В:".
     * @return возвращает результат деления делимого на делитель, или
     * пробрасывает исключение для дальнейшей обработки
     */
    public static Object division(String valueA, String valueB) {
        try {
            Double a = Double.parseDouble(valueA);
            Double b = Double.parseDouble(valueB);
        } catch (NumberFormatException e) {
            throw e;
        }
        Double a = Double.parseDouble(valueA);
        Double b = Double.parseDouble(valueB);

        //Отлавливаем исключение ArithmeticException(в нашем случае деление на 0)
        if (b == 0.0) {
            ArithmeticException e = new ArithmeticException();
            throw e;
        }
        // фикс после найденого бага благодаря тестам posTest018, posTest020.
        if (a == 0) {
            return 0.0;
        }

        Double result = a / b;
        return result;
    }

}
