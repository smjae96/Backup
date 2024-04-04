/*
        * JOIN
        : 두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용하는 구문
            조회 결과는 하나의 결과물(RESULT SET)로 나옴
            
        : 관계형 데이터베이스에서는 최소한의 데이터를 각각의 테이블에 담고 있음
            (중복 저장을 최소화하기 위해서 최대한 쪼개서 관리함)
            
        => 관계형 데이터베이스에서 SQL문을 이용한 테이블간 "관계"를 맺는 방법
        (무작정 다 조회를 하는 게 아니라 각 테이블간 연결 고리로서의 데이터를 매칭시켜서 조회해야 함 )
        
        - JOIN은 크게 "오라클 전용 구문" 과 "ANSI 구문" (ANSI == 미국국립표준협회)
        
        [JOIN 용어 정리]
        
                오라클 전용 구문                           ANSI 구문
        ---------------------------------------------------------------------------------------
                등가조인(EQUAL JOIN)         |          내부조인 (INNER JOIN) => JOIN USING/ON
        ---------------------------------------------------------------------------------------
                포괄조인                     |       왼쪽 외부 조인 (LEFT OUTER JOIN)                 
              ( LEFT OUTER )                |       오른쪽 외부 조인 (RIGHT OUTER JOIN)
              ( RIGHT OUTER )               |       전체 외부 조인 (FULL OUTER JOIN)
       -----------------------------------------------------------------------------------------
                자체조인 (SELF JOIN)         |          JOIN ON
            비등가 조인 (NON EQUAL JOIN)     |    
       ------------------------------------------------------------------------------------------     
*/      
-- 전체 사원들의 사번, 사원명, 부서코드, 부서명을 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, hire_date
FROM EMPLOYEE
order by hire_date desc;



SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;

-- 전체 사원들의 사번, 사원명, 직급코드, 직급명을 조회
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

SELECT JOB_CODE, JOB_NAME
FROM JOB;
/*
    1. 등가조인 (EQUAL JOIN) / 내부조인 (INNER JOIN)
        : 연결시키는 컬럼의 값이 일치하는 행들만 조회(=> 일치하지 않는 행은 제외)
*/    


-- 오라클 전용 구문: 등가조인(EQUAL JOIN)
-- FROM절에 조회하고자 하는 테이블들을 나열(,)
-- WHERE절에 연결고리역할을 하는 컬럼에 대한 조건을 제시

-- 1) 연결할 두 컬럼명이 다른 경우 (EMPLOYEE: DEPT_CODE / DEPARTMENT: DEPT_ID)
-- 사번, 사원명, 부서코드, 부서명 조회 (부서 배치를 받지 못한 직원들은 조회되지 않음!)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;
-- => null, D3, D4, D7 데이터는 조회되지 않은 것을 확인할 수 있음. => 일치하는 값이 없기 때문에

-- 2) 연결할 두 컬럼명이 같을 경우 (EMPLOYEE: JOB_CODE / JOB: JOB_CODE)
-- 사번, 사원명, 직급코드, 직급명 조회
SELECT EMP_ID, EMP_NAME, EMPLOYEE.JOB_CODE, JOB_NAME
FROM EMPLOYEE , JOB 
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;
-- * 별칭을 사용
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J      --1
WHERE E.JOB_CODE = J.JOB_CODE;

--================================
-- ANSI 구문
-- FROM절에 기준이 되는 테이블 하나 기술
-- JOIN절에 조인하고자 하는 테이블 기술 + 연결고리역할 컬럼에 대한 부분 기술
-- *JOIN USING / JOIN ON

-- 1) 연결 고리 역할을 하는 "컬럼명 다른 경우" => JOIN ON 구문을 사용
-- 사번, 사원명, 부서코드, 부서명 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

-- 2) 연결 고리 역할을 하는 "컬럼명 같은 경우" => JOIN USING 구문 (JOIN ON도 가능)
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE);

SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);   -- JOIN USING : 연결하는 컬럼명 같을 때만 사용 가능.

-- 추가적인 조건 제시도 가능.
-- 직급이 "대리"인 직원들 조회
-- ANSI 구문
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리';

-- ORACLE 전용 구문
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
AND JOB_NAME = '대리';
--------------------------------------------------------------------------------
-- 문제 ------------------------------------------------------------------------
--  (Oracle 전용 구문, ANSI 구문)

-- 1) 부서가 "인사관리부"인 사원들의 사번, 이름, 보너스 조회

--      * ORACLE 전용 구문
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID           -- 연결 고리 역할 컬럼
AND DEPT_TITLE = '인사관리부';       -- 추가 조건 (인사관리부)    
--      * ANSI 구문
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '인사관리부';

-- 2) 부서 테이블(DEPARTMENT)과 LOCATION 테이블을 참고하여 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;

--      * ORACLE 구문
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID, LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;

--      * ANSI 구문
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID, LOCAL_NAME
FROM DEPARTMENT     --기준이 되는 테이블 : 부서(DEPARTMENT)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);

-- 3) 보너스를 받은 사원들의 사번, 사원명, 보너스, 부서명 조회

--      * ORACLE 구문
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND BONUS IS NOT NULL;
--      * ANSI 구문
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL; 

-- 4) 부서가 "총무부"가 아닌 사원들의 사원명, 급여 조회
--      * ORACLE 구문
SELECT EMP_NAME, SALARY
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND DEPT_TITLE <> '총무부';    -- != ^= <> : 다름을 체크할 때 사용하는 연산자

--      * ANSI 구문
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE <> '총무부';
--------------------------------------------------------------------------------
/*
    2. 포괄 조인 / 외부 조인 (OUTER JOIN)
        : 두 테이블을 JOIN할 때 일치하지 않는 행도 포함하여 조회
        단, LEFT | RIGHT를 지정해줘야 함. (기준이 되는 테이블을 지정.)
*/
-- 등가(내부) 조인으로 조회.
-- 사원명, 부서명, 급여, 연봉 조회 (21명 조회) => 2명이 제외됨! (부서배치를 못받은 직원)
SELECT EMP_NAME 사원명, DEPT_TITLE 부서명, SALARY 급여, SALARY*12 연봉
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID);

SELECT COUNT(*) FROM EMPLOYEE; -- 총 직원 수 : 23명

-- [1] LEFT [OUTER] JOIN : 두 테이블 중 왼편에 있는 테이블을 기준으로 JOIN
-- 오라클 구문
-- 부서배치를 받지 못한 직원도 조회할 때
SELECT EMP_NAME 사원명, DEPT_TITLE 부서명, SALARY 급여, SALARY*12 연봉
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);   -- 동일한 값이 없을 때 왼쪽(EMPLOYEE)에 있는 데이터를 포함하여 조회함.

-- ANSI 구문
SELECT EMP_NAME 사원명, DEPT_TITLE 부서명, SALARY 급여, SALARY*12 연봉
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID);

-- [2] RIGHT [OUTER] JOIN : 두 테이블 중 오른편에 있는(기술한) 테이블을 기준으로 JOIN
SELECT COUNT(*) FROM DEPARTMENT;
-- 오라클 구문
-- 부서 내에 직원이 없는 경우도 조회할 때
SELECT EMP_NAME 사원명, DEPT_TITLE 부서명, SALARY 급여, SALARY*12 연봉
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- ANSI 구문
SELECT EMP_NAME 사원명, DEPT_TITLE 부서명, SALARY 급여, SALARY*12 연봉
FROM DEPARTMENT
LEFT JOIN EMPLOYEE ON(DEPT_CODE=DEPT_ID);

SELECT EMP_NAME 사원명, DEPT_TITLE 부서명, SALARY 급여, SALARY*12 연봉
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID);

-- [3] FULL (OUTER) JOIN : 두 테이블이 가진 모든 행을 조회 (오라클 전용 구문X, ANSI 구문만 가능!)
-- ANSI 구문
SELECT EMP_NAME 사원명, DEPT_TITLE 부서명, SALARY 급여, SALARY*12 연봉
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID);
--------------------------------------------------------------------------------
/*
        3. 비등가 조인 (NON EQUAL JOIN)
            : 연결 고리 역할을 하는 컬럼에 대한 조건식에 '='를 사용하지 않음.
                ANSI 구문에서는 ON만 사용.
*/
-- 사원명, 급여, 급여레벨 조회
SELECT * FROM EMPLOYEE;     -- 급여

SELECT * FROM SAL_GRADE;    -- 급여레벨    
-- 오라클 구문
SELECT EMP_NAME 사원명, SALARY 급여, SAL_LEVEL 급여레벨
FROM EMPLOYEE, SAL_GRADE
--WHERE SALARY>=MIN_SAL AND SALARY<=MAX_SAL;
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

-- ANSI 구문 : JOIN ~ ON 사용
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
--JOIN SAL_GRADE ON(SALARY>=MIN_SAL AND SALARY<=MAX_SAL);
JOIN SAL_GRADE ON(SALARY BETWEEN MIN_SAL AND MAX_SAL);
-- 직원의 급여 정보가 급여 레벨 범위에 속하는 지를 조건으로 제시.
--------------------------------------------------------------------------------
/*
    4. 자체 조인 (SELF JOIN)
        : 같은 테이블을 다시 한 번 조인하는 경우
*/    
-- 전체 사원의 사번, 사원명, 부서코드
--              사수 사번, 사수 사원명, 사수 부서코드 조회
-- 자체 조인 목적: 사수의 직원 정보를 조회
-- 오라클 전용 구문
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE, 
            E.MANAGER_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E, EMPLOYEE M         -- E: 직원용으로 조회하기 위한 EMPLOYEE
                                    -- M: 사수직원 정보 조회하기 위한 EMPLOYEE
WHERE E.MANAGER_ID = M.EMP_ID;     
--  WHERE E.MANAGER_ID = M.EMP_ID(+);   -- 사수가 없는 직원도 조회한다면, OUTER JOIN 적용

-- ANSI 구문
SELECT E.EMP_ID "직원 번호", E.EMP_NAME "직원명", E.DEPT_CODE "직원 부서코드", E.MANAGER_ID "사수 번호", M.EMP_NAME "사수명", M.DEPT_CODE "사수 부서코드"
FROM EMPLOYEE E
JOIN EMPLOYEE M ON(E.MANAGER_ID = M.EMP_ID);
-- LEFT JOIN EMPLOYEE M ON(E.MANAGER_ID = M.EMP_ID);    -- 사수가 없는 직원 조회 시
--------------------------------------------------------------------------------
/*
    5. 다중 JOIN : 2개 이상의 테이블을 JOIN.
*/
-- 사번, 사원명, 부서명, 직급명 조회
SELECT * FROM JOB;
-- ORACLE 구문
SELECT E.EMP_ID, E.EMP_NAME, DEPT_TITLE, J.JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE DEPT_CODE = DEPT_ID   -- EMPLOYEE 테이블과 DEPARTMENT 테이블 연결
        AND E.JOB_CODE = J.JOB_CODE;        -- EMPLOYEE 테이블과 JOB 테이블 연결

-- ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

-- 사번, 사원명, 부서명, 지역명 조회
SELECT * FROM location;
SELECT * FROM DEPARTMENT;
-- 오라클 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE;

-- ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID)
JOIN LOCATION ON(LOCATION_ID=LOCAL_CODE);

--------------------------------------------------------------------------------
-----------------------------실습 문제-------------------------------------------
SELECT * FROM NATIONAL;
SELECT * FROM LOCATION;
-- 1. 사번, 사원명, 부서명, 지역명, 국가명 조회
--     (EMPLOYEE, DEPARTMENT, LOCATION, NATIONAL)
--  ORACLE 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION L, NATIONAL N
WHERE DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE
AND L.NATIONAL_CODE = N.NATIONAL_CODE;
--  ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) -- EMPLOYEE - DEPARTMENT 연결
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)  -- DEPARTMENT - LOACATION 연결
JOIN NATIONAL USING(NATIONAL_CODE); -- LOCATION - NATIONAL 연결

--  2. 사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여 등급 조회
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
SELECT * FROM SAL_GRADE;
--      (EMPLOYEE, DEPARTMENT, JOB, LOCATION, NATIONAL, SAL_GRADE)
--      ORACLE 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE E, DEPARTMENT, JOB J, LOCATION L, NATIONAL N, SAL_GRADE
WHERE DEPT_CODE = DEPT_ID           -- EMPLOYEE - DEPARTMENT 연결
AND E.JOB_CODE = J.JOB_CODE         -- EMPLOYEE - JOB 연결
AND LOCATION_ID = LOCAL_CODE        -- DEPARTMENT - LOCATION 연결
AND L.NATIONAL_CODE = N.NATIONAL_CODE   -- LOCATION - NATIONAL 연결
AND SALARY BETWEEN MIN_SAL AND MAX_SAL;    -- EMPLOYEE - SEL_GRADE 연결

--      ANSI 구문

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
JOIN SAL_GRADE ON(SALARY BETWEEN MIN_SAL AND MAX_SAL);


SELECT E.EMP_NAME 사원명, E.DEPT_CODE 부서명, M.EMP_NAME 사수명, M.DEPT_CODE 사수부서명
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID(+);

SELECT E.EMP_NAME 사원명, E.DEPT_CODE 부서명, M.EMP_NAME 사수명, M.DEPT_CODE 사수부서명
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE M ON(E.MANAGER_ID = M.EMP_ID);

