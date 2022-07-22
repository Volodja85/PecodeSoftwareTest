package com.ita.edu.pecodesoftware.ui.elements.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }
}