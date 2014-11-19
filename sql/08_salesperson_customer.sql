CREATE TABLE salespersons_customers(
	id_customer integer references customers(id) primary key,
	id_salesperson integer references salespersons(id)
);