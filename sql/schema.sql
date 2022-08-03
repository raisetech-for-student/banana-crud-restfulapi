DROP TABLE IF EXISTS users;

CREATE TABLE users
(
	id char(26) NOT NULL,
	name varchar(255) NOT NULL,
	birthdate date NOT NULL,
	deleted boolean NOT NULL,
	created_at datetime NOT NULL,
	created_by varchar(255)	NOT NULL,
	updated_at datetime NOT NULL,
	updated_by varchar(255)	NOT NULL,
	deleted_at datetime,
	deleted_by varchar(255),
	PRIMARY KEY(id)
);

INSERT INTO users (
	id,
	name,
	birthdate,
	deleted,
	created_at,
	created_by,
	updated_at,
	updated_by,
	deleted_at,
	deleted_by
)
VALUES
	('11110111101111011110111100', 'AA', '2022-01-01', 0, '2022-01-02 12:30:30', 'API', '2022-01-02 12:30:30', 'API', NULL, NULL),
	('22220222202222022220222200', 'BA', '2022-02-02', 0, '2022-02-02 12:30:30', 'API', '2022-02-02 12:30:30', 'API', NULL, NULL),
	('33330333303333033330333300', 'C', '2022-01-01', 0, '2022-01-02 12:30:30', 'API', '2022-01-03 12:30:30', 'API', NULL, NULL),
	('44440444404444044440444400', 'DD', '2022-01-01', 1, '2022-01-02 12:30:30', 'API', '2022-01-03 12:30:30', 'API', '2022-01-04 12:30:30', 'API');
