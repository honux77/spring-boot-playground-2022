DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id int auto_increment primary key,
    email varchar(64) unique not null,
    name varchar(64),
    nickname varchar(64),
    photo_url varchar(255)
);

INSERT INTO user(email, name, nickname, photo_url)
    values ('honux@a.com', 'honux', 'hodor', 'aaa'),
           ('crong@b.io', 'crong', 'pororo', 'bbb'),
           ('kyu@newzealand.com', 'qqq', null, null);

select * from user;

DROP TABLE IF EXISTS food;

CREATE TABLE food (
    name varchar(64),
    cal int,
    user int references user(id)
);

insert into food values('flower crab', 0, 1),
                        ('Sool', 2000, 2),
                        ('Kangaroo', 600, 3);

select * from food;