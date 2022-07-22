package com.ita.edu.pecodesoftware.ui.elements.pages;


import com.ita.edu.pecodesoftware.ui.elements.locators.ErrorLoginLocator;
import com.ita.edu.pecodesoftware.ui.elements.locators.LoginLocator;
import io.qameta.allure.Step;
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
    @FindBy(how = How.XPATH, using = ErrorLoginLocator.ERROR_BODY_MASSAGE)
    private WebElement errorBodyMassage;
    @FindBy(how = How.XPATH, using = LoginLocator.AVATAR_LOGO_MINI_XPATH)
    private WebElement avatarLogoMini;
    @FindBy(how = How.XPATH, using = LoginLocator.TEXT_CENTER_XPATH)
    private WebElement textCenter;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click title UserName")
    public LoginPage ClickUserName() {
        userName.click();
        return this;
    }

    @Step("Click title UserPassword")
    public LoginPage ClickUserPassword() {
        userPassword.click();
        return this;
    }

    @Step("entered user name \"{nameValue}\"")
    public LoginPage sendKeysUserNameField(String nameValue) {
        userName.sendKeys(nameValue);
        return this;
    }

    @Step("entered password \"{passwordValue}\"")
    public LoginPage sendKeysUserPasswordField(String passwordValue) {
        userPassword.sendKeys(passwordValue);
        return this;
    }

    @Step("get error message when user not found")
    public String TextErrorNoFoundUserName() {
        saveScreenshot();
        return errorNoFoundUserName.getText();
    }

    @Step("get displayed when user not found")
    public boolean DisplayedErrorNoFoundUserName() {
        saveScreenshot();
         return errorNoFoundUserName.isDisplayed();
    }

    @Step("get error message Enter user password")
    public String TextErrorEnterUserPassword() {
        saveScreenshot();
        return errorEnterUserPassword.getText();
    }

    @Step("get displayed when Enter user password")
    public boolean DisplayedErrorEnterUserPassword() {
        saveScreenshot();
        return errorEnterUserPassword.isDisplayed();
    }

    @Step("get error message Enter user name")
    public String TextErrorEnterUserName() {
        saveScreenshot();
        return errorEnterUserName.getText();
    }

    @Step("get error message text from body")
    public String TextErrorBodyMassage() {
        String errorMassage = null;
        try {
            saveScreenshot();
            errorMassage = getFindTextFromBody(errorBodyMassage.getText(), "\n", 0);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return errorMassage;
    }

    @Step("get Displayed when Entered error UserName")
    public boolean DisplayedErrorEnterUserName() {
        return errorEnterUserName.isDisplayed();
    }

    @Step("delete text in userName")
    public LoginPage deleteTextUserName() {
        deleteText(userName);
        return this;
    }

    @Step("delete text in Password")
    public LoginPage deleteTextUserPassword() {
        deleteText(userPassword);
        return this;
    }

    @Step("Click login button and opened Home page")
    public HomePage clickLoginButton() {
        buttonLogin.click();
        sleep(1000);
        return new HomePage(driver);
    }

    @Step("get Attribute Avatar src")
    public String getAvatarImgPath() {
        return avatarLogoMini.getAttribute("src");
    }

    @Step("get Attribute text from text center")
    public String TextFromTextCenter() {
        return textCenter.getText();
    }

    @Step("get Attribute UserName Value")
    public String TextUserNameValue() {
        return userName.getAttribute("value");
    }

    @Step("get Attribute Password Value")
    public String TextUserPasswordValue() {
        return userPassword.getAttribute("value");
    }
}
