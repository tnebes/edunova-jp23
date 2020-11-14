/* A restaurant has many categories on a menu
 * One category has many meals.
 * Many drinks can be offered alongside each meal.
 * A drink can be offered with many meals.
 */

drop database if exists jp23_3_15_restaurant;
create database jp23_3_15_restaurant;

use jp23_3_15_restaurant;

create table menu(
	id			int primary key not null unique auto_increment,
	name		varchar(50)
);

create table category(
	id			int primary key not null unique auto_increment,
	menu		int null,
	name		varchar(50) not null,
	description	varchar(255)
);

create table meal(
	id			int primary key not null unique auto_increment,
	category	int not null,
	name		varchar(50) not null,
	description	varchar(255) not null
);

create table drink(
	id			int primary key not null unique auto_increment,
	name		varchar(50) not null,
	description	varchar(255)
);

create table drink_meal(
	drink		int not null,
	meal		int not null
);

alter table category
	add foreign key (menu) references menu(id);

alter table meal
	add foreign key (category) references category(id);

alter table drink_meal
	add foreign key (drink) references drink(id);
alter table drink_meal
	add foreign key (meal) references meal(id);

insert into menu(name)
	values ("Winter menu"); 

insert into category(menu, name, description)
	values (1, "Meat", "All the meat you need.");
insert into category(menu, name, description)
	values (1, "Vegetables", "Yummy!");

insert into meal(category, name, description)
	values(1, "Wiener Schnitzel", "A schnitzel from Vienna. Made from meat.");
insert into meal(category, name, description)
	values(2, "Broccoli", "It's green.");

insert into drink(name, description)
	values("Water", "Remember to hydrate!");

insert into drink_meal(drink, meal)
	values (1, 1);

