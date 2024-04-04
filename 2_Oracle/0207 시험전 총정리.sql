-- 사용자 추가 ( 관리자 계정으로만 가능, 일반 사용자 계정으로는 추가 불가. )
-- 객체 생성 (추가) => DDL
-- CREATE USER 사용자명
CREATE USER "C##TEST01" IDENTIFIED BY "TEST01";
-- 권한 부여 => DCL
-- GRANT 부여할권한명 TO 사용자명;
GRANT CONNECT, RESOURCE TO "C##TEST01";
-- *----------------------------------------------------------------------------
-- DQL (SELECT) : 데이터 조회 시 사용되는 구문
/*
     [SELECT문 구조]
        (5) SELECT * (전체 컬럼) | 컬럼A, 컬럼B | 컬럼A 별칭A | 컬럼A AS 별칭A | 컬럼A AS "별칭 A"
        (1) FROM 테이블명 별칭T
        (2) WHERE 조건식
        (3) GROUP BY 컬럼명 | 함수식
        (4) HAVING 그룹에_대한_조건식
        (6) ORDER BY 컬럼명
*/        
-- * 어떤 컬럼에 해당하는 데이터 대하여 중복을 제거한 상태로 조회하고자 할 때 ? DISTINCT
SELECT DISTINCT(DEPT_CODE) "부서코드" FROM EMPLOYEE;
-- * 이메일 주소에 _앞에 3글자가 있는 사원 정보를 조회하고자 할 때 ? 대상컬럼.LIKE '조회할패턴'
--   - 와일드카드(키워드) : _ , %
--   - 와일드카드로 조회를 해야할 때는 ESCAPE '구분자'를 추가하여 조회해야 함.
SELECT * FROM EMPLOYEE WHERE EMAIL LIKE '___?_%' ESCAPE '?';
--  김씨 성을 가진 사원을 조회하고자 할 때  -> EMP_NAME LIKE '김%'
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '김%';
-- * 정렬 시 NULL 값들의 위치 => NULL 값들을 먼저 정렬되도록 할 때 ? NULLS FIRST
--                              NULL 값들을 뒤쪽에 배치할 때 ? NULLS LAST
SELECT * FROM EMPLOYEE ORDER BY BONUS NULLS FIRST;  -- 내림차순 시 기본 값 (DESC)
SELECT * FROM EMPLOYEE ORDER BY BONUS NULLS LAST;   -- 오름차순 시 기본 값 (ASC)
-- * 날짜 관련 함수들
--          [변환 시 사용하는 포맷]
--          - 연도 : YYYY, YY, RRRR, RR => 50년 기준으로 Y 포맷 사용 시 20XX, R 포맷 사용 시 19XX
--          - 월 : MM, MON, MONTH (X월), RM (로마 숫자)
--          - 일 : DD, DDD, D
--          - 요일 : DAY, DY
--          - 시 : HH, HH24
--          - 분 : MI
--          - 초 : SS
SELECT TO_CHAR(TO_DATE('90-02-14', 'RR-MM-DD'), 'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('90-02-14', 'YY-MM-DD'), 'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('90-02-14', 'YY-MM-DD'), 'MONTH') FROM DUAL;
SELECT TO_CHAR(TO_DATE('90-02-14', 'YY-MM-DD'), 'RM') FROM DUAL;
--      EXTRACT : 연도(YEAR), 월(MONTH), 일(DAY)에 해당하는 값을 추출할 때 사용하는 함수
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(DAY FROM SYSDATE) FROM DUAL;
--------------------------------------------------------------------------------
-- * 선택함수 : DECODE , CASE WHEN THEN
--  DECODE(비교대상컬럼|연산식, 비교값, 결과값1, 비교값, 결과값2, ..., 결과값N)
SELECT EMP_NAME 이름, DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') 성별
FROM EMPLOYEE;
--  CASE WHEN 조건식1 THEN 결과값1 WHEN 조건식2 THEN 결과값2 ... ELSE 결과값N END
SELECT EMP_NAME 이름, SALARY 급여,
        CASE WHEN SALARY >= 5000000 THEN '고급'
            WHEN SALARY >= 3000000 THEN '중급'
            WHEN SALARY IS NULL THEN '알수 없음'    -- NULL 체크는 IS NULL | IS NOT NULL
            ELSE '초급'
        END 등급
FROM EMPLOYEE;        
-- COUNT : 데이터(행)의 개수
-- 성별에 따른 사원 수 조회
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') 성별, COUNT(*) "사원 수"
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8,1);
--------------------------------------------------------------------------------
-- * JOIN : 여러 개의 테이블을 연결하여 조회할 때 사용
--  * 오라클 전용 구문
SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, E.JOB_CODE -- 조회 시 동일한 컬럼명이 있으면 별칭을 달아줘야 함.
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE DEPT_CODE = DEPT_ID
AND E.JOB_CODE = J.JOB_CODE;
--  * ANSI (표준) 구문  -- JOIN ~ ON (동일컬럼명, 다른컬럼명 모두 사용 가능), JOIN ~ USING (컬럼명이 동일할 때만 사용 가능)
SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, JOB_CODE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

-- 비등가조인 : 직원 별 월급에 해당하는 등급 조회
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE, SAL_GRADE
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;   -- SALARY >= MIN_SAL AND SALARY <= MAX_SAL
-- DEPT_CODE IN ('D3', 'D4', 'D5');         -- DEPT_CODE = 'D3' OR DEPT_CODE = 'D4' OR DEPT_CODE = 'D5'

SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON(SALARY BETWEEN MIN_SAL AND MAX_SAL);

-- 셀프(자체) 조인 : 어떤 직원의 사수 직원에 대한 정보 조회
SELECT E.EMP_ID 사번, E.EMP_NAME 직원명, M.EMP_NAME 사수명
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;

SELECT E.EMP_ID 사번, E.EMP_NAME 직원명, M.EMP_NAME 사수명
FROM EMPLOYEE E
JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID);
--------------------------------------------------------------------------------
-- * 서브쿼리 : SQL문 내에 또 다른 SQL문
-- ex) 하이유 직원과 같은 부서인 직원 목록 조회 (직원명, 부서코드(부서명), 직급코드(직급명))
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '하이유')
AND EMP_NAME <> '하이유';                    

SELECT EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '하이유');
--------------------------------------------------------------------------------
/*
        DDL (데이터 정의 언어)                     DML (데이터 조작 언어)
    ----------------------------------------------------------------------------
    추가 | CREATE {객체종류} 이름 ...              INSERT INTO 테이블명[(컬럼명,...)] VALUES (값,...)
    삭제 | DROP {객체종류} 이름...                 DELETE FROM 테이블명 [WHERE 조건식]
    수정 | ALTER {객체종류} 이름...                UPDATE 테이블명 SET 컬럼 = 값, 컬럼 = 값... [WHERE 조건식]
    ----------------------------------------------------------------------------
*/
/*
    * 컬럼에 대한 제약조건
            [1] 기본키 (PRIMARY KEY) : NOT NULL + UNIQUE 반영되어, NULL 허용X, 중복X
                                    : 테이블 내 행(데이터)에 대한 구분하는 용도로 사용됨.
            [2] 외래키 (FOREIGN KEY) : 다른 테이블에 있는 기본키 또는 어떤 값을 사용하는 컬럼
                                    : 데이터 삭제에 대한 옵션 설정됨 - ON DELETE [SET NULL |CASCADE |RESTRICTED(기본값)]
            [3] NOT NULL    : NULL값을 허용하지 않음.
            [4] UNIQUE      : 중복값을 허용하지 않음.
            [5] CHECK       : 조건에 해당하는 값만 넣도록 하는 제약. CHECK(조건식)
            
    * 컬럼에 기본값을 설정하는 옵션 : DEFAULT
        ...
        컬럼명 자료형 DEFAULT 기본값
        ...
*/
/*
        - DML (데이터 조작언어)
            * 데이터 추가 : INSERT
                INSERT INTO 테이블명[ (컬럼, 컬럼, ...) ]
                VALUES (값, 값, ...);
                ex) insert into member(emp_id, emp_name, dept_code) values (666, '홍길동', 'D3');
                
            * 데이터 수정 : UPDATE
                UPDATE 테이블명
                SET 변경할컬럼명 = 변경할 값,
                    변경할컬럼명 = 변경할 값,
                    ...
                [WHERE 조건식];
                
                ex) UPDATE EMPLOYEE SET DEPT_CODE = 'D6' WHERE EMP_NAME = '홍길홍';
                    SELECT * FROM EMPLOYEE WHERE EMP_NAME = '홍길홍'; -- 데이터 수정/삭제 시에는 SELECT로 먼저 내가 변경할 데이터가 맞는지 체크해보자!
                    
            * 데이터 삭제 : DELETE
                DELTETE FROM 테이블명 [WHERE 조건식];
                ex) DELETE FROM EMPLOYEE WHERE EMP_ID = 666;    -- 데이터 변경 시 조건식은 고유값으로 해주는 것이 좋다!
                ex) DELETE FROM EMPLOYEE WHERE EMP_ID = (SELECT EMP_ID FROM EMPLOYEE WHERE EMP_NAME = '홍길홍);
                
                (*) TRUNCATE : 테이블 전체 행을 삭제
                                DELETE보다 속도가 빠름.
                               ROLLBACK 되지 않음!
*/                
/*
    트랜잭션 : DML을 사용하여 데이터를 변경했을 때 해당 작업 목록을 보관하는 곳
              데이터베이스에 바로 적용하는 것이 아니라, COMMIT을 했을 때 반영됨.
              
              * COMMIT : 데이터 변경사항을 데이터베이스에 반영.
              * ROLLBACK : 데이터 변경사항을 취소. 마지막 COMMIT 상태까지 돌려놓음.
                    - DDL 이 실행된 후에는 ROLLBACK이 반영되지 않음. (DDL-CREATE/ALTER/DROP . DDL 실행하는 순간 COMMIT이 수행됨)
              * SAVEPOINT 포인트명 : 트랜잭션 상에 변경사항을 임시저장. ROLLBACK을 통해 해당 위치로 돌아갈 수 있음.
                    - ROLLBACK TO {포인트명};
*/
/*
    * 데이터베이스 객체 (시퀀스, 뷰, 트리거)
        - 시퀀스 : 자동으로 번호를 발생시켜 주는 객체 -> 기본키(PK)로 많이 사용.
            [생성]
            CREATE SEQUENCE 시퀀스_이름
                [START WITH 시작값] -- 기본값:1
                [INCREMENT BY 증가값] -- 기본값:1
                [MAXVALUE 최대값]  -- 기본값:99999999.....
                [MINVALUE 최소값]  -- 기본값:1
                [NOCYCLE(default) | CYCLE]  -- 순환여부
                [NOCACHE | CACHE 바이트크기]; -- 캐시메모리 사용여부 / 기본값: CACHE 20
            
            [사용]
            시퀀스_이름.CURRVAL : 현재 시퀀스 값 (마지막 NEXTVAL 가 실행된 값) --가장 처음에는 사용 불가. 최소 1번은 NEXTVAL해주어야 함.
            시퀀스_이름.NEXTVAL : 현재 시퀀스 값 + 증가값
            
        - 뷰 (VIEW) : SELECT문을 저장하는 객체
                        가상 테이블
                        실제 값(데이터)을 저장하지는 않음.
                        DML 사용이 가능한 경우가 있다. (안되는 조건이 있음. GROUP BY, JOIN 등등..)
                [생성]
                    CREATE [OR REPLACE] VIEW 뷰_이름   -- OR REPLACE : 같은 이름의 뷰가 있으면 갱신 
                        AS SQL문(서브쿼리); --SQL문을 뷰가 저장하게 됨.
                        
        - 트리거 (TRIGGER) : 테이블에 데이터에 대한 변경사항 (DML)이 있을 때
                            자동으로 매번 또는 한번 실행할 작업을 미리 정의해 놓는 것.
                            
            [생성]
                CREATE [OR REPLACE] TRIGGER 트리거_이름
                BEFORE|AFTER INSERT|UPDATE|DELETE ON 테이블명
                [FOR EACH ROW]      -- 매번 실행
                -- PL/SQL문
                [DECLARE]            -- 선언부: 변수, 상수를 선언 및 초기화
                    변수명 자료형;
                    상수명 CONSTANT 자료형;
                    
                BEGIN                   -- 실행부
                        -- 이벤트(DML에 의해 변경사항) 발생 시 처리할 내용
                        -- 조건문, 반복문, SQL문 실행
                        
                [EXCEPTION]                     -- 예외처리부   
                    WHEN 예외명 THEN 예외처리할내용;
                    WHEN OTHERS THEN 예외처리내용;
                END;
                /
*/
/*
    * PL/SQL : 프로시져 언어.
               오라클에서의 절차적 언어
               
    - 조건문
            [1] IF문
                - 단일 IF문 : IF 조건식 THEN 수행할내용 END IF; -- 조건식이 참(TRUE)일 때만 처리
                - IF ~ ELSE문 : IF 조건식 THEN 수행할내용(T) ELSE 수행할_내용(F) END IF;
                - 조건식이 여러개 필요할 때
                    : IF 조건식1 THEN 수행할내용(T_1) ELSIF 조건식2 THEN 수행할내용(T_2) ... [ELSE 수행할내용(F)] END IF;
            [2] CASE WHEN THEN문
                CASE 비교대상
                    WHEN 비교값1 THEN 처리할_내용(1)
                    WHEN 비교값2 THEN 처리할_내용(2)
                    ...
                    ELSE 처리할_내용(F)
                END;
                
    - 반복문
            [1] LOOP문
                    LOOP 
                        반복할 작업
                        * 반복을 빠져나올 조건문
                    END LOOP;    
            [2] FOR LOOP문
                    FOR 변수 IN [REVERSE] 시작값..끝값
                    LOOP
                        반복할 작업
                    END LOOP;
            [3] WHILE LOOP문
                    WHILE 반복문이_수행될_조건
                    LOOP
                        반복할 작업
                    END LOOP;    
*/







