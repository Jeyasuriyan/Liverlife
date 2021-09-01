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

  Scenario: Checking view in the intercepts only
    Given I login using "eric.hoch@aventriahealth.com" and "^CTonMS21!"
    When I click on intercepts only
    Then Go to View and check whether able to open and close