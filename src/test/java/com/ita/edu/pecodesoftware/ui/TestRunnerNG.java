package com.ita.edu.pecodesoftware.ui;

import com.ita.edu.pecodesoftware.ui.utils.TestNGListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(testValueProvider.getBaseUrl());
    }

    @AfterClass
    public void quitDriverClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void quitDriverSuite() {
        if (driver != null) {
            driver.quit();
        }
    }
}



