drop table user if exists;
create table user(
  id bigint auto_increment,
  name varchar(40),
  user_name varchar(40),
  age int(3),
  balance decimal(10, 2),
  primary key (id)
);
