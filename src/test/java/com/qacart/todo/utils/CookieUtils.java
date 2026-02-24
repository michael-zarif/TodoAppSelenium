package com.qacart.todo.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();
        for (io.restassured.http.Cookie restAssuredCookie : restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookie =
                    new org.openqa.selenium.Cookie(restAssuredCookie.getName(), restAssuredCookie.getValue());
            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;
    }
}
