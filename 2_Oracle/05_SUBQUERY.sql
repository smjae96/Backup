/*
    * �������� (SUBQUERY)
    : �ϳ��� SQL�� �ȿ� ���Ե� �� �ٸ� SELECT��
      ���� SQL���� ���� ������ �ϴ� ������
      
      * SQL�� = SELECT�� = ������
*/
-- ���ö ����� ���� �μ��� ����� ��ȸ
-- * ���ö ��� ���� ��ȸ
SELECT * FROM EMPLOYEE WHERE EMP_NAME = '���ö';

-- * �μ��ڵ尡 'D9'�� ��� ���� ��ȸ
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

-- * �� ������ �����غ���.
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE                     -- 'D9' : ���ö ����� �μ��ڵ�
                    FROM EMPLOYEE                   
                    WHERE EMP_NAME = '���ö'
                    );
                    
-- �� ������ ��� �޿����� �� ���� �޿��� �޴� ���� ��ȸ
-- * �� ���� ��� �޿� ��ȸ
SELECT ROUND(AVG(SALARY)) FROM EMPLOYEE;

-- * ��ȸ�� ��� �޿����� ���� �޿��� �޴� ���� ��ȸ
SELECT * FROM EMPLOYEE WHERE SALARY > 3047663;

-- * �� �������� �����غ���. 
SELECT *
FROM EMPLOYEE
WHERE SALARY > ( -- SALARY > ��ձ޿�
                SELECT ROUND(AVG(SALARY))
                FROM EMPLOYEE
                );
--------------------------------------------------------------------------------
/*

    * ���������� ����
        : ���������� ������ ������� ���� ��� �����Ŀ� ���� �з�
        
    - ������ �������� : ���������� ��ȸ ����� 1�� + ��, �� : 1��
    - ������ �������� : ���������� ��ȸ ����� ���� ��(��) + ���� 1��
    - ���߿� �������� : ���������� ��ȸ ����� �� ���̰�, �÷��� ���� ���� ��
    - ������ ���߿� �������� : ���������� ��ȸ ����� ���� ���̰�, ���� ��(�÷��� ���� ��)�� ��
    
    >> �������� ������ ���� �տ� ���Ǵ� �����ڰ� �޶���.
    
*/  
/*
    - ������ �������� : �������� ��� ���� 1���� ��� (1�� 1��)
        + �Ϲ� �񱳿����� ��� ����
            : = != > <= ....
*/
-- ��� �޿����� ���� ������ �̸�, ����ó, �޿� ��ȸ
-- * ��� �޿�
SELECT ROUND(AVG(SALARY)) FROM EMPLOYEE;
-- * ����
SELECT EMP_NAME "�̸�", PHONE "����ó", SALARY "�޿�"
FROM EMPLOYEE
WHERE SALARY < (SELECT ROUND(AVG(SALARY)) 
                FROM EMPLOYEE
                );

-- ���� �޿��� �޴� ���� ���� ��ȸ (�̸�, ����ó, �޿�)
--  * ���� �޿�
SELECT MIN(SALARY) FROM EMPLOYEE;
-- * ����
SELECT EMP_NAME �̸�, PHONE ����ó, SALARY �޿�
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                FROM EMPLOYEE
                );

-- ���ö ����� �޿����� ���� �޴� ����� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö'
                );
-- ���ö ����� �޿����� ���� �޴� ����� ���, �̸�, �μ���, �޿� ��ȸ
-- ORACLE ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö'
                );
-- ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö'
                );
-- GROUP BY ����
-- * �μ� �� �޿� ���� ���� ū �μ��� �μ��ڵ�, �޿� �� ��ȸ
--  + �μ� �� �޿� �� �߿��� ���� ū �� �ϳ��� ��ȸ
SELECT MAX(SUM(SALARY))         -- 17,700,000
FROM EMPLOYEE 
GROUP BY DEPT_CODE;

-- +�μ� �� �޿� ���� 17,700,000�� �μ��� �μ��ڵ� ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = 17700000;

-- + �����غ���.
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
    * ������ ��������
    : �������� ������ ����� ���� �� (���� 1��) - N�� 1���� ���
    
    IN (��������) : ���� ���� ��� �� �ϳ��� ��ġ�ϸ� ��ȸ
    
    > ANY (��������) : ���� ���� ��� �� �ϳ��� ũ�� ��ȸ
    < ANY (��������) : ���� ���� ��� �� �ϳ��� ������ ��ȸ
    
        �� ��� > ANY ((�������� ��� �� - ��1, ��2, ��3))
        -> �� ��� > ��1 OR �� ��� > ��2 OR �� ��� > ��3
        
        
    > ALL (��������) : ���� ���� ����麸�� ��� Ŭ ���
    < ALL (��������) : ���� ���� ����麸�� ��� ���� ���
        
        �� ��� > ALL ((�������� ��� �� - ��1, ��2, ��3))
        -> �� ��� > ��1 AND �� ��� > ��2 AND �� ��� > ��3
*/        
-- ����� �Ǵ� ������ ����� ���� ������ ������� ���, �̸�, �����ڵ�, �޿� ��ȸ
--  * ����� �Ǵ� ������ ����� �����ڵ� ��ȸ
SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME IN ('�����', '������');

-- * ����
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN ('�����', '������')
                    );
-- �븮 ������ ����� �� ���� ������ �ּ� �޿����� ���� �޴� ������� ���,�̸�,���޸�,�޿� 
-- *����
SELECT EMP_ID ���, EMP_NAME �̸�, JOB_NAME ���޸�, SALARY �޿�
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '�븮'
AND SALARY > ANY (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '����'
                    );
--------------------------------------------------------------------------------

/*
        * ���߿� �������� : ��� ���� �� ���̰�, ���� ���� �÷�(��)�� ��� -- 1�� N��
*/
-- ������ ����� ���� �μ��ڵ�, ���� �����ڵ带 ���� ����� ��ȸ
--  * ������ ����� �μ��ڵ�, �����ڵ� ��ȸ
SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE EMP_NAME ='������';

-- * ������ �������� ��� ��
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������')
AND JOB_CODE = (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������');                   
                    
-- * ���߿� �������� ���
SELECT EMP_ID "���", EMP_NAME "�̸�", HIRE_DATE "�Ի���"
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '������'
                                )    
AND EMP_NAME <> '������';         -- ��, ������ ����� ����
--------------------------------------------------------------------------------
/*
    * ������ ���߿� �������� : N�� N�� ��� 
*/    
-- �� ���޺� �ּ� �޿��� �޴� ���
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
-- �� �μ��� �ְ� �޿��� �޴� �������� ���, �����, �μ��ڵ�, �޿� ��ȸ
-- * �μ��� �ְ� �޿� ��ȸ
SELECT DEPT_CODE, MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--  * ����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY)
                                FROM EMPLOYEE
                                GROUP BY DEPT_CODE
                                );
--------------------------------------------------------------------------------
/*
    * �ζ��� ��
    - FROM ���� ���������� �ۼ��� ��
    - ���������� ������ ����� �ϳ��� ���̺�� ���
    
    - ROWNUM : ����Ŭ���� �������ִ� �÷�, ��ȸ�� ������� 1���� ������ �ο����ִ� �÷�
    
*/    
-- ������� ���, �̸�, ���ʽ� ���� ����, �μ��ڵ� ��ȸ
-- ��, ���ʽ� ���� ������ NULL�� �Ǹ� �ȵȴ�.
-- ��, ���ʽ� ���� ������ 3000���� �̻��� ����� ��ȸ�Ѵ�.
SELECT ROWNUM, EMP_ID "���", EMP_NAME "�̸�", SALARY*(1+NVL(BONUS,0))*12 "���ʽ� ���� ����", DEPT_CODE "�μ��ڵ�"
FROM EMPLOYEE
WHERE SALARY*(1+NVL(BONUS,0))*12 >=30000000
ORDER BY 3 DESC;

-- =>> TOP-N �м� : ���� N���� ��ȸ
SELECT ROWNUM, ���, �̸�, ����, �μ��ڵ� 
FROM (  -- ���� ���� �������� ������ ����� �ϳ��� ���̺�� ���
    SELECT EMP_ID "���", EMP_NAME "�̸�", SALARY*(1+NVL(BONUS,0))*12 "����", DEPT_CODE "�μ��ڵ�"
    FROM EMPLOYEE
    WHERE SALARY*(1+NVL(BONUS,0))*12 >=30000000
    ORDER BY 3 DESC
    )
WHERE ROWNUM <= 5;    

-- ���� �ֱٿ� �Ի��� ��� 5�� ��ȸ
--  *�Ի��� �������� ����
--  * ROWNUM �÷� ����Ͽ� 5�� �߷�����.
SELECT *
FROM (
    SELECT EMP_ID ���, EMP_NAME �̸�, HIRE_DATE �Ի���
    FROM EMPLOYEE
    ORDER BY 3 DESC
    )
WHERE ROWNUM <= 5;    
--------------------------------------------------------------------------------

/*
    * ������ �ű�� �Լ� (WINDOW FUNCTION)
        - RANK() OVER(���� ����) : ������ ���� ������ ����� �� ������ŭ �ǳʶٰ� ���� ���
        ex) ���� 3�� 2��, �� ���� ������ 5
        - DENSE_RANK() OVER(���� ����) : ������ ���� ���Ŀ� ������ 1�� �����Ͽ� ���� ���
        ex) ���� 3�� 2��, �� ���� ������ 4
        
        + SELECT�������� ��� ����!
*/
-- �޿��� ���� ������� ������ �Űܼ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE;

-- �޿� TOP-5 ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE
WHERE ���� <= 5;              -- ��Ī => WHERE������ ��� �Ұ�..

-- ��������
SELECT *
FROM ( 
        -- ���� ������ ��� "����"��� ��Ī�� �ϳ��� �÷����� ���� ������������ ����� �� ����.
        SELECT EMP_ID, EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC nulls last) "����"
        FROM EMPLOYEE
)
WHERE ���� <=5;


SELECT TO_CHAR(TO_DATE('24/01/29'), 'YYYY-MM-DD') FROM DUAL;

SELECT TO_CHAR(TO_DATE('240105'), 'YYYY"��" FMMM"��" DD"��"') FROM DUAL;
-- > FM : �ڿ� ���� �������� 0�� ��� ���ܽ�����! ��, �����ٰ��� FM�� �ٿ��� �Ͽ����� 0�� ��������.


     
                                
    

                
               
