package com.prog;

import java.awt.Color;
import javax.swing.*;
/**
 * Кдасс графического интервейса
 */
public class Calculator {
    public static void main(String[] args) {
        Calculator  call = new  Calculator ();
    }

    private static final Color red = new Color(255,0,0);
    private static final Color white = new Color(255,255,255);

    private static JLabel labelA = new JLabel("Делимое А:");
    private static JLabel errorA = new JLabel("");
    private static JTextField fieldA = new JTextField(10);

    private static JLabel labelB = new JLabel("Делитель В:");
    private static JLabel errorB = new JLabel("");
    private static JTextField fieldB = new JTextField(10);

    private static JButton button1 = new JButton("=");

    private static JLabel labelC = new JLabel("Частное С:");
    private static JTextField fieldC = new JTextField(10);

    private static JFrame frame = new JFrame("Калькулятор");
    private static JPanel windowContent = new JPanel();

    CalculatorEngine  calcEng = new CalculatorEngine ();

    public  Calculator (){
        windowContent.setLayout(null);

        windowContent.add(labelA);
        labelA.setBounds(25,20,90,40);

        windowContent.add(fieldA);
        fieldA.setBounds(100,20,140,40);

        windowContent.add(errorA);
        errorA.setBounds(250,20,180,40);

        windowContent.add( labelB);
        labelB.setBounds(20,75,90,40);

        windowContent.add(fieldB);
        fieldB.setBounds(100,75,140,40);

        windowContent.add(errorB);
        errorB.setBounds(250,75,180,40);

        windowContent.add( labelC);
        labelC.setBounds(30, 125,90, 40);

        windowContent.add(fieldC);
        fieldC.setBounds(100, 125, 140, 40);

        windowContent.add(button1);
        button1.setBounds(100,175,140,60);
        button1.addActionListener(calcEng);

        frame.setContentPane(windowContent);
        frame.setSize(350,300);
        frame.setVisible(true);
    }

    public static String getValueA(){
        return fieldA.getText();
    }

    public static String getValueB(){
        return fieldB.getText();
    }

    public static void setValueC(String valueC){
        fieldC.setText(valueC);
    }

    public static void makeBackgrounRed(String fieldNameAorB){
        if (fieldNameAorB.equals("A")){
            fieldA.setBackground(red);
        }   else {
            fieldB.setBackground(red);
        }
    }

    public static void makeBackgrounWhite(String fieldNameAorB){
        if (fieldNameAorB.equals("A")){
            fieldA.setBackground(white);
        }   else {
            fieldB.setBackground(white);
        }
    }

    public static void setErrorLabel(String wrongFieldAorB, String error){
        if(wrongFieldAorB.equals("A")){
            errorA.setText(error);
        }   else{
            errorB.setText(error);
        }
    }

    public static void errorSizeFrame() { frame.setSize(490,300); }

    public static void normalSizeFrame(){ frame.setSize(350,300); }

    // Методы ниже написаны специально для тестов
    public static void setValueA(String valueA){
        fieldA.setText(valueA);
    }

    public static void setValueB(String valueB){
        fieldB.setText(valueB);
    }

    public static String getValueC(){
        return fieldC.getText();
    }

    public static void clickButton(){
        button1.doClick();
    }

    public static Color getColorFieldA(){ return fieldA.getBackground(); }

    public static Color getColorFieldB(){ return fieldB.getBackground(); }

    public static String getTextErrorA() {return errorA.getText();}

    public static String getTextErrorB() {return errorB.getText();}

}