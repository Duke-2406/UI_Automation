Feature: Sanity Suite

  @Sanity
  Scenario: Book Flight Tickets for One Way Trip
    Given I landed on Home Page
    Then I select My Flight
    Then I fill passenger details
    Then I confirm my flight

  @Sanity
  Scenario: Book Flight Tickets for Round Trip
    Given I landed on Home Page and search for round trip
    Then I select My Flight for Round Trip
    Then I fill passenger details
    Then I confirm my flight

