/*
PLANNER(TO-DO LIST) & DEVELOPER RETROSPECTION

���̺� �ۼ� �� �߰� ���̵��
REPORT ���̺� �����Ͽ� ���� �ۼ��ߴ� TO-DO-LIST�� �Ϸ� ���� Ȯ�� �� ��ȹ�� ����� ���� �����ͷ� ��� ���̺� �����ؼ� ��������
����? ��ī�̺�? �������� ���� �� ���� ���� ������ �󸶳� PLAN�� �� ��õ�ϰ� �ִ��� Ȯ���� �� �ֵ���
-> ���� ���̺��� �����Ϸ��� �ϴ�, PLAN ���̺��̳� DETAIL ���̺��� �ش� �÷����� �̹� �Ϻ� ������ �����Ƿ� ������ ������� ����!
*/
DROP TABLE DETAIL;
DROP TABLE PLANNER;
DROP TABLE USERS;
-- USERS ���̺�
-- �߰��� �÷� SSN(�ֹι�ȣ), ENROLLDATE(������), NICKNAME(�г���) : PLAN ���̺��� WRITER�� �ܷ�Ű�� ���� �÷�.
CREATE TABLE USERS (
    USERNO NUMBER PRIMARY KEY,
    USERID VARCHAR2(20) UNIQUE NOT NULL,
    USERPW VARCHAR2(20) NOT NULL,
    USERNAME VARCHAR2(20) NOT NULL,
    NICKNAME VARCHAR2(20) NOT NULL UNIQUE,
    EMAIL VARCHAR2(30) NOT NULL,
    PHONE VARCHAR2(15),
    SSN VARCHAR2(30) UNIQUE NOT NULL,
    ADDRESS VARCHAR2(100) NOT NULL,
    INTEREST VARCHAR2(500),
    ENROLLDATE DATE);
    
CREATE SEQUENCE SEQ_USER
NOCACHE;

select * from users;

-- PLANNER ���̺�
-- �߰��� �÷� : PRIORITY(��ȹ�� �߿䵵 ǥ��), REPEATTASK_YN(�ݺ� �۾����� ����, �ݺ��۾��� ��� ���� TO-DO LIST�� �ۼ����� �ʾƵ� �ڵ����� ������ ������ ��¥���� �ش� TO-DO LIST�� �߰��ǵ���)
--              REMINDDATE(ENDDATE 24�ð� �� �˸� â �ߵ���)
-- ����(������ �÷�) : �ļ��� DETAIL ���̺��� ���� ���뿡 ���� �ۼ��� ���̱� ������, PLAN ���̺��� ���γ��� �÷��� ���� �ʿ��ϴٰ� �������� �����Ƿ� ����.
CREATE TABLE PLANNER (
    PLANNO NUMBER PRIMARY KEY,
    WRITERNO NUMBER REFERENCES USERS ON DELETE CASCADE,
    TITLE VARCHAR2(30) NOT NULL,
    CREATEDATE DATE,
    STARTDATE DATE,
    ENDDATE DATE,
    REMINDALARM DATE,
    REPEATTASK_YN CHAR(3) DEFAULT 'N' CHECK(REPEATTASK_YN IN ('Y', 'N')),
    COMPLETE_YN CHAR(3) CHECK(COMPLETE_YN IN ('Y', 'N'))
);

CREATE SEQUENCE SEQ_PLAN
NOCACHE;

-- DETATIL ���̺�
-- �߰��� �÷�: PLANNO(PLAN���̺��� �⺻Ű(PLANNO)�� �����ϴ� �ܷ�Ű), 
CREATE TABLE DETAIL (
    DETAILNO NUMBER PRIMARY KEY,
    PLANNO NUMBER REFERENCES PLANNER ON DELETE CASCADE,
    DETATILNAME VARCHAR2(30),
    CONTENTS VARCHAR2(50),
    COMPLETE_YN CHAR(3) CHECK(COMPLETE_YN IN ('Y', 'N')),
    STARTTIME DATE,
    ENTTIME DATE,
    ALARM DATE,
    REPEAT_YN CHAR(3) DEFAULT 'N' CHECK(REPEATTASK_YN IN ('Y', 'N')),
    PRIORITY NUMBER DEFAULT 1 CHECK(PLAN_PRIORITY IN (1,2,3))
);    
    
CREATE SEQUENCE SEQ_DETAIL
NOCACHE;

/*
-- REPORT ���̺�
CREATE TABLE REPORT (
*/    
    
    
    
    
    
