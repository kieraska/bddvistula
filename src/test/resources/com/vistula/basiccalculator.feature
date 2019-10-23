Feature: Simple calculator
  Scenario: Add two numbers
    Given I open calculator
    When I add two numbers
    Then Result should be "8"

  Scenario: Subtract two numbers
    Given I open calculator
    When I subtract one number from another
    Then Result should be "3"

  Scenario: Multiply two numbers
    Given I open calculator
    When I multiply one number by another
    Then Result should be "12"

  Scenario: Divide one number by another
    Given I open calculator
    When I divide one number by another
    Then Result should be "3"