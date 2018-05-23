Feature: Main
  the user gets displayed a Hello World test activity

  Scenario: Hello World
    Given user is on main activity
    When menubar is displayed
    Then helloWorld should be displayed