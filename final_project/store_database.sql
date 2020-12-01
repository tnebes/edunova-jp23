/* The following will run only once and has been made for testing
* purposes.
*/

###
drop database if exists final_project_store_database;
create database final_project_store_database character set utf8;
###

use final_project_store_database;

create table partner(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   VATIN                varchar(32),
   national_id_number   varchar(32),                
   name                 varchar(100),
   first_name           varchar(50),
   middle_name          varchar(50),
   last_name            varchar(50),
   ZIP_code             varchar(32),
   street               varchar(50),
   street_number        varchar(10),
   steet_letter         varchar(10),
   country              varchar(100)   
);

create table customer(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   partner_id           int not null
);

alter table customer
   add foreign key (partner_id) references partner(id);

create table supplier(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   partner_id           int not null
);

alter table supplier
   add foreign key (partner_id) references partner(id);

create table shipping_info(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   customer_id          int,
   name                 varchar(100),
   first_name           varchar(50),
   middle_name          varchar(50),
   last_name            varchar(50),
   ZIP_code             varchar(32),
   street               varchar(50),
   street_number        varchar(10),
   steet_letter         varchar(10),
   country              varchar(100)
);

alter table shipping_info
   add foreign key (customer_id) references customer(id);

create table status(
   id                   tinyint primary key not null,
   name                 varchar(100),
   description          varchar(255),
   description_long     text
);

create table transaction_type(
   id                   tinyint primary key not null,
   name                 varchar(100),
   description          varchar(255)
);

create table customer_order(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   customer_id          int not null,
   shipping_info_id     int not null,
   status_id            tinyint not null,
   transaction_type_id  tinyint,
   total                decimal(18,2),
   total_discount       tinyint(3)
);


alter table customer_order
   add foreign key (customer_id) references customer(id);
alter table customer_order
   add foreign key (shipping_info_id) references shipping_info(id);
alter table customer_order
   add foreign key (status_id) references status(id);
alter table customer_order
   add foreign key (transaction_type_id) references transaction_type(id);

create table offer (
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   customer_order_id    int not null,
   shipping_info_id     int not null,
   status_id            tinyint not null,
   total                decimal(18,2),
   total_discount       tinyint(3)
);

alter table offer
   add foreign key (customer_order_id) references customer_order(id);

alter table offer
   add foreign key (shipping_info_id) references shipping_info(id);
alter table offer
   add foreign key (status_id) references status(id);

create table invoice (
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   customer_id          int,
   customer_order_id    int,
   shipping_info_id     int,
   transaction_type_id  tinyint,
   status_id            tinyint not null,
   total                decimal(18,2),
   total_discount       tinyint(3),
   amount_paid          int
);

alter table invoice
   add foreign key (customer_order_id) references customer_order(id);
alter table invoice
   add foreign key (customer_id) references customer(id);
alter table invoice
   add foreign key (shipping_info_id) references shipping_info(id);
alter table invoice
   add foreign key (status_id) references status(id);
alter table invoice
   add foreign key (transaction_type_id) references transaction_type(id);

create table warehouse_receipt (
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   supplier_id          int not null,
   status               tinyint not null
);

alter table warehouse_receipt
   add foreign key (supplier_id) references supplier(id);

create table article(
   id                   int primary key not null auto_increment,
   warehouse_location   varchar(10),
   quantity             int default 0,
   wholesale_price      decimal(10,2) not null,
   retail_price         decimal(10,2),
   tax_rate             int,
   short_name           varchar(50) not null,
   long_name            varchar(255),
   short_description    varchar(255),
   long_description     text
);

create table article_warehouse_receipt(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   note                 varchar(100),
   code                 tinyint,
   article_id           int not null,
   warehouse_receipt_id int not null,
   amount               int not null default 1
);

alter table article_warehouse_receipt
   add foreign key (article_id) references article(id);
alter table article_warehouse_receipt
   add foreign key (warehouse_receipt_id) references warehouse_receipt(id);

create table article_customer_order(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   note                 varchar(100),
   code                 tinyint,
   article_id           int not null,
   customer_order_id    int not null,
   amount               int not null default 1
);

alter table article_customer_order
   add foreign key (article_id) references article(id);
alter table article_customer_order
   add foreign key (customer_order_id) references customer_order(id);

create table article_invoice(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   note                 varchar(100),
   code                 tinyint,
   article_id           int not null,
   invoice_id           int not null,
   amount               int not null default 1
);

alter table article_invoice
   add foreign key (article_id) references article(id);
alter table article_invoice
   add foreign key (invoice_id) references invoice(id);

create table article_offer(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   note                 varchar(100),
   code                 tinyint,
   article_id           int not null,
   offer_id             int not null,
   amount               int not null default 1
);

alter table article_offer
   add foreign key (article_id) references article(id);
alter table article_offer
   add foreign key (offer_id) references offer(id);

create table packing_instructions(
   id                   int primary key not null auto_increment,
   date_of_creation     datetime not null default now(),
   invoice_id           int not null,
   status_id            tinyint not null
);

alter table packing_instructions
   add foreign key (invoice_id) references invoice(id);
