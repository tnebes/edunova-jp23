/*
 * https://www.w3resource.com/sql-exercises/sql-joins-exercises.php
 */

/* 1 Write a SQL statement to prepare a list with salesman name, customer name and their cities for the salesmen and customer who belongs to the same city. */

select a.city, a.name, b.cust_name
from salesman a
inner join customer b
on a.city = b.city;

/* 2 Write a SQL statement to make a list with order no, purchase amount, customer name and their cities for those orders which order amount between 500 and 2000. */

select a.ord_no, a.purch_amt, b.cust_name, b.city
from orders a
inner join customer b
on a.customer_id = b.customer_id
where purch_amt between 500 and 2000;

/* 3 Write a SQL statement to know which salesman are working for which customer. */

select a.cust_name, b.name
from customer a
inner join salesman b
on a.salesman_id = b.salesman_id;

/* 4 Write a SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%. */

select a.cust_name, b.name, b.commission
from customer a
inner join salesman b
on a.salesman_id = b.salesman_id
where commission > 0.12;

/* 5 Write a SQL statement to find the list of customers who appointed a salesman for their jobs who does not live in the same city where their customer lives, and gets a commission is above 12% . */

select a.cust_name, b.name, a.city as "customer city", b.city as "salesman city"
from customer a
inner join salesman b
on a.salesman_id = b.salesman_id
where a.city != b.city;

/* 6 Write a SQL statement to find the details of a order i.e. order number, order date, amount of order, which customer gives the order and which salesman works for that customer and how much commission he gets for an order. */

select a.ord_no, a.ord_date, a.purch_amt, b.cust_name, c.name, c.commission
from orders a
inner join customer b
on a.customer_id = b.customer_id
inner join salesman c
on b.salesman_id = c.salesman_id;

/* 7 Write a SQL statement to make a join on the tables salesman, customer and orders in such a form that the same column of each table will appear once and only the relational rows will come. */

select *
from orders
natural join customer
natural join salesman;

/* 8  Write a SQL statement to make a list in ascending order for the customer who works either through a salesman or by own. */

select a.cust_name, a.city, a.grade, b.name, b.city
from customer a
left join salesman b
on a.salesman_id = b.salesman_id
order by a.customer_id;

/* 9 Write a SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman or by own. */

select a.cust_name
from customer a
left join salesman b
on a.salesman_id = b.salesman_id
where a.grade < 300;

/* 10 Write a SQL statement to make a report with customer name, city, order number, order date, and order amount in ascending order according to the order date to find that either any of the existing customers have placed no order or placed one or more orders. */

select a.cust_name, a.city, b.ord_no, b.ord_date, b.purch_amt
from customer a
left outer join orders b
on a.customer_id = b.customer_id
order by b.ord_date;

/* 11 Write a SQL statement to make a report with customer name, city, order number, order date, order amount salesman name and commission to find that either any of the existing customers have placed no order or placed one or more orders by their salesman or by own. */

select a.cust_name, a.city, b.ord_no, b.ord_date, b.purch_amt, c.name
from customer a
left outer join orders b
on a.customer_id = b.customer_id
left outer join salesman c
on b.salesman_id = c.salesman_id;

/* 12 Write a SQL statement to make a list in ascending order for the salesmen who works either for one or more customer or not yet join under any of the customers. */

select a.name, b.cust_name
from salesman a
left outer join customer b
on a.salesman_id = b.salesman_id;

/* 15 Write a SQL statement to make a report with customer name, city, order no. order date, purchase amount for those customers from the existing list who placed one or more orders or which order(s) have been placed by the customer who is not on the list. */

select a.cust_name, a.city, b.ord_no, b.ord_date, b.purch_amt
from customer a
full outer join orders b
on a.customer_id = b.customer_id;

/* 17 Write a SQL statement to make a cartesian product between salesman and customer i.e. each salesman will appear for all customer and vice versa. */

select
from salesman a
cross join customer b;



