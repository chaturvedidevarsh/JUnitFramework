Feature: Test the Trade Me SandBox Website
  As a TradeMe application user
  I want to look at the available listings
  So that I can select an available listings

  Scenario: Check there is at least one listing in the TradeMe UsedCars category
    Given I am on the TradeMe SandBox WebPage
    When I navigate to "Motors" category
    And I select "Used cars" from the options
    Then I should be able to see atleast one listing in that category

  Scenario: Check that the make ‘Kia’ exists
    Given I am on the TradeMe SandBox WebPage
    When I search for "Kia" cars
    Then I should only see cars related to my search option

  Scenario: Confirm all the details are displayed of selected used car
    Given I am on the TradeMe SandBox WebPage
    And I navigate to "Motors" category
    When I search for "2011 Volkswagen Golf" car on Motors page
    Then I should be able to see atleast one listing in that category
    When I select the available car
    Then I should be able to see the following details
      |Number plate|
      |Kilometres  |
      |Body        |
      |Seats       |
      |Fuel type   |
      |Engine size |
      |Transmission|
      |History     |
      |Registration expires|
      |WoF expires         |
      |Model detail        |

  Scenario: Confirm all the details are displayed of selected used car without Seats details
    Given I am on the TradeMe SandBox WebPage
    And I navigate to "Motors" category
    When I search for "2016 Mazda GSX PT" car on Motors page
    Then I should be able to see atleast one listing in that category
    When I select the available car
    Then I should be able to see the following details
      |Number plate|
      |Kilometres  |
      |Body        |
#      |Seats       |
      |Fuel type   |
      |Engine size |
      |Transmission|
      |History     |
      |Registration expires|
      |WoF expires         |
      |Model detail        |