package com.example.stepdefinitions;

import com.example.hooks.DriverManager;
import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(DriverManager driverManager) {
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
}