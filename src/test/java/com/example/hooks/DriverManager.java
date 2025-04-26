package com.example.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getChromeOptions());
            configureTimeouts(driver);
        }
        return driver;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "no-sandbox",
                "ignore-certificate-errors",
                "disable-popup-blocking",
                "disable-default-apps",
                "disable-extensions-file-access-check",
                "disable-dev-shm-usage",
                "disable-infobars",
                "disable-gpu"
        );

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 1);
        prefs.put("profile.default_content_setting_values.geolocation", 1);
        prefs.put("default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", prefs);

        options.setExperimentalOption("excludeSwitches",
                new String[]{"enable-automation", "load-extension"});

        return options;
    }

    private void configureTimeouts(WebDriver driver) {
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofMillis(15000))
                .pageLoadTimeout(Duration.ofMillis(300000));
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}