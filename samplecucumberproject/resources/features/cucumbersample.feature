#Sample automation code written in Java with Selenium WebDriver that can:
#1. Select item from pulldown menu
#2. Input text into a textbox
#3. Click button
#4. Click page link
#5. Select value from a table
#We are looking for your use of CSS and XPath, use of POM design pattern, and general code
Feature: Validating user is able to view data table
  In order to validate the table that 
  user is able to navigate to the table

  @smokeTest
  Scenario: Verify the table
    Given user is able to navigate to "http://www.kraken.com"
    Then click on create account link
    Then enter user info
    When select the "China" from the dropdown
    And click on sign in link
   
