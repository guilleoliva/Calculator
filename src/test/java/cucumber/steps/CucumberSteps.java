package cucumber.steps;
/**
 * Класс шагов для теста
 */

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import com.prog.Calculator;
import com.prog.CalculatorEngine;

public class CucumberSteps {

    @Given("^Ввод данных в поле '(.+)' , ввод данных в поле '(.+)' , cравнение с ожидаемым результатом '(.+)'$")
    public void result(String valueA, String valueB, Double expectedResult) {
        Assert.assertEquals(expectedResult, CalculatorEngine.division(valueA, valueB));
    }
}
