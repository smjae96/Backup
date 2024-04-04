/*
    * PL/SQL : PROCEDURE LANGUAGE EXTENSION TO SQL
    
    ����Ŭ���� ����Ǿ� �ִ� ������ ���
    SQL���� ������ ���� ����, ����(IF), �ݺ�(FOR, WHILE) ���� �����Ͽ� SQL�� ������ ����
    �ټ��� SQL���� �ѹ��� ���� ����
    
    * PL/SQL ����
    
        [�����]       : DECLARE �� ����. ������ ����� ���� �� �ʱ�ȭ�ϴ� �κ�
        �����         : BEGIN���� ����. SQL���̳� ���(���ǹ�, �ݺ���)���� ����ϴ� �κ�
        [����ó����]   : EXCEPTION�� ����. ���� �߻� �� �ذ��ϱ� ���� ������ �̸� �ۼ��ϴ� �κ�  
*/
--  * ȭ�鿡 ǥ���ϱ� ����
SET SERVEROUTPUT ON;

--  * ȭ�鿡 HELLO ORACLE ���   DBMS_OUTPUT.PUT_LINE(����� ����);

BEGIN
    -- System.out.println("Hello world"); 
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE!');
END;
/
--------------------------------------------------------------------------------
/*
    1. DECLARE �����
        : ���� �Ǵ� ����� ���� �ϴ� �κ� ( ����� ���ÿ� �ʱ�ȭ ���� )
        
        - (������)Ÿ�� ���� ����
          + �Ϲ� Ÿ��
          + ���۷��� Ÿ��
          + ROW Ÿ��
*/    
/*
    [1] �Ϲ� Ÿ�� ����
        [ǥ����]
                ������ [CONSTANT] �ڷ��� [:= ��]; 
                -- ��� ���� �� CONSTANT �ۼ�
                -- �ʱ�ȭ �� ":= ��" �������� �ۼ�
*/    
DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
    
BEGIN
    -- ������ ���� ����
    EID := 100;
    ENAME := '������';
    
    -- EID, ENAME, PI ������ ���� ���
    -- Ư�� ���ڿ� ������ ���� ����ϰ��� �� ���� ���Ῥ����(||)
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID || ' ENAME : ' || ENAME || ' PI : ' || PI);
END;
/
-- ���� �Է¹޾� ������ ����
DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    -- ���� �Է¹��� �� '&��ü������' �������� �ۼ�
    EID := &��ȣ;
    ENAME := '������';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/
--------------------------------------------------------------------------------
/*
    [2] ���۷��� Ÿ�� ����
        : � ���̺��� � �÷��� ������Ÿ���� �����ؼ� �ش� Ÿ������ ������ ����
        
        [ǥ����]
                ������ ���̺��.�÷���%TYPE;
                
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    EID := 500;
    ENAME := '������';
    SALARY := 5000000;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('����� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SALARY);
END;
/



DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    -- EMPLOYEE ���̺��� ����� 200���� ����� ���, �����, ���� ��ȸ
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SALARY      -- �� �÷��� ��� ���� ������ ����.
    FROM EMPLOYEE
    WHERE EMP_ID = &���;        -- ����� �Է¹޾� �� ����� ������ ����. 
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SALARY);
END;
/
----------------------------- ���� ---------------------------------------------
/*
    ���۷��� Ÿ�� ������ EID, ENAME, JCODE, SAL, DTITLE�� �����ϰ�
    �� �ڷ����� EMPLOYEE (EMP_ID, EMP_NAME, JOB_CODE, SALARY),
                DEPARTMENT(DEPT_TITLE) ���� �����ϵ��� �� ��
    ����ڰ� �Է��� ����� ��� ������ ��ȸ�Ͽ� ������ ��� ���            
*/
declare
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    jcode employee.job_code%type;
    sal employee.salary%type;
    dtitle department.dept_title%type;
begin
    select emp_id, emp_name, job_code, salary, dept_title
    into eid, ename, jcode, sal, dtitle
    from employee
    join department on(dept_code = dept_id)
    where emp_id = &���;
    
    dbms_output.put_line(eid);
    dbms_output.put_line(ename);
    dbms_output.put_line(jcode);
    dbms_output.put_line(sal);
    dbms_output.put_line(dtitle);
end;
/



DECLARE 
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, DEPT_TITLE
    INTO EID, ENAME, JCODE, SAL, DTITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('����� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�����ڵ� : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);
    DBMS_OUTPUT.PUT_LINE('�μ��� : ' || DTITLE);

END;
/
--------------------------------------------------------------------------------
/*
    [3] ROW Ÿ�� ���� ����
        : ���̺��� �� �࿡ ���� ��� �÷����� �Ѳ����� ���� �� �ִ� ����
        
        [ǥ����]
                ������ ���̺��%ROWTYPE;
*/
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    -- �ش� ����� �����, �޿�, ���ʽ� ���   (�ش� �����ʹ� ���̺��� �÷����� ����Ͽ� ����� �� ����)
    DBMS_OUTPUT.PUT_LINE('����� : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || E.SALARY);
    -- NULL ó�� �Լ��� ���.
    DBMS_OUTPUT.PUT_LINE('���ʽ� : ' || NVL(E.BONUS, 0));
END;
/
--------------------------------------------------------------------------------
/*
    2. BEGIN �����
    
    [1] ���ǹ�
    
        - ���� IF��: IF ���ǽ� THEN ���೻�� END IF;
        - IF ~ ELSE �� : IF ���ǽ� THEN ���೻�� ELSE ���೻�� END IF;
        - IF ~ ELSIF �� : IF ���ǽ�1 THEN ���೻��1 ELSIF ���ǽ�2 THEN ���೻��2 ... [ELSE ���೻��] END IF;
        - CASE ~ WHEN ~ THEN ��
            : CASE �񱳴�� WHEN ����񱳰�1 THEN �����1 WHEN ����񱳰�2 THEN �����2 ... ELSE ����� END;
*/
-- ����� �Է¹��� �� �ش� ����� ���, �̸�, �޿�, ���ʽ��� ���
-- (IF ~ ELSE��) ���ʽ����� 0�� ��� "���ʽ��� ���� �ʴ� ����̴�."�� ����ϰ�,
--                                      0�� �ƴ� ��� "���ʽ��� : .X"�� �������.
declare
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    salary employee.salary%type;
    bonus employee.bonus%type;
begin
    select emp_id, emp_name, salary, bonus
    into eid, ename, salary, bonus
    from employee
    where emp_id = &���;
    
    if bonus = 0 then dbms_output.put_line('���ʽ��� ���� �ʴ� ����̴�.');
    else dbms_output.put_line('���ʽ��� : ' || bonus);
    end if;
end;
/
    






DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS,0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);
    IF BONUS = 0 THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���� ����Դϴ�.');
    END IF;
    DBMS_OUTPUT.PUT_LINE('���ʽ��� : ' || BONUS);   
END;
/
-- (IF ~ ELSE��) ���ʽ����� 0�� ��� "���ʽ��� ���� �ʴ� ����̴�."�� ����ϰ�,
--                                      0�� �ƴ� ��� "���ʽ��� : .X"�� �������.
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS,0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);
    IF BONUS = 0 THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���� �ʴ� ����̴�.');
    ELSE DBMS_OUTPUT.PUT_LINE('���ʽ��� : 0' || BONUS);  
    END IF;
     
END;
/
--------------------------------------------------------------------------------
-- �ǽ�����
/*
    DECLARE
        -- ���۷���Ÿ�Ժ��� (EID, ENAME, DTITLE, NCODE)
                    �����÷� (EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE)
        -- �Ϲ�Ÿ�Ժ��� (TEAM ���ڿ�) -- '������' �Ǵ� '�ؿ���' ������ ����
    BEGIN
        -- ����ڰ� �Է��� ����� ����� ���, �̸�, �μ���, �ٹ������ڵ� ��ȸ �� ������  ����
        
        -- ��������,, 
                NCODE ���� KO�� ��� '������'�� TEAM ������ ����
                          KO�� �ƴ� ��� '�ؿ���'�� TEAM ������ ����
        -- ��� : ���, �̸�, �μ�, �Ҽӿ� ���� ���
    END;
    /
        
*/

declare 
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    dtitle department.dept_title%type;
    ncode location.national_code%type;
    team varchar(20);
begin
    select emp_id, emp_name, dept_title, national_code
    into eid, ename, dtitle, ncode
    from employee
    join department on(dept_code = dept_id)
    join location on(location_id = local_code)
    where emp_id = &���;
    
    if ncode = 'KO' THEN TEAM := '������';
    ELSE TEAM := '�ؿ���';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID || ', �̸� : ' || ENAME || ', �μ� : ' || DTITLE || ', �Ҽ� : ' || TEAM);
END;
/
    
    
SELECT * FROM NATIONAL;
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE "NATIONAL".NATIONAL_CODE%TYPE;        -- NATIONAL�� PL/SQL���� ���� ���� ����� �־ NATIONAL ���̺�κ��� �÷��� ������ ���� "NATIONAL"�� ������־�� �Ѵ�.
    TEAM VARCHAR2(20);
    NNAME "NATIONAL".NATIONAL_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE, DECODE(NATIONAL_CODE, 'KO', '������', '�ؿ���'), NATIONAL_NAME
    INTO EID, ENAME, DTITLE, NCODE, TEAM, NNAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE)
    WHERE EMP_ID = &���;
    
    IF NCODE = 'KO' THEN TEAM:= '������';
    ELSE TEAM:= '�ؿ���';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�μ� : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('�Ҽ� : ' || TEAM);
    DBMS_OUTPUT.PUT_LINE('������ : ' || NNAME);
END;
/
-----------------------------------    

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    TEAM VARCHAR2(20);
    NNAME "NATIONAL".NATIONAL_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE,  NATIONAL_NAME
    INTO EID, ENAME, DTITLE, NNAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE)
    WHERE EMP_ID = &���;
    
    
    TEAM:= '�ؿ���';
    
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�μ� : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('�Ҽ� : ' || TEAM);
    DBMS_OUTPUT.PUT_LINE('������ : ' || NNAME);
END;
/

--------------------------------------------------------------------------------
-- ����ڿ��� ������ �Է¹޾� �������� ������ ���
DECLARE
    SCORE NUMBER;
    GRADE CHAR(1);
BEGIN
    SCORE := &����;
    
    -- 90�� �̻� 'A', 80�� �̻� 'B', 70�� �̻� 'C', 60�� �̻� 'D', �������� 'F'
    IF SCORE >=90 THEN GRADE := 'A';
    ELSIF SCORE>=80 THEN GRADE := 'B';
    ELSIF SCORE>=70 THEN GRADE := 'C';
    ELSIF SCORE>=60 THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('������ ' || SCORE || '�̰�, ������ ' || GRADE || '�Դϴ�.');
END;
/
----------------------------------------------------------------------------------
-- ����ڿ��� ����� �Է¹޾� �ش� ����� �޿��� ��ȸ�Ͽ�
--      �޿��� 500���� �̻��̸� '���'
--      �޿��� 300���� �̻��̸� '�߱�'
--          �� �ܿ��� '�ʱ�'���� ����� �з��Ͽ�
--  '�ش� ����� �޿� ����� XX�Դϴ�.' ����� �� �ֵ��� �ۼ��غ���.
DECLARE
    SALARY EMPLOYEE.SALARY%TYPE;
    GRADE VARCHAR2(20);
BEGIN
    SELECT SALARY
    INTO SALARY
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    IF SALARY >= 5000000 THEN GRADE:= '���';
    ELSIF SALARY >= 3000000 THEN GRADE:= '�߱�';
    ELSE GRADE:= '�ʱ�';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('�ش� ����� �޿��� ' || SALARY || '���̰�, ����� ' || GRADE || '�Դϴ�.');
END;
/



DECLARE
    SALARY EMPLOYEE.SALARY%TYPE;
    GRADE VARCHAR(20);
BEGIN
    SELECT SALARY
    INTO SALARY
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    IF SALARY >= 5000000 THEN GRADE := '���';
    ELSIF SALARY >= 3000000 THEN GRADE := '�߱�';
    ELSE GRADE := '�ʱ�';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('�ش� ����� �޿� ����� ' ||GRADE ||'�Դϴ�.');
END;
/
--------------------------------------------------------------------------------
-- ����� �Է¹޾� �ش� ����� �μ��ڵ带 �������� �μ����� ���. (JOIN ���� �ʰ�)
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;

DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DTITLE VARCHAR2(50);
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DTITLE := CASE EMP.DEPT_CODE
            WHEN 'D1' THEN '�λ������'
            WHEN 'D2' THEN 'ȸ�������'
            WHEN 'D3' THEN '�����ú�'
            WHEN 'D4' THEN '����������'
            WHEN 'D5' THEN '�ؿܿ���1��'
            WHEN 'D6' THEN '�ؿܿ���2��'
            WHEN 'D7' THEN '�ؿܿ���3��'
            WHEN 'D8' THEN '���������'
            WHEN 'D9' THEN '�ѹ���'
            ELSE '�μ�����'
            END;
            
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME ||' ����� �μ����� ' ||DTITLE || '�Դϴ�.');
END;
/



DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DTITLE VARCHAR2(50);    -- ����Ÿ���� ������ ������ ����
BEGIN
    SELECT * 
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DTITLE := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '�λ������'
                WHEN 'D2' THEN 'ȸ�������'
                WHEN 'D3' THEN '�����ú�'
                WHEN 'D4' THEN '����������'
                WHEN 'D5' THEN '�ؿܿ���1��'
                WHEN 'D6' THEN '�ؿܿ���2��'
                WHEN 'D7' THEN '�ؿܿ���3��'
                WHEN 'D8' THEN '���������'
                WHEN 'D9' THEN '�ѹ���'
                ELSE '�μ� ����'
                END;
         DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME || '����� �μ����� ' || DTITLE || '�Դϴ�.');
END;
/
---------------------------------------------------------------------------------
/*
    [2] �ݺ���
    
        - �⺻ ���� : LOOP �ݺ��� ���� * �ݺ����� �������� ���� END LOOP;
            * �ݺ����� �������� ����
                1) IF ���ǽ� THEN EXIT; END IF;
                2) EXIT WHEN ���ǽ�; 
        - FOR LOOP�� :         
            FOR ���� IN [REVERSE] �ʱⰪ..������
            LOOP �ݺ��� ���� [* �ݺ����� �������� ����] END LOOP;
            * REVERSE : ���������� �ʱⰪ���� �ݺ�
        - WHILE LOOP�� :
            WHILE �ݺ����� ����� ���ǽ�
            LOOP �ݺ��� ���� END LOOP;
*/        
-- �⺻ ����
-- 'HELLO ORACLE!' 5���� ���
DECLARE
    NUM NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE('HELLO ORACLE!');
        NUM := NUM+1;
        EXIT WHEN NUM = 6;
    END LOOP;
END;
/


DECLARE
    NUM NUMBER := 1;
BEGIN
    LOOP 
        DBMS_OUTPUT.PUT_LINE('HELLO ORACLE!');
        NUM := NUM +1;
        IF NUM > 5 
            THEN EXIT; 
        END IF;
    END LOOP;
END;
/
-- FOR LOOP ��
BEGIN
    FOR I IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/

-- REVERSE �ɼ� �߰�
BEGIN
    FOR I IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/
----------------------------------------
DROP TABLE TEST;

-- TEST ���̺� ����
CREATE TABLE TEST (
    TNO NUMBER PRIMARY KEY,
    TDATE DATE
);    
-- SEQ_TNO ������ ����

CREATE SEQUENCE SEQ_TNO 
INCREMENT BY 2
MAXVALUE 1000
NOCYCLE
NOCACHE;

-- TEST ���̺� (TNO: �������� ��� TDATE: ���� ��¥/�ð�) 100�� �߰�
BEGIN
    FOR I IN 1..100
    LOOP
    INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL, SYSDATE);
    END LOOP;
END;
/
SELECT * FROM TEST;


BEGIN
    FOR I IN 1..100
    LOOP
    INSERT INTO TEST VALUES (SEQ_TNO.NEXTVAL, SYSDATE);
    END LOOP;
END;
/
SELECT * FROM TEST;
--------------------------------------------------------------------------------
-- 1���� 5���� ����ϱ�
DECLARE
I NUMBER := 1;
BEGIN
WHILE I <=5
LOOP
    DBMS_OUTPUT.PUT_LINE(I);
    I := I+1;
END LOOP;
END;
/


DECLARE
I NUMBER := 1;
BEGIN
    WHILE I <= 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I +1;
    END LOOP;
END;
/
--------------------------------------------------------------------------------
/*
    3. ����ó����
        * ���� (EXCEPTION) : ���� �� �߻��ϴ� ����
        
    [ǥ����]    
            EXCEPTION
                WHEN ���ܸ�1 THEN ����ó������1;
                WHEN ���ܸ�2 THEN ����ó������2;
                ...
                WHEN OTHERS THEN ����ó������N;
                
            * ����Ŭ���� �̸� ������ ���ܵ�.. => �ý��� ����
                - NO_DATA_FOUND : ��ȸ�� ����� ���� ��
                - TOO_MANY_ROWS : ��ȸ�� ����� ���� ���� �� (������ ������ ��..)
                - ZERO_DIVIDE   : 0���� ���� �������� �� ��
                - DUP_VAL_ON_INDEX : UNIQUE ���ǿ� ����� �� (�ߺ��Ǵ� ���)
                ...
*/
-- ����ڿ��� ���ڸ� �Է¹޾� 10�� �� ���ڷ� ���� ����� ����غ���.
DECLARE
    RESULT NUMBER;
BEGIN
   RESULT := &����;
    
    DBMS_OUTPUT.PUT_LINE(10/RESULT);
EXCEPTION
    WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('0���� ���� �� �����ϴ�.');
    
END;
/





DECLARE
    RESULT NUMBER;
BEGIN
    -- int result = 10 / x;
    RESULT := 10 /&����;
    DBMS_OUTPUT.PUT_LINE('����� ' || RESULT || '�Դϴ�.');
EXCEPTION
    -- WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('0���δ� ���� �� �����ϴ�.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('0���δ� ���� �� �����ϴ�.');
END;
/
-- EMPLOYEE ���̺� EMP_ID �÷��� �⺻Ű(PRIMARY KEY) ���� - UNIQUE + NOT NULL ����
ALTER TABLE EMPLOYEE
ADD PRIMARY KEY(EMP_ID);

-- UNIQUE ����

BEGIN
    UPDATE EMPLOYEE 
    SET EMP_ID = '&�����һ��'  -- => ' ���200' --> 10BYTE ���� ���� ���� �Է��� ��� �Ѵ�. 
                                                --      ������ ������ �� �ڷδ� ������ �Է��� ó���ϱ� ����
                                                --      & �ڿ��� ������ ������ �ؾ� ��.    
    WHERE EMP_NAME = '���ö';
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('����� �ߺ��� ���� �� �� �����ϴ�.');
END;
/
------------------------ ���� ---------------------------------------------------
-- ����� ����� �Է¹޾� �ش� ����� ���, �̸��� ����غ���.
-- ��� : XXX
-- �̸� : XXX
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EID, ENAME
    FROM EMPLOYEE
    WHERE MANAGER_ID = &������;

    DBMS_OUTPUT.PUT_LINE('��� : '|| EID || ', �̸� : ' ||ENAME);

EXCEPTION
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('�ش� ����� ���� ����� �����ϴ�.');
    WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('�ش� ����� ���� ����� �ʹ� �����ϴ�.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('���� �߻�');

END;
/




SELECT * FROM EMPLOYEE;

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EID, ENAME
    FROM EMPLOYEE
    WHERE MANAGER_ID = '&������';     -- ����Ÿ���� �Է¹��� ���� ��������ǥ('')�� �����ش�.
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('�ش� ����� ���� ����� �����ϴ�.');
    WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('�ش� ����� ���� ����� �ʹ� �����ϴ�.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('������ �߻��߽��ϴ�. �����ڿ��� �����Ͻʽÿ�.');

END;
/
    
    

    










