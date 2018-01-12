package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PesSignInpage {
	static WebDriver driver;
	
	public PesSignInpage(WebDriver d) {
		
		driver = d;
		PageFactory.initElements(d, this);// additional method
	}

    
    // Mapped with User ID on Pes Log In page
 	@FindBy(name = "login:j_id_4l")
 	@CacheLookup
 	WebElement txtUserId;
 	
 	// Mapped with Password on Pes Log In page
 	@FindBy(name= "login:j_id_4n")
 	@CacheLookup
 	WebElement txtPassword;
 	
   // Mapped with select facility on Pes Log In page
  	@FindBy(id = "login:facility")
  	@CacheLookup
  	WebElement selectfacility;
 		
 	// Mapped with Login button on Pes Log In page
 	@FindBy(id = "login:j_id_4u")
 	@CacheLookup
 	WebElement btnLogin;
 	
   // Mapped with Logout button on Pes.
 	@FindBy(id = "confirmed:confirmedForm:j_id_jsp_153476521_6pc9")
 	@CacheLookup
 	WebElement btnLogout;


    public void setPesUserID(String uname) {
    	txtUserId.clear();
    	txtUserId.sendKeys(uname);
    }

    public void setPesPassword(String pass) {

    	txtPassword.clear();
    	txtPassword.sendKeys(pass);

    }

    public void setPesFacility(String fac) {
        Select drop = new Select(selectfacility);
        drop.selectByVisibleText(fac);
    }

    public void clickLogin() {
    	btnLogin.click();
    }

}
