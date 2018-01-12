package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPPolicyPage {
	WebDriver driver;
	
public UserPPolicyPage(WebDriver d) {
		
		driver = d;
		PageFactory.initElements(d, this);// additional method
	}
		
	// Mapped with Logout button on User Portal Patient Page.
	@FindBy(id = "confirmed:confirmedForm:j_id_jsp_153476521_6pc9")
	@CacheLookup
	WebElement btnLogoutPP;
		
	// Mapped with ViewConsentPolicies on User Portal Patient Page.
	@FindBy(linkText = "View Consent Policies")
    @CacheLookup
	WebElement lnkViewConsentPolicies;
	
	// Mapped with back button on User Portal Patient Page.
	@FindBy(xpath = ".//*[@id='consentminder:j_id_jsp_247101692_52pc2:j_id_jsp_247101692_53pc2']/span")
	@CacheLookup
	WebElement btnback;
	
	// Mapped with ViewTemplateList on User Portal Patient Page.
	@FindBy(linkText = "View Template List")
	@CacheLookup
	WebElement lnkViewTemplateList ;
	
	// Mapped with Allow Disclosure of Healthcare Information on User Portal Patient Page.
	@FindBy(linkText = "Allow Disclosure of Healthcare Information")
	@CacheLookup
	WebElement lnkAllowDisclosureHI;
	
	// Mapped with Restrict Disclosure of Healthcare Information on User Portal Patient Page.
	@FindBy(linkText = "Restrict Disclosure of Healthcare Information")
	@CacheLookup
	WebElement lnkRestrictDisclosureHI;

	// Mapped with Allow Use of Healthcare Information on  User PortalPatient Page.
	@FindBy(linkText = "Allow Use of Healthcare Information")
	@CacheLookup
	WebElement lnkAllowUseHI;
	
	// Mapped with Restrict Use of Healthcare Information on User Portal Patient Page.
	@FindBy(linkText = "Restrict Use of Healthcare Information")
	@CacheLookup
	WebElement lnkRestrictUseHI;
	
	// Mapped with checkbox button to select directive outcome as None  on User Portal Patient Page.
	// ( by deafult : outcome is allow or deny according to template Restrict = Deny , Allow = Allow)
	@FindBy(id = "myCM_selection")
	@CacheLookup
	WebElement chkConsentOutcome;
	
	// Mapped with radio button consenter as Patient on User Portal Patient Page.
	@FindBy(id = "myCM_consenterPatient")
	@CacheLookup
	WebElement rdmyCMonsenterPatient;
	
	// Mapped with radio button consenter as Representative on User Portal Patient Page.
	@FindBy(id = "myCM_consenterRepresentative")
	@CacheLookup
	WebElement rdmyCMconsenterRepresentative;
	
	// Mapped with myCM consenter Representative Name field on User Portal Patient Page.
	@FindBy(id = "myCM_consenterName")
	@CacheLookup
	WebElement txtmyCMconsRepName;
	
	// Mapped with myCM consenter Representative role field on User Portal Patient Page.
	@FindBy(id = "myCM_consenterRole")
	@CacheLookup
	WebElement txtmyCMconsRepRelation;
	
	// Mapped with continue button on User Portal Patient Page.
	@FindBy(id = "consentminder:j_id_jsp_247101692_40pc2:j_id_jsp_247101692_49pc2")
	@CacheLookup
	WebElement btncontinue;
    
	// Mapped with save button on User Portal Patient Page.
	@FindBy(id = "consentminder:j_id_jsp_247101692_52pc2:j_id_jsp_247101692_72pc2")
	@CacheLookup
	WebElement btnsave;
	
	// Mapped with Logout button on User Portal.
	@FindBy(id = "welcome:j_id_jsp_2108537197_1pc3:j_id_jsp_2108537197_5pc3")
	@CacheLookup
	WebElement btnLogoutUP;
	
	// Mapped with update button on Patient Portal Patient Page.
	@FindBy(id = "consentminder:j_id_jsp_247101692_52pc2:j_id_jsp_247101692_71pc2")
	@CacheLookup
	WebElement btnupdate;
	
	public void clickViewConsentPolicies() {
    	lnkViewConsentPolicies.click();
    	 }
	
	public void clickViewTemplateList() {
		lnkViewTemplateList.click();
    	 }
	
	public void clickAllowDisclosureHI() {
		lnkAllowDisclosureHI.click();
    	 }
	
	public void clickRestrictDisclosureHI() {
		lnkRestrictDisclosureHI.click();
    	 }
	
	public void clickAllowUseHI() {
		lnkAllowUseHI.click();
    	 }
	
	public void clickRestrictUseHI() {
		lnkRestrictUseHI.click();
    	 }
	public void clickDirecOutcomeNone() {
		chkConsentOutcome.click();
    	 }
	
	public void clickPatient() {
		rdmyCMonsenterPatient.click();
    	 }
	
	public void clickRepresentative() {
		rdmyCMconsenterRepresentative.click();
    	 }
	
	public void setRepName(String Repname) {
		txtmyCMconsRepName.clear();
		txtmyCMconsRepName.sendKeys(Repname);
    }

    public void setRepRelation(String RepRelation) {

    	txtmyCMconsRepRelation.clear();
    	txtmyCMconsRepRelation.sendKeys(RepRelation);

    }

    public void clickbtncontinue() {
    	btncontinue.click();
    	 }
   
    public void clickbtnsave() {
    	btnsave.click();
    }
    public void clickbtnback() {
    	btnback.click();
    }
    public void clickbtnupdate() {
   	 btnupdate.click();
   }
   
    public void clickLogOutUser() {
    	btnLogoutUP.click();
    }

}
