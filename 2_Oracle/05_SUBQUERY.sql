/*
    * 서브쿼리 (SUBQUERY)
    : 하나의 SQL문 안에 포함된 또 다른 SELECT문
      메인 SQL문을 보조 역할을 하는 쿼리문
      
      * SQL문 = SELECT문 = 쿼리문
*/
-- 노옹철 사원과 같은 부서인 사원들 조회
-- * 노옹철 사원 정보 조회
SELECT * FROM EMPLOYEE WHERE EMP_NAME = '노옹철';

-- * 부서코드가 'D9'인 사원 정보 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

-- * 두 쿼리를 조합해보자.
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE                     -- 'D9' : 노옹철 사원의 부서코드
                    FROM EMPLOYEE                   
                    WHERE EMP_NAME = '노옹철'
                    );
                    
-- 전 직원의 평균 급여보다 더 많은 급여를 받는 직원 조회
-- * 전 직원 평균 급여 조회
SELECT ROUND(AVG(SALARY)) FROM EMPLOYEE;

-- * 조회한 평균 급여보다 많은 급여를 받는 직원 조회
SELECT * FROM EMPLOYEE WHERE SALARY > 3047663;

-- * 두 쿼리문을 조합해보자. 
SELECT *
FROM EMPLOYEE
WHERE SALARY > ( -- SALARY > 평균급여
                SELECT ROUND(AVG(SALARY))
                FROM EMPLOYEE
                );
--------------------------------------------------------------------------------
/*

    * 서브쿼리의 구분
        : 서브쿼리를 수행한 결과값이 몇행 몇열로 나오냐에 따라 분류
        
    - 단일행 서브쿼리 : 서브쿼리의 조회 결과가 1개 + 행, 열 : 1개
    - 다중행 서브쿼리 : 서브쿼리의 조회 결과가 여러 개(행) + 열은 1개
    - 다중열 서브쿼리 : 서브쿼리의 조회 결과가 한 행이고, 컬럼이 여러 개일 때
    - 다중행 다중열 서브쿼리 : 서브쿼리의 조회 결과가 여러 행이고, 여러 열(컬럼이 여러 개)일 때
    
    >> 서브쿼리 종류에 따라 앞에 사용되는 연산자가 달라짐.
    
*/  
/*
    - 단일행 서브쿼리 : 서브쿼리 결과 값이 1개인 경우 (1행 1열)
        + 일반 비교연산자 사용 가능
            : = != > <= ....
*/
-- 평균 급여보다 적은 직원의 이름, 연락처, 급여 조회
-- * 평균 급여
SELECT ROUND(AVG(SALARY)) FROM EMPLOYEE;
-- * 적용
SELECT EMP_NAME "이름", PHONE "연락처", SALARY "급여"
FROM EMPLOYEE
WHERE SALARY < (SELECT ROUND(AVG(SALARY)) 
                FROM EMPLOYEE
                );

-- 최저 급여를 받는 직원 정보 조회 (이름, 연락처, 급여)
--  * 최저 급여
SELECT MIN(SALARY) FROM EMPLOYEE;
-- * 적용
SELECT EMP_NAME 이름, PHONE 연락처, SALARY 급여
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                FROM EMPLOYEE
                );

-- 노옹철 사원의 급여보다 많이 받는 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철'
                );
-- 노옹철 사원의 급여보다 많이 받는 사원의 사번, 이름, 부서명, 급여 조회
-- ORACLE 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철'
                );
-- ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철'
                );
-- GROUP BY 복습
-- * 부서 별 급여 합이 가장 큰 부서의 부서코드, 급여 합 조회
--  + 부서 별 급여 합 중에서 가장 큰 값 하나만 조회
SELECT MAX(SUM(SALARY))         -- 17,700,000
FROM EMPLOYEE 
GROUP BY DEPT_CODE;

-- +부서 별 급여 합이 17,700,000인 부서의 부서코드 조회
SELECT DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = 17700000;

-- + 조합해보자.
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (
                        SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                        GROUP BY DEPT_CODE
                        );
--------------------------------------------------------------------------------
/*
    * 다중행 서브쿼리
    : 서브쿼리 수행한 결과가 여러 행 (열은 1개) - N행 1열의 결과
    
    IN (서브쿼리) : 서브 쿼리 결과 중 하나라도 일치하면 조회
    
    > ANY (서브쿼리) : 서브 쿼리 결과 중 하나라도 크면 조회
    < ANY (서브쿼리) : 서브 쿼리 결과 중 하나라도 작으면 조회
    
        비교 대상 > ANY ((서브쿼리 결과 값 - 값1, 값2, 값3))
        -> 비교 대상 > 값1 OR 비교 대상 > 값2 OR 비교 대상 > 값3
        
        
    > ALL (서브쿼리) : 서브 쿼리 결과들보다 모두 클 경우
    < ALL (서브쿼리) : 서브 쿼리 결과들보다 모두 작을 경우
        
        비교 대상 > ALL ((서브쿼리 결과 값 - 값1, 값2, 값3))
        -> 비교 대상 > 값1 AND 비교 대상 > 값2 AND 비교 대상 > 값3
*/        
-- 유재식 또는 윤은해 사원과 같은 직급인 사원들의 사번, 이름, 직급코드, 급여 조회
--  * 유재식 또는 윤은해 사원의 직급코드 조회
SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME IN ('유재식', '윤은해');

-- * 적용
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN ('유재식', '윤은해')
                    );
-- 대리 직급인 사원들 중 과장 직급의 최소 급여보다 많이 받는 사원들의 사번,이름,직급명,급여 
-- *적용
SELECT EMP_ID 사번, EMP_NAME 이름, JOB_NAME 직급명, SALARY 급여
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
AND SALARY > ANY (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '과장'
                    );
--------------------------------------------------------------------------------

/*
        * 다중열 서브쿼리 : 결과 값이 한 행이고, 여러 개의 컬럼(열)인 경우 -- 1행 N열
*/
-- 하이유 사원과 같은 부서코드, 같은 직급코드를 가진 사원을 조회
--  * 하이유 사원의 부서코드, 직급코드 조회
SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE EMP_NAME ='하이유';

-- * 단일행 서브쿼리 사용 시
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '하이유')
AND JOB_CODE = (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '하이유');                   
                    
-- * 다중열 서브쿼리 사용
SELECT EMP_ID "사번", EMP_NAME "이름", HIRE_DATE "입사일"
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '하이유'
                                )    
AND EMP_NAME <> '하이유';         -- 단, 하이유 사원은 제외
--------------------------------------------------------------------------------
/*
    * 다중행 다중열 서브쿼리 : N행 N열 결과 
*/    
-- 각 직급별 최소 급여를 받는 사원
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;
/*
    J1	8000000
    J2	3700000
    J4	1550000
    J3	3400000
    J7	1380000
    J5	2200000
    J6	2000000
*/

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (   -- ( (J1,8000000), (J2, 3700000), (J3, 3400000), ...)
                                SELECT JOB_CODE, MIN(SALARY)
                                FROM EMPLOYEE
                                GROUP BY JOB_CODE
                                );
                
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE;
-- 각 부서별 최고 급여를 받는 직원들의 사번, 사원명, 부서코드, 급여 조회
-- * 부서별 최고 급여 조회
SELECT DEPT_CODE, MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--  * 적용
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY)
                                FROM EMPLOYEE
                                GROUP BY DEPT_CODE
                                );
--------------------------------------------------------------------------------
/*
    * 인라인 뷰
    - FROM 절에 서브쿼리를 작성한 것
    - 서브쿼리를 수행한 결과를 하나의 테이블로 사용
    
    - ROWNUM : 오라클에서 제공해주는 컬럼, 조회된 순서대로 1부터 순번을 부여해주는 컬럼
    
*/    
-- 사원들의 사번, 이름, 보너스 포함 연봉, 부서코드 조회
-- 단, 보너스 포함 연봉은 NULL이 되면 안된다.
-- 단, 보너스 포함 연봉이 3000만원 이상인 사원만 조회한다.
SELECT ROWNUM, EMP_ID "사번", EMP_NAME "이름", SALARY*(1+NVL(BONUS,0))*12 "보너스 포함 연봉", DEPT_CODE "부서코드"
FROM EMPLOYEE
WHERE SALARY*(1+NVL(BONUS,0))*12 >=30000000
ORDER BY 3 DESC;

-- =>> TOP-N 분석 : 상위 N개를 조회
SELECT ROWNUM, 사번, 이름, 연봉, 부서코드 
FROM (  -- 연봉 기준 내림차순 정렬한 결과를 하나의 테이블로 사용
    SELECT EMP_ID "사번", EMP_NAME "이름", SALARY*(1+NVL(BONUS,0))*12 "연봉", DEPT_CODE "부서코드"
    FROM EMPLOYEE
    WHERE SALARY*(1+NVL(BONUS,0))*12 >=30000000
    ORDER BY 3 DESC
    )
WHERE ROWNUM <= 5;    

-- 가장 최근에 입사한 사원 5명 조회
--  *입사일 내림차순 정렬
--  * ROWNUM 컬럼 사용하여 5명만 추려내기.
SELECT *
FROM (
    SELECT EMP_ID 사번, EMP_NAME 이름, HIRE_DATE 입사일
    FROM EMPLOYEE
    ORDER BY 3 DESC
    )
WHERE ROWNUM <= 5;    
--------------------------------------------------------------------------------

/*
    * 순위를 매기는 함수 (WINDOW FUNCTION)
        - RANK() OVER(정렬 기준) : 동일한 순위 이후의 등수를 그 개수만큼 건너뛰고 순위 계산
        ex) 공동 3위 2건, 그 다음 순위는 5
        - DENSE_RANK() OVER(정렬 기준) : 동일한 순위 이후에 무조건 1씩 증가하여 순위 계산
        ex) 공동 3위 2건, 그 다음 순위는 4
        
        + SELECT절에서만 사용 가능!
*/
-- 급여가 높은 순서대로 순위를 매겨서 조회
SELECT EMP_ID, EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE;

-- 급여 TOP-5 조회
SELECT EMP_ID, EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE
WHERE 순위 <= 5;              -- 별칭 => WHERE절에서 사용 불가..

-- 메인쿼리
SELECT *
FROM ( 
        -- 서브 쿼리의 결과 "순위"라는 별칭을 하나의 컬럼으로 보고 메인쿼리에서 사용할 수 있음.
        SELECT EMP_ID, EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC nulls last) "순위"
        FROM EMPLOYEE
)
WHERE 순위 <=5;


SELECT TO_CHAR(TO_DATE('24/01/29'), 'YYYY-MM-DD') FROM DUAL;

SELECT TO_CHAR(TO_DATE('240105'), 'YYYY"년" FMMM"월" DD"일"') FROM DUAL;
-- > FM : 뒤에 오는 데이터의 0을 모두 제외시켜줌! 즉, 월에다가만 FM을 붙여도 일에서도 0을 제거해줌.


     
                                
    

                
               
