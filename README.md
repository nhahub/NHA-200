# SauceDemo.com Automation Testing Project Graduation Project — DEPI (Digital Egypt Pioneers Initiative) – Software Testing Track

This project is an Automation test suite for the saucedemo.com demo e-commerce site. Built in Java using Selenium WebDriver, the Page Object Model (POM) design pattern, and a small “Bot” engine that orchestrates actions and provides fluent waits inside page objects.
This project was developed as a graduation project for the Digital Egypt Pioneers Initiative (DEPI).

The goal of this project is to demonstrate a clean, scalable, and maintainable automation framework suitable for real-world testing environments.

--- 


📚 Table of Contents

[About the Project](#about-the-project)

[Key Features](#key-features)

[Project Structure](#project-structure)

[Tech Stack](#tech-stack)

[Installation and Setup](#installation-and-setup)

[How the Framework Works](#how-the-framework-works)

[Automated User Flow](#automated-user-flow)

[Configuration](#configuration)

[Future Improvements](#future-improvements)

[Acknowledgement](#acknowledgement)

[Contributors](#contributors)

[Contact](#contact)

---

## About the Project

This repository contains a Selenium automation test suite designed to validate the functionality of SauceDemo.com.
It uses:

* POM architecture

* Reusable Bot engine

* Fluent waits

* Modular test structure

The framework is designed with scalability, readability, and maintainability in mind — following best practices used in professional QA automation teams.

---

## Key Features
* Page Object Model (POM)

  A separate class for each page with clearly defined actions.

* Bot Engine

  Encapsulates:

  User interactions

  Fluent waits

  Navigation logic

* Modular Test Structure

  Each page has a matching test class.

* Selenium WebDriver

  Cross-browser test automation.

* Clean, Scalable Architecture

  Easy to maintain and extend.

---

## Project Structure
```
 SauceDemoWebsite
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   ├── Engine
    │   │   │   │   └── Bot.java
    │   │   │   │
    │   │   │   └── SauceDemoPages
    │   │   │       ├── CompletePage.java
    │   │   │       ├── LoginPage.java
    │   │   │       ├── OverviewPage.java
    │   │   │       ├── ProductListingPage.java
    │   │   │       ├── ProductPage.java
    │   │   │       ├── YourCartPage.java
    │   │   │       └── YourInformationPage.java
    │   │   │
    │   │   └── resources
    │   │
    │   └── test
    │       └── java
    │           └── SauceDemoPagesTest
    │               ├── BaseTest.java
    │               ├── CompletePageTest.java
    │               ├── LoginPageTest.java
    │               ├── OverviewPageTest.java
    │               ├── ProductListingPageTest.java
    │               ├── ProductPageTest.java
    │               ├── YourCartPageTest.java
    │               └── YourInformationPageTest.java
    │
    └──── pom.xml

```
---

## Tech Stack
* Java	Main programming language
* Selenium WebDriver	UI automation
* POM (Page Object Model)	Test framework architecture
* TestNG / JUnit	Test runner
* Fluent Waits	Stable test execution
* Maven	Dependency and build management

  ---
## Installation and Setup
1. Clone the repository

       git clone https://github.com/nhahub/NHA-200.git
       cd NHA-200/SauceDemoWebsite

3. Install dependencies

       mvn clean install

5. Run tests

       mvn test


If using TestNG suite file:

     mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml

---

## How the Framework Works
***Page Objects***

Each class in SauceDemoPages encapsulates:

* Web element locators

* Actions

* Validation methods

* Bot / Engine Layer

  ---

***The Bot class***

* Performs reusable UI actions

* Handles delays using Fluent Waits

* Abstracts away Selenium logic from tests

* Test Layer

* Each page has a dedicated test class.

  ---
***BaseTest handles***:

* WebDriver setup

* Browser configuration

* Tear down

  ---


## Automated User Flow

The framework automates a full e-commerce flow, including:

* Login

* Viewing products

* Navigating to a product

* Adding item to cart

* Opening the cart

* Proceeding to checkout

* Filling personal info

* Completing the order

* Validating the success page

  ---


## Configuration
***Browser Configuration***

Browser type: **Chrome**

---

## Future Improvements

* Add Fluent bot

* Add reporting (Allure)

* Negative and edge-case test scenarios

* Cross-browser testing


---

## Acknowledgement
* Eng. Mohamed Saied Alshafey (DEPI software testing instructor and Software Test Engineer at VOIS)
* Skills dynamix
* Selenium WebDriver documentation
* Mayar Magdy, who was a pleasure to work with throughout the diploma.

---

## Contributors

* Project Owner: DEPI through Skills Dynamix

* Collaborators: Mayar Magdy, Ahmed Saeed

* Contributions are welcome via pull requests

  ---

## Contact

Mayar Magdy  -[Linkedin](https://www.linkedin.com/in/mayar-magdy-2bb28b290/) - [Github](https://github.com/MayarMagdy24)
Ahmed Saeed  - [Linkedin](https://www.linkedin.com/in/ahmed-saeed1521998/) - [Github](https://github.com/Ahmad-Saeeed)
