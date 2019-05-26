package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverFactory;

public class LandingPage {
	
	@FindBy(linkText="Sign In")
	private WebElement signInLink;
	
	@FindBy(xpath="//a[contains(text(),'Create Account')]")
	private WebElement createAccountLink;

	public LandingPage() {
		
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
		
	public void clickOnCreateAccountLink() {
		createAccountLink.click();
	}
	
	public CreateAccountPage navigateToCreateAccountPage() {
		clickOnCreateAccountLink();
		return new CreateAccountPage();
	}
	
	public SignInPage clickOnSignInLink() {
		clickOnSignInLink();
		return new SignInPage();
	}
}
