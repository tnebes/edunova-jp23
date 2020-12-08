# Prikažite kolone haljina i maraka iz tablice sestra čiji se primarni ključ ne nalaze u tablici sestra_svekar.

use midterm_exercise_1;

select a.haljina, a.maraka
    from sestra as a inner join sestra_svekar as b on a.sifra = b.sestra
where a.sifra not in (select sestra from sestra_svekar);

# 4:15 