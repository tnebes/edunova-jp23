/* A publisher publishes books
 * a publisher can publish many books
 * and a book can be published by many publishers.
 * a publisher is in one place while a place can have many publishers.
 */

drop database if exists jp23_3_19_publisher;
create database jp23_3_19_publisher;

use jp23_3_19_publisher;

create table publisher(
   id             int primary key not null auto_increment,
   publisher_name varchar(50) not null,
   location       int not null
);

create table location(
   id             int primary key not null auto_increment,
   city           varchar(50),
   street         varchar(100),
   street_number  varchar(10)
);

create table book(
   id          int primary key not null auto_increment,
   author      int not null,
   title       varchar(50),
   issn        char(8) not null,
   year        varchar(4) not null
);

create table book_publisher(
   book        int not null,
   publisher   int not null
);

create table author(
   id          int primary key not null,
   last_name   varchar(50) not null,
   first_name  varchar(50) not null
);

alter table publisher
   add foreign key (location) references location(id);

alter table book
   add foreign key (author) references author(id);

alter table book_publisher
   add foreign key (book) references book(id);
alter table book_publisher
   add foreign key (publisher) references publisher(id);

