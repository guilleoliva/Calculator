package junit;

import com.prog.CalculatorEngine;
import org.junit.Test;

/**
 * Тест "деление на 0"
 */

public class Neg007Test {

    @Test(expected = ArithmeticException.class)
    public void negTest007() {
        CalculatorEngine.division("1", "0");
    }
}
