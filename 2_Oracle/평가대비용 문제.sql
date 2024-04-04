/*
            �򰡴��� ����
*/

-- 1)



/* 
�������� �����ϰ�(����) : ROWNUM�� �������� ���� ����� ��� ���� ���ϴ� ���� ��Ŀ� 
���� ������ ROWNUM�� ��ȸ���� �ʴ´�. ���������� �ȿ��� ORDER BY�� ���� ���� ������ ������ �� �Ŀ�, 
���������� �ۿ��� ROWNUM���� ���� ��ȸ�� ���ָ� ���� ���ϴ� ��� ���� ���̴�.
*/

/* �����ڵ�(��ġ) : 
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
SELECT DEPT_CODE "�μ��ڵ�", SUM(SALARY) "����", FLOOR(AVG(SALARY)) AS "���", COUNT(*) AS �ο���
FROM EMPLOYEE
WHERE SALARY > 2700000
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE ASC;

/* ������(����) : ���������� �μ��� ��ձ޿��� 270������ �ʰ��ϴ� �μ��鿡 ���� ������ ��ȸ�϶�� �Ͽ�����,
���õ� ���������� WHERE���� ������ ���� ��ձ޿��� �ƴ� SALARY(�޿�)�� 270������ �ʰ��ϴ� ����� ������ �ְ� �����Ƿ�
�������� ���ϴ� ����� ���� �� ����. ���� GROUP BY ���� ���� �÷��� ���� ������ �ַ��� ��� WHERE�� �ƴ� 
GROUP BY [�÷���] ���� HAVING�� ���� ������ �ο��� �־�� �Ѵ�.
*/

/* �����ڵ�(��ġ) :
SELECT DEPT_CODE "�μ��ڵ�", SUM(SALARY) "����", FLOOR(AVG(SALARY)) AS "���", COUNT(*) AS �ο���
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) > 2700000
ORDER BY DEPT_CODE ASC;
*/
SELECT DEPT_CODE "�μ��ڵ�", SUM(SALARY) "����", FLOOR(AVG(SALARY)) AS "���", COUNT(*) AS �ο���
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) > 2700000
ORDER BY DEPT_CODE ASC;

