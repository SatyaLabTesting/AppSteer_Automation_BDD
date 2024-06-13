package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageFactory.DriverFactory;
import utils.utils;

public class AppSpace_Page {
	private WebDriver driver;
	 utils util = new utils(DriverFactory.getDriver());
	 
	 private  By appspaceIcon= By.xpath("//i[@class='icon-device']");
	 private  By createIcon= By.xpath("(//button[@icon='pi icon-plus'])[1]");
	 private  By AppSpacePopup= By.xpath("//div[text()='Add Appspace']");
		private By messageNotification = By.xpath("(//div[contains(@class,'p-toast-message-text')]//div)[2]");
		private By GroupsDD = By.xpath("//div[text()='Groups']//parent::div//following-sibling::*[@formcontrolname='appspaceGroup']");

	 
		public AppSpace_Page(WebDriver driver) {
			this.driver = driver;
		}
		public void clickOnAppSpaceIcon() throws InterruptedException {
			driver.findElement(appspaceIcon).click();
			Thread.sleep(1000);
		}
		public void ClickOnAddIcon() {
			WebElement ele= driver.findElement(createIcon);
			util.waitforElementToBeVisible(ele);
			util.waitForElementToBeClickable(ele);
			ele.click();
		}
		public void verifyCreateNewAppSpace() {
		WebElement ele= driver.findElement(AppSpacePopup);
		util.waitforElementToBeVisible(ele);
		if(ele.isDisplayed()) {
			System.out.println("Create new Appspace pop-up is displayed");
		}
}
		public void ClickOnAppSpace_Name(String AppSpace_btn, String AppSpace_Name) {
			WebElement ele = driver.findElement(By.xpath("//div[text()='"+AppSpace_btn+"']//parent::div//following-sibling::input[@placeholder='Add Appspace']"));
			if (ele.isDisplayed()) {
				ele.sendKeys(AppSpace_Name);

			}
		}
		public void ClickOnAppSpace_Desc(String Desc_btn, String Desc_Name) {
			WebElement ele = driver.findElement(By.xpath("//div[text()='Description']//parent::div//following-sibling::textarea[@placeholder='Description']"));
			if (ele.isDisplayed()) {
				ele.sendKeys(Desc_Name);

			}
		}
	    public String messageNotifications() {
	    	util.waitforElementToBeVisible(driver.findElement(messageNotification));
	        String text = driver.findElement(messageNotification).getText().toString();
	        return text;
	        }
		public void formCategoryDropDownList(String grpData) throws InterruptedException
		{
			driver.findElement(GroupsDD).click();
			Thread.sleep(2000);
			WebElement ele= driver.findElement(By.xpath("//span[@class='ng-star-inserted' and text()='"+grpData+"']"));
			Actions act=new Actions(driver);
			act.moveToElement(ele).click().perform();
	        act.moveByOffset(100, 100).click().perform();

}
		public void ClickOnAppTypes_Desc(String Desc_btn, String Desc_Name) {
			WebElement ele = driver.findElement(By.xpath("//div[text()='"+Desc_btn+"']//parent::div//following-sibling::textarea[@placeholder='"+Desc_btn+"']"));
			if (ele.isDisplayed()) {
				ele.sendKeys(Desc_Name);
			}
		}
}
