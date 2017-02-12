/*
Write a procedure in MySQL to split a column into rows using a delimiter.
For example rows would look like >> "3, white", "3, Snow"
*/

CREATE TABLE aTable (
  id   INT,
  name VARCHAR(50)
);
INSERT INTO aTable VALUES
  (1, 'Smith'), (2, 'Julio|Jones|Falcons'), (3, 'White|Snow'), (4, 'Paint|It|Red'), (5, 'Green|Lantern'),
  (6, 'Brown|bag');

/*Found this solution. It working pretty well, but I have no idea how all this union stuff is working*/
SELECT
  aTable.id,
  SUBSTRING_INDEX(SUBSTRING_INDEX(aTable.name, '|', numbers.n), '|', -1) name
FROM
  (SELECT 1 n
   UNION ALL
   SELECT 2
   UNION ALL SELECT 3
   UNION ALL
   SELECT 4
   UNION ALL SELECT 5) numbers INNER JOIN aTable
    ON CHAR_LENGTH(aTable.name) - CHAR_LENGTH(REPLACE(aTable.name, '|', '')) >= numbers.n - 1
ORDER BY
  id, n;

/*I come out with this, but it's not complete cause it's not make a table out of the table,
 but table out of the delimiter separated values*/
CREATE FUNCTION STRING_SPLIT(x VARCHAR(255), delim VARCHAR(12), pos INTEGER)
  RETURNS VARCHAR(255)
  BEGIN
    DECLARE output VARCHAR(255);
    SET output = REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos),
                                   LENGTH(SUBSTRING_INDEX(x, delim, pos - 1)) + 1), delim, '');
    IF output = ''
    THEN SET output = NULL; END IF;
    RETURN output;
  END;

CREATE PROCEDURE ROWS_OUT_OF_COLUMN(
  IN col   VARCHAR(255),
  IN delim VARCHAR(10)
)
  BEGIN
    CREATE TEMPORARY TABLE rows_out_of_column_temp (
      value VARCHAR(255)
    );
    SET @i = 1;
    WHILE (STRING_SPLIT(col, delim, @i) IS NOT NULL) DO
      INSERT INTO rows_out_of_column_temp (value) VALUE (STRING_SPLIT(col, delim, @i));
      SET @i = @i + 1;
    END WHILE;
    SELECT *
    FROM rows_out_of_column_temp;
    DROP TEMPORARY TABLE IF EXISTS rows_out_of_column_temp;
  END;

CALL ROWS_OUT_OF_COLUMN('Julio|Jones|Falcons', '|')

SELECT
  aTable.id,
  TEMP.value
FROM aTable
  JOIN











