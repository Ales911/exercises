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
    department_id int,
    FOREIGN KEY (department_id) REFERENCES DEPARTMENT(id)
    );
 
INSERT INTO EMPLOYEE (name, salary, department_id, city) VALUES 
    ('John Smith', 5000, 1, 'New York'),
    ('Jane Doe', 6000, 2, 'Chicago'),
    ('Bob Johnson', 4500, 2, 'Pune'),
    ('Sarah Lee', 5500, 3, 'Pune'),
    ('Alice', 7000, 3, 'San Francisco'),
    ('Emily', 6500, 4, 'San Francisco');