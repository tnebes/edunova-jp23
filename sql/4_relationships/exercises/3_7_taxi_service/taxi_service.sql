drop database if exists jp23_3_7_taxi_service;
create database jp23_3_7_taxi_service;

use jp23_3_7_taxi_service;

create table vehicle(
	license_plate	char(8) primary key not null,
	max_passengers	int not null,
	driver			int
);

create table driver(
	id				int primary key not null auto_increment,
	first_name		varchar(50) not null,
	last_name		varchar(50) not null
);

create table passenger(
	id				int primary key not null auto_increment,
	first_name		varchar(50),
	last_name		varchar(50)
);

create table ride(
	id				int primary key not null auto_increment,
	vehicle			char(8) not null
);

create table passenger_ride(
	passenger		int not null,
	ride			int not null
);

alter table vehicle
	add foreign key (driver) references driver(id);
alter table ride
	add foreign key (vehicle) references vehicle(license_plate);
alter table passenger_ride
	add foreign key (passenger) references passenger(id);
alter table passenger_ride
	add foreign key (ride) references ride(id);
