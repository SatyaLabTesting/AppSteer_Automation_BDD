package pages;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageFactory.DriverFactory;
import utils.utils;

public class FormCreation_Page {
	private WebDriver driver;
	 utils util = new utils(DriverFactory.getDriver());
	
		private By FormModule = By.xpath("//i[@class='icon-view_form']");
		private By CreateNewBlankForm = By.xpath("//i[@class='icon-new']");
		private By CreateNewFormValidation = By.xpath("//div//div[@class='title']");
		private By FormCatagory = By.xpath("//p-dropdown[@formcontrolname='typeId']");
		private By deleteForm = By.xpath("//span[@class='p-button-icon pi icon-delete']");
		private By SearchByGroupNameTextBox= By.xpath("//span[@class='p-input-icon-right']/input");

		
		// 2. Constructor of the page class:
		public FormCreation_Page(WebDriver driver) {
			this.driver = driver;
		}

		// 3. page actions: features(behavior) of the page the form of methods:
		public void clickOnFormModule() {
			driver.findElement(FormModule).click();
		}
		public void clickOnCreateNewBlankForm() {
			driver.findElement(CreateNewBlankForm).click();
		}
		public void verifyCreateNewBlankForm() {
		WebElement ele= driver.findElement(CreateNewFormValidation);
		util.waitforElementToBeVisible(ele);
		if(ele.isDisplayed()) {
			System.out.println("Create new form page is displayed");
		}
}
		public void ClickOnForm_Textbox(String textboxData, String textboxName) {
			WebElement ele = driver.findElement(By.xpath("(//*[contains(@placeholder,'"+textboxName+"')])[1]"));
			util.waitforElementToBeVisible(ele);
			if (ele.isDisplayed()) {
				ele.sendKeys(textboxData);

			}
}
		public void formCategoryDropDownList(String Cataegoryname) throws InterruptedException
		{
			driver.findElement(FormCatagory).click();
			Thread.sleep(2000);
			WebElement ele= driver.findElement(By.xpath("//span[@class='ng-star-inserted' and text()='"+Cataegoryname+"']"));
			Actions act=new Actions(driver);
			act.moveToElement(ele).click().perform();
		}
		public void clickOnSearchedFormModule(String groupname) throws InterruptedException {
			WebElement ele= driver.findElement(SearchByGroupNameTextBox);
			util.waitforElementToBeVisible(ele);
			if(ele.isDisplayed()) {
			ele.sendKeys(groupname);
			}
			Thread.sleep(10000);
			WebElement ele1=driver.findElement(By.xpath("(//div[text()='"+groupname+"'])[1]"));
			util.waitforElementToBeVisible(ele1);
			Thread.sleep(2000);
			util.waitForElementToBeClickable(ele1);
			ele1.click();

		}

		public void clickOndeleteForm() throws InterruptedException {
			WebElement ele = driver.findElement(deleteForm);
			util.waitForElementToBeClickable(ele);
			Thread.sleep(2000);
			ele.click();
		}
		public void formDetailsValidation(String formName, String formCatagory) {
			WebElement ele = driver.findElement(By.xpath("//div[@class='title' and text()=' "+formName+" ']"));
			util.waitforElementToBeVisible(ele);
			if(ele.isDisplayed()) {
			String actualformname =ele.getText().substring(0, formName.length());
			Assert.assertEquals(actualformname, formName);	
			}
			WebElement ele1 = driver.findElement(By.xpath("//span[@id='pr_id_40_label' and text()='"+formCatagory+"']"));
			util.waitforElementToBeVisible(ele1);
			if(ele1.isDisplayed()) {
			String actualformCatagory =ele1.getText().toString();
			Assert.assertEquals(actualformCatagory, formCatagory);	
			}
		}
		
}
