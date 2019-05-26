package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.DriverFactory;

public class CreateAccountPage {
	
	@FindBy(css="input[name='email']")
	private WebElement emailInput;
	
	@FindBy(css="input[name='username']")
	private WebElement usernameInput;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordInput;
	
	@FindBy(name="tos")
	private WebElement agreementCheckbox;
	
	@FindBy(id="btn-signup")
	private WebElement signUpButton;
	
	@FindBy(xpath="//div[contains(text(), 'Password must contain non-alphanumeric characters')]")
	private WebElement passwordErrorMsg;
	
	@FindBy(name="country")
	private WebElement countryDDL;
	
	@FindBy(xpath="//a[contains(text(), 'Sign In')]")
	private WebElement signInLink;
	
	public CreateAccountPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	public void enterEmailAddress(String email) {
		typeInto(emailInput, email);
	}
	
	public void enterUsername(String username) {
		typeInto(usernameInput, username);
	}
	
	public void enterPassword(String password) {
		typeInto(passwordInput, password);
	}
	
	public void clickAgreementBox() {
		agreementCheckbox.click();
	}
	
	public void clickSignupButton() {
		signUpButton.click();
	}
	
	public String verifyErrorMessage() {
		String message = passwordErrorMsg.getText();
		return message;
	}
	
	public void selectCountryFromDDL(String countryName) {
		try {
			Select select = new Select(countryDDL);
			select.selectByVisibleText(countryName);
		}catch(NoSuchElementException e) {
			System.out.print("Element is not present: " + e);
		}
	}
			
	public void typeInto(WebElement element, String value) {
		try {
			if(element.isDisplayed()) {
				element.clear();
				element.sendKeys(value);
			}
		}catch(NoSuchElementException e) {
			System.out.println("Element is not present: " + e); 
		}
		
	}
	
	public SignInPage clickOnSignInLink() {
		List<WebElement> links = DriverFactory.getDriver().findElements(By.xpath("//a[contains(text(), 'Sign In')]"));
		links.get(2).click();
				
		return new SignInPage();
	}
		

}
