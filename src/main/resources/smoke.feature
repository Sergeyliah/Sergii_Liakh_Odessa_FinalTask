Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly
  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on Bluefin Cruise SUP
    And User clicks add to cart button
    And User clicks on Home page button
    Then User checks that amount of products in cart are '<amountOfProducts>'

    Examples:
      | homePage               | keyword | amountOfProducts |
      | https://www.amazon.com/ | SUP    | 1                |

  Scenario Outline: Check URL of current page
    Given User opens '<homePage>' page
    When User clicks All button
    And User clicks Smart home button
    And User clicks Amazon Smart home
    Then User checks presence of '<text>'
    Examples:
      | homePage               | text |
      | https://www.amazon.com/ | amazon_smart_home |

  Scenario Outline: Buy product
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on Bluefin Cruise SUP
    And User clicks buy now button
    Then User checks presence of text '<text>' on login page

    Examples:
      | homePage                | keyword | text |
      | https://www.amazon.com/ |Bluefin SUP|Sign-In |

  Scenario Outline: Check Add to list button
    Given User opens '<homePage>' page
    When User clicks All button
    And User clicks Smart home button
    And User clicks Amazon Smart home
    And User clicks on Lighting
    And User clicks on Light bulbs
    And User clicks seeAllResult button
    And User clicks on Kasa Smart Light Bulbs
    And User clicks Add to list button
    Then User checks presence of text '<text>' on login page
    Examples:
      | homePage |text |
      | https://www.amazon.com/ |Sign-In |

  Scenario Outline: Change language on home page
    Given User opens '<homePage>' page
    And User move over flag on the header of the home page
    And User select german language
    Then User checks language '<text>'
    Examples:
      | homePage |text|
      | https://www.amazon.com/ |Deutsch|

  Scenario Outline: Check text after invalid login
    Given User opens '<homePage>' page
    And User select button for sign in
    And User clicks next sign in button
    And User enter login '<login>'
    And User clicks continue button
    Then User checks text after invalid login '<text>'

    Examples:
      | homePage |login|text|
      | https://www.amazon.com/ |+381111111111|Incorrect phone number|

  Scenario Outline: Check text after click create account button
    Given User opens '<homePage>' page
    And User select button for sign in
    And User clicks next sign in button
    And User clicks create account
    Then User checks possibility to create new account by '<text>'
    Examples:
      | homePage |text|
      | https://www.amazon.com/ |Create account|

  Scenario Outline: Make a subscription
    Given User opens '<homePage>' page
    And User clicks blog button
    And User clicks subscribe button
    Then User checks presence of element
    Examples:
      | homePage |
      | https://www.amazon.com/ |

  Scenario Outline: Sort selected product
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks sort button
    And User clicks sort by price ascending
    Then User checks presence of '<text>'
    Examples:
      | homePage | keyword |text|
      | https://www.amazon.com/ |Bluefin SUP|price-asc-rank|
  Scenario Outline: Delete product from cart
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on Bluefin Cruise SUP
    And User clicks add to cart button
    And User clicks on Home page button
    And User clicks cart button
    And User clicks delete product from cart
    And User clicks on Home page button
    Then User checks that amount of products in cart are '<amountOfProducts>'

    Examples:
      | homePage               | keyword | amountOfProducts |
      | https://www.amazon.com/ | SUP    |            0     |


