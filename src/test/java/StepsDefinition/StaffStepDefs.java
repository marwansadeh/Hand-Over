package StepsDefinition;

import Pages.HomePage;
import Pages.StaffPage;
import common.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StaffStepDefs {

    @Given("^Navigate to Create Staff page\\.$")
    public void navigateToCreateStaffPage() {
        PageFactory.instance().homePage().goToStaffMenuGroup();
        PageFactory.instance().homePage().goToStaffMenuItem();
    }

    @When("^Create staff with all required fields\\.$")
    public void createStaffWithAllRequiredFields() {

    }

    @Then("^The staff will be created successfully\\.$")
    public void theStaffWillBeCreatedSuccessfully() {

    }

    @Then("^Enter Staff Number (.*)\\.$")
    public void enterStaffNumber(String number) {
        PageFactory.instance().staffPage().EnterStaffNumber(number);
    }
}
