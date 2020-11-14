/* a caa performs demostically and abroad.
 * many members of the caa take part in a performance
 * a single caa member can take part on many performances
 * each performance takes place on one location.
 */

drop database if exists jp23_3_20_caa;
create database jp23_3_20_caa;

use jp23_3_20_caa;

create table performance(
   id             int primary key not null auto_increment,
   location       int not null
);

create table location(
   id             int primary key not null auto_increment,
   street         varchar(50),
   street_number  varchar(10),
   city           varchar(50),
   country        varchar(50)
);

create table member(
   id             int primary key not null auto_increment,
   first_name     varchar(50) not null,
   last_name      varchar(50) not null
);

create table member_performance(
   member         int not null,
   performance    int not null
);

alter table performance
   add foreign key (location) references location(id);

alter table member_performance
   add foreign key (member) references member(id);
alter table member_performance
   add foreign key (performance) references performance(id);

