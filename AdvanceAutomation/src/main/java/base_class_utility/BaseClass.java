package base_class_utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.DatabaseUtility;
import generic_utility.PropertyFileUtility;
import object_repository.DashboardPage;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	DatabaseUtility dbUtil=new DatabaseUtility();
	PropertyFileUtility pro=new PropertyFileUtility();
	@BeforeSuite
	public void beforeSuite()
	{
	System.out.println("Establish database connection");	
	dbUtil.getDBConnection("jdbc:mysql://localhost:3306/Ninza_E18","root","sreelakam");
	}
	
	@BeforeTest
	public void beforeTest()
	{
	System.out.println("Pre configuration setup");	
	}
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
	System.out.println("Launch the browser");
	String BROWSER=pro.readingDataFromPropFile("browser");
	ChromeOptions Coptions=new ChromeOptions();
	FirefoxOptions Foptions=new FirefoxOptions();
	EdgeOptions Eoptions=new EdgeOptions();
	Coptions.addArguments("--headless");
	Foptions.addArguments("--headless");
	Eoptions.addArguments("--headless");
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		 driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
	else
		driver=new ChromeDriver();
	sdriver=driver;
	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{
	System.out.println("Login");
	String URL=pro.readingDataFromPropFile("url");
	String UN=pro.readingDataFromPropFile("uname");
	String PWD=pro.readingDataFromPropFile("pwd");
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.login(UN, PWD);
	
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
	System.out.println("Logout");	
	DashboardPage dp=new DashboardPage(driver);
	dp.Logout();
	}
	
	@AfterClass
	public void afterClass()
	{
	System.out.println("Close the browser");	
	driver.quit();
	}
	@AfterTest
	public void afterTest()
	{
	System.out.println("Post configuration setup");	
	}
	@AfterSuite
	public void afterSuite()
	{
	System.out.println("Close database connection");	
	dbUtil.closeDBConnection();
	}

}
