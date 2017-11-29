package junit;
/**
 * Тесты по позитивному сценарию
 */
import com.prog.CalculatorEngine;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class PositiveSuiteTest {

    //Структура массивов {делимое А, делитель Б, ожидаемый результат частное С}
    private String forTest1 [] = {"24.75", "4.5", "5.5"};
    private String forTest2 [] = {"24.75", "-4.5", "-5.5"};
    private String forTest3 [] = {"24.75", "3", "8.25"};
    private String forTest4 [] = {"24.75", "-3", "-8.25"};

    private String forTest5 [] = {"-24.75", "4.5", "-5.5"};
    private String forTest6 [] = {"-24.75", "-4.5", "5.5"};
    private String forTest7 [] = {"-24.75", "3", "-8.25"};
    private String forTest8 [] = {"-24.75", "-3", "8.25"};

    private String forTest9 [] = {"45", "4.5", "10.0"};
    private String forTest10 [] = {"45", "-4.5", "-10.0"};
    private String forTest11 [] = {"45", "3", "15.0"};
    private String forTest12 [] = {"45", "-3", "-15.0"};

    private String forTest13 [] = {"-45", "4.5", "-10.0"};
    private String forTest14 [] = {"-45", "-4.5", "10.0"};
    private String forTest15 [] = {"-45", "3", "-15.0"};
    private String forTest16 [] = {"-45", "-3", "15.0"};

    private String forTest17 [] = {"0", "4.5", "0.0"};

    // Благодаря тестам posTest018 и posTest020 БЫЛ найден БАГ!
    // Фактический результат -0.0, ожидаемый 0.0. был добавлен фикс
    private String forTest18 [] = {"0", "-4.5", "0.0"};
    private String forTest19 [] = {"0", "3", "0.0"};
    private String forTest20 [] = {"0", "-3", "0.0"};

    private String forTest21 [] = {"1.0e7", "1.0e7", "1.0"};
    private String forTest22 [] = {"1.0e7", "-1.0e7", "-1.0"};
    private String forTest23 [] = {"1.0e7", "1.0E7", "1.0"};
    private String forTest24 [] = {"1.0e7", "-1.0E7", "-1.0"};

    private String forTest25 [] = {"-1.0e7", "1.0e7", "-1.0"};
    private String forTest26 [] = {"-1.0e7", "-1.0e7", "1.0"};
    private String forTest27 [] = {"-1.0e7", "1.0E7", "-1.0"};
    private String forTest28 [] = {"-1.0e7", "-1.0E7", "1.0"};

    private String forTest29 [] = {"1.0E7", "1.0e7", "1.0"};
    private String forTest30 [] = {"1.0E7", "-1.0e7", "-1.0"};
    private String forTest31 [] = {"1.0E7", "1.0E7", "1.0"};
    private String forTest32 [] = {"1.0E7", "-1.0E7", "-1.0"};

    private String forTest33 [] = {"-1.0E7", "1.0e7", "-1.0"};
    private String forTest34 [] = {"-1.0E7", "-1.0e7", "1.0"};
    private String forTest35 [] = {"-1.0E7", "1.0E7", "-1.0"};
    private String forTest36 [] = {"-1.0E7", "-1.0E7", "1.0"};

    public void methodForTest(String [] array){
     Assert.assertEquals(array[2],CalculatorEngine.division(array[0],array[1]));
    }

    @Test
    public  void posTest001(){ methodForTest(forTest1); }
    @Test
    public  void posTest002(){ methodForTest(forTest2); }
    @Test
    public  void posTest003(){ methodForTest(forTest3); }
    @Test
    public  void posTest004(){ methodForTest(forTest4); }
    @Test
    public  void posTest005(){ methodForTest(forTest5); }
    @Test
    public  void posTest006(){ methodForTest(forTest6); }
    @Test
    public  void posTest007(){ methodForTest(forTest7); }
    @Test
    public  void posTest008(){ methodForTest(forTest8); }
    @Test
    public  void posTest009(){ methodForTest(forTest9); }
    @Test
    public  void posTest010(){ methodForTest(forTest10); }
    @Test
    public  void posTest011(){ methodForTest(forTest11); }
    @Test
    public  void posTest012(){ methodForTest(forTest12); }
    @Test
    public  void posTest013(){ methodForTest(forTest13); }
    @Test
    public  void posTest014(){ methodForTest(forTest14); }
    @Test
    public  void posTest015(){ methodForTest(forTest15); }
    @Test
    public  void posTest016(){ methodForTest(forTest16); }
    @Test
    public  void posTest017(){ methodForTest(forTest17); }
    @Test
    public  void posTest018(){ methodForTest(forTest18); }
    @Test
    public  void posTest019(){ methodForTest(forTest19); }
    @Test
    public  void posTest020(){ methodForTest(forTest20); }
    @Test
    public  void posTest021(){ methodForTest(forTest21); }
    @Test
    public  void posTest022(){ methodForTest(forTest22); }
    @Test
    public  void posTest023(){ methodForTest(forTest23); }
    @Test
    public  void posTest024(){ methodForTest(forTest24); }
    @Test
    public  void posTest025(){ methodForTest(forTest25); }
    @Test
    public  void posTest026(){ methodForTest(forTest26); }
    @Test
    public  void posTest027(){ methodForTest(forTest27); }
    @Test
    public  void posTest028(){ methodForTest(forTest28); }
    @Test
    public  void posTest029(){ methodForTest(forTest29); }
    @Test
    public  void posTest030(){ methodForTest(forTest30); }
    @Test
    public  void posTest031(){ methodForTest(forTest31); }
    @Test
    public  void posTest032(){ methodForTest(forTest32); }
    @Test
    public  void posTest033(){ methodForTest(forTest33); }
    @Test
    public  void posTest034(){ methodForTest(forTest34); }
    @Test
    public  void posTest035(){ methodForTest(forTest35); }
    @Test
    public  void posTest036(){ methodForTest(forTest36); }

    @After
    public void clear(){
        forTest1 = null;
        forTest2 = null;
        forTest3 = null;
        forTest4 = null;
        forTest5 = null;
        forTest6 = null;
        forTest7 = null;
        forTest8 = null;
        forTest9 = null;
        forTest10 = null;
        forTest11 = null;
        forTest12 = null;
        forTest13 = null;
        forTest14 = null;
        forTest15 = null;
        forTest16 = null;
        forTest17 = null;
        forTest18 = null;
        forTest19 = null;
        forTest20 = null;
        forTest21 = null;
        forTest22 = null;
        forTest23 = null;
        forTest24 = null;
        forTest25 = null;
        forTest26 = null;
        forTest27 = null;
        forTest28 = null;
        forTest29 = null;
        forTest30 = null;
        forTest31 = null;
        forTest32 = null;
        forTest33 = null;
        forTest34 = null;
        forTest35 = null;
        forTest36 = null;
    }
}
