drop database if exists edunovajp23;
create database edunovajp23;

use edunovajp23;

create table course(
    course_id           int,
    course_name         varchar(50),
    course_description  text,
    course_price        decimal(18, 2),
    course_verified     boolean
);

create table course_group(
    group_id            int,
    group_name          varchar(20),
    course_id           int,
    lecturer_id         int,
    start_date          datetime,
    number_of_students  int
);

create table lecturer(
    lecturer_id         int,
    lecturer_name       varchar(50),
    course_id           int,
    pid                 char(11),
    email               varchar(50),
    iban                varchar(50)
);

create table student(
    student_id          int,
    student_first_name  varchar(50),
    student_last_name   varchar(50),
    pid                 char(11),
    email               varchar(50),
    contract_number     varchar(50)
);