create table t_user(
  id number(7,0)
  ,name varchar2(50)
  ,pwd varchar2(50)
);


-- drop sequence seq_t_user;
create sequence seq_t_user;

insert into t_user(id,name,pwd,phone)values(seq_t_user.nextval,'Tom','123','110');