@regression @login
Feature: Login with Hudl Tests
  As a user
  I would like to login to Hudl
  So that I can start my journey with them

  @validLogIn
  Scenario: Login with valid credentials
    Given I am on Hudl Home page
    When I click on LogIn button
    Then Verify Hudl login page is displayed
    When I enter the details to login
    And I click on Log In button in login page
    Then Verify the success message should be displayed

  @invalidLogIn @negative
  Scenario: Login with invalid credentials
    Given I am on Hudl Home page
    When I click on LogIn button
    Then Verify Hudl login page is displayed
    When I enter the invalid details to login
      |    Field          |    Value          |
      |   email_address   |    email address2 |
      |   pass_word       |    pass word2     |
    And I click on Log In button in login page
    Then Verify the error message is displayed

  @emptyCredentials @negative
  Scenario: Login with empty credentials
    Given I am on Hudl Home page
    When I click on LogIn button
    Then Verify Hudl login page is displayed
    When I enter the empty details to login
      |    Field          |    Value         |
      |   email_address   |  email address2  |
    And I click on Log In button in login page
    Then Verify the error message is displayed

  @rememberMe
  Scenario: Check 'Remember me' while log in
    Given I am on Hudl Home page
    When I click on LogIn button
    Then Verify Hudl login page is displayed
    When I enter the details to login
    Then I click on Remember me checkbox
    When I click on Log In button in login page
    Then Verify the success message should be displayed

