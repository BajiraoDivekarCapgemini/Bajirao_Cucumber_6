Feature: Validate Login Functionality

  Background: 
    Given User enter the url "https://www.saucedemo.com"
    When User Enter The Username "standard_user"
    And User Enter The Password "secret_sauce"
    And User Click On The Login_Button
    Then validate the user is successfully logined

  #Scenario: Validate Login Page
  #Given User enter the url "https://www.saucedemo.com"
  #When User Enter The Username "standard_user"
  #And User Enter The Password "secret_sauce"
  #And User Click On The Login_Button
  #Then validate the user is successfully logined
  #Scenario Outline: : Validate Orange HRM Login Page
  #Given User enter the url "<url>"
  #When User Enter The Username "<username>"
  #And User Enter The Password "<password>"
  #And User Click On The Login_Button
  #Then validate the user is successfully logined
  #
  #Examples:
  #| url                                                                | username | password |
  #| https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | Admin    | admin123 |
  #Scenario Outline: : Validate Swag Labs Login Page
  #Given User enter the url "<url>"
  #When User Enter The Username "<username>"
  #And User Enter The Password "<password>"
  #And User Click On The Login_Button
  #Then validate the user is successfully logined
  #
  #Examples:
  #| url                       | username      | password     |
  #| https://www.saucedemo.com | standard_user | secret_sauce |
  Scenario Outline: : Order The Product
    When Select the product "<product>"
    And User Enter The FirstName "<firstname>"
    And User Enter The LastName "<lastname>"
    And User Enter The ZipCode "<zipcode>"
    Then validate the product order successfully

    Examples: 
      | product                  | firstname | lastname | zipcode |
      | Sauce Labs Backpack      | bajirao   | divekar  |  546605 |
      | Sauce Labs Bike Light    | bajirao   | divekar  |  546605 |
      | Sauce Labs Bolt T-Shirt  | bajirao   | divekar  |  546605 |
      | Sauce Labs Fleece Jacket | bajirao   | divekar  |  546605 |
