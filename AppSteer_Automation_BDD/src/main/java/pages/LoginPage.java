package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageFactory.DriverFactory;
import utils.utils;

public class LoginPage {

	 private WebDriver driver;
	 utils util = new utils(DriverFactory.getDriver());
			// 1. By Locators
	        private By emailId = By.xpath("//input[@type='text']");
			private By passwords = By.xpath("//input[@placeholder='Password']");
			private By signInButton = By.xpath("//button[@type='submit']");
		////////////////////////////////////////////////////////////////////
			  private By AppsteerLogo=By.xpath("//div[@class='appsteerlogo']");
			  private By userName= By.xpath("//input[@placeholder='Username']");
			  private By  passWord = By.xpath("//input[@placeholder='Password']");
			  private By  Loginbutton = By.xpath("//button[@type='submit']");
			  private By  Forgotpassword = By.xpath("//div[@class='forgotlabel']");
			  private By  messageNotification = By.xpath("(//div[contains(@class,'p-toast-message-text')]//div)[2]");
              private By ForgotPwdPage = By.xpath("//div[text()='Forgot Password']");
			  
			// 2. Constructor of the page class:
			public LoginPage(WebDriver driver) {
				this.driver = driver;
			}
			  

			// 3. page actions: features(behavior) of the page the form of methods:
			public boolean forgotPwdPage() {
				 boolean text= driver.findElement(ForgotPwdPage).isDisplayed();
			 return text;
			}
			
			  public void loginToAppsteer(String username,String password) throws InterruptedException
			  {
				  util.waitforElementToBeVisible(driver.findElement(userName));
				  driver.findElement(userName).sendKeys(username);
				  util.waitforElementToBeVisible(driver.findElement(passWord));
				  driver.findElement(passWord).sendKeys(password);
				  driver.findElement(Loginbutton).click();
				  Thread.sleep(1000);
			  }
			  public void VerifyLaunchAppsteer()
			  {
				  driver.findElement(AppsteerLogo).isDisplayed();
				   System.out.println("Launching appsteer successfully");
			  }
			public String getLoginPageTitle() {
				return driver.getTitle();
			}

			public boolean isForgotPwdLinkExist() {
				return driver.findElement(Forgotpassword).isDisplayed();
			}
			public void clickOnForgotPWD() throws InterruptedException {
				 driver.findElement(Forgotpassword).click();
				 Thread.sleep(3000);
				 
			}
			public void enterUserName(String username) {
				driver.findElement(emailId).sendKeys(username);
			}

			public void enterPassword(String pwd) {
				driver.findElement(passwords).sendKeys(pwd);
			}

			public void clickOnLogin() {
				driver.findElement(signInButton).click();
		}
			public String ActualnotificationText() {
			   util.waitforElementToBeVisible(driver.findElement(messageNotification));
				String notificationText = driver.findElement(messageNotification).getText().toString();
			    System.out.println(notificationText);
			    return notificationText;
			}
		   
}
