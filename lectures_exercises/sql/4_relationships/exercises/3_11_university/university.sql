/* students pass courses through exam periods.
 * a student can apply for an exam in an exam period.
 * and many students can apply for an exam period
 */ 

drop database if exists jp23_3_11_university;
create database jp23_3_11_university;

use jp23_3_11_university;

create table student(
	jmbag			varchar(20) primary key not null,
	first_name		varchar(50) not null,
	last_name		varchar(50) not null
);

create table course(
	id				int primary key not null auto_increment,
	name			varchar(50) not null,
	description		varchar(255)
);

create table exam_period(
	id				int primary key not null auto_increment,
	period_number	int not null,
	course			int not null
);

create table application(
	student			varchar(20) not null,
	exam_period		int not null
);

alter table exam_period
	add foreign key (course) references course(id);

alter table application
	add foreign key (student) references student(jmbag);
alter table application
	add foreign key (exam_period) references exam_period(id);
