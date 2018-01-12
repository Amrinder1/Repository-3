package com.hipaat.pes.mycm.integration.maintest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hipaat.pes.mycm.integration.test.po.PatientLogInPage;
import com.hipaat.pes.mycm.integration.test.po.PatientPPolicyPage;
import com.hipaat.pes.mycm.integration.test.po.PesConsentSubMenu;
import com.hipaat.pes.mycm.integration.test.po.PesMenuPage;
import com.hipaat.pes.mycm.integration.test.po.PesPatientPoliciesActivelistPage;
import com.hipaat.pes.mycm.integration.test.po.PesPatientSearchByInternalIDPage;
import com.hipaat.pes.mycm.integration.test.po.PesPatientSearchPage;
import com.hipaat.pes.mycm.integration.test.po.PesSignInpage;
import com.hipaat.pes.mycm.integration.test.po.UserLogInPage;
import com.hipaat.pes.mycm.integration.test.po.UserPPolicyPage;
import com.hipaat.pes.mycm.integration.test.po.UserPortalPatientSelector;
import com.hipaat.pes.test.drivermanager.DriverManager;

import com.hipaat.pes.test.utilities.CaptureLogs;

public class myCM_TC_001 extends DriverManager{
	public  WebDriver driver;
	public String patientportalurl = "http://35.190.164.252:8484/portal/myConsentMinder";
	public String userportalurl = "http://35.190.164.252:8484/portal/UserPortal";
	public String pesurl = "http://35.190.164.252:8181/esuite-admin/authenticate.jsf";  
	
    @Test(enabled = true, priority = 1)
    public void myCM_TC_001() throws InterruptedException {
        try {
            driver = DriverManager.getDriver();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        //Scenario 1: Step 1 - add new Policy in Patient Portal. 
        PatientLogInPage log = new PatientLogInPage (driver);
        driver.get(patientportalurl);
        //PropertyConfigurator.configure("Log4j.properties");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        CaptureLogs.autoLogs("OpenBrowserTest").info("OpenBrowserTest ended");
        log.setPatientId("1");
        log.setPassphrase("hipaat13");
        log.clickLogInPatient();
        String act_Title = driver.getTitle();
        System.out.println(act_Title);
        String exp_Title = "Home Page";
        SoftAssert softassert= new SoftAssert();
        softassert.assertEquals(act_Title, exp_Title);
        //softassert.assertAll();
          
        PatientPPolicyPage PPP1 = new PatientPPolicyPage (driver);
        PPP1.clickViewConsentPolicies();
        PPP1.clickViewTemplateList();
        PPP1.clickRestrictDisclosureHI();
        PPP1.clickRepresentative();
        PPP1.setRepName("john");
        PPP1.setRepRelation("brother");
        PPP1.clickbtncontinue();
        PPP1.clickbtnsave();
        Thread.sleep(2000);
        PPP1.clickbtnback();
        Thread.sleep(2000);
        
        /*PPP1.clickViewTemplateList();
        PPP1.clickRestrictUseHI();
        PPP1.clickRepresentative();
        PPP1.setRepName("sam");
        PPP1.setRepRelation("brother");
        PPP1.clickbtncontinue();
        PPP1.clickbtnsave();*/
        
        // AC01 - Assertion to check Policy created successfully in Scenario 1 Step 1
        WebElement policy1 = driver.findElement(By.linkText("Restrict Disclosure of Healthcare Information"));
        String Title1 = policy1.getText();
        SoftAssert softassert1= new SoftAssert();
        softassert1.assertTrue(Title1.contains("Restrict Disclosure of Healthcare Information"));
        softassert1.assertAll();
        //SoftAssert softassert1= new SoftAssert();
        //softassert1.assertTrue(Title1.contains("Restrict Disclosure of Healthcare Information"))
        //softassert.assertAll();
        System.out.println( "Policy with selected template created successfully in Patient Portal");
        PPP1.clickLogOutPatient();
        Thread.sleep(2000);
          
        //Scenario 2: Step 1 - add new Policy in User Portal. 
        UserLogInPage log1 = new UserLogInPage (driver);
        driver.get(userportalurl);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        log1.setUserId("talli");         
        log1.setUserPassword("hipaat");
        log1.clickLogInUser();
        String act_Title1 = driver.getTitle();
        System.out.println(act_Title1);
        String exp_Title1 = "Home Page";
        Assert.assertEquals(act_Title1, exp_Title1);
        
        UserPortalPatientSelector UPPS1 = new UserPortalPatientSelector (driver);
        UPPS1.clickclearBtn();
        UPPS1.SetpatientId("1");
        UPPS1.clickSearchBtn();
        UPPS1.clickreturnpatient();
        
        UserPPolicyPage UPP1 = new UserPPolicyPage (driver);
        UPP1.clickViewConsentPolicies();
        UPP1.clickViewTemplateList();
        UPP1.clickAllowUseHI();
        UPP1.clickRepresentative();
        UPP1.setRepName("Dave");
        UPP1.setRepRelation("Father");
        UPP1.clickbtncontinue();
        UPP1.clickbtnsave();
        UPP1.clickbtnback();
        // AC02 - Assertion to check Policy created successfully in Scenario 2 Step 1
        WebElement policy2 = driver.findElement(By.linkText("Allow Use of Healthcare Information"));
        String Title2 = policy2.getText();
        Assert.assertTrue(Title2.contains("Allow Use of Healthcare Information"));
        System.out.println( "Policy with selected template created successfully in User Portal");
        UPP1.clickLogOutUser();
        Thread.sleep(5000);
        
        //LogIn to Pes Step 2 for Scenario 1 and 2.
        PesSignInpage PesSgnIn1 = new PesSignInpage (driver);
        driver.get(pesurl);
        PesSgnIn1.setPesUserID("talli");
        PesSgnIn1.setPesPassword("hipaat");
        PesSgnIn1.setPesFacility("Hamilton General");
        PesSgnIn1.clickLogin();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String act_Title2 = driver.findElement(By.xpath(".//*[@id='applicationAreaId']/div[1]/div[2]/div[1]")).getText();
        String exp_Title2 = "Welcome to Privacy eSuite";
        Assert.assertEquals(act_Title2, exp_Title2);
        
        PesMenuPage Menu1 = new PesMenuPage (driver);
        Menu1.clickconsent();
        
        PesConsentSubMenu ConsentSubMenu1 = new PesConsentSubMenu (driver);
        ConsentSubMenu1.clickmanagement();
        
        String act_title = driver.findElement(By.xpath(".//*[@id='page-title-text']")).getText();
        String exp_title = "Patient Search";
        Assert.assertEquals(act_title, exp_title);
        
        PesPatientSearchPage Patientsrch1 = new PesPatientSearchPage (driver);
        Patientsrch1.clickByInternalIDTab();
        
        PesPatientSearchByInternalIDPage InternalId1 = new PesPatientSearchByInternalIDPage (driver);
        InternalId1.clickOnClearButton();
        InternalId1.enterSearchID("1");
        InternalId1.clickOnSearchButton();
        String act_Patient_table =driver.findElement(By.id("result:j_id_6t:0:j_id_6v")).getText();
        String exp_Patient_table= "Patient, Ann";
        Assert.assertEquals(act_Patient_table, exp_Patient_table);
        System.out.println( "A Patient searched by valid Internal ID has returned a Patient successfully");
        InternalId1.clickpatientnamebtn();
        
        PesPatientPoliciesActivelistPage ActPl1 = new PesPatientPoliciesActivelistPage (driver);
        ActPl1.clickActivePolicy0();
        // AC02 - Assertion to verify Policy in Pes in Scenario 2 Step 2
        String act_Title3 = driver.findElement(By.xpath(".//*[@id='detail:description']")).getText();
        String exp_Title3 = "Allow Use of Healthcare Information";
        Assert.assertEquals(act_Title3, exp_Title3);
        System.out.println( "Policy with selected template created in Patient Portal is successfully verified in Pes");
        ActPl1.clickrevokebtn();
        ActPl1.setRevokeComment("As requested by patient");
        ActPl1.clickRevokecont();
        String act_info = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
        String exp_info = "Policy was revoked successfully.";
        Assert.assertEquals(act_info, exp_info);
        ActPl1.clickbtnback();
        /*Thread.sleep(2000);
        ActPl1.clickActivePolicylast();
        Thread.sleep(10000);
        ActPl1.clickrevokebtn();
        ActPl1.setRevokeComment("As requested by patient");
        ActPl1.clickRevokecont();
        String act_info1 = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
        String exp_info1 = "Policy was revoked successfully.";
        Assert.assertEquals(act_info1, exp_info1);*/
        
        //Scenario 1 - Step 2
        PesMenuPage Menu2 = new PesMenuPage (driver);
        Thread.sleep(2000);
        Menu2.clickconsent();
        
        PesConsentSubMenu ConsentSubMenu2 = new PesConsentSubMenu (driver);
        ConsentSubMenu2.clickmanagement();
        
        String act_title3 = driver.findElement(By.xpath(".//*[@id='page-title-text']")).getText();
        String exp_title3 = "Patient Search";
        Assert.assertEquals(act_title3, exp_title3);
        
        PesPatientSearchPage Patientsrch2 = new PesPatientSearchPage (driver);
        Patientsrch2.clickByInternalIDTab();
        
        PesPatientSearchByInternalIDPage InternalId2 = new PesPatientSearchByInternalIDPage (driver);
        InternalId2.clickOnClearButton();
        InternalId2.enterSearchID("1");
        InternalId2.clickOnSearchButton();
        String act_Patient_table1 =driver.findElement(By.id("result:j_id_6t:0:j_id_6v")).getText();
        String exp_Patient_table1= "Patient, Ann";
        Assert.assertEquals(act_Patient_table1, exp_Patient_table1);
        System.out.println( "A Patient searched by valid Internal ID has returned a Patient successfully");
        InternalId2.clickpatientnamebtn();
        
        PesPatientPoliciesActivelistPage ActPl2 = new PesPatientPoliciesActivelistPage (driver);
        Thread.sleep(2000);
        ActPl2.clickActivePolicylast();
        Thread.sleep(2000);
        // AC02 - Assertion to verify Policy in Pes in Scenario 1 Step 2
        String act_Title4 = driver.findElement(By.xpath(".//*[@id='detail:description']")).getText();
        String exp_Title4 = "Restrict Disclosure of Healthcare Information";
        Assert.assertEquals(act_Title4, exp_Title4);
        System.out.println( "Policy with selected template created in Patient Portal is successfully verified in Pes");
        ActPl2.clickrevokebtn();
        ActPl2.setRevokeComment("As requested by patient");
        ActPl2.clickRevokecont();
        String act_info1 = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
        String exp_info1 = "Policy was revoked successfully.";
        Assert.assertEquals(act_info1, exp_info1);
        softassert.assertAll();
        ActPl2.clicklogout();         
    	}
    
    	@AfterMethod(alwaysRun = true)
    
    	public void Aftermethod() {    
    	driver.quit(); }
		}
