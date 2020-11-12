drop database if exists jp23_3_6_monastery;
create database jp23_3_6_monastery;

use jp23_3_6_monastery;

create table monk(
	id				int primary key not null auto_increment,
	first_name 		varchar(50),
	last_name		varchar(50),
	religious_name	varchar(100) not null,
	superior		int
);

create table job(
	id				int primary key not null auto_increment,
	name			varchar(50),
	description		varchar(255)
);

create table monk_job(
	monk			int not null,
	job				int not null
);

/* should not be used as a monk should only have one superior
 * and this would allow a monk to have more superiors.
create table superior_monk(
	monk			int not null,
	superior		int not null
);
*/

alter table monk_job
	add foreign key (monk) references monk(id);
alter table monk_job
	add foreign key (job) references job(id);

/* a monk can only have one superior.
alter table superior_monk
	add foreign key (monk) references monk(id);
alter table superior_monk
	add foreign key (superior) references monk(id);
*/

alter table monk add foreign key (superior) references monk(id);
