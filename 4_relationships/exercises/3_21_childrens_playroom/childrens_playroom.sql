/* In a children's playroom, children play in groups
 * a child can play in more than one group
 * and a group consists of children.
 * each group is led by an educator.
 */

drop database if exists jp23_3_21_childrens_playroom;
create database jp23_3_21_childrens_playroom;

use jp23_3_21_childrens_playroom;

create table playgroup(
   id             int primary key not null auto_increment,
   educator       int not null,
   max_age        int not null,
   max_children   int not null
);

create table person(
   id             int primary key not null auto_increment,
   first_name     varchar(50) not null,
   last_name      varchar(50) not null,
   phone          varchar(20) not null
);

create table educator(
   person         int not null,
   iban           varchar(32) not null
);

create table child(
   person         int not null,
   notes          varchar(255),
   year_of_birth  datetime not null
);

create table child_playgroup(
   child          int not null,
   playgroup     int not null
);

alter table educator
   add foreign key (person) references person(id);

alter table playgroup
   add foreign key (educator) references educator(person);

alter table child
   add foreign key (person) references person(id);

alter table child_playgroup
   add foreign key (child) references child(person);
alter table child_playgroup
   add foreign key (playgroup) references playgroup(id);
