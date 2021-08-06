package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StaffPage extends PageBase{

    public StaffPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Staff']/../input[@type='text' and @class='z-TextBox z-TextBoxWithIcon']")
    private WebElement staffnumberBox;

    @FindBy(xpath = "//button[text()='Search']")
    private WebElement SearchStaffButton;

    public void EnterStaffNumber(String number) {
        wait.until(ExpectedConditions.elementToBeClickable(SearchStaffButton));
        wait.until(ExpectedConditions.visibilityOf(staffnumberBox)).sendKeys(number);
        SearchStaffButton.click();
    }

}
