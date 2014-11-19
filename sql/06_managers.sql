CREATE TABLE managers(
	id integer references employees(id) primary key,
	account varchar(255) CONSTRAINT std_account DEFAULT 'Akquise',
	company_car_license_plate varchar(25)
);