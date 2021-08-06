package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".z-FieldLabel.z-LabelBanner")
    private WebElement text;

    @FindBy(xpath = "//div[text()='Staff' and @class='z-FieldLabel']")
    private WebElement staffMenuGroup;

    @FindBy(xpath = "//img[@src='system/scenarios/version2/create_staff.png' and @class='z-ImageButtonToolsWidget-Image z-ImageButtonToolsSizeMedium-Image']")
    private WebElement staffMenuItem;

    public void goToStaffMenuGroup() {
        wait.until(ExpectedConditions.visibilityOf(staffMenuGroup)).click();
    }

    public void goToStaffMenuItem() {
        wait.until(ExpectedConditions.elementToBeSelected(staffMenuItem));
        staffMenuItem.click();
    }

    public void assertMethod(String expected) {
        String message = wait.until(ExpectedConditions.visibilityOf(text)).getText();
        Assert.assertEquals(message, expected, "The expected message is \"" + expected + "\" but we found " + message);
    }

}
