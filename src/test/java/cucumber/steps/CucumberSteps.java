package cucumber.steps;
/**
 * Класс шагов для теста
 */
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import com.prog.Calculator;
import com.prog.CalculatorEngine;

public class CucumberSteps {

    @Given("^Вводит корректные данные в поле «Делимое А:» '(.+)'$")
    public void inputA(String inputA) {
                Calculator.setValueA(inputA);
    }

    @And("^Вводит корректные данные в поле «Делитель В:» '(.+)'$")
    public void inputB(String inputB) {
        Calculator.setValueB(inputB);
    }

    @And("^Нажимает на кнопку «=» и видит результат деления '(.+)'$")
    public void result(String expectedResult) {
        Assert.assertEquals(expectedResult, CalculatorEngine.division(Calculator.getValueA(), Calculator.getValueB()));
    }
}
