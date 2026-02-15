package com.qacart.todo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddTodoItem {
    @Test
    public void ShouldBeAbleToAddTodoItem() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qacart-todo.herokuapp.com/login");
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("michaelzarif@example.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("12312345");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();
        String todoItem = driver.findElement(By.cssSelector("[data-testid=\"todo-text\"]")).getText();
        Assert.assertEquals(todoItem, "Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid=\"delete\"]")).click();
        String noTodoItems = driver.findElement(By.cssSelector("[data-testid=\"no-todos\"]")).getText();
        Assert.assertEquals(noTodoItems, "No Available Todos");
        driver.quit();
    }
}
