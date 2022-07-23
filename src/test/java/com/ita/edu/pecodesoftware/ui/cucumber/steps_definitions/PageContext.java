package com.ita.edu.pecodesoftware.ui.cucumber.steps_definitions;

import com.ita.edu.pecodesoftware.ui.cucumber.steps_definitions.AllPages;
import org.openqa.selenium.WebDriver;

public class PageContext {
    private WebDriver driver;
    private AllPages allPages;

    public PageContext(WebDriver driver){
        this.driver = driver;
    }

    public AllPages getAllPages() {
        allPages = new AllPages(driver);
        return  allPages;
    }
}

