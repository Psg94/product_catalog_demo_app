INSERT INTO product_categories(name, description) VALUES('Light bulb', 'An ordinary light bulb');
INSERT INTO product_categories(name, description) VALUES('LED light bulb', 'LED');

INSERT INTO products(name, description, price, category_id, status, creation_date, image)
VALUES('Light bulb 1', '-', 100, 1, 'ACTIVE', CURRENT_TIMESTAMP(), NULL);

INSERT INTO products(name, description, price, category_id, status, creation_date, image)
VALUES('Light bulb 2', '-', 110, 1, 'ACTIVE', CURRENT_TIMESTAMP(), NULL);

INSERT INTO products(name, description, price, category_id, status, creation_date, image)
VALUES('LED bulb 3', 'New LED bulb', 200, 2, 'ACTIVE', CURRENT_TIMESTAMP(), NULL);

