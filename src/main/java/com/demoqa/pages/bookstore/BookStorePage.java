package com.demoqa.pages.bookstore;

import com.demoqa.pages.base.BasePage;
import com.microsoft.playwright.Page;

public class BookStorePage extends BasePage {

    public BookStorePage(Page page) {
        super(page);
    }

    private final String homeloginMenu = "//h5[normalize-space()='Book Store Application']";
    private final String loginMenu = "//li[@id='item-0']//span[text()='Login']";
    private final String userNameInput = "fouad123";
    private final String passwordInput = "Fouad@123456";
    private final String loginButton = "#login";
    private final String logoutButton = "#submit"; // Sometimes ID is submit for logout
    private final String invalidLoginMessage = "#name";

    public void navigateToLogin() {
        click(homeloginMenu);
        click(loginMenu);
    }

    public void login(String user, String password) {
        type(userNameInput, user);
        type(passwordInput, password);
        click(loginButton);
    }

    public boolean isLoggedIn() {
        return isVisible(logoutButton); // Simplification, depends on UI state
    }
}
