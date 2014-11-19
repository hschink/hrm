INSERT INTO customers(firstname, surname, address, telephone, taken_care_of_by)
	SELECT 'Erhard', 'Erlich', 'Kundenweg 1/12345 Kundenhausen', '123456789', 
		salespersons.id
	FROM employees, salespersons
	WHERE employees.id = salespersons.id
		AND surname = 'Becker';