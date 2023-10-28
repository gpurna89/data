@login1
Feature: User Login

  Background: 
    Given a user is on the home page
    When user clcik login link
    Then user should be navigated to login page

  @validUsrPass
  Scenario Outline: Login with valid credential
    Given a user is on the login page
    When user enter valid information (email, password) "<email>" "<password>"
    And user click login button
    Then user should verify login successfully

    @valid @sanity
    Examples: 
      | email                     | password   |
      | prabuchinnasamy@gmail.com | mayusri*1A |
      

@invalidUserNameAndPassword
  Scenario Outline: Login with Invalid credential
    Given a user is on the login page
    When user enter valid information (email, password) "<email>" "<password>"
  	And user click login button
    Then user should verify login unsuccessfully

   @invalidUserNameAndPassword 
   Examples: 
    | email                        | password     |
    | prabuchinnasamy@gmailprs.com | mayusri*1A55 |

		@invalidUser
    Examples: 
     | email                       | password   |
     | prabuchinnasamy@gm22ail.com | mayusri*1A |
			
    @invalidPass
    Examples: 
      | email                     | password       |
      | prabuchinnasamy@gmail.com | mayusri*1Adddd |
      
    @invalidUserPass
    Examples: 
      | email                     | password       |
      | prabuchinnasamy@gmailww.com | mayusri*1Adddd | 
