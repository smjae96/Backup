-- 샘플 스크립트
--  * 사용되는 DB에 객체가 이미 존재할 수 있으므로, DROP 명령어를 작성해준다.  (오류가 날 때는 해당 객체가 없는 것)
DROP TABLE MEMBER;
CREATE TABLE MEMBER (
    USERNO NUMBER PRIMARY KEY,      --회원번호
    USERID VARCHAR2(15) NOT NULL UNIQUE, -- 회원아이디
    USERPW VARCHAR2(30) NOT NULL,        -- 회원비밀번호
    USERNAME VARCHAR2(20) NOT NULL,      -- 회원이름
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')),   --성별
    AGE NUMBER,                         -- 나이
    EMAIL VARCHAR2(30),                 -- 이메일
    PHONE CHAR(11),                     -- 연락처
    ADDRESS VARCHAR2(100),              -- 주소
    HOBBY VARCHAR2(50),                 -- 취미
    ENROLLDATE DATE DEFAULT SYSDATE NOT NULL    --가입일
);    

DROP SEQUENCE SEQ_UNO;
CREATE SEQUENCE SEQ_UNO
NOCACHE;


select * from member;

INSERT INTO MEMBER (USERNO, USERID, USERPW, USERNAME, ENROLLDATE)
    VALUES (SEQ_UNO.NEXTVAL, 'sample', '1234', '샘플이', DEFAULT);

update member set userpw = '1234' where username = '샘플이';
COMMIT;



--------------------------------------------------------------------------------
CREATE TABLE TEST (
    TNO NUMBER,
    TNAME VARCHAR2(30),
    TDATE DATE
);

SELECT * FROM TEST;
delete from test
where tname = '홍길동';
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

