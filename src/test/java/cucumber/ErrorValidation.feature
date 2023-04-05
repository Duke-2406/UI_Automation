Feature: Error validation
  Background:
    Given I landed on Ecommerce Page

  @ErrorValidation
  Scenario Outline:
    Given Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
    Examples:
      | name                         | password          |
      | deepaksihare891@gmail.com    | Deepak@24         |