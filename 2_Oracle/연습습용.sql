
-- <���� �� ��������>
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

-- ������ ����� ���� �μ������� ���, �����, ��ȭ��ȣ, �Ի���, �μ��� ��ȸ
-- >ORACLE ���� ����
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND EMP_NAME <> '������'
AND DEPT_CODE = (SELECT DEPT_CODE
                FROM EMPLOYEE
                WHERE EMP_NAME = '������');
                
-- > ANSI ����
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������')
AND EMP_NAME <> '������';            



-- <���� �� ��������>

-- IN �������� : ���� ���� ��� �� �߿��� �� ���� ��ġ�ϴ� ���� �ִٸ�..

-- >ANY �������� : ���� ���� ��� �� �߿��� "�� ����" Ŭ ��� ( ���� ���� ����� �߿��� ���� 
--                ���� ������ Ŭ ��� )

-- <ANY �������� : ���� ���� ��� �� �߿��� "�� ����" ���� ��� ( ���� ���� ����� �߿��� ����
--                ū ������ ���� ��� )

--      �񱳴�� > ANY (��1, ��2, ��3)
--      �񱳴�� > ��1 OR �񱳴�� > ��2 OR �񱳴�� > ��3

-- >ALL �������� : ���� ���� "���" ��� ���麸�� Ŭ ���

-- <ALL �������� : ���� ���� "���" ��� ���麸�� ���� ���

--      �񱳴�� > ALL (��1, ��2, ��3)
--      �񱳴�� > ��1 AND �񱳴�� > ��2 AND �񱳴�� > ��3

-- 1) ����� �Ǵ� ������ ����� ���� ������ ������� ���, �����, �����ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE          -- �� ��ġ���� =�� �ƴ϶� IN�� ����Ѵ�!
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN ('�����', '������'));

-- 2) �븮 �����ӿ��� �ұ��ϰ� ���� ���� �޿��� �� �ּ� �޿����� ���� �޴� ���� ��ȸ ( ���, �̸�, ���޸�, �޿�)
--  ���(J7) => �븮 => ���� => ���� => ����...
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

-- >> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
AND JOB_NAME = '�븮'
AND SALARY > ANY (SELECT SALARY
                FROM EMPLOYEE E, JOB J
                WHERE E.JOB_CODE = J.JOB_CODE
                AND JOB_NAME = '����');
                
-- >> ANSI ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '�븮'
AND SALARY > ANY(SELECT SALARY
                FROM EMPLOYEE
                JOIN JOB USING(JOB_CODE)
                WHERE JOB_NAME = '����')
ORDER BY EMP_ID;                
                
-- >> �� ������ ������ ���������ε� ����!
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '�븮'
AND SALARY > (SELECT MIN(SALARY)
                FROM EMPLOYEE
                JOIN JOB USING(JOB_CODE)
                WHERE JOB_NAME = '����')
ORDER BY EMP_ID;   

-- 3) ���� �����ӿ��� �ұ��ϰ� ���������� ������� ��� �޿����ٵ� �� ���� �޴� ������� ���, �̸�, ���޸�, �޿� ��ȸ
-- >> ����Ŭ ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
AND JOB_NAME = '����'
AND SALARY > ANY(SELECT SALARY
                FROM EMPLOYEE E, JOB J
                WHERE E.JOB_CODE = J.JOB_CODE
                AND JOB_NAME = '����');
                
-- >> ANSI ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����'
AND SALARY > ANY (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '����');
                    
-- >> ������ ����������
SELECT EMP_ID, EMP_NAME, JOB
