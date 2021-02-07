# U tablici cura postavite svim zapisima kolonu gustoca na vrijednost 15,77.

use midterm_exercise_1;

insert into punac(hlace)
    values  ('crne'),
            ('crne'),
            ('bijele'),
            ('smeđe');

insert into cura(novcica, gustoca, ogrlica, punac)
    values  (567.23, 54.21, 4, 1),
            (67.23, 32.01, 0, 2),
            (1.5, 43.64, 12, 3),
            (rand() * 500, rand() * 100, floor(rand() * 50), 4);

update cura
    set gustoca = 15.77;

# 5:34

