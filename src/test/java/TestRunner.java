import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/Reports", "json:target/Reports/cucumber.json"},
        features = {"src/test/resources"},
        strict = true,
        monochrome = true,
        tags = {"@test"}
)
public class TestRunner {
}

