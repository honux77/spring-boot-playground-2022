drop table if exists game;
drop table if exists user;

CREATE TABLE user (
    id int primary key auto_increment,
    email varchar(64)
);

CREATE TABLE game (
    id int primary key auto_increment,
    title varchar(64),
    user int references user(id),
    user_key clob
);
