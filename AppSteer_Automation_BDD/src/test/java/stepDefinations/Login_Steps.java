package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.DriverFactory;
import pages.LoginPage;
import utils.ConfigReader;
import utils.utils;

public class Login_Steps {
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	private ConfigReader cr = new ConfigReader();
	private utils util = new utils(DriverFactory.getDriver());

	@Given("I have launched {string} for Appsteer portal page")
	public void i_have_launched_for_appsteer_portal_page(String url) {
		DriverFactory.getDriver().get(cr.getProperty(url));
		util.waitForPage();
	}
	@When("I have logged in using valid {string} and {string}")
	public void i_have_logged_in_using_valid_and(String UN, String PWD) throws InterruptedException {
	   	 lp.loginToAppsteer(cr.getProperty(UN), cr.getProperty(PWD));
	}
	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		System.out.println(lp.getLoginPageTitle());
	}
	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating(String expText) {
		String ActualText=lp.ActualnotificationText();
		String expectedText = expText ;
        assert ActualText.equals(expectedText) : String.format("Notification content is not as expected. Expected: %s, Actual: %s", expectedText, ActualText);

	}
	@When("I click on the {string} link")
	public void i_click_on_the_link(String string) throws InterruptedException {
System.out.println(lp.isForgotPwdLinkExist());
lp.clickOnForgotPWD();

	}

	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() {
if(lp.forgotPwdPage()) {
	System.out.println("Password reset page is displayed");
}

	}
}
