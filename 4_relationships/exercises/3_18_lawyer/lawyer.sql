/* A lawyer represents multiple defendants
 * A defendant can be represented multiple times
 * The lawyer's partners assist him in his defences
 * A defence can be attended by multiple partners
 * A partner can attend multiple defences.
 */

drop database if exists jp23_3_18_lawyer;
create database jp23_3_18_lawyer;

use jp23_3_18_lawyer;

create table person(
   oib               char(11) primary key not null,
   first_name        varchar(50) not null,
   last_name         varchar(50) not null
);

create table defendant(
   id                int primary key not null auto_increment,
   person            char(11) not null
);

create table legal_case(
   id                int primary key not null auto_increment,
   case_time         datetime not null,
   description       varchar(255) not null,
   defendant         int not null
);

create table defence(
   id                int primary key not null auto_increment,
   legal_case        int not null
);

create table partner(
   id                int primary key not null auto_increment,
   person            char(11) not null
);

create table defence_partner(
   defence           int not null,
   partner           int not null
);

alter table defendant
   add foreign key (person) references person(oib);

alter table legal_case
   add foreign key (defendant) references defendant(id);

alter table defence
   add foreign key (legal_case) references legal_case(id);

alter table partner
   add foreign key (person) references person(oib);

alter table defence_partner
   add foreign key (defence) references defence(id);
alter table defence_partner
   add foreign key (partner) references partner(id);
