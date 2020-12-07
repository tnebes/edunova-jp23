use final_project_store_database;

insert into customer(name, billing_city, billing_country, billing_street, billing_street_number,
	billing_street_letter, billing_ZIP_code)
	values ('tnebes d.o.o.', 'Wien', 'Austria', 'Schwarzstrasse', '23', 'E', '1100');

insert into status(id) values (1);

insert into transaction_type(id, name)
	values (1, 'creditcard');
	
insert into invoice(customer_id, transaction_type_id, status_id)
	values(1, 1, 1);
	
insert into article(warehouse_location, warehouse_quantity, wholesale_price, retail_price, tax_rate,
	short_name)
	values ('A0-00', 100, 100, 125, 25, '1L PET bottle');
	
insert into article_invoice(article_id, invoice_id, note, quantity)
	values (1, 1, 'TEST', 25);