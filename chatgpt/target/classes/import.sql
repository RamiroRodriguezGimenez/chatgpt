INSERT INTO chatgpt.role (id, role) VALUES (1, 'ADMIN');
INSERT INTO chatgpt.role (id, role) VALUES (2, 'USER');

INSERT INTO Currency (id, currency, converter) VALUES (1, 'USD', 1);
INSERT INTO Currency (id, currency, converter) VALUES (2, 'AR', 600);

INSERT INTO chatgpt.balance (id, balance, free_question, currency_id) VALUES (1, 0, 3, 2);
INSERT INTO chatgpt.balance (id, balance, free_question, currency_id) VALUES (2, 0, 3, 1);
INSERT INTO chatgpt.balance (id, balance, free_question, currency_id) VALUES (3, 0, 3, 1);

INSERT INTO chatgpt.USERS (user_name, creation_date, first_name, last_name, phone, gender, country, role_id, balance_id) VALUES ('usuario1', '2023-08-27', 'Ramiro', 'Gomez', '123456789', 'Masculino', 'Argentina', 2, 1);
INSERT INTO chatgpt.USERS (user_name, creation_date, first_name, last_name, phone, gender, country, role_id, balance_id) VALUES ('usuario2', '2023-08-27', 'Maria', 'Perez', '987654321', 'Femenino', 'Chile', 2, 2);
INSERT INTO chatgpt.USERS (user_name, creation_date, first_name, last_name, phone, gender, country, role_id, balance_id) VALUES ('admin', '2023-08-27', 'Andres', 'Lopez', '111111111', 'Masculino', 'Brasil', 1, 3);


INSERT INTO Answer (id, answer) VALUES (1, 'Hola');
INSERT INTO Answer (id, answer) VALUES (2, '4');
INSERT INTO Answer (id, answer) VALUES (3, 'Messi');


INSERT INTO Question (question, creation_date, user_id, answer_id) VALUES ('Hola', '2023-08-28T00:00:00', 1, 1);
INSERT INTO Question (question, creation_date, user_id, answer_id) VALUES ('Cuanto es 2+2?', '2023-08-28T00:00:00', 2, 2);
INSERT INTO Question (question, creation_date, user_id, answer_id) VALUES ('El mejor jugador del mundo', '2023-08-28T00:00:00', 3, 3);

