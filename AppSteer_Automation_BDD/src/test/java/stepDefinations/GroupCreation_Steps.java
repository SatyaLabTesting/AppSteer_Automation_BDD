package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageFactory.DriverFactory;
import pages.GroupCreation_Page;
import utils.ConfigReader;

public class GroupCreation_Steps {
	private ConfigReader cr = new ConfigReader();

	GroupCreation_Page gp = new GroupCreation_Page(DriverFactory.getDriver());
	
	@Given("I click on Group Management")
	public void i_click_on_group_management() {
    gp.clickOnGroupManagement();
	}

	@Given("I click on Add Group button")
	public void i_click_on_add_group_button() {
    gp.clickOnAddGroup();
	}

	@Then("I Validate Add Group page displayed")
	public void i_validate_add_group_page_displayed() {
gp.verifyAddGroupPageDisplayed();
	}

	@Then("I enter data as {string} under {string}")
	public void i_enter_data_as_under(String grpName, String btn) {
gp.ClickOnEnterName_Textbox(cr.getProperty(grpName), btn);
	}
	@Given("I search on {string} in the search bar")
	public void i_search_on_in_the_search_bar(String groupname) throws InterruptedException {
gp.GroupNameTextBoxSearch(cr.getProperty(groupname));
Thread.sleep(2000);
	}
	@Given("I click on Delete icon for {string}")
	public void i_click_on_delete_icon_for(String groupname) {
gp.deleteGroup(cr.getProperty(groupname));
	}
}
