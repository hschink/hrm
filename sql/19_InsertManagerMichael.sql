INSERT INTO managers (id)
	SELECT id
	FROM employees
	WHERE firstname = 'Michael';