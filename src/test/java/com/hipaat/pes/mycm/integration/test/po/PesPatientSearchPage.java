package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PesPatientSearchPage {
	private WebDriver driver;

	// Mapped with By Identifier ID link on Patient Search  Page.
	@FindBy(id = "detail:j_id_4t")
	
	
	@CacheLookup
	private WebElement byIdentifier;

	// Mapped with By Internal ID link on Patient Search Page.
	@FindBy(id = "detail:j_id_4o")
	@CacheLookup
	private WebElement byInternalId;
	
	// Mapped with By Name link on Patient Search Page.
	@FindBy(id = "detail:j_id_4y")
	@CacheLookup
	private WebElement byName;

	/**
	 * @param driver
	 */
	public PesPatientSearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * Click on By Internal ID Button.
	 *
	 */
	public void clickByInternalIDTab() {
	  	    byInternalId.click();
	}
	
	/**
	 * Click on By Identifier Button.
	 *.
	 */
	public void clickByIdentifierTab() {
	  	    byIdentifier.click();
	  	   
	}
	/**
	 * Click on By Name Button.
	 *
	 * @return the PatientSearchByInternalIDPage class instance.
	 */
	public void clickByNameTab() {
	  	    byName.click();
	  	    
	}

}
