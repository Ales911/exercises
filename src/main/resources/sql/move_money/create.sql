
-- DROP SCHEMA IF EXISTS move_money CASCADE;
-- CREATE SCHEMA move_money;
-- 
-- SET DATABASE SQL SYNTAX PGS TRUE;
-- 
DROP TABLE IF EXISTS user CASCADE;
DROP TABLE IF EXISTS transaction CASCADE;

-- Create a new table for users
CREATE TABLE user (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

-- Insert unique users into the table
INSERT INTO user (name)
VALUES ('User1'), ('User2'), ('User3');

CREATE TABLE transaction (
    id SERIAL PRIMARY KEY,
    user_id_from INT,
    user_id_to INT,
    amount INT,
    FOREIGN KEY (user_id_from) REFERENCES user(id),
    FOREIGN KEY (user_id_to) REFERENCES user(id)
);
 
INSERT INTO transaction (user_id_from, user_id_to, amount)
VALUES  (1, 2, 100),
        (1, 3, 200),
        (2, 3, 400),
        (1, 2, 600),
        (1, 2, 1000)
;


select sum(amount) from transaction where USER_ID_FROM = 1 and USER_ID_TO = 2