package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(className="form-control")
	private WebElement searchByContactDD;
	
	@FindBy(className="form-control")
	private WebElement searchByContactTextField;
	
	@FindBy(xpath="//span[text()='Create Contact']")
	private WebElement createContactBtn;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement confMsg;
	
	public WebElement getSearchByContactDD() {
		return searchByContactDD;
	}

	public WebElement getSearchByContactTextField() {
		return searchByContactTextField;
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public WebElement getConfMsg() {
		return confMsg;
	}


	
}
