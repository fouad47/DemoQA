package com.demoqa.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getName());
        captureScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getName(), result.getThrowable());
        captureScreenshot(result);
    }

    @io.qameta.allure.Attachment(value = "Screenshot", type = "image/png")
    private byte[] captureScreenshot(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof com.demoqa.tests.base.BaseTest) {
            com.demoqa.tests.base.BaseTest baseTest = (com.demoqa.tests.base.BaseTest) testInstance;
            if (baseTest.getPage() != null) {
                byte[] screenshotBytes = baseTest.getPage().screenshot();
                saveScreenshotLocally(result.getName(), screenshotBytes);
                return screenshotBytes;
            }
        }
        return new byte[0];
    }

    private void saveScreenshotLocally(String testName, byte[] screenshotBytes) {
        try {
            String folderPath = "screenshots";
            java.nio.file.Path path = java.nio.file.Paths.get(folderPath).toAbsolutePath();
            if (!java.nio.file.Files.exists(path)) {
                java.nio.file.Files.createDirectories(path);
            }

            java.nio.file.Path filePath = path.resolve(testName + ".png");
            if (java.nio.file.Files.exists(filePath)) {
                java.nio.file.Files.delete(filePath);
            }
            java.nio.file.Files.write(filePath, screenshotBytes);
            logger.info("Screenshot saved locally: " + filePath.toString());
        } catch (Exception e) {
            logger.error("Failed to save screenshot locally", e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test execution finished");
    }
}
