INSERT INTO customers (firstname, surname, address, telephone, taken_care_of_by)
	SELECT 'Frank', 'Fuhrstedt', 'Kundenweg 2/12345 Kundenhausen', '1234567810', 
		salespersons.id
	FROM employees, salespersons
	WHERE employees.id = salespersons.id
		AND surname = 'Becker';