DROP TABLE IF EXISTS github;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (id int auto_increment primary key, email varchar(64) unique);

CREATE TABLE github(
    id int auto_increment primary key,
    user int references user(id),
    github_id varchar(64)
)
