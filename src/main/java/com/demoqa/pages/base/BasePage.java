package com.demoqa.pages.base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    protected Page page;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BasePage(Page page) {
        this.page = page;
    }

    protected void click(String selector) {
        logger.info("Clicking on element: {}", selector);
        page.locator(selector).click();
    }

    protected void click(Locator locator) {
        logger.info("Clicking on locator: {}", locator);
        locator.click();
    }

    protected void type(String selector, String text) {
        logger.info("Typing '{}' into element: {}", text, selector);
        page.locator(selector).fill(text);
    }

    protected String getText(String selector) {
        logger.info("Getting text from element: {}", selector);
        return page.locator(selector).textContent();
    }

    protected boolean isVisible(String selector) {
        return page.locator(selector).isVisible();
    }

    protected void waitForVisibility(String selector) {
        page.locator(selector).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public String getTitle() {
        return page.title();
    }
}
