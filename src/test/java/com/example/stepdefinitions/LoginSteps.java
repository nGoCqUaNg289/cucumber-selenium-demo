package com.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        // Implement code to enter credentials (ví dụ sử dụng Selenium)
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be redirected to the dashboard")
    public void verifyDashboard() {
        // Kiểm tra URL hoặc element trên dashboard
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}