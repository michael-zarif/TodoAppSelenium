package com.qacart.todo.api;

import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private String accessToken;
    private String userId;
    private String firstName;
    private List<Cookie> restAssuredCookies;

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public void register(){
        User user = UserUtils.generateRandomUser();

        Response response =
                given()
                    .baseUri("https://qacart-todo.herokuapp.com")
                    .header("Content-Type", "application/json")
                    .body(user)
                    .log().all()
                .when()
                    .post("/api/v1/users/register")
                .then()
                    .log().all()
                    .extract().response();

        if (response.statusCode() != 201){
            throw new RuntimeException("Something went wrong with the request");
        }

        accessToken = response.path("access_token");
        userId = response.path("userId");
        firstName = response.path("firstName");
        restAssuredCookies = response.detailedCookies().asList();
    }
}
