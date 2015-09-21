drop table if exists credit_cards;
drop table if exists orders;
drop table if exists picture_data;
drop table if exists picture_thumb;
drop table if exists pictures;
drop table if exists users;


create table credit_cards (
	number varchar(30) PRIMARY KEY,
	expiry_month int NOT NULL,
	expiry_year int NOT NULL,
	ccv int NOT NULL
);

create table users (
	username varchar(30) NOT NULL PRIMARY KEY,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	user_password varchar(30) NOT NULL,
	email varchar(30) NOT NULL
);

create table pictures (
	id int AUTO_INCREMENT PRIMARY KEY,
	username varchar(30) NOT NULL,
	file_name varchar(128) NOT NULL,
	price  numeric(15,2) NOT NULL,
	FOREIGN KEY(username) REFERENCES users(username)
);

create table picture_data (
	id int AUTO_INCREMENT PRIMARY KEY,
	picture_data longblob NOT NULL,
	FOREIGN KEY (id) REFERENCES pictures(id)
);

create table picture_thumb (
	id int AUTO_INCREMENT PRIMARY KEY,
	picture_data longblob NOT NULL,
	FOREIGN KEY (id) REFERENCES pictures(id)
);

create table orders (
	id int AUTO_INCREMENT PRIMARY KEY,
	username varchar(30),
	picture_id int,
	FOREIGN KEY (username) REFERENCES users(username),
	FOREIGN KEY (picture_id) REFERENCES pictures(id)
);