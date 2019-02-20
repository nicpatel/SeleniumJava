package main.resources.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.resources.library.TestBase;

public class Md1 extends TestBase {
	public static WebDriver driver;
	
	public Md1 (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id="ctrlLogin_UserName")
	WebElement txtUserName;
	
	@FindBy (id="ctrlLogin_Password")
	WebElement txtPassword;
	
	@FindBy (id="ctrlLogin_LoginButton")
	WebElement btnLogin;
	
	@FindBy (id="lbtnLogout")
	WebElement btnLogout;
	
	@FindBy (id="ts_findparty_UCFindParty_txtAccountNo")
	WebElement txtAccNumber;
	
	@FindBy (id="ts_findparty_UCFindParty_btnFindParty")
	WebElement btnFind;
	
	public WebElement userName() { return txtUserName; }
	
	public WebElement password() { return txtPassword; }
	
	public WebElement loginBtn() { return btnLogin; }
	
	public WebElement logoutBtn() { return btnLogout; }
	public WebElement accountNumber() { return txtAccNumber; }
	public WebElement findBtn() { return btnFind; }
	

}
