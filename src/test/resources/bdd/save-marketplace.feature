Feature: Saving Marketplaces

  Scenario: Saving new marketplace with success
    Given I have a valid marketplace
    When I call service to save the new marketplace
    Then  I receive the code 201
