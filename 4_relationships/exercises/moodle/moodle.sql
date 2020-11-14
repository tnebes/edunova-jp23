drop database if exists jp23_3_moodle;
create database jp23_3_moodle;

use jp23_3_moodle;

create table assign(
   id                            bigint(10) primary key not null auto_increment,
   course                        bigint(10) not null,
   name                          varchar(255) not null,
   intro                         longtext not null,
   introformat                   smallint(4) not null,
   alwaysshowdescription         tinyint(2) not null,
   nosubmissions                 tinyint(2) not null,
   submissiondrafts              tinyint(2) not null,
   sendnotifications             tinyint(2) not null,
   sendlatenotifications         tinyint(2) not null,
   duedate                       bigint(10) not null,
   allowsubmissionsfromdate      bigint(10) not null,
   grade                         bigint(10) not null,
   timemodified                  bigint(10) not null,
   requiresubmissionstatement    tinyint(2) not null,
   completionsubmit              tinyint(2) not null,
   cutoffdate                    bigint(10) not null,
   teamsubmission                tinyint(2) not null,
   requirerealteammemberssubmit  tinyint(2) not null,
   teamsubmissiongroupingid      bigint(10) not null,
   blindmarking                  tinyint(2) not null,
   revealidentities              tinyint(2) not null,
   attemptreopenmethod           varchar(10) not null,
   maxattempts                   mediumint(6) not null,
   markingworkflow               mediumint(6) not null,
   markingallocation             tinyint(2) not null,
   sendstudentnotifications      tinyint(2) not null
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

create table assignsubmission_onlinetext(
   id             bigint(10) primary key not null auto_increment,
   assignment     bigint(10) not null,
   submission     bigint(10) not null,
   onlinetext     longtext,
   onlineformat   smallint(4) not null
);

create table assign_user_flags(
   id                bigint(10) primary key not null auto_increment,
   userid            bigint(10) null, # TODO missing userid, for all userid now null
   assignment        bigint(10) not null,
   locked            bigint(10) not null,
   mailed            smallint(4) not null,
   extensionduedate  bigint(10) not null,
   worksflowstate    varchar(20),
   allocatedmarker   bigint(10) not null
);

create table assignfeedback_editpdf_quick(
   id          bigint(10) primary key not null auto_increment,
   userid      bigint(10) null, # TODO missing userid
   rawtext     longtext not null,
   width       bigint(10) not null,
   colour      varchar(10)
);

create table assignfeedback_file(
   id          bigint(10) primary key not null auto_increment,
   assignment  bigint(10) not null,
   grade       bigint(10) not null,
   numfiles    bigint(10) not null
);

create table assign_user_mapping(
   id          bigint(10) primary key not null auto_increment,
   assignment  bigint(10) not null,
   userid      bigint(10) null # TODO missing userid
);

create table assign_grades(
   id             bigint(10) primary key not null auto_increment,
   assignment     bigint(10) not null,
   userid         bigint(10) not null,
   timecreated    bigint(10) not null,
   timemodified   bigint(10) not null,
   grader         bigint(10) not null,
   grade          decimal(10, 5),
   attemptnumber  bigint(10)
);

create table assignfeedback_editpdf_cmnt(
   id          bigint(10) primary key not null auto_increment,
   gradeid     bigint(10) not null,
   x           bigint(10),
   y           bigint(10),
   width       bigint(10),
   rawtext     longtext,
   pageno      bigint(10) not null,
   colour      varchar(10),
   draft       tinyint(2)
);

create table assignfeedback_editpdf_annot(
   id          bigint(10) primary key not null auto_increment,
   gradeid     bigint(10) not null,
   pageno      bigint(10) not null,
   x           bigint(10),
   y           bigint(10),
   endx        bigint(10),
   endy        bigint(10),
   path        longtext,
   type        varchar(10),
   colour      varchar(10),
   draft       tinyint(2) not null
);

create table assignfeedback_comments(
   id             bigint(10) primary key not null auto_increment,
   assignment     bigint(10) not null,
   grade          bigint(10) not null,
   commenttext    longtext,
   commentformat  smallint(4) not null
);

alter table assign_plugin_config
   add foreign key (assignment) references assign(id);

alter table assignsubmission_file
   add foreign key (assignment) references assign(id);
alter table assignsubmission_file
   add foreign key (submission) references assign_submission(id);

alter table assign_submission
   add foreign key (assignment) references assign(id);

alter table assignsubmission_onlinetext
   add foreign key (assignment) references assign(id);
alter table assignsubmission_onlinetext
   add foreign key (submission) references assign_submission(id);

/* TODO where does the userid come from??? what???
 * userid missing. cannot be found in database
alter table assign_user_flags
   add foreign key (userid) references 
*/
alter table assign_user_flags
   add foreign key (assignment) references assign(id);

/* TODO userid missing
alter table assignfeedback_editpdf_quick
   add foreign key (userid) references
*/

alter table assignfeedback_file
   add foreign key (assignment) references assign(id);
alter table assignfeedback_file
   add foreign key (grade) references assign_grades(id);

alter table assign_user_mapping
   add foreign key (assignment) references assign(id);
/* TODO userid missing
alter table assign_user_mapping
   add foreign key (userid) references
*/

alter table assign_grades
   add foreign key (assignment) references assign(id);

alter table assignfeedback_editpdf_cmnt
   add foreign key (gradeid) references assign_grades(id);

alter table assignfeedback_editpdf_annot
   add foreign key (gradeid) references assign_grades(id);

alter table assignfeedback_comments
   add foreign key (assignment) references assign(id);
alter table assignfeedback_comments
   add foreign key (grade) references assign_grades(id);

