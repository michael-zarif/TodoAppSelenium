package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoItemTest extends BaseTest {
    @Test
    public void ShouldBeAbleToAddTodoItem() {
        LoginPage loginPage = new LoginPage(driver);
        String todoItemText = loginPage.navigateToLoginPage()
                .login("michaelzarif@example.com", "12312345")
                .clickAddTodoButton()
                .addNewTodoItem("Learn Selenium")
                .getTodoItemText();
        Assert.assertEquals(todoItemText, "Learn Selenium");
    }

    @Test
    public void ShouldBeAbleToDeleteTodoItem(){
        LoginPage loginPage = new LoginPage(driver);
        String noTodoItemsMessage = loginPage.navigateToLoginPage()
                .login("michaelzarif@example.com", "12312345")
                .deleteTodoItem()
                .getNoTodoItemsMessage();
        Assert.assertEquals(noTodoItemsMessage, "No Available Todos");
    }
}
