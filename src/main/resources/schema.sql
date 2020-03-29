DROP TABLE IF EXISTS github;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (id int auto_increment primary key, email varchar(64) unique, created_date datetime);
CREATE TABLE github (
  user int primary key references user(id),
  email varchar(64),
  github_id varchar(64)
);
