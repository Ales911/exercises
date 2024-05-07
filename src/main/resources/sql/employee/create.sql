SET DATABASE SQL SYNTAX PGS TRUE;

DROP TABLE IF EXISTS EMPLOYEE CASCADE;
DROP TABLE IF EXISTS DEPARTMENT;


CREATE TABLE DEPARTMENT (
    id SERIAL PRIMARY KEY,
    name NVARCHAR(300));

INSERT INTO DEPARTMENT (name) VALUES ('Marketing', 'Engineering', 'HR', 'Sales');

CREATE TABLE EMPLOYEE (
    id SERIAL PRIMARY KEY,
    name NVARCHAR(300),
    salary INTEGER,
    city NVARCHAR(300),
    manager_id int,
    department_id int,
    FOREIGN KEY (department_id) REFERENCES DEPARTMENT(id)
    );
 
INSERT INTO EMPLOYEE (name, salary, department_id, city, manager_id) VALUES 
    ('John Smith', 5000, 1, 'New York', 7),
    ('Jane Doe', 6000, 2, 'Chicago', null),
    ('Bob Johnson', 4500, 2, 'Pune', 2),
    ('Sarah Lee', 5500, 3, 'Pune', null),
    ('Alice', 7000, 3, 'San Francisco', null),
    ('Emily', 6500, 4, 'San Francisco', null),
    ('Carmen', 4500, 1, 'New York', null)
;