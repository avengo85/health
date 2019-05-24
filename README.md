# Web UI Automation

This project includes a test for  [https://beta.caspar-health.com/](https://beta.caspar-health.com/).

The technology stack that is used:
* Selenium Webdriver
 * JAVA
 * Maven 
 * Extent Reports
 * WebDriverManager

### Prerequisites

In order to use these tests you need to install following software:


* [Maven](https://maven.apache.org/)
* [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (JDK)


### Installing

After cloning the project from Githab, you can either build it in your IDE (IntelliJ IDEA or Eclipse) or just go to the project folder and type in command line "mvn clean install".

## Parameters
At the catalogue **\src\test\resources** you can find **selenium.properties** file where you can specify base URL of the project, reports folder and browser where the test is executed. 

## Running the tests

You can execute tests either in IDE or just go to the project folder and type in command line "mvn test"  


## Results and reports

After every execution a folder named with timestamp is created where you can find HTML reports along with some statistics and screenshots in cases of failed tests. 


### Test Description

###### registerTest

This test opens Registration page, execute simple validation of text boxes, then fill them by valid data and register a new user. 

Checkings:
* Red border of text boxes and error messages next to them when email is invalid, password is short, repeated password does not match entered.
* Account page opens after successful registration.
* Message about successful registration is displayed.

###### loginSuccessDeleteAccountTest
runs only after successful finish of registerTest.

This test opens Login page, logs in as the user created during previous test, opens Personal Data page and deletes this account. 

Checkings:
* Account page opens after successful logging in.
* Message about successful logging in is displayed.
* Message about successful removing account is displayed.


###### addNewPatientTest

This test opens Login page, fills username and password fields by values provided, clicks 'LOGIN' button, clicks 'Add Patient' button, fills all required fields by test values, clicks 'SAVE' button, gets new user name and password, logs in as the user added, and checks 'terms of use' and 'release of medical information' links are displayed.  


## Author

 **Alexander Ognev** 
