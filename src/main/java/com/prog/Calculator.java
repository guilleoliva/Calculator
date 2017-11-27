package com.prog;

import java.awt.Color;
import javax.swing.*;
/**
 * @author Pustovit V.V.
 */
public class Calculator {
    public static void main(String[] args) {
        Calculator  call = new  Calculator ();
    }

    private final Color red=new Color(255,0,0);
    private final Color white=new Color(255,255,255);

    private JLabel labelA = new JLabel("Делимое А:");
    private JLabel errorA = new JLabel("");
    private JTextField fieldA = new JTextField(10);
    private JLabel labelB = new JLabel("Делитель В:");
    private JLabel errorB = new JLabel("");
    private JTextField fieldB = new JTextField(10);
    private JButton button1 = new JButton("=");
    private JLabel labelC = new JLabel("Частное С:");
    private JTextField fieldC = new JTextField(10);

    private JPanel windowContent = new JPanel();

    CalculatorEngine  calcEng  = new CalculatorEngine ( this );

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
        fieldC.setBounds(100, 125, 250, 40);

        windowContent.add(button1);
        button1.setBounds(100,175,250,60);
        button1.addActionListener(calcEng);

        JFrame frame = new JFrame("Калькулятор");
        frame.setContentPane(windowContent);
        frame.setSize(465,300);
        frame.setVisible(true);
    }

    public String getValueA(){
        return fieldA.getText();
    }

    public String getValueB(){
        return fieldB.getText();
    }

    public void setValueC(String valueC){
        fieldC.setText(valueC);
    }

    public void makeBackgrounRed(String fieldNameAorB){
        if (fieldNameAorB.equals("A")){
            fieldA.setBackground(red);
        }   else {
            fieldB.setBackground(red);
        }
    }

    public void makeBackgrounWhite(String fieldNameAorB){
        if (fieldNameAorB.equals("A")){
            fieldA.setBackground(white);
        }   else {
            fieldB.setBackground(white);
        }
    }

    public void setErrorLabel(String wrongFieldAorB, String error){
        if(wrongFieldAorB.equals("A")){
            errorA.setText(error);
        }   else{
            errorB.setText(error);
        }
    }
    // Методы ниже написаны специально для тестов
    public void setValueA(String valueA){
        fieldA.setText(valueA);
    }

    public void setValueB(String valueB){
        fieldB.setText(valueB);
    }

    public String getValueC(){
        return fieldC.getText();
    }

    public void clickButton(){
        button1.doClick();
    }

    public Color getColorFieldA(){ return fieldA.getBackground(); }

    public Color getColorFieldB(){ return fieldB.getBackground(); }

    public String getTextErrorA() {return errorA.getText();}

    public String getTextErrorB() {return errorB.getText();}

}