package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login with email and password")
    @Description("It will login by filling the email and password and navigate to the Todo page")
    @Test(description = "Test the Login functionality using email and password")
    public void ShouldBeAbleToLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        String welcomeMessage = loginPage.load()
                .login(ConfigUtils.getInstance().getPropertyValue("email"),
                        ConfigUtils.getInstance().getPropertyValue("password"))
                .getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "GOOD EVENING MICHAEL");
    }
}
