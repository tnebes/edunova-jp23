drop database if exists jp23_3_10_practitioners_office;
create database jp23_3_10_practitioners_office;

use jp23_3_10_practitioners_office;

create table person(
    oib         char(13) primary key not null,
    first_name  varchar(50) not null,
    last_name   varchar(50) not null
);

create table employee(
    person      char(13) primary key not null,
    iban        varchar(32)
);

create table doctor(
    employee    char(13) primary key not null
);

create table patient(
	person     char(13) primary key not null
);

create table treatment(
	id			int primary key not null auto_increment,
    doctor      char(13) not null,
    patient     char(13) not null,
    date        datetime not null
);

create table nurse(
	employee    char(13) primary key not null
);

create table nurse_treatment(
	nurse		char(13) not null,
	treatment	int not null
);

alter table employee
    add foreign key (person) references person(oib);

alter table doctor
    add foreign key (employee) references employee(person);

alter table patient
    add foreign key (person) references person(oib);

alter table treatment
    add foreign key (doctor) references doctor(employee);
alter table treatment
    add foreign key (patient) references patient(person);

alter table nurse
    add foreign key (employee) references employee(person);

alter table nurse_treatment
	add foreign key (nurse) references nurse(employee);
alter table nurse_treatment
	add foreign key (treatment) references treatment(id);

