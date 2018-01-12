package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PesPatientSearchByInternalIDPage {
	private WebDriver driver;

	// Mapped with ID on Patient Search Page.
	@FindBy(id = "criteria:patId")
	@CacheLookup
	private WebElement Patientid;

	// Mapped with Search button on Patient Search Page.
	@FindBy(id = "criteria:search")
	@CacheLookup
	private WebElement search;

	// Mapped with clear button on Patient Search Page.
	@FindBy(id = "criteria:clear")
	@CacheLookup
	private WebElement clear;
	
	// Mapped with clear button on Patient Search Page.
	@FindBy(xpath = ".//*[@id='result:j_id_6t:0:j_id_6v']")
	@CacheLookup
	private WebElement returnpatient;
	
	/**
	 * @param driver
	 */
	public PesPatientSearchByInternalIDPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	public void enterSearchID(String id) {
		Patientid.sendKeys(id);
		
	}

	/**
	 * Click on Search Button.
	 *
	 * @return the PatientSearchResultTable class instance.
	 */
	public void clickOnSearchButton() {
	   
		search.click();
		
	}

	
	 //Click on Clear Button.
	 
	public void clickOnClearButton() {
	    clear.click();
		
}
	public  void clickpatientnamebtn() {
		returnpatient.click();

}
	


}
