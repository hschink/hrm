CREATE TABLE janitors(
	id integer references employees(id) primary key,
	company_name varchar(255),
	address varchar(255)
);