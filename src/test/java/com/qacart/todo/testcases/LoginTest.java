package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void ShouldBeAbleToLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        String welcomeMessage = loginPage.navigateToLoginPage()
                .login(ConfigUtils.getInstance().getPropertyValue("email"),
                        ConfigUtils.getInstance().getPropertyValue("password"))
                .getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "GOOD AFTERNOON MICHAEL");
    }
}
