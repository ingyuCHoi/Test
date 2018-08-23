Create Table member1_tbl(
	id varchar2(5) primary key,
	pw varchar2(10) not null,
	name varchar2(10) not null,
	gender char(1) not null,
	email varchar2(30) not null,
	mobile varchar2(13),
	phone varchar2(13),
	zip char(10),
	address varchar2(300),
	birhtday date NOT NULL,
	joindate date NOT NULL
);

Select * from member1_tbl;

