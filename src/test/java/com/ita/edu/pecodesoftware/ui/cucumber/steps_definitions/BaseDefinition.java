package com.ita.edu.pecodesoftware.ui.cucumber.steps_definitions;

import com.ita.edu.pecodesoftware.ui.TestValueProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ParameterType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseDefinition {

    protected static WebDriver driver;
    protected static TestValueProvider testValueProvider;

    @BeforeAll
    public static void beforeAll() throws IOException {
        testValueProvider = new TestValueProvider();
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before(){
        ChromeOptions options = new ChromeOptions();
        if (testValueProvider.getHeadlessMode()) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080", "--no-sandbox", "'--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
       //  driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS.ordinal());
        driver.get(testValueProvider.getBaseUrl());
    }

    @After
    public void after() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }

    public static TestValueProvider getTestValueProvider() {
        return testValueProvider;
    }

    public WebDriver getDriver(){
        return driver;
    }

    @ParameterType("([^\"]*)")
    public String  nameUser(String nameUser) {
        return nameUser;
    }

    @ParameterType("([^\"]*)")
    public String  password(String password) {
        return password;
    }

    @ParameterType("([^\"]*)")
    public String  expected(String expected) {
        return expected;
    }

}
