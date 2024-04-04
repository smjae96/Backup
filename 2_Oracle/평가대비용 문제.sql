/*
            평가대비용 문제
*/

-- 1)



/* 
문제점을 서술하고(원인) : ROWNUM을 서브쿼리 없이 사용할 경우 내가 원하는 정렬 방식에 
따른 순서로 ROWNUM이 조회되지 않는다. 서브쿼리문 안에서 ORDER BY를 통해 연봉 순으로 정렬을 한 후에, 
서브쿼리문 밖에서 ROWNUM으로 순위 조회를 해주면 내가 원하는 대로 나올 것이다.
*/

/* 수정코드(조치) : 
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
        FROM EMPLOYEE
        ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;        
*/
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
        FROM EMPLOYEE
        ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;  


--2)
SELECT DEPT_CODE "부서코드", SUM(SALARY) "총합", FLOOR(AVG(SALARY)) AS "평균", COUNT(*) AS 인원수
FROM EMPLOYEE
WHERE SALARY > 2700000
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE ASC;

/* 문제점(원인) : 문제에서는 부서별 평균급여가 270만원을 초과하는 부서들에 대한 정보를 조회하라고 하였으나,
제시된 쿼리문에서 WHERE절의 조건을 보면 평균급여가 아닌 SALARY(급여)가 270만원을 초과하는 경우의 조건을 주고 있으므로
문제에서 원하는 결과를 얻을 수 없다. 또한 GROUP BY 절에 들어가는 컬럼에 대한 조건을 주려는 경우 WHERE가 아닌 
GROUP BY [컬럼명] 이후 HAVING을 통해 조건을 부여해 주어야 한다.
*/

/* 수정코드(조치) :
SELECT DEPT_CODE "부서코드", SUM(SALARY) "총합", FLOOR(AVG(SALARY)) AS "평균", COUNT(*) AS 인원수
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) > 2700000
ORDER BY DEPT_CODE ASC;
*/
SELECT DEPT_CODE "부서코드", SUM(SALARY) "총합", FLOOR(AVG(SALARY)) AS "평균", COUNT(*) AS 인원수
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) > 2700000
ORDER BY DEPT_CODE ASC;

