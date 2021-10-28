# 7mindapp
Automated Login functionality of 7mindapp using BDD Framework with Cucumber, Appium, Testng and Java etc.


Prerequisite

Below is a list of tools or frameworks that has to be installed.
Java (JDK 8 from Oracle or OpenJDK)
Eclipse IDE 
Cucumber Plugin
Appium
Maven 3
Log4J2, TestNg, and JUnit
Android SDK or Android Studio

Make sure appium server is up and running before executing the script(Appium Desktop) and set up is done properly.


Script Description

Feature File: Login.feature file in cucumber.feature folder package in com folder

Step Definition: BaseSteps have generic functions and HomePageSteps have the glue code of login.feature with specific functions related to login etc. in cucumber.steps java package.

Runner File: RunCucumberFeatures is a java file for initiating the run that includes cucumber reporting configuration as well.

Resources: It contains the json for handling known bugs, config.properties file which contains key and value pair of the device information where the test needs to be executed and debugOR.properties file which contain the mobile element identification with text,xpath, id etc.

Utils Package: It contains Driver factory and Driver Manager java files which is used to configure driver.

Results/TestOutput:
After the execution the cucumber-reports are stored in target folder such as index.html etc.

