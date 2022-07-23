package com.ita.edu.pecodesoftware.ui.cucumber.steps_definitions;

import com.ita.edu.pecodesoftware.ui.elements.pages.HomePage;
import com.ita.edu.pecodesoftware.ui.elements.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class AllPages {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPAge;

    public AllPages(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() { return loginPAge == null ? new LoginPage(driver) : loginPAge;
    }
}


