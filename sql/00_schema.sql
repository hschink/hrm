CREATE TABLE customers(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	firstname varchar(255),
	lastname varchar(255),
	address varchar(255),
	telephone varchar(255),
	taken_care_of_by integer references salespersons(id)
);

CREATE TABLE departments(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name varchar(255)
);

CREATE TABLE employees(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	firstname varchar(255),
	surname varchar(255),
	salary real,
	boss integer references manager(id),
	department integer references departments(id)
);

CREATE TABLE external_staff(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	firstname varchar(255),
	surname varchar(255),
	salary real,
	business varchar(255), -- janitor, etc.
	company_name varchar(255),
	address varchar(255)
);

CREATE TABLE janitors(
	id integer references employees(id) primary key,
	company_name varchar(255),
	address varchar(255)
);

CREATE TABLE managers(
	id integer references employees(id) primary key,
	account varchar(255) CONSTRAINT std_account DEFAULT 'Akquise',
	company_car_license_plate varchar(25)
);

CREATE TABLE salespersons(
	id integer references employees(id) primary key,
	account varchar(255) CONSTRAINT std_account DEFAULT 'Akquise',
	company_car_license_plate varchar(25)
);

CREATE TABLE salespersons_customers(
	id_customer integer references customers(id) primary key,
	id_salesperson integer references salespersons(id)
);
