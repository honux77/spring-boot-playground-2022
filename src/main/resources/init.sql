
drop table if exists `group`;
create table `group` (
   id int primary key auto_increment,
   name varchar(64)
);
insert into `group`(name) values
    ('game'), ('backend'), ('frontend');
select * from `group`;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id int auto_increment primary key,
    email varchar(64) unique not null,
    name varchar(64),
    nickname varchar(64),
    photo_url varchar(255),
    group_id int references `group`(id)
);
INSERT INTO user(email, name, nickname, photo_url, `group_id`)
    values ('honux@a.com', 'honux', 'hodor', 'aaa', 1),
           ('crong@b.io', 'crong', 'pororo', 'bbb', 1),
           ('kyu@newzealand.com', 'qqq', null, null, 3);
select * from user;

DROP TABLE IF EXISTS food;
CREATE TABLE food (
    name varchar(64),
    cal int,
    user int references user(id),
    order_in_user int
);
insert into food values('flower crab', 0, 1, 0),
                        ('Sool', 2000, 2, 0),
                        ('Kangaroo', 600, 3, 0);
select * from food;

drop table if exists project;
create table project (
    id int primary key auto_increment,
    name varchar(64)
);
insert into project(name) values ('sidedish'),('todo'),('super mario');
select * from project;

drop table if exists works_on;
create table works_on (
    id int primary key auto_increment,
    project_id int references project(id),
    user int references user(id),
    hour int
);

insert into works_on(project_id, user, hour) values (1, 1, 1), (2, 1, 1), (2, 2, 2);
select * from works_on;