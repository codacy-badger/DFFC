**WakeMeInTime**
----------------

Software Requirements Specification
===================================

**Version 1.0**
---------------

Revision History
================

| **Date** | **Version** | **Description**                         | **Author**                     |
|----------|-------------|-----------------------------------------|--------------------------------|
| 22/10/17 | 1.0         | Initial version, added Use Case Diagram | Florian Christof; Denny Flämig |

1 Introduction
==============

1.1 Purpose
-----------

This SRS will define our project and will give a detailed description of all its
features.

1.2 Scope
---------

WakeMeInTime will be an application that will help you organize your
appointments automatically. As such the focus of this project will be mobile
platforms, specifically the Android system.

1.3 Definitions, Acronyms, and Abbreviations
--------------------------------------------

| Acronyms | Description                       |
|----------|-----------------------------------|
| MVC      | Model-View-Controller             |
| App      | Application                       |
| API      | Application-Programming-Interface |

1.4 References
--------------

Not applicable

1.5 Overview
------------

The idea behind WakeMeInTime changed from a simple alarm clock app to a complete
scheduling app. It grabs appointments from your calendar, checks the locations
and provides traffic information. It takes this information and sets your alarm
according to your customized time.

2 Overall Description
=====================

The following Use Case Diagram will show you the main features of our
application:

![alt text][logo]

[logo]: https://github.com/flowriance/DFFC/blob/master/doc/WakeMeInTime.png "Overall use case diagram"

3 Specific Requirements
=======================

3.1 Functionality
-----------------

### 3.1.1 Register

The user can register, primarily with his Google account, since most of our
functionality is based on Google services.

### 3.1.2 Login

The user can log in to our app by providing his Google account information.

### 3.1.3 Logout

The user can log out.

### 3.1.4 Get calendar data

The app can connect to your Google Calendar and read your appointment
information.

### 3.1.5 Get traffic information

The app can use Google to check for traffic data and can also use “Deutsche
Bahn” data or other local transportation service to get information about public
transportation.

### 3.1.6 Set alarm

The app has access to the alarm and can set it and change the alarm settings.

### 3.1.7 Set notification

The app will show you various notifications about your appointments, or how much
time you have left.

### 3.1.8 Change settings

The user can change various app setting.

### 3.1.9 [Change calendars](https://github.com/flowriance/DFFC/blob/master/doc/Specifications/UC_ChooseCalendars.md)

The user can select which calendars he wants to use for setting his alarm.

### 3.1.10 [Get overview](https://github.com/flowriance/DFFC/blob/master/doc/Specifications/UC_GetOverview.md)

The user get an overview about his alarms, his meetings and his personalized live traffic data.

3.2 Usability
-------------

### 3.2.1 Structured settings

The settings will be easy to reach and the user can adjust them without any
difficulty.

### 3.2.2 Easily accessible functions

All common functions will be available on the home screen, or will be
automatically provided in the form of notifications.

### 3.2.3 Language

The main language will be German, but an English version is possible.

3.3 Reliability
---------------

### 3.3.1 Accuracy

-   Position should be determined within a 20m radius.

-   Traffic data should be updated regularly, according to special rules.

### 3.3.2 Availability

24/7

### 3.3.3 Mean Time Between Failures

To be determined.

3.4 Performance
---------------

### 3.4.1 Response time

App should load fast after tapping the icon.

### 3.4.2 Capacity

There will be no limitation to the number of users.

### 3.4.3 Speed

The performance should be very fluent.

3.5 Supportability
------------------

### 3.5.1 Conventions

The code should follow the Java Naming Conventions and using speaking variable
and function names.

3.6 Design Constraints
----------------------

### 3.5.1 MVC pattern

The programming of this application will follow the MVC architecture pattern. It
decouples the major components model, view and controller. The model contains
the business logic, the view shows the result to the user and the controller is
the intermediary between those two. This allows for efficient code reuse and
parallel development.

### 3.5.2 Programming language

This application will be programmed in Kotlin and Java.

3.7 On-line User Documentation and Help System Requirements
-----------------------------------------------------------

In-App help-functions.

3.8 Purchased Components
------------------------

Not applicable.

3.9 Interfaces
--------------

### 3.9.1 User Interfaces

Users can access the system via Android app. Mockups for their design are
released soon.

### 3.9.2 Hardware Interfaces

Not applicable.

### 3.9.3 Software Interfaces

Several Google APIs

### 3.9.4 Communications Interfaces

-   Alarm Clock

-   Notification

-   Weather

3.10 Licensing Requirements
---------------------------

To be determined.

3.11 Legal, Copyright, and Other Notices
----------------------------------------

To be determined.

3.12 Applicable Standards
-------------------------

Not applicable.

4 Supporting Information
========================

To be determined.
