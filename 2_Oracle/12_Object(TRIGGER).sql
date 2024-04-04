/*
    * Ʈ���� (TRIGGER)
      : ������ ���̺� DML(INSERT, UPDATE, DELETE)���� ���� ��������� ���� �� (���̺� �̺�Ʈ�� �߻����� ��)
        �ڵ����� �Ź� ������ ������ �̸� ������ �δ� ��.
        
        ex) ȸ�� Ż�� �� ���� ȸ�����̺� ������ ����(DELETE)�ϰ�, 
            Ż�� ȸ�� ���̺� ������ �߰�(INSERT)�ؾ� �� �� �ڵ����� ������
            
            �Ű�Ƚ���� Ư�� ���� �Ѿ�� �� �ش� ȸ���� ������Ʈ�� ó��
            
            ����� ���� �����͸� ����� �� �ش� ��ǰ�� ���� ��� ������ �����ؾ� �� ��
            
    * Ʈ������ ����
        - SQL���� ���� �ñ⿡ ���� �з�
            + BEFORE TRIGGER : ������ ���̺� �̺�Ʈ�� �߻��ϱ� ���� Ʈ���� ����
            + AFTER TRIGGER  : ������ ���̺� �̺�Ʈ�� �߻��� �Ŀ� Ʈ���� ����
        - SQL���� ���� ������ �޴� �� �࿡ ���� �з�
            + ���� Ʈ����    : �̺�Ʈ�� �߻��� SQL���� ���� �� �� ���� Ʈ���� ����
            + �� Ʈ����      : �ش� SQL���� ������ ������ �Ź� Ʈ���� ����
                                (�ɼ� �� FOR EACH ROW �����ؾ� ��)
                                
                                :OLD - BEFORE UPDATE(���� �� �ڷ�), BEFORE DELETE (���� �� �ڷ�)
                                :NEW - AFTER INSERT(�߰� �� �ڷ�), AFTER UPDATE (���� �� �ڷ�)
                                
    * Ʈ���� ����( ���� ���� )
        CREATE [OR REPLACE] TRIGGER �̸� 
        BEFORE|AFTER INSERT|UPDATE|DELETE ON ���̺��
        [FOR EACH ROW]
        [DECLARE] -- ���� �� ��� ����, �ʱ�ȭ
        BEGIN     -- ����� (SQL��, ���ǹ�, �ݺ���, ...)
                  -- �̺�Ʈ �߻� �� �ڵ����� ó���� ����
        [EXCEPTION] -- ����ó����
        END;
        /    
*/
-- EMPLOYEE ���̺� �����Ͱ� �߰��ɶ����� '���Ի���� ȯ���մϴ�!' ���
CREATE TRIGGER TRG_EMP
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN   
    DBMS_OUTPUT.PUT_LINE('���Ի���� ȯ���մϴ�!');
END;
/
DROP TRIGGER TRG_EMP;



CREATE TRIGGER TRG_EMP
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
        DBMS_OUTPUT.PUT_LINE('���Ի���� ȯ���մϴ�!');
END;
/

SELECT * FROM EMPLOYEE;


INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES (503, '�̼���', '111111-1111111', 'D7', 'J7', SYSDATE);

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES (504, '������', '111111-1111111', 'D8', 'J7', SYSDATE);
--------------------------------------------------------------------------------
-- ��ǰ�԰� �� ��� ����

-- 1) ���̺�, ������ ����
DROP TABLE TB_PRODUCT;
DROP TABLE TB_PRODETAIL;
DROP SEQUENCE SEQ_PCODE;
DROP SEQUENCE SEQ_DECODE;
-- ��ǰ�� �����ϱ� ���� ���̺�
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY,       -- ��ǰ��ȣ
    PNAME VARCHAR2(30) NOT NULL,    -- ��ǰ��
    BRAND VARCHAR2(30) NOT NULL,    -- �귣��
    PRICE NUMBER,                   -- ��ǰ����
    STOCK NUMBER DEFAULT 0          -- ������
);    

SELECT * FROM TB_PRODUCT;

-- ��ǰ��ȣ �÷��� ����� ������ ( 200������ ����, 5�� ����, ĳ�ø޸�X)
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5
NOCACHE;


-- ���� ������ �߰�
INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '������S24', '����', 1300000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '������15', '���', 1900000, 10);
INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '�����', '�����', 700000, 30);

COMMIT;     -- DB�� �ݿ�


-- ��ǰ ����� �� �̷� ���̺�
CREATE TABLE TB_PRODETAIL (
    DECODE NUMBER CONSTRAINT PK PRIMARY KEY,          -- �̷� ��ȣ
    PCODE NUMBER CONSTRAINT FOREIGNK REFERENCES TB_PRODUCT ON DELETE CASCADE, -- ��ǰ ��ȣ
    PDATE DATE NOT NULL,                -- �������
    AMOUNT NUMBER NOT NULL,             -- ��������
    STATUS CHAR(6) CHECK(STATUS IN ('�԰�', '���'))    -- ����
);
-- TB_PRODETAIL ���̺��� DECODE �÷��� ���� ������ (SEQ_DECODE) - ĳ�ø޸�X
CREATE SEQUENCE SEQ_DECODE 
NOCACHE;

-- TB_PRODETAIL (200�� ��ǰ, ���ó�¥, 10�� �԰�) ������ �߰�
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 200, SYSDATE, 10, '�԰�');

-- TB_PRODUCT �԰�� ��ǰ�� ��� ������Ʈ
UPDATE TB_PRODUCT
SET STOCK = STOCK + 10
WHERE PCODE = 200;

COMMIT;

-- 205�� ��ǰ ���� ��¥�� 20�� �԰�
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 205, SYSDATE, 20, '�԰�');

UPDATE TB_PRODUCT
SET STOCK = STOCK + 10
WHERE PCODE = 200;

ROLLBACK;           -- ������Ʈ�� �߸��ؼ� ROLLBACK;

INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 205, SYSDATE, 20, '�԰�');

UPDATE TB_PRODUCT
SET STOCK = STOCK + 20
WHERE PCODE = 205;

COMMIT;
------------------------------
-- TB_PRODETAIL ���̺� INSERT �̺�Ʈ �߻� ��
-- TB_PRODUCT ���̺� �Ź� ��� ���� UPDATE => �ڵ����� ����ǰԲ� Ʈ���� ����
/*
        - UPDATE ����
        
            * ��ǰ�� �԰�� ��� => �ش� ��ǰ�� ã�Ƽ� ��� ���� ����
                UPDATE TB_PRODUCT
                SET STOCK = STOCK + �԰����(TB_PRODETAIL.AMOUNT)
                WHERE PCODE = �԰�Ȼ�ǰ��ȣ(TB_PRODETAIL.PCODE)
            * ��ǰ�� ���� ��� => �ش� ��ǰ�� ã�Ƽ� ��� ���� ����
                UPDATE TB_PRODUCT
                SET STOCK = STOCK - ������(TB_PRODETAIL.AMOUNT)
                WHERE PCODE = ���Ȼ�ǰ��ȣ(TB_PRODETAIL.PCODE)
*/           
SELECT * FROM TB_PRODETAIL;
SELECT * FROM TB_PRODUCT;


CREATE TRIGGER TRG_PRO
AFTER INSERT ON TB_PRODETATIL
FOR EACH ROW
DECLARE
    STOCK TB_PRODUCT.STOCK%TYPE;
BEGIN
    IF :NEW.STATUS = '�԰�' THEN 
    UPDATE TB_PRODUCT
    SET STOCK = STOCK + :NEW.AMOUNT
    WHERE PCODE = :NEW.PCODE;
    ELSIF :NEW.STATUS = '���' THEN
    UPDATE TB_PRODUCT
    SET STOCK = STOCK - :NEW.AMOUNT
    WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/
    
    
    



CREATE OR REPLACE TRIGGER TRG_PRO
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW
DECLARE
    STK TB_PRODUCT.STOCK%TYPE;
BEGIN
    IF :NEW.STATUS = '�԰�' THEN          -- �߰��� �� �ڷ� �̹Ƿ� :NEW�� ���� TB_PRODETAIL ���̺��� �÷��� ����.
    UPDATE TB_PRODUCT
    SET STOCK = STOCK + :NEW.AMOUNT
    WHERE PCODE = :NEW.PCODE;
    END IF;
    IF :NEW.STATUS = '���' THEN
    UPDATE TB_PRODUCT
    SET STOCK = STOCK - :NEW.AMOUNT
    WHERE PCODE = :NEW.PCODE;
    END IF; 
END;
/
/*
CREATE OR REPLACE TRIGGER TRG_PRO
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW
DECLARE
    ORGSTOCK TB_PRODUCT.STOCK%TYPE;
    UPDSTOCK NUMBER;
BEGIN
    SELECT STOCK
    INTO ORGSTOCK
    FROM TB_PRODUCT
    WHERE PCODE = :NEW.PCODE;

    IF :NEW.STATUS = '�԰�' THEN          -- �߰��� �� �ڷ� �̹Ƿ� :NEW�� ���� TB_PRODETAIL ���̺��� �÷��� ����.
        UPDSTOCK := ORGSTOCK + :NEW.AMOUNT;
    END IF;
    IF :NEW.STATUS = '���' THEN
        UPDSTOCK := ORGSTOCK - :NEW.AMOUNT;
        
        IF UPDSTOCK < 0
            THEN UPDSTOCK := 0;
        END IF;
    END IF;
    
    UPDATE TB_PRODUCT
    SET STOCK = UPDSTOCK
    WHERE PCODE = :NEW.PCODE;
END;
/
*/
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 210, SYSDATE, 7, '���');
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 200, SYSDATE, 10, '���');
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 210, SYSDATE, 7, '�԰�');


SELECT * FROM TB_PRODETAIL;
SELECT * FROM TB_PRODUCT;


DROP TRIGGER TRG_PRO;



/*
CREATE OR REPLACE TRIGGER TRG_DEL
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW
DECLARE
    STK TB_PRODUCT.STOCK%TYPE;
BEGIN
    SELECT STOCK
    INTO STK
    FROM TB_PRODUCT
    WHERE PCODE = :NEW.PCODE;
    

    
    IF STK <= 0
    THEN DELETE FROM TB_PRODUCT
    WHERE STOCK <= 0;
    END IF;
END;
/
*/
DROP TRIGGER TRG_DEL;










