package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PesConsentSubMenu {
	private WebDriver driver;

	// Mapped with Management link on consent subMenu.
	@FindBy(id = "appMenu:j_id_m")
	@CacheLookup
	private WebElement management;

	// Mapped with Policy Merge link on consent subMenu.
	@FindBy(id = "appMenu:j_id_o")
	@CacheLookup
	private WebElement policyMerge;

	// Mapped with Policy Unmerge link on consent subMenu.
	@FindBy(id = "appMenu:j_id_q")
	@CacheLookup
	private WebElement policyUnmerge;

	// Mapped with systemDirectives link on consent subMenu.
	@FindBy(id = "appMenu:j_id_s")
	@CacheLookup
	private WebElement systemDirectives;

	// Mapped with resolvePcrChanges link on consent subMenu.
	@FindBy(id = "appMenu:j_id_w")
	@CacheLookup
	private WebElement resolvePcrChanges;

	// Mapped with internal client search link on ResolvePCRChanges SubMenu.
	@FindBy(id = "appMenu:j_id_y")
	@CacheLookup
	private WebElement internalClientSearch;

	/**
	 * @param driver
	 */
	public PesConsentSubMenu(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickmanagement() {
		
			management.click();
}
	public void clickpolicyMerge() {
		policyMerge.click();
}
	public void clickpolicyunmerge() {
		policyUnmerge.click();
}
	public void clicksystemdirectives() {
		systemDirectives.click(); 
}
	
    	public void clickresolvePCRchanges() {
		resolvePcrChanges.click();
}
	public void clickinternalclientSearch() {
		internalClientSearch.click();
}

	


}
