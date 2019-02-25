package main.resources.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import main.resources.pageObjects.Md1PageObjects;


public class Md1_Common extends Md1PageObjects{
	
	public Md1_Common(WebDriver driver) {
		
		super(driver);
	}
	

	public static Md1PageObjects mdBy = new Md1PageObjects(driver);
	
	
	public static void md1_Login(String userName, String password)
	{
		
		mdBy = new Md1PageObjects(driver);
		waitForElement(mdBy.userName(), 30);
		mdBy.userName().sendKeys(userName);
		mdBy.password().sendKeys(password);
		
		mdBy.loginBtn().click();
		 
		waitForElement(mdBy.logoutBtn(), 30);
		
		System.out.println("MD1 login is successful");
	}
	
	public static void logout()
	{
		//Md1PageObjects mdBy = new Md1PageObjects(driver); 
		waitForElement(mdBy.logoutBtn(), 30);
		mdBy.logoutBtn().click();
		System.out.println("Logged out of MD1");
		
		
	}
	
	public static void selectAccount(String accountNumber) throws InterruptedException
	{
		//Md1PageObjects mdBy = new Md1PageObjects(driver); // this requires only if we define this selectAccount() as the static  
		mdBy.accountNumber().sendKeys(accountNumber);
	
		mdBy.findBtn().click();
		WebElement find = driver.findElement(By.id("ts_UCDemographics_lblClientProfileTitle"));
     	waitForElement(find,30);
		WebElement tab = driver.findElement(By.id("ts_ctl01_upnlAccountList"));
		WebElement myTable = tab.findElement(By.className("DataTable"));
		
		List <WebElement> accLinks = myTable.findElements(By.tagName("a"));
		for (int i=0; i<accLinks.size();i++)
		{
			String accNum = accLinks.get(i).getText();
			if (accNum.equals(accountNumber))
			{
				accLinks.get(i).click();
				System.out.println("Account# "+ accNum + " has been selected");
				break;
			}
		}
	}
	
	
	public static void deposit() throws InterruptedException
	{
		WebElement overviewPage = driver.findElement(By.id("ts_pm_ctl00_lblAccountOverviewTitle"));
		waitForElement(overviewPage, 40);
		
		
		driver.findElement(By.id("ts_lm_lblCash")).click();
		driver.findElement(By.id("ts_lm_lblCashDeposit")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ts_pm_wiz_dtl_lblPageTitle")));
		Select bank = new Select(driver.findElement(By.id("ts_pm_wiz_dtl_ddlSettlementOption")));
		bank.selectByVisibleText("Bank account");
		Select bankAcc = new Select(driver.findElement(By.id("ts_pm_wiz_dtl_ddlBankAccount")));
		
		bankAcc.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.id("ts_pm_wiz_dtl_txtAmount")).sendKeys("11");
		Thread.sleep(2000);
		Select source = new Select(driver.findElement(By.id("ts_pm_wiz_dtl_AdditionalInformation1_ddlSourceOfTrade")));
		source.selectByVisibleText("Face-to-Face");
		Thread.sleep(3000);
		driver.findElement(By.id("ts_pm_wiz_StartNavigationTemplateContainerID_btnNext")).click();
		WebElement confirmPage = driver.findElement(By.id("ts_pm_wiz_vfy_lblPageTitle"));
		
		waitForElement(confirmPage, 40);
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$ctl00$ts$pm$wiz$StepNavigationTemplateContainerID$btnSubmit")).click();
		Thread.sleep(5000);
		System.out.println("Cash Deposit order placed");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Deposit cash - Confirmation")));
		
		
	}
	
	
	public static void withdraw() throws InterruptedException
	{
		WebElement overviewPage = driver.findElement(By.id("ts_pm_ctl00_lblAccountOverviewTitle"));
		waitForElement(overviewPage, 40);
		
		
		driver.findElement(By.id("ts_lm_lblCash")).click();
		driver.findElement(By.id("ts_lm_lblWithdrawCash")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ts_pm_wiz_dtl_lblPageTitle")));
		Select bank = new Select(driver.findElement(By.id("ts_pm_wiz_dtl_ddlSettlementOption")));
		bank.selectByVisibleText("Bank account");
		Select bankAcc = new Select(driver.findElement(By.id("ts_pm_wiz_dtl_ddlBankAccount")));
		
		bankAcc.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.id("ts_pm_wiz_dtl_txtAmount")).sendKeys("11");
		Thread.sleep(2000);
		Select reason = new Select(driver.findElement(By.id("ts_pm_wiz_dtl_ddlWithdrawReason")));
		reason.selectByIndex(1);
		Thread.sleep(3000);
		
		Select source = new Select(driver.findElement(By.id("ts_pm_wiz_dtl_AdditionalInformation1_ddlSourceOfTrade")));
		source.selectByVisibleText("Face-to-Face");
		Thread.sleep(3000);
		driver.findElement(By.id("ts_pm_wiz_StartNavigationTemplateContainerID_btnNext")).click();
		WebElement confirmPage = driver.findElement(By.id("ts_pm_wiz_vfy_lblPageTitle"));
		
		waitForElement(confirmPage, 40);
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$ctl00$ts$pm$wiz$StepNavigationTemplateContainerID$btnSubmit")).click();
		Thread.sleep(5000);
		System.out.println("Cash Withdraw order placed");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Deposit cash - Confirmation")));
		
		
	}
	
	
	
}
