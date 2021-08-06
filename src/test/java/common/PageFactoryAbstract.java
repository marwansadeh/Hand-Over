package common;

import org.openqa.selenium.WebDriver;

public class PageFactoryAbstract {

    private static WebDriver _driver;

    public WebDriver getWebDriver() {
        return _driver;
    }

    public void setWebDriver(WebDriver driver) {
        this._driver = driver;
    }

    public void deleteAllDriverCookies()
    {
        getWebDriver().manage().deleteAllCookies();
    }

}
