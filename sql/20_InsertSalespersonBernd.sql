INSERT INTO salespersons (id, account, company_car_license_plate)
	SELECT id, 'Project Y', 'INF - 42'
	FROM employees
	WHERE surname = 'Becker';