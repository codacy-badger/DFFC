**WakeMeInTime**
----------------

**Use-Case Specification: Choose calendars**
============================================

**Version 1.0**
---------------

Revision History
================

| **Date**   | **Version** | **Description**      | **Author**                     |
|------------|-------------|----------------------|--------------------------------|
| 28/10/2017 | 1.0         | Creation of Document | Denny Flämig; Florian Christof |
|            |             |                      |                                |
|            |             |                      |                                |

**Use-Case Specification: Choose calendars**

1 Use-Case Name
===============

1.1 Brief Description
---------------------

To be determined.

2 Flow of Events
================

2.1 Basic Flow
--------------

*Activity Diagram(UML):*

![alt text](https://github.com/flowriance/DFFC/blob/master/doc/Specifications/ChooseCalendarUCD.png "Use Case Diagram: Choose calendar")

*Mock-Up:*

![alt text][logo]

[logo]: https://github.com/flowriance/DFFC/blob/master/doc/Mockup_ChooseCalendar.png "Mockup: Choose calendar"

*Feature file:*

**Login**

```

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

```

3 Special Requirements
======================

3.1 Functionality on Android
----------------------------

Since this will be an Android Application it is important for
every design such as this to be fitting for Smartphone screens.

4 Preconditions
===============

4.1 \<Precondition 1\>
----------------------

…

5 Postconditions
================

5.1 \<Postcondition 1\>
------------------------

…

6 Extension Points
===================

...
