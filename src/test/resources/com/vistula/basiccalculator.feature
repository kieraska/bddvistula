Feature: Simple calculator
  Scenario: Add two numbers
    Given I open calculator
    When I add two numbers
    Then Numbers should be added

  Scenario: Subtract two numbers
    Given I open calculator
    When I subtract one number from another
    Then Numbers should be subtracted

  Scenario: Multiply two numbers
    Given I open calculator
    When I multiply one number by another
    Then Numbers should be multiplied

  Scenario: Divide one number by another
    Given I open calculator
    When I divide one number by another
    Then Numbers should be divided