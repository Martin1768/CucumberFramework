Feature: Login Validation for HRMs Portal

  Scenario: Login with valid user and password
    #Given user can access the login page of hrms application
    When user enters admin username and password
    And user clicks on login button
    Then user will be redirected to dashboard page


  Scenario: Login with incorrect username or/and password
    #Given user can access the login page of hrms application
    When user enters invalid username or password
      | username | password    | errmsg                   |
      |          | Hum@nhrm123 | Username cannot be empty |
      | Admin    |             | Password is empty        |
      | Adfmin   | Hum@nhrm123 | Invalid credentials      |

