# Na današnji dan uz unosa vlastitog datuma rođenja upit ispisuje
# koliko ste stari godina, mjeseci, dana

select (timestampdiff(day, date('1993-12-27'), now())) % 365 as days,
	timestampdiff(month, date('1993-12-27'), now()) % 12 as months,
	timestampdiff(year, date('1993-12-27'), now()) as year;
