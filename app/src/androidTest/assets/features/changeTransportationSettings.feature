Feature: change transportation settings
  As a mobile app user
  in order to react to changes in traffic user has to manage the traffic settings

  Scenario: successfully change travel method
    Given user is logged in
    And user is on change travel setting activity
    When user changes the travel method
    Then the travel method should be changed

  Scenario: successfully change update frequency
    Given user is logged in
    And user is on change travel setting activity
    When user changes the update frequency
    Then the update frequency should be changed

  Scenario: not logged in when changing settings
    Given user is not logged in
    And user is on change travel setting activity
    When user changes any setting
    Then the user should get an error
    And the user should be asked to log in