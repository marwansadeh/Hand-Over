package common;

import io.github.bonigarcia.wdm.managers.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Browser {

	static WebDriver driver;

	/**
	 * 
	 * @return CHROME WebDriver
	 */
	public static WebDriver createInstance() {
		return createInstance(null);
	}

	/**
	 * 
	 * @param browserName
	 *            firefox, IE, Chrome, Safari, EDGE or Opera
	 * 
	 * @return WebDriver
	 */
	public static WebDriver createInstance(String browserName) {

		browserName = (browserName != null) ? browserName : "CHROME";

		switch (Browsers.valueOf(browserName.toUpperCase())) {
		case FIREFOX:
//		    FirefoxDriverManager.getInstance().setup();
		    FirefoxDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case IE:
			InternetExplorerDriverManager.iedriver().setup();
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(caps);
			break;
		case CHROME:
			ChromeDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case EDGE:
			EdgeDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case OPERA:
			OperaDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		default:
			Assert.fail("you Provided a value for Browser that is incorrect please recheck again, the Value was: --> " + browserName
					+ "\nPlease send one of the following values: (Chrome, Firefox, IE or Safari).");
			break;
		}
		// maximize browser's window on start
//		driver.manage().window().maximize();
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	private static enum Browsers {
		FIREFOX, CHROME, IE, SAFARI,EDGE,OPERA;
	}
}