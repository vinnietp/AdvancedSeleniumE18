package product_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_class_utility.BaseClass;
import generic_listener_utility.ListenerImp;
import generic_utility.ExcelFileUtility;
import generic_utility.JavaUtility;
import generic_utility.PropertyFileUtility;
import generic_utility.WebDriverUtility;
import object_repository.CreateProductsPage;
import object_repository.DashboardPage;
import object_repository.LoginPage;
import object_repository.ProductPage;
@Listeners(ListenerImp.class)
public class AddProduct extends BaseClass {
	//@Parameters("browser")
@Test(groups= {"integrationtest"})

	public void AddProductTest(/*String browser*/) throws IOException, InterruptedException {
		//PropertyFileUtility propUt=new PropertyFileUtility();
		ExcelFileUtility exUtil=new ExcelFileUtility();
		WebDriverUtility webUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		int randomNum=jUtil.getRandomNo(2000);
		//String BROWSER=browser;
		  String product=exUtil.readingDataFromExcel("Product", 1, 2)+randomNum;
		  String quantity=exUtil.readingDataFromExcel("Product", 1, 3);
		  String price=exUtil.readingDataFromExcel("Product", 1, 4);
		
		  String expectedURL="http://49.249.28.218:8098/dashboard";
			
	    webUtil.maximizeWindow(driver);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	  
	   DashboardPage dp=new DashboardPage(driver);
	   dp.getProductsLink().click();
Thread.sleep(2000);
	   ProductPage p=new ProductPage(driver);
	   p.getAddProduct().click();
	   // driver.findElement(By.xpath("//span[text()='Add Product']")).click();
	    Thread.sleep(2000);
	 
	  
	   
	    CreateProductsPage cpp=new CreateProductsPage(driver);
	    cpp.addProductWithMandatoryFields(product, "Electricals",price,quantity, "VID_016");
	    
	    Thread.sleep(5000);
		String confMsg = p.getConfMsg().getText();
		boolean status = confMsg.contains(product);
		Assert.assertTrue(status);
		Thread.sleep(5000);
		//logout
	    
	}

}
