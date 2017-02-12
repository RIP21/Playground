/*
Here is the table from bug tracker. Write procedure to show number of still open bugs per date within date range.
*/
DROP TABLE IF EXISTS bugs;
CREATE TABLE bugs
(
  id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  open_date  DATE            NOT NULL,
  close_date DATE
);
CREATE UNIQUE INDEX bugs_id_uindex
  ON bugs (id);

INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-01', NULL);
INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-01', NULL);
INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-02', '2017-02-12');
INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-02', NULL);
INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-03', '2017-02-09');
INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-04', '2017-02-12');
INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-05', '2017-02-11');
INSERT INTO bugs (open_date, close_date) VALUES ('2017-02-06', NULL);

DROP PROCEDURE IF EXISTS OPEN_BUGS_IN_DATE_RANGE;
CREATE PROCEDURE OPEN_BUGS_IN_DATE_RANGE
  (
    IN date_from DATE,
    IN date_to   DATE
  )
  BEGIN
    SELECT
      open_date AS date,
      COUNT(*)  AS open_bugs
    FROM bugs
    WHERE open_date >= date_from
          AND (close_date > CURDATE()
               OR close_date IS NULL)
          AND open_date <= date_to
    GROUP BY open_date
    ORDER BY open_date;
  END;


/*Tests*/
CALL OPEN_BUGS_IN_DATE_RANGE("2017-01-29", "2017-02-10");
/*Three rows with 01 02 06 dates and count of 2 1 1 respectively*/
CALL OPEN_BUGS_IN_DATE_RANGE("2017-02-01", "2017-02-02");
/*Two rows with 01 02 dates and count of 2 1 respectively*/
CALL OPEN_BUGS_IN_DATE_RANGE("2017-02-01", "2017-02-06");
/*Three rows with 01 02 06 dates and count of 2 1 1 respectively*/
CALL OPEN_BUGS_IN_DATE_RANGE("2017-02-06", "2017-02-10");
/*One row with 06 date and count of 1*/
CALL OPEN_BUGS_IN_DATE_RANGE("2017-01-01", "2017-01-01");
/*Nothing which is expected*/