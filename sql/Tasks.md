# SQL tasks

- Write a query to rank order the following table in MySQL by votes, display the rank as one of the
columns.
```sql
CREATE TABLE votes ( name CHAR(10), votes INT );
INSERT INTO votes VALUES
 ('Smith',10), ('Jones',15), ('White',20), ('Black',40), ('Green',50), ('Brown',20);
 ```
[Solution](/sql/rank.sql)

- Write a function to capitalize the first letter of a word in a given string;
   Example:
   ```sql
   SELECT initcap("UNITED states Of AmERIca ") == United States Of America
   ```
[Solution](/sql/upperCase.sql)

- Here is the table from bug tracker. Write procedure to show number of still open bugs per date within date range.
   ```sql
   CREATE TABLE bugs
   (
     id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     open_date  DATE            NOT NULL,
     close_date DATE
   );
   CREATE UNIQUE INDEX bugs_id_uindex
     ON bugs (id);

   INSERT INTO `database`.bugs (open_date, close_date) VALUES ('2017-02-01', null);
   INSERT INTO `database`.bugs (open_date, close_date) VALUES ('2017-02-01', null);
   INSERT INTO `database`.bugs (open_date, close_date) VALUES ('2017-02-02', '2017-02-12');
   INSERT INTO `database`.bugs (open_date, close_date) VALUES ('2017-02-02', null);
   INSERT INTO `database`.bugs (open_date, close_date) VALUES ('2017-02-03', '2017-02-09');
   INSERT INTO `database`.bugs (open_date, close_date) VALUES ('2017-02-04', '2017-02-12');
   INSERT INTO `database`.bugs (open_date, close_date) VALUES ('2017-02-05', '2017-02-11');
   INSERT INTO `database`.bugs (open_date, close_date) VALUES ('2017-02-06', null);
   ```
   [Solution](/sql/showOpenBugsInDateRange.sql)
