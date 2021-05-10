create database euriscatalogo;
use euriscatalogo;

create table products (
	id int primary key auto_increment,
    nameproduct varchar(100),
    price varchar (20)
);

insert into products (nameproduct, price) values
("wheel","12p 4s 4d"),
("hammer","3p 7s 10d"),
("leather belt","6p 12s 1d");


