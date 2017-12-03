package junit;
/**
 * Тесты по позитивному сценарию
 */

import com.prog.CalculatorEngine;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PositiveSuiteTest {
    private String valueA;
    private String valueB;
    private String expectedResult;

    public PositiveSuiteTest(String valueA, String valueB, String expectedResult) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<String[]> getTestData() {
        return Arrays.asList(new String[][]{
                //Структура массивов {делимое А, делитель Б, ожидаемый результат частное С}
                {"24.75", "4.5", "5.5"},
                {"24.75", "-4.5", "-5.5"},
                {"24.75", "3", "8.25"},
                {"24.75", "-3", "-8.25"},

                {"-24.75", "4.5", "-5.5"},
                {"-24.75", "-4.5", "5.5"},
                {"-24.75", "3", "-8.25"},
                {"-24.75", "-3", "8.25"},

                {"45", "4.5", "10.0"},
                {"45", "-4.5", "-10.0"},
                {"45", "3", "15.0"},
                {"45", "-3", "-15.0"},

                {"-45", "4.5", "-10.0"},
                {"-45", "-4.5", "10.0"},
                {"-45", "3", "-15.0"},
                {"-45", "-3", "15.0"},

                {"0", "4.5", "0.0"},

                // Благодаря тестам posTest018 и posTest020 БЫЛ найден БАГ!
                // Фактический результат -0.0, ожидаемый 0.0. был добавлен фикс
                {"0", "-4.5", "0.0"},
                {"0", "3", "0.0"},
                {"0", "-3", "0.0"},

                {"1.0e7", "1.0e7", "1.0"},
                {"1.0e7", "-1.0e7", "-1.0"},
                {"1.0e7", "1.0E7", "1.0"},
                {"1.0e7", "-1.0E7", "-1.0"},

                {"-1.0e7", "1.0e7", "-1.0"},
                {"-1.0e7", "-1.0e7", "1.0"},
                {"-1.0e7", "1.0E7", "-1.0"},
                {"-1.0e7", "-1.0E7", "1.0"},

                {"1.0E7", "1.0e7", "1.0"},
                {"1.0E7", "-1.0e7", "-1.0"},
                {"1.0E7", "1.0E7", "1.0"},
                {"1.0E7", "-1.0E7", "-1.0"},

                {"-1.0E7", "1.0e7", "-1.0"},
                {"-1.0E7", "-1.0e7", "1.0"},
                {"-1.0E7", "1.0E7", "-1.0"},
                {"-1.0E7", "-1.0E7", "1.0"}
        });
    }


    @Test
    public void posTest001_036() {
        Assert.assertEquals(expectedResult, CalculatorEngine.division(valueA, valueB).toString());
    }


}
