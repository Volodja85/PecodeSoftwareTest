package com.ita.edu.pecodesoftware.ui.tests;

import com.ita.edu.pecodesoftware.ui.TestRunnerNG;
import com.ita.edu.pecodesoftware.ui.elements.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestRunnerNG {

    @Test(description = "")
    public void verifyAllParametersInLogining() {
        var loginPage=new LoginPage(driver)
                .sendKeysUserNameField(testValueProvider.getUserName())
                .sendKeysUserPasswordField(testValueProvider.getUserPassword())
                .clickLoginButton();


}
}
