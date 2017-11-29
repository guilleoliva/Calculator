package com.prog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Класс "движок" калькулятора.
 * Реагирует на клик по кнопке "=" класса Calculator, и вызывает метод деления
 */
public class CalculatorEngine implements ActionListener {

    /**
     * Метод выполнения действия.
     * @param e - активное действие(нажатие на кнопку в классе Calculator)
     * Метод вызывает метод деления.
     * @see String division(String, String) и
     * передает результат деления в поле "Частное С:"
     */
    public void actionPerformed(ActionEvent e) {
        Calculator.setValueC(division(Calculator.getValueA(),Calculator.getValueB()));
    }
    /**
     * Метод деления.
     * Так же метод отлавливает неверный ввод данных
     *  и выводит сообщение об ошибке рядом с полем.
     * @param valueA - данные введенные в поле "Делимое А:".
     * @param valueB - данные введенные в поле "Делитель В:".
     * @return возвращает результат деления делимого на делитель.
     */
    public static String division(String valueA, String valueB) {

    // Возвращаем элементы калькулятора в состояние "Без ошибки"
        Calculator.normalSizeFrame();
        Calculator.setErrorLabel("A","");
        Calculator.setErrorLabel("B","");
        Calculator.makeBackgrounWhite("A");
        Calculator.makeBackgrounWhite("B");

    // Проверяем, содержат ли поля "Делимое А:" и "Делитель В:"  ","
        if(valueA.contains(",") | valueB.contains(","))
        {
            if(valueA.contains(",")) {
                Calculator.errorSizeFrame();
                Calculator.makeBackgrounRed("A");
                Calculator.setErrorLabel("A","Дробь следует разделять \".\"");
            }
            else {
                Calculator.errorSizeFrame();
                Calculator.makeBackgrounRed("B");
                Calculator.setErrorLabel("B","Дробь следует разделять \".\"");
            }
    // Перехватыаем исключение, возвращаем пустую строку
            try {
                double a = Double.parseDouble(valueA);
                double b = Double.parseDouble(valueB);
                } catch(NumberFormatException e) {
                return "";
            }
        }
    // Проверяем, содержит ли поле "Делимое А:"  букву вместо цифры, или пустой ввод
        try {
            double a = Double.parseDouble(valueA);
            } catch(NumberFormatException e) {
            Calculator.errorSizeFrame();
            Calculator.makeBackgrounRed("A");
            Calculator.setErrorLabel("A","Следует вводить цифры!");
            return "";
        }
    // Проверяем, содержит ли поле "Делитель В:"  букву вместо цифры, или пустой ввод
        try {
            double b = Double.parseDouble(valueB);
            } catch(NumberFormatException e) {
            Calculator.errorSizeFrame();
            Calculator.makeBackgrounRed("B");
            Calculator.setErrorLabel("B","Следует вводить цифры!");
            return "";
        }
    //Парсируем строки в Double
        Double a = Double.parseDouble(valueA);
        Double b = Double.parseDouble(valueB);

    //Отлавливаем исключение ArithmeticException(в нашем случае деление на 0)
        if(b == 0.0) {
            Integer valueAToInt = Integer.parseInt(valueA);
            Integer valueBToInt = Integer.parseInt(valueB);
          try {
              int res = valueAToInt/valueBToInt;
              } catch(ArithmeticException e) {
                Calculator.errorSizeFrame();
                Calculator.makeBackgrounRed("B");
                Calculator.setErrorLabel("B","Деление на ноль невозможно!");
                return "";
                }
        }
    // фикс после найденого бага благодаря тестам posTest018, posTest020.
        if(a == 0){return "0.0";}
        Double result = a/b;
        return result.toString();
    }

}
