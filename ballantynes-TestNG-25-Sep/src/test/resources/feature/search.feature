Feature: Search the Product

  Background: 
    Given a user is on the home page
    When user clcik login link
    Then user should be navigated to login page

  Scenario Outline: Search a valid product
    Given a user is on the login page
    When user enter valid information (email, password) "<email>" "<password>"
    And user click login button
    Then user should verify login successfully
    Given user enter a item "<itemName>" in search box
    When user press enter key

    @valid @sanity
    Examples: 
      | email                     | password   | itemName               |
      | prabuchinnasamy@gmail.com | mayusri*1A | Lemon Tree Meryn Dress |

     
