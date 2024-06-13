package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageFactory.DriverFactory;
import utils.ConfigReader;
import utils.utils;

import java.util.Properties;


public class Hook {
	private DriverFactory dv;
	private WebDriver driver;
	private ConfigReader cr;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		cr = new ConfigReader();
		prop = cr.init_prop();
	}

	@Before(order = 1)
	public void launchAppSteer() {
		dv = new DriverFactory();
		String browserName = prop.getProperty("browser");
		dv.init_driver(browserName);
		driver=DriverFactory.getDriver();
	}

//	public void setUp() {
//		System.out.println("Initializing WebDriver");
//		if (configReader.getProperty("browser").equals("chrome")) {
//			DriverFactory.createInstance("chrome");
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--disable-notifications");
//			driver = new ChromeDriver(options);
//			util.maximizeWindow();
//			System.out.println("chrome launched successfully");
//		}
//	}


	@After(order = 0)
	public void quitBrowser() throws InterruptedException {
		System.out.println("Closing Browser");
        if (driver != null) {
        	driver.quit();
    		System.out.println("Closed Browser");

    }
}
}