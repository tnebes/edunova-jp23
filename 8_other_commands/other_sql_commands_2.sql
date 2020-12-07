use classicmodels;

select * from employees;

# odaberite sve proizvode koje je prodao Martin

select e.productName
from employees a inner join customers b on a.employeeNumber = b.salesRepEmployeeNumber 
inner join orders c on b.customerNumber = c.customerNumber
inner join orderdetails d on c.orderNumber = d.orderNumber
inner join products e on d.productCode = e.productCode
where a.firstName = 'Martin';

# odaberite sve podređene zaposlenike od Patterson Mary

select firstName, lastName from employees where reportsTo in (select employeeNumber from employees where firstName = 'Mary' and lastName = 'Patterson');

select a.firstName, a.lastName 
from employees a 
inner join employees b on b.employeeNumber = a.reportsTo 
where b.firstName = 'Mary' and b.lastName = 'Patterson';

# odaberite sve proizvode koji nisu na niti jednoj narudzbi

select * from products where productCode not in (select distinct productcode from orderdetails);

# obrisite taj proizvod

delete from products where productCode not in (select distinct productCode from orderdetails);

# na koji datum narudzbe je prodan najskuplji (priceEach) proizvod

select a.priceEach, b.orderDate
from orderdetails a
inner join orders b on b.orderNumber = a.orderNumber
where a.priceEach = (select max(c.priceEach) from orderdetails c) limit 2;