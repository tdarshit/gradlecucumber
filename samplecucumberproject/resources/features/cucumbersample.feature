Feature: Validating user is able to navigate to pages
  In order to validate the pages
  user is able to navigate to the web site

  @smokeTest
  Scenario: Verify the web site pages
    Given user is able to navigate to "http://www.kraken.com"
    Then click on create account link
    Then enter user info
    When select the "China" from the dropdown
    And click on sign in link
   
