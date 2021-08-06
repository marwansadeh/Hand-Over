package StepsDefinition;

import common.PageFactory;
import io.cucumber.java.en.*;

public class MyStepdefs {

    @Given("Open the SIS site.")
    public void openTheSISSite() {
        PageFactory.instance().loginPage().openSISSite();
    }

    @When("^Use (.*?) user name and (.*) password to login\\.$")
    public void useUserNameAndPasswordToLogin(String user, String pass) {
        PageFactory.instance().loginPage().loginToSISSite(user,pass,"MINISTRY OF EDUCATION");
    }

    @Then("^Home page should be displayed (.*)\\.$")
    public void homePageShouldBeDisplayed(String expected) {
        PageFactory.instance().homePage().assertMethod(expected);
    }

}
