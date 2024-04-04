/*
        * �� (View) : SELECT���� �����ص� �� �ִ� ��ü
        
         - ���� ����ϴ� �� SELECT���� �����صθ� �� SELECT���� �Ź� �ۼ��� �ʿ䰡 ����.
         - �ӽ� ���̺��� ����
            + ���� �����͸� �����ϴ� �� �ƴ�! -> ������ ���̺�
*/
-- "�ѱ�"���� �ٹ��ϴ� ������� ���, �̸�, �μ���, �޿�, �ٹ������� ��ȸ
SELECT * FROM DEPARTMENT;
SELECT * FROM NATIONAL;
SELECT * FROM LOCATION;

SELECT EMP_ID ��� , EMP_NAME �̸�, DEPT_TITLE �μ���, SALARY �޿�, NATIONAL_NAME �ٹ�������
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '�ѱ�';

--  "���þ�"���� �ٹ��ϴ� ����� ���� ��ȸ
SELECT EMP_ID ��� , EMP_NAME �̸�, DEPT_TITLE �μ���, SALARY �޿�, NATIONAL_NAME �ٹ�������
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '���þ�';

-- "�̱�"���� �ٹ��ϴ� ����� ���� ��ȸ
SELECT EMP_ID ��� , EMP_NAME �̸�, DEPT_TITLE �μ���, SALARY �޿�, NATIONAL_NAME �ٹ�������
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '�̱�';
--------------------------------------------------------------------------------
/*
    1. VIEW �����ϱ�
    
    [ǥ����]
    CREATE [OR REPLACE] VIEW ���̸�
    AS ��������;           -- �������� : ������ SELECT��
    
    -- OR REPLACE : �� ���� �� ���� ������ �̸��� �䰡 �ִٸ� �ش� �信 ����� SELECT���� �����ϰ�,
                                                     ���ٸ� ���� �����Ѵ�.
*/
-- ������ ����� SELECT������ ���Ǻκи� �����ϰ� VIEW�� �����غ���.
CREATE VIEW VW_EMPLOYEE
AS SELECT EMP_ID ��� , EMP_NAME �̸�, DEPT_TITLE �μ���, SALARY �޿�, NATIONAL_NAME �ٹ�������
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

-- KH ������ ������ DBA ������ �־� VIEW�� �� ����������,
--  �Ϲ������� CONNECT, RESOURCE ���Ѹ� ���� ��쿡�� VIEW�� �������� ���� ���̴�.
--  ����, CONNECT, RESOURCE ���Ѹ� �ִ� ��� �Ʒ��� ���� ������ �߰������ ��.
--  GRANT CREATE VIEW TO KH;    -- KH ������ CONNECT, RESOURCE ���Ѹ� �ִ� ��� �߰� �ʿ�!
--  *---------------------------------

SELECT * FROM VW_EMPLOYEE;  -- VIEW (�ӽ����̺�)�� ��ȸ�Ѵٴ� ����,
SELECT * FROM (             -- �� SELECT��ó�� ��ȸ�ϴ� �Ͱ� ������.
    SELECT EMP_ID ��� , EMP_NAME �̸�, DEPT_TITLE �μ���, SALARY �޿�, NATIONAL_NAME �ٹ�������
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE)
);    
--> ��� �������̺��̹Ƿ�, ���� �����͸� �����ϰ� ���� ����!

-- "�ѱ�"�� �ٹ��ϴ� ������� ���� ��ȸ   (VW_EMPLOYEE �並 ��� ��ȸ)
SELECT * FROM VW_EMPLOYEE
WHERE �ٹ������� = '�ѱ�';

--  * --------------------------------------
--    ����� ������ ������ �� ��� ��ȸ
--          + VIEW_NAME : �� �̸�
--          + TEXT      : ������ SELECT��
SELECT * FROM USER_VIEWS;
--  * --------------------------------------

-- ������ ������ VW_EMPLOYEE �並 ����  (BONUS �÷� �߰�)
CREATE OR REPLACE VIEW VW_EMPLOYEE
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

SELECT * FROM VW_EMPLOYEE;
--------------------------------------------------------------------------------

-- ��ü ����� ���, �̸�, ���޸�, ����('��'/'��'), �ٹ������ ��ȸ�� �� �ִ� SELECT�� 
--> ��(VW_EMP_JOB)�� ����
--  * ��ü ����� ���, �̸�, ���޸�, ����('��'/'��'), �ٹ������ ��ȸ
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

CREATE OR REPLACE VIEW VW_EMP_JOB 
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, DECODE(SUBSTR(EMP_NO, 8,1), '1', '��', '2', '��') ���� , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) �ٹ����
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

/* 
    * ������������ �Լ����̳� ���������� ����ϰ� �Ǵ� ���
        ��Ī�� ������ �䰡 �������� �ʱ� ������, �ݵ�� ��Ī�� �ο������ ��.
*/        
SELECT * FROM VW_EMP_JOB;


-- ��Ī �ο� ���2
--  * ��� ���� �÷��� �����ϴ� ��� ��� �÷��� �̸��� �ۼ��ؾ� ��.
CREATE OR REPLACE VIEW VW_EMP_JOB (���, �̸�, ���޸�, ����, �ٹ����)
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, DECODE(SUBSTR(EMP_NO, 8,1), '1', '��', '2', '��'), EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

-- ������ ��ȸ �� �ش� �÷��� ����ؾ� ��.
SELECT * FROM VW_EMP_JOB
WHERE emp_id = 200;

SELECT * FROM VW_EMP_JOB
WHERE �ٹ���� >= 20;

-- SELECT * FROM VW_EMP_JOB WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >=20;   : �信�� ������ ��ȸ�� �� �ο��� ��Ī ��ü�� �÷����� �ǹǷ� �̿� ������ ��!
SELECT * FROM VW_EMP_JOB WHERE �ٹ���� >= 20;      -- ���� ��ȸ�ؾ� �Ѵ�.

-- �並 �����ϰ��� �Ѵٸ�, DROP VIEW ���;
DROP VIEW VW_EMP_JOB;
--------------------------------------------------------------------------------
/*
    * ������ �並 ���ؼ� DML(INSERT, UPDATE, DELETE) ����Ѵٸ� ?  -- ��� ����
    
*/    
-- JOB ���̺��� ��� �����غ���. (VW_JOB)

CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME FROM JOB;

SELECT * FROM VW_JOB ORDER BY JOB_CODE; -- �����͸� ������ �ִ� �� �ƴ϶� JOB ���̺��� ��ȸ�ϴ� SELECT���� ������ ����.
SELECT * FROM JOB ORDER BY JOB_CODE;    -- ���� �����ʹ� JOB ���̺� ����.     

-- INSERT
INSERT INTO VW_JOB VALUES ('J8', '����');     -- ���� �����Ͱ� �ִ� JOB ���̺� �����Ͱ� �߰���.

-- UPDATE
UPDATE VW_JOB
SET JOB_NAME = '�Ƹ�����Ʈ'
WHERE JOB_CODE = 'J8';      -- ���� �����Ͱ� �ִ� JOB ���̺��� �����Ͱ� �����.

-- DELETE
DELETE FROM VW_JOB
WHERE JOB_CODE = 'J8';  -- ���� �����Ͱ� �ִ� JOB ���̺��� �����Ͱ� ������.
-----------------------------------------------------------------------
/*
    * DML ��ɾ�� ������ �Ұ����� ���
        [1] �信 ���ǵǾ� ���� ���� �÷��� �����Ϸ��� ��� --> ���� JOB_NAME ������ VIEW�� ������ ��� JOB_CODE �÷� ���� �Ұ���
        [2] �信 ���ǵǾ� ���� ���� �÷� �߿� ���� �����Ͱ� ����� ���̺��� 
            NOT NULL ���������� �����Ǿ� �ִ� ���.  --> JOB_NAME������ VIEW�� �����Ϸ� �� ��, JOB_CODE�� NOT NULL ���������� �����Ǿ� �ִٸ� NULL���� JOB_CODE�� �� �� �����Ƿ� ���� �Ұ���.
        [3] ���������̳� �Լ����� ����Ͽ� ��ȸ�� �÷��� ���    --> ���������̳� �Լ����� ���� �÷��� ���� �����Ͱ� �ƴϴ�.
        [4] �׷� �Լ��� GROUP BY���� ���ԵǾ� �ִ� ���
        [5] DISTINCT ������ ���Ե� ���             --> [3],[4],[5]�� ���� �����͸� �����Ͽ� �信�� �����ϴ� ��.
        [6] JOIN�� �̿��ؼ� ���� ���̺��� ������ ���
        
    - �̷��� �پ��� �������� DML�� ����� �� ���� ������,
      ��κ� ��� ��ȸ�� �������� �̿��Ѵ�. DML�� �ǵ��� ������� �ʴ� ���� ����.
*/    
--------------------------------------------------------------------------------
/*
    * VIEW �ɼ�
    
    [��ǥ����]
    CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW ��� 
    AS ��������
    [WITH CHECK OPTION]
    [WITH READ ONLY]
    
    + OR REPLACE : ������ ������ �䰡 ������ �����ϰ�, ������ �䰡 ������ ���� ����
    + FORCE | NOFORCE
        - FORCE : ���������� ����� ���̺��� �������� ���� ��쿡�� �䰡 ������
        - NOFORCE : ���������� ����� ���̺��� �����ؾ����� �䰡 ������ (�⺻��)
    + WITH CHECK OPTION : DML ��� �� ���������� ����� ���ǿ� ������ ������ DML  ���۵ǵ���.
    + WITH READ ONLY : �信 ���ؼ� ��ȸ�� �����ϵ��� �ϴ� �ɼ�
*/    
-- FORCE | NOFORCE
-- FORCE �ɼ� �����Ͽ� �� ����
CREATE FORCE VIEW VW_TEST
AS SELECT T_ID, T_NAME FROM TT;

SELECT * FROM VW_TEST;          -- VW_TEST �䰡 ������ ������, TT��� ���̺��� ���� ���� �߻�!

-- NOFORCE �ɼ� �����Ͽ� �� ����
CREATE NOFORCE VIEW VW_TEST_2
AS SELECT T_ID, T_NAME FROM TT;        -- TT��� ���̺��� �������� �ʾ� ���� �߻�

CREATE TABLE TT (
    T_ID NUMBER,
    T_NAME VARCHAR2(30)
);    

SELECT * FROM VW_TEST;          -- TT ���̺� ���� �� ������ �����! (�߻����� ����!)

CREATE NOFORCE VIEW VW_TEST_2
AS SELECT T_ID, T_NAME FROM TT;     -- TT ���̺� ���� �� �䰡 ���������� ������.

SELECT * FROM VW_TEST_2;
--------------------------------------------------------------------------------
-- WITH CHECK OPTION : ���������� ����� ���ǿ� ���յ��� �ʴ� ������ �������� �ʵ��� ��.
--  �޿��� 300���� �̻��� ��� ������ ��� ���� (VW_EMP)
CREATE VIEW VW_EMP
AS SELECT * 
FROM EMPLOYEE
WHERE SALARY  >= 3000000;


SELECT * FROM VW_EMP;
-- ����� 200���� ����� ������ 500�������� ����
UPDATE VW_EMP 
SET SALARY = 5000000
WHERE EMP_ID = '200';
-- ���� ����� ������ 250�������� ����
UPDATE VW_EMP
SET SALARY = 2500000
WHERE EMP_ID = 200;

ROLLBACK;

-- WITH CHECK OPTION �� ����Ͽ� �並 �ٽ� ����
CREATE OR REPLACE VIEW VW_EMP
AS SELECT * 
FROM EMPLOYEE
WHERE SALARY  >= 3000000
WITH CHECK OPTION;

SELECT * FROM VW_EMP;
-- ����� 200���� ����� ������ 500�������� ����
UPDATE VW_EMP 
SET SALARY = 5000000
WHERE EMP_ID = '200';
-- ���� ����� ������ 250�������� ����
UPDATE VW_EMP
SET SALARY = 2500000
WHERE EMP_ID = 200; --> ���� �ȵ�. ������!

SELECT * FROM EMPLOYEE;
--------------------------------------------------------------------------------
-- WITH READ ONLY
CREATE OR REPLACE VIEW VW_EMP
AS SELECT EMP_ID, EMP_NAME, BONUS
    FROM EMPLOYEE
    WHERE BONUS IS NOT NULL
WITH READ ONLY;

SELECT * FROM VW_EMP;

-- 200�� ��� ����
DELETE FROM VW_EMP
WHERE EMP_ID = 200; --> WITH READ ONLY �ɼǿ� ���� �����Ұ�!




