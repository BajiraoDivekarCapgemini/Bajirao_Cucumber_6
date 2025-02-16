Feature: Validate Login Functionality

  # Scenario: Validate Login Page
  #    Given User enter the url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  #    When  User Enter The Username "Admin"
  #   And User Enter The Password "admin123"
  #    And User Click On The Login_Button
  #    Then validate the user is successfully logined
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

  Scenario Outline: : Validate Swag Labs Login Page
    Given User enter the url "<url>"
    When User Enter The Username "<username>"
    And User Enter The Password "<password>"
    And User Click On The Login_Button
    Then validate the user is successfully logined

    Examples: 
      | url                       | username      | password     |
      | https://www.saucedemo.com | standard_user | secret_sauce |
