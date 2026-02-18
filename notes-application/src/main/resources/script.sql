CREATE TABLE users(
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(500) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	constraint fk_authorities_users foreign key(username)
	references users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username,authority);

