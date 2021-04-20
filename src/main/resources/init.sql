DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id int auto_increment primary key,
    email varchar(64) unique not null,
    name varchar(64)
);

DROP TABLE IF EXISTS github;

CREATE TABLE github (
    nickname varchar(64),
    photo_url varchar(255),
    `user` int references user(id)
);


INSERT INTO user(email, name)
    values ('honux@a.com', 'honux'), ('crong@b.io', 'crong'),
           ('kyu@newzealand.com', 'qqq');

INSERT INTO github(nickname, photo_url, user)
    values('hodor', 'https://a.com/ppp', 1),
        ('pororo', 'https://a.com/pororo', 2);

select * from github;