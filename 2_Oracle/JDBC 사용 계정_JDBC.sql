-- ���� ��ũ��Ʈ
--  * ���Ǵ� DB�� ��ü�� �̹� ������ �� �����Ƿ�, DROP ��ɾ �ۼ����ش�.  (������ �� ���� �ش� ��ü�� ���� ��)
DROP TABLE MEMBER;
CREATE TABLE MEMBER (
    USERNO NUMBER PRIMARY KEY,      --ȸ����ȣ
    USERID VARCHAR2(15) NOT NULL UNIQUE, -- ȸ�����̵�
    USERPW VARCHAR2(30) NOT NULL,        -- ȸ����й�ȣ
    USERNAME VARCHAR2(20) NOT NULL,      -- ȸ���̸�
    GENDER CHAR(3) CHECK(GENDER IN('��', '��')),   --����
    AGE NUMBER,                         -- ����
    EMAIL VARCHAR2(30),                 -- �̸���
    PHONE CHAR(11),                     -- ����ó
    ADDRESS VARCHAR2(100),              -- �ּ�
    HOBBY VARCHAR2(50),                 -- ���
    ENROLLDATE DATE DEFAULT SYSDATE NOT NULL    --������
);    

DROP SEQUENCE SEQ_UNO;
CREATE SEQUENCE SEQ_UNO
NOCACHE;


select * from member;

INSERT INTO MEMBER (USERNO, USERID, USERPW, USERNAME, ENROLLDATE)
    VALUES (SEQ_UNO.NEXTVAL, 'sample', '1234', '������', DEFAULT);

update member set userpw = '1234' where username = '������';
COMMIT;



--------------------------------------------------------------------------------
CREATE TABLE TEST (
    TNO NUMBER,
    TNAME VARCHAR2(30),
    TDATE DATE
);

SELECT * FROM TEST;
delete from test
where tname = 'ȫ�浿';
commit;

commit;


--------------------------------------------------------------------------------
CREATE TABLE BURGERKING (
    MENU_NAME VARCHAR(30),
    MENU_CARB NUMBER,
    MENU_PROTEIN NUMBER,
    MENU_FAT NUMBER,
    MENU_KCAL NUMBER,
    MENU_PRICE NUMBER
);

CREATE TABLE HANSOT (
    MENU_NAME VARCHAR(30),
    MENU_CARB NUMBER,
    MENU_PROTEIN NUMBER,
    MENU_FAT NUMBER,
    MENU_KCAL NUMBER,
    MENU_PRICE NUMBER
);

CREATE TABLE HOMECOOK (
    MENU_NAME VARCHAR(30),
    MENU_CARB NUMBER,
    MENU_PROTEIN NUMBER,
    MENU_FAT NUMBER,
    MENU_KCAL NUMBER
);
CREATE SEQUENCE SEQ_CUS
NOCACHE;

CREATE TABLE CUSTOMER (
    CUS_NO NUMBER PRIMARY KEY,
    CUS_NAME VARCHAR2(20) NOT NULL,
    CUS_GENDER CHAR(3) CHECK(CUS_GENDER IN('M', 'F'))
);    
DROP TABLE CUSTOMER;

CREATE TABLE CUST_RESULT (
    CUS_FOODLIST VARCHAR2(50),
    CUS_TPRICE NUMBER,
    CUS_TKCAL NUMBER
);

CREATE TRIGGER TRG_CUS 
AFTER INSERT ON CUSTOMER
FOR EACH ROW
BEGIN
    



select * from burgerking;
select * from hansot;
select * from homecook;
select * from customer;

