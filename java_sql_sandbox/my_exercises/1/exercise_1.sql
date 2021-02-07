# U tablice muskarac, zena i sestra_svekar unesite po 3 retka.

use midterm_exercise_1;

insert into svekar(bojaociju)
    values  ('plava'),
            ('crvena'),
            ('zelena');

insert into sestra(haljina, hlace, narukvica)
    values  ('crvena', 'crvene', 1),
            ('plava', 'plave', 2),
            ('zelena', 'zelene', 3);

insert into sestra_svekar(sestra, svekar)
    values  (1, 1),
            (2, 2),
            (3, 3);

insert into zena(jmbag, bojaociju, sestra)
    values  ('00000000000', 'zelena', 1),
            ('00000000001', 'smeđa', 2),
            ('00000000002', 'crna', 3);

insert into muskarac(bojaociju, maraka, zena)
    values  ('smeđa', 100.4, 1),
            ('crna', 56.4, 2),
            ('zelena', 0.5, 3);

#10:00