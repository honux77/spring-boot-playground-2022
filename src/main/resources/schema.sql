DROP TABLE IF EXISTS github;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (id int auto_increment primary key, email varchar(64) unique, created_date datetime);

CREATE TABLE IF NOT EXISTS github (
  user int primary key references user(id),
  email varchar(64),
  github_id varchar(64)
);

CREATE TABLE IF NOT EXISTS game(
    id int auto_increment primary key,
    user int references user(id),
    user_key int,
    game_name varchar(64)
)