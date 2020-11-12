drop database if exists jp23_3_3_animal_protection_association;
create database jp23_3_3_animal_protection_association;

use jp23_3_3_animal_:protection_association;

create table person(
	id					int primary key not null auto_increment,
	person_name			varchar(50) not null
);

create table animal_type(
	id					int primary key not null auto_increment,
	name				varchar(50),
	species				varchar(50) not null
);

create table foster_animal(
	id					int primary key not null auto_increment,
	animal_type			int not null,
	name				varchar(50),
	person				int,
	enclosure			int not null
);

create table enclosure(
	id					int primary key not null auto_increment
);

alter table foster_animal add foreign key (animal_type) references animal_type(id);
alter table foster_animal add foreign key (person) references person(id);
alter table foster_animal add foreign key (enclosure) references enclosure(id);

