# DemoQA Test Automation Framework

![Build Status](https://github.com/fouad47/DemoQA/actions/workflows/maven.yml/badge.svg)

A robust, modular, and scalable end-to-end test automation framework for [demoqa.com](https://demoqa.com) built using Java, Playwright, TestNG, and Allure.

## Features
- **Page Object Model (POM)**: Modular and maintainable code structure.
- **Playwright**: Fast and reliable browser automation.
- **Cross-Browser Testing**: Supports Chrome, Firefox, and WebKit (Safari).
- **TestRail Integration**: Automatically updates test results in TestRail.
- **Allure Reporting**: Detailed HTML reports with screenshots and steps.
- **Retry Mechanism**: Automatically retries failed tests.
- **CI/CD Ready**: GitHub Actions workflow for automated testing on every push/PR.

## Prerequisites
- Java JDK 21+
- Maven 3.6+
- Valid `src/test/resources/config.properties` (TestRail credentials optional)

## Installation
1. Clone the repository.
2. Install Maven dependencies:
   ```bash
   mvn clean install -DskipTests
   ```
3. Install Playwright browsers:
   ```bash
   mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
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

## CI/CD Integration
This project includes a GitHub Actions workflow that automatically:
- Runs on every push/pull request to `main` or `master` branches
- Installs Java 21 and all required system dependencies
- Executes the complete test suite
- Generates and uploads Allure reports as artifacts

View the workflow configuration at `.github/workflows/maven.yml`.

## Project Structure
- `src/main/java/com/demoqa/pages`: Page Objects
- `src/main/java/com/demoqa/utils`: Utilities (TestRail, Listeners)
- `src/test/java/com/demoqa/tests`: Test Classes
- `.github/workflows`: CI/CD configuration
