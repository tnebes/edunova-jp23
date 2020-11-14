/* A family farm produces materials that they grow themselves
 * A product can be made of many materials.
 * A material can be found in many products.
 * A worker is responsible for one or more products.
 */

drop database if exists jp23_3_16_family_farm;
create database jp23_3_16_family_farm;

use jp23_3_16_family_farm;

create table material(
	id				int primary key not null auto_increment,
	name			varchar(100) not null,
	description		varchar(255)
);

create table product(
	id				int primary key not null auto_increment,
	name			varchar(100) not null,
	description		varchar(255)
);

create table product_material(
	product			int not null,
	material		int not null
);

create table worker(
	id				int primary key not null,
	first_name		varchar(50) not null,
	last_name		varchar(50) not null,
	iban			varchar(32) not null
);

create table worker_product(
	worker			int not null,
	product			int not null
);

alter table product_material
	add foreign key (product) references product(id);
alter table product_material
	add foreign key (material) references material(id);

alter table worker_product
	add foreign key (worker) references worker(id);
alter table worker_product
	add foreign key (product) references product(id);
