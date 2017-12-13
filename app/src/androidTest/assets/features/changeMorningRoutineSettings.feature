Feature: change morning routine settings
  As a mobile app user
  in order to customize how the app manages the time before an appointment user has to set a morning routine

  Scenario: successfully change wake up time before appointment
    Given user is on setting activity
    When user clicks morningroutine button
    And user clicks timeitem
    And user changes the wake up time
    Then the wake up time should be changed and displayed

  Scenario: successfully change information on wake up
    Given user is on setting activity
    When user clicks morningroutine button
    And user clicks messageitem
    And user changes the the information shown on wake up
    Then the information shown on wake should be changed and displayed
