CREATE FUNCTION `STRING_SPLIT`(`x` VARCHAR(255), `delim` VARCHAR(12), `pos` INT(11))
  RETURNS VARCHAR(255)
  BEGIN
    DECLARE output VARCHAR(255);
    SET output = REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos)
    , LENGTH(SUBSTRING_INDEX(x, delim, pos - 1)) + 1)
    , delim
    , '');
    IF output = ''
    THEN SET output = NULL; END IF;
    RETURN output;
  END