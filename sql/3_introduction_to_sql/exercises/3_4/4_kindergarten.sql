drop database if exists jp23_3_4_kindergarten;
create database jp23_3_4_kindergarten;

use jp23_3_4_kindergarten;

create table edu_group(
    id          int,
    max_age     int,
    teacher     int
);

create table child(
    id          int,
    edu_group   int
);

create table teacher(
    id          int,
    first_name  varchar(50),
    edu_group   int
);

create table qualification(
    id          int,
    name        varchar(100)
);

create table has_qualification(
    qualification   int,
    teacher         int
);