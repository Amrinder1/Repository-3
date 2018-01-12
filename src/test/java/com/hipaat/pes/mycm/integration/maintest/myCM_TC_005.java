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

public class myCM_TC_005 extends DriverManager {
	public  WebDriver driver;
	public String patientportalurl = "http://35.190.164.252:8484/portal/myConsentMinder";
	public String userportalurl = "http://35.190.164.252:8484/portal/UserPortal";
	public String pesurl = "http://35.190.164.252:8181/esuite-admin/authenticate.jsf";   
    @Test(enabled = true, priority = 1)
    public void myCM_TC_005() throws InterruptedException {
        try {
            driver = DriverManager.getDriver();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        //Step 1 - add new Policy in Patient Portal.
        PatientLogInPage log = new PatientLogInPage (driver);
        driver.get(patientportalurl);
        PropertyConfigurator.configure("Log4j.properties");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        CaptureLogs.autoLogs("OpenBrowserTest").info("OpenBrowserTest ended");
        log.setPatientId("1");
        log.setPassphrase("hipaat13");
        log.clickLogInPatient();
        String act_Title = driver.getTitle();
        String exp_Title = "Home Page";
        SoftAssert softassert= new SoftAssert();
        softassert.assertEquals(act_Title, exp_Title);
        System.out.println(act_Title);
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
        //Thread.sleep(2000);
        PPP1.clickbtnback();
        // Thread.sleep(2000);
           
        // AC01 - Assertion to check Policy created successfully in Step 1.
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
        Thread.sleep(500);
          
        //Step 2 - add new Policy in User Portal.
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
        // AC01 - Assertion to check Policy created successfully in Step 2.
        WebElement policy2 = driver.findElement(By.linkText("Allow Use of Healthcare Information"));
        String Title2 = policy2.getText();
        Assert.assertTrue(Title2.contains("Allow Use of Healthcare Information"));
        System.out.println( "Policy with selected template created successfully in User Portal");
        UPP1.clickLogOutUser();
        Thread.sleep(500);
        
        //LogIn to Pes Step 3
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
        System.out.println(act_Title2);
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
        //AC02 - Assertion to verify Policy title and directive outcome in Pes in Step 3
        String act_Title3 = driver.findElement(By.xpath(".//*[@id='detail:description']")).getText();
        String exp_Title3 = "Allow Use of Healthcare Information";
        Assert.assertEquals(act_Title3, exp_Title3);
        System.out.println( "Policy with selected template created in User Portal is successfully verified in Pes");
        String act_directiveoutcome1 = driver.findElement(By.xpath(".//*[@id='ui-id-6']/tbody/tr[1]/td[6]/span")).getText();
        String exp_directiveoutcome1 = "Allow";
        Assert.assertEquals(act_directiveoutcome1, exp_directiveoutcome1);
        System.out.println( "Policy directive outcome created in User Portal is successfully verified in Pes");
        ActPl1.clickbtnback();
        
        ActPl1.clickActivePolicy1();
        Thread.sleep(1000);
        //AC02 - Assertion to verify Policy title and directive outcome in Pes in Step 3
        String act_Title4 = driver.findElement(By.xpath(".//*[@id='detail:description']")).getText();
        String exp_Title4 = "Restrict Disclosure of Healthcare Information";
        Assert.assertEquals(act_Title4, exp_Title4);
        System.out.println( "Policy with selected template created in Patient Portal is successfully verified in Pes");
        String act_directiveoutcome2 = driver.findElement(By.xpath(".//*[@id='ui-id-6']/tbody/tr[1]/td[6]/span")).getText();
        String exp_directiveoutcome2 = "Deny";
        Assert.assertEquals(act_directiveoutcome2, exp_directiveoutcome2);
        System.out.println( "Policy directive outcome created in Patient Portal is successfully verified in Pes");
        ActPl1.clicklogout();
        
        // Step 4 - update directive outcome of Policy in Patient Portal.
        PatientLogInPage log2 = new PatientLogInPage (driver);
        driver.get(patientportalurl);
        log2.setPatientId("1");
        log2.setPassphrase("hipaat13");
        log2.clickLogInPatient();
        String act_Title5 = driver.getTitle();
        System.out.println(act_Title);
        String exp_Title5 = "Home Page";
        Assert.assertEquals(act_Title5, exp_Title5);
        //softassert.assertAll();
         
        PatientPPolicyPage PPP2 = new PatientPPolicyPage (driver);
        PPP2.clickViewConsentPolicies();
        PPP2.clickRestrictDisclosureHI();
        PPP2.clickbtnupdate();
        PPP2.clickDirecOutcomeNone();
        PPP2.clickbtncontinue();
        PPP2.clickbtnsave();
        PPP2.clickLogOutPatient();
        
        // Step 5 - update directive outcome of Policy in User Portal.
        UserLogInPage log3 = new UserLogInPage (driver);
        driver.get(userportalurl);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        log3.setUserId("talli");         
        log3.setUserPassword("hipaat");
        log3.clickLogInUser();
        String act_Title6 = driver.getTitle();
        System.out.println(act_Title6);
        String exp_Title6 = "Home Page";
        Assert.assertEquals(act_Title6, exp_Title6);
        
        UserPortalPatientSelector UPPS2 = new UserPortalPatientSelector (driver);
        UPPS2.clickclearBtn();
        UPPS2.SetpatientId("1");
        UPPS2.clickSearchBtn();
        UPPS2.clickreturnpatient();
        
        UserPPolicyPage UPP2 = new UserPPolicyPage (driver);
        UPP2.clickViewConsentPolicies();
        UPP2.clickAllowUseHI();
        UPP2.clickbtnupdate();
        UPP2.clickDirecOutcomeNone();
        UPP2.clickbtncontinue();
        UPP2.clickbtnsave();
        UPP2.clickLogOutUser();
        
        //LogIn to Pes Step 5
        PesSignInpage PesSgnIn2 = new PesSignInpage (driver);
        driver.get(pesurl);
        PesSgnIn2.setPesUserID("talli");
        PesSgnIn2.setPesPassword("hipaat");
        PesSgnIn2.setPesFacility("Hamilton General");
        PesSgnIn2.clickLogin();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String act_Title7 = driver.findElement(By.xpath(".//*[@id='applicationAreaId']/div[1]/div[2]/div[1]")).getText();
        System.out.println(act_Title7);
        String exp_Title7 = "Welcome to Privacy eSuite";
        Assert.assertEquals(act_Title7, exp_Title7);
        
        PesMenuPage Menu3 = new PesMenuPage (driver);
        Menu3.clickconsent();
        
        PesConsentSubMenu ConsentSubMenu3 = new PesConsentSubMenu (driver);
        ConsentSubMenu3.clickmanagement();
        
        String act_title8 = driver.findElement(By.xpath(".//*[@id='page-title-text']")).getText();
        String exp_title8 = "Patient Search";
        Assert.assertEquals(act_title8, exp_title8);
        
        PesPatientSearchPage Patientsrch3 = new PesPatientSearchPage (driver);
        Patientsrch3.clickByInternalIDTab();
        
        PesPatientSearchByInternalIDPage InternalId3 = new PesPatientSearchByInternalIDPage (driver);
        InternalId3.clickOnClearButton();
        InternalId3.enterSearchID("1");
        InternalId3.clickOnSearchButton();
        String act_Patient_table2 =driver.findElement(By.id("result:j_id_6t:0:j_id_6v")).getText();
        String exp_Patient_table2= "Patient, Ann";
        Assert.assertEquals(act_Patient_table2, exp_Patient_table2);
        System.out.println( "A Patient searched by valid Internal ID has returned a Patient successfully");
        InternalId3.clickpatientnamebtn();
        
        PesPatientPoliciesActivelistPage ActPl3 = new PesPatientPoliciesActivelistPage (driver);
        ActPl3.clickActivePolicy0();
        //AC03 (Step 6)- Assertion in Pes to verify updated Policy title and directive outcome in Step 5 (User portal)
        String act_Title9 = driver.findElement(By.xpath(".//*[@id='detail:description']")).getText();
        String exp_Title9 = "Allow Use of Healthcare Information";
        Assert.assertEquals(act_Title9, exp_Title9);
        System.out.println( "Policy updated in User Portal is successfully verified in Pes");
        String act_directiveoutcome3 = driver.findElement(By.xpath(".//*[@id='ui-id-6']/tbody/tr[1]/td[6]/span")).getText();
        String exp_directiveoutcome3 = "None";
        Assert.assertEquals(act_directiveoutcome3, exp_directiveoutcome3);
        System.out.println( "Policy directive outcome updated in User Portal is successfully verified in Pes");
        ActPl3.clickrevokebtn();
        ActPl3.setRevokeComment("As requested by patient");
        ActPl3.clickRevokecont();
        String act_info = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
        String exp_info = "Policy was revoked successfully.";
        Assert.assertEquals(act_info, exp_info);
        Thread.sleep(2000);
        ActPl3.clickbtnback();
        Thread.sleep(2000);
        
        PesMenuPage Menu4 = new PesMenuPage (driver);
        Thread.sleep(2000);
        Menu4.clickconsent();
        
        PesConsentSubMenu ConsentSubMenu4 = new PesConsentSubMenu (driver);
        ConsentSubMenu4.clickmanagement();
        
        String act_title10 = driver.findElement(By.xpath(".//*[@id='page-title-text']")).getText();
        String exp_title10 = "Patient Search";
        Assert.assertEquals(act_title10, exp_title10);
        
        PesPatientSearchPage Patientsrch4 = new PesPatientSearchPage (driver);
        Patientsrch4.clickByInternalIDTab();
        
        PesPatientSearchByInternalIDPage InternalId6= new PesPatientSearchByInternalIDPage (driver);
        InternalId6.clickOnClearButton();
        InternalId6.enterSearchID("1");
        InternalId6.clickOnSearchButton();
        String act_Patient_table4 =driver.findElement(By.id("result:j_id_6t:0:j_id_6v")).getText();
        String exp_Patient_table4= "Patient, Ann";
        Assert.assertEquals(act_Patient_table4, exp_Patient_table4);
        System.out.println( "A Patient searched by valid Internal ID has returned a Patient successfully");
        InternalId6.clickpatientnamebtn();
        
        PesPatientPoliciesActivelistPage ActPl4 = new PesPatientPoliciesActivelistPage (driver);
        Thread.sleep(2000);
        ActPl4.clickActivePolicy0(); // please change it to clickActivePolicylast when there is no bug.
        Thread.sleep(2000);
        //AC03 (Step 6)- Assertion in Pes to verify updated Policy title and directive outcome in Step 4 ( patient portal)
        String act_Title11 = driver.findElement(By.xpath(".//*[@id='detail:description']")).getText();
        String exp_Title11 = "Restrict Disclosure of Healthcare Information";
        Assert.assertEquals(act_Title11, exp_Title11);
        System.out.println( "Policy updated in Patient Portal is successfully verified in Pes");
        String act_directiveoutcome4 = driver.findElement(By.xpath(".//*[@id='ui-id-6']/tbody/tr[1]/td[6]/span")).getText();
        String exp_directiveoutcome4 = "None";
        Assert.assertEquals(act_directiveoutcome4, exp_directiveoutcome4);
        System.out.println( "Policy directive outcome updated in Patient Portal is successfully verified in Pes");
        ActPl4.clickrevokebtn();
        ActPl4.setRevokeComment("As requested by patient");
        ActPl4.clickRevokecont();
        String act_info1 = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
        String exp_info1 = "Policy was revoked successfully.";
        Assert.assertEquals(act_info1, exp_info1);
        softassert.assertAll();
        Thread.sleep(2000);
        ActPl4.clickbtnback();
        Thread.sleep(2000);
        
        // Remove this code till logout statement  when bug which creats new policy on updating is rectified.
        PesMenuPage Menu5 = new PesMenuPage (driver);
        Thread.sleep(2000);
        Menu5.clickconsent();
        
        PesConsentSubMenu ConsentSubMenu5 = new PesConsentSubMenu (driver);
        ConsentSubMenu5.clickmanagement();
        
        PesPatientSearchPage Patientsrch5 = new PesPatientSearchPage (driver);
        Patientsrch5.clickByInternalIDTab();
        
        PesPatientSearchByInternalIDPage InternalId7= new PesPatientSearchByInternalIDPage (driver);
        InternalId7.clickOnClearButton();
        InternalId7.enterSearchID("1");
        InternalId7.clickOnSearchButton();
        InternalId7.clickpatientnamebtn();
        
        PesPatientPoliciesActivelistPage ActPl5 = new PesPatientPoliciesActivelistPage (driver);
        ActPl5.clickActivePolicy0();
        ActPl5.clickrevokebtn();
        ActPl5.setRevokeComment("As requested by patient");
        ActPl5.clickRevokecont();
        Thread.sleep(2000);
        ActPl5.clickbtnback();
        Thread.sleep(2000);
        
        PesMenuPage Menu6 = new PesMenuPage (driver);
        Thread.sleep(2000);
        Menu6.clickconsent();
        
        PesConsentSubMenu ConsentSubMenu6 = new PesConsentSubMenu (driver);
        ConsentSubMenu6.clickmanagement();
        
        PesPatientSearchPage Patientsrch6 = new PesPatientSearchPage (driver);
        Patientsrch6.clickByInternalIDTab();
        
        PesPatientSearchByInternalIDPage InternalId8= new PesPatientSearchByInternalIDPage (driver);
        InternalId8.clickOnClearButton();
        InternalId8.enterSearchID("1");
        InternalId8.clickOnSearchButton();
        InternalId8.clickpatientnamebtn();
        
        PesPatientPoliciesActivelistPage ActPl6 = new PesPatientPoliciesActivelistPage (driver);
        ActPl6.clickActivePolicylast();
        ActPl6.clickrevokebtn();
        ActPl6.setRevokeComment("As requested by patient");
        ActPl6.clickRevokecont();
        ActPl6.clickbtnback();
        ActPl6.clicklogout();          
	} 

	@AfterMethod(alwaysRun = true)
    
    public void Aftermethod() {    
    	driver.quit(); }
	}
