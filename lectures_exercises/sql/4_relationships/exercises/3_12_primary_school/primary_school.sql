/* There are children's workshops in a school.
 * Multiple children can attend a workshop.
 * A child can attend multiple workshops.
 * A workshop is led by a teacher.
 */

drop database if exists jp23_3_12_primary_school;
create database jp23_3_12_primary_school;

use jp23_3_12_primary_school;

create table workshop(
	id			int primary key not null auto_increment,
	name		varchar(50) not null,
	description varchar(255),
	teacher		int not null
);

create table person(
	id			int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null
);

create table child(
	person		int not null,
	phone_num	varchar(20) not null
);

create table child_workshop(
	child		int not null,
	workshop	int not null
);

create table teacher(
	person		int not null
);

alter table child
	add foreign key (person) references person(id);

alter table child_workshop
	add foreign key (child) references child(person);
alter table child_workshop
	add foreign key (workshop) references workshop(id);

alter table teacher
	add foreign key (person) references person(id);

alter table workshop
	add foreign key (teacher) references teacher(person);


