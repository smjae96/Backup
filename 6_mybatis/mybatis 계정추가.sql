-- mybatis/mybatis 계정 추가
create user C##mybatis identified by mybatis; 
--최소권한
grant resource, connect to C##mybatis;
--테이블 스페이스 설정
alter user c##mybatis default tablespace users quota unlimited on users;