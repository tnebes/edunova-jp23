## run only once
drop database if exists midterm_exercise_2;
create database midterm_exercise_2;
##

use midterm_exercise_2;

create table svekar(
    sifra           int primary key not null auto_increment,
    stilfrizura     varchar(48),
    ogrlica         int not null,
    asocijalno      bit not null
);

create table prijatelj(
    sifra           int primary key not null auto_increment,
    modelnaocala    varchar(37),
    treciputa       datetime not null default now(),
    ekstrovertno    bit not null,
    prviputa        datetime,
    svekar          int not null
);

alter table prijatelj
    add foreign key (svekar) references svekar(sifra);

create table zarucnica(
    sifra           int primary key not null auto_increment,
    narukvica       int,
    bojakose        varchar(37) not null,
    novcica         decimal(15, 9),
    lipa            decimal(15, 8),
    indiferentno    bit not null
);


create table decko_zarucnica(
    sifra           int primary key not null auto_increment,
    decko           int not null,
    zarucnica       int not null
);

create table decko(
    sifra           int primary key not null auto_increment,
    indiferentno    bit,
    vesta           varchar(34),
    asocijalno      bit not null
);

alter table decko_zarucnica
    add foreign key (decko) references decko(sifra);
alter table decko_zarucnica
    add foreign key (zarucnica) references zarucnica(sifra);

create table cura(
    sifra           int primary key not null auto_increment,
    haljina         varchar(33) not null,
    drugiputa       datetime not null default now(),
    suknja          varchar(38),
    narukvica       int,
    introvertno     bit,
    majica          varchar(40) not null,
    decko           int
);

alter table cura 
    add foreign key (decko) references decko(sifra);

create table neprijatelj(
    sifra           int primary key not null auto_increment,
    majica          varchar(32),
    haljina         varchar(43) not null,
    lipa            decimal(16, 8),
    modelnaocala    varchar(49) not null,
    kuna            decimal(12, 6) not null,
    jmbag           char(11),
    cura            int
);

alter table neprijatelj
    add foreign key (cura) references cura(sifra);

create table brat(
    sifra           int primary key not null auto_increment,
    suknja          varchar(47),
    ogrlica         int not null,
    asocijalno      bit not null,
    neprijatelj     int not null
);

alter table brat
    add foreign key (neprijatelj) references neprijatelj(sifra);