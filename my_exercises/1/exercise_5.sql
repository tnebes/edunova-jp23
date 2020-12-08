use midterm_exercise_1;

# Prikažite dukserica iz tablice svekar, asocijalno iz tablice mladic te hlace iz tablice muskarac uz uvjet da su vrijednosti kolone hlace iz tablice zena počinju slovom a te da su vrijednosti kolone haljina iz tablice sestra sadrže niz znakova ba. Podatke posložite po hlace iz tablice muskarac silazno.

select a.dukserica, b.asocijalno, c.hlace, d.hlace, e.haljina
    from svekar as a inner join mladic as b
        inner join muskarac as c
            inner join zena as d 
                inner join sestra as e
where d.hlace like 'a%' and e.haljina like '%ba%'
order by c.hlace DESC;

# 5:55