**WakeMeInTime**
----------------

**Use-Case Specification: Get overview**
============================================

**Version 1.0**
---------------

Revision History
================

| **Date**   | **Version** | **Description**      | **Author**                     |
|------------|-------------|----------------------|--------------------------------|
| 28/10/2017 | 1.0         | Creation of Document | Denny Flämig; Florian Christof |
| 13/11/2017 | 1.1         | Adding feature files | Denny Flämig; Florian Christof |
|            |             |                      |                                |

**Use-Case Specification: Get overview**

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

![alt text](https://github.com/flowriance/DFFC/blob/master/doc/Specifications/GetOverviewUCD.png "UCD: Get overview")

*Mock-Up:*
![alt text][logo]

[logo]: https://github.com/flowriance/DFFC/blob/master/doc/Mockup_GetOverview.png "Mockup: Get overview"



[*Feature file:*](https://github.com/flowriance/DFFC/blob/master/app/src/androidTest/assets/features/getOverview.feature)

```gherkin

Feature: get overview
  As a mobile app user
  in order to see the overview the user needs to use the overview function

  Scenario: check overview
    Given user is on overview activity
    Then user should see his managed appointments

  Scenario: check details
    Given user is on overview activity
    When chooses an appointment
    Then the detail view should open
    And user should see the details of the managed appointment

  Scenario: delete alarm for appointment
    Given user is on overview activity
    When chooses an appointment
    And the detail view is open
    And the user presses the delete alarm button
    Then the alarm should be deleted

  Scenario: minimize appointment
    Given user is on overview activity
    When chooses an appointment
    And the detail view is open
    And the user presses the minimize button
    Then the detail view should be closed
    And the user is back at the overview

```

3 Special Requirements
======================

3.1 Functionality on Android
----------------------------

Since this will be a game in form of an Android Application it is important for
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
