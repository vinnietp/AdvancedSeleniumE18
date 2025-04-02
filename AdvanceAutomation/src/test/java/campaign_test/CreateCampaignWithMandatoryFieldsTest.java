package campaign_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_utility.ExcelFileUtility;
import generic_utility.JavaUtility;
import generic_utility.PropertyFileUtility;
import generic_utility.WebDriverUtility;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import object_repository.CampaignPage;
import object_repository.CreateCampaignsPage;
import object_repository.DashboardPage;
import object_repository.LoginPage;

public class CreateCampaignWithMandatoryFieldsTest {

	@Test
	
	public static void main(String[] args) throws InterruptedException, IOException {
		PropertyFileUtility propUtil=new PropertyFileUtility();
		WebDriverUtility webUtil=new WebDriverUtility();
		String BROWSER=propUtil.readingDataFromPropFile("browser");
		String URL=propUtil.readingDataFromPropFile("url");
		String UN=propUtil.readingDataFromPropFile("uname");
		String PWD=propUtil.readingDataFromPropFile("pwd");
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Launching the browser
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
	webUtil.maximizeWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//navigating to ninza CRM
		driver.get("http://49.249.28.218:8098/");
				
		//enter the username and password
		/*driver.findElement(By.id("username")).sendKeys(UNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();*/
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PWD);
		Thread.sleep(2000);
		
		DashboardPage dp=new DashboardPage(driver);
		dp.getCampaignsLink().click();
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Campaigns")).click();
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampaignBtn().click();
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
        JavaUtility jUtil=new JavaUtility();
        int randomNum=jUtil.getRandomNo(2000);
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String campaignName=exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize=exUtil.readingDataFromExcel("DDT", 1, 3)+randomNum;
		Thread.sleep(2000);
		System.out.println(campaignName);
		
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.createCampaignWithMandatoryFields(campaignName, targetSize);
		/*driver.findElement(By.name("campaignName")).sendKeys(campaignName);
		
		driver.findElement(By.name("campaignStatus")).sendKeys("Status");
		driver.findElement(By.name("targetSize")).clear();
		
		driver.findElement(By.name("targetSize")).sendKeys(targetSize);*/
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		String Confmsg = cp.getConfMsg().getText();
		//String Confmsg=driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Thread.sleep(4000);

		if(Confmsg.contains(campaignName))
			System.out.println("campaign added successfully");
		else
			System.out.println("campaign not added");
		Thread.sleep(4000);
		dp.Logout();
		driver.quit();
		/*driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		 WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		 webUtil.actionMoveToElement(driver, logoutBtn);*/
		
	}

}
