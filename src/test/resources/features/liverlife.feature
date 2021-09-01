Feature: Validate the signup functionality to ParaBank

  Scenario Outline: Login
    Given I hit the login url
    When I enter the details "<Username>", "<Password>", "<check>"
    And click on login
    Then if the details are valid it will redirect home page else it will stay in login page with error
    Examples:
      | Username                     | Password   | check      |
      | eric.hoch@aventriahealth.com | ^CTonMS21! | Valid      |
      | eric.hoch@aventriahealth.com | ss         | Invalid    |
      |                              |            | empty      |
      | eric.hoch@aventriahealth.com |            | Emptypass  |
      |                              | pass       | Emptyemail |

  Scenario: Checking view and customize in all the resources
    Given I login using "eric.hoch@aventriahealth.com" and "^CTonMS21!"
    When I click on resources
    Then Go to View or Customize button and click on the check box to generate the url with validation

  @not_working
  Scenario: Checking view in the intercepts only
    Given I login using "eric.hoch@aventriahealth.com" and "^CTonMS21!"
    When I click on intercepts only
    Then Go to View and check whether able to open and close

  Scenario: Checking the resource search and filter target audience is working or not
    Given I login using "eric.hoch@aventriahealth.com" and "^CTonMS21!"
    When Enter the value for to check the search function "PBC Predictive"
    Then Verify that the same resource is showing "Level Check–PBC Predictive Biomarkers".
    And Click on target audience and Check the filter is working or not
    Then Validate the filter results by "patient" and "healthcare"

  Scenario: Checking the Gina url
    Given I login using "eric.hoch@aventriahealth.com" and "^CTonMS21!"
    When Click on Gina in the Resources
    Then It should redirect to the url "https://www.research.net/r/LiverLifePro"

  Scenario: Checking the EHRPlugin url
    Given I login using "eric.hoch@aventriahealth.com" and "^CTonMS21!"
    When Click on EHRPlugin
    And Click on View live sample
    Then It should redirect to the static url "https://liverlifeweb.myliverlife.online/sample-plugin-static"