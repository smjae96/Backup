-- ������ ����


-- [����] ���� ������ �����ϰ� �ִ� ���������� ������ ������ �� ��
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
START WITH 300 -- 300���� ����
INCREMENT BY 5 -- 5�� ����
MAXVALUE 310 -- 310�� �ִ�
NOCYCLE
NOCACHE;


SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 300 : ���������� ������ NEXTVAL�� ��

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 305

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 310

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- ������ MAXVALUE �� �ʰ��߱� ������ ���� �߻�! (����!)
SELECT SEQ_EMPNO.CURRVAL FROM DUAL;

-- ������ ���� ����
/*
ALTER SEQUENCE ��������
[INCREMENT BY ����]            -- �� �� ������ų���� (�⺻�� 1)
[MAXVALUE ����]                -- �ִ밪 ���� (�⺻�� �̳�ŭ...)
[MINVALUE ����]                -- �ּҰ� ���� (�⺻�� 1)
[CYCLE|NOCYCLE]               -- �� ��ȯ ���� ���� (�⺻�� NOCYCLE) => �ִ밪 ��� ó������ �ٽ� ���ƿͼ� ������ �� �ְ���
[NOCACHE|CACHE ����Ʈũ��]      -- ĳ�ø޸� �Ҵ� (�⺻�� CACHE 20)

** START WITH �� ���� �Ұ�!!!
*/
ALTER SEQUENCE SEQ_EMPNO
    INCREMENT BY 10
    MAXVALUE 400;
                
SELECT * FROM USER_SEQUENCES;
                 
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310 + 10 => 320

-- ������ ����
DROP SEQUENCE SEQ_EMPNO;



CREATE SEQUENCE SEQ_EID
START WITH 400
NOCACHE;




CREATE TABLE EMPLOYEE (
        
          EMP_ID VARCHAR2(20)
        , EMP_NAME VARCHAR2(20)
        , EMP_NO VARCHAR2(20)
        , JOB_CODE VARCHAR2(3)
        , SAL_LEVEL VARCHAR2(3)
        , HIRE_DATE DATE
        );
        
     

SELECT * FROM EMPLOYEE;

INSERT
    INTO EMPLOYEE
        (
          EMP_ID
        , EMP_NAME
        , EMP_NO
        , JOB_CODE
        , SAL_LEVEL
        , HIRE_DATE
        )
  VALUES
       (
         SEQ_EID.NEXTVAL
       , 'ȫ�浿'
       , '111111-1111111'
       , 'J7'
       , 'S1'
       , SYSDATE
       );

INSERT
    INTO EMPLOYEE
        (
          EMP_ID
        , EMP_NAME
        , EMP_NO
        , JOB_CODE
        , SAL_LEVEL
        , HIRE_DATE
        )
  VALUES
       (
         SEQ_EID.NEXTVAL
       , '������'
       , '111111-2111111'
       , 'J6'
       , 'S1'
       , SYSDATE
       );

SELECT * FROM EMPLOYEE;
DROP TABLE EMPLOYEE;
DROP SEQUENCE SEQ_EID;

--------------------------------------------------------------------------------
/*
        <PL/SQL>

PROCEDURE LANGUAGE EXTENSION TO SAL

����Ŭ ��ü�� ����Ǿ� �ִ� ������ ���
SQL ���� ������ ������ ����, ����ó��(IF), �ݺ�ó��(LOOP, FOR, WHILE)���� �����Ͽ� SQL��
���� ����
�ټ��� SQL���� �� ���� ���� ����(BLOCK ����) + ����ó���� ����

* PL / SQL ����
- [�����] : DECLARE ������ ����� ���� �� �ʱ�ȭ �ϴ� �κ�
- ����� : BEGIN���� ����, ������ �־����! SQL�� �Ǵ� ��� (���ǹ�, �ݺ���) ���� ������
            ����ϴ� �κ�
- [����ó����] : EXCEPTION���� ����, ���� �߻� �� �ذ��ϱ� ���� ������ �̸� ����ص� �� 
                �ִ� ����.
*/

 SET SERVEROUTPUT ON;


-- * �����ϰ� ȭ�鿡 HELLO ORACLE ���! HELLO WORLD ����ߴ� �� ó��..
BEGIN
    -- System.out.println("HELLO ORACLE");
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
    DBMS_OUTPUT.PUT_LINE('������');
END;        -- *�ʼ�!
/           -- *�ʼ�!    

/* 
    1. DECLARE �����
    ���� �� ��� �����ϴ� ����(����� ���ÿ� �ʱ�ȭ�� ����)
    �Ϲ�Ÿ�Ժ���, ���۷���Ÿ�Ժ���, ROWŸ�Ժ���
    
    1-1) �Ϲ�Ÿ�� ���� ���� �� �ʱ�ȭ
        [ǥ����]
        ������[CONSTANT -> ����� ��] �ڷ��� [:=��];
*/

DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    --EID := 800;
    --ENAME := '������';
    
    EID := &��ȣ;
    ENAME := '&�̸�';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);

END;
/

/* 
    
    1-2) ���۷���(����) ���� ���� �� �ʱ�ȭ(� ���̺��� � �÷��� ������ Ÿ���� �����ؼ�
         �� Ÿ������ ����)
        [ǥ����]
        ������ ���̺��.�÷���%TYPE;
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    -- EID := '300';
    -- ENAME := '������';
    -- SAL := 3000000;
    
    -- ����� 200���� ����� ���, �����, �޿� ��ȸ�ؼ� �� ������ ����
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SAL
    FROM EMPLOYEE
    --WHERE EMP_ID = '200';
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);

END;
/

/*  --�ǽ�����
���۷��� Ÿ�� ������ EID, ENAME, JCODE, SAL, DTITLE�� �����ϰ� �� �ڷ����� EMPLOYEE,
DEPARTMENT ���̺��� �����ϵ��� ����ڰ� �Է��� ����� ����� ���, �����, �����ڵ�, �޿�,
�μ����� ��ȸ �� �� �� ������ ��Ƽ� ���.
*/

DECLARE 
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT  EMP_ID, EMP_NAME, JOB_CODE, SALARY, DEPT_TITLE
    INTO EID, ENAME, JCODE, SAL, DTITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    WHERE EMP_NAME = '&�����';
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('����� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�����ڵ� : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);
    DBMS_OUTPUT.PUT_LINE('�μ��� : ' || DTITLE);
END;
/
    
/*
    1-3) ROWŸ�� ���� ����
    ���̺��� �� �࿡ ���� ��� �÷����� �Ѳ����� ���� �� �ִ� ����
    [ǥ����]
    ������ ���̺��%ROWTYPE;
*/
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT * -- ����÷��� �ش��ϴ� ���� �־����
    INTO E
    FROM EMPLOYEE
    WHERE EMP_NAME = '&�����';
    
--      DBMS_OUTPUT.PUT_LINE(E);
    DBMS_OUTPUT.PUT_LINE('����� : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('��� : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || E.SALARY);
    DBMS_OUTPUT.PUT_LINE('���ʽ� : ' || NVL('0'||E.BONUS, 0));
    DBMS_OUTPUT.PUT_LINE('�ֹι�ȣ : ' || E.EMP_NO);
     
    
END;
/

--2. BEGIN �����

/*
    <���ǹ�>
1) IF ���ǽ� THEN ���೻�� END IF; (�ܵ�IF��);
-- ��� �Է¹��� �� �ش� ����� ���, �̸�, �޿�, ���ʽ���(%) ���.
-- ��, ���ʽ��� ���� �ʴ� ����� ���ʽ��� ��� �� '���ʽ��� ���޹��� �ʴ� ����Դϴ�.' ���.
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);

    IF BONUS = 0
    THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�.');
    END IF;
    DBMS_OUTPUT.PUT_LINE('���ʽ��� : ' || '0'||BONUS);
END;
/

/*
    2) IF ���ǽ� THEN ���೻�� ELSE ���೻�� END IF; (IF-ELSE��)
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE ('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE ('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE ('�޿� : ' || SALARY);
    
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�.');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('���ʽ��� : ' || '0'||BONUS);
    END IF;
END;
/

/*
-- �ǽ����� : ���۷���Ÿ�� ����(EID, ENAME, DTITLE, NCODE)
            ������ ���̺� : EMPLOYEE, DEPARTMENT, NATIONAL
            �Ϲ�Ÿ�� ���� (TEAM ���ڿ�) => �̵��� '������' �Ǵ� '�ؿ���' ���� ����
*/
SELECT * FROM NATIONAL;
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE LOCATION.NATIONAL_CODE%TYPE;      -- LOCATION.NATIONAL_CODE�� �����. WHY?
    
    TEAM VARCHAR2(10);
BEGIN
    -- ����ڰ� �Է��� ����� ����� ���, �̸�, �μ���, �ٹ������ڵ� ��ȸ �� �� ������ ����.
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EID, ENAME, DTITLE, NCODE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE)
    WHERE EMP_ID = &���;
    
    IF NCODE = 'KO'
        THEN TEAM := '������';
    ELSE TEAM := '�ؿ���';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�μ��� : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('�ٹ������ڵ� : ' || NCODE);
    DBMS_OUTPUT.PUT_LINE('�Ҽ��� : ' || TEAM);
END;
/
    
/*
    3) IF ���ǽ�1 THEN ���೻��1 ELSIF ���ǽ�2 THEN ���೻��2 ELSE ���೻�� END IF 
        (IF - ELSE IF - ELSE��)
     -- ������ �Է¹޾� SCORE ������ ������ ��
     -- 90�� �̻��� 'A', 80�� �̻��� 'B', 70�� �̻��� 'C', 60�� �̻��� 'D', 60�� �̸��� 'F'�� ó�� ��
     -- GRADE ������ ����
     -- '����� ������ XX���̰�, ������ X�����Դϴ�.'
*/     
DECLARE
    SCORE NUMBER;
    GRADE VARCHAR2(1);
BEGIN
    SCORE := &����;
    IF SCORE >= 90 THEN GRADE := 'A';
    ELSIF SCORE >= 80 THEN GRADE := 'B';
    ELSIF SCORE >= 70 THEN GRADE := 'C';
    ELSIF SCORE >= 60 THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('����� ������ ' || SCORE || '���̰�, ������ ' || GRADE || '�����Դϴ�.');
    
END;
/

/*
    4) CASE �񱳴���� WHEN ������� ��1 THEN �����1 WHEN �񱳰�2 THEN �����2 ... 
        ELSE ����� END;
*/
SELECT * FROM DEPARTMENT;
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(30); -- �μ��� ���� ����
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DNAME := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '�λ������'
                WHEN 'D2' THEN 'ȸ�������'
                WHEN 'D3' THEN '�����ú�'
                WHEN 'D4' THEN '����������'
                WHEN 'D9' THEN '�ѹ���'
                ELSE '�ؿܿ�����'
            END;
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME || '��(��) ' || DNAME || '�Դϴ�.');

END;
/

/*
-- �ǽ�����
    1. ����� ������ ���ϴ� PL/SQL �� �ۼ�, ���ʽ��� �ִ� ����� ���ʽ��� �����Ͽ� ���
    ���ʽ��� ������ ���ʽ� �����Կ���
    ���ʽ��� ������ ���ʽ����Կ���
    ��¿���
    �޿� �̸� \(��ȭ)999,999,999 (80000000  ������ \124,800,800)
*/    
SELECT * FROM EMPLOYEE;
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    YEAR_SAL NUMBER;
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    IF EMP.BONUS IS NULL THEN YEAR_SAL := EMP.SALARY*12;
    ELSE YEAR_SAL := EMP.SALARY*(1+EMP.BONUS)*12;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(EMP.SALARY || ' ' || EMP.EMP_NAME || ' ' || TRIM(TO_CHAR(YEAR_SAL, 'L999,999,999')));
END;
/

/*
    <�ݺ���> - BEGIN �ȿ��� �ۼ�
1) BASIC LOOP��
    [ǥ����]
    LOOP
    �ݺ������� ������ ����
    * �ݺ����� �������� �� �ִ� ����
    END LOOP;

* �ݺ����� �������� �� �ִ� ����(2����)
 1. IF ���ǽ� THEN EXIT END IF;
 2. EXIT WHEN ���ǽ�;
*/
DECLARE
    I NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;
        
        -- IF I = 6 THEN EXIT; END IF;
        EXIT WHEN I = 6;
    END LOOP;
END;
/

/*
2) FOR LOOP ��
    [ǥ����]
    FOR ���� IN [REVERSE-> ���� ���� �۾����� �ϰ� ������..]�ʱⰪ..������
    LOOP
    END LOOP;
    
*/
BEGIN
    FOR I IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/

BEGIN
    FOR I IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/
    
CREATE TABLE TEST(
    TNO NUMBER PRIMARY KEY,
    TDATE DATE
);

SELECT * FROM TEST;

CREATE SEQUENCE SEQ_TNO
START WITH 1
INCREMENT BY 2
MAXVALUE 1000
NOCYCLE
NOCACHE;

BEGIN
    FOR I IN 1..100 -- �⺻������ 1�� ����
    LOOP
        INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL, SYSDATE);
    END LOOP;
END;
/
SELECT * FROM TEST;

/*
    3) WHILE LOOP��
        [ǥ����]
        WHILE �ݺ����� ����� ����
        LOOP
        �ݺ������� ����� ����
        END LOOP;
*/    
DECLARE
    I NUMBER := 1;
BEGIN

    WHILE I < 6
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;
    END LOOP;
END;
/

/*
    3. ����ó����
    
    ����(EXCEPTION): ���� �� �߻��ϴ� ����
        [ǥ����]
        EXCEPTION
        WHEN ���ܸ�1 THEN ����ó������1;
        WHEN ���ܸ�2 THEN ����ó������2;
        ...
        WHEN OTHERS THEN ����ó������N;
    
    * ���ܸ� �� ����ұ�?
    * �ý��� ����(����Ŭ���� �̸� �����ص� ����)
    - NO_DATA_FOUND : SELECT �� ����� �� �൵ ���� ���
    - TOO_MANY_ROWS : SELECT �� ����� ���� ���� ���
    - ZERO_DIVIDE : 0���� ���� ��
    - DUP_VAL_ON_INDEX : UNIQUE �������ǿ� ������� ���
*/    
    -- ����ڰ� �Է��� ���� ������ ������ ��� ���
    DECLARE
        RESULT NUMBER;
    BEGIN
        RESULT := 10 / &����;
        DBMS_OUTPUT.PUT_LINE('��� : ' || RESULT);
    EXCEPTION
        WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('������ ����� 0���� ���� �� �����ϴ�.');
    END;
    /
   
   -- UNIQUE �������� ����
   BEGIN
        UPDATE EMPLOYEE
        SET EMP_ID = &�����һ��
        WHERE EMP_NAME = '���ö';
        
   EXCEPTION 
        WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('�̹� �����ϴ� ����Դϴ�.');
    END;
    /
    
    -- SELECT �� ����� ���� ���� ���
    -- SELECT �� ����� �� �൵ ���� ���
    DECLARE
        EID EMPLOYEE.EMP_ID%TYPE;
        ENAME EMPLOYEE.EMP_NAME%TYPE;
    BEGIN
        SELECT EMP_ID, EMP_NAME
        INTO EID, ENAME
        FROM EMPLOYEE
        WHERE MANAGER_ID = &������;   -- 200 : �ʹ� ���� �� ��ȸ�� / 202 : ��ȸ�Ǵ� ���� ����.
        
        DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
        DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
        
        EXCEPTION
        WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('�ʹ� ���� ���� ��ȸ�ƽ��ϴ�.');
        WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('�ش� ����� ���� ����� �����ϴ�.');
END;
/

    




-- <Ʈ���� TRIGGER >
/*
    ���� ������ ���̺� INSERT, UPDATE, DELETE �� DML���� ���� ��������� ���� ��
    (���̺� �̺�Ʈ�� �߻����� ��)
    �ڵ����� �Ź� ������ ������ �̸� �����ص� �� �ִ� ��ü.
    
    EX) ȸ�� Ż�� �� ������ ȸ�����̺� �����͸� DELETE �� ��ٷ� Ż���� ȸ���鸸
    ���� �����ϴ� ���̺� �ڵ����� INSERT ó���ؾ� �ȴ�!
    �Ű� Ƚ���� ���� ���� �Ѿ��� �� ���������� �ش� ȸ���� ������Ʈ�� ó���ǰԲ�
    ����� ���� �����Ͱ� ���(INSERT)�� ������ �ش� ��ǰ�� ���� ������ �Ź� ����(UPDATE)�ؾ� �� ��.
*/

/*
    * Ʈ���� ����
    
    - SQL���� ����ñ⿡ ���� �з�
    > BEFORE TRIGGER : ���� ������ ���̺� �̺�Ʈ�� �߻��Ǳ� ���� Ʈ���� ����
    > AFTER TRIGGER : ���� ������ ���̺� �̺�Ʈ�� �߻��� �Ŀ� Ʈ���� ����
    
    - SQL���� ���� ������ �޴� �� �࿡ ���� �з�
    > STATEMENT TRIGGER(����Ʈ����) : �̺�Ʈ�� �߻��� SQL���� ���� �� �ѹ��� Ʈ���� ����
    > ROW TRIGGER(�� Ʈ����): �ش� SQL�� ������ ������ �Ź� Ʈ���� ����
                            (FOR EACH ROW �ɼ� ����ؾߵ�)
                >: OLD - BEFORE UPDATE(������ �ڷ�), BEFORE DELETE(������ �ڷ�)
                >: NEW = AFTER INSERT(�߰��� �ڷ�), AFTER UPDATE(������ �ڷ�)
                
        [ǥ����]
        CREATE [OR REPLACE] TRIGGER Ʈ���Ÿ�
        BEFORE|AFTER INSERT|UPDATE|DELETE ON ���̺�� -- BEFORE ��� ��: ���̺� INSERT|UPDATE|DELETE�� �߻��ϱ� ���� Ʈ���� ����.
                                                     -- ARTER ��� ��: ���̺� INSERT|UPDATE|DELETE�� �߻��� �Ŀ� Ʈ���� ����.
        [FOR EACH ROW]
        �ڵ����� ������ ����;
        �� [DECLARE  
                ��������]
            BEGIN
                ���೻��(�ش� ���� ������ �̺�Ʈ �߻� �� ���������� (�ڵ�����) ������ ����)
            [EXCEPTION
                ����ó������;]
            END;
            /
*/

/*          EMP_ID VARCHAR2(20)
        , EMP_NAME VARCHAR2(20)
        , EMP_NO VARCHAR2(20)
        , JOB_CODE VARCHAR2(3)
        , SAL_LEVEL VARCHAR2(3)
        , HIRE_DATE DATE
*/
-- EMPLOYEE ���̺� ���ο� ���� INSERT �� ������ �ڵ����� �޽��� ��µǴ� Ʈ���� ����
CREATE OR REPLACE TRIGGER TRG_01
BEFORE INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('���Ի���� ȯ���մϴ�!');
END;
/
SELECT * FROM EMPLOYEE;
INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES(402, '������', '111112-1015123', 'J1');

ROLLBACK;

-- ��ǰ �԰� �� ��� ���� ����
/*
-->> �׽�Ʈ�� ���� ���̺� �� ������ ����

--1. ��ǰ�� ���� ������ ������ ���̺� (TB_PRODUCT)
*/
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY,       -- ��ǰ��ȣ
    PNAME VARCHAR2(30) NOT NULL,    -- ��ǰ��
    BRAND VARCHAR2(30) NOT NULL,    -- �귣��
    PRICE NUMBER,                   -- ����
    STOCK NUMBER DEFAULT 0          -- ������
);
SELECT * FROM TB_PRODUCT;
-- ��ǰ��ȣ �ߺ� �ȵǰԲ� �Ź� ���ο� ��ȣ �߻���Ű�� ������ (SEQ_PCODE)
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5
NOCACHE;
-- ���õ����� �߰�
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '������23', '�Ｚ', 1400000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '������14', '����', 1300000, 10);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '�����', '������', 600000, 20);

COMMIT;

-- 2. ��ǰ ����� �� �̷� ���̺� (TB_PRODETAIL)
-- � ��ǰ�� � ��¥�� ��� �԰� �Ǵ� ��� �Ǿ������� ���� �����͸� ����ϴ� ���̺�

CREATE TABLE TB_PRODETAIL(
    DCODE NUMBER PRIMARY KEY,               --�̷¹�ȣ
    PCODE NUMBER REFERENCES TB_PRODUCT,     --��ǰ��ȣ
    PDATE DATE NOT NULL,                    -- ��ǰ�������
    AMOUNT NUMBER NOT NULL,                 -- ��������
    STATUS CHAR(6) CHECK(STATUS IN ('�԰�', '���'))    -- ����(�԰�/���)
);    

-- �̷¹�ȣ�� �Ź� ���ο� ��ȣ �߻����Ѽ� �� �� �ְ� �����ִ� ������ (SEQ_DCODE)
CREATE SEQUENCE SEQ_DCODE
NOCACHE;


-- ��ǰ ����� �����ϱ�!
/* Ʈ���Ÿ� ����Ͽ� ����
-- TB_PRODETAIL ���̺� INSERT �̺�Ʈ �߻� ��
-- TB_PRODUCT ���̺� �Ź� �ڵ����� ������ UPDATE �ǰԲ� Ʈ���� ����.

-- ��ǰ�� �԰�� ��� => �ش� ��ǰ ã�Ƽ� ������ ���� UPDATE
UPDATE TB_PRODUCT
SET STOCK = STOCK + �����԰�ȼ���(INSERT�� �ڷ��� AMOUNT��)
WHERE PCODE = �԰�Ȼ�ǰ��ȣ(INSERT�� �ڷ��� PCODE��);

-- ��ǰ�� ���� ��� => �ش� ��ǰ ã�Ƽ� ������ ���� UPDATE
UPDATE TB_PRODUCT
SET STOCK = STOCK - �������ȼ���(INSERT�� �ڷ��� AMOUNT��)
WHERE PCODE = ���Ȼ�ǰ��ȣ(INSERT�� �ڷ��� PCODE��);
*/

-- :NEW �����
CREATE OR REPLACE TRIGGER TRG_02
