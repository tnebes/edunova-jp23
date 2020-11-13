drop database if exists jp23_3_10_practitioners_office;
create database jp23_3_10_practitioners_office;

use jp23_3_10_practitioners_office;

create table patient(
	oib			char(13) primary key not null,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null
);

create table therapy(
	id			int primary key not null auto_increment,
	patient		char(13) not null
);

create table treatment(
	id			int primary key not null auto_increment,
	therapy		int not null
);

create table nurse(
	id			int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null
);

create table nurse_treatment(
	nurse		int not null,
	treatment	int not null
);

alter table therapy
	add foreign key (patient) references patient(oib);

alter table treatment
	add foreign key (therapy) references therapy(id);

alter table nurse_treatment
	add foreign key (nurse) references nurse(id);
alter table nurse_treatment
	add foreign key (treatment) references treatment(id);

