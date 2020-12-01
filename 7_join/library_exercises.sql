use knjiznica;

# odaberite sve naslove knjige koje su napisali autori rodjeni 1980 g.

select a.naslov
	from katalog a inner join autor b on a.autor = b.sifra
		where b.datumrodenja between '1980-01-01' and '1980-12-31';
	
# odaberite sve naslove koji su izdani od strane aktivnih izdavača

select b.naziv 
from katalog a inner join izdavac b on a.izdavac = b.sifra
	where b.aktivan = 1;

# odaberite imena i prezime autora koji su pisali knjige na ljubavnu tematiku

select a.ime, a.prezime
from autor a
inner join katalog b on b.autor = a.sifra 
where naslov like '%ljubav%';
		
	