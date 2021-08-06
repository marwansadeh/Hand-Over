import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class testClass {

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert = new SoftAssert();

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        wait = new WebDriverWait(driver,60);

        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void login(){
        driver.get("http://s-2stp-dev04:8080/HR2607/");

        WebElement UsernameTXT = driver.findElement(By.xpath("//input[@type='text' and @class='z-TextBox']"));
        wait.until(ExpectedConditions.visibilityOf(UsernameTXT)).sendKeys("administrator");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("misk");
        WebElement loginbutton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginbutton.click();
        WebElement site= driver.findElement(By.xpath("//select[@class=\"z-ListBox\"][not(@disabled)]"));

        Select dropList=new Select(site);
        dropList.selectByVisibleText("MINISTRY OF EDUCATION");
        loginbutton.click();
    }

    @Test
    public void loginAndVerify(){
       login();
        String message = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".z-FieldLabel.z-LabelBanner")))).getText();
//        Assert.assertEquals(message,"SYSTEM ADMINN","The expected message is \"SYSTEM ADMINN\" but we found " + message);
        softAssert.assertEquals(message,"SYSTEM ADMIN","The expected message is \"SYSTEM ADMINN\" but we found " + message);
    }

    @After
    public void after(){
        driver.quit();
        softAssert.assertAll();
    }

}
