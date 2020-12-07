drop database if exists midterm_exercise_1;
create database midterm_exercise_1 character set utf8;

use midterm_exercise_1;

create table svekar(
    sifra           int primary key not null auto_increment,
    bojaociju       varchar(40) not null,
    prstena         int,
    dukserica       varchar(41),
    lipa            decimal(13, 8),
    eura            decimal(12, 7),
    majica          varchar(35)
);

create table sestra(
    sifra           int primary key not null auto_increment,
    introvertno     bit,
    haljina         varchar(31) not null,
    maraka          decimal(16, 6),
    hlace           varchar(46) not null,
    narukvica       int not null
);

create table sestra_svekar(
    sifra           int primary key not null auto_increment,
    sestra          int not null,
    svekar          int not null
);

alter table sestra_svekar
    add foreign key(sestra) references sestra(sifra);
alter table sestra_svekar
    add foreign key(svekar) references svekar(sifra);

create table zena(
    sifra           int primary key not null auto_increment,
    treciupta       datetime,
    hlace           varchar(46),
    kraktamajica    varchar(31),
    jmbag           char(11) not null,
    bojaociju       varchar(39) not null,
    haljina         varchar(44),
    sestra          int not null
);

alter table zena
    add foreign key (sestra) references sestra(sifra);

create table muskarac(
    sifra           int primary key not null auto_increment,
    bojaociju       varchar(50) not null,
    hlace           varchar(30),
    modelnaocala    varchar(43),
    maraka          decimal(14, 5) not null,
    zena            int not null
);

alter table muskarac
    add foreign key (zena) references zena(sifra);

create table mladic(
    sifra           int primary key not null auto_increment,
    suknja          varchar(50) not null,
    kuna            decimal(16, 8) not null,
    drugiputa       datetime,
    asocijalno      bit,
    ekstrovertno    bit not null,
    dukserica       varchar(48) not null,
    muskarac        int
);

alter table mladic
    add foreign key(muskarac) references muskarac(sifra);

create table punac(
    sifra           int primary key not null auto_increment,
    ogrlica         int,
    gustoca         decimal(14, 9),
    hlace           varchar(41) not null
);

create table cura(
    sifra           int primary key not null auto_increment,
    novcica         decimal(16, 5) not null,
    gustoca         decimal(18, 6) not null,
    lipa            decimal(13, 10),
    ogrlica         int not null,
    bojakose        varchar(36),
    suknja          varchar(36),
    punac           int
);

alter table cura
    add foreign key (punac) references punac(sifra);

## time elapsed: 15:26 ##


