/* A high school has many forms
 * each form is attended by many students
 * each form is taught by many teachers
 * a teacher can teach in multiple forms
 */

drop database if exists jp23_3_13_high_school;
create database jp23_3_13_high_school;

use jp23_3_13_high_school;

create table form(
	id			int primary key not null auto_increment,
	form_number int not null,
	form_letter	char(1) not null
);

create table person(
	id			int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null
);

create table student(
	person		int not null,
	form		int not null
);

create table teacher(
	id			int primary key not null auto_increment,
	person		int not null
);

create table teacher_form(
	teacher		int not null,
	form		int not null
);

alter table student
	add foreign key (person) references person(id);
alter table student
	add foreign key (form) references form(id);

alter table teacher
	add foreign key (person) references person(id);

alter table teacher_form
	add foreign key (teacher) references teacher(id);
alter table teacher_form
	add foreign key (form) references form(id);
