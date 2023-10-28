Feature: Add to Cart
 
  Background: 
    Given a user is on the home page
    When user clcik login link
    Then user should be navigated to login page

  Scenario Outline: Search a product and add to cart
    Given a user is on the login page
    When user enter valid information (email, password) "<email>" "<password>"
    And user click login button
    Then user should verify login successfully
    Given user enter a item "<itemName>" in search box
    When user press enter key
    Then user click addtocart button

    @valid 
    Examples: 
      | email                     | password   | itemName               |
      | prabuchinnasamy@gmail.com | mayusri*1A | Lemon Tree Meryn Dress |

 
 #Scenario Outline: Make Empty card
    #Given a user is on the login page
    #When user enter valid information (email, password) "<email>" "<password>"
    #And user click login button
    #Then user should verify login successfully
  #	When user click cart icon  
#		And user remove all items from  cart
#		Then user should verify the message "There are no items in your cart"
    #@valid 
    #Examples: 
      #| email                     | password   |
      #| prabuchinnasamy@gmail.com | mayusri*1A | 
 