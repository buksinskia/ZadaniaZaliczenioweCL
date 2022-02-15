Feature: adding new adress for existing user on Mystore site
  Scenario Outline: add new adress to Mystore site
    Given registered user is on mystore site
    When user clicks sign in
    And user puts proper credentials into username and passwort input fields and clicks sign in
    And clicks on adresses on a main shop site
    And clicks create new adress
    And fill mandatory fields "<alias>", "<address>", "<city>", "<zip/postal code>","<phone>"
    And clicks save
    Then user has succesfully added a new address
    And  new adress data was correctly added "<alias>", "<address>", "<city>", "<zip/postal code>","<phone>"
    And user delete newly added adress
    And adress is deleted
    Examples:
      |alias|address|city|zip/postal code|phone|
      |msislaw@wp.pl     |ul Kolorowa 78|Wroc|00-382|698444738|
