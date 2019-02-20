package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.resources.library.TestBase;
import main.resources.pageObjects.Md1;

public class Md1Trading extends TestBase {

	public static WebDriver driver;
	public static void main(String[] args) {
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("Md1Url"));
		Md1 mdBy = new Md1(driver);
		mdBy.userName().sendKeys(prop.getProperty("fcuser"));
		mdBy.password().sendKeys(prop.getProperty("fcPassword"));
		mdBy.loginBtn().click();
		
		WebDriverWait wait = new WebDriverWait(driver,30); 
		wait.until(ExpectedConditions.visibilityOf(mdBy.logoutBtn()));
		
		driver.close();	

	}
}
