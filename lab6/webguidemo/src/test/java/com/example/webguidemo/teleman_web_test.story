Scenario: User searches for a single step
 
Given user is on Home page
When user opens Sport link
Then Sport page is shown

When user opens list channels and choose Polsat channel
Then Polsat page is shown

When user searches Polsat
Then showing the Polsat channel on third position
Then showing the Polsat Viasat History channel on second position
Then showing the Polsat Viasat Explore channel on first position

When user click on Polsat programmes
Then Then it checks the program display on 23 kwietnia at 6:00

