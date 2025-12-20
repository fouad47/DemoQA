package com.demoqa.tests.forms;

import com.demoqa.pages.forms.FormsPage;
import com.demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Forms")
@Feature("Practice Form")
public class FormsTest extends BaseTest {

    private FormsPage formsPage;

    @BeforeMethod
    public void methodSetup() {
        formsPage = new FormsPage(page);
    }

    @Test(description = "Verify Practice Form Registration")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyFormRegistration() {
        formsPage.navigateToPracticeForm();
        formsPage.fillRegistrationForm("Jane", "Doe", "jane@example.com", "1234567890");

        String modalTitle = formsPage.getModalTitle();
        Assert.assertEquals(modalTitle, "Thanks for submitting the form", "Modal title mismatch");
    }
}
