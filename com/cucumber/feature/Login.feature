#Author: Latika


@7Mind @login
Feature: 7Mind Meditation App - Login Feature
  Description: The purpose of this feature is to test the login functionality of 7Mind Meditation App.

  @TC_01 @negative
  Scenario: Verify that user is not able to login successfully
    Login with invalid credentials

    Given I am on the 7Mind Meditation App
    And I click on Login button
    And Enter invalid email login credentials
    Then Verify that user is not allowed to login
   
 @TC_02 @postive
  Scenario: Verify that user is able to login successfully
    Login with valid credentials

    Given I am on the 7Mind Meditation App
    And I click on Login button
    And Enter valid email login credentials
    Then Verify that user is allowed to login