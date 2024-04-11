-- SELECT * FROM pdd.fine

--update fine f, traffic_violation tv set f.sum_fine = tv.sum_fine where f.sum_fine is null and f.violation = tv.violation

-- SELECT name, number_plate, violation, count(*)
-- FROM fine
-- GROUP BY name, number_plate, violation;

-- SELECT name, number_plate, violation
-- FROM fine 
-- GROUP BY name, number_plate, violation
-- having COUNT(violation) > 1
-- ORDER BY name

-- UPDATE fine, 
--     (
--  SELECT name, number_plate, violation
--  FROM fine 
--  GROUP BY name, number_plate, violation
--  having COUNT(violation) > 1
--  ORDER BY name
--     ) as query_in
-- SET fine.sum_fine = 2 * fine.sum_fine
-- WHERE fine.name = query_in.name AND fine.violation = query_in.violation AND fine.number_plate = query_in.number_plate AND fine.date_payment is null;


-- UPDATE pdd.fine f, pdd.payment p   
-- SET f.date_payment = p.date_payment, f.sum_fine = IF (DATEDIFF(p.date_payment, p.date_violation) < 21, f.sum_fine/2, f.sum_fine)
-- WHERE f.name = p.name AND f.number_plate = p.number_plate AND f.violation = p.violation AND f.date_violation = p.date_violation AND f.date_payment IS NULL;
-- 
-- SELECT * FROM pdd.fine;  /* Чтобы сразу увидеть плоды нашей работы */

--  CREATE TABLE pdd.back_payment AS
--    SELECT "name", number_plate, violation, sum_fine, date_violation
--    FROM pdd.fine
--    WHERE date_payment IS NULL;


SELECT * FROM pdd.fine;

DELETE FROM pdd.fine WHERE date_violation < '2020-02-01'

