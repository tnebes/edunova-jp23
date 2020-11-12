drop database if exists jp23_3_3_organisation;
create database jp23_3_3_organisation;

use jp23_3_3_organisation;

create table person(
    id              int,
    name            varchar(50),
    phone_number    varchar(20)
);

create table foster_animal(
    id              int,
    person          int,
    animal          int
);

create table enclosure(
    id              int,
    foster_animal   int
);

