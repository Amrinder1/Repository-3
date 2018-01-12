package com.hipaat.pes.mycm.integration.test.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PesPatientPolicyDetailPage {
	static WebDriver driver;
	
	By ActiveList = By.xpath(".//*[@id='detail:j_id_4w']");
	By newusing=By.xpath(".//*[@id='policiesResult']/div[2]/div/input");
	By advanced=By.xpath(".//*[@id='policiesResult:j_id_7p']");
	By wizard=By.xpath(".//*[@id='policiesResult:j_id_7s']");
	By wizardnext=By.xpath(".//*[@id='detail:j_id_ac']");
	By wizdirtitle=By.xpath(".//*[@id='detail:cdTitle']");
	By wizdeny=By.xpath(".//*[@id='wizardDiv-10']/table/tbody/tr/td/label[3]/span");
	By excfirst=By.xpath(".//*[@id='mustExecuteRadio']/label[2]/span");
	
	@FindBy(xpath=".//*[@id='mustExecuteRadio']/label[1]/span")
	WebElement ExecuteFirstNo;
	
	@FindBy(xpath=".//*[@id='detail']/table/tbody/tr[1]/td[3]/div/select")
	WebElement RealWorldIdentifier;
	
	@FindBy(xpath=".//*[@id='validUntilRadio']/label[1]/span")
	WebElement ValidUntilRevoked;
	
	@FindBy(xpath=".//*[@id='pouRadio']/label[1]/span")
	WebElement PoUAll;
	
	@FindBy(xpath=".//*[@id='initByRadio']/label[1]/span")
	WebElement RequestedByPatient;
	
	@FindBy(xpath=".//*[@id='directiveDetail:privacyOperation']")
	WebElement  PrivacyOperation;
	
	@FindBy(xpath=".//*[@id='directiveDetail:directiveType']")
	WebElement  DirectiveType;
	
	@FindBy(xpath=".//*[@id='directiveDetail:outcome']")
	WebElement DirectiveOutcome;
	
	@FindBy(xpath=".//*[@id='phiGranularityRadio']/div[1]/label/span")
	WebElement ApplicableToRequestorAll;
	
	@FindBy(xpath=".//*[@id='policiesResult:j_id_6h:0:j_id_6j']")
	WebElement ActivePolicy1;
	
	@FindBy(xpath=".//*[@id='detail_pouSelectObj_chosen']/ul")
	WebElement TextinSpecifyPou;
	
	@FindBy(xpath=".//*[@id='detail_pouSelectObj_chosen']/div/ul/li[3]")
	WebElement Healthservicemanagement;
	
	@FindBy(css=".active-result.highlighted")
	WebElement TestSpecialValue;
	
	@FindBy(xpath= ".//*[@id='phiGranularityRadio']/div[1]/label/span")
	WebElement SpecfToPHIAll;
	
	@FindBy(id = "appMenu:j_id_4e")
	@CacheLookup
	private WebElement logout;
	
	
			
	By datepick=By.xpath(".//*[@id='detail']/div[1]/table/tbody/tr[1]/td[4]/div/img");
	By date=By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[6]/a");
	By specify=By.xpath(".//*[@id='validUntilRadio']/label[2]/span");
	By specificdatepick=By.xpath(".//*[@id='validUntilDiv']/img");
	By yearselect=By.xpath(".//*[@id='ui-datepicker-div']/div[1]/div/div/select[2]");
	By specifydate=By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[3]/a");
	By policytitle=By.xpath(".//*[@id='detail:description']");
	By subdecisionmaker=By.xpath(".//*[@id='initByRadio']/label[2]/span");
	By decisionmakernam=By.xpath(".//*[@id='detail:consenterName']");
	By relationship=By.xpath(".//*[@id='detail:consenterRole']");
	By purposespecify=By.xpath(".//*[@id='pouRadio']/label[2]/span");
	By adddirective=By.xpath(".//*[@id='detail']/div[1]/table/tbody/tr[6]/td[2]/div/input");
	By adddiradvanced=By.xpath(".//*[@id='detail:j_id_7z']");
	By privacyoper=By.xpath(".//*[@id='directiveDetail:privacyOperation']");
	By directivetyp=By.xpath(".//*[@id='directiveDetail:directiveType']");
	
	By adddirtitle=By.xpath(".//*[@id='directiveDetail:cdTitle']");
	By apptorequest=By.xpath(".//*[@id='appliesToRadio']/label[2]/span");
	
	By adddiredit=By.xpath(".//*[@id='detail:j_id_6y:0:j_id_7s']");
	By adddirdelete=By.xpath(".//*[@id='detail:j_id_6y:0:j_id_7t']");
	
	By adddirdone=By.xpath(".//*[@id='directiveDetail:doneBtn']");
	

	By addseconddir=By.xpath(".//*[@id='detail']/div[1]/table/tbody/tr[6]/td[2]/div/input");
	By secondadv=By.xpath(".//*[@id='detail:j_id_7z']");
	
	By cancelbutton=By.xpath(".//*[@id='detail:j_id_8r']");
	By yesbutton=By.xpath("html/body/div[10]/div[2]/div/div/div/div/div[4]/button[1]");
	By policysave=By.xpath(".//*[@id='detail:saveBtn']"); 
	By savecomment=By.xpath(".//*[@id='save-comment']");
	By savecommentcont=By.xpath(".//*[@id='save-comment-btn-continue']");
	
	By forcesave=By.xpath(".//*[@id='detail:forceSaveBtn']");
	By forcesavecomment=By.xpath(".//*[@id='save-comment']");
	By forcesavecont=By.xpath(".//*[@id='save-comment-btn-continue']");
	
	By policyactivate=By.xpath(".//*[@id='detail:j_id_8e']");
	By policyback=By.xpath(".//*[@id='detail:j_id_8t']");
	
	By docupload=By.xpath(".//*[@id='detail:signedDocumentUpload']");
	By savedoc=By.xpath(".//*[@id='detail:saveSignedDocumentBtn']");
	
	By reopen=By.xpath(".//*[@id='detail:j_id_8h']");
	By reopencancelbutt=By.id("detail:j_id_8s");
	By RevokeBtn=By.xpath(".//*[@id='detail:j_id_8i']");
	By Revokecomment=By.xpath(".//*[@id='revoke-comment']");
	By Revokecont=By.xpath(".//*[@id='revoke-comment-btn-continue']");
	By downloadtemplate=By.xpath(".//*[@id='detail:j_id_8j']");
	By downloadsigneddoc=By.xpath(".//*[@id='detail']/div[2]/div[1]/input");
	
	By apptoreq=By.xpath(".//*[@id='ui-id-6']/tbody/tr[2]/td[2]/span");
	By activatebutt=By.xpath(".//*[@id='detail:j_id_8e']");
	
	
	By provideradd=By.xpath(".//*[@id='directiveDetail:j_id_ad:0:j_id_an']");
	By providerlastnam=By.xpath(".//*[@id='criteria:lastName4']");
	By providersearch=By.xpath(".//*[@id='criteria:search']");
	By providercheckbox=By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[1]/div/label");
	By returnselect=By.xpath(".//*[@id='result:returnBtn']");
	By proincludeexclude=By.xpath(".//*[@id='appliesToSelectDiv']/table/tbody/tr[1]/td[2]/select");
	
	By facilityadd=By.xpath(".//*[@id='directiveDetail:j_id_ad:1:j_id_an']");
	By facname=By.xpath(".//*[@id='criteria:name3']");
	By facilitysearch=By.xpath(".//*[@id='criteria:search']");
	By facilitycheck=By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[1]/div/label");
	By facilityreturnsel=By.xpath(".//*[@id='result:returnBtn']");
	By facilincexcl=By.xpath(".//*[@id='appliesToSelectDiv']/table/tbody/tr[2]/td[2]/select");
	
	By orgadd=By.xpath(".//*[@id='directiveDetail:j_id_ad:2:j_id_an']");
	By orgname=By.xpath(".//*[@id='criteria:name2']");
	By orgsearch=By.xpath(".//*[@id='criteria:search']");
	By orgcheckbox=By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[1]/div/label");
	By orgreturnsel=By.xpath(".//*[@id='result:returnBtn']");
	By orgexclincl=By.xpath(".//*[@id='appliesToSelectDiv']/table/tbody/tr[3]/td[2]/select");
	
	By deprtmntadd=By.xpath(".//*[@id='directiveDetail:j_id_ad:3:j_id_an']");
	By deprtmntid=By.xpath(".//*[@id='criteria:id']");
	By deprtmntsearch=By.xpath(".//*[@id='criteria:search']");
	By deprtmntcheck=By.xpath(".//*[@id='resultData']/tbody/tr/td[1]/div/label");
	By deprtmntreturnsel=By.xpath(".//*[@id='result:returnBtn']");
	By deprtmntinclexcl=By.xpath(".//*[@id='appliesToSelectDiv']/table/tbody/tr[4]/td[2]/select");
	
	By jurisadd=By.xpath(".//*[@id='directiveDetail:j_id_ad:4:j_id_an']");
	By jurisid=By.xpath(".//*[@id='criteria:id']");//demo jurisdictions
	By jurissearch=By.xpath(".//*[@id='criteria:search']");
	By jurischeckbox=By.xpath(".//*[@id='resultData']/tbody/tr/td[1]/div/label");
	By jurisreturnsel=By.xpath(".//*[@id='result:returnBtn']");
	By jurisinclexcl=By.xpath(".//*[@id='appliesToSelectDiv']/table/tbody/tr[5]/td[2]/select");
	
	@FindBy (xpath=".//*[@id='policiesResult:j_id_78:0:j_id_7a']")
	WebElement ActivePolicy;
	
	By clinicalmeta=By.xpath(".//*[@id='phiGranularityRadio']/div[3]/label/span");
	By clinicaladd=By.xpath(".//*[@id='directiveDetail:j_id_cb']");
	
	By daterange=By.xpath(".//*[@id='phiGranularityRadio']/div[2]/label/span");
	By equnotequ=By.xpath(".//*[@id='directiveDetail:phiEqualOrNotEqual']");
	By startdate=By.xpath(".//*[@id='phiDateRangeDiv']/table/tbody/tr/td[3]/img");
	By year=By.xpath(".//*[@id='ui-datepicker-div']/div[1]/div/div/select[2]");
	By seldate=By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[6]/a");
	By endate=By.xpath(".//*[@id='phiDateRangeDiv']/table/tbody/tr/td[5]/img");
	By endateyear=By.xpath(".//*[@id='ui-datepicker-div']/div[1]/div/div/select[2]");
	By enddatesel=By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[2]/a");
	
	By categrycode=By.xpath(".//*[@id='phiGranularityRadio']/div[4]/label/span");
	By categryequ=By.xpath(".//*[@id='directiveDetail:phiEqualOrNotEqual3']");
	By categrytxt=By.xpath(".//*[@id='directiveDetail_phiCategoryCodesSelObj_chosen']/ul");
	
	
	By condidencialitycode=By.xpath(".//*[@id='phiGranularityRadio']/div[5]/label/span");
	By confidencialequ=By.xpath(".//*[@id='directiveDetail:phiEqualOrNotEqual4']");
	By confidencialtxt=By.xpath(".//*[@id='directiveDetail_phiConfidentialityCodesSelObj_chosen']/ul");


	
	
	public PesPatientPolicyDetailPage(WebDriver driver2) {
		driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	public void clickactivelist()
	{
	driver.findElement(ActiveList).click();
	}
	public void clickNewUsing()
	{
		driver.findElement(newusing).click();
	}
	
	public void clickAdvanced()
	{
		driver.findElement(advanced).click();
		
	}
	
	public void clickexecutefirstNo(){
		if(ExecuteFirstNo.isSelected()) 
			ExecuteFirstNo.click();}
	
	
	public void selectrealworldidentifier(String RWID){
		Select drop =new Select(RealWorldIdentifier);
		drop.selectByVisibleText(RWID);
	}
	
	public void clickvaliduntilrevoked(){
		if(ValidUntilRevoked.isSelected())
			ValidUntilRevoked.click();
		}
	
	public void clickrequestedbypatient(){
		if(RequestedByPatient.isSelected())
		RequestedByPatient.click();
		}
	
	public void clickpouAll(){
		if(PoUAll.isSelected())
			PoUAll.click();
		}
	
	public void clickapplicabletorequestorAll(){
		if(ApplicableToRequestorAll.isSelected()){
			ApplicableToRequestorAll.click();
		}}
	
	public void selectprivacyoperation(String Privacyope){
		Select drop =new Select(PrivacyOperation);
		drop.selectByVisibleText(Privacyope);
	}
	
	public void selectdirectivetype(String Dirtype){
		Select drop =new Select(DirectiveType);
		drop.selectByVisibleText(Dirtype);
	}
	
	public void selectdirectiveOutcome(String Dirotcm){
		Select drop =new Select(DirectiveOutcome);
		drop.selectByVisibleText(Dirotcm);
	}
	
	public void clickWizard()
	{
		driver.findElement(wizard).click();
	}
	
	public void wizardNext() 
	{
	driver.findElement(wizardnext).click();
     }
	
	public void wizDirTitle(String title)
	{
		driver.findElement(wizdirtitle).sendKeys(title);
	}
	public void wizDirOutcomeDeny()
	{
		driver.findElement(wizdeny).click();
	}
	
	public void ClickexecuteFirstYes()
	{
		driver.findElement(excfirst).click();
	}
	public void clickdatepickButton()
	{
		driver.findElement(datepick).click();
	}
	public void clickOnDate()
	{
		driver.findElement(date).click();
	}
	 public void futuredate()
	 {
		 driver.findElement(date).click();
	 }
	
	
	 public void validUntilSpecifyButton()
	 {
		 driver.findElement(specify).click();
	 }
	 public void specifyDatepicker()
	 {
		 driver.findElement(specificdatepick).click();
	 }
	 public void specifyYearSelect()
	 {
		 driver.findElement(yearselect).click();
	 }
	 
	 public void specifyDatePick()
	 {
		 driver.findElement(specifydate).click();
	 }
	 public void setPolicyTitle(String title)
	 {
		 driver.findElement(policytitle).clear();
		 driver.findElement(policytitle).sendKeys(title);
	 }
	 public void SubDecisionMaker()
	 {
		 driver.findElement(subdecisionmaker).click();
			 
	 }
	 
	 public void DecisionMakerName(String decname)
	 {
		 driver.findElement(decisionmakernam).sendKeys(decname);
	 }
	 
	 public void DecisionMakerRel(String relation)
	 {
		 driver.findElement(relationship).sendKeys(relation);
	 }
public void clickpouspecify(){
	driver.findElement(purposespecify).click();
}
	 
	 public void setPurposeSpecify(String purpose)
	 {
		 Select drop=new Select(driver.findElement(purposespecify));
			drop.selectByVisibleText(purpose);
	 }
	 public void clickAddDirective()
	 {
		 driver.findElement(adddirective).click();
	 }
	 public void clickAddDirAdv()
	 {
		 driver.findElement(adddiradvanced).click();
	 }
	 
	
		
	 public void setdirectiveTitle(String title)
	 {
		 driver.findElement(adddirtitle).sendKeys(title);
	 }
	 public void clickAppToReqSpecify()
	 {
		 driver.findElement(apptorequest).click();
	 }
     public void clickProvideAdd()
	 {
		 driver.findElement(provideradd).click();
	 }
	 public void searchProviderName(String providname)
	 {
		 driver.findElement(providerlastnam).sendKeys(providname);
		 driver.findElement(providersearch).click();
	 }
	 
	 public void clickProviderCheckBox()
	 {
		 driver.findElement(providercheckbox).click();
		 driver.findElement(returnselect).click();
	 }
	 
	 public void clickproviderExclInclSelect(String inclexcl)
	 {
		 Select drop=new Select(driver.findElement(proincludeexclude));
			drop.selectByVisibleText(inclexcl);
	 }
	 
	 public void clickFacilityAdd()
	 {
		 driver.findElement(facilityadd).click();
	 }
	 public void facilityName(String facilitynam)
	 {
		 driver.findElement(facname).sendKeys(facilitynam);
		 driver.findElement(facilitysearch).click();
	 }
	 
	 public void clickFacilityCheckBox()
	 {
		 driver.findElement(facilitycheck).click();
		 driver.findElement(facilityreturnsel).click();
	 }
	 
	 public void facilityExclInclSelect(String inclexcl)
	 {
		 Select drop=new Select(driver.findElement(facilincexcl));
			drop.selectByVisibleText(inclexcl);
		
	 }
	 public void clickOrgnznAdd()
	 {
		 driver.findElement(orgadd).click();
	 }
	 
	 public void searchOrgnznName(String orgznname)
	 {
		 driver.findElement(orgname).sendKeys(orgznname);
		 driver.findElement(orgsearch).click();
	 }
	 public void clickOrgnznCheckBox()
	 {
		 driver.findElement(orgcheckbox).click();
		 driver.findElement(orgreturnsel).click();
	 }
	 
	 public void orgnznExclInclSelect(String inclexcl)
	 {
		 Select drop=new Select(driver.findElement(orgexclincl));
			drop.selectByVisibleText(inclexcl);
	 }
	 public void clickDeprmntAdd()
	 {
		 driver.findElement(deprtmntadd).click();
	 }
	 
	 public void searchDeptId(String deptid)
	 {
		 driver.findElement(deprtmntid).sendKeys(deptid);
		 driver.findElement(deprtmntsearch).click();
	 }
	 public void clickDeptCheckBox()
	 {
		 driver.findElement(deprtmntcheck).click();
		 driver.findElement(deprtmntreturnsel).click();
	 }
	 public void clickJurisdctnAdd()
	 {
		 driver.findElement(jurisadd).click();
	 }
	 
	 public void searchJurisdctnID(String jurisdnid )
	 {
		 driver.findElement(jurisid).sendKeys(jurisdnid);
		 driver.findElement(jurissearch).click();
	 }
	 public void clickJurisdctnCheckBox()
	 {
		 driver.findElement(jurischeckbox).click();
		 driver.findElement(jurisreturnsel).click();
	 }
	 
	 public void jurisdnExclIncl(String inclexcl)
	 {
		 Select drop=new Select(driver.findElement(jurisinclexcl));
		drop.selectByVisibleText(inclexcl);
	 }
	
	 
	 public void clickAddDirectiveDone()
	 {
		driver.findElement(adddirdone).click(); 
	 }
	 public void addDirectiveEdit()
	 {
		driver.findElement(adddiredit).click(); 
	 }
	 public void addDirectiveDelete()
	 {
		 driver.findElement(adddirdelete).click();
	 }
	 public void addSecondDirective()
	 {
		 driver.findElement(addseconddir).click();
		 driver.findElement(secondadv).click();
	 }
	 
	 public void clickPolicySave(String text)
	 {
		 driver.findElement(policysave).click();
		 driver.findElement(savecomment).sendKeys(text);
		 driver.findElement(savecommentcont).click();
		 
	 }
	 
	 public void clickCancelButton()
	 {
		 driver.findElement(cancelbutton).click();
		 driver.findElement(yesbutton).click();
	 }
	 
	 public void whyPolicyCreatedText(String text)
	 {
		 driver.findElement(savecomment).sendKeys(text);
		 driver.findElement(savecommentcont).click();
	 }
	 
	 
	 public void clickForceSave(String comment)
	 {
		 driver.findElement(forcesave).click();
		 driver.findElement(forcesavecomment).sendKeys(comment);
		 driver.findElement(forcesavecont).click();
	 }
	 
	 public void clickBrowseDoc()
	 {
		 driver.findElement(docupload).click();
		 	 
	 }
	 public void clickSaveDocument()
	 {
		 driver.findElement(savedoc).click();
	 }
	 public void activatePolicy()
	 {
		 driver.findElement(policyactivate).click();
	 }
	 
	 public void clickBackBtn()
	 {
		 driver.findElement(policyback).click();
	 }
	 
	 public void clickreopenPolicy()
	 {
		 driver.findElement(reopen).click();
	 }
	 
	 public void clickReopenCancel()
		{
			 driver.findElement(reopencancelbutt).click();
	    }
	 public void clickrevokebtn() {
		driver.findElement(RevokeBtn).click();
		
	}

	public void setrevokePolicy(String comment)
	 {
		driver.findElement(Revokecomment).sendKeys(comment);		
		driver.findElement(Revokecont).click();
	
	 }
	 
	 public void downloadTemplate()
	 {
		 driver.findElement(downloadtemplate).click();
		
	 }
	 
	 public void downloadSignDoc()
	 {
		 driver.findElement(downloadsigneddoc).click();
	 }
	 
	 
	 
	 public void clickActivateButton()
	 {
		 driver.findElement(activatebutt).click();
		
	 }
	 
	 public void clickactivepolicy()
	 {
		 ActivePolicy.click();
	 }
	 
	 public void clickClinicalMetaData()
	 {
		 driver.findElement(clinicalmeta).click();
	 }
	 public void clickclinicalMetaAdd()
	 {
		 driver.findElement(clinicaladd).click();
	 }
	 
		
		 public void clickDateRange()
		 {
			 driver.findElement(daterange).click();
		 }
		 public void dateRangeEqu(String equals)
		 {
			 Select drop=new Select(driver.findElement(equnotequ));
			drop.selectByVisibleText(equals);
		 }
		 public void clickStartDate()
		 {
			 driver.findElement(startdate).click();
		 }
		 
		 public void selectstartDateYear(String selyear)
		 {
			 Select drop=new Select(driver.findElement(year));
			 drop.selectByVisibleText(selyear);
		 }
		 
		 public void clickstartDateSelDate()
		 {
			 driver.findElement(seldate).click();
		 }
		 
		 public void clickEndDate()
		 {
			 driver.findElement(endate).click();
		 }
		 
		 public void selectendDateYear(String selyear)
		 {
			 Select drop=new Select(driver.findElement(endateyear));
			 drop.selectByVisibleText(selyear);
		 }
		 public void clickendDateSel()
		 {
			 driver.findElement(enddatesel).click();
		 }
		 public void clickCategoryCode()
		 {
			 driver.findElement(categrycode).click();
		 }
		 public void selectcategoryCodeEquNotequ(String equals)
		 {
			 Select drop=new Select(driver.findElement(categryequ));
			 drop.selectByVisibleText(equals);
			 
		 }
		 public void selectCategorycode(String catcode)
		 {
			 Select drop=new Select(driver.findElement(categrytxt));
			 drop.selectByVisibleText(catcode);
		 }
		 public void clickConfidentialCode()
		 {
			 driver.findElement(condidencialitycode).click();
		 }
		 public void selectconfidentCodeEquNotequ(String equals)
		 {
			 Select drop=new Select(driver.findElement(confidencialequ));
			 drop.selectByVisibleText(equals);
		 }
		 public void selectConfidentCode(String confcode)
		 {
			 Select drop=new Select(driver.findElement(confidencialtxt));
			 drop.selectByVisibleText(confcode);
		}
		 public int getpolicycount()
			{
				List <WebElement> policy = driver.findElements(By.xpath("//a[@class='detailLink']"));
				int count = policy.size();
				return count;
			}
		 public void clickactivepolicy1(){
			 ActivePolicy1.click();
		 }
		 
		 public void clickSpecfToPHIAll(){
			 SpecfToPHIAll.click();
		 }
	 
	 public void setpoutext(String poutext){
		 TextinSpecifyPou.sendKeys(poutext);
	 }

	 public void clickhealthservicemanagement(){
		 Healthservicemanagement.click();
	 }
	 
	 public void clicktestspecialvalue(){
		 TestSpecialValue.click();
	 }
	 public void clicklogout() {
			logout.click();
		}
	 public int getpouCount(){
	 List<WebElement> myList=driver.findElements(By.className("active-result"));

	   /* //myList contains all the web elements
	    //if you want to get all elements text into array list
	    List<String> all_elements_text=new ArrayList<>();
	    boolean b=false;
		for(int i=0; i<myList.size(); i++){
	    	   	  EmergencyCare.click();
	      //loading text of each element in to array all_elements_text
	        all_elements_text.add(myList.get(i).getText());
	        EmergencyCare.click();
	        //to print directly
	        System.out.println(myList.get(i).getText());

	    }*/
	// List<WebElement> nextElements = driver.findElements(By.xpath("xpath"));
     if (myList.size() > 0) {
    	 myList.get(3).click();
        // waitSecs(randomNumber(5,10));
     }
     //else {
         //inLoop = false;
		return 0;
		}}


