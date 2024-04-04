/*
    *DCL : 데이터 제어 언어
    
        - 계정(사용자)에게 시스템 권한 또는 객체 접근 권한을 부여하거나 회수하는 구문
            + 시스템권한 : DB에 접근하는 권한, 객체들을 생성할 수 있는 권한
            + 객체 접근 권한 : 특정 객체들을 조작할 수 있는 권한
            
        - 계정 추가
            ** CREATE USER 계정명 IDENTIFIED BY 비밀번호;
        - 계정에 권한 부여(설정)
            ** GRANT 권한(CONNECT, RESOURCE[, DBA]) TO 계정명;   -- DBA는 보통 관리자에게만 주는 권한.
            
            + ROLE : 특정 권한들을 하나의 집합으로 모아놓은 것
                * CONNECT : 접속할 수 있는 권한 (CREATE SESSION)
                * RESOURCE : 특정 객체들을 생성할 수 있는 권한 (CREATE TABLE, CREATE SEQUENCE, ...)
*/                
-- CONNECT, RESOURCE 설정된 권한 정보 확인
SELECT *
FROM ROLE_SYS_PRIVS
WHERE ROLE IN ('CONNECT', 'RESOURCE');
--------------------------------------------------------------------------------
/*
    * TCL : 트랜잭션 제어 언어
    
        - 트랜잭션 : 데이터베이스에서 논리적 연산단위
                    데이터의 변경사항(DML) 들을 하나의 트랜잭션에 묶어서 처리
                    DML 명령어들이 실행될 때 트랜잭션이 존재하지 않는다면
                                              트랜잭션을 만들어서 묶음
                                            트랜잭션이 존재한다면 해당 
                                        트랜잭션에 포함해서 한번에 처리
                COMMIT 하기 전까지의 변경사항을 하나의 트랜잭션에 담아둔다.   
       - 트랜잭션 대상 SQL(쿼리문)
            : INSERT, UPDATE, DELETE (DML)
            
       - 트랜잭션 종류
            + COMMIT    : 트랜잭션 종류 처리 후 확정
                COMMIT; -- 트랜잭션에 담겨져 있는 변경사항들을 DB(데이터베이스)에 반영한다.    
            + ROLLBACK  : 트랜잭션 취소
                ROLLBACK; -- 트랜잭션에 담겨져 있는 변경사항들을 삭제(취소)한 후 마지막 COMMIT 시점으로 돌아간다.
                ROLLBACK TO 포인트명;   -- 임시저장한 시점인 포인트명 위치로 돌아간다.
            + SAVEPOINT : 트랜잭션 임시 저장
                SAVEPOINT 포인트명; -- 해당 시점에 포인트명으로 임시 저장점을 저장해두는 것이다.
            
*/
-- EMP_01 테이블 조회
SELECT * FROM EMP_01 ORDER BY EMP_ID;

-- 사번 201번인 사원 삭제
DELETE FROM EMP_01 WHERE EMP_ID = 201;  -- 트랜잭션 생성 후 DELETE 201 추가
DELETE FROM EMP_01 WHERE EMP_ID = 202;  --                DELETE 202 추가


ROLLBACK;   -- DELETE 201, DELETE 202 가 트랜잭션에서 제거됨
-----------------------------------------
INSERT INTO EMP_01 VALUES (900, '아무개', NULL);
COMMIT;
-----------------------------------------
SELECT * FROM EMP_01 ORDER BY EMP_ID;

-- 사번이 900번인 사원 삭제
DELETE FROM EMP_01 WHERE EMP_ID = 900;  -- 트랜잭션 생성 후 DELETE 900 추가

INSERT INTO EMP_01 VALUES (801, '손흥민', NULL);   -- INSERT 801 추가 

COMMIT;     -- DB에 변경사항을 반영
ROLLBACK;   -- 직전 COMMIT 위치까지 돌아감.
---------------------------------------
SELECT * FROM EMP_01 ORDER BY EMP_ID;
-- 사번이 217, 218, 219번인 사원을 삭제
DELETE FROM EMP_01 WHERE EMP_ID IN (217,218,219);

-- 임시저장 (SAVEPOINT)
SAVEPOINT SP;

-- 사원 추가
INSERT INTO EMP_01 (EMP_ID, EMP_NAME) 
        VALUES (700, '윤성우');
        
-- 사번이 222번인 사원 삭제
DELETE FROM EMP_01 WHERE EMP_ID = 222;

-- 임시저장(SP) 위치로 돌아가보자
ROLLBACK TO SP;
COMMIT;
--------------------------------------------
SELECT * FROM EMP_01 ORDER BY EMP_ID;
--  800번 사원 삭제
DELETE FROM EMP_01 WHERE EMP_ID = 800;

-- TEST 테이블 생성  (DDL) 
CREATE TABLE TEST (
    T_NO NUMBER
);
-- 이 시점에서 COMMIT; 이 실행된 것과 마찬가지다.

ROLLBACK;
--> 롤백을 했으나, 800번 사원 돌아오지 않고, TEST 테이블도 제거되지 않음.
-- DDL (CREATE, ALTER, DROP)을 수행하는 순간 기존에 트랜잭션에 있었던 변경 사항들이
-- 무조건 COMMIT이 된다.
-- 그렇기 때문에, DDL을 사용하기 전에 변경 사항이 있다면 확정을 지어주고 DDL을 사용해야 함.










    