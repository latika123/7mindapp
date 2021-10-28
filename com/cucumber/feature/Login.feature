#Author: Latika


@7Mind @login
Feature: 7Mind Meditation App - Login Feature
  Description: The purpose of this feature is to test the login functionality of 7Mind Meditation App.

  @TC_01 @negative
  Scenario: Verify that user is not able to login successfully
    Login with invalid credentials

    Given I am on the 7Mind Meditation App
    And I click on Login button
    And Enter invalid email and password login credentials
    Then Verify that user is not allowed to login
   
 @TC_02 @postive
  Scenario: Verify that user is able to login successfully
    Login with valid credentials

    Given I am on the 7Mind Meditation App
    And I click on Login button
    And Enter valid email and password login credentials
    Then Verify that user is allowed to login
    
 @TC_03 @negative @bug
  Scenario: Verify that valiadtion for email field while login
    Login with email having length more than specifield length and invalid email format.

    Given I am on the 7Mind Meditation App
    And I click on Login button
    And Enter invalid email format
    Then Verify that email validation error message should appear  
    
  @TC_03 @negative @bug
  Scenario: Verify that valiadtion for password field while login
    Login with email having length more than specifield length and invalid email format.

    Given I am on the 7Mind Meditation App
    And I click on Login button
    And Enter invalid password format
    Then Verify that password validation error message should appear   