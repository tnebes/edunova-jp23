/* The following will run only once and has been made for testing
* purposes.
*/

###
drop database if exists final_project_store_database;
create database final_project_store_database character set utf8;
###

use final_project_store_database;

create table customer_order(
   id                   int primary key not null,
   date_of_creation     now() not null
);

