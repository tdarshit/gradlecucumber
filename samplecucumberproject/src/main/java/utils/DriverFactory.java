package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
	
	public static DriverFactory driverFactory;
	public static WebDriver driver;
	public static WebDriverWait webDriverWait;
	public final static int TIME_OUT = 30;
	public final static int PAGE_LOAD_TIMEOUT = 50;
	
	
	public DriverFactory() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		webDriverWait = new WebDriverWait(driver, TIME_OUT);
		
		driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
	}
	
	public static void getUrl(String url) {
		driver.get(url);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() {
		if(driverFactory==null) {
			driverFactory = new DriverFactory();
		}
	}
	
	public static void shutDown() {
		if(driver != null) {
			driver.close();
			driver.quit();
		}
		
		driverFactory = null;
	}
	
	public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

}
