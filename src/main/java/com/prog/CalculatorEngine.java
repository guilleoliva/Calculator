package com.prog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Pustovit V.V.
 */
public class CalculatorEngine implements ActionListener {

     Calculator  parent;

    public CalculatorEngine ( Calculator  parent) {
        this.parent=parent;
    }

    public void actionPerformed(ActionEvent e) {
        parent.setValueC(division().toString());
    }

    public  Object division() {
        parent.setErrorLabel("A","");
        parent.setErrorLabel("B","");
        parent.makeBackgrounWhite("A");
        parent.makeBackgrounWhite("B");

        if(parent.getValueA().contains(",") | parent.getValueB().contains(","))
        {
            if(parent.getValueA().contains(",")) {
                parent.makeBackgrounRed("A");
                parent.setErrorLabel("A","Дробь следует разделять \".\"");
            }
            else {parent.makeBackgrounRed("B");
                parent.setErrorLabel("B","Дробь следует разделять \".\"");
            }
            try {
                double a=Double.parseDouble(parent.getValueA());
                double b=Double.parseDouble(parent.getValueB());
            }  catch(NumberFormatException e) {
                return "";
            }
        }


        try {
            double a=Double.parseDouble(parent.getValueA());
        }	catch(NumberFormatException e) {
            parent.makeBackgrounRed("A");
            parent.setErrorLabel("A","Следует вводить цифры!");
            return "";
        }

        try {
            double b=Double.parseDouble(parent.getValueB());
        }	catch(NumberFormatException e) {
            parent.makeBackgrounRed("B");
            parent.setErrorLabel("B","Следует вводить цифры!");
            return "";
        }

        double a=Double.parseDouble(parent.getValueA());
        double b=Double.parseDouble(parent.getValueB());

        if(b==0.0)
        {
            int AtoInt = (int)a;
            int BtoInt=(int)b;
            try {
                int res =AtoInt/BtoInt;
            }	catch(ArithmeticException e) {
                parent.makeBackgrounRed("B");
                parent.setErrorLabel("B","Деление на ноль невозможно!");
                return "";
            }

        }
        if(a==0){return 0.0;} // фикс после найденого бага благодаря тестам posTest018, posTest020.
        return a/b;
    }



}
