@Login
Feature: Login
  As a user, I want to login

  @LGI001
  Scenario: LGI001 - User want to login 2 attempt with valid and invalid credentials
    Given The User go to login page
    And User click My Account
    When User click Login
    Then User performs two login attempts with valid credetials and invalid credentials

