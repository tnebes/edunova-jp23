drop database if exists final_project_store_database;
create database final_project_store_database character set utf8;

use final_project_store_database;

/*
* Thanks @mtutavac!
*/
create table address(
   id                int primary key not null auto_increment,
   `type`            bit not null default 0, # 0 - billing, 1 - shipping
   city              varchar(50) not null,
   ZIP_code          varchar(32) not null,
   street            varchar(50) not null,
   street_number     varchar(10) not null,
   street_letter     varchar(10) not null,
   country           varchar(100) not null default 'Croatia'
);

create table customer(
   id                      int primary key not null auto_increment,
   `type`                  bit not null default 0, # 0 - natural person, 1 - legal person
   date_of_creation        datetime not null default now(),
   VATIN                   varchar(32),
   national_id_number      varchar(32),                
   `name`                  varchar(100),
   first_name              varchar(50),
   middle_name             varchar(50),
   last_name               varchar(50),
   billing_address_id      int not null,
   shipping_address_id     int
);

alter table customer add foreign key(billing_address_id)
   references address(id);
alter table customer add foreign key(shipping_address_id)
   references address(id);

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
   subtotal                   decimal(10,2) default 0.0, # amount without tax
   amount_due                 decimal(10,2) default 0.0,
   amount_paid                decimal(10,2) not null default 0.0,
   shipping_address_id        int
);

alter table invoice
   add foreign key (shipping_address_id) references address(id);
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
   discount             tinyint not null default 0,
   quantity             int not null default 1,
   wholesale_price      decimal(10,2) not null,
   retail_price         decimal(10,2),
   tax_rate             tinyint default 25,
   note                 varchar(255)
);

alter table article_invoice
   add foreign key (article_id) references article(id);
alter table article_invoice
   add foreign key (invoice_id) references invoice(id);
