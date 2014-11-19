INSERT INTO salespersons_customers(id_customer, id_salesperson)
	SELECT customers.id, salespersons.id
	FROM salespersons, customers
	WHERE salespersons.id = customers.taken_care_of_by;