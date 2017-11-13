Feature: get overview
  As a mobile app user
  in order to see the overview the user needs to use the overview function

  Scenario: check overview
    Given user is on overview activity
    Then user should see his managed appointments

  Scenario: check details
    Given user is on overview activity
    When chooses an appointment
    Then the detail view should open
    And user should see the details of the managed appointment

  Scenario: delete alarm for appointment
    Given user is on overview activity
    When chooses an appointment
    And the detail view is open
    And the user presses the delete alarm button
    Then the alarm should be deleted

  Scenario: minimize appointment
    Given user is on overview activity
    When chooses an appointment
    And the detail view is open
    And the user presses the minimize button
    Then the detail view should be closed
    And the user is back at the overview