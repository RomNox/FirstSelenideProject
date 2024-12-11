Feature: Login

  @positive
  Scenario: Successful Login
    Given User is on HomePage
    When User clicks on Login icon
#    Then User verifies Login form is displayed
    And User enters valid data
    And User clicks on Anmelden button
    And User clicks on User icon
    Then User verifies his name

  @negative
  Scenario: Login with invalid email
    Given User is on HomePage
    When User clicks on Login icon
    And User enters invalid email and password
    And User clicks on Anmelden button
    Then User sees an error message for invalid login
