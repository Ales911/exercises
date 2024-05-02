-- Часть 1: Получаем самую высокую зарплату в каждом отделе
-- SELECT max(salary) AS salary From employee GROUP BY department_id

 -- Часть 2: Получаем желаемый формат вывода employee_id
 -- Поскольку employee_id нельзя напрямую использовать в группе путем агрегации, мы можем прибегнуть к подзапросам.
 SELECT e1.id, e1."NAME"
 FROM employee e1 
 WHERE e1.SALARY IN (
                      SELECT max(e2.SALARY) AS amount 
                      From employee as e2
                      GROUP BY e2.department_id
                      HAVING e1.department_id = e2.department_id )
