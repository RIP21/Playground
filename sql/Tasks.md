# SQL tasks

1. Write a query to rank order the following table in MySQL by votes, display the rank as one of the
columns.
```sql
CREATE TABLE votes ( name CHAR(10), votes INT );
INSERT INTO votes VALUES
 ('Smith',10), ('Jones',15), ('White',20), ('Black',40), ('Green',50), ('Brown',20);
 ```

[Solution](/sql/rank.sql)