/*
 * Exercises from https://www.w3resource.com/sql-exercises/sql-retrieve-from-table.php
*/

# 19 Write a SQL query to show all the winners in Physics for 1970 together with the winner of Economics for 1971.

SELECT * FROM nobel_win
    WHERE (subject ='Physics' AND year=1970) 
        UNION (SELECT * FROM nobel_win
            WHERE (subject ='Economics' AND year=1971));

# 20 Write a SQL query to show all the winners of nobel prize in the year 1970 except the subject Physiology and Economics.

SELECT *
    FROM nobel_win 
        WHERE year=1970
            AND subject NOT IN('Physiology','Economics');

# 21 Write a SQL query to show the winners of a 'Physiology' prize in an early year before 1971 together with winners of a 'Peace' prize in a later year on and after the 1974.

SELECT * FROM nobel_win
    WHERE (LOWER(SUBJECT) = 'physiology' AND YEAR < 1971)
    UNION (SELECT * FROM nobel_win
        WHERE (LOWER(SUBJECT) = 'peace' AND YEAR > 1974));

# 22 Write a SQL query to find all details of the prize won by Johannes Georg Bednorz.

SELECT * FROM nobel_win
    WHERE LOWER(WINNER) = 'johannes georg bednorz';

# 23 Find all the details of the nobel winners for the subject not started with the letter 'P' and arranged the list as the most recent comes first, then by name in order

SELECT * FROM nobel_win
    WHERE LOWER(SUBJECT) NOT LIKE ('p%')
    ORDER BY YEAR, WINNER;

# 24 Write a SQL query to find all the details of 1970 winners by the ordered to subject and winner name; but the list contain the subject Economics and Chemistry at last.

SELECT * FROM nobel_win
    WHERE YEAR = 1970
    ORDER BY
    CASE
        WHEN SUBJECT IN ('Economics', 'Chemistry') THEN 1
    ELSE 0
    END
    ASC,
        SUBJECT, WINNER;

# 25 Write a SQL query to find all the products with a price between Rs.200 and Rs.600.

SELECT * FROM item_mast
    WHERE PRO_PRICE BETWEEN 200 AND 600;

# 26 Write a SQL query to calculate the average price of all products of the manufacturer which code is 16.

SELECT AVG(PRO_PRICE) as avg FROM item_mast
WHERE PRO_COM = 16;

# 27 Write a SQL query to find the item name and price in Rs.

SELECT PRO_NAME, PRO_PRICE FROM item_mast;

# 28 Write a SQL query to display the name and price of all the items with a price is equal or more than Rs.250, and the list contain the larger price first and then by name in ascending order.

SELECT PRO_NAME, PRO_PRICE FROM item_mast
    WHERE PRO_PRICE >= 250
    ORDER BY PRO_PRICE DESC, PRO_NAME;

# 29 Write a SQL query to display the average price of the items for each company, showing only the company code.

SELECT PRO_COM, AVG(PRO_PRICE) FROM item_mast
GROUP BY PRO_COM;

# 30 Write a SQL query to find the name and price of the cheapest item(s).

# not-so-good solution
SELECT PRO_NAME, PRO_PRICE
    FROM item_mast
    ORDER BY PRO_PRICE ASC
    LIMIT 1;

# better solution

SELECT *
FROM item_mast
    WHERE PRO_PRICE =
        (SELECT MIN(PRO_PRICE) FROM item_mast);

# 31 Write a query in SQL to find the last name of all employees, without duplicates.

SELECT DISTINCT EMP_LNAME
FROM emp_details;

# 32 Write a query in SQL to find the data of employees whose last name is 'Snares'.

SELECT *
FROM emp_details
    WHERE LOWER(EMP_LNAME) = 'snares';

# 33 Write a query in SQL to display all the data of employees that work in the department 57.
SELECT *
FROM emp_details
    WHERE EMP_DEPT = 57;
