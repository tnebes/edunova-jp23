/* the book club has members who read books
 * a member can read many books
 * while a book can be read by many members.
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

create table book(
   id                int primary key not null auto_increment,
   issn              char(8) not null,
   author_last_name  varchar(50) not null,
   author_first_name varchar(50) not null,
   year              int(4) not null,
   owner             int not null
);

create table book_member(
   book           int not null,
   member         int not null,
   active         bool
);

alter table book
   add foreign key (owner) references member(id);

alter table book_member
   add foreign key (book) references book(id);
alter table book_member
   add foreign key (member) references member(id);



