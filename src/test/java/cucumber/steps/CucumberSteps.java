package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import com.prog.Calculator;
/**
 * @author Pustovit V.V.
 */
public class CucumberSteps {
    private Calculator calc;

    @Given("^Пользователь запускает калькулятор$")
            public void startCalculator(){
            calc = new Calculator(); }


    @Then("^Вводит корректные данные в поле «Делимое А:» '(.+)'$")
    public void inputA(String inputA) {
                calc.setValueA(inputA);
    }

    @And("^Вводит корректные данные в поле «Делитель В:» '(.+)'$")
    public void inputB(String inputB) {
        calc.setValueB(inputB);
    }


    @And("^Нажимает на кнопку «=»$")
    public void Btn(){
                calc.clickButton();
    }


    @Then("^Он видит результат деления '(.+)'$")
    public void result(String expectedResult) {
        System.out.print(calc.getValueC());
        Assert.assertEquals(expectedResult,calc.getValueC());
    }
}
