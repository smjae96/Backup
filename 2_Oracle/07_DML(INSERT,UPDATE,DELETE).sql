/*
    * DQL (QUERY) : SELECT
    * DML (MANIPULATION) : INSERT, UPDATE, DELETE
    * DDL (DEFINITION) : CREATE, ALTER, DROP
    * DCL (CONTROL) : GRANT, REVOKE
    * TCL (TRANSACTION CONTROL) : COMMIT, ROLLBACK
    
    - DML : DATA MANIPULATION LANGUAGE
            ������ ���� ���
            ��(������)�� ����(�߰�)�ϰų� �����ϰų� ������ �� ����ϴ� ���
*/    
/*
    1. INSERT : ���̺� �����͸� �߰��� �� ���
    
    [ǥ����]
        [1] INSERT INTO ���̺�� VALUES (��1, ��2, ��3, ...);
            : ���̺� ���ǵ� ��� �÷��� ���� �ִ� ��� ���
              ������ ������Ÿ��(�ڷ���)�� �� ���Ѽ� �ۼ��ؾ� ��!
              
              * �÷����� ���� ���� �ۼ��� ��� => not enough value ����
              * �÷����� ���� ���� �ۼ��� ��� => too many value ����
              
        [2] INSERT INTO ���̺��(�÷���, �÷���, ..) VALUES (��, ��, ..);  
            : ������ �÷��� �ش��ϴ� ���� �߰��ϴ� ��� ���
              �������� ���� �÷��� �⺻���� ������ �⺻������, ������ NULL�� �����Ͱ� �߰���.
              
*/
-- EMPLOYEE ���̺� ����� �߰�
--  [1] ��� �÷��� ����Ͽ� �߰�


INSERT INTO EMPLOYEE VALUES (800, '������', '960528-1019731', 'tlawodbs0528@naver.com', '01062719615', 
                                    'D1', 'J1', 10000000, 0.9, 200, SYSDATE, NULL, DEFAULT);
                                    
SELECT * FROM EMPLOYEE
WHERE EMP_NAME = '������';

UPDATE EMPLOYEE
SET DEPT_CODE ='D7'
WHERE EMP_NAME = '������';
--  [2] �÷� �����Ͽ� �߰�
INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES (301, '�����', '920702-2123456', 'J1');

SELECT * FROM EMPLOYEE WHERE EMP_NAME = '�����';

--------------------------------------------------------------------------------
/*
    [3] �������� ����Ͽ� ������ �߰�
            : VALUES�� ���� ���� �ۼ��ϴ� �� ���
              ���������� ��ȸ�� ��� ���� �ѹ��� �߰�
  
    [ǥ����] 
            INSERT INTO ���̺� (��������);
*/              
--  EMP_01 ���̺� ����
CREATE TABLE EMP_01 (
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(20),
    DEPT_TITLE VARCHAR2(20)
);
SELECT * FROM EMP_01;

-- ��ü ����� ���, �̸�, �μ����� ��ȸ�Ͽ� ������ �߰�
--  * ��ü ����� ���, �̸�, �μ��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
--  * ���������� ����Ͽ� ������ �߰�
INSERT INTO EMP_01
(
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
);
--------------------------------------------------------------------------------
/*
    [4] INSERT ALL
        �� �� �̻��� ���̺� ���� �����͸� �߰��� ��,
        �� �� ���Ǵ� ���������� ������ ��� ����ϴ� ���
*/    
-- EMP_DEPT ���̺� ����
DROP TABLE EMP_DEPT;
CREATE TABLE EMP_DEPT 
AS ( 
     SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
     FROM EMPLOYEE
     WHERE 1 = 0
);




-- EMP_MANAGER ���̺� ����
CREATE TABLE EMP_MANAGER 
AS (
    SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE 1 = 0 -- �÷� ������ �������� ���� ������ FALSE ���� ����.
);

SELECT * FROM EMP_MANAGER;
SELECT * FROM EMP_DEPT;

-- �μ��ڵ尡 'D1'�� ������� ���, �̸�, �μ��ڵ�, �Ի���, ������ ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

/*
    [ǥ����]
            INSERT ALL
            INTO ���̺��(A) VALUES (�÷���, �÷���, ...)
            INTO ���̺��(B) VALUES (�÷���, �÷���, ...)
                ��������;
*/

INSERT ALL
INTO EMP_DEPT VALUES (EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES (EMP_ID, EMP_NAME, MANAGER_ID)
(SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1'
);

-- 6�� ���� �߰��� (���� 3���� �߰��Ǿ���)
SELECT * FROM EMP_DEPT;     -- 3�� �� �߰���
SELECT * FROM EMP_MANAGER;  -- 3�� �� �߰���
--------------------------------------------------------------------------------
/*
    * ������ ����ؼ� �� ���̺� ���� �߰��ϴ� ���
    
    [ǥ����]
            INSERT ALL
            WHEN ����1 THEN
                INTO ���̺��(A) VALUES (�÷���, �÷���, ...)
            WHEN ����2 THEN
                INTO ���̺��(B) VALUES (�÷���, �÷���, ...)
            ��������;    
*/
-- �Ի����� 2000�� ������ ��� ���, �̸�, ����, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE < '2000/01/01';     -- 2000�� ���� �Ի��ڵ�
-- WHERE HIRE_DATE >= '2000/01/01';     -- 2000�� ���� �Ի��ڵ�

-- EMP_OLD ���̺� ����
CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
    FROM EMPLOYEE
    WHERE 1=0;

-- EMP_NEW ���̺� ����
CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
    FROM EMPLOYEE
    WHERE 1=0;

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

-- '2000/01/01' ���� �Ի��ڵ��� EMP_OLD ���̺� �߰�
--              ���� �Ի��ڵ��� EMP_NEW ���̺� �߰�
INSERT ALL
    WHEN HIRE_DATE < '2000/01/01' THEN 
        INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, SALARY, HIRE_DATE)
    WHEN HIRE_DATE >= '2000/01/01' THEN
        INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, SALARY, HIRE_DATE)
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE;

-- �� 24�� ���� �߰���.
SELECT * FROM EMP_OLD;  -- 8�� �� �߰���
SELECT * FROM EMP_NEW;  -- 16�� �� �߰���
--------------------------------------------------------------------------------
/*
    2. UPDATE : ���� �����͸� ������ �� ����ϴ� ����
    
    [ǥ����]
            UPDATE ���̺��
            SET �÷��� = ��1,
                �÷��� = ��2,
                ...
            [WHERE ���ǽ�] --> ���ǿ� ���� �ش� �÷��� ���� �����ϴ� ��� ���    
                          --> ���� ��, ��� �����Ϳ� �ش� �÷��� ���� �����ϰ� ��. 
                          
            * ������ ���� �� "��������"�� �� Ȯ���ؾ� ��.              
    
*/
-- DEPARTMENT --> DEPT_TABLE ���̺�� ���� (DEPT_TABLE ���̺� ����, DEPARTMENT ���̺� ��������)
CREATE TABLE DEPT_TABLE
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_TABLE;

-- DEPT_TABLE���� �μ��ڵ尡 'D9'�� ������ ��ȸ
SELECT *
FROM DEPT_TABLE
WHERE DEPT_ID ='D9';

-- �μ��ڵ尡 'D9'�� �μ��� �μ����� '������ȹ��'���� ����
UPDATE DEPT_TABLE
SET DEPT_TITLE = '������ȹ��'
WHERE DEPT_ID = 'D9';

-- EMP_SALARY ���̺� ���� 
-- (EMPLOYEE ���̺��� ���� - EMP_ID / EMP_NAME / DEPT_CODE / SALARY / BONUS)

CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
    FROM EMPLOYEE;

SELECT * FROM EMP_SALARY;

-- '���ö' ����� ������ 100�������� ����
SELECT * FROM EMP_SALARY WHERE EMP_NAME = '���ö';

UPDATE EMP_SALARY
SET SALARY = 1000000
WHERE EMP_NAME = '���ö';

-- '����' ����� ������ 500�������� �����ϰ�, ���ʽ��� 0.2�� ����
SELECT * FROM EMP_SALARY WHERE EMP_NAME = '����';

UPDATE EMP_SALARY
SET SALARY = 5000000,
    BONUS = 0.2
WHERE EMP_NAME = '����';

-- ��ü ����� �޿��� ���� �޿��� 10���� �λ�� �ݾ����� ����
UPDATE EMP_SALARY
SET SALARY = SALARY*1.1;
--------------------------------------------------------------------------------
/*
    * ������ ���� �� �������� ����غ���
    
    [ǥ����]
            UPDATE ���̺��
            SET �÷��� = ( �������� )
            [WHERE ���ǽ�]
*/
-- EMP_SALARY 
-- '����' ����� �޿��� ���ʽ��� '�����' ����� �޿��� ���ʽ� ������ ����
SELECT SALARY, BONUS FROM EMP_SALARY WHERE EMP_NAME = '����';
SELECT SALARY, BONUS FROM EMP_SALARY WHERE EMP_NAME = '�����';
SELECT SALARY, BONUS FROM EMP_SALARY WHERE EMP_NAME = '������';
--  * ������ �������� (1�� 1��)
UPDATE EMP_SALARY
SET SALARY = (SELECT SALARY
                        FROM EMP_SALARY
                        WHERE EMP_NAME = '�����'),
    BONUS = (SELECT BONUS
                        FROM EMP_SALARY
                        WHERE EMP_NAME = '�����')               
WHERE EMP_NAME = '����';  


--  * ���߿� �������� (1�� N��) -- '������' ����� �޿��� ���ʽ��� ����
UPDATE EMP_SALARY
SET (SALARY, BONUS) = (SELECT SALARY, BONUS
                        FROM EMP_SALARY
                        WHERE EMP_NAME = '������')
WHERE EMP_NAME = '����';  

-- ����) ASIA �������� �ٹ��ϴ� ������� ���ʽ� ���� 0.3���� ����
SELECT * FROM LOCATION;
SELECT * FROM EMP_SALARY;
SELECT * FROM DEPARTMENT;

--       * ASIA �������� �ٹ��ϴ� ��� ��ȸ
SELECT *
FROM EMP_SALARY 
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE '%ASIA%';

--      * ���� ���������� ����Ͽ� ������Ʈ
UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE EMP_ID IN (     -- ���� ������ ����� �������̹Ƿ� '='�� �ƴ� 'IN' �����ڸ� ���.
                      -- EMP_ID�� ������ �ִ� ����: PK(PRIMARY KEY)�� �ߺ��� �� �Ǳ� ������!!     
    SELECT EMP_ID
    FROM EMP_SALARY 
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    WHERE LOCAL_NAME LIKE '%ASIA%'
);
         

SELECT EMP_NAME, BONUS, LOCAL_NAME FROM EMP_SALARY  
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);
             
-- ������� ����� ������ Ȯ�� ����.
COMMIT;

create table tb_01 (
    id number,
    name varchar2(20),
    enrolldate date
);    
  
insert into tb_01
values(1, '��', sysdate);

update tb_01
set id = 2,
    name = '��',
    enrolldate = '2024/01/24';
    
select * from tb_01;    

alter table tb_01
add constraint pk01 primary key(id);

alter table tb_01
rename constraint pk01 to pk02;

alter table tb_01
modify name constraint nn01 not null;

alter table tb_01
drop constraint pk02;

alter table tb_01
modify name constraint nn01 null;

alter table tb_01
rename column name to name1;

select * from tb_01;
    
--------------------------------------------------------------------------------
/*
    3. DELETE : ���̺� ����� �����͸� �����ϴ� ����
    
    [ǥ����]
            DELETE FROM ���̺��
            [WHERE ���ǽ�] --> WHERE�� ���� �� ��� �����Ͱ� ������!
*/
DELETE FROM EMPLOYEE;
SELECT * FROM EMPLOYEE;
ROLLBACK;                   --> ������ COMMIT �������� ���ư�.

SELECT * FROM EMPLOYEE WHERE EMP_NAME ='�����';
DELETE FROM EMPLOYEE
WHERE EMP_NAME = '�����';

COMMIT;

-- DEPARTMENT ���̺��� DEPT_ID ���� 'D1' �����͸� �����غ���.
DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';   
rollback;
--> ��������(�ܷ�Ű)�� ����Ǿ� ������ �Ұ�! = 'D1'�� ������� �ٸ� ���̺��� ����.

/*
    * TRUNCATE : ���̺��� ��ü ���� �����ϴ� ����
                 DELETE���� ���� �ӵ��� ����
                 ������ ������ ���� (��� �Ұ�)
                 ROLLBACK �Ұ�
    [ǥ����]
                TRUNCATE TABLE ���̺��;
*/
SELECT * FROM EMP_SALARY;
TRUNCATE TABLE EMP_SALARY;

ROLLBACK;           -- ROLLBACK �� �����ص� �����Ͱ� ���ƿ��� �ʴ´�!





        
