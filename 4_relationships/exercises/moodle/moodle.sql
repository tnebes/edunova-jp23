drop database if exists jp23_3_moodle;
create database jp23_3_moodle;

use jp23_3_moodle;

create table assign(
   id                         bigint(10) primary key not null auto_increment,
   course                     bigint(10) not null,
   name                       varchar(255) not null,
   intro                      longtext not null,
   introformat                smallint(4) not null,
   alwaysshowdescription      tinyint(2) not null,
   nosubmissions              tinyint(2) not null,
   submissiondrafts           tinyint(2) not null,
   sendnotifications          tinyint(2) not null,
   sendlatenotifications      tinyint(2) not null,
   duedate                    bigint(10) not null,
   allowsubmissionsfromdate   bigint(10) not null,
   grade                      bigint(10) not null,
   timemodified               bigint(10) not null,
   requiresubmissionstatement tinyint(2) not null,
   completionsubmit           tinyint(2) not null,
   cutoffdate                 bigint(10) not null,
   teamsubmission             tinyint(2) not null,
   requirerealteammemberssubmit  tinyint(2) not null,
   teamsubmissiongroupingid   bigint(10) not null,
   blindmarking               tinyint(2) not null,
   revealidentities           tinyint(2) not null,
   attemptreopenmethod        varchar(10) not null,
   maxattempts                mediumint(6) not null,
   markingworkflow            mediumint(6) not null,
   markingallocation          tinyint(2) not null,
   sendstudentnotifications   tinyint(2) not null
);

create table assign_plugin_config(
   id          bigint(10) primary key not null auto_increment,
   assignment  bigint(10) not null,
   plugin      varchar(28) not null,
   subtype     varchar(28) not null,
   name        varchar(28) not null,
   value       longtext
);

create table assignsubmission_file(
   id          bigint(10) primary key not null auto_increment,
   assignment  bigint(10) not null,
   submission  bigint(10) not null,
   numfiles    bigint(10) not null
);

create table assign_submission(
   id             bigint(10) primary key not null auto_increment,
   assignment     bigint(10) not null,
   userid         bigint(10) not null,
   timecreated    bigint(10) not null,
   timemodified   bigint(10) not null,
   status         varchar(10),
   groupid        bigint(10) not null,
   attemptnumber  bigint(10) not null
);

alter table assign_plugin_config
   add foreign key (assignment) references assign(id);

alter table assignsubmission_file
   add foreign key (assignment) references assign(id);
alter table assignsubmission_file
   add foreign key (submission) references assign_submission(id);

alter table assign_submission
   add foreign key (assignment) references assign(id);

