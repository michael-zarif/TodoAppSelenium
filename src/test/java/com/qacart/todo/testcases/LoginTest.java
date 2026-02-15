package com.qacart.todo.testcases;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void ShouldBeAbleToLoginWithValidCredentials() {
        WebDriver driver = DriverFactory.initializeDriver();
        driver.get("https://qacart-todo.herokuapp.com/login");
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("michaelzarif@example.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("12312345");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        String welcomeText = driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).getText();
        Assert.assertEquals(welcomeText, "GOOD AFTERNOON MICHAEL");
        driver.quit();
    }
}
