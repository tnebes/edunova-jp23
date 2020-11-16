/* make a meme database */

drop database if exists jp23_5_meme;
create database jp23_5_meme character set utf8mb4;

use jp23_5_meme;

create table bookshelf(
	id			int primary key not null auto_increment
);

create table book(
	id				int primary key not null auto_increment,
	bookshelf	int not null,
	colour		varchar(1)
);

alter table book
	add foreign key (bookshelf) references bookshelf(id);

insert into bookshelf
	values(null);

insert into book(bookshelf, colour)
	VALUES	(1, "📕"),
				(1, "📘"),
				(1, "📗");




