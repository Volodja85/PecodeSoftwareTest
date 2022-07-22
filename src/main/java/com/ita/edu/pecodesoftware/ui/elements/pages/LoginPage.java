package com.ita.edu.pecodesoftware.ui.elements.pages;


import com.ita.edu.pecodesoftware.ui.elements.locators.ErrorLoginLocator;
import com.ita.edu.pecodesoftware.ui.elements.locators.LoginLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage {

    @FindBy(how = How.XPATH, using = LoginLocator.LOGIN_USER_NAME_XPATH)
    private WebElement userName;
    @FindBy(how = How.XPATH, using = LoginLocator.LOGIN_USER_PASSWORD_XPATH)
    private WebElement userPassword;
    @FindBy(how = How.XPATH, using = LoginLocator.LOGIN_BUTTON_XPATH)
    private WebElement buttonLogin;
    @FindBy(how = How.XPATH, using = ErrorLoginLocator.ERROR_NO_ACCOUNT_FOUND)
    private WebElement errorNoFoundUserName;
    @FindBy(how = How.XPATH, using = ErrorLoginLocator.ERROR_PLEASE_ENTER_PASSWORD)
    private WebElement errorEnterUserPassword;
    @FindBy(how = How.XPATH, using = ErrorLoginLocator.ERROR_PLEASE_ENTER_USERNAME)
    private WebElement errorEnterUserName;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage ClickUserName() {
        userName.click();
        return this;
    }

    public LoginPage ClickUserPassword() {
        userPassword.click();
        return this;
    }

    public LoginPage sendKeysUserNameField(String nameValue) {
        userName.sendKeys(nameValue);
        return this;
    }

    public LoginPage sendKeysUserPasswordField(String passwordValue) {
        userPassword.sendKeys(passwordValue);
        return this;
    }

    public String TextErrorNoFoundUserName() {
        return errorNoFoundUserName.getText();
    }

    public boolean DisplayedErrorNoFoundUserName() {
         return errorNoFoundUserName.isDisplayed();
    }
    public String TextErrorEnterUserPassword() {
        return errorEnterUserPassword.getText();
    }

    public boolean DisplayedErrorEnterUserPassword() {
       return errorEnterUserPassword.isDisplayed();

    }
    public String TextErrorEnterUserName() {
        return errorEnterUserName.getText();
    }

    public boolean DisplayedErrorEnterUserName() {
       return errorEnterUserName.isDisplayed();
    }

    public HomePage clickLoginButton() {
        buttonLogin.click();
        sleep(1000);
        return new HomePage(driver);
    }


}
