#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login Page

  Background:
     Given User is on saucedemo login page
   
   @smoke @Regression
  Scenario: Successful login with valid credentials
    Given User entered a valid username and password
    When User click on Login button
    Then User should land on Products Page

   @smoke
  Scenario Outline: Unsuccessful login with invalid credentials
    Given User entered a invalid "<username>" and "<password>"
    When User click on Login button
    Then User should display error message as "<error_message>"

    Examples: 
      | username | password | error_message  |
      | dd | eer_88 | Epic sadface: Username and password do not match any user in this service |
      | name2 |     7 | Epic sadface: Username and password do not match any user in this srevice    |
