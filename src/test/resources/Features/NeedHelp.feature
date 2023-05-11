@regression
Feature: Reset Password test
  As a user
  I would like to seek help to reset the password
  So that I can login again to Hudl

  @needHelp
  Scenario: Need help to log in
    Given I am on Hudl Home page
    When I click on LogIn button
    Then Verify Hudl login page is displayed
    When I click on Need Help? link
    Then Verify the Login Help page is displayed
    When I enter the email address for resetting the password
    And I click on Send Password Reset button
    Then Verify the email has successfully sent to the user

  @invalidUserToResetPass @negative
  Scenario: User does not exist in Hudl to reset the password
    Given I am on Hudl Home page
    When I click on LogIn button
    Then Verify Hudl login page is displayed
    When I click on Need Help? link
    Then Verify the Login Help page is displayed
    When I enter the invalid email address for resetting the password
    And I click on Send Password Reset button
    Then Verify error message for invalid user in help page