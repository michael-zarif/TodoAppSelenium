package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver initializeDriver() {

        String browser = System.getProperty("browser", "Chrome");   // Gets the system property when sent from terminal
        WebDriver driver = switch (browser) {
            case "Chrome" -> new ChromeDriver();
            case "Firefox" -> new FirefoxDriver();
            case "Edge" -> new EdgeDriver();
            case "Safari" -> new SafariDriver();
            default -> throw new RuntimeException("The browser is not supported");
        };

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
