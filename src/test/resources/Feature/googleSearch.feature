Feature:Google search

@GoogleSearch
Scenario Outline:Open a chrome browser and do google search
  Given user navigated to google
  When the page is loaded
  Then search for "<searchText>"
  And take screenshot of the result page

  Examples:
  |searchText|
  |Bahamas   |
  |Amsterdam |