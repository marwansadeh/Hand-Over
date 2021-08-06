package common;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.StaffPage;

public class PageFactory extends PageFactoryAbstract {

    private static PageFactory pageFactory;

    public static PageFactory instance() {
        if (pageFactory == null) {
            pageFactory = new PageFactory();
        }
        return pageFactory;
    }

// pages object

    public LoginPage loginPage() {
        return new LoginPage(getWebDriver());
    }

    public HomePage homePage() {
        return new HomePage(getWebDriver());
    }

    public StaffPage staffPage() {
        return new StaffPage(getWebDriver());
    }

}
