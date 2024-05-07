-- Часть 1: Получаем самую высокую зарплату в каждом отделе
-- SELECT max(salary) AS salary From employee GROUP BY department_id

 -- Часть 2: Получаем желаемый формат вывода employee_id
 -- Поскольку employee_id нельзя напрямую использовать в группе путем агрегации, мы можем прибегнуть к подзапросам.
--  SELECT e1.id, e1."NAME"
--  FROM employee e1 
--  WHERE e1.SALARY IN (
--                       SELECT max(e2.SALARY) AS amount 
--                       From employee as e2
--                       GROUP BY e2.department_id
--                       HAVING e1.department_id = e2.department_id )

-- Часть 1: Поставьте рядом зарплату менеджера и зарплату сотрудника с помощью self join
-- SELECT e1.id, e1.SALARY, e1."NAME" as employee_name, d."NAME" as department_name, e2."NAME" as boss_name, e2.SALARY as boss_salary FROM employee as e1
-- JOIN employee as e2 ON e1.manager_id = e2.id
-- join DEPARTMENT as d ON e1.DEPARTMENT_ID = d.ID

-- Часть 2: Отфильтруйте сотрудников, которые зарабатывают больше, чем менеджер
-- SELECT e1.id, e1.SALARY, e1."NAME" as employee_name, d."NAME" as department_name, e2."NAME" as boss_name, e2.SALARY as boss_salary FROM employee as e1
-- JOIN employee as e2 ON e1.manager_id = e2.id AND e1.SALARY > e2.SALARY
-- join DEPARTMENT as d ON e1.DEPARTMENT_ID = d.ID

-- write a query which gives me two persons highest salary earner can you tell me the query
-- 1.
--select * from employee;
select DISTINCT(salary) from employee order by salary desc limit 1,1
-- Note:
-- limit 0,1 - Top max salary limit 1,1 - Second max salary limit 2,1 - Third max salary limit 3,1 - Fourth max salary
-- 2.We can do that like this
-- SELECT Salary FROM (SELECT DISTINCT Salary FROM Employee ORDER BY Salary desc) WHERE ROWNUM <= 2;
-- 3.
-- select (SELECT MAX(Salary) FROM Employee) maxsalary, (SELECT MAX(Salary) FROM Employee WHERE Salary NOT IN (SELECT MAX(Salary) FROM Employee )) as nd_max_salary
