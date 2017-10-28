Version \<1.0\>

Revision History

| **Date**   | **Version** | **Description**                         | **Author**                     |
|------------|-------------|-----------------------------------------|--------------------------------|
| 28.10.2017 | 1.0         | Initial version, added Use Case Diagram | Florian Christof; Denny Flämig |

Table of Contents

1. Introduction 4

1.1 Purpose 4

1.2 Scope 4

1.3 Definitions, Acronyms, and Abbreviations 4

1.4 References 4

1.5 Overview 4

2. Overall Description 4

3. Specific Requirements 4

3.1 Functionality 5

3.1.1 \<Functional Requirement One\> 5

3.2 Usability 5

3.2.1 \<Usability Requirement One\> 5

3.3 Reliability 5

3.3.1 \<Reliability Requirement One\> 5

3.4 Performance 5

3.4.1 \<Performance Requirement One\> 6

3.5 Supportability 6

3.5.1 \<Supportability Requirement One\> 6

3.6 Design Constraints 6

3.6.1 \<Design Constraint One\> 6

3.7 On-line User Documentation and Help System Requirements 6

3.8 Purchased Components 6

3.9 Interfaces 6

3.9.1 User Interfaces 6

3.9.2 Hardware Interfaces 6

3.9.3 Software Interfaces 6

3.9.4 Communications Interfaces 6

3.10 Licensing Requirements 6

3.11 Legal, Copyright, and Other Notices 7

3.12 Applicable Standards 7

4. Supporting Information 7

Introduction
============

Purpose
-------

This SRS will define our project and will give a detailed description of all its
features.

Scope
-----

>   WakeMeInTime will be an application that will help you organize your
>   appointments automatically. As such the focus of this project will be mobile
>   platforms, specifically the Android system.

Definitions, Acronyms, and Abbreviations
----------------------------------------

| Acronyms | Description                       |
|----------|-----------------------------------|
| MVC      | Model-View-Controller             |
| App      | Application                       |
| API      | Application-Programming-Interface |

References
----------

>   Not applicable

Overview
--------

>   The idea behind WakeMeInTime changed from a simple alarm clock app to a
>   complete scheduling app. It grabs appointments from your calendar, checks
>   the locations and provides traffic information. It takes this information
>   and sets your alarm according to your customized time.

Overall Description
===================

>   The following Use Case Diagram will show you the main features of our
>   application:

Specific Requirements 
======================

Functionality
-------------

### Register

>   The user can register, primarily with his Google account, since most of our
>   functionality is based on Google services.

### Login

The user can log in to our app by providing his Google account information.

### Logout

The user can log out.

### Get calendar data

>   The app can connect to your Google Calendar and read your appointment
>   information.

### Get traffic information

>   The app can use Google to check for traffic data and can also use “Deutsche
>   Bahn” data or other local transportation service to get information about
>   public transportation.

### Set alarm

The app has access to the alarm and can set it and change the alarm settings.

### Set notification

>   The app will show you various notifications about your appointments, or how
>   much time you have left.

### Change settings

The user can change various app setting.

Usability 
----------

### Structured settings

>   The settings will be easy to reach, and the user can adjust them without any
>   difficulty.

### Easily accessible functions

>   All common functions will be available on the home screen, or will be
>   automatically provided in the form of notifications.

### Language

>   The main language will be German, but an English version is possible.

Reliability 
------------

### Accuracy

-   Position should be determined within a 20m radius.

-   Traffic data should be updated regularly, according to special rules.

### Availability

>   24/7

### Mean Time Between Failures

>   To be determined.

Performance
-----------

### Response time

>   App should load fast after tapping the icon.

### Capacity

>   There will be no limitation to the number of users.

### Speed

>   The performance should be very fluent.

Supportability
--------------

### Conventions

>   The code should follow the Java Naming Conventions and using speaking
>   variable and function names.

Design Constraints
------------------

### MVC pattern

>   The programming of this application will follow the MVC architecture
>   pattern. It decouples the major components model, view and controller. The
>   model contains the business logic, the view shows the result to the user and
>   the controller is the intermediary between those two. This allows for
>   efficient code reuse and parallel development.

### Programming language

>   This application will be programmed in Kotlin and Java.

On-line User Documentation and Help System Requirements
-------------------------------------------------------

>   In-App help-functions.

Purchased Components
--------------------

>   Not applicable.

Interfaces
----------

### User Interfaces

>   Users can access the system via Android app. Mockups for their design can be
>   found at our use case specifications.

### Hardware Interfaces

>   Not applicable.

### Software Interfaces

>   Several Google APIs

### Communications Interfaces

-   Alarm Clock

-   Notification

-   Weather

Licensing Requirements
----------------------

>   To be determined.

Legal, Copyright, and Other Notices
-----------------------------------

>   To be determined.

Applicable Standards
--------------------

>   Not applicable.

Supporting Information
======================

>   To be determined.
