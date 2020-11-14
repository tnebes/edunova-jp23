/* the book club has memebers who read books.
 * a reader can read many books
 * while a book can be read by many readers.
 * Each book has one and only one owner
 * while an owner can have many books.
 * the owner is a reader.
 */

drop database if exists jp23_3_22_book_club;
create database jp23_3_22_book_club;

use jp23_3_22_book_club;

create table member(
   id             int primary key not null auto_increment,
   first_name     varchar(50) not null,
   last_name      varchar(50) not null
);

create table reader(
   member         int not null
);

create table owner(
   reader         int not null
);

create table book(
   id             int primary key not null auto_increment,
   issn           char(8) not null,
   author         int not null,
   year           int(4) not null,
   owner          int not null
);

create table book_reader(
   book           int not null,
   reader         int not null
);

create table author(
   id             int primary key not null auto_increment,
   last_name      varchar(50),
   first_name     varchar(50)
);

alter table reader
   add foreign key (member) references member(id);

alter table owner
   add foreign key (reader) references reader(member);

alter table book
   add foreign key (author) references author(id);
alter table book
   add foreign key (owner) references owner(reader);

alter table book_reader
   add foreign key (book) references book(id);
alter table book_reader
   add foreign key (reader) references reader(member);



