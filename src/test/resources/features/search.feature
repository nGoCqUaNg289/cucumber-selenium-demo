# search.feature
Feature: Product Search
  Scenario: Search valid product
    Given I am on the homepage
    When I search for "laptop"
    Then I should see at least 5 results