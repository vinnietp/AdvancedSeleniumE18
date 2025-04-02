package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class CreateContactPage {
WebDriver driver;
	
	public CreateContactPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="organizationName")
	private WebElement organizationName;	
	
	@FindBy(name="title")
	private WebElement titleField;	

	@FindBy(name="contactName")
	private WebElement contactName;	

	@FindBy(name="mobile")
	private WebElement mobile;	
	
	@FindBy(xpath="//button[contains(@style,'white-space: nowrap; margin:')]")
	private WebElement selectCampBtn;	
	
	@FindBy(id="search-criteria")
	private WebElement searchCmpDD;	
	
	@FindBy(id="search-input")
	private WebElement seachInp;	
	
	
	@FindBy(xpath="//button[@class='select-btn']")
	private WebElement selectBtn;
	
	@FindBy(xpath="//button[text()='Create Contact']")
	private WebElement createContactBtn;
	
	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public void setSelectCampBtn(WebElement selectCampBtn) {
		this.selectCampBtn = selectCampBtn;
	}


	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getTitleField() {
		return titleField;

	}

	public WebElement getContactName() {
		return contactName;

	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getSelectCampBtn() {
		return selectCampBtn;
	}

	public WebElement getSearchCmpDD() {
		return searchCmpDD;
	}

	public WebElement getSeachInp() {
		return seachInp;
	}

	
		
	public void createContactWithCampaign(String org,String title,String cont,String mob,String childURL,String parentURL,String campName)
	{
		organizationName.sendKeys(org);
		titleField.sendKeys(title);
		contactName.sendKeys(cont);
		mobile.sendKeys(mob);
		selectCampBtn.click();
		WebDriverUtility webUtil=new WebDriverUtility();
		webUtil.switchToWindow(driver, childURL);
		webUtil.select(searchCmpDD, 1);
		seachInp.sendKeys(campName);
		selectBtn.click();
		webUtil.switchToWindow(driver, parentURL);
		createContactBtn.click();
		
		
		
		
		
	}
}
