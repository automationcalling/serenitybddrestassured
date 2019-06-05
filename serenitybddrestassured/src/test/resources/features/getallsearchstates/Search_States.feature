Feature: To get and Search states and territories of a country

  Scenario: To Get all states in the given country
    Given I supply country code "IND" to get all states
    Then I get 36 records found in the given country code