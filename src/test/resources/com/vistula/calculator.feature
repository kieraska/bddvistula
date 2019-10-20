Feature: Advanced calculator
    Scenario: Advanced options visible in horizontal view
        Given I open calculator
        When I rotate to horizontal position
        Then advanced options are shown

    Scenario: Advanced options are hidden after double rotation
        Given I open calculator
        When I rotate to horizontal position
        And I add two numbers
        And I rotate to portrait position
        Then advanced options are not shown
