package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserLogInPage {
WebDriver driver;

	
	public UserLogInPage(WebDriver d) {
	
	driver = d;
	PageFactory.initElements(d, this);// additional method
}
	// Mapped with User ID on User Portal Log In page
	@FindBy(id = "facUserId")
	@CacheLookup
	WebElement txtUserId;
	
	// Mapped with Password on User Portal Log In page
	@FindBy(id = "password")
	@CacheLookup
	WebElement txtPassword;
		
	// Mapped with Login button on User Portal Log In page
	@FindBy(id = "loginBtn-button")
	@CacheLookup
	WebElement btnLogin;
	
	// Mapped with Login button on User Portal Log In page
	@FindBy(linkText = "Hamilton General")
	@CacheLookup
	WebElement hamiltongeneral;
	
	// Mapped with Logout button on User Portal.
	@FindBy(id = "confirmed:confirmedForm:j_id_jsp_153476521_6pc9")
	@CacheLookup
	WebElement btnLogout;
	
	public void setUserId(String uname) {
		txtUserId.clear();
		txtUserId.sendKeys(uname);
    }

    public void setUserPassword(String pass) {

    	txtPassword.clear();
    	txtPassword.sendKeys(pass);

    }

    public void clickLogInUser() {
    	btnLogin.click();
    	hamiltongeneral.click();
    	
    }
   
    public void clickLogOutUser() {
    	btnLogout.click();
    }
}
