Feature: Test the saucedemo Application

  Scenario: Test the Login functionality
    Given user open a login page url in "edge" browser
    When user enter valid username and valid password and click on login button
      | standard_user    | secret_sauce |
    Then user is on home page
