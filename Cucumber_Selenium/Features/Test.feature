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
Feature: Login Feature

  Scenario: Login as a authenticated user
    Given user is on homepage
    #When user navigates to Login Page
    And user enters "pirunov94@gmail.com" and "ilovemyfamily"

  #Then success message is displayed
  Scenario Outline: Login as a authenticated user
    Given user is on homepage
    And user enters <username> and <password>

    Examples: 
      | username            | password       |
      | pirunov94@gmail.com | ilovemyfamily  |
      | pirunov94@gmail.com | ilovemyfamily1 |
      | pirunov94@gmail.com | ilovemyfamily2 |

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
