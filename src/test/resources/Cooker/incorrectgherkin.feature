# This feature file aims at braking as much gherkin coding standard rules as possible, where this comment is one of them.
Feature: incorrectgherkin
  Cover a range of violations to the Gherkin coding standard.

    #Repeating the given at background and scenario, BackgroundsOnlySteps
  Background: Always start cold
    Given cookerplate is cold
    When I heat the plate

    Scenario: Simple ok scenario, only braking repetition of given
      Given cookerplate is cold
      When I do nothing
      Then I should have a cold cookerplate

  # WRONG: violates DifferentValuesDatatable, OnlyOneScenario, TablesOutline
  # Can be fixed by adding more examples and alignment of the table.
  Scenario Outline: Heating cookerplate at different starting points
    Given cookerplate is <startTemp>
    When I heat the plate
    Then I should have a <endTemp> cookerplate

    Examples:
    | startTemp | endTemp |
    | cold    | warm    |

    # WRONG: violates DifferentValuesDatatable, EmptyCell
  # Can be fixed by either adding different starting temperatures or removing it as variable.
  # Add value at the empty action column
  Scenario Outline: Different actions on different starting temperatures
    Given cookerplate is <startTemp>
    When I <action> the plate
    Then I should have a <endTemp> cookerplate

    Examples:
    | startTemp | action | endTemp |
    | cold      | cool   | cold    |
    | cold      | cool   | cold    |
    | cold      | heat   | warm    |
    | cold      |        | cold    |

  #WRONG: NoScenarioStartComments, GivenAfterWhenOrThen, ThenAfterWhen, WhenAfterGiven.
  # Can be fixed by placing the comment after the scenario line and ordering the statements as Given, When, Then.
  Scenario: Do nothing in the wrong order
    Then cookerplate is cold
    When I do nothing
    Given cookerplate is cold

