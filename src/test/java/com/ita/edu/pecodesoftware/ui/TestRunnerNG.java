package com.ita.edu.pecodesoftware.ui;

import com.ita.edu.pecodesoftware.ui.utils.TestNGListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.time.Duration;

@Listeners(TestNGListener.class)
public class TestRunnerNG {

    protected static WebDriver driver;
    protected static TestValueProvider testValueProvider;

    @BeforeSuite
    public void beforeSuite() throws IOException {

        if (testValueProvider == null) {
            testValueProvider = new TestValueProvider();
        }
    }

    @BeforeClass
    public void initDriver(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        context.setAttribute("myDriver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(testValueProvider.getBaseUrl());
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}



