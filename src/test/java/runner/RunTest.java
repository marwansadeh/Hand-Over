package runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"StepsDefinition", "runner"},
//        tags = "@Staff",
        plugin = {"html:target/cucumber-html-report", "junit:target/cucumber-junit.xml", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json"},
        features = "src/test/java/Features",
        monochrome = true)

public class RunTest {
}
