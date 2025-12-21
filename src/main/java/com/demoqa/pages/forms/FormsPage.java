package com.demoqa.pages.forms;

import com.demoqa.pages.base.BasePage;
import com.microsoft.playwright.Page;

public class FormsPage extends BasePage {

    public FormsPage(Page page) {
        super(page);
    }

    private final String HomepracticeFormMenu = "//h5[normalize-space()='Forms']";
    private final String practiceFormMenu = "//li[@id='item-0']//span[text()='Practice Form']";
    private final String firstNameInput = "//input[@id='firstName']";
    private final String lastNameInput = "//input[@id='lastName']";
    private final String emailInput = "//input[@id='userEmail']";
    private final String genderMaleRadio = "//label[contains(@for, 'gender-radio-1')]";
    private final String mobileInput = "//input[@id='userNumber']";
    private final String submitButton = "//button[@id='submit']";
    private final String modalTitle = "#example-modal-sizes-title-lg";

    public void navigateToPracticeForm() {
        click(HomepracticeFormMenu);
        click(practiceFormMenu);
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String mobile) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(emailInput, email);
        click(genderMaleRadio);
        type(mobileInput, mobile);
        // Other fields can be added
        click(submitButton);
    }

    public String getModalTitle() {
        waitForVisibility(modalTitle);
        return getText(modalTitle);
    }
}
