package main.resources.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase  {

	public static WebDriver driver;
	public static Properties prop;
	
	@SuppressWarnings("deprecation")
	public static WebDriver initializeDriver() 
	{
		
		try {
			prop = new Properties();
			FileInputStream fis;
			fis = new FileInputStream("C:\\Repos\\SeleniumJava\\src\\main\\resources\\data.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
	    }
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		if (browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
		}
		
		
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
			return driver;
	}
	
	
	public static void waitForElement(WebElement locator, int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(locator));
	}
	
}
