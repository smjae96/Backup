/*
        <SELECT> : 데이터 조회 시 사용하는 문법
        
        SELECT 가지고 올 정보 FROM 테이블
        SELECT 컬럼1, 컬럼2, 컬럼3 FROM 테이블
        SELECT * FROM 테이블   // 테이블에 있는 모든 정보(데이터) 조회
*/        

-- EMPLOYEE : 직원(사원)에 대한 데이터 묶음(그룹)

-- 모든 사원의 정보를 조회
SELECT * FROM EMPLOYEE;

-- 모든 사원의 이름(EMP_NAME), 주민번호(EMP_NO), 핸드폰번호(PHONE) 조회
SELECT EMP_NAME, EMP_NO, PHONE FROM EMPLOYEE;
-------------------------------------------------------------------------
-- JOB  : 직급에 대한 데이터 묶음

-- 모든 직급의 정보를 조회
SELECT * FROM JOB;

-- 모든 직급의 직급명(JOB_NAME) 컬럼만 조회
SELECT JOB_NAME FROM JOB;
---------------------------------------------------------------------------
-- DEPARTMENT : 부서에 대한 데이터 묶음

-- 모든 부서의 정보를 조회
SELECT * FROM DEPARTMENT;

-- 모든 부서의 부서코드(DEPT_ID), 부서명(DEPT_TITLE) 조회
SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT;
---------------------------------------------------------------------------
-- 직원의 사원명, 이메일, 연락처, 입사일, 급여 조회
SELECT * FROM EMPLOYEE;

SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY FROM EMPLOYEE ORDER BY EMP_NAME ASC;

/*
    컬럼 값을 통한 산술연산
    : SELECT절 컬럼명 작성부분에 산술연산을 할 수 있음.
*/
-- 직원 테이블의 사원명, 사원의 급여, 사원의 연봉(급여 * 12) 조회
SELECT EMP_NAME, SALARY, SALARY*12 FROM EMPLOYEE;

-- 사원의 연봉 정보(보너스 포함 연봉) 조회
-- 조회 정보 : 사원명, 급여, 보너스, 연봉, 보너스 포함 연봉

SELECT EMP_NAME, SALARY, BONUS, SALARY*(1+nvl(BONUS,0))*12 FROM EMPLOYEE;

-- 사원명, 입사일, 근무일수를 조회
--     * 조회 시 날짜를 표시하는 상수 : SYSDATE (년/월/일/시/분/초)
--      DATE 타입의 값 - DATE 타입의 값의 결과 값을 일로 표시
--      소수를 정수로 : 버림- TRUNC(소수) / 올림- CEIL(소수) / 반올림- ROUND(소수)
--      COLUMN의 이름을 내가 원하는대로 바꿔서 출력시키고 싶을 때 
--      해당 COLUMN 뒤에 "이름" 작성.
--      출력되는 값의 뒤에 내가 원하는 내용 추가로 작성 원한는 경우 ||'내용' 작성.
select * from employee;

select emp_name"직원명", hire_date"고용일", sysdate"현재날짜", 
trunc(sysdate - hire_date)||'일' "근속일자" from employee;

-- 현재 날짜 및 시간 조회
--  *DUAL : 오라클에서 제공해주는 가상 데이터 테이블
SELECT SYSDATE 현재날짜 FROM DUAL;

/* 
    <컬럼명에 별칭 지정하기>
    : 산술 연산 시 컬럼명이 지저분해 보이는데, 이 때 컬럼명을 별칭을 부여하여 깔끔하게
      표시할 수 있음.
      
      [표현법]
        * 컬럼명 별칭
        * 컬럼명 as 별칭
        * 컬럼명 "별칭"
        * 컬럼명 as "별칭"
        
        - 별칭에 띄어쓰기 또는 특수문자 포함될 때 큰따옴표("")로 묶어서 표시함.
*/      
-- 직원 정보 조회 : 사원명, 급여, 보너스, 연봉, 보너스 포함 연봉
select emp_name 사원명, salary 급여, NVL(BONUS,0) 보너스, salary*12 연봉
        , SALARY*(1+nvl(BONUS,0))*12 "보너스 포함 연봉" FROM employee;
        
/* 
    <리터럴> : 값 자체
    - 임의로 지정한 문자열('')
    - 조회된 RESULT SET(결과창)의 모든 행에 반복적으로 출력
*/
-- 직원 정보 조회 : 사번, 사원명, 급여
SELECT EMP_ID 사번, EMP_NAME 사원명, SALARY 급여,'원' AS "단위" FROM EMPLOYEE;

/* 
    <연결 연산자> : ||
    - 여러 컬럼 값들을 하나의 컬럼처럼 연결할 수 있음
*/    
SELECT EMP_ID 사번, EMP_NAME 사원명, SALARY||'원' AS "급여" FROM EMPLOYEE; 

-- 사번, 이름, 급여를 하나의 컬럼처럼 조회
SELECT EMP_ID || ' ' ||EMP_NAME || ' '|| SALARY||'원' "직원정보" FROM EMPLOYEE;

-- XXX의 월급은 XXX원 입니다. 출력되도록 조회.
SELECT EMP_NAME||'의 월급은 '|| SALARY ||'원 입니다.' AS "직원 별 급여정보" 
FROM EMPLOYEE;

/*
    <중복 제거> : DISTINCT 컬럼명
    - 컬럼에 표시되는 값들을 한번씩만 조회하고자 할 때 사용
*/

-- 직원 정보에서 직급코드를 중복 제거 조회
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- 직원 정보에서 부서코드를 중복 제거 조회
SELECT DISTINCT NVL(DEPT_CODE, '부서 없음') "부서코드" FROM EMPLOYEE;

-- 직급코드, 부서코드 둘 다 중복 제거 가능할까?
/*
-- DISTINCT 는 한 쿼리문 안에서 여러 개 사용 불가 : 에러 발생.
SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE FROM EMPLOYEE;
*/
SELECT DISTINCT JOB_CODE, NVL(DEPT_CODE, '부서 없음') FROM EMPLOYEE;
-- 위처럼 사용 시 (JOB_CODE, DEPT_CODE)를 한 쌍으로 묶어서 중복을 제거한 결과를 볼 수 있음.
-- JOB_CODE, DEPT_CODE가 둘 다 같은 경우 중복 제거됨.

-----------------------------------------------------------------------------------------------

 --   <WHERE 절>
 --   : 조회하고자 하는 테이블로부터 특정 조건에 만족하는 데이터만을 조회할 때 사용
 --   - 조건식에 다양한 연산자 사용 가능.
    
--    [표현법]
 --               SELECT 컬럼, 컬럼2, 컬럼연산
--                FROM 테이블명
  --              WHERE 조건식;
                
 --   * 연산자
 --     - 대소 비교 : > < >= <=
 --     - 동등 비교 : = ( 양쪽이 같은 지? )
--                 != ^= <> ( 양쪽이 다른 지? )

-- 직원 테이블에서 부서코드가 'D9'인 사원들만 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

-- 직원 테이블에서 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME 사원명, SALARY 급여, DEPT_CODE 부서코드 FROM EMPLOYEE 
WHERE DEPT_CODE = 'D1';

-- 직원 테이블에서 부서코드가 'D1'이 아닌 사원들의 사번, 사원명, 부서코드 조회
SELECT EMP_ID 사번, EMP_NAME 사원명, DEPT_CODE 부서코드 FROM EMPLOYEE
WHERE DEPT_CODE <> 'D1';

-- 월급이 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME 사원명, DEPT_CODE 부서코드, SALARY 급여 FROM EMPLOYEE
WHERE SALARY >= 4000000;

----------------------(실습 문제)--------------------------------
-- 1) 급여가 300만원 이상인 사원들의 사원명, 급여, 입사일, 연봉 조회 (별칭 사용)
SELECT EMP_NAME 사원명, SALARY 급여, HIRE_DATE 입사일, SALARY*12 연봉,
            SALARY*(1+NVL(BONUS,0))*12  "보너스 포함 연봉"
FROM EMPLOYEE
WHERE SALARY >= 3000000;
-- 2) 연봉이 5000만원 이상인 사원들의 사원명, 급여, 연봉, 부서코드 조회
SELECT EMP_NAME 사원명, SALARY*(1+NVL(BONUS,0)) 급여, SALARY*(1+NVL(BONUS,0))*12 연봉, 
DEPT_CODE 부서코드 FROM EMPLOYEE WHERE SALARY*(1+NVL(BONUS,0))*12 >= 50000000;
-- 3) 직급코드가 'J3'이 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회
SELECT EMP_ID 사번, EMP_NAME 사원명, JOB_CODE 직급코드, ENT_YN 퇴사여부 
FROM EMPLOYEE WHERE JOB_CODE <> 'J3';
-- 4) 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
--      * 범위 : 350만원 ~ 600만원 => AND
SELECT EMP_NAME 사원명, EMP_ID 사번, SALARY 급여
FROM EMPLOYEE WHERE SALARY >= 3500000 AND SALARY <=6000000;
--====================================================================
/*
    <AND, OR 연산자>
    : 조건을 여러 개 사용할 때 연결해주는 역할
    
    (표현법)
    * 조건A AND 조건B : 조건A와 조건B가 모두 참(true)일 때 데이터를 조회해옴.
        -> 그리고, 범위,
    * 조건A OR 조건B  : 조건A 또는 조건B가 참일 때 데이터를 조회해옴.
        -> 또는, 
        
    <BETWEEN AND>
    : 조건식에 사용하는 구문
      몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 사용하는 연산자 (이상, 이하만 가능)
      
      [표현법]
            
            비교대상 컬럼 BETWEEN 시작값(하한값) AND 끝값(상한값)
            
    <NOT> : 부정 연산자        
    - 컬럼명 앞 또는 BETWEEN 앞에 사용
*/    
-- 급여가 350만원 이상 600만원 이하인 모든 사원 사원명, 사번, 급여 조회 (BETWEEN AND)
SELECT EMP_NAME 사원명, EMP_ID 사번, SALARY||'원' 급여 FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- 급여가 350만원 미만 600만원 초과인 모든 사원 사원명, 사번, 급여 조회
SELECT EMP_NAME 사원명, EMP_ID 사번, SALARY||'원' 급여 FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 3500000 AND 6000000; -- NOT (부정 연산자) 사용한 방법 (BETWEEN AND를 부정)
-- NOT : 부정 연산자, 컬럼명 앞 또는 BETWEEN 앞에 사용


-- 입사일이 '90/01/01' ~ '01/01/01' 인 사원을 전체 조회
SELECT * FROM EMPLOYEE
--WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01'; -- BETWEEN AND 사용한 방법
WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01'; -- AND 연산자를 사용한 방법
-- DATE 타입도 비교 연산이 가능하다.
-- ========================================================================================
/*
    <LIKE> 
    : 비교하고자 하는 컬럼값이 내가 제시한 특정 패턴에 만족할 경우 조회
    
    [표현법]
            비교대상컬럼 LIKE '특정 패턴';
            
    * 와일드카드 ('%', '_')
    (1) '%' : 포함 문자 검색 (0글자 이상 전부 조회)
        ex) 비교대상컬럼 LIKE '문자%'; => 비교대상컬럼값 중에서 해당문자로 시작하는 값들만 조회
            비교대상컬럼 LIKE '%문자'; => 비교대상컬럼값 중에서 해당문자로 끝나는 값들만 조회
            비교대상컬럼 LIKE '%문자%'; => 비교대상컬럼값 중에서 해당문자가 포함된 값을 조회
            
    (2) '_' : 1글자를 대체해서 검색 
        ex) 비교대상컬럼 LIKE '_문자'; => 비교대상컬럼값 중에서 문자 앞에 아무글자나 한글자가 있는 값을 조회
            비교대상컬럼 LIKE '___문자'; => 비교대상컬럼값 중에서 문자 앞에 아무글자나 세글자가 있는 값을 조회
            비교대상컬럼 LIKE '_문자_'; => 비교대상컬럼값 중에서 문자 앞, 뒤에 아무글자나 한글자씩 있는 값을 조회
*/
-- 사원들 중에서 전씨 성을 가진 사원들의 사원명, 급여, 입사일 조회
SELECT EMP_NAME 사원명, SALARY 급여, HIRE_DATE 입사일 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- 사원 이름 중간에 '하'가 포함된 사원들의 사원명, 사번, 연락처 조회
SELECT EMP_NAME 사원명, EMP_ID 사번, PHONE 연락처
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_하_';

-- 사원 이름에 '하'가 포함된 사원의 사원명, 사번, 연락처 조회
SELECT EMP_NAME 사원명, EMP_ID 사번, PHONE 연락처
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- 이메일 중 _ 앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
SELECT EMP_ID 사번, EMP_NAME 이름, EMAIL 이메일
FROM EMPLOYEE
WHERE EMAIL LIKE '___?_%' ESCAPE '?';
-- 와일드카드와 일반문자의 구분이 필요할 때, 나만의 탈출법을 제시하여 처리할 수 있음.
-- * ESCAPE OPTION : OPTION 부분에 내가 사용할 문자를 지정
-- ======================실습문제==========================
-- 1) 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME 사원명, HIRE_DATE 입사일
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';
-- 2) 연락처 처음 3자리가 010이 아닌 사원들의 사원명, 연락처 조회
SELECT EMP_NAME 사원명, PHONE 연락처
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%'; 
-- 3) 이름에 '하'가 포함되어 있고, 급여가 240만원 이상인 사원들의 사원명, 급여 조회
SELECT EMP_NAME 사원명, SALARY 급여
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;
-- 4) 부서테이블에서 해외영업으로 시작하는 부서의 부서코드, 부서명 조회
SELECT DEPT_ID 부서코드, DEPT_TITLE 부서명
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%';

-- =======================================================================

/*

    <IN> : WHERE절에서 비교대상 컬럼값이 내가 제시한 목록 중에 일치하는 값이 있는 경우 조회
    
    [표현법]
            비교대상컬럼 IN ('값1', '값2', ...)
            
*/
-- 부서코드가 D6이거나 D8이거나 D5인 부서원들의 이름, 부서코드, 급여를 조회
SELECT EMP_NAME 이름, DEPT_CODE 부서코드, SALARY 급여
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6','D8','D5') ORDER BY 2 ASC;

-- =================================================================================
/*
    < IS NULL & IS NOT NULL >
    : 컬럼값에 NULL이 있을 경우 NULL 값을 비교하기 위해 사용
*/
-- [JAVA] str == null / str = null (x) / [Oracle] str is null (o)
-- 보너스를 받지않은 (BONUS IS NULL) 사원들의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, NVL('0'||TO_CHAR(BONUS), '보너스 없음')
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 보너스 받은 사원들의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 사수가 없는 직원의 사원명, 사수 사번, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- 부서를 배치받지 않은 직원의 사원 이름, 급여, 보너스 조회
SELECT EMP_NAME, SALARY, NVL(CONCAT('0', TO_CHAR(BONUS)), '보너스 없음') 보너스
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL;

-- ===========================================================================
/*
    연산자 우선순위: 여러 개의 연산자가 수행될 때 우선순위에 따라 순서대로 수행되는 방식
    
    1. 산술 연산자 : + - * /
    2. 연결 연산자 : ||
    3. 비교 연산자 : < > <= >= = != ^= <>
    4. IS NULL / LIKE / IN
    5. BETWEEN 시작 AND 끝
    6. NOT
    7. AND
    8. OR
*/    
-- 직급코드가 J7이거나 J2인 사원 중에 급여가 200만원 이상인 사원들의 모든 데이터 조회
SELECT * 
FROM EMPLOYEE
--WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') AND SALARY >= 2000000;
WHERE JOB_CODE IN('J7', 'J2') AND SALARY>= 2000000;
--============================ 실습 문제 =============================================
-- 1. 사수가 없고 부서 배치도 받지 않은 사원의 사원명, 사번, 부서코드 조회
SELECT EMP_NAME, EMP_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 2. 연봉(보너스 미포함)이 3천만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE SALARY*12 >= 30000000 AND BONUS IS NULL;

-- 3. 입사일이 '95/01/01' 이후이고 부서배치를 받지 않은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE> '95/01/01' AND DEPT_CODE IS NULL;

-- 4. 급여가 200만원 이상, 500만원 이하인 사원 중 입사일이 '01/01/01' 이후이고
--      보너스를 받지 않은 사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 5000000 AND HIRE_DATE >= '01/01/01' AND BONUS IS NULL;

-- 5. 보너스 포함된 연봉이 NULL이 아니고 이름에 '하'가 포함된 사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회
SELECT EMP_ID, EMP_NAME, SALARY, NVL(SALARY*12*(1+BONUS), SALARY*12)||'원' "보너스 포함 연봉"
FROM EMPLOYEE
WHERE SALARY*12*(1+BONUS) IS NOT NULL AND EMP_NAME LIKE '%하%';

-- =================================================================================
/*
        <ORDER BY> : 정렬 관련된 구문
                     SELECT문 가장 마지막 줄에 작성.
                     실행 순서 또한 마지막에 실행.
                     
        [표현법]
                SELECT 컬럼1, 컬럼2 별칭, ...
                FROM 테이블
                WHERE 조건식
                ORDER BY 정렬할컬럼 | 별칭 | 컬럼순번 [ASC | DESC] [NULLS FIRST | NULLS LAST]
                
                 * ASC : 오름차순   (기본 값으로 생략 가능)
                 * DESC : 내림차순  
                 
                 * NULLS FIRST : 정렬하려 하는 데이터 값들 중 NULL인 값을 해당 데이터 맨 앞에 위치
                                 DESC (내림차순) 기본 값
                 * NULLS LAST  : 정렬하려 하는 데이터 값들 중 NULL인 값을 해당 데이터 맨 뒤에 위치
                                 ASC  (오룸차순) 기본 값
                                 
                ex) ORDER BY NAME; -- ASC(오름차순), NULLS LAST 이 적용된 상태!                     
*/        
-- 직원 테이블에서 전체 데이터 조회
SELECT *
FROM EMPLOYEE
--ORDER BY EMP_NAME; -- 직원명으로 오름차순 정렬 (ASC 생략!)
--ORDER BY EMP_NAME DESC; -- 직원명으로 내림차순 정렬
--ORDER BY BONUS ASC NULLS FIRST; -- 보너스 기준으로 NULL인 항목이 맨 앞에 배치되도록 오름차순 정렬
-- ORDER BY BONUS; -- 보너스 기준으로 NULL인 항목을 맨 뒤에 배치되도록 오름차순 정렬
ORDER BY BONUS DESC, SALARY ASC; -- 보너스 기준으로 내림차순 정렬하고, 급여 기준으로 오름차순 정렬

-- 전 사원의 사원명, 연봉 조회 (연봉 별 내림차순 정렬)
SELECT EMP_NAME 사원명, SALARY*12 연봉 
FROM EMPLOYEE
-- ORDER BY SALARY*12 DESC;
-- ORDER BY 연봉 DESC;
ORDER BY 2 DESC;   -- SELECT절에 나열한 순번으로 사용 가능. 오라클은 1부터 시작.








-- << 개인연습>> --
SELECT EMP_ID 사원번호, EMP_NAME 사원명, FLOOR(SYSDATE-HIRE_DATE) 근속일 , ENT_YN 퇴사여부
FROM EMPLOYEE WHERE TRUNC(SYSDATE-HIRE_DATE)>10000 AND ent_yn <> 'Y' ORDER BY TRUNC(SYSDATE-HIRE_DATE) DESC;

SELECT * FROM EMPLOYEE;

SELECT * FROM DEPARTMENT;

SELECT EMP_NAME 사원명, SALARY*(1+BONUS) 급여, SALARY*(1+BONUS)*12 연봉, 
DEPT_CODE 부서코드 FROM EMPLOYEE ORDER BY SALARY*(1+BONUS) DESC NULLS LAST;


SELECT EMAIL, INSTR(EMAIL, '@' , -1) , INSTR (EMAIL, '_' , 1, 1)
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8) , 14, '*') 주민번호뒷자리숨김
FROM EMPLOYEE;

SELECT EMP_NAME, EMAIL, REPLACE(EMAIL, 'KH.or.kr' , 'gmail.com') "변경email"
from employee;