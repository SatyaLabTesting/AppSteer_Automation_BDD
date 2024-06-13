package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageFactory.DriverFactory;
import utils.utils;

public class GroupCreation_Page {
	private WebDriver driver;
	 utils util = new utils(DriverFactory.getDriver());

	// 1. By Locators
	private By GroupManagement= By.xpath("//a[@href='#/a/settings/group-manage']");
	private By ADDGroup= By.xpath("//button[@class='p-element add-group p-button p-component']//span");
	private By AddGroupPageDisplayed= By.xpath("//div[@role='region']");
	private By SearchByGroupNameTextBox= By.xpath("//span[@class='p-input-icon-right']/input");
	// 2. Constructor of the page class:
	public GroupCreation_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	// 3. page actions: features(behavior) of the page the form of methods:
	public void clickOnGroupManagement() {
		util.waitforElementToBeVisible(driver.findElement(GroupManagement));
		driver.findElement(GroupManagement).click();
	}
public void clickOnAddGroup() {
	util.waitforElementToBeVisible(driver.findElement(ADDGroup));
	driver.findElement(ADDGroup).click();
}
public void verifyAddGroupPageDisplayed() {
	WebElement ele= driver.findElement(AddGroupPageDisplayed);
util.waitforElementToBeVisible(ele);
if(ele.isDisplayed()) {
	System.out.println("Add group page is displayed");
}
}
public void ClickOnEnterName_Textbox(String textboxData, String textboxName) {
	String lowerCase_data=textboxName.toLowerCase();
	WebElement ele = driver.findElement(By.xpath("//div[text()=' "+textboxName+" ']//parent::div//following-sibling::*[@formcontrolname='"+lowerCase_data+"']"));
	util.waitforElementToBeVisible(ele);
	if (ele.isDisplayed()) {
		ele.sendKeys(textboxData);

	}

}
public void GroupNameTextBoxSearch(String groupname) {
	WebElement ele= driver.findElement(SearchByGroupNameTextBox);
util.waitforElementToBeVisible(ele);
if(ele.isDisplayed()) {
ele.sendKeys(groupname);
}
}

public void deleteGroup(String grpName) {
	WebElement ele= driver.findElement(By.xpath("//div[text()='"+grpName+"']//parent::td/..//div//span[@class='p-button-icon icon-delete']"));
	util.waitforElementToBeVisible(ele);
	ele.click();

}
}
