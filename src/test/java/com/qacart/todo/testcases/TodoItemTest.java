package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoItemTest extends BaseTest {
    @Test
    public void ShouldBeAbleToAddTodoItem() {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        TodoPage todoPage = new TodoPage(driver);
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        String todoItemText = todoPage
                .load()
                .clickAddTodoButton()
                .addNewTodoItem("Learn Selenium")
                .getTodoItemText();
        Assert.assertEquals(todoItemText, "Learn Selenium");
    }

    @Test
    public void ShouldBeAbleToDeleteTodoItem(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage(driver);
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());

        String noTodoItemsMessage = todoPage
                .load()
                .deleteTodoItem()
                .getNoTodoItemsMessage();
        Assert.assertEquals(noTodoItemsMessage, "No Available Todos");
    }
}
