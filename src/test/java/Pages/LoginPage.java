package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text' and @class='z-TextBox']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//select[@class=\"z-ListBox\"][not(@disabled)]")
    private WebElement siteDropdown;

    public void openSISSite(){
        driver.get("http://s-2stp-dev04:8080/HR2607/");
    }

    public void loginToSISSite(String user, String pass, String site){
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(user);
        passwordField.sendKeys(pass);
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(siteDropdown));
        Select dropList=new Select(siteDropdown);
        dropList.selectByVisibleText(site);
        loginButton.click();
    }

    public void loginToSISSite(String user, String pass){
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(user);
        passwordField.sendKeys(pass);
        loginButton.click();
    }

}
