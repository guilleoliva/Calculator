package com.prog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static com.prog.CalculatorEngine.division;

/**
 * Класс графического интерфейса.
 */
public class Calculator {
    public static void main(String[] args) {
        Calculator call = new Calculator();
    }

    private static final Color red = new Color(255, 0, 0);
    private static final Color white = new Color(255, 255, 255);

    private JLabel labelA = new JLabel("Делимое А:");
    private static JLabel errorA = new JLabel("");
    private static JTextField fieldA = new JTextField(10);

    private JLabel labelB = new JLabel("Делитель В:");
    private static JLabel errorB = new JLabel("");
    private static JTextField fieldB = new JTextField(10);

    private JButton button1 = new JButton("=");

    private JLabel labelC = new JLabel("Частное С:");
    private static JTextField fieldC = new JTextField(10);

    private static JFrame frame = new JFrame("Калькулятор");
    private JPanel windowContent = new JPanel();

    Listener listener = new Listener();

    public Calculator() {
        windowContent.setLayout(null);

        windowContent.add(labelA);
        labelA.setBounds(25, 20, 90, 40);

        windowContent.add(fieldA);
        fieldA.setBounds(100, 20, 140, 40);

        windowContent.add(errorA);
        errorA.setBounds(250, 20, 180, 40);

        windowContent.add(labelB);
        labelB.setBounds(20, 75, 90, 40);

        windowContent.add(fieldB);
        fieldB.setBounds(100, 75, 140, 40);

        windowContent.add(errorB);
        errorB.setBounds(250, 75, 180, 40);

        windowContent.add(labelC);
        labelC.setBounds(30, 125, 90, 40);

        windowContent.add(fieldC);
        fieldC.setBounds(100, 125, 140, 40);

        windowContent.add(button1);
        button1.setBounds(100, 175, 140, 60);
        button1.addActionListener(listener);

        frame.setContentPane(windowContent);
        frame.setSize(350, 300);
        frame.setVisible(true);
    }

    public static String getValueA() {
        return fieldA.getText();
    }

    public static String getValueB() {
        return fieldB.getText();
    }

    public static void setValueC(String valueC) {
        fieldC.setText(valueC);
    }

    public static void makeBackgrounRed(String fieldNameAorB) {
        if (fieldNameAorB.equals("A")) {
            fieldA.setBackground(red);
        } else {
            fieldB.setBackground(red);
        }
    }

    public static void makeBackgrounWhite(String fieldNameAorB) {
        if (fieldNameAorB.equals("A")) {
            fieldA.setBackground(white);
        } else {
            fieldB.setBackground(white);
        }
    }

    public static void setErrorLabel(String wrongFieldAorB, String error) {
        if (wrongFieldAorB.equals("A")) {
            errorA.setText(error);
        } else {
            errorB.setText(error);
        }
    }

    public static void errorSizeFrame() {
        frame.setSize(490, 300);
    }

    public static void normalSizeFrame() {
        frame.setSize(350, 300);
    }

}

/**
 * Класс - реакция на нажатие кнопки.
 */
class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // Возвращаем элементы калькулятора в состояние "Без ошибки"
        Calculator.normalSizeFrame();
        Calculator.setErrorLabel("A", "");
        Calculator.setErrorLabel("B", "");
        Calculator.makeBackgrounWhite("A");
        Calculator.makeBackgrounWhite("B");

        try {
            Calculator.setValueC(CalculatorEngine.division(Calculator.getValueA(), Calculator.getValueB()).toString());
        } catch (NumberFormatException ex) {
            if (Calculator.getValueA().contains(",")) {
                Calculator.setValueC("");
                Calculator.errorSizeFrame();
                Calculator.makeBackgrounRed("A");
                Calculator.setErrorLabel("A", "Дробь следует разделять \".\"");
            } else if (Calculator.getValueB().contains(",")) {
                Calculator.setValueC("");
                Calculator.errorSizeFrame();
                Calculator.makeBackgrounRed("B");
                Calculator.setErrorLabel("B", "Дробь следует разделять \".\"");
            } else {
                try {
                    Double valueA = Double.parseDouble(Calculator.getValueA());
                } catch (NumberFormatException exc) {
                    Calculator.setValueC("");
                    Calculator.errorSizeFrame();
                    Calculator.makeBackgrounRed("A");
                    Calculator.setErrorLabel("A", "Следует вводить цифры!");
                }
                try {
                    Double valueB = Double.parseDouble(Calculator.getValueB());
                } catch (NumberFormatException exc) {
                    Calculator.setValueC("");
                    Calculator.errorSizeFrame();
                    Calculator.makeBackgrounRed("B");
                    Calculator.setErrorLabel("B", "Следует вводить цифры!");
                }
            }

        } catch (ArithmeticException ex) {
            Calculator.setValueC("");
            Calculator.errorSizeFrame();
            Calculator.makeBackgrounRed("B");
            Calculator.setErrorLabel("B", "Деление на ноль невозможно!");
        }
    }

}