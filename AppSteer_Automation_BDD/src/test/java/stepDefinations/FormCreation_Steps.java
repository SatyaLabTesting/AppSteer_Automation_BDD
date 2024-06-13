package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.DriverFactory;
import pages.FormCreation_Page;
import pages.GroupCreation_Page;
import utils.ConfigReader;

public class FormCreation_Steps {
	private ConfigReader cr = new ConfigReader();
	FormCreation_Page fc = new FormCreation_Page(DriverFactory.getDriver());
	GroupCreation_Page gp = new GroupCreation_Page(DriverFactory.getDriver());

	@And("I click on Form Module")
	public void i_click_on_form_Module() throws InterruptedException {
		fc.clickOnFormModule();
		Thread.sleep(2000);
	}

	@When("I click on Create new blank form button")
	public void i_click_on_create_new_blank_form_button() {
		fc.clickOnCreateNewBlankForm();
	}

	@Then("I Validate Create new form page displayed")
	public void i_validate_create_new_form_page_displayed() {
		fc.verifyCreateNewBlankForm();
	}

	@And("I enter Form data as {string} under {string}")
	public void i_enter_form_data_as_under(String data, String name) {
		fc.ClickOnForm_Textbox(cr.getProperty(data), name);
	}

	@And("I choose Form catagory as {string}")
	public void i_choose_form_catagory_as(String string) throws InterruptedException {
		fc.formCategoryDropDownList(cr.getProperty(string));
	}

	@Then("I search on {string} in the search bar and clicked it")
	public void i_search_on_in_the_search_bar_and_clicked_it(String data) throws InterruptedException {
		fc.clickOnSearchedFormModule(cr.getProperty(data));
	}
	@Then("I click on Delete")
	public void i_click_on_delete() throws InterruptedException {
fc.clickOndeleteForm();
	}
	@Then("I validate Form name as {string}, Form catagory as {string}")
	public void i_validate_form_name_as_form_catagory_as(String formname, String formCatagory) {
fc.formDetailsValidation(cr.getProperty(formname), cr.getProperty(formCatagory));
	}
}
