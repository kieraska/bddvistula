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

  Scenario Outline: Divide two numbers
    Given I open calculator
    When I enter <input_1>
    And I press divide
    And I enter <input_2>
    And I press equals
    Then Result should be <output>
    Examples:
      | input_1 | input_2 | output              |
      | 6       | 3       | 2                   |
      | 6       | 0       | "Can't divide by 0" |
      | 1       | 2       | "0.5"               |