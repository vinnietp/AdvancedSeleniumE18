package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(id="inputPassword")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement signInBtn;
	
	@FindBy(linkText="Forgot password?")
	private WebElement forgotPswd;
	
	@FindBy(xpath="//a[text()='Create Account']")
	private WebElement createAccount;
	

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getForgotPswd() {
		return forgotPswd;
	}

	public WebElement getCreateAccount() {
		return createAccount;
	}

	
	public void login(String uname,String pwd)
	{System.out.println(uname);
		usernameField.sendKeys(uname);
		passwordField.sendKeys(pwd);
		signInBtn.click();
		
	}

}
