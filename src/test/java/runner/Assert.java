package runner;

import common.PageFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Assert extends Assertion {

	public static SoftAssert softAssert = new SoftAssert();

	@Before
	public void beforeAssert() throws IOException, InterruptedException {
		softAssert = new SoftAssert();
		System.out.println("beforeScenario is called");
	}

	@Override
	public void onAssertFailure(IAssert<?> var1, AssertionError var2) {
		this.onAssertFailure(var1);
		final byte[] screenshot = ((TakesScreenshot) PageFactory.instance().getWebDriver())
				.getScreenshotAs(OutputType.BYTES);
		Reporter.getCurrentTestResult();
	}

	@After
	public void afterAssert() throws IOException {
		softAssert.assertAll();
		System.out.println("afterScenario is called");
	}

}
