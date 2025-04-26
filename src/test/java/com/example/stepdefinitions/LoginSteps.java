package com.example.stepdefinitions;

import com.example.hooks.DriverManager;
import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private final LoginPage loginPage;
    private final DriverManager driverManager;

    public LoginSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
        this.loginPage = new LoginPage(driverManager.getDriver());
    }

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        loginPage.navigateTo();
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the dashboard")
    public void verifyDashboard() {
        assertEquals(
                "https://www.saucedemo.com/inventory.html",
                driverManager.getDriver().getCurrentUrl(),
                "URL trang dashboard không khớp"
        );

        assertTrue(
                loginPage.isOnDashboard(),
                "Không tìm thấy element đặc trưng của dashboard"
        );
    }
}