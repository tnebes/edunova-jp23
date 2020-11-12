drop database if exists jp23_3_4_kindergarten;
create database jp23_3_4_kindergarten;

use jp23_3_4_kindergarten;

create table edu_group(
	id				int primary key not null auto_increment,
	max_age			int not null,
	teacher			int not null
);

create table pupil(
	id				int primary key not null auto_increment,
	name			varchar(50) not null,
	edu_group		int not null,
	date_of_birth	datetime not null
);

create table teacher(
	id				int primary key not null auto_increment,
	first_name		varchar(50),
	last_name		varchar(50),
	qualification	int not null
);

create table qualification(
	id				int primary key not null auto_increment,
	name			varchar(50) not null,
	qualification_rank int not null
);

alter table edu_group add foreign key (teacher) references teacher(id);
alter table pupil add foreign key (edu_group) references edu_group(id);
alter table teacher add foreign key (qualification) references qualification(id);

