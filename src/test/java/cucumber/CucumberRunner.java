package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
/**
 * @author Pustovit V.V.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue = "cucumber.steps"
)

public class CucumberRunner {}
