**WakeMeInTime**
----------------

**Use-Case Specification: Change transportation settings**
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

**Use-Case Specification: Change transportation settings**

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

![alt text](https://github.com/flowriance/DFFC/blob/master/doc/Specifications/UC_ChangeTransportationSettings.png "Use Case Diagram: Change transportation settings")

*Mock-Up:*

![alt text][logo]

[logo]: https://github.com/flowriance/DFFC/blob/master/doc/Mockup_ChangeTransportationSettings.png "Mockup: Change transportation settings"


[*Feature file:*](https://github.com/flowriance/DFFC/blob/master/app/src/androidTest/assets/features/changeTransportationSettings.feature)

**changetransportationsettings.feature**

```gherkin

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
