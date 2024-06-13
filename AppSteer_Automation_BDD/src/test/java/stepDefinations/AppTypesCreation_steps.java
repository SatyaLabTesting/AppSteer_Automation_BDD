package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.DriverFactory;
import pages.AppTypes_Page;
import utils.ConfigReader;
import utils.utils;

public class AppTypesCreation_steps {
	private AppTypes_Page Ap = new AppTypes_Page(DriverFactory.getDriver());
	private ConfigReader cr = new ConfigReader();
	 utils util = new utils(DriverFactory.getDriver());

	@Given("I navigated to settings page")
	public void i_navigated_to_settings_page() {
		Ap.clickOnSettings();
	}

	@Given("I click on {string} AppTypes")
	public void i_click_on_app_types(String str) throws InterruptedException {
		Ap.ClickOnApptypes(str);
		Thread.sleep(2000);
	}

	@Given("I click on {string} UserDefined")
	public void i_click_on_user_defined(String string) {
		Ap.ClickOnUser_Defined(string);
	}

	@When("I click on {string} Create new")
	public void i_click_on_create_new(String string) {
		Ap.ClickOnCreateNewbutton(string);
	}

	@Then("I Validate Add AppTypes page displayed")
	public void i_validate_add_app_types_page_displayed() {
		Ap.confirmationPopupDisplayed();
	}

	@Then("I enter data {string} under AppTypes Name as {string}")
	public void i_enter_data_under_app_types_name_as(String string1, String string2) {
		Ap.ClickOnAppTypes_Name(string1, cr.getProperty(string2));
	}

	@Then("I enter data {string} under Description as {string}")
	public void i_enter_data_under_description_as(String string1, String string2) {
		Ap.ClickOnAppTypes_Desc(string1, cr.getProperty(string2));

	}

	@When("I clicked on {string} button")
	public void i_clicked_on_button(String string) throws InterruptedException {
		Ap.ClickOnAddBtn(string);
		Thread.sleep(1000);
	}

	@Then("I validate success notifications as {string}")
	public void i_validate_success_notifications_as(String msg) {
		String notificationText = Ap.messageNotifications();
		System.out.println(notificationText);
		String expectedText = msg;
		assert notificationText.equals(expectedText) : String.format(
				"Notification content is not as expected. Expected: %s, Actual: %s", expectedText, notificationText);
	}

	@And("I click on Delete Group for {string}")
	public void i_click_on_delete_group_for(String grpName) {
		Ap.deleteAppspaceGrp(cr.getProperty(grpName));
	}

	@Given("I got delete confirmation popup")
	public void i_got_delete_confirmation_popup() {
		Ap.confirmationPopupDisplayed();
	}

	@When("I click on {string} confirmation")
	public void i_click_on_confirmation(String string) {
		Ap.deleteAppspace(string);
	}

}
