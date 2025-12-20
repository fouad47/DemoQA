package com.demoqa.tests.alerts;

import com.demoqa.pages.alerts.AlertsPage;
import com.demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Alerts, Frame & Windows")
@Feature("Alerts")
public class AlertsTest extends BaseTest {

    private AlertsPage alertsPage;

    @BeforeMethod
    public void methodSetup() {
        alertsPage = new AlertsPage(page);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifySimpleAlert() {
        alertsPage.navigateToAlerts();
        alertsPage.triggerAlert();
    }

    @Test
    public void verifyConfirmAlert() {
        alertsPage.navigateToAlerts();
        alertsPage.triggerConfirmAlert(true);
    }
}
