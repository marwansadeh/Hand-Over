package runner;

import common.Browser;
import common.PageFactory;
import common.StateHelper;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks {

    @Before
    public void hookBeforeScenario() {
        System.out.println("custom Before scenario hook");
        PageFactory.instance().setWebDriver(Browser.createInstance("chrome"));
        PageFactory.instance().deleteAllDriverCookies();
    }

    @After
    public void hookAfterScenario(Scenario scenario) {
    	System.out.println("custom After scenario hook");
    	try {
			StateHelper.clearStepState();
		} catch (IOException e) {
			System.err.println("ERROR");
		}

        if (scenario.isFailed()) {
        	final byte[] screenshot  = ((TakesScreenshot) PageFactory.instance().getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);        
            scenario.attach(screenshot , "image/png","testStateHelper");
        }

        PageFactory.instance().deleteAllDriverCookies();
        PageFactory.instance().getWebDriver().quit();
    }

}