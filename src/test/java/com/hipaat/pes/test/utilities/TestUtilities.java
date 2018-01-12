package com.hipaat.pes.test.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hipaat.pes.mycm.integration.test.po.PesMenuPage;
import com.hipaat.pes.mycm.integration.test.po.PesPatientPolicyDetailPage;

public final class TestUtilities {

    public static void revoke(WebDriver driver){
        PesMenuPage menupage = new PesMenuPage(driver);
        PesPatientPolicyDetailPage patientpolicydetailpage = new PesPatientPolicyDetailPage(driver);
        patientpolicydetailpage.clickactivelist();
        String act_title = driver.findElement(By.xpath(".//*[@id='page-title-text']")).getText();
        String exp_title = "Patient Policies";
        Assert.assertEquals(act_title, exp_title);
        patientpolicydetailpage.clickactivepolicy1();
        patientpolicydetailpage.clickrevokebtn();
        patientpolicydetailpage.setrevokePolicy("To Test");
        String act_info1 = driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
        String exp_info1 = "Policy was revoked successfully.";
        Assert.assertEquals(act_info1, exp_info1);
        patientpolicydetailpage.clickBackBtn();
        menupage.clicklogout();
        WebDriverWait wait = new WebDriverWait(driver,10,5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@id='logout']/div/div")));
        String act_title1=driver.findElement(By.xpath(".//*[@id='logout']/div/div")).getText();
        String exp_title1="Thank you for using Privacy eSuite.";
        Assert.assertEquals(act_title1, exp_title1);
    }
}

