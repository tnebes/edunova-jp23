drop database if exists jp23_3_10_practitioners_office;
create database jp23_3_10_practitioners_office;

use jp23_3_10_practitioners_office;

create table person(
    id          int primary key not null auto_increment,
    oib         char(13) not null,
    first_name  varchar(50) not null,
    last_name   varchar(50) not null
);

create table employee(
    id          int primary key not null auto_increment,
    person		int not null,
    iban        varchar(32)
);

create table doctor(
    id          int primary key not null auto_increment,
    employee    int not null
);

create table patient(
   id         int primary key not null auto_increment,
	person     int not null
);

create table treatment(
	id			int primary key not null auto_increment,
    doctor      int not null,
    patient     int not null,
    date        datetime not null
);

create table nurse(
   id          int primary key not null,
	employee    int not null
);

create table nurse_treatment(
	nurse		   int not null,
	treatment	int not null
);

alter table employee
    add foreign key (person) references person(id);

alter table doctor
    add foreign key (employee) references employee(id);

alter table patient
    add foreign key (person) references person(id);

alter table treatment
    add foreign key (doctor) references doctor(id);
alter table treatment
    add foreign key (patient) references patient(id);

alter table nurse
    add foreign key (employee) references employee(id);

alter table nurse_treatment
	add foreign key (nurse) references nurse(id);
alter table nurse_treatment
	add foreign key (treatment) references treatment(id);

