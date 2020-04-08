DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
    id int auto_increment primary key,
    email varchar(64) unique,
    github_id varchar(64) unique
);