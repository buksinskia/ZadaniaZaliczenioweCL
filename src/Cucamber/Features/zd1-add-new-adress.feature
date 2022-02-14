Feature: adding new adress for existing user on Mystore site
  Scenario Outline: add new adress to Mystore site
    Given registered user is on mystore site
    When user clicks sign in
    And user puts proper credentials into username and passwort input fields and clicks sign in
    And clicks on adresses on a main shop site
    And clicks create new adress
    And fill mandatory fields "<alias>", "<address>", "<city>", "<zip/postal code>", "<country>", "<phone>"
    And clicks save
    And delete adress by clicking delete
    And check if the adress was succesfully deleted
    Then user has succesfully added a new adress, and deleted it
    Examples:
      |alias|address|city|zip/postal code|country|phone|
      |msislaw@wp.pl     |ul Kolorowa 78|Warszawa|00-382|Polska|698444738|
