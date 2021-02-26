/*
 * https://www.w3resource.com/sql-exercises/sql-exercises-quering-on-multiple-table.php
 */

/* 1 Write a query to find those customers with their name and those salesmen with their name and city who lives in the same city. */

# solution 1

select a.name, b.cust_name, a.city
from salesman a
inner join customer b
on a.city = b.city;

# solution 2

select salesman.name, customer.cust_name, salesman.city
from salesman, customer
where salesman.city = customer.city;

/* 2 Write a SQL statement to find the names of all customers along with the salesmen who works for them. */

select customer.cust_name, salesman.name
from customer, salesman
where customer.salesman_id = salesman.salesman_id;

/* 3 Write a SQL statement to display all those orders by the customers not located in the same cities where their salesmen live. */

select orders.ord_no, customer.customer_id, salesman.salesman_id
from orders, customer, salesman
where customer.city != salesman.city
AND orders.salesman_id = salesman.salesman_id
AND orders.customer_id = customer.customer_id;

# alternatively

select a.ord_no, c.city as "salesman city", b.city as "customer city"
from orders a
inner join customer b
on a.customer_id = b.customer_id
inner join salesman c
on b.salesman_id = c.salesman_id
where b.city != c.city;

/* 4 Write a SQL statement that finds out each order number followed by the name of the customers who made the order. */

select orders.ord_no, customer.cust_name
from orders, customer
where orders.customer_id = customer.customer_id;

# alternatively

select a.ord_no, b.cust_name
from orders a
inner join customer b
on a.customer_id = b.customer_id;

/* 5 Write a SQL statement that sorts out the customer and their grade who made an order. Each of the customers must have a grade and served by at least a salesman, who belongs to a city. */

select customer.cust_name, customer.grade, orders.ord_no
from customer, orders, salesman
where orders.customer_id = customer.customer_id
and orders.salesman_id = salesman.salesman_id
and salesman.city is not null
and customer.grade is not null;

# alternatively

select b.cust_name, b.grade, c.name, c.city
from orders a
inner join customer b
on a.customer_id = b.customer_id
inner join salesman c
on b.salesman_id = c.salesman_id
where b.grade is not null
and c.city is not null;

/* 6 Write a query that produces all customers with their name, city, salesman and commission, who served by a salesman and the salesman works at a rate of the commission within 12% to 14%. */

select customer.cust_name, customer.city, salesman.name, salesman.commission
from customer, salesman
where customer.salesman_id = salesman.salesman_id
and salesman.commission between 0.12 and 0.14;

# alternatively

select a.cust_name, a.city, b.name, b.commission
from customer a
inner join salesman b
on a.salesman_id = b.salesman_id
where b.commission between 0.12 and 0.14;

/* 7 Write a SQL statement that produces all orders with the order number, customer name, commission rate and earned commission amount for those customers who carry their grade is 200 or more and served by an existing salesman. */

select orders.ord_no, customer.cust_name, salesman.commission, orders.purch_amt * salesman.commission
from orders, customer, salesman
where orders.customer_id = customer.customer_id
and orders.salesman_id = salesman.salesman_id
and customer.grade >= 200;

# alternatively

select a.ord_no, b.cust_name, c.commission, a.purch_amt * c.commission
from orders a
inner join customer b
on a.customer_id = b.customer_id
inner join salesman c
on b.salesman_id = c.salesman_id
where b.grade >= 200;

/* 8 Find all customers with orders on October 5, 2012. */

select customer.cust_name, orders.ord_date
from customer, orders
where orders.customer_id = customer.customer_id
and orders.ord_date = '2012-10-05';

# alternatively

select b.ord_date, a.cust_name
from customer a
inner join orders b
on a.customer_id = b.customer_id
where b.ord_date = '2012-10-05';
