Version \<1.0\>

Revision History

| **Date**      | **Version** | **Description** | **Author** |
| ------------- | ----------- | --------------- | ---------- |
| \<16/005/18\> | \<1.0\>     | \<Initial\>     | \<Florian Christof; Denny Flämig\>   |
|               |             |                 |            |
|               |             |                 |            |
|               |             |                 |            |

Table of Contents

1\. Introduction 3

1.1 Purpose 3

1.2 Scope 3

1.3 Intended Audience 3

1.4 Document Terminology and Acronyms 3

1.5 References 3

1.6 Document Structure 3

2\. Evaluation Mission and Test Motivation 3

2.1 Background 3

2.2 Evaluation Mission 3

2.3 Test Motivators 3

3\. Target Test Items 3

4\. Outline of Planned Tests 3

4.1 Outline of Test Inclusions 3

4.2 Outline of other candidates for potential inclusion 3

4.3 Outline of Test Exclusions 3

5\. Test Approach 3

5.1 Initial Test-Idea Catalogs and other reference sources 3

5.2 Testing Techniques and Types 3

5.2.1 Data and Database Integrity Testing 3

5.2.2 Function Testing 3

5.2.3 Business Cycle Testing 3

5.2.4 User Interface Testing 3

5.2.5 Performance Profiling 3

5.2.6 Load Testing 3

5.2.7 Stress Testing 3

5.2.8 Volume Testing 3

5.2.9 Security and Access Control Testing 3

5.2.10 Failover and Recovery Testing 3

5.2.11 Configuration Testing 3

5.2.12 Installation Testing 3

6\. Entry and Exit Criteria 3

6.1 Test Plan 3

6.1.1 Test Plan Entry Criteria 3

6.1.2 Test Plan Exit Criteria 3

6.1.3 Suspension and resumption criteria 3

6.2 Test Cycles 3

6.2.1 Test Cycle Entry Criteria 3

6.2.2 Test Cycle Exit Criteria 3

6.2.3 Test Cycle abnormal termination 3

7\. Deliverables 3

7.1 Test Evaluation Summaries 3

7.2 Reporting on Test Coverage 3

7.3 Perceived Quality Reports 3

7.4 Incident Logs and Change Requests 3

7.5 Smoke Test Suite and supporting Test Scripts 3

7.6 Additional work products 3

7.6.1 Detailed Test Results 3

7.6.2 Additional automated functional Test Scripts 3

7.6.3 Test Guidelines 3

7.6.4 Traceability Matrices 3

8\. Testing Workflow 3

9\. Environmental Needs 3

9.1 Base System Hardware 3

9.2 Base Software Elements in the Test Environment 3

9.3 Productivity and Support Tools 3

9.4 Test Environment Configurations 3

10\. Responsibilities, Staffing and Training Needs 3

10.1 People and Roles 3

10.2 Staffing and Training Needs 3

11\. Iteration Milestones 3

12\. Risks, Dependencies, Assumptions and Constraints 3

13\. Management Process and Procedures 3

13.1 Measuring and Assessing the Extent of Testing 3

13.2 Assessing the deliverables of this Test Plan 3

13.3 Problem Reporting, Escalation and Issue Resolution 3

13.4 Managing Test Cycles 3

13.5 Traceability Strategies 3

13.6 Approval and Signoff 3

# Introduction

## Purpose

The purpose of the Iteration Test Plan is to gather all of the
information necessary to plan and control the test effort for a given
iteration. It describes the approach to testing the software, and is the
top-level plan generated and used by managers to direct the test effort.

This *Test Plan* for the supports the following objectives:

• Identifies the items that should be targeted by the tests.

• Identifies the motivation for and ideas behind the test areas to be
covered.

• Outlines the testing approach that will be used.

• Identifies the required resources and provides an estimate of the test
efforts.

• Lists the deliverable elements of the test project.

## Scope

We do some Unit testing and some Integration Testing. Theres also some Surface Testing we did.

## Intended Audience

The audience are our customers that want to know how our testing runs and what we test. For developers it might also be interesting.

## Document Terminology and Acronyms



##  References


## Document Structure

(Table of Contents above)

# Evaluation Mission and Test Motivation

Our Motivation is to produce a perfect product. To ensure this and to show this to our customers we do Testing so everyone sees how great we are doing.

## Background

Studies showed that you win the time that you spent on unit testing at the end of your project. The time at the end is mostly the most productive time and you save lot of time.

## Evaluation Mission

Our mission is to:

  - find as many bugs as possible

  - find important problems, assess perceived quality risks

  - advise about perceived project risks

  - certify to a standard

  - verify a specification (requirements, design or claims)

  - advise about product quality, satisfy stakeholders

  - advise about testing

  - fulfill process mandates

  - and so forth

Each mission provides a different context to the test effort and alters
the way in which testing should be approached.

## Test Motivators

Our test motivators are quality risks, technical risks, project risks, use cases,
functional requirements, non-functional requirements, design elements,
suspected failures or faults, change requests.

# Target Test Items

- Units
- Database
- User interface
- etc.


# Outline of Planned Tests

- Example unit test
- Test of our Data models
  - Calendar
  - DataTraffic


## Outline of Test Inclusions



## Outline of Other Candidates for Potential Inclusion

Maybe we will add some Instrumentation Test for our databaseHelper :) This needs a test context so its not testable by unit tests.

## Outline of Test Exclusions

We will not unit test our database, because you need a test context for it :) We also wont Unit test our activity create Methods because they are overwritten from another android class.

# Test Approach

Test Driven Development means that you first create the test, then you try to implement the feature and make the tests pass.

## Initial Test-Idea Catalogs and Other Reference Sources


## Testing Techniques and Types

### Data and Database Integrity Testing

The databases and the database processes should be tested as an
independent subsystem. This testing should test the subsystems without
the target-of-test’s User Interface as the interface to the data.
Additional research into the DataBase Management System (DBMS) needs to
be performed to identify the tools and techniques that may exist to
support the testing identified in the following table.

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th>Exercise database access methods and processes independent of the UI so you can observe and log incorrect functioning target behavior or data corruption.</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><p>• Invoke each database access method and process, seeding each with valid and invalid data or requests for data.</p>
<p>• Inspect the database to ensure the data has been populated as intended and all database events have occurred properly, or review the returned data to ensure that the correct data was retrieved for the correct reasons.</p></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td></td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>The technique requires the following tools:</p>
<ul>
<li><p>Test Script Automation Tool</p></li>
<li><p>base configuration imager and restorer</p></li>
<li><p>backup and recovery tools</p></li>
<li><p>installation-monitoring tools (registry, hard disk, CPU, memory, and so forth)</p></li>
<li><p>database SQL utilities and tools</p></li>
<li><p>Data-generation tools</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td>The technique supports the testing of all key database access methods and processes.</td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td><ul>
<li><p>Small or minimally sized databases (limited number of records) should be used to increase the visibility of any non-acceptable events.]</p></li>
</ul></td>
</tr>
</tbody>
</table>

### Function Testing

Function testing of the target-of-test should focus on any
requirements for test that can be traced directly to use cases or
business functions and business rules. The goals of these tests are to
verify proper data acceptance, processing, and retrieval, and the
appropriate implementation of the business rules. This type of testing
is based upon black box techniques; that is verifying the application
and its internal processes by interacting with the application via the
Graphical User Interface (GUI) and analyzing the output or results. The
following table identifies an outline of the testing recommended for
each application.

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th>Exercise target-of-test functionality, including navigation, data entry, processing, and retrieval to observe and log target behavior.</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><p>Execute each use-case scenario’s individual use-case flows or functions and features, using valid and invalid data, to verify that:</p>
<p>• the expected results occur when valid data is used</p>
<p>• the appropriate error or warning messages are displayed when invalid data is used</p>
<p>• each business rule is properly applied</p></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>The technique requires the following tools:</p>
<ul>
<li><p>Test Script Automation Tool</p></li>
<li><p>Data-generation tools</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td><p>The technique supports the testing of:</p>
<p>• all key use-case scenarios</p>
<p>• all key features</p></td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td>-</td>
</tr>
</tbody>
</table>

###   
Business Cycle Testing

Business Cycle Testing should emulate the activities performed on the
over time. A period should be identified, such as one year, and
transactions and activities that would occur during a year’s period
should be executed. This includes all daily, weekly, and monthly cycles,
and events that are date-sensitive, such as ticklers.

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th>[Exercise target-of-test and background processes according to required business models and schedules to observe and log target behavior.]</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><p>[Testing will simulate several business cycles by performing the following:</p>
<ul>
<li><p>The tests used for target-of-test’s function testing will be modified or enhanced to increase the number of times each function is executed to simulate several different users over a specified period.</p></li>
<li><p>All time or date-sensitive functions will be executed using valid and invalid dates or time periods.</p></li>
<li><p>All functions that occur on a periodic schedule will be executed or launched at the appropriate time.</p></li>
<li><p>Testing will include using valid and invalid data to verify the following:</p>
<ul>
<li><p>The expected results occur when valid data is used.</p></li>
<li><p>The appropriate error or warning messages are displayed when invalid data is used.</p></li>
<li><p>Each business rule is properly applied.]</p></li>
</ul></li>
</ul></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>The technique requires the following tools:</p>
<ul>
<li><p>Test Script Automation Tool</p></li>
<li><p>base configuration imager and restorer</p></li>
<li><p>backup and recovery tools</p></li>
<li><p>Data-generation tools</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td>The technique supports the testing of all critical business cycles.</td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td><p>• System dates and events may require special support activities.</p>
<p>• A business model is required to identify appropriate test requirements and procedures.</p></td>
</tr>
</tbody>
</table>

###   
User Interface Testing

User Interface (UI) testing verifies a user’s interaction with the
software. The goal of UI testing is to ensure that the UI provides the
user with the appropriate access and navigation through the functions of
the target-of-test. In addition, UI testing ensures that the objects
within the UI function as expected and conform to corporate or industry
standards.

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th><p>Exercise the following to observe and log standards conformance and target behavior:</p>
<ul>
<li><p>Navigation through the target-of-test reflecting business functions and requirements, including window-to-window, field-to- field, and use of access methods (tab keys, mouse movements, accelerator keys).</p></li>
<li><p>Window objects and characteristics can be exercised–such as menus, size, position, state, and focus.</p></li>
</ul></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td>[Create or modify tests for each window to verify proper navigation and object states for each application window and object.]</td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td>[The technique requires the Test Script Automation Tool.]</td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td>[The technique supports the testing of each major screen or window that will be used extensively by the end user.]</td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td>[Not all properties for custom and third-party objects can be accessed.]</td>
</tr>
</tbody>
</table>

### Performance Profiling 

\[Performance profiling is a performance test in which response times,
transaction rates, and other time-sensitive requirements are measured
and evaluated. The goal of Performance Profiling is to verify
performance requirements have been achieved. Performance profiling is
implemented and executed to profile and tune a target-of-test's
performance behaviors as a function of conditions such as workload or
hardware configurations.

**Note**: Transactions in the following table refer to “logical business
transactions”. These transactions are defined as specific use cases that
an actor of the system is expected to perform using the target-of-test,
such as add or modify a given contract.\]

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th><p>[Exercise behaviors for designated functional transactions or business functions under the following conditions to observe and log target behavior and application performance data:</p>
<p>• normal anticipated workload</p>
<p>• anticipated worst-case workload]</p></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><p>• [Use Test Procedures developed for Function or Business Cycle Testing.</p>
<p>• Modify data files to increase the number of transactions or the scripts to increase the number of iterations that occur in each transaction.</p>
<p>• Scripts should be run on one machine (best case to benchmark single user, single transaction) and should be repeated with multiple clients (virtual or actual, see Special Considerations below).]</p></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>[The technique requires the following tools:</p>
<ul>
<li><p>Test Script Automation Tool</p></li>
<li><p>an application performance profiling tool, such as Rational Quantify</p></li>
<li><p>installation-monitoring tools (registry, hard disk, CPU, memory, and so on</p></li>
<li><p>resource-constraining tools; for example, Canned Heat]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td><p>The technique supports testing:</p>
<p>• Single Transaction or single user: Successful emulation of the transaction scripts without any failures due to test implementation problems.]</p>
<p>• Multiple transactions or multiple users: Successful emulation of the workload without any failures due to test implementation problems.]</p></td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td><p>[Comprehensive performance testing includes having a background workload on the server.</p>
<p>There are several methods that can be used to perform this, including:</p>
<p>• “Drive transactions” directly to the server, usually in the form of Structured Query Language (SQL) calls.</p>
<p>• Create “virtual” user load to simulate many clients, usually several hundred. Remote Terminal Emulation tools are used to accomplish this load. This technique can also be used to load the network with “traffic”.</p>
<p>• Use multiple physical clients, each running test scripts, to place a load on the system.</p>
<p>Performance testing should be performed on a dedicated machine or at a dedicated time. This permits full control and accurate measurement.</p>
<p>The databases used for Performance Testing should be either actual size or scaled equally.]</p></td>
</tr>
</tbody>
</table>

### Load Testing

\[Load testing is a performance test that subjects the target-of-test to
varying workloads to measure and evaluate the performance behaviors and
abilities of the target-of-test to continue to function properly under
these different workloads. The goal of load testing is to determine and
ensure that the system functions properly beyond the expected maximum
workload. Additionally, load testing evaluates the performance
characteristics, such as response times, transaction rates, and other
time-sensitive issues).\]

\[**Note**: Transactions in the following table refer to “logical
business transactions”. These transactions are defined as specific
functions that an end user of the system is expected to perform using
the application, such as add or modify a given contract.\]

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th>[Exercise designated transactions or business cases under varying workload conditions to observe and log target behavior and system performance data.]</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><p>• [Use Transaction Test Scripts developed for Function or Business Cycle Testing as a basis, but remember to remove unnecessary interactions and delays.</p>
<p>• Modify data files to increase the number of transactions or the tests to increase the number of times each transaction occurs.</p>
<p>• Workloads should include (for example, Daily, Weekly, Monthly and so forth) Peak loads.</p>
<p>• Workloads should represent both Average as well as Peak loads.</p>
<p>• Workloads should represent both Instantaneous and Sustained Peaks.</p>
<p>• The Workloads should be executed under different Test Environment Configurations.]</p></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>[The technique requires the following tools:</p>
<ul>
<li><p>Test Script Automation Tool</p></li>
<li><p>Transaction Load Scheduling and control tool</p></li>
<li><p>installation-monitoring tools (registry, hard disk, CPU, memory, and so on)</p></li>
<li><p>resource-constraining tools (for example, Canned Heat)</p></li>
<li><p>Data-generation tools]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td>[The technique supports the testing of Workload Emulation, which is the successful emulation of the workload without any failures due to test implementation problems.]</td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td><p>• [Load testing should be performed on a dedicated machine or at a dedicated time. This permits full control and accurate measurement.</p>
<p>• The databases used for load testing should be either actual size or scaled equally.]</p></td>
</tr>
</tbody>
</table>

### Stress Testing

\[Stress testing is a type of performance test implemented and executed
to understand how a system fails due to conditions at the boundary, or
outside of, the expected tolerances. This typically involves low
resources or competition for resources. Low resource conditions reveal
how the target-of-test fails that is not apparent under normal
conditions. Other defects might result from competition for shared
resources, like database locks or network bandwidth, although some of
these tests are usually addressed under functional and load testing.\]

\[**Note**: References to transactions in the following table refer to
logical business transactions.\]

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th><p>[Exercise the target-of-test functions under the following stress conditions to observe and log target behavior that identifies and documents the conditions under which the system <strong>fails</strong> to continue functioning properly</p>
<p>• little or no memory available on the server (RAM and persistent storage space)</p>
<p>• maximum actual or physically capable number of clients connected or simulated</p>
<p>• multiple users performing the same transactions against the same data or accounts</p>
<p>• “overload” transaction volume or mix (see Performance Profiling above)]</p></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><p>• [Use tests developed for Performance Profiling or Load Testing.</p>
<p>• To test limited resources, tests should be run on a single machine, and RAM and persistent storage space on the server should be reduced or limited.</p>
<p>• For remaining stress tests, multiple clients should be used, either running the same tests or complementary tests to produce the worst-case transaction volume or mix.</p></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>[The technique requires the following tools:</p>
<ul>
<li><p>Test Script Automation Tool</p></li>
<li><p>Transaction Load Scheduling and control tool</p></li>
<li><p>installation-monitoring tools (registry, hard disk, CPU, memory, and so on)</p></li>
<li><p>resource-constraining tools (for example, Canned Heat)</p></li>
<li><p>Data-generation tools]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td>The technique supports the testing of Stress Emulation. The system can be emulated successfully in one or more conditions defined as stress conditions and an observation of the resulting system state during and after the condition has been emulated can be captured.]</td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td><p>• [Stressing the network may require network tools to load the network with messages or packets.</p>
<p>• The persistent storage used for the system should temporarily be reduced to restrict the available space for the database to grow.</p>
<p>• Synchronize the simultaneous clients accessing of the same records or data accounts.]</p></td>
</tr>
</tbody>
</table>

###   
Volume Testing

\[Volume testing subjects the target-of-test to large amounts of data to
determine if limits are reached that cause the software to fail. Volume
testing also identifies the continuous maximum load or volume the
target-of-test can handle for a given period. For example, if the
target-of-test is processing a set of database records to generate a
report, a Volume Test would use a large test database, and would check
that the software behaved normally and produced the correct report.\]

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th><p>[Exercise the target-of-test under the following high volume scenarios to observe and log target behavior:</p>
<p>• Maximum (actual or physically-capable) number of clients connected, or simulated, all performing the same, worst case (performance) business function for an extended period.</p>
<p>• Maximum database size has been reached (actual or scaled) and multiple queries or report transactions are executed simultaneously.]</p></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><p>• [Use tests developed for Performance Profiling or Load Testing.</p>
<p>• Multiple clients should be used, either running the same tests or complementary tests to produce the worst-case transaction volume or mix (see Stress Testing) for an extended period.</p>
<p>• Maximum database size is created (actual, scaled, or filled with representative data) and multiple clients are used to run queries and report transactions simultaneously for extended periods.]</p></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>[The technique requires the following tools:</p>
<ul>
<li><p>Test Script Automation Tool</p></li>
<li><p>Transaction Load Scheduling and control tool</p></li>
<li><p>installation-monitoring tools (registry, hard disk, CPU, memory, and so on)</p></li>
<li><p>resource-constraining tools (for example, Canned Heat)</p></li>
<li><p>Data-generation tools]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td>[The technique supports the testing of Volume Emulation. Large quantities of users, data, transactions, or other aspects of the system use under volume can be successfully emulated and an observation of the system state changes over the duration of the volume test can be captured.]</td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td>[What period of time would be considered an acceptable time for high volume conditions, as noted above?]</td>
</tr>
</tbody>
</table>

###   
Security and Access Control Testing

\[Security and Access Control Testing focuses on two key areas of
security:

• Application-level security, including access to the Data or Business
Functions

• System-level Security, including logging into or remotely accessing to
the system.

Based on the security you want, application-level security ensures that
actors are restricted to specific functions or use cases, or they are
limited in the data that is available to them. For example, everyone may
be permitted to enter data and create new accounts, but only managers
can delete them. If there is security at the data level, testing ensures
that “user type one” can see all customer information, including
financial data, however, “user two” only sees the demographic data for
the same client.

System-level security ensures that only those users granted access to
the system are capable of accessing the applications and only through
the appropriate gateways.\]

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th><p>[Exercise the target-of-test under the following conditions to observe and log target behavior:</p>
<ul>
<li><p>Application-level Security: an actor can access only those functions or data for which their user type is provided permissions.</p></li>
<li><p>System-level Security: only those actors with access to the system and applications are permitted to access them.</p></li>
</ul></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><ul>
<li><p>[Application-level Security: Identify and list each user type and the functions or data each type has permissions for.]</p>
<ul>
<li><p>Create tests for each user type and verify each permission by creating transactions specific to each user type.</p></li>
<li><p>Modify user type and re-run tests for same users. In each case, verify those additional functions or data are correctly available or denied.</p></li>
</ul></li>
<li><p>System-level Access: [See Special Considerations below]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>[The technique requires the following tools:</p>
<ul>
<li><p>Test Script Automation Tool</p></li>
<li><p>“Hacker” security breach and probing tools</p></li>
<li><p>OS Security Admin Tools]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td>[The technique supports the testing of for each known actor type the appropriate functions or data affected by security settings can be tested.]</td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td>[Access to the system must be reviewed or discussed with the appropriate network or systems administrator. This testing may not be required as it may be a function of network or systems administration.]</td>
</tr>
</tbody>
</table>

### Failover and Recovery Testing

\[Failover and recovery testing ensures that the target-of-test can
successfully failover and recover from a variety of hardware, software
or network malfunctions with undue loss of data or data integrity.

For those systems that must be kept running failover testing ensures
that, when a failover condition occurs, the alternate or backup systems
properly “take over” for the failed system without any loss of data or
transactions.

Recovery testing is an antagonistic test process in which the
application or system is exposed to extreme conditions, or simulated
conditions, to cause a failure, such as device Input/Output (I/O)
failures, or invalid database pointers and keys. Recovery processes are
invoked, and the application or system is monitored and inspected to
verify proper application, or system, and data recovery has been
achieved.\]

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th><p>[Simulate the failure conditions and exercise the recovery processes (manual and automated) to restore the database, applications, and system to a desired, known, state. The following types of conditions are included in the testing to observe and log target behavior after recovery:</p>
<p>• power interruption to the client</p>
<p>• power interruption to the server</p>
<p>• communication interruption via network servers</p>
<p>• interruption, communication, or power loss to DASD (Dynamic Access Storage Devices) and DASD controllers</p>
<p>• incomplete cycles (data filter processes interrupted, data synchronization processes interrupted)</p>
<p>• invalid database pointers or keys</p>
<p>• invalid or corrupted data elements in database]</p></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><p>[The tests already created for Function and Business Cycle testing can be used as a basis for creating a series of transactions to support failover and recovery testing, primarily to define the tests to be run to test that recovery was successful.</p>
<p>• Power interruption to the client: power the PC down.</p>
<p>• Power interruption to the server: simulate or initiate power down procedures for the server.</p>
<p>• Interruption via network servers: simulate or initiate communication loss with the network (physically disconnect communication wires or power down network servers or routers).</p>
<p>• Interruption, communication, or power loss to DASD and DASD controllers: simulate or physically eliminate communication with one or more DASDs or controllers.</p>
<p>Once the above conditions or simulated conditions are achieved, additional transactions should be executed and, upon reaching this second test point state, recovery procedures should be invoked.</p>
<p>Testing for incomplete cycles uses the same technique as described above except that the database processes themselves should be aborted or prematurely terminated.</p>
<p>Testing for the following conditions requires that a known database state be achieved.</p>
<p>Several database fields, pointers, and keys should be corrupted manually and directly within the database (via database tools). Additional transactions should be executed using the tests from Application Function and Business Cycle Testing and full cycles executed.]</p></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>[The technique requires the following tools:</p>
<ul>
<li><p>base configuration imager and restorer</p></li>
<li><p>installation monitoring tools (registry, hard disk, CPU, memory, and so on)</p></li>
<li><p>backup and recovery tools]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td><p>The technique supports the testing of:</p>
<ul>
<li><p>One or more simulated disasters involving one or more combinations of the application, database, and system.</p></li>
<li><p>One or more simulated recoveries involving one or more combinations of the application, database, and system to a known desired state.]</p></li>
</ul></td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td><ul>
<li><p>[Recovery testing is highly intrusive. Procedures to disconnect cabling (simulating power or communication loss) may not be desirable or feasible. Alternative methods, such as diagnostic software tools may be required.</p></li>
<li><p>Resources from the Systems (or Computer Operations), Database, and Networking groups are required.</p></li>
<li><p>These tests should be run after hours or on an isolated machine.]</p></li>
</ul></td>
</tr>
</tbody>
</table>

### Configuration Testing

\[Configuration testing verifies the operation of the target-of-test on
different software and hardware configurations. In most production
environments, the particular hardware specifications for the client
workstations, network connections, and database servers vary. Client
workstations may have different software loadedfor example,
applications, drivers, and so onand, at any one time, many different
combinations may be active using different resources.\]

<table>
<thead>
<tr class="header">
<th>Technique Objective:</th>
<th>Exercise the target-of-test on the required hardware and software configurations to observe and log target behavior under different configurations and identify changes in configuration state.</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Technique:</td>
<td><ul>
<li><p>Use Function Test scripts.</p></li>
<li><p>Open and close various non-target-of-test related software, such as Microsoft Excel and Word applications, either as part of the test or prior to the start of the test.</p></li>
<li><p>Execute selected transactions to simulate actors interacting with the target-of-test and the non-target-of-test software.</p></li>
<li><p>Repeat the above process, minimizing the available conventional memory on the client workstation.]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Oracles:</td>
<td>[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]</td>
</tr>
<tr class="odd">
<td>Required Tools:</td>
<td><p>[The technique requires the following tools:</p>
<ul>
<li><p>base configuration imager and restore</p></li>
<li><p>installation monitoring tools (registry, hard disk, CPU, memory, and so on)]</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Success Criteria:</td>
<td>[The technique supports the testing of one or more combinations of the target test items running in expected, supported deployment environments.]</td>
</tr>
<tr class="odd">
<td>Special Considerations:</td>
<td><ul>
<li><p>[What non-target-of-test software is needed, is available, and what is accessible on the desktop?</p></li>
<li><p>What applications are typically used?</p></li>
<li><p>What data are the applications running; for example, a large spreadsheet opened in Excel or a 100-page document in Word?</p></li>
<li><p>The entire system’s netware, network servers, databases, and so on, also needs to be documented as part of this test.]</p></li>
</ul></td>
</tr>
</tbody>
</table>

### Installation Testing

(n/a)

# Entry and Exit Criteria

## Test Plan

### Test Plan Entry Criteria

\[Specify the criteria that will be used to determine whether the
execution of the **Test Plan** can begin.\]

### Test Plan Exit Criteria

\[Specify the criteria that will be used to determine whether the
execution of the **Test Plan** is complete or that continued execution
provides no further benefit.\]

###  Suspension and Resumption Criteria

\[Specify the criteria that will be used to determine whether testing
should be prematurely suspended or ended before the plan has been
completely executed, and under what criteria testing can be resumed.\]

## Test Cycles

(tbd.)

### Test Cycle Entry Criteria

(tbd.)

### Test Cycle Exit Criteria
(tbd.)

### Test Cycle Abnormal Termination

(tbd.)

# Deliverables

(tbd.)

## Test Evaluation Summaries

(tbd.)

## Reporting on Test Coverage

(tbd.)

## Perceived Quality Reports

(n/a)

## Incident Logs and Change Requests

(n/a)

## Smoke Test Suite and Supporting Test Scripts

(n/a)

## Additional Work Products

(n/a)

### Detailed Test Results

(n/a)

### Additional Automated Functional Test Scripts

(N/A)

### Test Guidelines

Common Best Practices are used.

### Traceability Matrices

(n/a)

# Testing Workflow

(n/a)

# Environmental Needs

Android Studio with Kotlin plugin

## Base System Hardware

(n/a)
## Base Software Elements in the Test Environment

The following base software elements are required in the test
environment for this *Test Plan*.
(n/A)

| **Software Element Name**               | **Version** | **Type and Other Notes**              |
| --------------------------------------- | ----------- | ------------------------------------- |


## Productivity and Support Tools

The following tools will be employed to support the test process for
this *Test Plan*.

\[Note: Add or delete items as
appropriate.\]

| **Tool Category or Type**         | **Tool Brand Name** | **Vendor or In-house** | **Version** |
| --------------------------------- | ------------------- | ---------------------- | ----------- |
| Test Management                   |                     |                        |             |
| Defect Tracking                   |                     |                        |             |
| ASQ Tool for functional testing   |                     |                        |             |
| ASQ Tool for performance testing  |                     |                        |             |
| Test Coverage Monitor or Profiler |                     |                        |             |
| Project Management                |                     |                        |             |
| DBMS tools                        |                     |                        |             |

# 

## Test Environment Configurations

(n/a)

The following Test Environment Configurations needs to be provided and
supported for this
project.

| **Configuration Name**            | **Description** | **Implemented in Physical Configuration** |
| --------------------------------- | --------------- | ----------------------------------------- |
| Average user configuration        |                 |                1                          |
| Minimal configuration supported   |                 |                                           |
| Visually and mobility challenged  |                 |                                           |
| International Double Byte OS      |                 |                                           |
| Network installation (not client) |                 |                                           |

# Responsibilities, Staffing, and Training Needs

((n/a))

## People and Roles

(tbd.)

This table shows the staffing assumptions for the test effort.


<table>
<thead>
<tr class="header">
<th><strong>Human Resources</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Role</strong></td>
<td><p><strong>Minimum Resources Recommended</strong></p>
<p><strong>(number of full-time roles allocated)</strong></p></td>
<td><strong>Specific Responsibilities or Comments</strong></td>
</tr>
<tr class="even">
<td>Test Manager</td>
<td></td>
<td><p>Provides management oversight.</p>
<p>Responsibilities include:</p>
<ul>
<li><p>planning and logistics</p></li>
<li><p>agree mission</p></li>
<li><p>identify motivators</p></li>
<li><p>acquire appropriate resources</p></li>
<li><p>present management reporting</p></li>
<li><p>advocate the interests of test</p></li>
<li><p>evaluate effectiveness of test effort</p></li>
</ul></td>
</tr>
<tr class="odd">
<td>Test Analyst</td>
<td></td>
<td><p>Identifies and defines the specific tests to be conducted.</p>
<p>Responsibilities include:</p>
<ul>
<li><p>identify test ideas</p></li>
<li><p>define test details</p></li>
<li><p>determine test results</p></li>
<li><p>document change requests</p></li>
<li><p>evaluate product quality</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Test Designer</td>
<td></td>
<td><p>Defines the technical approach to the implementation of the test effort.</p>
<p>Responsibilities include:</p>
<ul>
<li><p>define test approach</p></li>
<li><p>define test automation architecture</p></li>
<li><p>verify test techniques</p></li>
<li><p>define testability elements</p></li>
<li><p>structure test implementation</p></li>
</ul></td>
</tr>
<tr class="odd">
<td>Tester</td>
<td></td>
<td><p>Implements and executes the tests.</p>
<p>Responsibilities include:</p>
<ul>
<li><p>implement tests and test suites</p></li>
<li><p>execute test suites</p></li>
<li><p>log results</p></li>
<li><p>analyze and recover from test failures</p></li>
<li><p>document incidents</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Test System Administrator</td>
<td></td>
<td><p>Ensures test environment and assets are managed and maintained.</p>
<p>Responsibilities include:</p>
<ul>
<li><p>administer test management system</p></li>
<li><p>install and support access to, and recovery of, test environment configurations and test labs</p></li>
</ul></td>
</tr>
<tr class="odd">
<td>Database Administrator, Database Manager</td>
<td></td>
<td><p>Ensures test data (database) environment and assets are managed and maintained.</p>
<p>Responsibilities include:</p>
<ul>
<li><p>support the administration of test data and test beds (database).</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Designer</td>
<td></td>
<td><p>Identifies and defines the operations, attributes, and associations of the test classes.</p>
<p>Responsibilities include:</p>
<ul>
<li><p>defines the test classes required to support testability requirements as defined by the test team</p></li>
</ul></td>
</tr>
<tr class="odd">
<td>Implementer</td>
<td></td>
<td><p>Implements and unit tests the test classes and test packages.</p>
<p>Responsibilities include:</p>
<ul>
<li><p>creates the test components required to support testability requirements as defined by the designer</p></li>
</ul></td>
</tr>
</tbody>
</table>

## Staffing and Training Needs

(n/a)

# Iteration Milestones


| **Milestone**                    | **Planned Start Date** | **Actual Start Date** | **Planned End Date** | **Actual End Date** |
| -------------------------------- | ---------------------- | --------------------- | -------------------- | ------------------- |
| Iteration Plan agreed            |                        |                       |                      |                     |
| Iteration starts                 |                        |                       |                      |                     |
| Requirements baselined           |                        |                       |                      |                     |
| Architecture baselined           |                        |                       |                      |                     |
| User Interface baselined         |                        |                       |                      |                     |
| First Build delivered to test    |                        |                       |                      |                     |
| First Build accepted into test   |                        |                       |                      |                     |
| First Build test cycle finishes  |                        |                       |                      |                     |
| \[Build Two will not be tested\] |                        |                       |                      |                     |
| Third Build delivered to test    |                        |                       |                      |                     |
| Third Build accepted into test   |                        |                       |                      |                     |
| Third Build test cycle finishes  |                        |                       |                      |                     |
| Fourth Build delivered to test   |                        |                       |                      |                     |
| Fourth Build accepted into test  |                        |                       |                      |                     |
| Iteration Assessment review      |                        |                       |                      |                     |
| Iteration ends                   |                        |                       |                      |                     |

# Risks, Dependencies, Assumptions, and Constraints

\[List any risks that may affect the successful execution of this **Test
Plan**, and identify mitigation and contingency strategies for each
risk. Also indicate a relative ranking for both the likelihood of
occurrence and the impact if the risk is realized.\]

<table>
<thead>
<tr class="header">
<th><strong>Risk</strong></th>
<th><strong>Mitigation Strategy</strong></th>
<th><strong>Contingency (Risk is realized)</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Prerequisite entry criteria is not met.</td>
<td><p>&lt;Tester&gt; will define the prerequisites that must be met before Load Testing can start.</p>
<p>&lt;Customer&gt; will endeavor to meet prerequisites indicated by &lt;Tester&gt;.</p></td>
<td><ul>
<li><p>Meet outstanding prerequisites</p></li>
<li><p>Consider Load Test Failure</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Test data proves to be inadequate.</td>
<td><p>&lt;Customer&gt; will ensure a full set of suitable and protected test data is available.</p>
<p>&lt;Tester&gt; will indicate what is required and will verify the suitability of test data.</p></td>
<td><ul>
<li><p>Redefine test data</p></li>
<li><p>Review Test Plan and modify</p></li>
<li><p>components (that is, scripts)</p></li>
<li><p>Consider Load Test Failure</p></li>
</ul></td>
</tr>
<tr class="odd">
<td>Database requires refresh.</td>
<td>&lt;System Admin&gt; will endeavor to ensure the Database is regularly refreshed as required by &lt;Tester&gt;.</td>
<td><ul>
<li><p>Restore data and restart</p></li>
<li><p>Clear Database</p></li>
</ul></td>
</tr>
</tbody>
</table>


| **Dependency between** | **Potential Impact of Dependency** | **Owners** |
| ---------------------- | ---------------------------------- | ---------- |
|                        |                                    |            |
|                        |                                    |            |
|                        |                                    |            |



| **Assumption to be proven** | **Impact of Assumption being incorrect** | **Owners** |
| --------------------------- | ---------------------------------------- | ---------- |
|                             |                                          |            |
|                             |                                          |            |
|                             |                                          |            |



| **Constraint on** | **Impact Constraint has on test effort** | **Owners** |
| ----------------- | ---------------------------------------- | ---------- |
|                   |                                          |            |
|                   |                                          |            |
|                   |                                          |            |

# Management Process and Procedures

(n/a)

## Measuring and Assessing the Extent of Testing

(n/a)

## Assessing the Deliverables of this Test Plan

(n/a)

## Problem Reporting, Escalation, and Issue Resolution

(n/a)

## Managing Test Cycles
(n/a)

## Traceability Strategies

(n/a)

## Approval and Signoff

(n/a)
