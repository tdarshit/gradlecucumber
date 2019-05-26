package steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.*;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.SignInPage;
import utils.DriverFactory;

public class UserDefineSteps {
	
	LandingPage landingPage = new LandingPage();
	CreateAccountPage createAccountPage = new CreateAccountPage();
	SignInPage signInPage = new SignInPage();
	
	
	@Given("^user is able to navigate to \"([^\"]*)\"$")
	public void user_is_able_to_navigate_to(String url) throws Throwable {
	   DriverFactory.getUrl(url);
	}

	@Then("^click on create account link$")
	public void click_on_create_account_link() throws Throwable {
		DriverFactory.waitForPageToLoad();
		createAccountPage = landingPage.navigateToCreateAccountPage();
		
	}

	@Then("^enter user info$")
	public void enter_user_info() throws Throwable {
	    DriverFactory.waitForPageToLoad();
	    String actualPageTitle = DriverFactory.getDriver().getTitle();
	    Assert.assertEquals("Kraken | Buy, Sell and Margin Trade Bitcoin (BTC) and Ethereum (ETH) - Sign Up", actualPageTitle);
		createAccountPage.enterEmailAddress("test@test.com");
		createAccountPage.enterUsername("testcucumber");
		createAccountPage.enterPassword("testAutomation");
		createAccountPage.clickAgreementBox();
		createAccountPage.clickSignupButton();	
		    
	}

	@When("^select the \"([^\"]*)\" from the dropdown$")
	public void select_the_value_from_the_dropdown(String countryName) throws Throwable {
	   DriverFactory.waitForPageToLoad(); 
	   createAccountPage.selectCountryFromDDL(countryName);
	   Assert.assertTrue(DriverFactory.getDriver().findElement(By.id("btn-signup")).isEnabled());
	} 
	
	@When("^click on sign in link$")
	public void click_on_link() throws Throwable {
	   DriverFactory.waitForPageToLoad(); 
	   signInPage = createAccountPage.clickOnSignInLink();
	   Assert.assertEquals("Start Trading", signInPage.getTradingText());

	    
	}

	
}
