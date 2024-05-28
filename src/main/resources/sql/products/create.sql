
SET DATABASE SQL SYNTAX PGS TRUE;

DROP TABLE IF EXISTS CATEGORIES CASCADE;
DROP TABLE IF EXISTS PRODUCTS;

-- Create a new table for categories
CREATE TABLE CATEGORIES (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(255)
);

-- Insert unique categories into the CATEGORIES table
INSERT INTO CATEGORIES (category_id, category_name)
VALUES (1, 'Home Appliances'), (2, 'Furniture'), (3, 'Food');

CREATE TABLE PRODUCTS (
    product_id INT PRIMARY KEY,
    product_code VARCHAR(255),
    product_name VARCHAR(255),
    product_value DECIMAL(8, 2),
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES products.CATEGORIES(category_id)
);

INSERT INTO PRODUCTS (product_id, product_code, product_name, product_value, category_id)
VALUES  (1, '1001', 'TV', 2000.00, 1),
        (2, '1002', 'Sofa', 1200.00, 2),
        (3, '1003', 'Banana', 15.00, 3),
        (4, '1004', 'Blender', 130.00, 1),
        (5, '1005', 'Refrigerator', 450.00, 1);
