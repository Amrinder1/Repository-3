package com.hipaat.pes.mycm.integration.test.po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PatientLogInPage{
	
	WebDriver driver;
	
	
	public PatientLogInPage(WebDriver d) {
	
	driver = d;
	PageFactory.initElements(d, this);// additional method
}
	// Mapped with Patient ID on Patient Portal Log In page
	@FindBy(id = "patientId_3")
	@CacheLookup
	WebElement txtPatientId;
	
	// Mapped with Passphrase on Patient Portal Log In page
	@FindBy(id = "passphrase_3")
	@CacheLookup
	WebElement txtPassphrase;
		
	// Mapped with Login button on Patient Portal Log In page
	@FindBy(id = "login:loginForm:j_id_jsp_1919274207_10pc2")
	@CacheLookup
	WebElement btnLogin;
	
	public void setPatientId(String uname) {
		txtPatientId.clear();
		txtPatientId.sendKeys(uname);
    }

    public void setPassphrase(String pass) {

    	txtPassphrase.clear();
    	txtPassphrase.sendKeys(pass);

    }

    public void clickLogInPatient() {
    	btnLogin.click();
    }
    
		
	
}
