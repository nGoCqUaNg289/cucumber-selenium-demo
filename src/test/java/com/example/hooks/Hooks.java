package com.example.hooks;

import io.cucumber.java.*;
import org.openqa.selenium.*;
import io.cucumber.java.Scenario;

public class Hooks {
    private final DriverManager driverManager;

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Before(order = 0)
    public void initBrowser() {
        System.out.println("HOOK: Before - Open browser");
        WebDriver driver = driverManager.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("HOOK: After - Close browser");
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driverManager.quitDriver();
    }
}