/*
    
    * GROUP BY절
    : 그룹 기준을 제시할 수 있는 구문
      해당 그룹 기준별로 여러 그룹을 묶을 수 있음
      여러 개의 값들을 하나의 그룹으로 묶어서 처리하는 목적으로 사용
*/      

SELECT SUM(SALARY)
FROM EMPLOYEE;      -- 전체 사원을 하나의 그룹으로 묶어서 월급의 총합을 구함.

-- 부서 별 총 급여
SELECT DEPT_CODE 부서코드, SUM(SALARY) 총 급여
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 부서 별 사원 수
SELECT DEPT_CODE 부서코드, COUNT(*) "사원 수", SUM(SALARY) "총 급여"  --3
FROM EMPLOYEE               --1
GROUP BY DEPT_CODE;         --2        

SELECT DEPT_CODE 부서코드, COUNT(*) "사원 수", SUM(SALARY) "총 급여"  --3
FROM EMPLOYEE               --1
GROUP BY DEPT_CODE;         --2        
ORDER BY DEPT_CODE;         --4

-- 직급별 사원 수, 총 급여 조회
SELECT JOB_CODE 직급, COUNT(*) "사원 수", SUM(SALARY) "총 급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- 직급 별 사원 수, 보너스 받은 사원 수, 총 급여, 평균 급여, 최저 급여, 최고 급여 조회
-- (직급 기준 오름차순 정렬)

SELECT JOB_CODE 직급, COUNT(*) "사원 수", COUNT(BONUS) "보너스 받은 사원 수", SUM(SALARY) "총 급여",
        ROUND(AVG(SALARY)) "평균 급여", MIN(SALARY) "최저 급여", MAX(SALARY) "최고 급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- 남자 직원 수, 여자 직원 수  == (성별 별 직원 수)  // 직원 수 : COUNT(*)
-- | 성별 | 직원 수|
--   남      xxx
--   여      xxx
-- 성별 : SUBSTR(EMP_NO, 8, 1)
-- GROUP BY절에는 함수식 기술 가능!
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '남자', '2', '여자') "성별" , COUNT(*) "직원 수"   --3
FROM EMPLOYEE                       --1 
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '남자', '2', '여자');       --2

-- 부서 내 직급 별  부서코드, 직급코드, 사원 수, 총 급여 조회
--  GROUP BY절에 여러 컬럼을 기술할 수 있음
SELECT DEPT_CODE "부서코드", JOB_CODE "직급코드", COUNT(*) "사원 수", SUM(SALARY) "총 급여"
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;
--==============================================================================
/*
    * HAVING 절
    : 그룹에 대한 조건을 제시할 때 사용되는 구문
      주로, 그룹함수식을 사용하여 조건을 제시할 때 작성함.
*/    
-- 각 부서별 평균 급여 조회
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 각 부서별 평균급여가 300만원 이상인 부서만 조회
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
WHERE ROUND(AVG(SALARY)) >= 3000000;            -- WHERE절 사용 시 오류 발생!

SELECT DEPT_CODE, ROUND(AVG(SALARY))     --4
FROM EMPLOYEE                            --1
GROUP BY DEPT_CODE                       --2
HAVING ROUND(AVG(SALARY)) >= 3000000;    --3     

-- 직급별 직급코드, 총 급여 조회 (단, 직급별 총 합이 1,000만원 이상인 직급만 조회)
SELECT JOB_CODE 직급코드, SUM(SALARY) "총 급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;
-- 부서 별 보너스를 받은 사원이 없는 부서의 부서코드 조회
SELECT DEPT_CODE 부서코드, COUNT(BONUS) " 보너스 받은 사원 수"
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;    -- COUNT(BONUS) => BONUS 컬럼에 데이터가 있는 경우 개수. 0은 모든 데이터가 NULL.
--------------------------------------------------------------------------------
/*
    * SELECT문 실행 순서
    
    SELECT * | 조회할 컬럼 [AS 별칭] | 산술연산식 | 함수식   --5
    FROM 조회할 테이블                                    --1
    WHERE 조건식 (연산자들을 사용)                         --2
    GROUP BY 그룹으로 지정할 기준이 되는 컬럼 | 연산식       --3
    HAVING 조건식 (그룹함수들 가지고 기술)                  --4     
    ORDER BY 컬럼 | 별칭 | 컬럼_작성_순서_번호 [NULLS FIRST | NULLS LAST]   --6
*/    
--------------------------------------------------------------------------------
/*
    * 집계 함수 : 그룹 별 산출된 결과 값에 중간 집계를 계산해주는 함수


    ROLLUP, CUBE
    => GROUP BY 절에 기술함.
    
*/
-- 직급 별 총 급여 합
SELECT JOB_CODE "직급코드", SUM(SALARY) "총 급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- 마지막 행으로 전체 총 급여 합까지 같이 조회하고자 할 때
SELECT JOB_CODE "직급코드", SUM(SALARY) "총 급여"
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE)
ORDER BY JOB_CODE;

SELECT NVL2(JOB_CODE, JOB_CODE, '총합') "직급코드", SUM(SALARY) "총 급여"    
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE)           -- 결과가 CUBE 사용했을 때와 동일.
ORDER BY JOB_CODE;

-- 그룹 기준의 컬럼이 하나일 때는 CUBE, ROLLUP 의 차이점이 없음!
-- 두 차이점을 보려면, 그룹 기준의 컬럼이 두 개는 있어야 함.

-- ROLLUP(컬럼1, 컬럼2) : 컬럼1을 가지고 다시 중간집계를 하는 함수
SELECT DEPT_CODE "부서코드", JOB_CODE "직급코드", SUM(SALARY) "총 합"
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

-- CUBE(컬럼1, 컬럼2) : 컬럼1을 가지고 중간집계를 내고, 컬럼2를 가지고도 중간집계를 계산하는 함수. 
SELECT DEPT_CODE "부서코드", JOB_CODE "직급코드", SUM(SALARY) "총 합"
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;
--------------------------------------------------------------------------------
/*
    * 집합 연산자 == SET OPERATION
        : 여러 개의 쿼리문을 하나의 쿼리문으로 만드는 연산자
    
    - UNION: 합집합, OR ( 두 쿼리문의 수행한 결과 값을 더한다. )
    - INTERSECT: 교집합, AND  ( 두 쿼리문의 수행한 결과 값에 중복된 부분 )
    - UNION ALL : 합집합(UNION) + 교집합(INTERSECT) (중복되는 게 두 번 표현될 수 있다.)
    - MINUS : 차집합 (선행 결과 값에 후행 결과 값을 뺀 나머지)
*/
-- 1) UNION 
-- 부서 코드가 D5인 사원 또는 급여가 300만원 초과인 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY >3000000;

-- 부서 코드가 D5인 사원
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- 급여가 300만원 초과인 사원
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000;

-- UNION 사용 // 중복이 제거됨.
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000;

-- UNION ALL 사용 : 쿼리문 결과를 무조건 다 더한다! (중복된 데이터도)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY 
FROM EMPLOYEE
WHERE SALARY >3000000;

-- INTERSECT 사용
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000;

-- MINUS 사용
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000;
----------------------------------------------
-- 집합 연산자 사용 시 주의사항
-- 1) 두 쿼리문의 컬럼의 개수는 똑같아야 함.
-- 2) 컬럼 자리마다 동일한 타입으로 작성해야 함.    
-- 3) 정렬을 하고자 한다면, ORDER BY는 마지막에 작성해야 한다.
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000
ORDER BY EMP_ID;
--------------------------------------------

