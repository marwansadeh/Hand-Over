Feature: test feature

  Scenario: Verify the login action
    Given Open the SIS site.
    When Use administrator user name and misk password to login.
    Then Home page should be displayed SYSTEM ADMINn.

  Scenario Outline: Verify the login staff
    Given Open the SIS site.
    When Use <UserName> user name and <Password> password to login.
    Then Home page should be displayed <Expected>.

    Examples:
      | UserName      | Password | Expected       |
      | administrator | misk     | SYSTEM ADMIN   |
      | az            | misk     | Ahmed Zakaryya |
