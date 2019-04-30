@tutorial
Feature: Visit Google and do an example search

Scenario: Navigate to the Google search homepage, search for "Cat", and check the first result is about cats
    Given I visit the Google search page
    When I enter the text "cat" into the search box
    And I click the search button
    Then I should see the top result mentioning cats
