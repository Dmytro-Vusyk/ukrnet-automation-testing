@login
Feacher: send mail with attached file and check files content


	Scenario: Test login
        Given As a user
        When I navigate to ukr.net
        Then I see email sign in form
        When I enter login and password
        And I click 'sign in' button
        Than I see homepage
