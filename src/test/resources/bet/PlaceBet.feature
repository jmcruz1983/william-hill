#Author: Juan Cruz

Feature: Place a bet
  I want to test the flow to place a bet

  Scenario Outline: Place a bet on a English Premier League event
    Given I am logged in into portal as <platform>
    When I select premiership football category
	  And I select first home bet
	  And I place a £<value> bet
    Then The bet is <outcome> placed
 	  And I logout

  Examples:
    | platform  | value | outcome        |
    | desktop   | 0.5   | successfully   |
    | desktop   | 0     | unsuccessfully |
    | mobile    | 0.5   | successfully   |
    | mobile    | 0     | unsuccessfully |