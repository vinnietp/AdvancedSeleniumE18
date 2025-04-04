package contact_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import object_repository.ContactsPage;
import object_repository.CreateCampaignsPage;
import object_repository.CreateContactPage;
import object_repository.DashboardPage;
import object_repository.LoginPage;
@Listeners(ListenerImp.class)
public class CreateContactTest extends BaseClass 
{
	//@Parameters("browser")
@Test(groups= {"regresssion"})

	public void CreateContactTest(/*String browser*/)throws InterruptedException, IOException {
		JavaUtility jUtil=new JavaUtility();
		int randomNum=jUtil.getRandomNo(2000);
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String campaign=exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize=exUtil.readingDataFromExcel("DDT", 1, 3)+randomNum;
		String organization=exUtil.readingDataFromExcel("Contact", 1, 2)+randomNum;
		String title=exUtil.readingDataFromExcel("Contact", 1, 3)+randomNum;
		String contactName=exUtil.readingDataFromExcel("Contact", 1, 4);
		String mobile=exUtil.readingDataFromExcel("Contact", 1, 5);

		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Launching the browser

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		
		Thread.sleep(5000);
		DashboardPage dp=new DashboardPage(driver);
		dp.getCampaignsLink().click();
		//driver.findElement(By.linkText("Campaigns")).click();
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampaignBtn().click();
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.createCampaignWithMandatoryFields(campaign, targetSize);
		Thread.sleep(2000);
		WebElement contactlink=dp.getContactsLink();
		WebDriverUtility webUtil=new WebDriverUtility();
		webUtil.waitForElementToClickable(driver, contactlink, 20);
		contactlink.click();
		Thread.sleep(2000);
		
        ContactsPage ccp1=new ContactsPage(driver);
		WebElement createContactBtn = ccp1.getCreateContactBtn();
		webUtil.waitForElementToClickable(driver, createContactBtn,20);
		createContactBtn.click();

		Thread.sleep(2000);
		CreateContactPage cct=new CreateContactPage(driver);
		cct.createContactWithCampaign(organization, title, contactName, mobile, "selectCampaign", "create-contact", campaign );
		Thread.sleep(4000);
		String ConfirmationMsg = ccp1.getConfMsg().getText();
		boolean status=ConfirmationMsg.contains(contactName);
		Assert.assertEquals(status, true, "Contact not added");
		Thread.sleep(4000);
		
		
	}


}

