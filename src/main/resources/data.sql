DROP TABLE IF EXISTS EndUser;

CREATE TABLE EndUser (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);

INSERT INTO EndUser (username, password) VALUES ('test', '{noop}password');