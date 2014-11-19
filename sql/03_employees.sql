CREATE TABLE employees(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	firstname varchar(255),
	surname varchar(255),
	salary real,
	boss integer references manager(id),
	department integer references departments(id)
);