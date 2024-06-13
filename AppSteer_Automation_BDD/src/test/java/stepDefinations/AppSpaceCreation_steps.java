package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.DriverFactory;
import pages.AppSpace_Page;
import utils.ConfigReader;
import utils.utils;

public class AppSpaceCreation_steps {
	private AppSpace_Page As = new AppSpace_Page(DriverFactory.getDriver());
	private ConfigReader cr = new ConfigReader();
	utils util = new utils(DriverFactory.getDriver());

	@Then("I click on AppSpace icon")
	public void i_click_on_app_space_icon() throws InterruptedException {
		As.clickOnAppSpaceIcon();
	}

	@When("I click on Add icon")
	public void i_click_on_add_icon() {
		As.ClickOnAddIcon();
	}

	@Then("I Validate Add Appspace page displayed")
	public void i_validate_add_appspace_page_displayed() {
		As.verifyCreateNewAppSpace();
	}

	@Then("I enter data {string} under Appspace Name as {string}")
	public void i_enter_data_under_appspace_name_as(String string, String string2) throws InterruptedException {
		Thread.sleep(5000);
		As.ClickOnAppSpace_Name(string, cr.getProperty(string2));
	}

	@Then("I enter data as {string} under Groups")
	public void i_enter_data_as_under_groups(String string) throws InterruptedException {
		As.formCategoryDropDownList(cr.getProperty(string));

	}

	@Then("I enter {string} data under {string}")
	public void i_enter_data_under(String string, String string2) {
		As.ClickOnAppTypes_Desc(string, cr.getProperty(string2));

	}
}
