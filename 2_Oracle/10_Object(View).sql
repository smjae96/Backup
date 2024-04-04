/*
        * 뷰 (View) : SELECT문을 저장해둘 수 있는 객체
        
         - 자주 사용하는 긴 SELECT문을 저장해두면 그 SELECT문을 매번 작성할 필요가 없다.
         - 임시 테이블같은 존재
            + 실제 데이터를 저장하는 건 아님! -> 논리적인 테이블
*/
-- "한국"에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT * FROM DEPARTMENT;
SELECT * FROM NATIONAL;
SELECT * FROM LOCATION;

SELECT EMP_ID 사번 , EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '한국';

--  "러시아"에서 근무하는 사원들 정보 조회
SELECT EMP_ID 사번 , EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '러시아';

-- "미국"에서 근무하는 사원들 정보 조회
SELECT EMP_ID 사번 , EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '미국';
--------------------------------------------------------------------------------
/*
    1. VIEW 생성하기
    
    [표현식]
    CREATE [OR REPLACE] VIEW 뷰이름
    AS 서브쿼리;           -- 서브쿼리 : 저장할 SELECT문
    
    -- OR REPLACE : 뷰 생성 시 뷰명과 동일한 이름의 뷰가 있다면 해당 뷰에 저장된 SELECT문을 변경하고,
                                                     없다면 새로 생성한다.
*/
-- 위에서 사용한 SELECT문에서 조건부분만 제외하고 VIEW로 생성해보자.
CREATE VIEW VW_EMPLOYEE
AS SELECT EMP_ID 사번 , EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

-- KH 계정은 권한을 DBA 권한이 있어 VIEW가 잘 생성되지만,
--  일반적으로 CONNECT, RESOURCE 권한만 있을 경우에는 VIEW가 생성되지 않을 것이다.
--  따라서, CONNECT, RESOURCE 권한만 있는 경우 아래와 같이 권한을 추가해줘야 함.
--  GRANT CREATE VIEW TO KH;    -- KH 계정이 CONNECT, RESOURCE 권한만 있는 경우 추가 필요!
--  *---------------------------------

SELECT * FROM VW_EMPLOYEE;  -- VIEW (임시테이블)을 조회한다는 것은,
SELECT * FROM (             -- 이 SELECT문처럼 조회하는 것과 동일함.
    SELECT EMP_ID 사번 , EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE)
);    
--> 뷰는 가상테이블이므로, 실제 데이터를 저장하고 있지 않음!

-- "한국"에 근무하는 사원들의 정보 조회   (VW_EMPLOYEE 뷰를 사용 조회)
SELECT * FROM VW_EMPLOYEE
WHERE 근무국가명 = '한국';

--  * --------------------------------------
--    사용자 계정에 설정된 뷰 목록 조회
--          + VIEW_NAME : 뷰 이름
--          + TEXT      : 저장한 SELECT문
SELECT * FROM USER_VIEWS;
--  * --------------------------------------

-- 기존에 생성한 VW_EMPLOYEE 뷰를 갱신  (BONUS 컬럼 추가)
CREATE OR REPLACE VIEW VW_EMPLOYEE
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

SELECT * FROM VW_EMPLOYEE;
--------------------------------------------------------------------------------

-- 전체 사원의 사번, 이름, 직급명, 성별('남'/'여'), 근무년수를 조회할 수 있는 SELECT문 
--> 뷰(VW_EMP_JOB)로 생성
--  * 전체 사원의 사번, 이름, 직급명, 성별('남'/'여'), 근무년수를 조회
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

CREATE OR REPLACE VIEW VW_EMP_JOB 
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, DECODE(SUBSTR(EMP_NO, 8,1), '1', '남', '2', '여') 성별 , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) 근무년수
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

/* 
    * 서브쿼리에서 함수식이나 산술연산식을 사용하게 되는 경우
        별칭이 없으면 뷰가 생성되지 않기 때문에, 반드시 별칭을 부여해줘야 함.
*/        
SELECT * FROM VW_EMP_JOB;


-- 별칭 부여 방법2
--  * 뷰명 옆에 컬럼을 지정하는 경우 모든 컬럼의 이름을 작성해야 함.
CREATE OR REPLACE VIEW VW_EMP_JOB (사번, 이름, 직급명, 성별, 근무년수)
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, DECODE(SUBSTR(EMP_NO, 8,1), '1', '남', '2', '여'), EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

-- 데이터 조회 시 해당 컬럼명 사용해야 함.
SELECT * FROM VW_EMP_JOB
WHERE emp_id = 200;

SELECT * FROM VW_EMP_JOB
WHERE 근무년수 >= 20;

-- SELECT * FROM VW_EMP_JOB WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >=20;   : 뷰에서 데이터 조회할 때 부여한 별칭 자체가 컬럼명이 되므로 이에 유의할 것!
SELECT * FROM VW_EMP_JOB WHERE 근무년수 >= 20;      -- 으로 조회해야 한다.

-- 뷰를 삭제하고자 한다면, DROP VIEW 뷰명;
DROP VIEW VW_EMP_JOB;
--------------------------------------------------------------------------------
/*
    * 생성된 뷰를 통해서 DML(INSERT, UPDATE, DELETE) 사용한다면 ?  -- 사용 가능
    
*/    
-- JOB 테이블을 뷰로 생성해보자. (VW_JOB)

CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME FROM JOB;

SELECT * FROM VW_JOB ORDER BY JOB_CODE; -- 데이터를 가지고 있는 게 아니라 JOB 테이블을 조회하는 SELECT문을 가지고 있음.
SELECT * FROM JOB ORDER BY JOB_CODE;    -- 실제 데이터는 JOB 테이블에 있음.     

-- INSERT
INSERT INTO VW_JOB VALUES ('J8', '인턴');     -- 실제 데이터가 있는 JOB 테이블에 데이터가 추가됨.

-- UPDATE
UPDATE VW_JOB
SET JOB_NAME = '아르바이트'
WHERE JOB_CODE = 'J8';      -- 실제 데이터가 있는 JOB 테이블의 데이터가 변경됨.

-- DELETE
DELETE FROM VW_JOB
WHERE JOB_CODE = 'J8';  -- 실제 데이터가 있는 JOB 테이블의 데이터가 삭제됨.
-----------------------------------------------------------------------
/*
    * DML 명령어로 조작이 불가능한 경우
        [1] 뷰에 정의되어 있지 않은 컬럼을 조작하려는 경우 --> 만약 JOB_NAME 만으로 VIEW를 생성한 경우 JOB_CODE 컬럼 조작 불가능
        [2] 뷰에 정의되어 있지 않은 컬럼 중에 실제 데이터가 저장된 테이블에서 
            NOT NULL 제약조건이 지정되어 있는 경우.  --> JOB_NAME만으로 VIEW를 생성하려 할 때, JOB_CODE가 NOT NULL 제약조건이 지정되어 있다면 NULL값이 JOB_CODE에 들어갈 수 없으므로 조작 불가능.
        [3] 산술연산식이나 함수식을 사용하여 조회된 컬럼의 경우    --> 산술연산식이나 함수식이 사용된 컬럼은 실제 데이터가 아니다.
        [4] 그룹 함수나 GROUP BY절이 포함되어 있는 경우
        [5] DISTINCT 구문이 포함된 경우             --> [3],[4],[5]는 실제 데이터를 조작하여 뷰에서 정의하는 것.
        [6] JOIN을 이용해서 여러 테이블을 연결한 경우
        
    - 이렇게 다양한 조건으로 DML을 사용할 수 없기 때문에,
      대부분 뷰는 조회를 목적으로 이용한다. DML은 되도록 사용하지 않는 것이 좋다.
*/    
--------------------------------------------------------------------------------
/*
    * VIEW 옵션
    
    [상세표현식]
    CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰명 
    AS 서브쿼리
    [WITH CHECK OPTION]
    [WITH READ ONLY]
    
    + OR REPLACE : 기존에 동일한 뷰가 있으면 갱신하고, 동일한 뷰가 없으면 새로 생성
    + FORCE | NOFORCE
        - FORCE : 서브쿼리에 기술된 테이블이 존재하지 않을 경우에도 뷰가 생성됨
        - NOFORCE : 서브쿼리에 기술된 테이블이 존재해야지만 뷰가 생성됨 (기본값)
    + WITH CHECK OPTION : DML 사용 시 서브쿼리에 기술된 조건에 부합한 값으로 DML  동작되도록.
    + WITH READ ONLY : 뷰에 대해서 조회만 가능하도록 하는 옵션
*/    
-- FORCE | NOFORCE
-- FORCE 옵션 적용하여 뷰 생성
CREATE FORCE VIEW VW_TEST
AS SELECT T_ID, T_NAME FROM TT;

SELECT * FROM VW_TEST;          -- VW_TEST 뷰가 생성은 됐으나, TT라는 테이블이 없어 오류 발생!

-- NOFORCE 옵션 적용하여 뷰 생성
CREATE NOFORCE VIEW VW_TEST_2
AS SELECT T_ID, T_NAME FROM TT;        -- TT라는 테이블이 존재하지 않아 오류 발생

CREATE TABLE TT (
    T_ID NUMBER,
    T_NAME VARCHAR2(30)
);    

SELECT * FROM VW_TEST;          -- TT 테이블 생성 후 오류가 사라짐! (발생하지 않음!)

CREATE NOFORCE VIEW VW_TEST_2
AS SELECT T_ID, T_NAME FROM TT;     -- TT 테이블 생성 후 뷰가 정상적으로 생성됨.

SELECT * FROM VW_TEST_2;
--------------------------------------------------------------------------------
-- WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합되지 않는 값으로 수정되지 않도록 함.
--  급여가 300만원 이상인 사원 정보를 뷰로 생성 (VW_EMP)
CREATE VIEW VW_EMP
AS SELECT * 
FROM EMPLOYEE
WHERE SALARY  >= 3000000;


SELECT * FROM VW_EMP;
-- 사번이 200번인 사원의 월급을 500만원으로 변경
UPDATE VW_EMP 
SET SALARY = 5000000
WHERE EMP_ID = '200';
-- 같은 사원의 월급을 250만원으로 변경
UPDATE VW_EMP
SET SALARY = 2500000
WHERE EMP_ID = 200;

ROLLBACK;

-- WITH CHECK OPTION 을 사용하여 뷰를 다시 생성
CREATE OR REPLACE VIEW VW_EMP
AS SELECT * 
FROM EMPLOYEE
WHERE SALARY  >= 3000000
WITH CHECK OPTION;

SELECT * FROM VW_EMP;
-- 사번이 200번인 사원의 월급을 500만원으로 변경
UPDATE VW_EMP 
SET SALARY = 5000000
WHERE EMP_ID = '200';
-- 같은 사원의 월급을 250만원으로 변경
UPDATE VW_EMP
SET SALARY = 2500000
WHERE EMP_ID = 200; --> 변경 안됨. 오류남!

SELECT * FROM EMPLOYEE;
--------------------------------------------------------------------------------
-- WITH READ ONLY
CREATE OR REPLACE VIEW VW_EMP
AS SELECT EMP_ID, EMP_NAME, BONUS
    FROM EMPLOYEE
    WHERE BONUS IS NOT NULL
WITH READ ONLY;

SELECT * FROM VW_EMP;

-- 200번 사원 삭제
DELETE FROM VW_EMP
WHERE EMP_ID = 200; --> WITH READ ONLY 옵션에 따라 삭제불가!




