Feature: Add Employee to HRMS

  Background:
    #Given user can access the login page of hrms application
    When user enters admin username and password
    And user clicks on login button
    Then user will be redirected to dashboard page
    When user clicks on PIM menu item
    And user clicks on Add Employee menu item

  @runOnlyThis
  Scenario: add an employee to the HRMS application without providing an employee ID
    And user enters firstname and middlename and lastname
      | firstname | middlename | lastname |
      |           |            |          |
      | John      | Michael    | Smith    |
      | Emily     |            | Johnson  |
      |           | Alexander  | Brown    |
      | Sarah     | Elizabeth  |          |
      | Daniel    | James      | Wilson   |

  Scenario: add an employee to the HRMS application with unique employee ID
    And user enters firstname and middlename and lastname and employeeID
      | firstname | middlename | lastname | id         |
      |           |            |          | 1e17TDRZHu |
      | John      | Michael    | Smith    | KOzORGvxRh |
      | Emily     |            | Johnson  | M4DVzzK09k |
      |           | Alexander  | Brown    | NKndbNhthP |
      | Sarah     | Elizabeth  |          | POIW3mpu0Q |
      | Daniel    | James      | Wilson   | mXGFIv7goT |
