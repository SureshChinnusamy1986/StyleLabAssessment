Feature: Open a Expedia website and make a search

  @FlightSearch
  Scenario: Search a flight from Brussels to New York in Expedia site.
    Given I navigate to the Expedia website
    When I look for a flight with accommodation from Brussels to New York
    Then the result page contains travel option for the chosen destination
