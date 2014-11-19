INSERT INTO salespersons (id)
	SELECT id
	FROM employees
	WHERE surname = 'Detlefs';