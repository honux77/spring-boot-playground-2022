CREATE TABLE IF NOT EXISTS user
(
    id int auto_increment primary key,
    email varchar(64) unique,
    nickname varchar(64)
);