# Todo App Selenium Test Automation

This project is a robust, automated UI testing framework built for a Todo application. It leverages modern Java practices and popular testing libraries to ensure the quality and reliability of the web application.
Based on a course by QACart and Hatem Hatamleh
https://qacart.com/path-player?courseid=complete-selenium-framework-for-todo-application

## Technologies Used

*   **Java 21:** The core programming language used for writing the test scripts.
*   **Selenium WebDriver:** Used for automating web browser interaction and UI testing.
*   **TestNG:** The testing framework used to structure, execute, and manage the tests.
*   **Maven:** The build automation and dependency management tool.
*   **Allure Framework:** Used for generating beautiful, detailed, and interactive test execution reports.
*   **Rest Assured:** Integrated for API testing capabilities, specifically used here for manipulating browser state (like injecting cookies) to optimize test execution speed.
*   **Java Faker:** Used to generate realistic, random data for testing (e.g., names, emails) to avoid data dependency issues.
*   **Page Object Model (POM):** The design pattern used to create object repositories for web UI elements, enhancing test maintenance and reducing code duplication.

## Project Structure

The project follows a standard Maven directory structure tailored for a test automation framework:

*   **`src/test/java/com/qacart/todo/base`**: Contains the `BaseTest` class, which handles setup and teardown operations (like driver initialization and taking screenshots on failure).
*   **`src/test/java/com/qacart/todo/config`**: Holds configuration files (e.g., `production.properties`, `local.properties`) to manage environment-specific settings like Base URLs and credentials.
*   **`src/test/java/com/qacart/todo/factory`**: Contains factory classes (like `DriverFactory`) responsible for instantiating and configuring WebDriver instances.
*   **`src/test/java/com/qacart/todo/pages`**: Implements the Page Object Model. Each class represents a distinct page or component of the web application, encapsulating its locators and actions.
*   **`src/test/java/com/qacart/todo/testcases`**: Contains the actual TestNG test classes (e.g., `LoginTest`, `TodoItemTest`), organized by feature.
*   **`src/test/java/com/qacart/todo/utils`**: Provides utility classes for common tasks, such as reading configuration properties (`ConfigUtils`), managing cookies (`CookieUtils`), or interacting with APIs.

## Prerequisites

Before running the project, ensure you have the following installed on your system:

1.  **Java Development Kit (JDK) 21:** Ensure the `JAVA_HOME` environment variable is correctly set.
2.  **Maven:** Ensure the `mvn` command is available in your system's PATH.
3.  **A modern web browser:** (e.g., Google Chrome, Mozilla Firefox) installed on your machine.
4.  **(Optional) Allure Commandline:** To serve and view the Allure reports locally after execution.

## Getting Started

1.  **Clone the repository:**

    ```bash
    git clone <repository_url>
    cd TodoAppSelenium
    ```

2.  **Configuration:**

    *   Navigate to `src/test/java/com/qacart/todo/config/`.
    *   Review the properties files (e.g., `production.properties`).
    *   **Crucial:** Ensure the `baseUrl` property points to a valid, accessible, and running instance of the Todo application. *If the provided URL (e.g., a Heroku app) is no longer available, you must update this value to a working environment.*

## Running the Tests

You can execute the test suite using Maven from the command line.

*   **Run all tests:**

    ```bash
    mvn clean test
    ```

*   **Run tests in a specific environment:**
    The project uses a system property `env` to determine which configuration file to load (defaulting to "Production").

    ```bash
    mvn clean test -Denv=Local
    ```

## Viewing Test Reports (Allure)

This project uses Allure to generate comprehensive test reports. After running the tests, an `allure-results` directory will be created in your project's `target` folder.

To view the report, you need the Allure command-line tool installed.

1.  **Generate and serve the report:**

    ```bash
    allure serve target/allure-results
    ```

    This command will process the results and automatically open the interactive report in your default web browser.

## CI/CD Integration

This project is configured for Continuous Integration using GitHub Actions (refer to the `.github/workflows` directory if present). The workflow typically defines steps to check out the code, set up Java and Maven, run the test suite, and generate/publish the Allure report automatically on every push or pull request.
