Feature: Pesta shop shoping features
  Scenario Outline: Adding items to the basket and finalising transaction
    Given user is registred on mystore site and loged in
    When navigates to main shop page
    And chooses  Hummingbird Printed Sweater
    And checks if discount for item is 20
    And chooses "<size>" size
    And orders "<number of pieces>" pieces of chosen item
    And adds item to the card by clicking add to cart
    And clicks proceed to checkout
    And clicks continiue on Adresses view
    And choses pickup in store method and clicks continiue
    And clicks Pay by check method clicks agree with terms of service
    And clicks order with an obligatory to pay
    Then order is confirmed and screenshoot is done
Examples:
    |size|number of pieces|
    |  L |   10            |


