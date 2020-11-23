select * from smjer;

update smjer set cijena = 1000 where sifra = 2;

update smjer set
	cijena = null,
	trajanje = 200
where sifra = 2;

update smjer set
	naziv = null
where sifra = 1;

select * from grupa;

update grupa set
	predavac = 7
where sifra = 1;

update grupa set predavac = 7 where sifra = 1;
select * from predavac where sifra = 7;

select * from predavac;
select * from osoba;
update grupa set
	predavac = 1
where sifra = 1;

select * from grupa;

select * from osoba;

update osoba set
	oib = '08195610701'
where sifra = 1;
update osoba set
	oib = '83543820825'
where sifra = 2;
update osoba set
	oib = '28374622898'
where sifra = 3;

select * from smjer;

alter table smjer add broj decimal(18,2);
alter table smjer add iznos decimal(18,2) not null default 0;
update smjer set broj=rand() * 5;

/* svim smjerovima postavite iznose izmedju 10 i 100 */

update smjer set iznos = 10 + (rand() * 90);

/* sve iznose uvećajte za 10 kuna */

update smjer set iznos = iznos + 10;


/* svim brojevima dodijeliti iznos umanjen za 15 */

update smjer set iznos = iznos - 15;

/* sve cijene smanjiti za 10% */

update smjer set cijena = cijena * 0.9;

delete from smjer;

