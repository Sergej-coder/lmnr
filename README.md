
## Overview
This guide explains how to run tests and generate Allure reports from the `lmnr` project directory using Gradle commands.

---

## Running Tests

Navigate to the `lmnr` directory and execute:
```bash
gradle clean test
```
This command cleans previous builds and runs all tests.

---

## Generating Allure Report

From the `lmnr` directory, run:
```bash
gradle AllureReport
```
This command generates an Allure report based on the latest test results.

---

##  Viewing the Allure Report

To open the generated Allure report in a local server, run:
```bash
gradle AllureServe
```
This will start a local server where you can view the report in your browser.

---



