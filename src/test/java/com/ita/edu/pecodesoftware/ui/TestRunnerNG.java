package com.ita.edu.pecodesoftware.ui;

import com.ita.edu.pecodesoftware.ui.utils.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;


public class TestRunnerNG {

    protected static WebDriver driver;
    protected static TestValueProvider testValueProvider;


    @BeforeSuite
    public void beforeSuite() throws IOException {

        if (testValueProvider == null) {
            testValueProvider = new TestValueProvider();
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(testValueProvider.getBaseUrl());
    }

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        context.setAttribute("myDriver", driver);
        driver.get(testValueProvider.getBaseUrl());
    }


    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }

}
