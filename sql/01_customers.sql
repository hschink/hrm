CREATE TABLE customers(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	firstname varchar(255),
	surname varchar(255),
	address varchar(255),
	telephone varchar(255),
	taken_care_of_by integer references salespersons(id)
);