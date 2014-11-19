INSERT INTO managers (id, account)
	SELECT id, 'ProjectX'
	FROM employees
	WHERE surname = 'Langenhahn';