INSERT INTO janitors (id, company_name, address)
	SELECT id, 'JanitorExpress', 'CompanyWay 10a'
		FROM employees
		WHERE surname = 'Gemrich';