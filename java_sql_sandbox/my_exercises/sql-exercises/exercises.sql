# Write a SQL query to show all the winners in Physics for 1970 together with the winner of Economics for 1971.

SELECT * FROM nobel_win
    WHERE (subject ='Physics' AND year=1970) 
        UNION (SELECT * FROM nobel_win
            WHERE (subject ='Economics' AND year=1971));

# Write a SQL query to show all the winners of nobel prize in the year 1970 except the subject Physiology and Economics.

SELECT *
    FROM nobel_win 
        WHERE year=1970
            AND subject NOT IN('Physiology','Economics');

# Write a SQL query to show the winners of a 'Physiology' prize in an early year before 1971 together with winners of a 'Peace' prize in a later year on and after the 1974.

SELECT * FROM nobel_win
    WHERE (LOWER(SUBJECT) = 'physiology' AND YEAR < 1971)
    UNION (SELECT * FROM nobel_win
        WHERE (LOWER(SUBJECT) = 'peace' AND YEAR > 1974));

# Write a SQL query to find all details of the prize won by Johannes Georg Bednorz.

SELECT * FROM nobel_win
    WHERE LOWER(WINNER) = 'johannes georg bednorz';

# Find all the details of the nobel winners for the subject not started with the letter 'P' and arranged the list as the most recent comes first, then by name in order

SELECT * FROM nobel_win
    WHERE LOWER(SUBJECT) NOT LIKE ('p%')
    ORDER BY YEAR, WINNER;

# Write a SQL query to find all the details of 1970 winners by the ordered to subject and winner name; but the list contain the subject Economics and Chemistry at last.

SELECT * FROM nobel_win
    WHERE YEAR = 1970
    ORDER BY
    CASE
        WHEN SUBJECT IN ('Economics', 'Chemistry') THEN 1
    ELSE 0
    END
    ASC,
        SUBJECT, WINNER;

# Write a SQL query to find all the products with a price between Rs.200 and Rs.600.

SELECT * FROM item_mast
    WHERE PRO_PRICE BETWEEN 200 AND 600;

# Write a SQL query to calculate the average price of all products of the manufacturer which code is 16.

SELECT AVG(PRO_PRICE) as avg FROM item_mast
WHERE PRO_COM = 16;


