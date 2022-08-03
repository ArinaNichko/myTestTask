Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check that the city is "New York" and date is "December 1, 2022 - December 30, 2022" correctly appears in the first page
    Given User opens '<homePage>' page
    And User сhooses a city '<city>'
    And User сhooses a date
    And User clicks search button
    Then User checks that the text of the first page, which contains the city and the date

    Examples:
    | homePage                 | city     |
    | https://www.booking.com/ | New York |



  Scenario Outline: Check properties found are '5,268' when the city is 'Paris' and adults are '3'
    Given User opens '<homePage>' page
    And User сhooses a city '<city>'
    And User chooses three adults
    And User clicks search button
    Then User checks that the properties found equal to '<amount>'
    Examples:
    | homePage                 | city     | amount|
    | https://www.booking.com/ | Paris    | 5,268 |



