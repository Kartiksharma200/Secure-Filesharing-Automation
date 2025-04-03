# Secure Filesharing Automation

## **Overview**

Secure Filesharing Automation is a project designed to automate file sharing securely while ensuring thorough testing through both manual and automation testing. This project follows a structured testing approach using Page Object Model (POM) and TestNG, with test planning and execution based on a detailed test plan and test summary.

## Features

- Secure File Transfer: Encrypts files before transmission to protect sensitive data.

- Automated Testing: Implements test automation using Selenium, TestNG, and POM.

- Manual Testing: Comprehensive test plans and test cases executed manually.

- User Authentication Testing: Ensures only authorized users can access shared files.

- Logging & Monitoring: Tracks test results and logs for security and debugging.


## Technologies Used

- Programming Language: Java
- Automation Framework: Selenium WebDriver, TestNG
- Build Tool: Maven
- Reporting: Extent Reports, TestNG Reports
- Version Control: GitHub

## Project Structure
~~~
kartiksharma200-secure-filesharing-automation/
├── README.md
├── LICENSE
└── SecureFileSharing-Automation/
    ├── pom.xml
    ├── testng.xml
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── com/
    │   │           ├── pageObjects/
    │   │           │   ├── loginPage.java
    │   │           │   ├── signupPage.java
    │   │           │   └── uploadPage.java
    │   │           └── utils/
    │   │               ├── driverManager.java
    │   │               └── ExtentReportManager.java
    │   └── test/
    │       └── java/
    │           └── com/
    │               └── tests/
    │                   ├── e2e.java
    │                   ├── LoginTest.java
    │                   ├── SignupTest.java
    │                   └── uploadTest.java
    ├── target/
    ├── test-output/
    └── reports/
~~~
## Installation & Setup

**Prerequisites**

**Ensure you have the following installed:**

- Java JDK 8+
- Maven
- TestNG Plugin for IDE
- Selenium WebDriver
- Git

Clone the Repository
~~~
git clone https://github.com/Kartiksharma200/Secure-Filesharing-Automation.git
cd SecureFileSharing-Automation
~~~
## Running Tests

**Running Automated Tests**

To execute tests using TestNG, run:
~~~
mvn clean test
~~~
This will run all test cases as per testng.xml.

**Running Individual Test Cases**

To run specific tests, update the testng.xml file or use:
~~~
mvn test -Dtest=LoginTest
~~~
**Test Reports**

- After test execution, reports are generated in the test-output/ folder:
- extent-report.html for detailed reporting.
- testng-results.xml for XML-based test results.
- emailable-report.html for summarized test execution results.

## Manual Testing

**Test Plan & Test Summary**

Manual testing follows a structured test plan, ensuring:

- Functional Testing: Validates core features like login, signup, file upload.
- Security Testing: Ensures data encryption and secure authentication.
- UI/UX Testing: Confirms usability and user interface consistency.
- Regression Testing: Tests system stability after updates.

**Test Execution**

- Test cases are documented and executed manually.
- Defects are logged and tracked for resolution.

## Contribution Guidelines

- Fork the repository and create a new branch for your changes.
- Submit a pull request with a detailed description of your changes.
- Follow best practices in testing and automation.
## Explaination Video
  -  https://drive.google.com/drive/folders/1OXNZnnAWWv1eBoR93ysoLsvSOwaZ4hPb?usp=sharing
    
## License

This project is licensed under the MIT License - see the LICENSE file for details.
