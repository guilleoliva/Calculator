package junit;

import com.prog.CalculatorEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Тесты "деление на 0"
 */
@RunWith(Parameterized.class)
public class NegativeSuite2Test {
    private String valueA;
    private String valueB;

    public NegativeSuite2Test(String valueA, String valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    @Parameterized.Parameters
    public static Collection<String[]> getTestData() {
        return Arrays.asList(new String[][]{
                {"1", "0"},
                {"1", "0.0"},
                {"1.0", "0"},
                {"1.0", "0.0"},
        });
    }


    @Test(expected = ArithmeticException.class)
    public void negTest007_010() {
        CalculatorEngine.division(valueA, valueB);
    }

}
