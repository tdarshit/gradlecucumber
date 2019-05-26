package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverFactory;

public class SignInPage {
	
	@FindBy(css="input[name='email']")
	private WebElement emailInput;
	
	@FindBy(xpath="input[@name='username']")
	private WebElement usernameInput;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordInput;
	
	@FindBy(name="tos")
	private WebElement agreementCheckbox;
	
	@FindBy(id="btn-signup")
	private WebElement signUpButton;
	
	@FindBy(xpath="//h3[contains(text(), 'Start trading')]")
	private WebElement tradingText;
	
	
	public SignInPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	public String getTradingText() {
		String text = tradingText.getText();
		return text;
	}

}
