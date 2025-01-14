drop user vra cascade;

create user vra identified by Changeme0;

alter user vra quota unlimited on DATA;

alter user vra quota unlimited on USERS;

grant create session to vra with admin option;

grant connect to vra;

alter session set current_schema = vra;

create table item (
	id 				varchar2(8) primary key,
	title			varchar2(128),
	genre			varchar2(16),
	copies			number(3,0)
)