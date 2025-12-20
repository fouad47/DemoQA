package com.demoqa.tests.widgets;

import com.demoqa.pages.widgets.WidgetsPage;
import com.demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Widgets")
@Feature("Accordian")
public class WidgetsTest extends BaseTest {

    private WidgetsPage widgetsPage;

    @BeforeMethod
    public void methodSetup() {
        widgetsPage = new WidgetsPage(page);
    }

    @Test
    public void verifyAccordian() {
        widgetsPage.navigateToAccordian();
        widgetsPage.toggleSection1(); // Close it if open
        // Wait logic might be needed for animation
        widgetsPage.toggleSection1(); // Open it
        Assert.assertTrue(widgetsPage.isSection1Visible(), "Section 1 should be visible");
    }
}
