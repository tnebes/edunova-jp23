drop database if exists 6_automobiles;
create database 6_automobiles character set utf8;

use 6_automobiles;

create table automobile(
	id				int primary key not null auto_increment,
	model_name		varchar(50) not null,
	manufacturer	varchar(50) not null,
	door_num		smallint not null,
	engine_volume	decimal(3,1)
);

insert into automobile(model_name, manufacturer, door_num, engine_volume)
	values	("Tiger", "Henschel", rand() * 4, rand() * 5),
			("Panther", "Mann", 2, rand() * 10),
			("Hummel", "AG Werke", 1, rand() * 6),
			("Käfer", "Volkwagen", 3, rand() * 3),
			("Riva", "Lada", 5, rand() * 3);

select * from automobile;
		
update automobile set
	engine_volume = 2.0
where id % 2 = 0;

update automobile set
	model_name = concat(model_name, ' II') 
where id % 3 = 0;

delete from automobile where id % 4 = 0;
	