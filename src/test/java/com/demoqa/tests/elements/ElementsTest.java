package com.demoqa.tests.elements;

import com.demoqa.pages.elements.ElementsPage;
import com.demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Elements")
@Feature("Text Box")
public class ElementsTest extends BaseTest {

    private ElementsPage elementsPage;

    @BeforeMethod
    public void methodSetup() {
        elementsPage = new ElementsPage(page);
    }

    @Test(description = "Verify Text Box Form Submission")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that the text box form can be filled and submitted correctly.")
    public void verifyTextBoxForm() {
        elementsPage.navigateToTextBox();
        elementsPage.fillTextBoxForm("John Doe", "john@example.com", "123 Street", "456 Avenue");

        String output = elementsPage.getOutput();
        Assert.assertTrue(output.contains("John Doe"), "Output should contain Name");
        Assert.assertTrue(output.contains("john@example.com"), "Output should contain Email");
    }
}
