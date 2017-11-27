Feature: Login
  As a mobile app user
  in order to use the application the user needs to log in

  Scenario: valid login
    Given user is on login activity
    When user provides username "User"
    And user provides password "1234"
    And user presses the login button
    Then user should be successfully logged in as "User"

  Scenario Outline: invalid login
    Given User is on login activity
    When User provides username <username>
    And User provides password <password>
    And user presses the login button
    Then User should not be logged in
    And User should be shown an error message

    Examples:

      | username | password |
      | tester   | test     |
      | Admin    | wrong    |