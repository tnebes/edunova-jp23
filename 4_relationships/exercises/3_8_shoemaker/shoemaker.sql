drop database if exists jp23_3_8_shoemaker;
create database jp23_3_8_shoemaker;

use jp23_3_8_shoemaker;

create table repair(
	id			int primary key not null auto_increment,
	repair_user	int not null
);

create table footwear(
	id			int primary key not null auto_increment,
	job			int not null
);

create table repair_user(
	id			int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50)
);

create table apprentice(
	id			int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null,
	iban		varchar(32) not null
);

create table job(
	id			int primary key not null auto_increment,
	repair		int not null,
	name		varchar(50),
	description	varchar(255)
);

create table apprentice_job(
	apprentice	int not null,
	job			int not null
);

alter table repair
	add foreign key (repair_user) references repair_user(id);

alter table footwear
	add foreign key (job) references job(id);

alter table apprentice_job
	add foreign key (apprentice) references apprentice(id);
alter table apprentice_job
	add foreign key (job) references job(id);

alter table job
	add foreign key (repair) references repair(id);
