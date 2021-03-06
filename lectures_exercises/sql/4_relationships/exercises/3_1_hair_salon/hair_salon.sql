drop database if exists jp23_3_1_hair_salon;
create database jp23_3_1_hair_salon;

use jp23_3_1_hair_salon;

create table hairdresser(
    id          int not null primary key auto_increment,
    iban        varchar(20) not null,
    person      int not null
);

create table client(
    id          int not null primary key auto_increment,
    person      int not null
);

create table person(
    id          int not null primary key auto_increment,
    person_name varchar(40) not null
);

create table visit(
    id          int not null primary key auto_increment,
    date_visit  datetime not null,
    client      int,
    hairdresser int
);

create table service(
    name varchar(50)    not null,
    visit               int not null
);

alter table hairdresser add foreign key (person) references person(id);

alter table client add foreign key (person) references person(id);

alter table visit add foreign key (client) references client(id);
alter table visit add foreign key (hairdresser) references hairdresser(id);

alter table service add foreign key (visit) references visit(id);
