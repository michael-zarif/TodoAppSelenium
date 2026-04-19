package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")
public class TodoItemTest extends BaseTest {
    @Story("Add new Todo item")
    @Description("It will add a new Todo item by filling the value and clicking add")
    @Test(description = "Test Adding Todo item functionality")
    public void shouldBeAbleToAddTodoItem() {
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

    @Story("Delete Todo item")
    @Description("It will delete a Todo item and checking for deletion")
    @Test(description = "Test Deleting Todo item functionality")
    public void shouldBeAbleToDeleteTodoItem(){
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
