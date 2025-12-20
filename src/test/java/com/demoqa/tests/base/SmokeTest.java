package com.demoqa.tests.base;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyTitle() {
        String title = basePage.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "DEMOQA", "Title mismatch");
    }
}
