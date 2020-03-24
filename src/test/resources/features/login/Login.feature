Feature: Login
  As user, I want to be able to login into vytrack
  under different roles with username and password
  @store_manager
  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as store manager
    And user verifies that "Dashboard" page subtitle displayed
    #second scenaio
  @driver
  Scenario: Login as driver
    Given user is on the login page
    Then user logs in as driver
    And user verifies that "Dashboard" page subtitle displayed
   #third scenario
  @sales_manger
    Scenario: Login as sales manager
      Given user is on the login page
      Then user logs in as sales manager
      And user verifies that "Dashboard" page subtitle displayed
      # this is negative scenario and tag will help to figure out negative _test in the Cucnberrunner
    @negative_test
    Scenario: Verify that warning message is displayed when password is not correct
      Given user is on the login page
      Then user enter "srormanage85" username and "wrong" password
      And user verifies that "Invalid user name or password." message is displayed
  @negative_test  @driver
  Scenario: Verify that warning message is displayed when username is not correct
    Given user is on the login page
    Then user enter "wrong" username and "User123User123" password
    And user verifies that "Invalid user name or password." message is displayed
  @driver_with_data_table
     Scenario: Login as driver(data table example)
       Given user is on the login page
       Then user logs in as driver with following credentials
       |username     | user160            |
       |password     | UserUser123        |
       And user verifies that "Quick Launchpad" page subtitle displayed

 @login_with_role
 Scenario: Login as driver
   Given user is on the login page
   Then user logs in as "driver"

  @login_with_role
  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as "sales manager"

  @login_with_role
  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as "store manager"

  @login_with_role_ddt
  Scenario Outline: DDT example, Login as <role>
    Given user is on the login page
    Then user logs in as "<role>"
    Examples: roles
      | role        |
      | driver       |
      | sales manager|
      | store manager|
  @login_with_credentials_ddt
  Scenario Outline: DDT example with credentials, Login as <username>
    Given user is on the login page
    Then user enter "<username>" username and "<password>" password
    Examples:
      |username       | password   |
      |storemanager85 | UserUser123|
      |user160        | UserUser123|
      |salesmanager110| UserUser123|

  @login_with_roles_ddt_2
  Scenario Outline: Login as <role> and verify <title> page title is correct
    Given user is on the login page
    And user logs in as "<role>"
    When user navigates to "<module>" then to "<sub module>"
    Then the page title should be "<title>"

    Examples: drivers
      | role     | module     | sub module      | title                                                        |
      | driver   | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
      | driver   | Customers  | Accounts        | Accounts - Customers                                         |
      | driver   | Customers  | Contacts        | Contacts - Customers                                         |
      | driver   | Activities | Calendar Events | Calendar Events - Activities                                 |
      | driver   | System     | Jobs            | Jobs - System                                                |

    Examples: sales managers
      | role          | module     | sub module          | title                                                          |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | All - Jobs - System                                                |

    Examples: store managers
      | role          | module     | sub module          | title                                                          |
      | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | store manager | System     | Jobs            | All - Jobs - System                                                |




