/*
PLANNER(TO-DO LIST) & DEVELOPER RETROSPECTION

테이블 작성 전 추가 아이디어
REPORT 테이블 구성하여 과거 작성했던 TO-DO-LIST의 완료 여부 확인 및 계획의 이행률 등을 데이터로 담는 테이블 구성해서 유저에게
보고서? 아카이브? 페이지를 통해 한 눈에 유저 본인이 얼마나 PLAN을 잘 실천하고 있는지 확인할 수 있도록
-> 막상 테이블을 생성하려고 하니, PLAN 테이블이나 DETAIL 테이블이 해당 컬럼들을 이미 일부 가지고 있으므로 생성의 어려움이 있음!
*/
DROP TABLE DETAIL;
DROP TABLE PLANNER;
DROP TABLE USERS;
-- USERS 테이블
-- 추가한 컬럼 SSN(주민번호), ENROLLDATE(가입일), NICKNAME(닉네임) : PLAN 테이블의 WRITER가 외래키로 가질 컬럼.
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

-- PLANNER 테이블
-- 추가한 컬럼 : PRIORITY(계획의 중요도 표시), REPEATTASK_YN(반복 작업인지 여부, 반복작업일 경우 새로 TO-DO LIST에 작성하지 않아도 자동으로 유저가 지정한 날짜마다 해당 TO-DO LIST가 추가되도록)
--              REMINDDATE(ENDDATE 24시간 전 알림 창 뜨도록)
-- 수정(삭제한 컬럼) : 후술할 DETAIL 테이블에서 세부 내용에 대해 작성할 것이기 때문에, PLAN 테이블에서 세부내용 컬럼이 굳이 필요하다고 느껴지지 않으므로 삭제.
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

-- DETATIL 테이블
-- 추가한 컬럼: PLANNO(PLAN테이블의 기본키(PLANNO)를 참조하는 외래키), 
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
-- REPORT 테이블
CREATE TABLE REPORT (
*/    
    
    
    
    
    
