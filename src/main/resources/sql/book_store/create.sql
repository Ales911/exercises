
-- DROP SCHEMA IF EXISTS book_store CASCADE;
-- CREATE SCHEMA book_store;


DROP TABLE IF EXISTS book_store.book CASCADE;
DROP TABLE IF EXISTS book_store.author;
DROP TABLE IF EXISTS book_store.genre;

DROP TABLE IF EXISTS book_store.city CASCADE;
DROP TABLE IF EXISTS book_store.client CASCADE;
DROP TABLE IF EXISTS book_store.buy CASCADE;
DROP TABLE IF EXISTS book_store.buy_book;
DROP TABLE IF EXISTS book_store.step CASCADE;
DROP TABLE IF EXISTS book_store.buy_step;
DROP TABLE IF EXISTS book_store.buy_archive;


CREATE TABLE book_store.author (
    author_id INTEGER PRIMARY KEY,
    name_author VARCHAR(50)
);

INSERT INTO book_store.author (author_id, name_author)
VALUES (1, 'Булгаков М.А.'),
       (2, 'Достоевский Ф.М.'),
       (3, 'Есенин С.А.'),
       (4, 'Пастернак Б.Л.'),
       (5, 'Лермонтов М.Ю.');

CREATE TABLE book_store.genre (
    genre_id INTEGER PRIMARY KEY,
    name_genre VARCHAR(30)
);

INSERT INTO book_store.genre(genre_id, name_genre)
VALUES (1, 'Роман'),
       (2, 'Поэзия'),
       (3, 'Приключения');

CREATE TABLE book_store.book (
    book_id INTEGER PRIMARY KEY,
    title VARCHAR(50),
    author_id INT NOT NULL,
    genre_id INT,
    price DECIMAL(8, 2),
    amount INT,
    FOREIGN KEY (author_id)
        REFERENCES book_store.author (author_id)
        ON DELETE CASCADE,
    FOREIGN KEY (genre_id)
        REFERENCES book_store.genre (genre_id)
        ON DELETE SET NULL
);

INSERT INTO book_store.book (book_id, title, author_id, genre_id, price, amount)
VALUES  (1, 'Мастер и Маргарита', 1, 1, 670.99, 3),
        (2, 'Белая гвардия ', 1, 1, 540.50, 5),
        (3, 'Идиот', 2, 1, 460.00, 10),
        (4, 'Братья Карамазовы', 2, 1, 799.01, 2),
        (5, 'Игрок', 2, 1, 480.50, 10),
        (6, 'Стихотворения и поэмы', 3, 2, 650.00, 15),
        (7, 'Черный человек', 3, 2, 570.20, 6),
        (8, 'Лирика', 4, 2, 518.99, 2);

CREATE TABLE book_store.city (
    city_id INTEGER PRIMARY KEY,
    name_city VARCHAR(30),
    days_delivery INT
);

INSERT INTO book_store.city(city_id, name_city, days_delivery)
VALUES (1, 'Москва', 5),
       (2, 'Санкт-Петербург', 3),
       (3, 'Владивосток', 12);

CREATE TABLE book_store.client (
    client_id INTEGER PRIMARY KEY,
    name_client VARCHAR(50),
    city_id INT,
    email VARCHAR(30),
    FOREIGN KEY (city_id) REFERENCES book_store.city (city_id)
);

INSERT INTO book_store.client(client_id, name_client, city_id, email)
VALUES (1, 'Баранов Павел', 3, 'baranov@test'),
       (2, 'Абрамова Катя', 1, 'abramova@test'),
       (3, 'Семенонов Иван', 2, 'semenov@test'),
       (4, 'Яковлева Галина', 1, 'yakovleva@test');

CREATE TABLE book_store.buy(
    buy_id INTEGER PRIMARY KEY,
    buy_description VARCHAR(100),
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES book_store.client (client_id)
);

INSERT INTO book_store.buy (buy_id, buy_description, client_id)
VALUES (1, 'Доставка только вечером', 1),
       (2, NULL, 3),
       (3, 'Упаковать каждую книгу по отдельности', 2),
       (4, NULL, 1);

CREATE TABLE book_store.buy_book (
    buy_book_id INTEGER PRIMARY KEY,
    buy_id INT,
    book_id INT,
    amount INT,
    FOREIGN KEY (buy_id) REFERENCES book_store.buy (buy_id),
    FOREIGN KEY (book_id) REFERENCES book_store.book (book_id)
);

INSERT INTO book_store.buy_book(buy_book_id, buy_id, book_id, amount)
VALUES (1, 1, 1, 1),
       (2, 1, 7, 2),
       (3, 1, 3, 1),
       (4, 2, 8, 2),
       (5, 3, 3, 2),
       (6, 3, 2, 1),
       (7, 3, 1, 1),
       (8, 4, 5, 1);

CREATE TABLE book_store.step (
    step_id INTEGER PRIMARY KEY,
    name_step VARCHAR(30)
);

INSERT INTO book_store.step(step_id, name_step)
VALUES (1, 'Оплата'),
       (2, 'Упаковка'),
       (3, 'Транспортировка'),
       (4, 'Доставка');

CREATE TABLE book_store.buy_step (
    buy_step_id INTEGER PRIMARY KEY,
    buy_id INT,
    step_id INT,
    date_step_beg DATE,
    date_step_end DATE,
    FOREIGN KEY (buy_id) REFERENCES book_store.buy (buy_id),
    FOREIGN KEY (step_id) REFERENCES book_store.step (step_id)
);

INSERT INTO book_store.buy_step(buy_step_id, buy_id, step_id, date_step_beg, date_step_end)
VALUES (1, 1, 1, '2020-02-20', '2020-02-20'),
       (2, 1, 2, '2020-02-20', '2020-02-21'),
       (3, 1, 3, '2020-02-22', '2020-03-07'),
       (4, 1, 4, '2020-03-08', '2020-03-08'),
       (5, 2, 1, '2020-02-28', '2020-02-28'),
       (6, 2, 2, '2020-02-29', '2020-03-01'),
       (7, 2, 3, '2020-03-02', NULL),
       (8, 2, 4, NULL, NULL),
       (9, 3, 1, '2020-03-05', '2020-03-05'),
       (10, 3, 2, '2020-03-05', '2020-03-06'),
       (11, 3, 3, '2020-03-06', '2020-03-10'),
       (12, 3, 4, '2020-03-11', NULL),
       (13, 4, 1, '2020-03-20', NULL),
       (14, 4, 2, NULL, NULL),
       (15, 4, 3, NULL, NULL),
       (16, 4, 4, NULL, NULL);

CREATE TABLE book_store.buy_archive
(
    buy_archive_id INTEGER PRIMARY KEY,
    buy_id         INT,
    client_id      INT,
    book_id        INT,
    date_payment   DATE,
    price          DECIMAL(8, 2),
    amount         INT
);

INSERT INTO book_store.buy_archive (buy_archive_id, buy_id, client_id, book_id, date_payment, amount, price)
VALUES (1, 2, 1, 1, '2019-02-21', 2, 670.60),
       (2, 2, 1, 3, '2019-02-21', 1, 450.90),
       (3, 1, 2, 2, '2019-02-10', 2, 520.30),
       (4, 1, 2, 4, '2019-02-10', 3, 780.90),
       (5, 1, 2, 3, '2019-02-10', 1, 450.90),
       (6, 3, 4, 4, '2019-03-05', 4, 780.90),
       (7, 3, 4, 5, '2019-03-05', 2, 480.90),
       (8, 4, 1, 6, '2019-03-12', 1, 650.00),
       (9, 5, 2, 1, '2019-03-18', 2, 670.60),
       (10, 5, 2, 4, '2019-03-18', 1, 780.90);

