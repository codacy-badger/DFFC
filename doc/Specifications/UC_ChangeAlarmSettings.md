**WakeMeInTime**
----------------

**Use-Case Specification: Change alarm settings**
============================================================

**Version 1.0**
---------------

Revision History
================

| **Date**   | **Version** | **Description**      | **Author**                     |
|------------|-------------|----------------------|--------------------------------|
| 11/12/2017 | 1.0         | Creation of Document | Denny Flämig; Florian Christof |
|            |             |                      |                                |
|            |             |                      |                                |

**Use-Case Specification: Change alarm settings**

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

![alt text](https://github.com/flowriance/DFFC/blob/master/doc/Specifications/UC_ChangeAlarmSettings.png "Use Case Diagram: Change alarm settings")

*Mock-Up:*

![alt text][logo]

[logo]: https://github.com/flowriance/DFFC/blob/master/doc/Mockup_ChangeAlarmSettings.png "Mockup: Change alarm settings"

[*Feature file:*](https://github.com/flowriance/DFFC/blob/master/app/src/androidTest/assets/features/changeAlarmSettings.feature)

**changealarmsettings.feature**

```gherkin
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
