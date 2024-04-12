create table my_board(
	idx int not null auto_increment,
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(),
	count int default 0,
	primary key(idx)
);


insert into my_board(title, content, writer)
values('게시판 연습','게시판 연습입니다.','최성웅');
delete my_board where title = '게시판 연습';

select * from my_board;
select * from my_board order by idx desc;
