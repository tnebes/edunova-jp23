
### The following will run only once and has been made for testing purposes.

drop database if exists final_project_store_database;
create database final_project_store_database character set utf8;

###

use final_project_store_database;

create table customer(
   id                      int primary key not null auto_increment,
   date_of_creation        datetime not null default now(),
   VATIN                   varchar(32),
   national_id_number      varchar(32),                
   `name`                  varchar(100),
   first_name              varchar(50),
   middle_name             varchar(50),
   last_name               varchar(50),
   billing_city            varchar(50) not null,
   billing_ZIP_code        varchar(32) not null,
   billing_street          varchar(50) not null,
   billing_street_number   varchar(10) not null,
   billing_street_letter   varchar(10) not null,
   billing_country         varchar(100) not null default 'Croatia',
   shipping_city           varchar(50),
   shipping_ZIP_code       varchar(32),
   shipping_street         varchar(50),
   shipping_street_number  varchar(10),
   shipping_street_letter  varchar(10),
   shipping_country        varchar(100)
);

create table status(
   id                   tinyint primary key not null,
   `name`               varchar(100),
   `description`        varchar(255),
   description_long     text
);

create table transaction_type(
   id                   tinyint primary key not null,
   `name`               varchar(100),
   `description`        varchar(255)
);

create table invoice (
   id                         int primary key not null auto_increment,
   date_of_creation           datetime not null default now(),
   customer_id                int not null,
   transaction_type_id        tinyint not null,
   status_id                  tinyint not null,
   invoice_discount_percent   tinyint not null default 0,
   amount_paid                decimal(10,2) not null default 0.0
);

alter table invoice
   add foreign key (customer_id) references customer(id);
alter table invoice
   add foreign key (status_id) references status(id);
alter table invoice
   add foreign key (transaction_type_id) references transaction_type(id);

create table article(
   id                   int primary key not null auto_increment,
   warehouse_location   varchar(10) not null default 'NOTSET',
   warehouse_quantity   int not null default 0,
   wholesale_price      decimal(10,2) not null,
   retail_price         decimal(10,2),
   tax_rate             tinyint default 25,
   short_name           varchar(50) not null,
   long_name            varchar(255),
   short_description    varchar(255),
   long_description     text
);

create table article_invoice(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   article_id           int not null,
   invoice_id           int not null,
   note                 varchar(255),
   discount             tinyint not null default 0,
   quantity             int not null default 1
);

alter table article_invoice
   add foreign key (article_id) references article(id);
alter table article_invoice
   add foreign key (invoice_id) references invoice(id);
