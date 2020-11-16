/* Create database jp23_5_3
 * Database has two tables
 * language and category
 * enter the following data
 * 
 * java(oop, win, osx)
 *	swift(osx)
 * php(oop, linux, win)
 *	go(linux, osx)
 *
 */

drop database if exists jp23_5_3;
create database jp23_5_3 character set utf8;

use jp23_5_3;

create table p_language(
	id			int primary key not null auto_increment,
	name		varchar(50) not null
);

create table category(
	id			int primary key not null auto_increment,
	name		varchar(50) not null
);

create table p_language_category(
	p_language	int not null,
	category	int not null
);

alter table p_language_category
	add foreign key (p_language) references p_language(id);
alter table p_language_category
	add foreign key (category) references category(id);

insert into p_language(name)
	values	("Java"), 	#1
				("Swift"),	#2
				("PHP"),		#3
				("Go");		#4

insert into category(name)
	values	("oop"),		#1
				("osx"),		#2
				("linux"),	#3
				("win");		#4
			
insert into p_language_category(p_language, category)
	values	(1, 1),
				(1, 4),
				(1, 2),
				
				(2, 2),
				
				(3, 1),
				(3, 3),
				(3, 4),
				
				(4, 3),
				(4, 2);
			

