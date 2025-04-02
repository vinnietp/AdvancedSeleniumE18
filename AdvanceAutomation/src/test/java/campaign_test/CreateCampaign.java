package campaign_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_class_utility.BaseClass;
import generic_listener_utility.ListenerImp;
import generic_utility.ExcelFileUtility;
import generic_utility.JavaUtility;
import generic_utility.PropertyFileUtility;
import generic_utility.WebDriverUtility;
import object_repository.CampaignPage;
import object_repository.CreateCampaignsPage;
import object_repository.DashboardPage;
import object_repository.LoginPage;

@Listeners(ListenerImp.class)
public class CreateCampaign extends BaseClass {

	//@Parameters("browser")
	//@Test(priority=1,invocationCount=2,threadPoolSize=3,groups= {"regresssion"})
	//threadPoolSize for parallel exec
	@Test(groups= {"regresssion"})
		
	public void CreateCampaignTest(/*String browser*/) throws InterruptedException, IOException {
		JavaUtility jUtil=new JavaUtility();
		int randomNum=jUtil.getRandomNo(10000);
		WebDriverUtility webUtil=new WebDriverUtility();
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String campaignName=exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize=exUtil.readingDataFromExcel("DDT", 1, 3)+randomNum;
		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Launching the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		DashboardPage dp=new DashboardPage(driver);
		Thread.sleep(2000);
		//click on campaign link
		dp.getCampaignsLink().click();
		CampaignPage cp=new CampaignPage(driver);
		//click on campaign button
		cp.getCreateCampaignBtn().click();
		Thread.sleep(2000);
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		//calling the method with campaign name and target size as arguments
		ccp.createCampaignWithMandatoryFields(campaignName, targetSize);
		Thread.sleep(4000);
		//calling the method for getting confirmation message
		String Confmsg = cp.getConfMsg().getText();
		boolean status=Confmsg.contains(campaignName);
		Assert.assertEquals(status, true, "not added");
		Reporter.log("Campaign "+campaignName+" added successfully",true);
	}

	//@Parameters("browser")
	//@Test(priority=2,groups= {"regresssion"},dependsOnMethods= {"CreateCampaignWithMandatoryFields"})
	@Test(groups= {"regresssion"})
	public void CreateCampaignWithDateTest() throws InterruptedException, IOException  {
		Thread.sleep(2000);
		JavaUtility jUtil=new JavaUtility();
		int randomNum=jUtil.getRandomNo(7000);
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String campaign=exUtil.readingDataFromExcel("DDT",1,2)+randomNum;
		String targetSize=exUtil.readingDataFromExcel("DDT",1,3);	
		System.out.println(campaign);
		System.out.println(targetSize);
		Thread.sleep(2000);
		String closeDate=jUtil.generteReqDate(30);
		//navigating to ninzacrm
		String expectedURL="http://49.249.28.218:8098/dashboard";
		WebDriverUtility webUtil=new WebDriverUtility();
		webUtil.maximizeWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		DashboardPage dp=new DashboardPage(driver);
		//click on campaign link
		dp.getCampaignsLink().click();
		Thread.sleep(2000);
		CampaignPage cp=new CampaignPage(driver);
		//click on campaign button
		cp.getCreateCampaignBtn().click();
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		//passing campaign name,target size and close date to the method 
		ccp.createCampaignWithCloseDate(campaign, targetSize, closeDate);
		Thread.sleep(2000);
		//getting the text on successful submisssion
		String Confmsg=cp.getConfMsg().getText();
		boolean status=Confmsg.contains(campaign);
		Assert.assertEquals(status, true, "campaign not added");
		//Assert.assertTrue(status, Confmsg);
		Reporter.log("campaign"+campaign+"successfully added",true);
	}
}
