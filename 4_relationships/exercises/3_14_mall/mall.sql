/* a mall has many shops
 * each shop has many persons
 * each person can work in many shops
 * each shop has a manager who is also a person.
 */

drop database if exists jp23_3_14_mall;
create database jp23_3_14_mall;

use jp23_3_14_mall;

create table shop(
	id			int primary key not null auto_increment,
	x_location	int not null,
	y_location	int not null,
	shop_name	varchar(50),
	manager		int not null
);

create table person(
	id			int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null
);

create table shop_person(
	shop		int not null,
	person		int not null
);

create table manager(
	person		int not null
);

alter table shop_person
	add foreign key (shop) references shop(id);
alter table shop_person
	add foreign key (person) references person(id);

alter table manager
	add foreign key (person) references person(id);
alter table shop
	add foreign key (manager) references manager(person);

