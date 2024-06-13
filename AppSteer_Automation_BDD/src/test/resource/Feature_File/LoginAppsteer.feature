#Author: satya.sunderbal@isteer.com

@loginPage @sanity
Feature: Login Functionality for Appsteer page.

  Background: 
    Given I have launched "url" for Appsteer portal page

  @tag1 @sanityrun
  Scenario Outline: Successful login with valid credentials
    When I have logged in using valid username" and "password"
    Then I should be logged in successfully

  @tag2
  Scenario: Unsuccessful login with invalid or empty credentials
    When I have logged in using valid "InValidUN" and "InValidPWD"
    Then I should see an error message indicating "Invalid Credentials"

  @tag3 @sanityrun
  Scenario: Navigating to the Forgot password page
    When I click on the "Forgot Password" link
    Then I should be redirected to the password reset page
    
