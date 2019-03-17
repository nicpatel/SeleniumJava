package main.resources.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import main.resources.pageObjects.FrontInvPageObjects;


public class FrontInv_Common extends FrontInvPageObjects{
	
	public FrontInv_Common(WebDriver driver) {
		
		super(driver);
	}
	

	public static FrontInvPageObjects fiBy = new FrontInvPageObjects(driver);
	
	
	public static void frontInv_Login(String userName, String password)
	{
		
		fiBy = new FrontInvPageObjects(driver);
		waitForElement(fiBy.userName(), 30);
		//driver.findElement(By.id("FORMLOGINid")).sendKeys(userName);
		fiBy.userName().sendKeys(userName);
		fiBy.password().sendKeys(password);
		
		fiBy.loginBtn().click();
		 
		waitForElement(fiBy.currentUser(), 30);
		
		System.out.println("FrontInvest login is successful");
	}
	
	public static void logout()
	{
		
		waitForElement(fiBy.logoutBtn(), 30);
		fiBy.logoutBtn().click();
		System.out.println("Logged out of FrontInvest");
		
		
	}
	
	public static void selectDeals() throws InterruptedException
	{
		
		fiBy.dealsLink().click();

		
		WebElement newDeal = driver.findElement(By.xpath("//div[@class='class_studio_bottombar_special_button'][contains(text(),'New')]"));
     	waitForElement(newDeal,30);
     	
     	newDeal.click();
     	Thread.sleep(8000);
     	WebElement dealName = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[3]/td[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[26]/div[3]/input[1]"));
     	
     	waitForElement(dealName,30);
     	dealName.sendKeys("KP Direct Inv-CompuLynx");
     	
     	String dealNo = driver.findElement(By.xpath("//div[26]//div[3]//input[2]")).getAttribute("Placeholder");
     	//Select workFlow = new Select(driver.findElement(By.xpath("//div[26]//div[3]//div[1]//select[1]")));
     	//workFlow.selectByVisibleText("Direct Investment");
     	
	}
	
}
