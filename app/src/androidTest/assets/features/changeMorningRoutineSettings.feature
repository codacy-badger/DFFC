Feature: change morning routine settings
  As a mobile app user
  in order to customize how the app manages the time before an appointment user has to set a morning routine

  Scenario: successfully change wake up time before appointment
    Given user is logged in
    And user is on change morning routine setting activity
    When user changes the wake up time
    Then the wake up time should be changed

  Scenario: successfully change information on wake up
    Given user is logged in
    And user is on change morning routine setting activity
    When user changes the the information shown on wake up
    Then the information shown on wake should be changed

  Scenario: not logged in when changing settings
    Given user is not logged in
    And user is on change morning routine setting activity
    When user changes any setting
    Then the user should get an error
    And the user should be asked to log in