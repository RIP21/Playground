/*
Write a query to rank order the following table in MySQL by votes, display the rank as one of the
columns.
*/
DROP TABLE IF EXISTS votes;

CREATE TABLE votes ( name CHAR(10), votes INT );
INSERT INTO votes VALUES
 ('Smith',10), ('Jones',15), ('White',20), ('Black',40), ('Green',50), ('Brown',20);

select
     @rownum := @rownum + 1 as rank,
     name,
     votes
   from
      (select @rownum := 0 ) counter,
      (select name, votes from votes order by votes desc) sorted