/* create database jp23_5_1
 * create table with 4 attributes
 * enter 5 rows
 * 
 * bonus:
 * make one of the entities use itself with a foreign key 
 */

drop database if exists jp23_5_1;
create database jp23_5_1 CHARACTER SET utf8;

use jp23_5_1;

create table person(
	id				int primary key not null auto_increment,
	first_name	varchar(50) not null,
	last_name	varchar(50) not null,
	is_male		bool not null,
	parent		int null
);

insert into person(first_name, last_name, is_male)
	values 	("Joe", "Smith", true),
				("Anna", "Doe", false),
				("Winston", "Smith", true),
				("Venessa", "Alexander", false),
				("Boban", "Rajović", true);
		
alter table person
	add foreign key (parent) references person(id);
	
update person
	set parent = 4
	where id = 2;
