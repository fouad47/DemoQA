package com.demoqa.tests.base;

import com.demoqa.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.demoqa.pages.base.BasePage;

@org.testng.annotations.Listeners(com.demoqa.utils.TestListener.class)
public class BaseTest {
    protected Page page;
    protected BasePage basePage;

    @BeforeMethod
    public void setup() {
        page = PlaywrightFactory.initBrowser();
        basePage = new BasePage(page);
    }

    @AfterMethod
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
    }

    public Page getPage() {
        return page;
    }
}
