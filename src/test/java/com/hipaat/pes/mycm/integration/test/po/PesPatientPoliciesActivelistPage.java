package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PesPatientPoliciesActivelistPage {
	
WebDriver driver;
	
	public PesPatientPoliciesActivelistPage(WebDriver d) {
		
		driver = d;
		PageFactory.initElements(d, this);// additional method
	}
	    // Mapped with Policy Title Allow Disclosure of Healthcare Information on Pes Patient Activelist Page .
		@FindBy(linkText = "Allow Disclosure of Healthcare Information")
		@CacheLookup
		WebElement lnkAllowDisclosureHI;
		
		// Mapped with Policy Title Restrict Disclosure of Healthcare Information on Pes Patient Activelist Page.
		@FindBy(linkText = "Restrict Disclosure of Healthcare Information")
		@CacheLookup
		WebElement lnkRestrictDisclosureHI;

		// Mapped with Policy Title Allow Use of Healthcare Information on Pes Patient Activelist Page
		@FindBy(linkText = "Allow Use of Healthcare Information")
		@CacheLookup
		WebElement lnkAllowUseHI;
		
		// Mapped with Policy Title Restrict Use of Healthcare Information on Pes Patient Activelist Page
		@FindBy(linkText = "Restrict Use of Healthcare Information")
		@CacheLookup
		WebElement lnkRestrictUseHI;
		
		// Mapped with back button after selecting policy.
		@FindBy(id = "detail:j_id_8t")
		@CacheLookup
		WebElement btnback;
		
		// Mapped with back button after selecting policy.
		@FindBy(xpath = ".//*[@id='detail:j_id_8i']") 
		@CacheLookup
		WebElement btnRevoke;
		
		// Mapped with revoke comment field after selecting policy.
		@FindBy(xpath = ".//*[@id='revoke-comment']")
		@CacheLookup
		WebElement txtRevokecomment;
		
		// Mapped with revoke continue button after selecting policy.
		@FindBy( xpath = ".//*[@id='revoke-comment-btn-continue']")
		@CacheLookup
		WebElement txtRevokecont;
		
		// Mapped with reopen button after selecting policy.
		@FindBy( xpath = ".//*[@id='detail:j_id_8h']")
		@CacheLookup
		WebElement btnReopen;
		
		// Mapped with list of active policies to select latest created or update policy when there are multiple active policies in active policies list.
		// So id or xpath here is for policy which is at top for multiple active policies list.
		@FindBy (id="policiesResult:j_id_78:0:j_id_7a")
		WebElement ActivePolicy0;
		
		// Mapped with list of active policies to select second latest created or update policy when there are multiple active policies in active policies list.
		// So id or xpath here is for policy which is at serial number 2 from top for multiple active policies list.
		@FindBy (id ="policiesResult:j_id_78:1:j_id_7a")
		WebElement ActivePolicy1;
		
		// Mapped with list of active policies to select policy when there is single active policy in active policies list.
		// So id or xpath here is for single active policy in active policies list.
		@FindBy (id="policiesResult:j_id_6h:0:j_id_6j")
		WebElement ActivePolicylast;
		
		// Mapped with logout button.
		@FindBy(id = "appMenu:j_id_4e")
		@CacheLookup
		private WebElement logout;
		
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
		public void clickbtnback() {
			btnback.click();
	    	 }
		public void clicklogout() {
			logout.click();
		}
		public void clickrevokebtn() {
			btnRevoke.click();
			
		}
		public void setRevokeComment(String rvkcomment) {
			txtRevokecomment.sendKeys("rvkcomment");
			
		}
		public void clickRevokecont() {
			txtRevokecont.click();
			
		}
		public void clickReopen() {
			btnReopen.click();
			
		}
		
		public void clickActivePolicylast()
		{
			ActivePolicylast.click();
		}
		public void clickActivePolicy0()
		{
			ActivePolicy0.click();
		}
		public void clickActivePolicy1()
		{
			ActivePolicy1.click();
		}

}
