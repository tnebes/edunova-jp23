drop database if exists vjezba2;
create database vjezba2;

use vjezba2;

create table person(
	id			int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null
);

create table car(
	id			int primary key not null auto_increment,
	person		int not null,
	name		varchar(50)
);

alter table car
	add foreign key (person) references person(id);

insert into person(first_name, last_name)
	values("John", "Doe"),
		("John", "Doe");

insert into car(person, name)
	values(2, "Audi"),
		(1, "Volkswagen"),
		(2, "Stojadin"),
		(1, "Lada");
