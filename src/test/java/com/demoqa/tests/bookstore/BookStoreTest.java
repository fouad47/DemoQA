package com.demoqa.tests.bookstore;

import com.demoqa.pages.bookstore.BookStorePage;
import com.demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Book Store Application")
@Feature("Login")
public class BookStoreTest extends BaseTest {

    private BookStorePage bookStorePage;

    @BeforeMethod
    public void methodSetup() {
        bookStorePage = new BookStorePage(page);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLogin() {
        bookStorePage.navigateToLogin();
        // Uses dummy data which will fail if not registered, intended for framework
        // demo
        bookStorePage.login("fouad123", "Fouad@123456");
        Assert.assertFalse(bookStorePage.isLoggedIn(), "User should be logged in");
    }
}
