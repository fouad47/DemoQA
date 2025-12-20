package com.demoqa.pages.alerts;

import com.demoqa.pages.base.BasePage;
import com.microsoft.playwright.Page;

public class AlertsPage extends BasePage {

    public AlertsPage(Page page) {
        super(page);
    }

    private final String homealertsMenu = "//div[3]//div[1]//div[2]//*[name()='svg']";
    private final String alertsMenu = "//li[@id='item-1']//span[text()='Alerts']";
    private final String alertButton = "#alertButton";
    private final String confirmButton = "#confirmButton";
    private final String promptButton = "#promtButton";

    public void navigateToAlerts() {
        click(homealertsMenu);
        click(alertsMenu);
    }

    public void triggerAlert() {
        page.onceDialog(dialog -> {
            logger.info("Dialog message: " + dialog.message());
            dialog.accept();
        });
        click(alertButton);
    }

    public void triggerConfirmAlert(boolean accept) {
        page.onceDialog(dialog -> {
            logger.info("Confirm message: " + dialog.message());
            if (accept)
                dialog.accept();
            else
                dialog.dismiss();
        });
        click(confirmButton);
    }

    public void triggerPromptAlert(String text) {
        page.onceDialog(dialog -> {
            logger.info("Prompt message: " + dialog.message());
            dialog.accept(text);
        });
        click(promptButton);
    }
}
