# DemoQA Test Automation Framework

A robust, modular, and scalable end-to-end test automation framework for [demoqa.com](https://demoqa.com) built using Java, Playwright, TestNG, and Allure.

## Features
- **Page Object Model (POM)**: Modular and maintainable code structure.
- **Playwright**: Fast and reliable browser automation.
- **Cross-Browser Testing**: Supports Chrome, Firefox, and WebKit (Safari).
- **TestRail Integration**: Automatically updates test results in TestRail.
- **Allure Reporting**: Detailed html reports with screenshots and steps.
- **Retry Mechanism**: Automatically retries failed tests.
- **CI/CD Ready**: Configured for Maven and easy CI integration.

## Prerequisites
- Java JDK 11+
- Maven 3.6+
- Valid `src/test/resources/config.properties` (TestRail credentials optional)

## Installation
1. Clone the repository.
2. Install dependencies:
   ```bash
   mvn clean install -DskipTests
   ```

## Configuration
Edit `src/test/resources/config.properties`:
```properties
browser=chrome  # chrome, firefox, webkit
headless=false  # true/false
testrail.enabled=false # Set to true to enable integration
```

## Running Tests
Run all tests:
```bash
mvn clean test
```

## Viewing Reports
Generate and view Allure report:
```bash
mvn allure:serve
```

## Project Structure
- `src/main/java/com/demoqa/pages`: Page Objects
- `src/main/java/com/demoqa/utils`: Utilities (TestRail, Listeners)
- `src/test/java/com/demoqa/tests`: Test Classes
