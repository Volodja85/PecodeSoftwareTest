package com.ita.edu.pecodesoftware.ui.tests;

import com.ita.edu.pecodesoftware.ui.TestRunnerNG;
import com.ita.edu.pecodesoftware.ui.elements.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestRunnerNG {
    private static final String UserCyrillicName="Володя";
    private static final String UserCyrillicPassword="Володя";

    @AfterMethod
    public void afterMethod() {
        new LoginPage(driver)
                .deleteTextUserName()
                .deleteTextUserPassword();
    }

    @Description("the test checks whether we can enter a non-existent user")
    @Issue("")
    @Test(description = "")
    public void verifyWhenEnteringNonExistentUser() {
        SoftAssert softAssert = new SoftAssert();
        var testErrorEnterUserName = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(testValueProvider.getUserName())
                .ClickUserPassword()
                .sendKeysUserPasswordField(testValueProvider.getUserPassword())
                .clickLoginButton()
                .getLoginPage()
                .TextErrorNoFoundUserName();
        var textValueUserName=new LoginPage(driver)
                .TextUserNameValue();
        var textValueUserPassword=new LoginPage(driver)
                .TextUserPasswordValue();
        var booleanErrorNoFoundUserName = new LoginPage(driver)
                .DisplayedErrorNoFoundUserName();
        softAssert.assertEquals(testErrorEnterUserName, "No account found with that username.", "the entered account already exists");
        softAssert.assertTrue(booleanErrorNoFoundUserName, "the entered account already exists");
        softAssert.assertEquals(textValueUserName,testValueProvider.getUserName());
        softAssert.assertNotEquals(textValueUserPassword,testValueProvider.getUserPassword());
        softAssert.assertAll();
    }

    @Description("the test checks whether we can enter a non-existent user")
    @Issue("")
    @Test(description = "")
    public void verifyValueWhenEnteringNonExistentUser() {
        SoftAssert softAssert = new SoftAssert();
        var loginPage = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(testValueProvider.getUserName())
                .ClickUserPassword()
                .sendKeysUserPasswordField(testValueProvider.getUserPassword());
        var textValueUserName=new LoginPage(driver)
                .TextUserNameValue();
        var textValueUserPassword=new LoginPage(driver)
                .TextUserPasswordValue();
        softAssert.assertEquals(textValueUserName,testValueProvider.getUserName());
        softAssert.assertEquals(textValueUserPassword,testValueProvider.getUserPassword());
        softAssert.assertAll();
    }

    @Description("")
    @Issue("")
    @Test(description = "")
    public void verifyWhenEnteringCyrillicValue() {
        SoftAssert softAssert=new SoftAssert();
        var testErrorBodyMassage = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(UserCyrillicName)
                .ClickUserPassword()
                .sendKeysUserPasswordField(UserCyrillicPassword);
        var textValueUserName=new LoginPage(driver)
                .TextUserNameValue();
        var textValueUserPassword=new LoginPage(driver)
                .TextUserPasswordValue();
        softAssert.assertEquals(textValueUserName,UserCyrillicName);
        softAssert.assertEquals(textValueUserPassword,UserCyrillicPassword);
        softAssert.assertAll();
    }

    @Description("")
    @Issue("")
    @Test(description = "")
    public void verifyValueWhenEnteringCyrillicData() {
        var testErrorBodyMassage = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(UserCyrillicName)
                .ClickUserPassword()
                .sendKeysUserPasswordField(UserCyrillicPassword)
                .clickLoginButton()
                .getLoginPage()
                .TextErrorBodyMassage();
        Assert.assertEquals(testErrorBodyMassage, "Oops! Something went wrong. Please try again later.", "the entered Cyrillic account already exists");

    }

    @Description("")
    @Issue("")
    @Test(description = "")
    public void verifyWhenEnterEmptyValue() {
        SoftAssert softAssert = new SoftAssert();
        var testErrorMassageUser = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(" ")
                .ClickUserPassword()
                .sendKeysUserPasswordField(" ")
                .clickLoginButton()
                .getLoginPage()
                .TextErrorEnterUserName();
        var testErrorMassagePassword = new LoginPage(driver)
                .TextErrorEnterUserPassword();
        var booleanErrorMassageUser = new LoginPage(driver)
                .DisplayedErrorEnterUserName();
        var booleanErrorMassagePassword = new LoginPage(driver)
                .DisplayedErrorEnterUserPassword();
        softAssert.assertEquals(testErrorMassageUser, "Please enter username.", "the entered Cyrillic account already exists");
        softAssert.assertEquals(testErrorMassagePassword, "Please enter your password.", "the entered Cyrillic account already exists");
        softAssert.assertTrue(booleanErrorMassageUser);
        softAssert.assertTrue(booleanErrorMassagePassword);
        softAssert.assertAll();
    }

    @Description("")
    @Issue("")
    @Test(description = "")
    public void verifyValueWhenEnterEmptyData() {
        SoftAssert softAssert = new SoftAssert();
        var loginPage = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(" ")
                .ClickUserPassword()
                .sendKeysUserPasswordField(" ");

        var textValueUserName=new LoginPage(driver)
                .TextUserNameValue();
        var textValueUserPassword=new LoginPage(driver)
                .TextUserPasswordValue();
        softAssert.assertEquals(textValueUserName," ");
        softAssert.assertEquals(textValueUserPassword," ");
        softAssert.assertAll();
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        Object[][] data = new Object[][]{
                {"123", "1234"},

        };
        return data;
    }

    @Description("")
    @Issue("")
    @Test(description = "", dataProvider = "data")
    public void verifyWhenEnterNumbersValue(String userName, String userPassword) {
        SoftAssert softAssert = new SoftAssert();
        var testErrorMassage = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(userName)
                .ClickUserPassword()
                .sendKeysUserPasswordField(userPassword)
                .clickLoginButton()
                .getLoginPage()
                .TextErrorNoFoundUserName();
        var booleanTestErrorMassage = new LoginPage(driver)
                .DisplayedErrorNoFoundUserName();
        var textValueUserName=new LoginPage(driver)
                .TextUserNameValue();
        var textValueUserPassword=new LoginPage(driver)
                .TextUserPasswordValue();
        softAssert.assertEquals(testErrorMassage, "No account found with that username.", "the entered account already exists");
        softAssert.assertTrue(booleanTestErrorMassage);
        softAssert.assertEquals(textValueUserName,userName);
        softAssert.assertNotEquals(textValueUserPassword,userPassword);
        softAssert.assertAll();
    }
    @Description("")
    @Issue("")
    @Test(description = "", dataProvider = "data")
    public void verifyValueWhenEnterNumbers(String userName, String userPassword) {
        SoftAssert softAssert = new SoftAssert();
        var loginPage = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(userName)
                .ClickUserPassword()
                .sendKeysUserPasswordField(userPassword);
        var textValueUserName=new LoginPage(driver)
                .TextUserNameValue();
        var textValueUserPassword=new LoginPage(driver)
                .TextUserPasswordValue();
        softAssert.assertEquals(textValueUserName,userName);
        softAssert.assertEquals(textValueUserPassword,userPassword);
        softAssert.assertAll();
    }

    @Test
    public void CheckLoginAvatarMini() {
        var avatarSCR = new LoginPage(driver)
                .getAvatarImgPath();
        Assert.assertEquals(avatarSCR, "https://pecode-software.web.app/static/media/icon-logo.f8576d05.svg");
    }

    @Test
    public void CheckLoginTextCenter() {
        var textCenter = new LoginPage(driver)
                .TextFromTextCenter();
        Assert.assertEquals(textCenter, "AQA internship Login");
    }


}



