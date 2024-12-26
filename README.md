# A Web Automation Project using ...

![image](https://github.com/user-attachments/assets/9fa0d164-de6d-4923-8b4b-73ce48a7f343)

# Table of Contents

1. [Introduction](#a-web-automation-project-using)
2. [🖥️ Features](#️-features)
3. [🧪 Test Cases Overview](#-test-cases-overview)
   - [1. `Q1_DigitalUnite`](#1-q1_digitalunite)
   - [2. `Q2_wpEverest`](#2-q2_wpeverest)
   - [3. `Q3_dsebd`](#3-q3_dsebd)
4. [🔒 Prerequisites](#-prerequisites)
5. [🚀 Project Setup](#-project-setup)
6. [🏗️ Directory Structure](#️-directory-structure)
7. [🔨 Configuration](#-configuration)
   - [`build.gradle`](#buildgradle)
   - [`MyUtils`](#myutils)
8. [🏷️ Known Issues](#️known-issues)


This project contains three test classes that automate various tasks using Selenium WebDriver with Java. Each class demonstrates a unique use case for web automation, including form submission, data scraping, and file handling.

---

## 🖥️ Features

- **Automated Form Filling and Validation**
    - Tests the form-filling process on two different websites.
    - Handles file uploads, checkbox clicks, and form submission validations.
- **Web Scraping**
    - Scrapes table data from a financial website and writes it to a text file.
- **Reusable Utility Functions**
    - Scroll, wait, and interact with web elements using utility methods.
- **Headless Browser Support**
    - Demonstrates scraping in a headless browser environment.

## 🧪 Test Cases Overview

### 1. `Q1_DigitalUnite`

Automates a form submission process on the [Digital Unite Practice Form](https://www.digitalunite.com/practice-webform-learners).

### Key Features:

- Handles cookie consent pop-ups.
- Fills out text fields with sample data.
- Uploads an image file and selects checkboxes.
- Submits the form and validates the confirmation message.

### Usage:

```java
@Test
void digitalUnite_formFillUp_confirmationMessage()
```

### 2. `Q2_wpEverest`

Automates the registration process on the [WP Everest Guest Registration Form](https://demo.wpeverest.com/user-registration/guest-registration-form/).

### Key Features:

- Randomized email and password generation.
- Selects dropdown values for nationality and country.
- Handles radio buttons, checkboxes, and calendar inputs.
- Validates success messages post-registration.

### Usage:

```java
@Test
void wpEverestFormFillUp_confirmationMessage()

```

### 3. `Q3_dsebd`

Scrapes table data from the [DSEBD Latest Share Price](https://dsebd.org/latest_share_price_scroll_by_value.php) page.

### Key Features:

- Operates in headless mode for efficient data extraction.
- Extracts HTML table data and writes it to a text file.
- Formats and logs the data for console output and storage.

### Usage:

```java
@Test
void scrapData_htmlTable_textFile()

```

## 🔒 Prerequisites

1. **Java Development Kit (JDK)**
    
    Ensure JDK 8+ is installed and configured.
    
2. **Gradle**
    
    Install Gradle or use the wrapper script provided.
    
3. **WebDriver**
    
    Download and configure the appropriate WebDriver 
    
4. **Dependencies**
    
    Add the following dependencies to your `build.gradle` file.
    
    - Selenium Java
    - JUnit 5
    - Any required utilities for file handling or browser-specific configurations.

## 🚀 Project Setup

1. Clone the repository:
    
    ```bash
    git clone https://github.com/your-username/selenium-automation-project.git
    cd selenium-automation-project
    ```
    
2. Build the project:
    
    ```bash
    ./gradlew build
    
    ```
    
3. Run the tests:
    
    ```bash
    ./gradlew test
    
    ```
    

## 🏗️ Directory Structure

```
src/
├── main/
│   ├── java/
│   └── resources/
└── test/
    ├── java/
    │   ├── Q1_DigitalUnite.java
    │   ├── Q2_wpEverest.java
    │   └── Q3_dsebd.java
    └── resources/
        ├── scrapData.txt
        └── myImage.jpg

```

## 🔨 Configuration

### `build.gradle`

Ensure the following dependencies are included in your `build.gradle`:

```
dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.27.0'
}
```

### `MyUtils`

- Custom Utility Class
- Includes helper methods for tasks like scrolling, waiting, and handling repetitive actions.

## 🏷️Known Issues

- **File Path Configuration:**
    
    Ensure the file paths for the resources (e.g., `myImage.jpg`, `scrapData.txt`) match your environment.
    
- **Delayed Form Validation:**
    
    Some forms might display confirmation messages with a delay. The tests account for such cases with dynamic waits.
