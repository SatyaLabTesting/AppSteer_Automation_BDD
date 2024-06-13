package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageFactory.DriverFactory;
import utils.utils;

public class AppTypes_Page {
	private WebDriver driver;
	 utils util = new utils(DriverFactory.getDriver());

	// 1. By Locators
	private By settingsModule = By.xpath("//i[@class='icon-settings']");
	private By confirmationPopup = By.xpath("//div[@role='dialog']");
	private By messageNotification = By.xpath("(//div[contains(@class,'p-toast-message-text')]//div)[2]");
    
	// 2. Constructor of the page class:
	public AppTypes_Page(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:
	public void clickOnSettings() {
		driver.findElement(settingsModule).click();
	}

	public void ClickOnApptypes(String Apptypes) {	
		WebElement ele = driver
				.findElement(By.xpath("//div//a[text()=' " + Apptypes + " ']"));
		util.waitforElementToBeVisible(ele);
		util.waitForElementToBeClickable(ele);
		ele.click();
	}
    public String messageNotifications() {
	util.waitforElementToBeVisible(driver.findElement(messageNotification));
    String text = driver.findElement(messageNotification).getText().toString();
    return text;
    }
	public void ClickOnUser_Defined(String User_Defined) {
		WebElement ele = driver
				.findElement(By.xpath("//div[@class='ng-star-inserted' and text()='" + User_Defined + "']"));
		util.waitforElementToBeVisible(ele);
		util.waitForElementToBeClickable(ele);
		ele.click();
	}

	public void ClickOnCreateNewbutton(String CreateNewbutton) {
		WebElement ele = driver
				.findElement(By.xpath("//span[@class='p-button-label' and text()='" + CreateNewbutton + "']"));
		ele.click();
	}
	public boolean confirmationPopupDisplayed() {
		WebElement ele= driver.findElement(confirmationPopup);
		util.waitforElementToBeVisible(ele);
	return ele.isDisplayed();
}
	public void ClickOnAddBtn(String add) {
		driver.findElement(By.xpath("//span[@class='p-button-label' and text()='"+add+"']")).click();
	}
	public void deleteAppspace(String delete) {
		driver.findElement(By.xpath("//span[@class='p-button-label' and text()='"+delete+"']")).click();

	}
	public void deleteAppspaceGrp(String grp) {
		WebElement ele=driver.findElement(By.xpath("//span[text()='"+grp+" ']//parent::td//following-sibling::td//button[@icon='icon-delete']"));
		util.waitforElementToBeVisible(ele);
		ele.click();

	}
	public void ClickOnAppTypes_Name(String AppTypes_btn, String AppTypes_Name) {
		WebElement ele = driver.findElement(By.xpath("//div//span[text()='" + AppTypes_btn
				+ "']//parent::div//following-sibling::input[@placeholder='Type Name']"));
		if (ele.isDisplayed()) {
			ele.sendKeys(AppTypes_Name);

		}
	}

	public void ClickOnAppTypes_Desc(String Desc_btn, String Desc_Name) {
		WebElement ele = driver.findElement(By.xpath("//div//span[text()='" + Desc_btn
				+ " ']//parent::div//following-sibling::textarea[@placeholder='Description Text']"));
		if (ele.isDisplayed()) {
			ele.sendKeys(Desc_Name);

		}
	}
}
