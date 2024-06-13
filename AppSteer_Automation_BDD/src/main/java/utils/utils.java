package utils;
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.Iterator;
	import java.util.Random;
	import java.util.Set;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.common.io.Files;

import pageFactory.DriverFactory;
	/**
	 * This Class consists of generic methods related to webdriver actions
	 * @author satya_isteer
	 *
	 */
	public class utils {
		/**
		 * This will maximize the window
		 * @param driver
		 */
		 //static WebDriver driver= DriverFactory.getDriver();
		 private WebDriver driver;
	    public utils(WebDriver driver) {
			this.driver = driver;
		}
		public void maximizeWindow()
	    {
	    	driver.manage().window().maximize();
	    }
	    /**
	     * this method will minimize the window
	     * @param driver
	     */
	    public void minimizeWindow()
	    {
	    	driver.manage().window().minimize();
	    }
	    /**
	     * This method Will works as driver sleep you given time
	     * @param microsec
	     * @throws InterruptedException
	     */
	    public void waitWebDriver(int microsec) throws InterruptedException
	    {
	    	Thread.sleep(microsec);
	    }
	    /**
	     * this method will wait for the page load
	     * @param driver
	     * @param sec
	     */
		public void waitForPage()
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		/**
		 * This method will wait until the element becomes clckable 
		 * @param driver
		 * @param sec
		 * @param element
		 */
		public void waitforElementToBeVisible(WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		/**
		 * This method will wait until the element visible
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeClickable(WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		/**
		 * This method will Handle drpdown Based On Index
		 * @param element
		 * @param index
		 */
		public void handleDropDown(WebElement element, int index)
		{
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 * This method will Handle drpdown Based On Value
		 * @param element
		 * @param index
		 */
		public void handleDropDown(WebElement element, String value)
		{
			Select sel=new Select(element);
			sel.selectByValue(value);
		}
		/**
		 * This method will handle dropdown Based on VisibleText
		 * @param Text
		 * @param element
		 */
		public void handleDropDown(String Text,WebElement element )
		{
			Select sel=new Select(element);
			sel.selectByVisibleText(Text);
		}
		/**
		 * This method will perform mouse Hover Action
		 * @param driver
		 * @param element
		 */
		public void mouseHoverAction(WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		/**
		 * This method will perform Any Where in webPage
		 * @param driver
		 */
		public void rightClickActions()
		{
			Actions act=new Actions(driver);
			act.contextClick().perform();
		}
		/**
		 * This method will perform rightclick on WebElement
		 * @param driver
		 * @param element
		 */
		public void rightClickActions(WebElement element)
		{
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
			
		}
		/**
		 * This method will perform double click Any where on webpage
		 * @param driver
		 */
		public void doubleClickAction()
		{
			Actions act=new Actions(driver);
			act.doubleClick().perform();
		}
		/**
		 * this method perform single click operation on particular element
		 * @param driver
		 * @param element
		 */
		public void singleClickOnElement(WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).click().build().perform();
		}
		/**
		 * This method will perform double click Operation on particular WebElement
		 * @param driver
		 * @param element
		 */
		public void doubleClickAction(WebElement element)
		{
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();
		}
		public void SingleClickMouseAction()
		{
			Actions act=new Actions(driver);
			act.click().perform();
		}
		/**
		 * This method will perform drag and drog Action
		 * @param driver
		 * @param srcElement
		 * @param dstElement
		 */
		public void dragAndDrop(WebElement srcElement,WebElement dstElement)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(srcElement, dstElement).build().perform();;
		}
		/**
		 * This method will accept the alert
		 * @param driver
		 */
		public void acceptAlert()
		{
			driver.switchTo().alert().accept();
		}
		/**
		 * This method will dismiss The alert
		 * @param driver
		 */
		public void dismissAlert()
		{
			driver.switchTo().alert().dismiss();
		}
		/**
		 * This method will capture the text from Alert
		 * @param driver
		 * @return
		 */
		public String getAlertText()
		{
			return driver.switchTo().alert().getText();
		}
		/**
		 * This method will handle frame based on index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(int index)
		{
			driver.switchTo().frame(index);
		}
		/**
		 * This method will handle frame based on name or ID
		 * @param driver
		 * @param nameORid
		 */
		public void handleFrame(String nameORid)
		{
			driver.switchTo().frame(nameORid);
		}
		/**
		 * This method will handle frame based on WebElement
		 * @param driver
		 * @param element
		 */
		public void handleFrame(WebElement element)
		{
			driver.switchTo().frame(element);
		}
		/**
		 * This method will switch to immediate parent frame
		 * @param driver
		 */
		public void switchToParentFrame()
		{
			driver.switchTo().parentFrame();
		}
		/**
		 * this method will switch to default frame
		 * @param driver
		 */
		public void switchToDefaultFrame()
		{
			driver.switchTo().defaultContent();
		}
		/**
		 * This method will helps to move sub window
		 * @param driver
		 * @param mainID
		 */
		public void switchToSubWindow( String mainID)
		{
			Set<String> winIDS = driver.getWindowHandles();
			Iterator<String> itr=winIDS.iterator();
			if(itr.hasNext())
			{
				String AllId=itr.next();
				if(!AllId.contains(mainID))
				{
					driver.switchTo().window(AllId);
				}
				
				
			}
		}
		/**
		 * this method will helps to move main window
		 * @param driver
		 * @param mainID
		 */
		public void switchToWindowMainWindow( String mainID)
		{
			driver.switchTo().window(mainID);
		}
		/**
		 * Thsi method will takes screenshot and save it in required fields
		 * @param driver
		 * @param Screenshotname
		 * @return
		 * @throws IOException
		 */
		public String takeScreenShot(String Screenshotname) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dst=new File(".\\ScreenShots\\"+Screenshotname+".png");
			Files.copy(src, dst);
			return dst.getAbsolutePath();//used for extends reports..
		 }
		/**
		 * Thsi method will perform random Scroll DownWards Vertically
		 * @param driver
		 */
		public void scrollAction()
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)","");
		}
		/**
		 * This method will scroll until the element is identified in DOM
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebElement element)
		{
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			int y=element.getLocation().getY();
			jse.executeScript("window.scrollBy(0,"+y+")", element);
			
		}
		/**
		 * This method will perform java Script Action on particular element
		 * @param driver
		 * @param jscr
		 */
		public void ElementActionWithJavScript(String jscr)
		{
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript(jscr);
		}
		/**
		 * this method works as drag and drop by replacing Actions class
		 * @param driver
		 * @param srcElement
		 * @param tarElement
		 */
		 public  void dragAndDropByjavaScript( WebElement srcElement, WebElement tarElement) { //changed from static method
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
			                      + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
			                      + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
			                      + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
			                      + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
			                      + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
			                      + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
			                      + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
			                      + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
			                      + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
			                      + "var dropEvent = createEvent('drop');\n"
			                      + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
			                      + "var dragEndEvent = createEvent('dragend');\n"
			                      + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
			                      + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
			                      + "simulateHTML5DragAndDrop(source,destination);", srcElement, tarElement);
			 }
		 /**
		  * This method return random number upto you given number
		  * @param num
		  * @return
		  */
		  public int  RandomNumber(int num)
		  {
			  Random r=new Random();
			 int no= r.nextInt(num);
			 return no;
		  }
		  /**
		   * this methode is used to scroll the window with the help of robot class
		   * @param n
		   * @throws AWTException
		   */
		  public void keyBoardScrollDown(int n) throws AWTException
		  {
			  Robot r=new Robot();
			  for(int i=0;i<=n;i++)
			  {
			  r.keyPress(KeyEvent.VK_DOWN);
			  r.keyRelease(KeyEvent.VK_DOWN);
			  }
		  }
		  public void keyBoardScrollUP(int n) throws AWTException
		  {
			  Robot r=new Robot();
			  for(int i=0;i<=n;i++)
			  {
			  r.keyPress(KeyEvent.VK_UP);
			  r.keyRelease(KeyEvent.VK_UP);
			  }
		  }
		  public String removeSpace(String name)
		  {
			  String s=name;
			  String a=s.replaceAll(" ", "");
			  return a;
			 
			  
		  }
		  public void ZoomOutScreen(int numb) throws AWTException
		  {
			  Robot r=new Robot();
				 for(int i=0;i<=numb;i++)
				 {
					 r.keyPress(KeyEvent.VK_CONTROL);
					 r.keyPress(KeyEvent.VK_MINUS);
				     r.keyRelease(KeyEvent.VK_MINUS);
				     r.keyRelease(KeyEvent.VK_CONTROL);
				 }
		  }
		  
		  public  Date currentTime()
		  {
			  Calendar cal=Calendar.getInstance();
			  Date date=cal.getTime();
			  return date;
		  }
		
		}
	