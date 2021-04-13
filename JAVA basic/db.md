# RDBMS

- Relational DataBase System
- 테이블 기반 => 하나의 테이블 = 여러개의 컬럼
- 중복 데이터 최소화
- join으로 필요한 데이터 검색



### SQL(Structured Query Language)

Database에 있는 정보 사용할 수 있도록 지원하는 언어

대소문자 구별x

| 문장                                            | 설명                    |
| ----------------------------------------------- | ----------------------- |
| **DML(Data Manipulation Lang)**                 |                         |
| INSERT                                          | 데이터 입력             |
| UPDATE                                          | 데이터 수정             |
| DELETE                                          | 데이터 삭제             |
| SELECT                                          | 데이터 조회             |
| **DDL(Data Definition Lang) = CARD**            |                         |
| CREATE                                          | DB 객체 생성            |
| ALTER                                           | DB 객체 삭제            |
| DROP                                            | 기존 DB 객체 수정       |
| RENAME                                          |                         |
| **TCL(Transaction Control Lang) DML 변경 관리** |                         |
| COMMIT                                          | 실행 쿼리 적용          |
| ROLLBACK                                        | 마지막 커밋 전으로 취소 |
| **DCL(Data Control Lang) 접근권한 제공/제거**   |                         |
| GRANT                                           | DB 객체에 권한 부여     |
| REVOKE                                          | DB 객체에 권한 취소     |



## DDL : CARD : Create, Alter, Rename, Drop


```mysql
create database dbtest -- db 생성
default character set utf8mb3 
collate utf8mb3_general_ci;

alter database dbtest -- db 수정
default character set utf8mb3;

drop database dbtest; -- db삭제
use dbtest; -- db 사용
```


```mysql
create table ssafy_member(
	idx			int 			not null auto_increment,
    userid 		varchar(16)		not null,
    username 	varchar(20),
    userpwd 	varchar(16),
    joindate	timestamp 		not null defautl current_timestamp,
    primary key (idx)
) engine=innptDB deafult charset=utf8;


insert into ssafy_member (userid, username, joindate)
valuse 
	('test', 'testname', now()),
	('second','test2', now());
	
	
update ssafy_member
set username = 'change', joindate=now()
where userid = 'test';

delete from ssafy_member
where userid = 'test';
```


### between A and B => A<= X <=B

### X is (not) null 로 해야 검색됨!!

### like 뒤에  %는 0글자 이상 / _(언더바)는 1글자씩 의미

### null & false = false , true | null = true    이거 두개빼고 다 null!!!!!!!!!!!


### round(123.456,2) => 3째자리에서 반올림


```mysql
select insert('helloabc!!!', 6, 3, ' ssafy ')
from dual;
===> hello ssafy !!!
```










# 데이터베이스 모델링 : 개논물!!!

# 기본키 : not null / unique

