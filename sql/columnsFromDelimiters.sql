/*
Write a procedure in MySQL to split a column into rows using a delimiter.
For example rows would look like >> "3, white", "3, Snow"
*/
DROP TABLE IF EXISTS aTable;
CREATE TABLE aTable (
  id   INT,
  name VARCHAR(50)
);
INSERT INTO aTable VALUES
  (1, 'Smith'), (2, 'Julio|Jones|Falcons'), (3, 'White|Snow'), (4, 'Paint|It|Red'), (5, 'Green|Lantern'),
  (6, 'Brown|bag');

/*It working pretty well (maximum 5 or more if you add more unions, which is mess but fast solution :D)*/
SELECT
  aTable.id,
  SUBSTRING_INDEX(SUBSTRING_INDEX(aTable.name, '|', numbers.n), '|', -1) name
FROM
  (SELECT 1 n
   UNION ALL SELECT 2
   UNION ALL SELECT 3
   UNION ALL SELECT 4
   UNION ALL SELECT 5
  ) numbers INNER JOIN aTable
    ON CHAR_LENGTH(aTable.name) - CHAR_LENGTH(REPLACE(aTable.name, '|', '')) >= numbers.n - 1
ORDER BY
  id, n;


/* More complicated but universal solution */
DROP PROCEDURE IF EXISTS SPREAD_COLUMN_TO_ROWS;
CREATE PROCEDURE SPREAD_COLUMN_TO_ROWS()
  BEGIN

    DECLARE delimiter VARCHAR(255) DEFAULT '|';
    DECLARE id INT DEFAULT 0;
    DECLARE name TEXT;
    DECLARE occurance INT DEFAULT 0;
    DECLARE i INT DEFAULT 0;
    DECLARE splitted_value VARCHAR(255);
    DECLARE done INT DEFAULT 0;
    DECLARE cursr CURSOR FOR SELECT
                               aTable.id,
                               aTable.name
                             FROM aTable
                             WHERE aTable.name != '';
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    DROP TEMPORARY TABLE IF EXISTS tempTable;
    CREATE TEMPORARY TABLE tempTable (
      id   INT          NOT NULL,
      name VARCHAR(255) NOT NULL
    );

    OPEN cursr;
    read_loop: LOOP
      FETCH cursr
      INTO id, name;
      IF done
      THEN
        LEAVE read_loop;
      END IF;

      SET occurance = (SELECT LENGTH(name)
                              - LENGTH(REPLACE(name, delimiter, ''))
                              + 1);
      SET i = 1;
      WHILE i <= occurance DO
        SET splitted_value =
        (SELECT REPLACE(SUBSTRING(SUBSTRING_INDEX(name, delimiter, i),
                                  LENGTH(SUBSTRING_INDEX(name, delimiter, i - 1)) + 1), delimiter, ''));

        INSERT INTO tempTable VALUES (id, splitted_value);
        SET i = i + 1;

      END WHILE;
    END LOOP;

    SELECT *
    FROM tempTable;
    CLOSE cursr;
  END;

CALL SPREAD_COLUMN_TO_ROWS();











