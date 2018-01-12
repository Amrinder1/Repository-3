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
import com.hipaat.pes.mycm.integration.test.po.PesPatientPolicyDetailPage;
import com.hipaat.pes.mycm.integration.test.po.PesPatientSearchByInternalIDPage;
import com.hipaat.pes.mycm.integration.test.po.PesPatientSearchPage;
import com.hipaat.pes.mycm.integration.test.po.PesSignInpage;
import com.hipaat.pes.mycm.integration.test.po.UserLogInPage;
import com.hipaat.pes.mycm.integration.test.po.UserPPolicyPage;
import com.hipaat.pes.mycm.integration.test.po.UserPortalPatientSelector;
import com.hipaat.pes.test.drivermanager.DriverManager;
import com.hipaat.pes.test.utilities.CaptureLogs;

public class myCM_TC_007 extends DriverManager{
	public static WebDriver driver;
	public String pesurl = "http://35.190.164.252:8181/esuite-admin/authenticate.jsf"; 
	public String patientportalurl = "http://35.190.164.252:8484/portal/myConsentMinder";
	public String userportalurl = "http://35.190.164.252:8484/portal/UserPortal";

	@Test(enabled = true, priority = 1)
	public void myCM_TC_007() throws InterruptedException {
		try {
			driver = DriverManager.getDriver();
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		driver.get(pesurl);
		PropertyConfigurator.configure("Log4j.properties");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		CaptureLogs.autoLogs("OpenBrowserTest").info("OpenBrowserTest ended");
		PesSignInpage PesSgnIn1 = new PesSignInpage (driver);
		driver.get(pesurl);

		//Step 1 - LogIn into PeS  then select patient and Add New Policy.
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

		//Create policy as per in myCM_TC_006
		PesPatientPolicyDetailPage patientpolicydetailpage= new PesPatientPolicyDetailPage(driver);
		patientpolicydetailpage.clickactivelist();
		patientpolicydetailpage.clickNewUsing();
		patientpolicydetailpage.clickAdvanced();
		String act_ttl = driver.findElement(By.xpath(".//*[@id='page-title-text']")).getText();
		String exp_ttl = "Patient Policy Detail";
		Assert.assertEquals(act_ttl, exp_ttl);
		WebElement element = driver.findElement(By.xpath(".//*[@id='detail:startDate1']"));
		String actual = element.getAttribute("value");
		System.out.println(actual);
		patientpolicydetailpage.clickexecutefirstNo();
		patientpolicydetailpage.selectrealworldidentifier("HCN - Ontario HCN: 16-03-83");
		patientpolicydetailpage.setPolicyTitle("Deny All Policy 1");
		patientpolicydetailpage.clickvaliduntilrevoked();
		patientpolicydetailpage.clickrequestedbypatient();
		patientpolicydetailpage.clickpouAll();;
		//patientpolicydetailpage.clickhealthservicemanagement();
		patientpolicydetailpage.clickAddDirective();
		patientpolicydetailpage.clickAddDirAdv();
		String act_dialogttl = driver.findElement(By.xpath(".//*[@id='ui-id-4']")).getText();
		String exp_dialogttl = "Patient Policy Consent Directive Detail";
		Assert.assertEquals(act_dialogttl, exp_dialogttl);
		patientpolicydetailpage.selectprivacyoperation("Disclosure");
		patientpolicydetailpage.selectdirectivetype("Directive Outcome");
		patientpolicydetailpage.selectdirectiveOutcome("Deny");
		patientpolicydetailpage.setdirectiveTitle("Deny All Directive");
		patientpolicydetailpage.clickapplicabletorequestorAll();
		patientpolicydetailpage.clickSpecfToPHIAll();
		patientpolicydetailpage.clickAddDirectiveDone();
		patientpolicydetailpage.clickPolicySave("To Test");

		//AC01- Policy successfully created in Step 1 
		String act_infoMsg = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		String exp_infoMsg = "Policy was saved successfully.";
		Assert.assertEquals(act_infoMsg, exp_infoMsg);
		patientpolicydetailpage.clickActivateButton();
		patientpolicydetailpage.clickBackBtn();

		//Step 2 - Reopen Policy created in Pes in Step 1  and change its Title. 
		PesPatientPoliciesActivelistPage ActPl1 = new PesPatientPoliciesActivelistPage (driver);
		ActPl1.clickActivePolicylast();
		ActPl1.clickReopen();

		patientpolicydetailpage.setPolicyTitle("Deny All Policy 1 updated today");
		patientpolicydetailpage.clickPolicySave("To Test");

		//AC01- Policy successfully updated in Step 2 
		String act_infoMsg1 = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		String exp_infoMsg1 = "Policy was saved successfully.";
		Assert.assertEquals(act_infoMsg, exp_infoMsg);
		System.out.println( "Policy successfully  updated in Pes");
		patientpolicydetailpage.clickActivateButton();
		patientpolicydetailpage.clickBackBtn();
		patientpolicydetailpage.clicklogout();

		// Step 3- LogIn into Patient Portal and verify updated policy exists here with new Title as per step 2.   
		PatientLogInPage log = new PatientLogInPage (driver);
		driver.get(patientportalurl);
		log.setPatientId("1");
		log.setPassphrase("hipaat13");
		log.clickLogInPatient();
		String act_Title = driver.getTitle();
		System.out.println(act_Title);
		String exp_Title = "Home Page";
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(act_Title, exp_Title);

		PatientPPolicyPage PPP1 = new PatientPPolicyPage (driver);
		PPP1.clickViewConsentPolicies(); 

		// AC02- Assertion to confirm Policy update verified for Patient  Portal in Step 3.  
		WebElement policy1 = driver.findElement(By.linkText("Deny All Policy 1 updated today"));
		String Title1 = policy1.getText();
		Assert.assertTrue(Title1.contains("Deny All Policy 1 updated today"));
		System.out.println( "Policy updated in Pes is successfully verified in Patient Portal ");
		PPP1.clickLogOutPatient();

		//Step 4 - LogIn to User Portal and verify updated policy exists here with new Title as per step 2.  
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

		// AC03- Assertion to confirm Policy update verified for User Portal in Step 4.
		WebElement policy2 = driver.findElement(By.linkText("Deny All Policy 1 updated today"));
		String Title2 = policy2.getText();
		Assert.assertTrue(Title2.contains("Deny All Policy 1 updated today"));
		System.out.println( "Policy updated in Pes is successfully verified in User Portal ");
		UPP1.clickLogOutUser();   
	    }
	@AfterMethod(alwaysRun = true)
	// Revoking created policy in Pes.
	public void Revoke() {
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
		ActPl1.clickActivePolicylast();
		ActPl1.clickrevokebtn();
		ActPl1.setRevokeComment("As requested by patient");
		ActPl1.clickRevokecont();
		String act_info = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		String exp_info = "Policy was revoked successfully.";
		Assert.assertEquals(act_info, exp_info);
		ActPl1.clickbtnback();
		ActPl1.clicklogout();
		driver.quit();
	}

}
