package com.qacart.todo.api;

import com.qacart.todo.objects.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {
//    private String item;
//
//    public TasksApi(String item) {
//        this.item = item;
//    }

    Task task = new Task("Learn Selenium", false);

    public void addTask(String bearerToken){
        Response response =
                given()
                    .baseUri("https://qacart-todo.herokuapp.com")
                    .header("Content-Type", "application/json")
                    .body(task)
                    .auth().oauth2(bearerToken)
                .when()
                    .post("/api/v1/tasks")
                .then()
                    .log().all()
                    .extract().response();

        if (response.statusCode() != 201){
            throw new RuntimeException("Something went wrong in adding Todo item");
        }
    }
}
