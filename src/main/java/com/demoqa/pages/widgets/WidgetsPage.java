package com.demoqa.pages.widgets;

import com.demoqa.pages.base.BasePage;
import com.microsoft.playwright.Page;

public class WidgetsPage extends BasePage {

    public WidgetsPage(Page page) {
        super(page);
    }

    private final String accordianMenu = "//li[@id='item-0']//span[text()='Accordian']";
    private final String section1Heading = "#section1Heading";
    private final String section1Content = "#section1Content";

    public void navigateToAccordian() {
        click(accordianMenu);
    }

    public boolean isSection1Visible() {
        return isVisible(section1Content);
    }

    public void toggleSection1() {
        click(section1Heading);
    }
}
