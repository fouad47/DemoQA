package com.demoqa.pages.elements;

import com.demoqa.pages.base.BasePage;
import com.microsoft.playwright.Page;

public class ElementsPage extends BasePage {

    public ElementsPage(Page page) {
        super(page);
    }

    // Locators
    private final String HometextBoxMenu = "//*[name()='path' and contains(@d,'M16 132h41')]";
    private final String textBoxMenu = "//li[@id='item-0']//span[text()='Text Box']";
    private final String checkMenu = "//li[@id='item-1']//span[text()='Check Box']";
    private final String fullNameInput = "#userName";
    private final String emailInput = "#userEmail";
    private final String currentAddressInput = "#currentAddress";
    private final String permanentAddressInput = "#permanentAddress";
    private final String submitButton = "#submit";
    private final String outputArea = "#output";

    // Actions
    public void navigateToTextBox() {
        click(HometextBoxMenu);
        click(textBoxMenu);
    }

    public void fillTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress) {
        type(fullNameInput, fullName);
        type(emailInput, email);
        type(currentAddressInput, currentAddress);
        type(permanentAddressInput, permanentAddress);
        // Scroll to submit if needed, Playwright auto-scrolls usually
        click(submitButton);
    }

    public String getOutput() {
        waitForVisibility(outputArea);
        return getText(outputArea);
    }
}
