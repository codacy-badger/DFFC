**WakeMeInTime**
----------------

**Use-Case Specification: Change morning routine settings**
============================================================

**Version 1.0**
---------------

Revision History
================

| **Date**   | **Version** | **Description**      | **Author**                     |
|------------|-------------|----------------------|--------------------------------|
| 28/10/2017 | 1.0         | Creation of Document | Denny Flämig; Florian Christof |
|            |             |                      |                                |
|            |             |                      |                                |

**Use-Case Specification: Change morning routine settings**

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

![alt text](https://github.com/flowriance/DFFC/blob/master/doc/Specifications/UC_ChangeMorningRoutineSettings.png "Use Case Diagram: Change morning routine settings")

*Mock-Up:*

![alt text][logo]

[logo]: https://github.com/flowriance/DFFC/blob/master/doc/Mockup_ChangeMorningRoutineSettings.png "Mockup: Change morning routine settings"


[*Feature file:*](https://github.com/flowriance/DFFC/blob/master/app/src/androidTest/assets/features/changeMorningRoutineSettings.feature)

**changemorningroutinesettings.feature**

```gherkin

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
