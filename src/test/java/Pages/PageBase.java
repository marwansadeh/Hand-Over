package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected static WebDriver driver = null;
    protected static WebDriverWait wait;

    public PageBase(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

}
