package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> ThreadLocal = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ThreadLocal.set(new ChromeDriver());
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}

	public static synchronized WebDriver getDriver() {
		return ThreadLocal.get();
	}
}
