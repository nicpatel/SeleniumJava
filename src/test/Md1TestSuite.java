package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.resources.library.Md1_Common;
import main.resources.library.TestBase;


public class Md1TestSuite extends TestBase {
	
	//public Md1_Common mdCommon = new Md1_Common(driver);  //this will require if we use non-static methods in the class we are calling  
	
	@BeforeTest
	public void setUp() {
		driver = initializeDriver();
		System.out.println("===  Test Started  ===");
	}
	

	//public static void main(String[] args) throws InterruptedException {
	/* Test method:Cash Deposit
	 * 
	 */
	@Test
	public void cashDeposit() throws InterruptedException { 
		
		
		String url= prop.getProperty("Md1Url");
		driver.get(url);
		String user = prop.getProperty("fcUser");
		String pass = prop.getProperty("fcPassword");
		
		Md1_Common.md1_Login(user, pass);
		Md1_Common.selectAccount("4137626NR");
		
		//mdCommon.deposit();  // if we use non-static then initialization required 
		Md1_Common.deposit();
		
		Md1_Common.logout();

	}
	

	/* Test Method:Cash Withdraw  
	 * 
	 */
	
	@Test
	public void cashWithdraw() throws InterruptedException { 
		
		//driver = initializeDriver();
		String url= prop.getProperty("Md1Url");
		driver.get(url);
		String user = prop.getProperty("fcUser");
		String pass = prop.getProperty("fcPassword");
		
		Md1_Common.md1_Login(user, pass);
		Md1_Common.selectAccount("4137626NR");
		
		Md1_Common.withdraw();
		
		Md1_Common.logout();

	}
	

	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("teardown executed-- Driver has been closed");
	}
	
	
	
	
}
