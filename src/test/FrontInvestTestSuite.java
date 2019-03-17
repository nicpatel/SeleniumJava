package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.resources.library.FrontInv_Common;
import main.resources.library.TestBase;
import main.resources.pageObjects.FrontInvPageObjects;


public class FrontInvestTestSuite extends TestBase {
	

  //this will require if we use non-static methods in the class we are calling  
	
	@BeforeTest
	public void setUp() {
		driver = initializeDriver();
		System.out.println("===  Test Started  ===");
	}
	

	//public static void main(String[] args) throws InterruptedException {
	/* Test method:Create new deal
	 * 
	 */
	@Test
	public void createNewDeal() throws InterruptedException { 
		
		String url= prop.getProperty("eFrontUrl");
		driver.get(url);
		String user = prop.getProperty("entUser");
		String pass = prop.getProperty("entPassword");
		
		FrontInv_Common.frontInv_Login(user, pass);
		
		FrontInv_Common.selectDeals();
		
	
		
		//FrontInv_Common.logout();

	}
	

	/* Test Method:test2
	 * 
	 */

	public void test2() throws InterruptedException { 
		
		String url= prop.getProperty("eFrontUrl");
		driver.get(url);
		String user = prop.getProperty("entUser");
		String pass = prop.getProperty("entPassword");
		
		FrontInv_Common.frontInv_Login(user, pass);

	}
	

	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("teardown executed-- Driver has been closed");
	}
	
	
	
	
}
