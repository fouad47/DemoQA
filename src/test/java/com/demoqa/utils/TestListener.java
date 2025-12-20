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
        // Integer testCaseId = (Integer) result.getAttribute("testCaseId");
        // if (testCaseId != null)
        // TestRailManager.addResultForTestCase(String.valueOf(testCaseId), 1,
        // "Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getName(), result.getThrowable());
        // Capture screenshot logic here usually
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test execution finished");
    }
}
