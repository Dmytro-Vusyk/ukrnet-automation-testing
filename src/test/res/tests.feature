@login
Feacher: send mail with attached file and check files content


	Scenario: Test login
		Given browse to "https://www.ukr.net"
		When i enter login «automationtester4502@ukr.net» to «id="id-input-login"»
		And i click ‚.dG5hZc .RveJvd‘
		Then i see «id="id-input-password"»
		When i enter password «Admin12345$» to ‚//input[@name = "password"]‘
		And i click  ‚//span[@class = "RveJvd snByac"]‘
		Than i see ‚//div[@class="B1tEqd"]‘