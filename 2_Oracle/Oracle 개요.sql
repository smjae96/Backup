-- 한줄 주석
/*
    여러 줄 주석
*/

-- RESULT SET => 코드를 실행하면 나오는 결과 값

-- 명령문 실행   : 상단의 재생버튼 또는 CTRL + ENTER
-- 현재 모든 계정들에 대해서 조회하는 명령문
SELECT * FROM DBA_USERS;
-- select * from dba_users;

-- 12버전부터 적용된 사용자 계정 추가 관련 정책을 11 이전 버전과 같이 사용하고자 할 때.
-- 아래 명령어 수행 후 추가
ALTER SESSION SET "_ORACLE_SCRIPT"=true;

-- 사용자 계정 추가 (관리자 계정으로만 가능!)
-- * CREATE USER 계정명 IDENTIFIED BY 비밀번호;
--   - 비밀번호는 대소문자 구분됨.

CREATE USER kh IDENTIFIED BY kh;

-- 사용자 계정에 권한 부여
-- * GRANT 권한1, 권한2, ... TO 계정명
--   * CONNECT : 접속 권한
--   * RESOURCE : 데이터 처리(추가/삭제/수정/조회..) 권한
--   * DBA :데이터 처리 권한
GRANT RESOURCE, CONNECT, DBA TO kh;



