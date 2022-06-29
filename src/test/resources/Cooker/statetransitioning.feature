Feature: Statetransitioning
  Cover all transitions of the state transition diagram of the cookerplate

  Scenario: Start with cold plate, heating up
    Given cookerplate is cold
    When I heat the plate
    Then I should have a warm cookerplate

  Scenario: Start with warm plate, heating up
    Given cookerplate is warm
    When I heat the plate
    Then I should have a hot cookerplate

  Scenario: Start with hot plate, heating up
    Given cookerplate is hot
    When I heat the plate
    Then I should have a hot cookerplate

  Scenario: Start with hot plate, cooling down
    Given cookerplate is hot
    When I cool the plate
    Then I should have a warm cookerplate

  Scenario: Start with warm plate, cooling down
    Given cookerplate is warm
    When I cool the plate
    Then I should have a cold cookerplate

  Scenario: Start with cold plate, cooling down
    Given cookerplate is cold
    When I cool the plate
    Then I should have a cold cookerplate

