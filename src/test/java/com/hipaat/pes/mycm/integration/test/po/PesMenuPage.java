package com.hipaat.pes.mycm.integration.test.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PesMenuPage {
	private WebDriver driver;
	private int timeout=10;
	
	//Mapped with Home link on Menu
	@FindBy(id = "appMenu:j_id_e")
    @CacheLookup
    private WebElement home;
	
	//Mapped with Consent link on menu.it will open a consent sub menu.
	 @FindBy(id = "appMenu:j_id_j")
	 @CacheLookup
	 private WebElement consent;
	
	 //Mapped with Report link on menu.it will open a report sub menu.
	 @FindBy(id = "appMenu:j_id_13")
	 @CacheLookup
	 private WebElement report;
	 
	 //Mapped with Audit Repository link. it will open a sub menu.
	 @FindBy(id = "appMenu:j_id_1e")
	 @CacheLookup
	 private WebElement auditRepository;
	 
	//Mapped with Administration link. it will open a sub menu.
	 @FindBy(id = "appMenu:j_id_1n")
	 @CacheLookup
	 private WebElement administration;
	 
	//Mapped with Help link.
	 @FindBy(css = "a[href='javascript:envokeHelp();']")
	 @CacheLookup
	 private WebElement help;
	 
	//Mapped with Logout link.
	 @FindBy(id = "appMenu:j_id_4e")
	 @CacheLookup
	 private WebElement logout;

	/**
	 * @param driver;
	 * 
	 */
	public PesMenuPage(WebDriver driver) {
				
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	/**
	 * Click on logout.
	 */
	
	public void clickhome() {
		home.click();
	}
	public void clickconsent() {
		Actions action = new Actions(driver);
		WebElement consent=driver.findElement(By.partialLinkText("Consent"));
	    action.moveToElement(consent).build().perform(); 
		
	}
	
	public void clickreport() {
		Actions action = new Actions(driver);
	    action.moveToElement(report).build().perform(); 
		
	}
	public void clickauditRepository() {
		Actions action = new Actions(driver);
	    action.moveToElement(auditRepository).build().perform(); 
		
	}
	public void clickadministration() {
		Actions action = new Actions(driver);
		action.moveToElement(administration).build().perform();
		 }
	
	
	
	public void clickhelp() {
		help.click();
	}
	public void clicklogout() {
		logout.click();
	}
	   		    	
	
		
	}

