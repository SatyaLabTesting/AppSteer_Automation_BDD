#Author: satya.sunderbal@isteer.com
@tag
Feature: Appspace creation

  Background: 
    Given I have launched "url" for Appsteer portal page
    When I have logged in using valid "username" and "password"
    Then I should be logged in successfully

  @Appspace1
  Scenario Outline: Creating a new Appspace
    And I click on AppSpace icon
    When I click on Add icon
    Then I Validate Add Appspace page displayed
    And I enter data "Appspace Name" under Appspace Name as "Appspacename"
    And I enter data as "GroupsData" under Groups
    And I enter "Description" data under "Description"
    When I clicked on "Submit" button
    Then I validate success notifications as "Appspace created successfully!"
