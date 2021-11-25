Feature: User API tests


  Scenario Outline: Checking Product Names for Matching a Request
    Given Launching the browser and opening the rozetka website
    When Search for a product by query "<query>"
    Then Checking if the product name contains a word from the query "<query>"

    Examples:
      | query |
      | selenium |

  Scenario Outline: Checking the possibility of purchasing a product
    Given Launching the browser and opening the rozetka website
    When Search for a product by query "<query>"
    Then Opening the product under number 0 and placing an order

    Examples:
      | query    |
      | selenium |