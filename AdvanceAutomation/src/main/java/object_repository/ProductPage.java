package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement searchByProductDD;
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement searchByProductID;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement addProduct;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement confMsg;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchByProductDD() {
		return searchByProductDD;
	}

	public WebElement getSearchByProductID() {
		return searchByProductID;
	}

	public WebElement getAddProduct() {
		return addProduct;
	}

	public WebElement getConfMsg() {
		return confMsg;
	}


	

}
