/*
 * https://www.w3resource.com/sql-exercises/sql-boolean-operators.php
 */

 # 4 Write a SQL statement to display all the customers, who are either belongs to the city New York or not had a grade above 100.

SELECT *
FROM customer
    WHERE LOWER(city) = 'new york'
        OR NOT grade > 100;

# 5 Write a SQL query to display those customers who are neither belongs to the city New York nor grade value is more than 100.

SELECT * FROM customer
    WHERE NOT (LOWER(city) = 'new york' OR grade > 100);

# 6 Write a SQL statement to display either those orders which are not issued on date 2012-09-10 and issued by the salesman whose ID is 5005 and below or those orders which purchase amount is 1000.00 and below.

SELECT *
FROM orders
    WHERE NOT((ord_date = '2012-09-10' AND salesman_id > 5005) OR (purch_amt > 1000));

# 7 Write a SQL statement to display salesman_id, name, city and commission who gets the commission within the range more than 0.10% and less than 0.12%.

SELECT salesman_id, name, city, commission
FROM salesman
WHERE commission > 0.10 AND commission < 0.12;

# 8 Write a SQL query to display all orders where purchase amount less than 200 or exclude those orders which order date is on or greater than 10th Feb,2012 and customer id is below 3009.

SELECT *
FROM orders
    WHERE purch_amt < 200 OR NOT (ord_date > '2012-02-10' AND customer_id < 3009);

# 9 Write a SQL statement to exclude the rows which satisfy 1) order dates are 2012-08-17 and purchase amount is below 1000 2) customer id is greater than 3005 and purchase amount is below 1000.

SELECT * 
FROM orders
    WHERE NOT ((ord_date ='2012-08-17' OR customer_id>3005) AND purch_amt<1000);

# 10 Write a SQL query to display order number, purchase amount, achieved, the unachieved percentage for those order which exceeds the 50% of the target value of 6000.

SELECT ord_no, purch_amt,
(purch_amt / 6000) * 100 AS "Achieved %",
(6000 - purch_amt) / 6000 ) * 100 AS "Unachieved %"
FROM orders
    WHERE purch_amt > 6000 / 2;

# 12 Write a query in SQL to display all the data of employees that work in department 47 or department 63.

SELECT *
FROM emp_details
WHERE EMP_DEPT IN (47, 63);