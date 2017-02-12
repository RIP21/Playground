# SQL tasks
Written in MySQL dialect.

### Task 1:
*Write a query to rank order the following table in MySQL by votes, display the rank as one of the columns.*
```sql
 CREATE TABLE votes ( name CHAR(10), votes INT );
 INSERT INTO votes VALUES
  ('Smith',10), ('Jones',15), ('White',20), ('Black',40), ('Green',50), ('Brown',20)
  ```
 [Solution](/sql/rank.sql)

### Task 2:
*Write a function to capitalize the first letter of a word in a given string.
Example:*
   ```sql
   SELECT initcap("UNITED states Of AmERIca ") == United States Of America
   ```
   [Solution](/sql/upperCase.sql)

### Task 3:
*Here is the table from bug tracker. Write procedure to show number of still open bugs per date within date range.*
   ```sql
   CREATE TABLE bugs
   (
     id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     open_date  DATE            NOT NULL,
     close_date DATE
   );
   CREATE UNIQUE INDEX bugs_id_uindex
     ON bugs (id);

   INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-01', null);
   INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-01', null);
   INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-02', '2017-02-12');
   INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-02', null);
   INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-03', '2017-02-09');
   INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-04', '2017-02-12');
   INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-05', '2017-02-11');
   INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-06', null);
   ```
   [Solution](/sql/showOpenBugsInDateRange.sql)

### Task 4:
*Write a procedure in MySQL to split a column into rows using a delimiter.
For example rows would look like `"3, white", "3, Snow"`*
```sql
CREATE TABLE aTable (
  id   INT,
  name VARCHAR(50)
);
INSERT INTO aTable VALUES
  (1, 'Smith'), (2, 'Julio|Jones|Falcons'), (3, 'White|Snow'), (4, 'Paint|It|Red'), (5, 'Green|Lantern'),
  (6, 'Brown|bag');
```
[Solution](/sql/columnsFromDelimiters.sql)

### Task 4:
*Given string `'Julio|Jones|Falcons'`Write a function which apply (input, delimiter, position)
and return string.
Example:*
```sql
SELECT STRING_SPLIT('Julio|Jones|Falcons', '|', 3); /*Returns 'Falcons'*/
```
[Solution](/sql/stringSplit.sql)