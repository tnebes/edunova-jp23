/*
 * https://www.w3resource.com/sql-exercises/sql-fromatting-output-exercises.php
 */

 /* 1 Write a SQL statement to display the commission with the percent sign ( % ) with salesman ID, name and city columns for all the salesmen. */

select salesman_id, name, city, '%', commission * 100
from salesman;

/* 3 Write a query to display the orders according to the order number arranged by ascending order. */

select *
from orders
order by ord_no asc;

/* 5 Write a SQL statement to display the orders with all information in such a manner that, the older order date will come first and the highest purchase amount of same day will come first. */

select *
from orders
order by ord_date asc, purch_amt desc;

/* 7 Write a SQL statement to make a report with salesman ID, order date and highest purchase amount in such an arrangement that, the smallest salesman ID will come first along with their smallest order date. */

select salesman_id, ord_date, max(purch_amt)
from orders
group by salesman_id, ord_date
order by salesman_id, ord_date;

/* 9 Write a SQL statement to make a report with customer ID in such a manner that, the largest number of orders booked by the customer will come first along with their highest purchase amount. */

select customer_id, count(customer_id), max(purch_amt)
from orders
group by customer_id
order by 2 desc, 3 desc;

/* 10 Write a SQL statement to make a report with order date in such a manner that, the latest order date will come last along with the total purchase amount and total commission (15% for all salesmen) for that date. */

select ord_date, sum(purch_amt), sum(purch_amt) * 0.15 as commission
from orders
group by ord_date
order by ord_date;