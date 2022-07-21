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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;


public class TestRunnerNG {

    protected static TestValueProvider testValueProvider;
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) throws IOException {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
        WebDriverManager.chromedriver().setup();
        testValueProvider = new TestValueProvider();
    }

    @SneakyThrows()
    @BeforeMethod
    public void beforeMethod(ITestContext context) {

        ChromeOptions options = new ChromeOptions();
        if (testValueProvider == null) {
            testValueProvider = new TestValueProvider();
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(testValueProvider.getBaseUrl());
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

}
