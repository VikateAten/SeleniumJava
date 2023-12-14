package proyecto.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "proyecto.steps",
        tags =  "@Hiraoka",
        plugin ={"pretty", "html:target/cucumber.html",
        "json:target/cucumber-rep"}
)

public class Runner {


}
