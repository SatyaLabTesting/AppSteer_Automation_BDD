#Author: satya.sunderbal@isteer.com
@formCreationTc
Feature: Appspace creation

  Background: 
    Given I have launched "url" for Appsteer portal page
    When I have logged in using valid "username" and "password"
    Then I should be logged in successfully

  @FormCreation1
  Scenario: Creating a new Form
    And I click on Form Module
    When I clicked on "Create New" button
    And I click on Create new blank form button	
    Then I Validate Create new form page displayed
    And I enter Form data as "Formname" under "Form"
    And I choose Form catagory as "FormCatagory"
    And I enter Form data as "Desc" under "Description"
    When I clicked on "Create" button
    Then I validate success notifications as "App Created Successfully"
    
    
  @FormCreation2
  Scenario: Validating the created Form
    And I click on Form Module
    When I search on "Formname" in the search bar and clicked it
    Then I validate Form name as "Formname", Form catagory as "FormCatagory"


  @FormCreation3
  Scenario: Deleting the existed Form
    And I click on Form Module
    And I search on "Formname" in the search bar and clicked it
    And I click on Delete
    And I got delete confirmation popup
    When I click on "Delete" confirmation
    Then I validate success notifications as "App Deleted Successfully"
