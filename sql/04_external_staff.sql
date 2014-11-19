CREATE TABLE external_staff(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	firstname varchar(255),
	surname varchar(255),
	salary real,
	business varchar(255), -- janitor, etc.
	company_name varchar(255),
	address varchar(255)
);