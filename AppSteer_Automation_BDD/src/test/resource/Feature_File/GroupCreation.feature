#Author: satya.sunderbal@isteer.com
@tag
Feature: Appspace creation

  Background: 
    Given I have launched "url" for Appsteer portal page
    When I have logged in using valid "username" and "password"
    Then I should be logged in successfully

  @GroupCreation1
  Scenario: Creating a new Group
    Given I navigated to settings page
    And I click on Group Management
    And I click on Add Group button
    Then I Validate Add Group page displayed
    And I enter data as "groupname" under "Name"
    And I enter data as "description_text" under "Description"
    When I clicked on "CREATE" button
    Then I validate success notifications as "Group Created Successfully"

  @GroupCreation2
  Scenario: Deleting the existed Group
    Given I navigated to settings page
    And I click on Group Management
    And I search on "groupname" in the search bar
    And I click on Delete icon for "groupname"
    And I got delete confirmation popup
    When I click on "Delete" confirmation
    Then I validate success notifications as "Group Deletion Success"
