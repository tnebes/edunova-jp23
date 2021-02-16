use final_project_store_database;

insert into status(id) values (1);

insert into address(type, city, ZIP_code, street, street_number, country)
	values (0, "Osijek", "31000", "Osjecka ulica", "1", "Croatia");

insert into customer(type, VATIN, name, billing_address_id, shipping_address_id)
	values (0, "32490282384", "tnebes d.o.o.", 1, 1);

insert into transaction_type(id, name)
	values (1, 'creditcard');
	
insert into invoice(customer_id, transaction_type_id, status_id)
	values(1, 1, 1);
	
insert into article(warehouse_location, warehouse_quantity, wholesale_price, retail_price, tax_rate,
	short_name)
	values ('A0-00', 100, 100, 125, 25, '1L PET bottle');
	
insert into article_invoice(article_id, invoice_id, note, quantity)
	values (1, 1, 'TEST', 25);