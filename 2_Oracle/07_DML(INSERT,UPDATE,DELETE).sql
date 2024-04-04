/*
    * DQL (QUERY) : SELECT
    * DML (MANIPULATION) : INSERT, UPDATE, DELETE
    * DDL (DEFINITION) : CREATE, ALTER, DROP
    * DCL (CONTROL) : GRANT, REVOKE
    * TCL (TRANSACTION CONTROL) : COMMIT, ROLLBACK
    
    - DML : DATA MANIPULATION LANGUAGE
            데이터 조작 언어
            값(데이터)을 삽입(추가)하거나 수정하거나 삭제할 때 사용하는 언어
*/    
/*
    1. INSERT : 테이블에 데이터를 추가할 때 사용
    
    [표현식]
        [1] INSERT INTO 테이블명 VALUES (값1, 값2, 값3, ...);
            : 테이블에 정의된 모든 컬럼에 값을 넣는 경우 사용
              순서랑 데이터타입(자료형)을 잘 지켜서 작성해야 함!
              
              * 컬럼보다 적게 값을 작성한 경우 => not enough value 오류
              * 컬럼보다 많게 값을 작성한 경우 => too many value 오류
              
        [2] INSERT INTO 테이블명(컬럼명, 컬럼명, ..) VALUES (값, 값, ..);  
            : 제시한 컬럼에 해당하는 값을 추가하는 경우 사용
              제시하지 않은 컬럼은 기본값이 있으면 기본값으로, 없으면 NULL로 데이터가 추가됨.
              
*/
-- EMPLOYEE 테이블에 사원을 추가
--  [1] 모든 컬럼을 사용하여 추가


INSERT INTO EMPLOYEE VALUES (800, '심재윤', '960528-1019731', 'tlawodbs0528@naver.com', '01062719615', 
                                    'D1', 'J1', 10000000, 0.9, 200, SYSDATE, NULL, DEFAULT);
                                    
SELECT * FROM EMPLOYEE
WHERE EMP_NAME = '심재윤';

UPDATE EMPLOYEE
SET DEPT_CODE ='D7'
WHERE EMP_NAME = '심재윤';
--  [2] 컬럼 지정하여 추가
INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES (301, '김고은', '920702-2123456', 'J1');

SELECT * FROM EMPLOYEE WHERE EMP_NAME = '김고은';

--------------------------------------------------------------------------------
/*
    [3] 서브쿼리 사용하여 데이터 추가
            : VALUES로 값을 직접 작성하는 것 대신
              서브쿼리로 조회된 결과 값을 한번에 추가
  
    [표현식] 
            INSERT INTO 테이블 (서브쿼리);
*/              
--  EMP_01 테이블 생성
CREATE TABLE EMP_01 (
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(20),
    DEPT_TITLE VARCHAR2(20)
);
SELECT * FROM EMP_01;

-- 전체 사원의 사번, 이름, 부서명을 조회하여 데이터 추가
--  * 전체 사원의 사번, 이름, 부서명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
--  * 서브쿼리를 사용하여 데이터 추가
INSERT INTO EMP_01
(
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
);
--------------------------------------------------------------------------------
/*
    [4] INSERT ALL
        두 개 이상의 테이블에 각각 데이터를 추가할 때,
        이 때 사용되는 서브쿼리가 동일한 경우 사용하는 방법
*/    
-- EMP_DEPT 테이블 생성
DROP TABLE EMP_DEPT;
CREATE TABLE EMP_DEPT 
AS ( 
     SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
     FROM EMPLOYEE
     WHERE 1 = 0
);




-- EMP_MANAGER 테이블 생성
CREATE TABLE EMP_MANAGER 
AS (
    SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE 1 = 0 -- 컬럼 정보만 가져오기 위해 억지로 FALSE 조건 제시.
);

SELECT * FROM EMP_MANAGER;
SELECT * FROM EMP_DEPT;

-- 부서코드가 'D1'인 사원들의 사번, 이름, 부서코드, 입사일, 사수사번 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

/*
    [표현식]
            INSERT ALL
            INTO 테이블명(A) VALUES (컬럼명, 컬럼명, ...)
            INTO 테이블명(B) VALUES (컬럼명, 컬럼명, ...)
                서브쿼리;
*/

INSERT ALL
INTO EMP_DEPT VALUES (EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES (EMP_ID, EMP_NAME, MANAGER_ID)
(SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1'
);

-- 6개 행이 추가됨 (각각 3개씩 추가되었음)
SELECT * FROM EMP_DEPT;     -- 3개 행 추가됨
SELECT * FROM EMP_MANAGER;  -- 3개 행 추가됨
--------------------------------------------------------------------------------
/*
    * 조건을 사용해서 각 테이블에 값을 추가하는 방법
    
    [표현식]
            INSERT ALL
            WHEN 조건1 THEN
                INTO 테이블명(A) VALUES (컬럼명, 컬럼명, ...)
            WHEN 조건2 THEN
                INTO 테이블명(B) VALUES (컬럼명, 컬럼명, ...)
            서브쿼리;    
*/
-- 입사일이 2000년 이전인 사원 사번, 이름, 월급, 입사일 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE < '2000/01/01';     -- 2000년 이전 입사자들
-- WHERE HIRE_DATE >= '2000/01/01';     -- 2000년 이후 입사자들

-- EMP_OLD 테이블 생성
CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
    FROM EMPLOYEE
    WHERE 1=0;

-- EMP_NEW 테이블 생성
CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
    FROM EMPLOYEE
    WHERE 1=0;

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

-- '2000/01/01' 이전 입사자들은 EMP_OLD 테이블에 추가
--              이후 입사자들은 EMP_NEW 테이블에 추가
INSERT ALL
    WHEN HIRE_DATE < '2000/01/01' THEN 
        INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, SALARY, HIRE_DATE)
    WHEN HIRE_DATE >= '2000/01/01' THEN
        INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, SALARY, HIRE_DATE)
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE;

-- 총 24개 행이 추가됨.
SELECT * FROM EMP_OLD;  -- 8개 행 추가됨
SELECT * FROM EMP_NEW;  -- 16개 행 추가됨
--------------------------------------------------------------------------------
/*
    2. UPDATE : 기존 데이터를 수정할 때 사용하는 구문
    
    [표현식]
            UPDATE 테이블명
            SET 컬럼명 = 값1,
                컬럼명 = 값2,
                ...
            [WHERE 조건식] --> 조건에 따라 해당 컬럼의 값을 변경하는 경우 사용    
                          --> 생략 시, 모든 데이터에 해당 컬럼의 값을 변경하게 됨. 
                          
            * 데이터 수정 시 "제약조건"을 잘 확인해야 함.              
    
*/
-- DEPARTMENT --> DEPT_TABLE 테이블로 복사 (DEPT_TABLE 테이블 생성, DEPARTMENT 테이블 기준으로)
CREATE TABLE DEPT_TABLE
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_TABLE;

-- DEPT_TABLE에서 부서코드가 'D9'인 데이터 조회
SELECT *
FROM DEPT_TABLE
WHERE DEPT_ID ='D9';

-- 부서코드가 'D9'인 부서의 부서명을 '전략기획실'으로 변경
UPDATE DEPT_TABLE
SET DEPT_TITLE = '전략기획실'
WHERE DEPT_ID = 'D9';

-- EMP_SALARY 테이블 생성 
-- (EMPLOYEE 테이블에서 복사 - EMP_ID / EMP_NAME / DEPT_CODE / SALARY / BONUS)

CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
    FROM EMPLOYEE;

SELECT * FROM EMP_SALARY;

-- '노옹철' 사원의 월급을 100만원으로 변경
SELECT * FROM EMP_SALARY WHERE EMP_NAME = '노옹철';

UPDATE EMP_SALARY
SET SALARY = 1000000
WHERE EMP_NAME = '노옹철';

-- '방명수' 사원의 월급을 500만원으로 변경하고, 보너스도 0.2로 변경
SELECT * FROM EMP_SALARY WHERE EMP_NAME = '방명수';

UPDATE EMP_SALARY
SET SALARY = 5000000,
    BONUS = 0.2
WHERE EMP_NAME = '방명수';

-- 전체 사원의 급여를 기존 급여에 10프로 인상된 금액으로 변경
UPDATE EMP_SALARY
SET SALARY = SALARY*1.1;
--------------------------------------------------------------------------------
/*
    * 데이터 변경 시 서브쿼리 사용해보기
    
    [표현식]
            UPDATE 테이블명
            SET 컬럼명 = ( 서브쿼리 )
            [WHERE 조건식]
*/
-- EMP_SALARY 
-- '방명수' 사원의 급여와 보너스를 '유재식' 사원의 급여와 보너스 값으로 변경
SELECT SALARY, BONUS FROM EMP_SALARY WHERE EMP_NAME = '방명수';
SELECT SALARY, BONUS FROM EMP_SALARY WHERE EMP_NAME = '유재식';
SELECT SALARY, BONUS FROM EMP_SALARY WHERE EMP_NAME = '장쯔위';
--  * 단일행 서브쿼리 (1행 1열)
UPDATE EMP_SALARY
SET SALARY = (SELECT SALARY
                        FROM EMP_SALARY
                        WHERE EMP_NAME = '유재식'),
    BONUS = (SELECT BONUS
                        FROM EMP_SALARY
                        WHERE EMP_NAME = '유재식')               
WHERE EMP_NAME = '방명수';  


--  * 다중열 서브쿼리 (1행 N열) -- '장쯔위' 사원의 급여와 보너스로 변경
UPDATE EMP_SALARY
SET (SALARY, BONUS) = (SELECT SALARY, BONUS
                        FROM EMP_SALARY
                        WHERE EMP_NAME = '장쯔위')
WHERE EMP_NAME = '방명수';  

-- 문제) ASIA 지역에서 근무하는 사원들의 보너스 값을 0.3으로 변경
SELECT * FROM LOCATION;
SELECT * FROM EMP_SALARY;
SELECT * FROM DEPARTMENT;

--       * ASIA 지역에서 근무하는 사원 조회
SELECT *
FROM EMP_SALARY 
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE '%ASIA%';

--      * 위의 서브쿼리를 사용하여 업데이트
UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE EMP_ID IN (     -- 서브 쿼리의 결과가 다중행이므로 '='과 아닌 'IN' 연산자를 사용.
                      -- EMP_ID로 조건을 주는 이유: PK(PRIMARY KEY)는 중복이 안 되기 때문에!!     
    SELECT EMP_ID
    FROM EMP_SALARY 
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    WHERE LOCAL_NAME LIKE '%ASIA%'
);
         

SELECT EMP_NAME, BONUS, LOCAL_NAME FROM EMP_SALARY  
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);
             
-- 여기까지 변경된 사항을 확정 짓기.
COMMIT;

create table tb_01 (
    id number,
    name varchar2(20),
    enrolldate date
);    
  
insert into tb_01
values(1, '이', sysdate);

update tb_01
set id = 2,
    name = '김',
    enrolldate = '2024/01/24';
    
select * from tb_01;    

alter table tb_01
add constraint pk01 primary key(id);

alter table tb_01
rename constraint pk01 to pk02;

alter table tb_01
modify name constraint nn01 not null;

alter table tb_01
drop constraint pk02;

alter table tb_01
modify name constraint nn01 null;

alter table tb_01
rename column name to name1;

select * from tb_01;
    
--------------------------------------------------------------------------------
/*
    3. DELETE : 테이블에 저장된 데이터를 삭제하는 구문
    
    [표현식]
            DELETE FROM 테이블명
            [WHERE 조건식] --> WHERE절 생략 시 모든 데이터가 삭제됨!
*/
DELETE FROM EMPLOYEE;
SELECT * FROM EMPLOYEE;
ROLLBACK;                   --> 마지막 COMMIT 시점으로 돌아감.

SELECT * FROM EMPLOYEE WHERE EMP_NAME ='김고은';
DELETE FROM EMPLOYEE
WHERE EMP_NAME = '김고은';

COMMIT;

-- DEPARTMENT 테이블의 DEPT_ID 값이 'D1' 데이터를 삭제해보자.
DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';   
rollback;
--> 제약조건(외래키)에 위배되어 삭제가 불가! = 'D1'을 사용중인 다른 테이블이 존재.

/*
    * TRUNCATE : 테이블의 전체 행을 삭제하는 구문
                 DELETE보다 수행 속도가 빠름
                 별도의 조건이 없음 (사용 불가)
                 ROLLBACK 불가
    [표현식]
                TRUNCATE TABLE 테이블명;
*/
SELECT * FROM EMP_SALARY;
TRUNCATE TABLE EMP_SALARY;

ROLLBACK;           -- ROLLBACK 을 수행해도 데이터가 돌아오지 않는다!





        
