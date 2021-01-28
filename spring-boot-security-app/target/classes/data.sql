DROP TABLE Users;

create table Users
(
	id integer,
	username varchar(255),
	password varchar(255),
	role varchar(255)
);

insert into Users (id,username, password, role)
values
(10001,'user','user','ROLE_USER');


insert into Users (id,username, password, role)
values
(10002,'admin','admin','ROLE_ADMIN');