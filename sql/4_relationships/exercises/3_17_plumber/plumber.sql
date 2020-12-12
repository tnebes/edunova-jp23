/* a plumber does repairs on plumbing
 * during one repair he can repair multiple defects
 * a defect can be repaired multiple times
 * the plumber's apprentice helps him on certain repairs.
 */

drop database if exists jp23_3_17_plumber;
create database jp23_3_17_plumber;

use jp23_3_17_plumber;

create table repair(
   id                int primary key not null auto_increment,
   repair_date       datetime not null,
   repair_location   int not null
);

create table repair_location(
   id                int primary key not null auto_increment,
   street            int not null,
   number            varchar(10)
);

create table city(
   id                int primary key not null auto_increment,
   name              varchar(50) not null
);

create table street(
   id                int primary key not null auto_increment,
   city              int not null,
   name              varchar(255) not null
);

create table defect(
   id                int primary key not null auto_increment,
   name              varchar(100) not null,
   description       varchar(255)
);

create table repair_defect(
   repair            int not null,
   defect            int not null
);

create table apprentice(
   id                int primary key not null auto_increment,
   first_name        varchar(50) not null,
   last_name         varchar(50) not null,
   iban              varchar(32) not null
);

create table apprentice_repair(
   apprentice        int not null,
   repair            int not null
);

alter table street
   add foreign key (city) references city(id);

alter table repair_location
   add foreign key (street) references street(id);

alter table repair
   add foreign key (repair_location) references repair_location(id);

alter table repair_defect
   add foreign key (repair) references repair(id);
alter table repair_defect
   add foreign key (defect) references defect(id);

alter table apprentice_repair
   add foreign key (apprentice) references apprentice(id);
alter table apprentice_repair
   add foreign key (repair) references repair(id);


