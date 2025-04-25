package com.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private final DriverManager driverManager;

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Before
    public void setup() {
        // Khởi tạo driver khi cần
    }

    @After
    public void teardown() {
        driverManager.quitDriver();
    }
}