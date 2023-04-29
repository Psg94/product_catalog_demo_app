-- Users and roles sample dataset
SELECT nextval('user_sequence');
SELECT nextval('user_sequence');

INSERT INTO users(id, username, password, email) VALUES (1, 'admin', '$2a$12$U1rFHOLz8AN.iQ/bGwca8OKC4p6WnyALTxHX.j1tewgSLhXGgGiHS', 'admin@mail.com');
INSERT INTO users(id, username, password, email) VALUES (2, 'user', '$2a$12$wPvMqfzPiquRGSUMIOL14.gQF4fGbJt0tnU13uzt5OmMGkB2X2GPK', 'user@mail.com');

SELECT nextval('role_sequence');
SELECT nextval('role_sequence');

INSERT INTO roles(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles(id, name) VALUES (2, 'ROLE_USER');

INSERT INTO users_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles(user_id, role_id) VALUES (2, 2);

-- Categories and products sample dataset
INSERT INTO product_categories(name, description) VALUES('Light bulb', 'An ordinary light bulb');
INSERT INTO product_categories(name, description) VALUES('LED light bulb', 'LED');

INSERT INTO products(name, description, price, category_id, status, creation_date, image)
VALUES('Light bulb 1', '-', 100, 1, 'ACTIVE', CURRENT_TIMESTAMP(), NULL);

INSERT INTO products(name, description, price, category_id, status, creation_date, image)
VALUES('Light bulb 2', '-', 110, 1, 'ACTIVE', CURRENT_TIMESTAMP(), NULL);

INSERT INTO products(name, description, price, category_id, status, creation_date, image)
VALUES('LED bulb 3', 'New LED bulb', 200, 2, 'ACTIVE', CURRENT_TIMESTAMP(), NULL);

