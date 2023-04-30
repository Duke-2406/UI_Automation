Feature: Sanity Suite

  @IndSanity
  Scenario: Landing on Indigo website
    Given I landed on Home Page
    Then I select My Flight
    Then I fill passenger details
    Then I confirm my flight