@regression @login
Feature: Login as organisation with Hudl Tests
  As an org
  I would like to login to Hudl
  So that I can start my journey with them

  @orgLogIn
  Scenario: Login as an organisation
    Given I am on Hudl Home page
    When I click on LogIn button
    Then Verify Hudl login page is displayed
    When I click on Log In with an Organisation button
    Then Verify Hudl login as organisation page is displayed
    When I enter the details to login as Org
    And I click on Log In button in org page
    Then Verify the error message is displayed for an org
