drop database if exists jp23_3_5_museum;
create database jp23_3_5_museum;

use jp23_3_5_museum;

create table exhibition(
	id			int primary key not null auto_increment,
	sponsor		int not null
);

create table artwork(
	id			int primary key not null auto_increment,
	name		varchar(100),
	exhibition	int
);

create table curator(
	id			int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null,
	exhibition	int not null
);

create table sponsor(
	id			int primary key not null auto_increment,
	name		varchar(100) not null
);

alter table exhibition add foreign key (sponsor) references sponsor(id);

alter table artwork add foreign key (exhibition) references exhibition(id);

alter table curator add foreign key (exhibition) references exhibition(id);
