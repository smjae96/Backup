
-- 사용자 계정 추가 : 관리자 계정으로 접속하고 추가
ALTER SESSION SET "_ORACLE_SCRIPT"=true;
CREATE USER workbook IDENTIFIED BY workbook;
-- 계정 추가 후 권한도 설정해줘야 함.
GRANT RESOURCE, CONNECT, DBA TO workbook;

-- 사용자 계정 추가
-- CREATE USER 사용자이름(ID) IDENTIFIED BY 비밀번호
CREATE USER DDL IDENTIFIED BY ddl;

-- 권한 설정
-- GRANT [권한들....] TO 사용자이름(ID);
-- RESOURCE, CONNECT, DBA
GRANT RESOURCE, CONNECT, DBA TO DDL;