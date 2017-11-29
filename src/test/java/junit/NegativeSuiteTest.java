package junit;

import com.prog.Calculator;
import com.prog.CalculatorEngine;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import java.awt.Color;
/**
 * Тесты по негативному сценарию
 */
public class NegativeSuiteTest {

    private Color red=new Color(255,0,0);
    private Color white=new Color(255,255,255);

    //Структура массивов {делимое А, делитель Б, ожидаемое сообщение о ошибке}+ проверка цвета поля
    private String forTest1 [] = {"2,5", "1", "Дробь следует разделять \".\""};
    private String forTest2 [] = {"1", "2,5", "Дробь следует разделять \".\""};
    private String forTest3 [] = {"bukva", "1", "Следует вводить цифры!"};
    private String forTest4 [] = {"1", "bukva", "Следует вводить цифры!"};
    private String forTest5 [] = {"", "1", "Следует вводить цифры!"};
    private String forTest6 [] = {"1", "", "Следует вводить цифры!"};
    private String forTest7 [] = {"1", "0", "Деление на ноль невозможно!"};




    public void methodForTestA(String [] array){
        CalculatorEngine.division(array[0],array[1]);
        Assert.assertEquals(array[2], Calculator.getTextErrorA());
        Assert.assertEquals(red, Calculator.getColorFieldA());
    }

    public void methodForTestB(String [] array){
        CalculatorEngine.division(array[0],array[1]);
        Assert.assertEquals(array[2], Calculator.getTextErrorB());
        Assert.assertEquals(red, Calculator.getColorFieldB());
    }

    public void methodAfterCorrectionA(String [] array){
        CalculatorEngine.division(array[0],array[1]);
        CalculatorEngine.division("1","1");
        Assert.assertEquals("",Calculator.getTextErrorA());
        Assert.assertEquals(white,Calculator.getColorFieldB());
    }

    public void methodAfterCorrectionB(String [] array){
        CalculatorEngine.division(array[0],array[1]);
        CalculatorEngine.division("1","1");
        Assert.assertEquals("",Calculator.getTextErrorB());
        Assert.assertEquals(white, Calculator.getColorFieldB());
    }


    @Test
    public void negTest001(){ methodForTestA(forTest1); }

    @Test
    public void negTest002(){ methodForTestB(forTest2); }

    @Test
    public void negTest003(){ methodForTestA(forTest3); }

    @Test
    public void negTest004(){ methodForTestB(forTest4); }

    @Test
    public void negTest005(){ methodForTestA(forTest5); }

    @Test
    public void negTest006(){ methodForTestB(forTest6); }

    @Test
    public void negTest007(){ methodForTestB(forTest7); }

    @Test
    public void negTest008(){ methodAfterCorrectionA(forTest1); }

    @Test
    public void negTest009(){ methodAfterCorrectionB(forTest2); }

    @Test
    public void negTest010(){ methodAfterCorrectionA(forTest3); }

    @Test
    public void negTest011(){ methodAfterCorrectionB(forTest4); }

    @Test
    public void negTest012(){ methodAfterCorrectionA(forTest5); }

    @Test
    public void negTest013(){ methodAfterCorrectionB(forTest6); }

    @Test
    public void negTest014(){ methodAfterCorrectionB(forTest7); }

    @After
    public void clear() {
        red = null;
        white = null;
        forTest1 = null;
        forTest2 = null;
        forTest3 = null;
        forTest4 = null;
        forTest5 = null;
        forTest6 = null;
        forTest7 = null;
    }
}
