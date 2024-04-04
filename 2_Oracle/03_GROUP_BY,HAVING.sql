/*
    
    * GROUP BY��
    : �׷� ������ ������ �� �ִ� ����
      �ش� �׷� ���غ��� ���� �׷��� ���� �� ����
      ���� ���� ������ �ϳ��� �׷����� ��� ó���ϴ� �������� ���
*/      

SELECT SUM(SALARY)
FROM EMPLOYEE;      -- ��ü ����� �ϳ��� �׷����� ��� ������ ������ ����.

-- �μ� �� �� �޿�
SELECT DEPT_CODE �μ��ڵ�, SUM(SALARY) �� �޿�
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �μ� �� ��� ��
SELECT DEPT_CODE �μ��ڵ�, COUNT(*) "��� ��", SUM(SALARY) "�� �޿�"  --3
FROM EMPLOYEE               --1
GROUP BY DEPT_CODE;         --2        

SELECT DEPT_CODE �μ��ڵ�, COUNT(*) "��� ��", SUM(SALARY) "�� �޿�"  --3
FROM EMPLOYEE               --1
GROUP BY DEPT_CODE;         --2        
ORDER BY DEPT_CODE;         --4

-- ���޺� ��� ��, �� �޿� ��ȸ
SELECT JOB_CODE ����, COUNT(*) "��� ��", SUM(SALARY) "�� �޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- ���� �� ��� ��, ���ʽ� ���� ��� ��, �� �޿�, ��� �޿�, ���� �޿�, �ְ� �޿� ��ȸ
-- (���� ���� �������� ����)

SELECT JOB_CODE ����, COUNT(*) "��� ��", COUNT(BONUS) "���ʽ� ���� ��� ��", SUM(SALARY) "�� �޿�",
        ROUND(AVG(SALARY)) "��� �޿�", MIN(SALARY) "���� �޿�", MAX(SALARY) "�ְ� �޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- ���� ���� ��, ���� ���� ��  == (���� �� ���� ��)  // ���� �� : COUNT(*)
-- | ���� | ���� ��|
--   ��      xxx
--   ��      xxx
-- ���� : SUBSTR(EMP_NO, 8, 1)
-- GROUP BY������ �Լ��� ��� ����!
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '����', '2', '����') "����" , COUNT(*) "���� ��"   --3
FROM EMPLOYEE                       --1 
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '����', '2', '����');       --2

-- �μ� �� ���� ��  �μ��ڵ�, �����ڵ�, ��� ��, �� �޿� ��ȸ
--  GROUP BY���� ���� �÷��� ����� �� ����
SELECT DEPT_CODE "�μ��ڵ�", JOB_CODE "�����ڵ�", COUNT(*) "��� ��", SUM(SALARY) "�� �޿�"
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;
--==============================================================================
/*
    * HAVING ��
    : �׷쿡 ���� ������ ������ �� ���Ǵ� ����
      �ַ�, �׷��Լ����� ����Ͽ� ������ ������ �� �ۼ���.
*/    
-- �� �μ��� ��� �޿� ��ȸ
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �� �μ��� ��ձ޿��� 300���� �̻��� �μ��� ��ȸ
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
WHERE ROUND(AVG(SALARY)) >= 3000000;            -- WHERE�� ��� �� ���� �߻�!

SELECT DEPT_CODE, ROUND(AVG(SALARY))     --4
FROM EMPLOYEE                            --1
GROUP BY DEPT_CODE                       --2
HAVING ROUND(AVG(SALARY)) >= 3000000;    --3     

-- ���޺� �����ڵ�, �� �޿� ��ȸ (��, ���޺� �� ���� 1,000���� �̻��� ���޸� ��ȸ)
SELECT JOB_CODE �����ڵ�, SUM(SALARY) "�� �޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;
-- �μ� �� ���ʽ��� ���� ����� ���� �μ��� �μ��ڵ� ��ȸ
SELECT DEPT_CODE �μ��ڵ�, COUNT(BONUS) " ���ʽ� ���� ��� ��"
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;    -- COUNT(BONUS) => BONUS �÷��� �����Ͱ� �ִ� ��� ����. 0�� ��� �����Ͱ� NULL.
--------------------------------------------------------------------------------
/*
    * SELECT�� ���� ����
    
    SELECT * | ��ȸ�� �÷� [AS ��Ī] | �������� | �Լ���   --5
    FROM ��ȸ�� ���̺�                                    --1
    WHERE ���ǽ� (�����ڵ��� ���)                         --2
    GROUP BY �׷����� ������ ������ �Ǵ� �÷� | �����       --3
    HAVING ���ǽ� (�׷��Լ��� ������ ���)                  --4     
    ORDER BY �÷� | ��Ī | �÷�_�ۼ�_����_��ȣ [NULLS FIRST | NULLS LAST]   --6
*/    
--------------------------------------------------------------------------------
/*
    * ���� �Լ� : �׷� �� ����� ��� ���� �߰� ���踦 ������ִ� �Լ�


    ROLLUP, CUBE
    => GROUP BY ���� �����.
    
*/
-- ���� �� �� �޿� ��
SELECT JOB_CODE "�����ڵ�", SUM(SALARY) "�� �޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- ������ ������ ��ü �� �޿� �ձ��� ���� ��ȸ�ϰ��� �� ��
SELECT JOB_CODE "�����ڵ�", SUM(SALARY) "�� �޿�"
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE)
ORDER BY JOB_CODE;

SELECT NVL2(JOB_CODE, JOB_CODE, '����') "�����ڵ�", SUM(SALARY) "�� �޿�"    
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE)           -- ����� CUBE ������� ���� ����.
ORDER BY JOB_CODE;

-- �׷� ������ �÷��� �ϳ��� ���� CUBE, ROLLUP �� �������� ����!
-- �� �������� ������, �׷� ������ �÷��� �� ���� �־�� ��.

-- ROLLUP(�÷�1, �÷�2) : �÷�1�� ������ �ٽ� �߰����踦 �ϴ� �Լ�
SELECT DEPT_CODE "�μ��ڵ�", JOB_CODE "�����ڵ�", SUM(SALARY) "�� ��"
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

-- CUBE(�÷�1, �÷�2) : �÷�1�� ������ �߰����踦 ����, �÷�2�� ������ �߰����踦 ����ϴ� �Լ�. 
SELECT DEPT_CODE "�μ��ڵ�", JOB_CODE "�����ڵ�", SUM(SALARY) "�� ��"
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;
--------------------------------------------------------------------------------
/*
    * ���� ������ == SET OPERATION
        : ���� ���� �������� �ϳ��� ���������� ����� ������
    
    - UNION: ������, OR ( �� �������� ������ ��� ���� ���Ѵ�. )
    - INTERSECT: ������, AND  ( �� �������� ������ ��� ���� �ߺ��� �κ� )
    - UNION ALL : ������(UNION) + ������(INTERSECT) (�ߺ��Ǵ� �� �� �� ǥ���� �� �ִ�.)
    - MINUS : ������ (���� ��� ���� ���� ��� ���� �� ������)
*/
-- 1) UNION 
-- �μ� �ڵ尡 D5�� ��� �Ǵ� �޿��� 300���� �ʰ��� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY >3000000;

-- �μ� �ڵ尡 D5�� ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- �޿��� 300���� �ʰ��� ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000;

-- UNION ��� // �ߺ��� ���ŵ�.
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000;

-- UNION ALL ��� : ������ ����� ������ �� ���Ѵ�! (�ߺ��� �����͵�)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY 
FROM EMPLOYEE
WHERE SALARY >3000000;

-- INTERSECT ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000;

-- MINUS ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000;
----------------------------------------------
-- ���� ������ ��� �� ���ǻ���
-- 1) �� �������� �÷��� ������ �Ȱ��ƾ� ��.
-- 2) �÷� �ڸ����� ������ Ÿ������ �ۼ��ؾ� ��.    
-- 3) ������ �ϰ��� �Ѵٸ�, ORDER BY�� �������� �ۼ��ؾ� �Ѵ�.
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >3000000
ORDER BY EMP_ID;
--------------------------------------------

