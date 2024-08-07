Feature: Testing the search result page
Scenario: To check the content in result and perform some actions
Given While user searched for the particular item
When The result page displayed
Then Check for the contents ae match with search text
And Collect the number of results obtained in first page
And Navigate to second page
Then Check the overall results count in the first and second page