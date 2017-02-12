CREATE FUNCTION CAPITALIZE_FIRST(input VARCHAR(255))

  RETURNS VARCHAR(255)

DETERMINISTIC

  BEGIN
    DECLARE len INT;
    DECLARE i INT;

    SET len = CHAR_LENGTH(input);
    SET input = LOWER(input);
    SET i = 0;

    WHILE (i < len) DO
      /*check if this is a space it's suppose that next symbol must be uppercase*/
      IF (MID(input, i, 1) = ' ' OR i = 0)
      THEN
        IF (i < len)
        THEN
          SET input = CONCAT(
              LEFT(input, i), /*Sliced everything that was left*/
              UPPER(MID(input, i + 1, 1)), /*do the uppercase of next symbol after space*/
              RIGHT(input, len - i - 1) /*Slice the rest of the String*/
          ); /*And CONCAT glue these pieces together*/
        END IF;
      END IF;
      SET i = i + 1;
    END WHILE;

    RETURN input;
  END;