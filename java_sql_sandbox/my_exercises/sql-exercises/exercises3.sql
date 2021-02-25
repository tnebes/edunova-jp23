/*
 * https://www.w3resource.com/sql-exercises/sql-wildcard-special-operators.php
*/

# 3 Write a query to produce a list of salesman_id, name, city and commission of each salesman who live in cities other than Paris and Rome.

select salesman_id, name, city, commission
from salesman
where city not in ('Paris', 'Rome');

# 6 Write a query to filter all those orders with all information which purchase amount value is within the range 500 and 4000 except those orders of purchase amount value 948.50 and 1983.43. 

select *
from orders
where (purch_amt between 500 and 4000) and not purch_amt in (948.50, 1983.43);

# 7 Write a SQL statement to find those salesmen with all other information and name started with any letter within 'A' and 'K'.

select *
from salesman
where lower(name) like '[a-k]%';

# 11  Write a SQL statement to find those salesmen with all information whose name containing the 1st character is 'N' and the 4th character is 'l' and rests may be any character.

select *
from salesman
where lower(name) like 'n__l%';

#12 Write a SQL statement to find those rows from the table testtable which contain the escape character underscore ( _ ) in its column 'col1'.

select *
from testtable
where col1 like '%\_%' escape '\';