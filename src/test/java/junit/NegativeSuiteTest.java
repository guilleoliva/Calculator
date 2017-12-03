package junit;

import com.prog.CalculatorEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

/**
 * Тесты по негативному сценарию
 */
@RunWith(Parameterized.class)
public class NegativeSuiteTest {
    private String valueA;
    private String valueB;

    public NegativeSuiteTest(String valueA, String valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    @Parameterized.Parameters
    public static Collection<String[]> getTestData() {
        return Arrays.asList(new String[][]{
                {"2,5", "1"},
                {"1", "2,5"},
                {"bukva", "1"},
                {"1", "bukva"},
                {"", "1"},
                {"1", ""},
        });
    }

    @Test(expected = NumberFormatException.class)
    public void negTest001_006() {
        CalculatorEngine.division(valueA, valueB);
    }

}
