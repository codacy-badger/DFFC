Feature: change alarm settings
  As a mobile app user
  in order to be able to wake up at the right time user has to manage the alarm settings

  Scenario: successfully change alarm sound
    Given user is logged in
    And user is on change alarm setting activity
    When user changes the alarm sound
    Then the alarm sound should be set to the new choice

  Scenario: successfully change alarm repeat time
    Given user is logged in
    And user is on change alarm setting activity
    When user changes the alarm repeat time
    Then the time before an alarm gets repeated should be changed

  Scenario: successfully change alarm repeat amount
    Given user is logged in
    And user is on change alarm setting activity
    When user changes the alarm repeat amount
    Then the number an alarm is repeated should be changed

  Scenario: not logged in when changing settings
    Given user is not logged in
    And user is on change alarm setting activity
    When user changes any setting
    Then the user should get an error
    And the user should be asked to log in