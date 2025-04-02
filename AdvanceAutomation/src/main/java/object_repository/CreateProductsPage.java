package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage {

WebDriver driver;
	
	public CreateProductsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="productName")
	private WebElement productName;	
	
	@FindBy(name="productCategory")
	private WebElement productCategory;	
	
	@FindBy(name="quantity")
	private WebElement quantity;	
	
	@FindBy(name="price")
	private WebElement price;	
	
	@FindBy(name="vendorId")
	private WebElement vendorId;	
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement addProductBtn;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}


	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}	
	public void addProductWithMandatoryFields(String PrName, String PrCategory,
		String Prquantity,String Prprice,String Prvendor)
	{
		productName.sendKeys(PrName);
		productCategory.sendKeys(PrCategory);
		quantity.sendKeys(Prquantity);
		price.sendKeys(Prprice);
		vendorId.sendKeys(Prvendor);
		addProductBtn.click();
		
		
	}

	
	
}
