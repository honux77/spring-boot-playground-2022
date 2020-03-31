DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (id identity, email varchar(64) unique, created_date datetime);