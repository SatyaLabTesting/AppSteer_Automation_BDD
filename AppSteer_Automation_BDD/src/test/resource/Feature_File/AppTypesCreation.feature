#Author: satya.sunderbal@isteer.com
@tag
Feature: AppTypes creation

  Background: 
    Given I have launched "url" for Appsteer portal page
    When I have logged in using valid "username" and "password"
    Then I should be logged in successfully

  @AppTypes1
  Scenario Outline: Creating a new AppTypes
    Given I navigated to settings page
    And I click on "AppTypes" AppTypes
    And I click on "User Defined" UserDefined
    When I click on "CREATE NEW" Create new
    Then I Validate Add AppTypes page displayed
    And I enter data "AppTypes Name" under AppTypes Name as "AppTypesName"
    And I enter data "Description" under Description as "Description"
    When I clicked on "Add" button
    Then I validate success notifications as "App Type Created Successfully"
      @AppTypes2
  Scenario: Deleting the existed AppTypes
    Given I navigated to settings page
    And I click on "AppTypes" AppTypes
    And I click on "User Defined" UserDefined
    And I click on Delete Group for "AppTypesName"
    And I got delete confirmation popup
    When I click on "Delete" confirmation
    Then I validate success notifications as "App Type Deleted Successfully"
    

