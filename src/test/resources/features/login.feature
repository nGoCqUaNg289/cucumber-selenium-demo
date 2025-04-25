Feature: Login Functionality
  Scenario: Successful Login
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    Then I should be redirected to the dashboard