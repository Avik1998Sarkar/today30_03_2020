create database today30_03_2020;

use today30_03_2020;

create table Address(
      houseNo varchar(20) not null primary key,
      city varchar(100) not null 
);

create table student(
   	id int not null primary key,
	name varchar(100) not null,
	course varchar(100) not null,
	houseNo varchar(20) references Address(houseNo)
);