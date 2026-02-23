package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoItemTest extends BaseTest {
    @Test
    public void ShouldBeAbleToAddTodoItem() {
        LoginPage loginPage = new LoginPage(driver);
        String todoItemText = loginPage.navigateToLoginPage()
                .login(ConfigUtils.getInstance().getPropertyValue("email"),
                        ConfigUtils.getInstance().getPropertyValue("password"))
                .clickAddTodoButton()
                .addNewTodoItem("Learn Selenium")
                .getTodoItemText();
        Assert.assertEquals(todoItemText, "Learn Selenium");
    }

    @Test
    public void ShouldBeAbleToDeleteTodoItem(){
        LoginPage loginPage = new LoginPage(driver);
        String noTodoItemsMessage = loginPage.navigateToLoginPage()
                .login(ConfigUtils.getInstance().getPropertyValue("email"),
                        ConfigUtils.getInstance().getPropertyValue("password"))
                .deleteTodoItem()
                .getNoTodoItemsMessage();
        Assert.assertEquals(noTodoItemsMessage, "No Available Todos");
    }
}
