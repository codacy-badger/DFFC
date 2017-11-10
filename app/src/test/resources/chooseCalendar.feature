Feature: Choose calendar
  As a mobile app user
  in order to organize the appointments user has to choose a calendar

  Scenario: successful choice
    Given user is on choose calendar activity
    When user selects calendar
    Then calendar should be added to synchronized calendars
