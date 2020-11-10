drop database if exists edunovajp23_3_4_kindergarten;
create database edunovajp23_3_4_kindergarten;

use edunovajp23_3_4_kindergarten;

create table edu_group(
    id int,
    max_age int,
    teacher int
);

create table child(
    id int,
    edu_group int
);

create table teacher(
    id int,
    first_name varchar(50),
    edu_group int
);

create table qualification(
    id int,
    name varchar(100)
);

create table has_qualification(
    qualification int,
    teacher int
);