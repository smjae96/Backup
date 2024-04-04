/*
        <SELECT> : ������ ��ȸ �� ����ϴ� ����
        
        SELECT ������ �� ���� FROM ���̺�
        SELECT �÷�1, �÷�2, �÷�3 FROM ���̺�
        SELECT * FROM ���̺�   // ���̺� �ִ� ��� ����(������) ��ȸ
*/        

-- EMPLOYEE : ����(���)�� ���� ������ ����(�׷�)

-- ��� ����� ������ ��ȸ
SELECT * FROM EMPLOYEE;

-- ��� ����� �̸�(EMP_NAME), �ֹι�ȣ(EMP_NO), �ڵ�����ȣ(PHONE) ��ȸ
SELECT EMP_NAME, EMP_NO, PHONE FROM EMPLOYEE;
-------------------------------------------------------------------------
-- JOB  : ���޿� ���� ������ ����

-- ��� ������ ������ ��ȸ
SELECT * FROM JOB;

-- ��� ������ ���޸�(JOB_NAME) �÷��� ��ȸ
SELECT JOB_NAME FROM JOB;
---------------------------------------------------------------------------
-- DEPARTMENT : �μ��� ���� ������ ����

-- ��� �μ��� ������ ��ȸ
SELECT * FROM DEPARTMENT;

-- ��� �μ��� �μ��ڵ�(DEPT_ID), �μ���(DEPT_TITLE) ��ȸ
SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT;
---------------------------------------------------------------------------
-- ������ �����, �̸���, ����ó, �Ի���, �޿� ��ȸ
SELECT * FROM EMPLOYEE;

SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY FROM EMPLOYEE ORDER BY EMP_NAME ASC;

/*
    �÷� ���� ���� �������
    : SELECT�� �÷��� �ۼ��κп� ��������� �� �� ����.
*/
-- ���� ���̺��� �����, ����� �޿�, ����� ����(�޿� * 12) ��ȸ
SELECT EMP_NAME, SALARY, SALARY*12 FROM EMPLOYEE;

-- ����� ���� ����(���ʽ� ���� ����) ��ȸ
-- ��ȸ ���� : �����, �޿�, ���ʽ�, ����, ���ʽ� ���� ����

SELECT EMP_NAME, SALARY, BONUS, SALARY*(1+nvl(BONUS,0))*12 FROM EMPLOYEE;

-- �����, �Ի���, �ٹ��ϼ��� ��ȸ
--     * ��ȸ �� ��¥�� ǥ���ϴ� ��� : SYSDATE (��/��/��/��/��/��)
--      DATE Ÿ���� �� - DATE Ÿ���� ���� ��� ���� �Ϸ� ǥ��
--      �Ҽ��� ������ : ����- TRUNC(�Ҽ�) / �ø�- CEIL(�Ҽ�) / �ݿø�- ROUND(�Ҽ�)
--      COLUMN�� �̸��� ���� ���ϴ´�� �ٲ㼭 ��½�Ű�� ���� �� 
--      �ش� COLUMN �ڿ� "�̸�" �ۼ�.
--      ��µǴ� ���� �ڿ� ���� ���ϴ� ���� �߰��� �ۼ� ���Ѵ� ��� ||'����' �ۼ�.
select * from employee;

select emp_name"������", hire_date"�����", sysdate"���糯¥", 
trunc(sysdate - hire_date)||'��' "�ټ�����" from employee;

-- ���� ��¥ �� �ð� ��ȸ
--  *DUAL : ����Ŭ���� �������ִ� ���� ������ ���̺�
SELECT SYSDATE ���糯¥ FROM DUAL;

/* 
    <�÷��� ��Ī �����ϱ�>
    : ��� ���� �� �÷����� �������� ���̴µ�, �� �� �÷����� ��Ī�� �ο��Ͽ� ����ϰ�
      ǥ���� �� ����.
      
      [ǥ����]
        * �÷��� ��Ī
        * �÷��� as ��Ī
        * �÷��� "��Ī"
        * �÷��� as "��Ī"
        
        - ��Ī�� ���� �Ǵ� Ư������ ���Ե� �� ū����ǥ("")�� ��� ǥ����.
*/      
-- ���� ���� ��ȸ : �����, �޿�, ���ʽ�, ����, ���ʽ� ���� ����
select emp_name �����, salary �޿�, NVL(BONUS,0) ���ʽ�, salary*12 ����
        , SALARY*(1+nvl(BONUS,0))*12 "���ʽ� ���� ����" FROM employee;
        
/* 
    <���ͷ�> : �� ��ü
    - ���Ƿ� ������ ���ڿ�('')
    - ��ȸ�� RESULT SET(���â)�� ��� �࿡ �ݺ������� ���
*/
-- ���� ���� ��ȸ : ���, �����, �޿�
SELECT EMP_ID ���, EMP_NAME �����, SALARY �޿�,'��' AS "����" FROM EMPLOYEE;

/* 
    <���� ������> : ||
    - ���� �÷� ������ �ϳ��� �÷�ó�� ������ �� ����
*/    
SELECT EMP_ID ���, EMP_NAME �����, SALARY||'��' AS "�޿�" FROM EMPLOYEE; 

-- ���, �̸�, �޿��� �ϳ��� �÷�ó�� ��ȸ
SELECT EMP_ID || ' ' ||EMP_NAME || ' '|| SALARY||'��' "��������" FROM EMPLOYEE;

-- XXX�� ������ XXX�� �Դϴ�. ��µǵ��� ��ȸ.
SELECT EMP_NAME||'�� ������ '|| SALARY ||'�� �Դϴ�.' AS "���� �� �޿�����" 
FROM EMPLOYEE;

/*
    <�ߺ� ����> : DISTINCT �÷���
    - �÷��� ǥ�õǴ� ������ �ѹ����� ��ȸ�ϰ��� �� �� ���
*/

-- ���� �������� �����ڵ带 �ߺ� ���� ��ȸ
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- ���� �������� �μ��ڵ带 �ߺ� ���� ��ȸ
SELECT DISTINCT NVL(DEPT_CODE, '�μ� ����') "�μ��ڵ�" FROM EMPLOYEE;

-- �����ڵ�, �μ��ڵ� �� �� �ߺ� ���� �����ұ�?
/*
-- DISTINCT �� �� ������ �ȿ��� ���� �� ��� �Ұ� : ���� �߻�.
SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE FROM EMPLOYEE;
*/
SELECT DISTINCT JOB_CODE, NVL(DEPT_CODE, '�μ� ����') FROM EMPLOYEE;
-- ��ó�� ��� �� (JOB_CODE, DEPT_CODE)�� �� ������ ��� �ߺ��� ������ ����� �� �� ����.
-- JOB_CODE, DEPT_CODE�� �� �� ���� ��� �ߺ� ���ŵ�.

-----------------------------------------------------------------------------------------------

 --   <WHERE ��>
 --   : ��ȸ�ϰ��� �ϴ� ���̺�κ��� Ư�� ���ǿ� �����ϴ� �����͸��� ��ȸ�� �� ���
 --   - ���ǽĿ� �پ��� ������ ��� ����.
    
--    [ǥ����]
 --               SELECT �÷�, �÷�2, �÷�����
--                FROM ���̺��
  --              WHERE ���ǽ�;
                
 --   * ������
 --     - ��� �� : > < >= <=
 --     - ���� �� : = ( ������ ���� ��? )
--                 != ^= <> ( ������ �ٸ� ��? )

-- ���� ���̺��� �μ��ڵ尡 'D9'�� ����鸸 ��ȸ
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

-- ���� ���̺��� �μ��ڵ尡 'D1'�� ������� �����, �޿�, �μ��ڵ� ��ȸ
SELECT EMP_NAME �����, SALARY �޿�, DEPT_CODE �μ��ڵ� FROM EMPLOYEE 
WHERE DEPT_CODE = 'D1';

-- ���� ���̺��� �μ��ڵ尡 'D1'�� �ƴ� ������� ���, �����, �μ��ڵ� ��ȸ
SELECT EMP_ID ���, EMP_NAME �����, DEPT_CODE �μ��ڵ� FROM EMPLOYEE
WHERE DEPT_CODE <> 'D1';

-- ������ 400���� �̻��� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME �����, DEPT_CODE �μ��ڵ�, SALARY �޿� FROM EMPLOYEE
WHERE SALARY >= 4000000;

----------------------(�ǽ� ����)--------------------------------
-- 1) �޿��� 300���� �̻��� ������� �����, �޿�, �Ի���, ���� ��ȸ (��Ī ���)
SELECT EMP_NAME �����, SALARY �޿�, HIRE_DATE �Ի���, SALARY*12 ����,
            SALARY*(1+NVL(BONUS,0))*12  "���ʽ� ���� ����"
FROM EMPLOYEE
WHERE SALARY >= 3000000;
-- 2) ������ 5000���� �̻��� ������� �����, �޿�, ����, �μ��ڵ� ��ȸ
SELECT EMP_NAME �����, SALARY*(1+NVL(BONUS,0)) �޿�, SALARY*(1+NVL(BONUS,0))*12 ����, 
DEPT_CODE �μ��ڵ� FROM EMPLOYEE WHERE SALARY*(1+NVL(BONUS,0))*12 >= 50000000;
-- 3) �����ڵ尡 'J3'�� �ƴ� ������� ���, �����, �����ڵ�, ��翩�� ��ȸ
SELECT EMP_ID ���, EMP_NAME �����, JOB_CODE �����ڵ�, ENT_YN ��翩�� 
FROM EMPLOYEE WHERE JOB_CODE <> 'J3';
-- 4) �޿��� 350���� �̻� 600���� ������ ��� ����� �����, ���, �޿� ��ȸ
--      * ���� : 350���� ~ 600���� => AND
SELECT EMP_NAME �����, EMP_ID ���, SALARY �޿�
FROM EMPLOYEE WHERE SALARY >= 3500000 AND SALARY <=6000000;
--====================================================================
/*
    <AND, OR ������>
    : ������ ���� �� ����� �� �������ִ� ����
    
    (ǥ����)
    * ����A AND ����B : ����A�� ����B�� ��� ��(true)�� �� �����͸� ��ȸ�ؿ�.
        -> �׸���, ����,
    * ����A OR ����B  : ����A �Ǵ� ����B�� ���� �� �����͸� ��ȸ�ؿ�.
        -> �Ǵ�, 
        
    <BETWEEN AND>
    : ���ǽĿ� ����ϴ� ����
      �� �̻� �� ������ ������ ���� ������ ������ �� ����ϴ� ������ (�̻�, ���ϸ� ����)
      
      [ǥ����]
            
            �񱳴�� �÷� BETWEEN ���۰�(���Ѱ�) AND ����(���Ѱ�)
            
    <NOT> : ���� ������        
    - �÷��� �� �Ǵ� BETWEEN �տ� ���
*/    
-- �޿��� 350���� �̻� 600���� ������ ��� ��� �����, ���, �޿� ��ȸ (BETWEEN AND)
SELECT EMP_NAME �����, EMP_ID ���, SALARY||'��' �޿� FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- �޿��� 350���� �̸� 600���� �ʰ��� ��� ��� �����, ���, �޿� ��ȸ
SELECT EMP_NAME �����, EMP_ID ���, SALARY||'��' �޿� FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 3500000 AND 6000000; -- NOT (���� ������) ����� ��� (BETWEEN AND�� ����)
-- NOT : ���� ������, �÷��� �� �Ǵ� BETWEEN �տ� ���


-- �Ի����� '90/01/01' ~ '01/01/01' �� ����� ��ü ��ȸ
SELECT * FROM EMPLOYEE
--WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01'; -- BETWEEN AND ����� ���
WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01'; -- AND �����ڸ� ����� ���
-- DATE Ÿ�Ե� �� ������ �����ϴ�.
-- ========================================================================================
/*
    <LIKE> 
    : ���ϰ��� �ϴ� �÷����� ���� ������ Ư�� ���Ͽ� ������ ��� ��ȸ
    
    [ǥ����]
            �񱳴���÷� LIKE 'Ư�� ����';
            
    * ���ϵ�ī�� ('%', '_')
    (1) '%' : ���� ���� �˻� (0���� �̻� ���� ��ȸ)
        ex) �񱳴���÷� LIKE '����%'; => �񱳴���÷��� �߿��� �ش繮�ڷ� �����ϴ� ���鸸 ��ȸ
            �񱳴���÷� LIKE '%����'; => �񱳴���÷��� �߿��� �ش繮�ڷ� ������ ���鸸 ��ȸ
            �񱳴���÷� LIKE '%����%'; => �񱳴���÷��� �߿��� �ش繮�ڰ� ���Ե� ���� ��ȸ
            
    (2) '_' : 1���ڸ� ��ü�ؼ� �˻� 
        ex) �񱳴���÷� LIKE '_����'; => �񱳴���÷��� �߿��� ���� �տ� �ƹ����ڳ� �ѱ��ڰ� �ִ� ���� ��ȸ
            �񱳴���÷� LIKE '___����'; => �񱳴���÷��� �߿��� ���� �տ� �ƹ����ڳ� �����ڰ� �ִ� ���� ��ȸ
            �񱳴���÷� LIKE '_����_'; => �񱳴���÷��� �߿��� ���� ��, �ڿ� �ƹ����ڳ� �ѱ��ھ� �ִ� ���� ��ȸ
*/
-- ����� �߿��� ���� ���� ���� ������� �����, �޿�, �Ի��� ��ȸ
SELECT EMP_NAME �����, SALARY �޿�, HIRE_DATE �Ի��� 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

-- ��� �̸� �߰��� '��'�� ���Ե� ������� �����, ���, ����ó ��ȸ
SELECT EMP_NAME �����, EMP_ID ���, PHONE ����ó
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_��_';

-- ��� �̸��� '��'�� ���Ե� ����� �����, ���, ����ó ��ȸ
SELECT EMP_NAME �����, EMP_ID ���, PHONE ����ó
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- �̸��� �� _ �ձ��ڰ� 3������ ������� ���, �̸�, �̸��� ��ȸ
SELECT EMP_ID ���, EMP_NAME �̸�, EMAIL �̸���
FROM EMPLOYEE
WHERE EMAIL LIKE '___?_%' ESCAPE '?';
-- ���ϵ�ī��� �Ϲݹ����� ������ �ʿ��� ��, ������ Ż����� �����Ͽ� ó���� �� ����.
-- * ESCAPE OPTION : OPTION �κп� ���� ����� ���ڸ� ����
-- ======================�ǽ�����==========================
-- 1) �̸��� '��'���� ������ ������� �����, �Ի��� ��ȸ
SELECT EMP_NAME �����, HIRE_DATE �Ի���
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';
-- 2) ����ó ó�� 3�ڸ��� 010�� �ƴ� ������� �����, ����ó ��ȸ
SELECT EMP_NAME �����, PHONE ����ó
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%'; 
-- 3) �̸��� '��'�� ���ԵǾ� �ְ�, �޿��� 240���� �̻��� ������� �����, �޿� ��ȸ
SELECT EMP_NAME �����, SALARY �޿�
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%' AND SALARY >= 2400000;
-- 4) �μ����̺��� �ؿܿ������� �����ϴ� �μ��� �μ��ڵ�, �μ��� ��ȸ
SELECT DEPT_ID �μ��ڵ�, DEPT_TITLE �μ���
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '�ؿܿ���%';

-- =======================================================================

/*

    <IN> : WHERE������ �񱳴�� �÷����� ���� ������ ��� �߿� ��ġ�ϴ� ���� �ִ� ��� ��ȸ
    
    [ǥ����]
            �񱳴���÷� IN ('��1', '��2', ...)
            
*/
-- �μ��ڵ尡 D6�̰ų� D8�̰ų� D5�� �μ������� �̸�, �μ��ڵ�, �޿��� ��ȸ
SELECT EMP_NAME �̸�, DEPT_CODE �μ��ڵ�, SALARY �޿�
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6','D8','D5') ORDER BY 2 ASC;

-- =================================================================================
/*
    < IS NULL & IS NOT NULL >
    : �÷����� NULL�� ���� ��� NULL ���� ���ϱ� ���� ���
*/
-- [JAVA] str == null / str = null (x) / [Oracle] str is null (o)
-- ���ʽ��� �������� (BONUS IS NULL) ������� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, NVL('0'||TO_CHAR(BONUS), '���ʽ� ����')
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- ���ʽ� ���� ������� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- ����� ���� ������ �����, ��� ���, �μ��ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- �μ��� ��ġ���� ���� ������ ��� �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_NAME, SALARY, NVL(CONCAT('0', TO_CHAR(BONUS)), '���ʽ� ����') ���ʽ�
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL;

-- ===========================================================================
/*
    ������ �켱����: ���� ���� �����ڰ� ����� �� �켱������ ���� ������� ����Ǵ� ���
    
    1. ��� ������ : + - * /
    2. ���� ������ : ||
    3. �� ������ : < > <= >= = != ^= <>
    4. IS NULL / LIKE / IN
    5. BETWEEN ���� AND ��
    6. NOT
    7. AND
    8. OR
*/    
-- �����ڵ尡 J7�̰ų� J2�� ��� �߿� �޿��� 200���� �̻��� ������� ��� ������ ��ȸ
SELECT * 
FROM EMPLOYEE
--WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') AND SALARY >= 2000000;
WHERE JOB_CODE IN('J7', 'J2') AND SALARY>= 2000000;
--============================ �ǽ� ���� =============================================
-- 1. ����� ���� �μ� ��ġ�� ���� ���� ����� �����, ���, �μ��ڵ� ��ȸ
SELECT EMP_NAME, EMP_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 2. ����(���ʽ� ������)�� 3õ���� �̻��̰� ���ʽ��� ���� ���� ������� ���, �����, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE SALARY*12 >= 30000000 AND BONUS IS NULL;

-- 3. �Ի����� '95/01/01' �����̰� �μ���ġ�� ���� ���� ������� ���, �����, �Ի���, �μ��ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE> '95/01/01' AND DEPT_CODE IS NULL;

-- 4. �޿��� 200���� �̻�, 500���� ������ ��� �� �Ի����� '01/01/01' �����̰�
--      ���ʽ��� ���� ���� ������� ���, �����, �޿�, �Ի���, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 5000000 AND HIRE_DATE >= '01/01/01' AND BONUS IS NULL;

-- 5. ���ʽ� ���Ե� ������ NULL�� �ƴϰ� �̸��� '��'�� ���Ե� ������� ���, �����, �޿�, ���ʽ� ���� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, NVL(SALARY*12*(1+BONUS), SALARY*12)||'��' "���ʽ� ���� ����"
FROM EMPLOYEE
WHERE SALARY*12*(1+BONUS) IS NOT NULL AND EMP_NAME LIKE '%��%';

-- =================================================================================
/*
        <ORDER BY> : ���� ���õ� ����
                     SELECT�� ���� ������ �ٿ� �ۼ�.
                     ���� ���� ���� �������� ����.
                     
        [ǥ����]
                SELECT �÷�1, �÷�2 ��Ī, ...
                FROM ���̺�
                WHERE ���ǽ�
                ORDER BY �������÷� | ��Ī | �÷����� [ASC | DESC] [NULLS FIRST | NULLS LAST]
                
                 * ASC : ��������   (�⺻ ������ ���� ����)
                 * DESC : ��������  
                 
                 * NULLS FIRST : �����Ϸ� �ϴ� ������ ���� �� NULL�� ���� �ش� ������ �� �տ� ��ġ
                                 DESC (��������) �⺻ ��
                 * NULLS LAST  : �����Ϸ� �ϴ� ������ ���� �� NULL�� ���� �ش� ������ �� �ڿ� ��ġ
                                 ASC  (��������) �⺻ ��
                                 
                ex) ORDER BY NAME; -- ASC(��������), NULLS LAST �� ����� ����!                     
*/        
-- ���� ���̺��� ��ü ������ ��ȸ
SELECT *
FROM EMPLOYEE
--ORDER BY EMP_NAME; -- ���������� �������� ���� (ASC ����!)
--ORDER BY EMP_NAME DESC; -- ���������� �������� ����
--ORDER BY BONUS ASC NULLS FIRST; -- ���ʽ� �������� NULL�� �׸��� �� �տ� ��ġ�ǵ��� �������� ����
-- ORDER BY BONUS; -- ���ʽ� �������� NULL�� �׸��� �� �ڿ� ��ġ�ǵ��� �������� ����
ORDER BY BONUS DESC, SALARY ASC; -- ���ʽ� �������� �������� �����ϰ�, �޿� �������� �������� ����

-- �� ����� �����, ���� ��ȸ (���� �� �������� ����)
SELECT EMP_NAME �����, SALARY*12 ���� 
FROM EMPLOYEE
-- ORDER BY SALARY*12 DESC;
-- ORDER BY ���� DESC;
ORDER BY 2 DESC;   -- SELECT���� ������ �������� ��� ����. ����Ŭ�� 1���� ����.








-- << ���ο���>> --
SELECT EMP_ID �����ȣ, EMP_NAME �����, FLOOR(SYSDATE-HIRE_DATE) �ټ��� , ENT_YN ��翩��
FROM EMPLOYEE WHERE TRUNC(SYSDATE-HIRE_DATE)>10000 AND ent_yn <> 'Y' ORDER BY TRUNC(SYSDATE-HIRE_DATE) DESC;

SELECT * FROM EMPLOYEE;

SELECT * FROM DEPARTMENT;

SELECT EMP_NAME �����, SALARY*(1+BONUS) �޿�, SALARY*(1+BONUS)*12 ����, 
DEPT_CODE �μ��ڵ� FROM EMPLOYEE ORDER BY SALARY*(1+BONUS) DESC NULLS LAST;


SELECT EMAIL, INSTR(EMAIL, '@' , -1) , INSTR (EMAIL, '_' , 1, 1)
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8) , 14, '*') �ֹι�ȣ���ڸ�����
FROM EMPLOYEE;

SELECT EMP_NAME, EMAIL, REPLACE(EMAIL, 'KH.or.kr' , 'gmail.com') "����email"
from employee;