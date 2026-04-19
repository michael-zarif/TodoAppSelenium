package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=\"todo-text\"]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodoItemsMessage;

    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getPropertyValue("baseUrl") + EndPoint.PAGE_TODO_ENDPOINT) ;
        return this;
    }

    @Step
    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }

    @Step
    public NewTodoPage clickAddTodoButton(){
        addButton.click();
        return new NewTodoPage(driver);
    }

    @Step
    public String getTodoItemText(){
        return todoItem.getText();
    }

    @Step
    public TodoPage deleteTodoItem(){
        deleteButton.click();
        return this;
    }

    @Step
    public String getNoTodoItemsMessage(){
        return noTodoItemsMessage.getText();
    }
}
