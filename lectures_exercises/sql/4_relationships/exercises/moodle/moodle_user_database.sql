drop database if exists jp23_moodle_users;
create database jp23_moodle_users;

use jp23_moodle_users;

create table user(
    id          bigint(10) primary key not null auto_increment #dummy data
);