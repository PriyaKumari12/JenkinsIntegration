Feature: Title of your feature
 
 @Execute
 Scenario Outline: Creation of New Customer
 Given TestData is loaded into HashMap '<TestDataPath>','<sheetName>'
 When customer logs into application

    Examples: 
      | TestDataPath         | sheetName  | 
      | CustomerDetails.xlsx | Sheet1 |
     
