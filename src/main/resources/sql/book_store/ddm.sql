--SET SCHEMA book_store;
-- SELECT * FROM BOOK_STORE.AUTHOR LIMIT 100;
SELECT AUTHOR_ID, COUNT(AUTHOR_ID) as Различных_книг, SUM(amount) as Количество_экземпляров, MIN(price) AS Минимальная_цена, MAX(price) AS Максимальная_цена, AVG(price) AS Средняя_цена
FROM BOOK_STORE.BOOK
GROUP BY AUTHOR_ID;

