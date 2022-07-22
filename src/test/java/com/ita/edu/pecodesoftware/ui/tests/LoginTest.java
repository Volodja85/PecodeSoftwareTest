package com.ita.edu.pecodesoftware.ui.tests;

import com.ita.edu.pecodesoftware.ui.TestRunnerNG;
import com.ita.edu.pecodesoftware.ui.elements.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestRunnerNG {
    @Description("the test checks whether we can enter a non-existent user}")
    @Issue("")
    @Test(description = "")
    public void verifyWhenEnteringNonExistentUser() {
        SoftAssert softAssert = new SoftAssert();
        String testErrorEnterUserName = new LoginPage(driver)
                .ClickUserName()
                .sendKeysUserNameField(testValueProvider.getUserName())
                .ClickUserPassword()
                .sendKeysUserPasswordField(testValueProvider.getUserPassword())
                .clickLoginButton()
                .getLoginPage()
                .TextErrorNoFoundUserName();
        softAssert.assertEquals(testErrorEnterUserName, "No account found with that username.", "the entered account already exists");

        boolean booleanErrorNoFoundUserName = new LoginPage(driver)
                .DisplayedErrorNoFoundUserName();
        softAssert.assertTrue(booleanErrorNoFoundUserName, "the entered account already exists");
        softAssert.assertAll();
    }
}
