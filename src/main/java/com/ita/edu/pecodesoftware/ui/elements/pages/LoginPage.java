package com.ita.edu.pecodesoftware.ui.elements.pages;

import com.ita.edu.pecodesoftware.ui.elements.custom_elements.Button;
import com.ita.edu.pecodesoftware.ui.elements.custom_elements.Input;
import com.ita.edu.pecodesoftware.ui.elements.locators.LoginLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.XPATH, using = LoginLocator.LOGIN_USER_NAME_XPATH)
    private Input userName;
    @FindBy(how = How.XPATH, using = LoginLocator.LOGIN_USER_PASSWORD_XPATH)
    private Input userPassword;
    @FindBy(how = How.XPATH, using = LoginLocator.LOGIN_BUTTON_XPATH)
    private Button buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage sendKeysUserNameField(String nameValue) {
        waitUntilVisibilityOfElementLocated(By.id(LoginLocator.LOGIN_USER_NAME_XPATH), 5);
        userName.set(nameValue);
        return this;
    }

    public LoginPage sendKeysUserPasswordField(String passwordValue) {
        waitUntilVisibilityOfElementLocated(By.id(LoginLocator.LOGIN_USER_PASSWORD_XPATH), 5);
        userPassword.set(passwordValue);
        return this;
    }

    public HomePage clickLoginButton() {
        buttonLogin.click();
        sleep(1000);
        return new HomePage(driver);
    }


}
