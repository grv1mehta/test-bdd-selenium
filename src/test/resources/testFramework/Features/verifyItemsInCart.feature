
@CartFeature
Feature: Verify the Items in the Cart

  Background:
    Given Iam on the homepage

  @CartItems
  Scenario Outline: Verify the items are in the cart after deleting the lowest price item.

    Given I add "<TotalItemsAdd>" random Items to my cart
    When I view my cart "<TotalItemsAdd>"
    Then I find the total "<TotalItemsAdd>" items listed in my cart
    When I search for lowest price item
    And Iam able to remove the lowest price item from my cart
    Then Iam able to verify "<verifyTotalItem>" items in my cart

  Examples:
    |TotalItemsAdd|verifyTotalItem|
    |4            |3              |


