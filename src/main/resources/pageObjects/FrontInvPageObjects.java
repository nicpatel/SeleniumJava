package main.resources.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.resources.library.TestBase;


public class FrontInvPageObjects extends TestBase {
	
	
	
	public FrontInvPageObjects (WebDriver driver)
	{
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id="FORMLOGINid")
	WebElement txtUserName;
	
	@FindBy (id="FORMLOGINpwd")
	WebElement txtPassword;
	
	@FindBy (id="btSubmit")
	WebElement btnLogin;
	
	@FindBy (id="lbtnLogout")
	WebElement btnLogout;
	
	@FindBy (id="id_current_user_name")
	WebElement currentUserName;
	
	@FindBy (xpath="//div[contains(text(),'Deals')]")
	WebElement txtDeals;
	
	
	
	public WebElement userName() { return txtUserName; }
	
	public WebElement password() { return txtPassword; }
	
	public WebElement loginBtn() { return btnLogin; }
	
	public WebElement currentUser() {return currentUserName;}
	
	public WebElement logoutBtn() { return btnLogout; }
	
	public WebElement dealsLink() { return txtDeals; }
	
	public WebElement findBtn() { return btnFind; }

 }
