package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPortalPatientSelector {
	
	public static WebDriver driver;
	
	// Mapped with PatientId on User Portal Patient Selector page.
	@FindBy(id ="patientselect:j_id_jsp_1738177317_1pc2:id")   
	WebElement PatientId;
	
	// Mapped with Search button on User Portal Patient Selector page.
	@FindBy(id ="patientselect:j_id_jsp_1738177317_1pc2:search")   
	WebElement SearchBtn;
	
	// Mapped with Clear button on User Portal Patient Selector page
	@FindBy(id ="patientselect:j_id_jsp_1738177317_1pc2:clear")   
	WebElement ClearBtn;
	
	// Mapped with Patient Last Name field on User Portal Patient Selector page.
	@FindBy(id ="lastName")   
	WebElement PatientLastName;
	
	// Mapped with Patient Given Name field on User Portal Patient Selector page.
	@FindBy(id ="givenNames")   
	WebElement PatientGivenName;
	
	// Mapped with City field on User Portal Patient Selector page.
	@FindBy(id ="patientselect:j_id_jsp_1738177317_1pc2:addrCity")   
	WebElement City;
	
	// Mapped with Province field on User Portal Patient Selector page.
	@FindBy(id ="patientselect:j_id_jsp_1738177317_1pc2:addrProvState")   
	WebElement Province;
	
	@FindBy(xpath =".//*[@id='patientselect:j_id_jsp_1738177317_1pc2:j_id_jsp_1738177317_18pc2:tbody_element']/tr/td[1]/a/span")   
	WebElement Patientname;

	 public UserPortalPatientSelector(WebDriver d) {
	    	// this.driver=driver;
	    	driver = d;
	    	PageFactory.initElements(d, this);// additional method
	    }
	 public void SetpatientId(String Id) {
 		PatientId.sendKeys(Id);
	 }
	 public void clickSearchBtn() {
 		SearchBtn.click();
	 }
	 public void clickclearBtn(){
	ClearBtn.click();
	 }
	 public void setpatientfirstName(String Gname){
	PatientGivenName.sendKeys(Gname);
	 }

	 public void setpatientLastName(String lname){
	PatientLastName.sendKeys(lname);
	 }
	 
	 public void setcity(String Cname) {
	  City.sendKeys(Cname);
	  	}
	 public void setProvince(String Pname) {
		 Province.sendKeys(Pname);
	  	}
	 public void clickreturnpatient () {
		 Patientname.click();
	  	}
}
