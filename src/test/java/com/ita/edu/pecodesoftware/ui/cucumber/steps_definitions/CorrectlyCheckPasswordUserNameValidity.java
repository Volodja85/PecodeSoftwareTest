package com.ita.edu.pecodesoftware.ui.cucumber.steps_definitions;

import com.ita.edu.pecodesoftware.ui.cucumber.cucumberTestRunner.BaseDefinition;
import com.ita.edu.pecodesoftware.ui.cucumber.cucumberTestRunner.PageContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.asserts.SoftAssert;

public class CorrectlyCheckPasswordUserNameValidity {
    private BaseDefinition baseDef;
    private PageContext pageContext;
    private final SoftAssert softAssert;

    public CorrectlyCheckPasswordUserNameValidity(BaseDefinition baseDef) {
        this.baseDef = baseDef;
        pageContext = new PageContext(baseDef.getDriver());
        softAssert = new SoftAssert();
    }

    @Given("Go to Login Page {nameUser} and {password}")
    public void goToLoginPage(String nameUser,String password) {
        pageContext.getAllPages()
                .getLoginPage()
                .ClickUserName()
                .sendKeysUserNameField(nameUser)
                .ClickUserPassword()
                .sendKeysUserPasswordField(password)
                 .clickLoginButton()
                .getLoginPage();
    }

    @And("Fill data in field {expected}")
    public void verifyIfUserConnecting(String expected) {
        softAssert.assertEquals(pageContext
                .getAllPages()
                .getLoginPage()
                .TextErrorNoFoundUserName(), expected);
        softAssert.assertAll();
    }
}


