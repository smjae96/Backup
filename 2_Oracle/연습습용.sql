
-- <단일 행 서브쿼리>
 MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = 17700000;

SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                        GROUP BY DEPT_CODE);

-- 전지연 사원과 같은 부서원들의 사번, 사원명, 전화번호, 입사일, 부서명 조회
-- >ORACLE 전용 구문
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND EMP_NAME <> '전지연'
AND DEPT_CODE = (SELECT DEPT_CODE
                FROM EMPLOYEE
                WHERE EMP_NAME = '전지연');
                
-- > ANSI 구문
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '전지연')
AND EMP_NAME <> '전지연';            



-- <다중 행 서브쿼리>

-- IN 서브쿼리 : 여러 개의 결과 값 중에서 한 개라도 일치하는 값이 있다면..

-- >ANY 서브쿼리 : 여러 개의 결과 값 중에서 "한 개라도" 클 경우 ( 여러 개의 결과값 중에서 가장 
--                작은 값보다 클 경우 )

-- <ANY 서브쿼리 : 여러 개의 결과 값 중에서 "한 개라도" 작을 경우 ( 여러 개의 결과값 중에서 가장
--                큰 값보다 작을 경우 )

--      비교대상 > ANY (값1, 값2, 값3)
--      비교대상 > 값1 OR 비교대상 > 값2 OR 비교대상 > 값3

-- >ALL 서브쿼리 : 여러 개의 "모든" 결과 값들보다 클 경우

-- <ALL 서브쿼리 : 여러 개의 "모든" 결과 값들보다 작을 경우

--      비교대상 > ALL (값1, 값2, 값3)
--      비교대상 > 값1 AND 비교대상 > 값2 AND 비교대상 > 값3

-- 1) 유재식 또는 윤은해 사원과 같은 직급인 사원들의 사번, 사원명, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE          -- 이 위치에서 =이 아니라 IN을 사용한다!
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN ('유재식', '윤은해'));

-- 2) 대리 직급임에도 불구하고 과장 직급 급여들 중 최소 급여보다 많이 받는 직원 조회 ( 사번, 이름, 직급명, 급여)
--  사원(J7) => 대리 => 과장 => 차장 => 부장...
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

-- >> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
AND JOB_NAME = '대리'
AND SALARY > ANY (SELECT SALARY
                FROM EMPLOYEE E, JOB J
                WHERE E.JOB_CODE = J.JOB_CODE
                AND JOB_NAME = '과장');
                
-- >> ANSI 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
AND SALARY > ANY(SELECT SALARY
                FROM EMPLOYEE
                JOIN JOB USING(JOB_CODE)
                WHERE JOB_NAME = '과장')
ORDER BY EMP_ID;                
                
-- >> 위 쿼리를 단일행 서브쿼리로도 가능!
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
AND SALARY > (SELECT MIN(SALARY)
                FROM EMPLOYEE
                JOIN JOB USING(JOB_CODE)
                WHERE JOB_NAME = '과장')
ORDER BY EMP_ID;   

-- 3) 과장 직급임에도 불구하고 차장직급인 사원들의 모든 급여보다도 더 많이 받는 사원들의 사번, 이름, 직급명, 급여 조회
-- >> 오라클 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
AND JOB_NAME = '과장'
AND SALARY > ANY(SELECT SALARY
                FROM EMPLOYEE E, JOB J
                WHERE E.JOB_CODE = J.JOB_CODE
                AND JOB_NAME = '차장');
                
-- >> ANSI 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
AND SALARY > ANY (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '차장');
                    
-- >> 단일행 서브쿼리로
SELECT EMP_ID, EMP_NAME, JOB
