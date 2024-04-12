-- create table trip
-- (
--     trip_id SERIAL PRIMARY KEY ,
--     name varchar(30),
--     city varchar(25),
--     per_diem decimal(8,2),
--     date_first date,
--     date_last date
-- );

-- insert into trip (name,city,per_diem,date_first,date_last) 
-- values
-- ('Баранов П.Е.','Москва',700 , '2020-01-12', '2020-01-17'),
-- ('Абрамова К.А.','Владивосток',450 , '2020-01-14', '2020-01-27'),
-- ('Семенов И.В.','Москва',700 , '2020-01-23', '2020-01-31'),
-- ('Ильиных Г.Р.','Владивосток', 450, '2020-01-12', '2020-02-02'),
-- ('Колесов С.П.','Москва',700 , '2020-02-01', '2020-02-06'),
-- ('Баранов П.Е.','Москва', 700, '2020-02-14', '2020-02-22'),
-- ('Абрамова К.А.','Москва', 700, '2020-02-23', '2020-03-01'),
-- ('Лебедев Т.К.','Москва', 700, '2020-03-03', '2020-03-06'),
-- ('Колесов С.П.','Новосибирск',450 , '2020-02-27', '2020-03-12'),
-- ('Семенов И.В.','Санкт-Петербург',700 , '2020-03-29', '2020-04-05'),
-- ('Абрамова К.А.','Москва',700 , '2020-04-06', '2020-04-14'),
-- ('Баранов П.Е.','Новосибирск',450 , '2020-04-18', '2020-05-04'),
-- ('Лебедев Т.К.','Томск',450 , '2020-05-20', '2020-05-31'),
-- ('Семенов И.В.','Санкт-Петербург',700 , '2020-06-01', '2020-06-03'),
-- ('Абрамова К.А.','Санкт-Петербург', 700, '2020-05-28', '2020-06-04'),
-- ('Федорова А.Ю.','Новосибирск',450 , '2020-05-25', '2020-06-04'),
-- ('Колесов С.П.','Новосибирск', 450, '2020-06-03', '2020-06-12'),
-- ('Федорова А.Ю.','Томск', 450, '2020-06-20', '2020-06-26'),
-- ('Абрамова К.А.','Владивосток', 450, '2020-07-02', '2020-07-13'),
-- ('Баранов П.Е.','Воронеж', 450, '2020-07-19', '2020-07-25');

--select *, MONTHNAME(date_first) from trip;
-- select MONTHNAME(date_first) as Месяц, Count(MONTHNAME(date_first)) AS Количество  from trip group by Месяц ORDER BY Количество DESC, Месяц;
--select name, city, per_diem, date_first, date_last from trip where name like '%а %' order by date_last DESC
 --select DISTINCT name from trip where city='Москва' ORDER BY name ASC
--select DISTINCT city from trip
-- select city, COUNT(city) as Количество from trip group by city order by Количество DESC limit 2
-- select name, city, DATEDIFF(date_last, date_first) AS Длительность from trip where city not in ('Москва', 'Санкт-Петербург')
--select name, city, date_first, date_last from trip where MONTH(date_first) = MONTH(date_last)
--select name, city, date_first, per_diem * (DATEDIFF(date_last, date_first) + 1) AS Сумма from trip WHERE MONTH(date_first) IN (2, 3) ORDER BY name, Сумма DESC
--select name, per_diem * (DATEDIFF(date_last, date_first) + 1) AS Сумма from trip 
--select name, per_diem * 3 AS Сумма from trip where name in (select name from trip GROUP BY name HAVING COUNT(name) > 3)
--select name, SUM(per_diem * (DATEDIFF(date_last, date_first) + 1) AS Сумма from trip GROUP BY name HAVING COUNT(name) > 3

-- DROP SCHEMA IF EXISTS testing CASCADE;
-- CREATE SCHEMA IF NOT EXISTS testing;

--SELECT name_student, date_attempt, result FROM attempt
-- SELECT date_attempt, result FROM attempt

-- CREATE TABLE orders (
--     id SERIAL PRIMARY KEY ,
--     date date,
--     medium varchar(30),
--     Conversions int
--  );
-- 
-- insert into orders (date, medium, Conversions) 
-- values
--     ('2020-05-10', 'cpa', 1),
--     ('2020-05-10', 'cpc', 2),
--     ('2020-05-10', 'organic', 1),
--     ('2020-05-11', 'cpa', 1),
--     ('2020-05-11', 'cpc', 3),
--     ('2020-05-11', 'organic', 2),
--     ('2020-05-11', 'direct', 1),
--     ('2020-05-12', 'cpc', 1),
--     ('2020-05-12', 'organic', 2);

-- SELECT date, Medium
-- , Conversions
-- , SUM(Conversions) OVER() AS Sum
-- FROM orders;

--     SELECT 
--       Date
--     , Medium
--     , Conversions
--     , SUM(Conversions) OVER(PARTITION BY Date) AS Sum
--     FROM Orders

--     SELECT 
--       Date
--     , Medium
--     , Conversions
--     , SUM(Conversions) OVER(PARTITION BY Date ORDER BY Medium) AS Sum
--     FROM Orders

--     SELECT 
--       Date
--     , Medium
--     , Conversions
--     , SUM(Conversions) OVER(PARTITION BY Date ORDER BY Conversions ROWS BETWEEN CURRENT ROW AND 1 FOLLOWING) AS Sum 
--     FROM Orders

--     SELECT 
--       Date
--     , Medium
--     , Conversions
--     , SUM(Conversions) OVER(PARTITION BY Date) AS Sum
--     , COUNT(Conversions) OVER(PARTITION BY Date) AS Count
--     , AVG(Conversions) OVER(PARTITION BY Date) AS Avg
--     , MAX(Conversions) OVER(PARTITION BY Date) AS Max
--     , MIN(Conversions) OVER(PARTITION BY Date) AS Min
--     FROM Orders

--     SELECT 
--       Date
--     , Medium
--     , Conversions
--     , ROW_NUMBER() OVER(PARTITION BY Date ORDER BY Conversions) AS Row_number
--     , RANK() OVER(PARTITION BY Date ORDER BY Conversions) AS Rank
--     , DENSE_RANK() OVER(PARTITION BY Date ORDER BY Conversions) AS Dense_Rank 
--     , NTILE(3) OVER(PARTITION BY Date ORDER BY Conversions) AS Ntile
--     FROM Orders

--     SELECT 
--       Date
--     , Medium
--     , Conversions
--     , LAG(Conversions) OVER(PARTITION BY Date ORDER BY Date) AS Lag 
--     , LEAD(Conversions) OVER(PARTITION BY Date ORDER BY Date) AS Lead
--     , FIRST_VALUE(Conversions) OVER(PARTITION BY Date ORDER BY Date) AS First_Value
--     , LAST_VALUE(Conversions) OVER(PARTITION BY Date ORDER BY Date) AS Last_Value
--     FROM Orders



-- CREATE TABLE empsalary (
-- 	depname char (10) NOT NULL,
--         empno int NOT NULL,
--         salary int NOT NULL
-- )
-- ;
-- 
-- 
-- insert into empsalary values('develop', 11, 5200);
-- insert into empsalary values('develop', 7, 4200);
-- insert into empsalary values('develop', 9, 4500);
-- insert into empsalary values('develop', 6, 6000);
-- insert into empsalary values('develop', 10, 5200);
-- insert into empsalary values('personnel', 5, 3500);
-- insert into empsalary values('personnel', 2, 3900);
-- insert into empsalary values('sales', 3, 4800);
-- insert into empsalary values('sales', 1, 5000);
-- insert into empsalary values('sales', 4, 4800);

--select * from empsalary

--SELECT depname, empno, salary, avg(salary) FROM empsalary GROUP BY depname, empno, salary;
-- SELECT depname, empno, salary, avg(salary) OVER (PARTITION BY depname) FROM empsalary;

--SELECT depname, empno, salary, rank() OVER (PARTITION BY depname ORDER BY salary DESC) FROM empsalary;
--SELECT salary, sum(salary) OVER () FROM empsalary;
--SELECT salary, sum(salary) OVER (ORDER BY salary) FROM empsalary;