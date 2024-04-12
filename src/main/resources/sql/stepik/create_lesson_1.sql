--DROP SCHEMA IF EXISTS book_store CASCADE;
--CREATE SCHEMA book_store;

SET DATABASE SQL SYNTAX PGS TRUE;

DROP TABLE IF EXISTS module CASCADE;
DROP TABLE IF EXISTS lesson CASCADE;
DROP TABLE IF EXISTS step CASCADE;
DROP TABLE IF EXISTS keyword CASCADE;
DROP TABLE IF EXISTS step_keyword;
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS step_student;

CREATE TABLE module
(
    module_id SERIAL PRIMARY KEY,
    module_name VARCHAR(64)
);
 
INSERT INTO module (module_name)
        ('Основы реляционной модели и SQL'),
        ('Запросы SQL к связанным таблицам'),
        ('Базы данных и SQL запросы');
 
CREATE TABLE lesson
(
    lesson_id       SERIAL PRIMARY KEY,
    lesson_name     VARCHAR(50),
    module_id       INT,
    lesson_position INT,
    FOREIGN KEY (module_id) REFERENCES module (module_id) ON DELETE CASCADE
);
 
INSERT INTO lesson(lesson_name, module_id, lesson_position)
VALUES ('Отношение(таблица)', 1, 1),
       ('Выборка данных', 1, 2),
       ('Таблица "Командировки", запросы на выборку', 1, 6),
       ('Вложенные запросы', 1, 4);

CREATE TABLE step
(
    step_id       SERIAL PRIMARY KEY,
    step_name     VARCHAR(256),
    step_type     VARCHAR(16),
    lesson_id     INT,
    step_position INT,
    FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id) ON DELETE CASCADE
);

INSERT INTO step(step_name, step_type, lesson_id, step_position)
VALUES ('Структура уроков курса', 'text', 1, 1),
       ('Содержание урока', 'text', 1, 2),
       ('Реляционная модель, основные положения', 'table', 1, 3),
       ('Отношение, реляционная модель', 'choice', 1, 4);

CREATE TABLE keyword
(
    keyword_id   SERIAL PRIMARY KEY,
    keyword_name VARCHAR(16)
);

INSERT INTO keyword(keyword_name)
VALUES ('SELECT'),
       ('FROM');

CREATE TABLE step_keyword
(
    step_id    INT,
    keyword_id INT,
    PRIMARY KEY (step_id, keyword_id),
    FOREIGN KEY (step_id) REFERENCES step (step_id) ON DELETE CASCADE,
    FOREIGN KEY (keyword_id) REFERENCES keyword (keyword_id) ON DELETE CASCADE
);

-- MySQL
-- SET FOREIGN_KEY_CHECKS = 0;
-- SET session_replication_role = 'replica';

-- Hsqldb
SET DATABASE REFERENTIAL INTEGRITY FALSE;

INSERT INTO step_keyword (step_id, keyword_id)
VALUES (38, 1), (81, 3);

CREATE TABLE student
(
    student_id   SERIAL PRIMARY KEY,
    student_name VARCHAR(64)
);

INSERT INTO student(student_name)
VALUES ('student_1'),
       ('student_2');

CREATE TABLE step_student
(
    step_student_id SERIAL PRIMARY KEY,
    step_id         INT,
    student_id      INT,
    attempt_time    INT,
    submission_time INT,
    result          VARCHAR(16),
    FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE CASCADE,
    FOREIGN KEY (step_id) REFERENCES step (step_id) ON DELETE CASCADE
);

INSERT INTO step_student (step_id, student_id, attempt_time, submission_time, result)
VALUES (10, 52, 1598291444, 1598291490, 'correct'),
       (10, 11, 1593291995, 1593292031, 'correct'),
       (10, 19, 1591017571, 1591017743, 'wrong'),
       (10, 4, 1590254781, 1590254800, 'correct');

-- /*включаем проверку*/

-- MySQL
-- SET FOREIGN_KEY_CHECKS = 1;
-- SET session_replication_role = 'origin';

-- Hsqldb
SET DATABASE REFERENTIAL INTEGRITY TRUE;