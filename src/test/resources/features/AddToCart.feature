Feature: Add To Cart
  Scenario: The user add product to cart
    Given Open application
    Given Click product
    Given Choose blue color
    Given Select how many want to add
    Given Click add
    When Click cart
    Then The product added to cart successfully