package login;

import java.io.IOException;

import java.time.Duration;
import java.util.Properties;

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
import org.testng.asserts.SoftAssert;

import base_class_utility.BaseClass;
import generic_listener_utility.ListenerImp;
import generic_utility.PropertyFileUtility;
import generic_utility.WebDriverUtility;
import object_repository.DashboardPage;
import object_repository.LoginPage;

@Listeners(ListenerImp.class)
public class Login extends BaseClass {
	//private WebDriver driver;

	//@Parameters("browser")
   //  @Test(groups= {"smoketest"})
   
	// @Test(retryAnalyzer=generic_listener_utility.RetryListenerImp.class)
	@Test
	public  void LoginTest() throws IOException, InterruptedException {
	
		
		
	String expectedURL="http://49.249.28.218:8098/dashboar";
	
	
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	
	Thread.sleep(2000);
	String actualURL=driver.getCurrentUrl();
	System.out.println(actualURL);
	Assert.assertEquals(actualURL, expectedURL,"Validation is fail");
	
		Reporter.log("Validation is pass",true);
	
	//logout
	Thread.sleep(5000);
	DashboardPage dp=new DashboardPage(driver);
	dp.Logout();
	driver.quit();
			/*driver.findElement(By.xpath("//div[@class='user-icon']")).click();
	        WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
	        webUtil.actionMoveToElement(driver, logoutBtn);
	        driver.quit();*/
	

	}
	

}
