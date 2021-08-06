@Staff
Feature: Create and edit staff

  Background: Login to SIS
    Given Open the SIS site.

    Scenario: Create new Staff
      * Use administrator user name and misk password to login.
      Given Navigate to Create Staff page.
      When Create staff with all required fields.
      Then The staff will be created successfully.

  Scenario: Edit Staff
    * Use administrator user name and misk password to login.
    Given Navigate to Create Staff page.
    When Create staff with all required fields.
    Then The staff will be created successfully.



  Scenario: Open Staff screen
    * Use administrator user name and misk password to login.
    Given Navigate to Create Staff page.
    Then Enter Staff Number "284479".
