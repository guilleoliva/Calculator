package cucumber;
/**
 * Класс запуска cucumber тестов
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue = "cucumber.steps"
)

public class CucumberRunner {}
