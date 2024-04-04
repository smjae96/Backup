/*
        * DDL : 데이터 정의 언어
        오라클에서 제공하는 객체를 새로 만들고(CREATE), 구조를 변경하고(ALTER),
                                구조 자체를 삭제(DELETE)하는 언어
        즉, 실제 데이터 값이 아닌 규칙 자체를 정의하는 언어
        
        - 오라클에서의 객체(구조) : 테이블, 뷰, 시퀀스
                                 인덱스, 패키지, 트리거,
                                 프로시져, 함수, 동의어, 사용자
                                 
        < CREATE > : 객체를 새로 생성하는 구문                         
*/
/*
        1. 테이블 생성
        - 테이블: 행과 열로 구성되는 가장 기본적인 데이터베이스 객체 
                 모든 데이터들은 테이블을 통해서 저장됨. 
                 (DBMS 용어 중 하나로 데이터를 일종의 표 형태로 표현한 것)
                 
        - 표현식
        CREATE TABLE 테이블명 (
            컬럼명 자료형(크기),
            컬럼명 자료형(크기),
            컬럼명 자료형,
            ...
        )
        
        - 자료형
            * 문자 -> 반드시 크기지정을 해줘야 함.
                + CHAR(바이트크기)       : 고정길이  (고정된 길이의 데이터가 담길 경우)
                                            -> 지정한 길이보다 작은 값이 들어올 경우 공백으로 채워져서 저장
                                            최대 2,000 바이트까지 지정 가능
                + VARCHAR2(바이트크기)   : 가변길이  (데이터 길이가 정해져 있지 않은 경우)
                                            -> 저장되는 데이터 길이만큼 공간 크기가 맞춰짐
                                            최대 4,000 바이트까지 지정 가능
            * 숫자 : NUMBER
            * 날짜 : DATE
        
*/    
CREATE TABLE MEMBER (   -- MEMBER 라는 이름의 테이블 생성
    MEM_NO NUMBER, 
    MEM_ID VARCHAR2(20),
    MEM_PWD VARCHAR2(20),
    MEM_NAME VARCHAR2(20),
    GENDER CHAR(3),     -- 성별은 '남'  | '여' 으로 저장
    PHONE VARCHAR2(13), -- 01012345678  , 010-1234-5678
    EMAIL VARCHAR2(30),
    MEM_DATE DATE
);

SELECT * FROM MEMBER;

-- [참고] 데이터 딕셔너리 : 다양한 객체들의 정보를 저장하고 있는 시스템 테이블
-- * USER_TABLES : 사용자가 가지고 있는 테이블들의 전반적인 구조를 확인할 수 있는 시스템 테이블
SELECT * FROM USER_TABLES;
-- * USER_TAB_COLUMNS : 사용자가 가지고 있는 테이블들 상의 모든 컬럼의 구조를 확인할 수 있는 시스템 테이블
SELECT * FROM USER_TAB_COLUMNS; -- 어떤 테이블에 어떤 컬럼이 어떤 타입으로 있는지 확인 가능
--------------------------------------------------------------------------------
/*
    2. 컬럼에 주석달기 (컬럼에 대한 간단한 설명)
    
    [표현식]
    COMMENT ON COLUMN 테이블명.컬럼명 IS '주석 내용(설명)';
    -> 잘못 작성 시 새로 작성하면 수정이 됨.
    
*/
COMMENT ON COLUMN MEMBER.MEM_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEM_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.MEM_PWD IS '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEM_NAME IS '회원이름';
COMMENT ON COLUMN MEMBER.GENDER IS '성별';
COMMENT ON COLUMN MEMBER.PHONE IS '연락처';
COMMENT ON COLUMN MEMBER.EMAIL IS '이메일';
COMMENT ON COLUMN MEMBER.MEM_DATE IS '가입일';

-- 테이블 삭제하고자 할 때 : DROP TABLE 테이블명;

-- 테이블에 데이터를 추가할 때 사용하는 구문 (INSERT)
--  INSERT INTO 테이블명 VALUES (값, 값, 값, 값, 값, ...);
INSERT INTO MEMBER 
VALUES (1, 'USER1', 'PASS1', '홍길동', '남', '010-1234-5678'
            , 'hong@naver.com', '24/01/29');
            
select * from member;            

INSERT INTO MEMBER
VALUES (2, 'USER2', 'PASS2', '홍길순', NULL, NULL, NULL, SYSDATE); -- NULL 데이터 넣을 경우 ''(작은따옴표) 없이!
    -- SYSDATE: 시스템 기준 현재 날짜
    
INSERT INTO MEMBER
VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
--------------------------------------------------------------------------------
/*
    * 제약조건
    : 원하는 데이터 값(유효한 형식의 값)만 유지하기 위해서 특정 컬럼에 설정하는 제약
      데이터 무결성 보장을 목적으로 함.
      
      - 종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
*/
/*
    [1] NOT NULL 제약 조건
        : 해당 컬럼에 반드시 값이 존재해야 할 경우 (즉, 절대 NULL이 저장되면 안되는 경우)
          삽입(추가) / 수정 시 NULL값을 허용하지 않도록 제한
          
    (+) 제약조건 설정 방식 (2가지)
        + 컬럼레벨방식
        + 테이블레벨방식
    
    * NOT NULL 제약 조건의 경우 무조건 "컬럼레벨방식"만 사용 가능!    
*/
CREATE TABLE MEM_NOTNULL (  -- MEM_NOTNULL 테이블 생성
    MEM_NO NUMBER NOT NULL,     -- 컬럼레벨방식 : 컬럼을 정의한 위치에 제약조건을 설정
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),     -- 성별은 '남'  | '여' 으로 저장
    PHONE VARCHAR2(13), -- 01012345678  , 010-1234-5678
    EMAIL VARCHAR2(30),
    MEM_DATE DATE
);

INSERT INTO MEM_NOTNULL
VALUES(1, 'USER1', 'PASS1', '홍길동', '남', '010-1234-5678', 'hong@naver.com', SYSDATE);

SELECT * FROM MEM_NOTNULL;

INSERT INTO MEM_NOTNULL
VALUES(2, 'USER2', 'PASS2', '홍길순', NULL, NULL, NULL, NULL);

INSERT INTO MEM_NOTNULL
VALUES(3, NULL, 'PASS3', '홍홍홍', NULL, NULL, NULL, NULL);
--> 우리가 의도한 대로 오류가 발생. (NOT NULL 제약 조건을 준 컬럼에 NULL을 저장하려고 해서)

INSERT INTO MEM_NOTNULL
VALUES(3, 'USER2', 'PASS3', '홍홍홍', NULL, NULL, NULL, NULL);
--> 사용자 아이디가 동일하나 추가가 잘 되었음. (중복되지 않게 처리가 필요함!)
--------------------------------------------------------------------------------
/*
    [2] UNIQUE 제약 조건
        : 해당 컬럼에 중복된 값이 추가되지 않도록 할 때 사용
          컬럼 값에 중복 값을 제한하는 제약 조건
          삽입(추가)/수정 시 중복되는 값이 있을 경우 오류를 발생시킴!
*/
CREATE TABLE MEM_UNIQUE (
    MEM_NO NUMBER NOT NULL,     
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,        -- 컬럼레벨방식
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),     -- 성별은 '남'  | '여' 으로 저장
    PHONE VARCHAR2(13), -- 01012345678  , 010-1234-5678
    EMAIL VARCHAR2(30),
    MEM_DATE DATE
    -- , UNIQUE(MEM_ID)     --> 테이블레벨방식 .  제약조건명(컬럼명)
    --    * 제약조건 (컬럼명)
);

-- 테이블 삭제
DROP TABLE MEM_UNIQUE;

CREATE TABLE MEM_UNIQUE (
    MEM_NO NUMBER NOT NULL, 
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),     -- 성별은 '남'  | '여' 으로 저장
    PHONE VARCHAR2(13), -- 01012345678  , 010-1234-5678
    EMAIL VARCHAR2(30),
    MEM_DATE DATE
    , UNIQUE(MEM_ID)        --> 테이블레벨방식
);


INSERT INTO MEM_UNIQUE
VALUES (1, 'USER1', 'PASS1', '홍길동', NULL, NULL, NULL, NULL);

INSERT INTO MEM_UNIQUE
VALUES (2, 'USER1', 'PASS2', '홍길순', NULL, NULL, NULL, NULL);
-- UNIQUE 제약조건에 위배되어 INSERT 시 오류 발생!
--> 오류 메시지에 자세하게 표현되지 않음. (파악 어려움)
--> 제약 조건 설정 시 "제약조건명"을 지정하게 되면, 
--      오류 메시지에 해당 제약조건명을 표시해줌.
--------------------------------------------------------------------------------
/*
    * 제약 조건 설정 시 "제약조건명"을 설정하는 방법   ( CONSTRAINT )
        + 컬럼레벨방식
            CREATE TABLE 테이블명 (
                컬럼명 자료형 [CONSTRAINT 제약조건명] 제약조건
            );
            
        + 테이블레벨방식
            CREATE TABLE 테이블명 (
                컬럼명 자료형,
                ...,
                [CONSTRAINT 제약조건명] 제약조건(컬럼명)
            );    
*/
DROP TABLE MEM_UNIQUE;


CREATE TABLE MEM_UNIQUE (
    MEM_NO NUMBER CONSTRAINT MEMNO_NN NOT NULL,     
    MEM_ID VARCHAR2(20) CONSTRAINT MEMID_NN NOT NULL,        -- 컬럼레벨방식
    MEM_PWD VARCHAR2(20) CONSTRAINT MEMPW_NN NOT NULL,
    MEM_NAME VARCHAR2(20) CONSTRAINT MEMNAME_NN NOT NULL,
    GENDER CHAR(3),     -- 성별은 '남'  | '여' 으로 저장
    PHONE VARCHAR2(13), -- 01012345678  , 010-1234-5678
    EMAIL VARCHAR2(30),
    MEM_DATE DATE,
    CONSTRAINT MEMID_UNIQ UNIQUE(MEM_ID)     --> 테이블레벨방식 .  제약조건명(컬럼명)
    --    * 제약조건 (컬럼명)
);


INSERT INTO MEM_UNIQUE
VALUES (1, 'USER1', 'PASS1', '홍길동', NULL, NULL, NULL, NULL);

INSERT INTO MEM_UNIQUE
VALUES (2, 'USER1', 'PASS2', '홍길순', NULL, NULL, NULL, NULL);

INSERT INTO MEM_UNIQUE
VALUES (NULL, 'USER1', 'PASS2', '홍길순', NULL, NULL, NULL, NULL);
--> NULL 관련 메시지는 제약조건명을 지어줘도 제약조건명이 아니라 다른 오류 메시지로 확인됨.

INSERT INTO MEM_UNIQUE
VALUES (3, 'USER3', 'PASS3', '홍홍홍', 'ㅇ', NULL, NULL, NULL);
--> 성별 데이터에 유효한 값이 아닌 경우인데도 잘 추가가 됨.
--------------------------------------------------------------------------------
/*
    [3] CHECK(조건식) 
        : 해당 컬럼에 저장될 수 있는 값에 대해 조건을 설정하는 것.
          조건에 해당되어야만 데이터 추가 가능  
*/

CREATE TABLE MEM_CHECK (
    MEM_NO NUMBER NOT NULL,     
    MEM_ID VARCHAR2(20) NOT NULL,        -- 컬럼레벨방식
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    -- 성별에 조건을 설정 : '남' 또는 '여' 인 경우에만 저장되도록
    GENDER CHAR(3) CONSTRAINT GENDER_CHECK CHECK(GENDER IN ('남', '여')),     
    PHONE VARCHAR2(13), 
    EMAIL VARCHAR2(30),
    MEM_DATE DATE,
    UNIQUE(MEM_ID)     
);

DROP TABLE MEM_CHECK;

INSERT INTO MEM_CHECK
VALUES (1, 'USER1', 'PASS1', '홍길순', '여', NULL, NULL, NULL);

INSERT INTO MEM_CHECK
VALUES (2, 'USER2', 'PASS2', '홍홍홍', 'ㅇ', NULL, NULL, NULL);
--> CHECK 제약조건에 위배되어 오류 발생!

INSERT INTO MEM_CHECK
VALUES (2, 'USER2', 'PASS2', '홍홍홍', NULL, NULL, NULL, NULL);
--> NULL은 값이 없다는 뜻으로 추가가 가능.
--> NULL이 아닌 경우는 CHECK 조건에 해당하는 값만 추가할 수 있음. ('남', '여')
INSERT INTO MEM_CHECK
VALUES (2, 'USER3', 'PASS3', '아이유', NULL, NULL, NULL, NULL);
--> 회원 번호에 해당하는 데이터가 같은 값임에도 잘 추가됨.
--------------------------------------------------------------------------------
/*
    [4] PRIMARY KEY  (기본키) 제약조건
        : 테이블에서 각 행(데이터)들을 식별하기 위한 값으로 사용되는 컬럼
        
        EX) 회원번호, 학번, 군번, 부서코드, 직급코드, 주문번호, ...
        
        PRIMARY KEY가 설정되면 해당 컬럼은 NOT NULL + UNIQUE가 걸려있음을 의미함.
        
        * 유의 사항: 한 테이블 당 오로지 한 개만 설정 가능.
*/    
CREATE TABLE MEM_PRI (
    MEM_NO NUMBER CONSTRAINT MEMNO_PK PRIMARY KEY,  -- MEM_NO 컬럼을 기본키로 설정
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(30),
    UNIQUE(MEM_ID)
    -- , CONSTRAINT MEMNO_PK PRIMARY KEY(MEM_NO)    -- 테이블레벨방식 설정
);

INSERT INTO MEM_PRI
VALUES(1, 'USER1', 'PASS1', '홍길동', '010-1234-5678', 'hong@naver.com');

INSERT INTO MEM_PRI
VALUES(1, 'USER2', 'PASS2', '홍길순', NULL, NULL);
--> 기본키(MEM_NO)에 이미 저장된 값을 추가하려고 하자, 오류 발생! (UNIQUE 제약 조건)

INSERT INTO MEM_PRI
VALUES(NULL, 'USER2', 'PASS2', '홍길순', NULL, NULL);
--> 기본키(MEM_NO)에 NULL 값을 추가하려고 하자 오류 발생! (NOT NULL 제약 조건)

INSERT INTO MEM_PRI
VALUES(2, 'USER2', 'PASS2', '홍길순', NULL, NULL);
--------------------
-- 오류 발생!   , PRIMARY KEY는 하나만 설정해야 한다.
CREATE TABLE MEM_PRI2 (
    MEM_NO NUMBER PRIMARY KEY,  -- MEM_NO 컬럼을 기본키로 설정
    MEM_ID VARCHAR2(20) PRIMARY KEY,
    MEM_PWD VARCHAR2(20) ,
    MEM_NAME VARCHAR2(20) ,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(30)
);

-- 두 개의 컬럼을 하나의 PRIMARY KEY로 사용하고자 할 경우
-- 무조건 테이블레벨방식으로 설정!
CREATE TABLE MEM_PRI2 (
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20),
    MEM_PWD VARCHAR2(20),
    MEM_NAME VARCHAR2(20),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(30),
    PRIMARY KEY(MEM_NO, MEM_ID) --> 여러 컬럼을 묶어서 하나의 기본키로 사용 (복합키)
);

INSERT INTO MEM_PRI2
VALUES(1, 'USER1', 'PASS1', '홍길동', NULL, NULL);

INSERT INTO MEM_PRI2
VALUES(1, 'USER2', 'PASS1', '홍길동', NULL, NULL);

INSERT INTO MEM_PRI2
VALUES(2, 'USER2', 'PASS1', '홍길동', NULL, NULL);


-- 복합키 사용 예시
CREATE TABLE TB_LIKE(
    MEM_NO NUMBER,
    PRODUCT_NAME VARCHAR2(10),
    LIKE_DATE DATE,
    PRIMARY KEY(MEM_NO, PRODUCT_NAME)
);

-- 회원 번호 1, 상품명 화장품A 데이터 추가
INSERT INTO TB_LIKE VALUES (1, '화장품A', SYSDATE);
-- 회원 번호 2, 상품명 화장품A 데이터 추가
INSERT INTO TB_LIKE VALUES (2, '화장품A', SYSDATE);
-- 1번 회원이 같은 상품을 또 찜할 수 있나? (X)
INSERT INTO TB_LIKE VALUES (1, '화장품A', SYSDATE);

-- 복합키로 설정한 컬럼 중 하나의 컬럼에 NULL을 추가할 수 있는가?  (X)
INSERT INTO TB_LIKE VALUES (1, NULL, SYSDATE);
--------------------------------------------------------------------------------
/*
    [5] FOREIGN KEY (외래키)
        : 다른 테이블에 존재하는 값만 사용되는 컬럼에 설정하는 제약 조건
*/
-- 회원 등급 관련 테이블 생성
CREATE TABLE MEM_GRADE (
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR(20) NOT NULL
);


-- 100: 일반회원
-- 200: 우수회원
-- 300: 특별회원
INSERT INTO MEM_GRADE
VALUES(100, '일반회원');

INSERT INTO MEM_GRADE
VALUES(200, '우수회원');

INSERT INTO MEM_GRADE
VALUES(300, '특별회원');

SELECT * FROM MEM_GRADE;

CREATE TABLE MEM (
    MEM_NO NUMBER PRIMARY KEY,  
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(30),
    GRADE_ID NUMBER,
    UNIQUE(MEM_ID)
);

INSERT INTO MEM
VALUES (1, 'USER1', 'PASS1', '홍길동', NULL, NULL, NULL);

INSERT INTO MEM
VALUES (2, 'USER2', 'PASS2', '홍길순', NULL, NULL, 100);

INSERT INTO MEM
VALUES (3, 'USER3', 'PASS3', '홍홍홍', NULL, NULL, 400);
--> 유효한 회원등급이 아닌데도 데이터가 잘 추가되고 있음.

DROP TABLE MEM;

-- 외래키 설정방법: 
--          REFERENCES 참조할 테이블명(컬럼명) -- 컬럼레벨방식
--          FOREIGN KEY(컬럼명) REFERENCES 참조할테이블명([참조할컬럼명]) -- 테이블레벨방식
--      * 참조할 컬럼명을 생략하는 경우 해당 참조할 테이블에 기본키가 자동으로 설정됨!
CREATE TABLE MEM (
    MEM_NO NUMBER PRIMARY KEY,  
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(30),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE),   -- 컬럼레벨방식
    UNIQUE(MEM_ID)
    -- , FOREIGN KEY (GRADE_ID) REFERENCES MEM_GRADE(GRADE_CODE)    -- 테이블레벨방식
);

INSERT INTO MEM
VALUES (1, 'USER1', 'PASS1', '홍길동', NULL, NULL, NULL);
--> 외래키 제약조건은 기본적으로 NULL이 허용됨.
INSERT INTO MEM
VALUES (2, 'USER2', 'PASS2', '홍길순', NULL, NULL, 100);

INSERT INTO MEM
VALUES (3, 'USER3', 'PASS3', '홍홍홍', NULL, NULL, 400);
--> 부모 키가 없다는 오류 발생

INSERT INTO MEM
VALUES (3, 'USER3', 'PASS3', '홍홍홍', NULL, NULL, 100);

-- MEM_GRADE (부모테이블) -|----<- MEM (자식테이블)
-- 1:N 관계   ) 1 - 부모테이블, N - 자식테이블

-- 부모테이블에 있는 데이터를 삭제한다면? 문제가 없을까?
-- 데이터 삭제: DELETE FROM 테이블명 WHERE 조건식;
--      * 삭제 전 해당 조건식으로 SELECT를 먼저 해볼 것!

SELECT * FROM MEM_GRADE WHERE GRADE_CODE = 100;

DELETE FROM MEM_GRADE WHERE GRADE_CODE = 100;
--> 실행 시 오류 발생!
--   자식테이블(MEM)에 사용 중인 값이 있다. 

SELECT * FROM MEM_GRADE WHERE GRADE_CODE = 300;
DELETE FROM MEM_GRADE WHERE GRADE_CODE = 300;
--> 해당 데이터를 사용중인 자식테이블이 없어서 삭제가 정상적으로 실행됨.

--> "삭제 제한" 옵션을 설정할 수 있음
--  COMMIT;         -- 수정/삭제 시 시스템적으로 적용하는 명령어. ROLLBACK 불가.
ROLLBACK;           -- 수정/삭제 시 원래대로 돌려놓는 명령어(구문)
--------------------------------------------------------------------------------
/*
    * 삭제 제한 옵션
      : 외래 키 설정 시 부모테이블의 데이터가 삭제되는 경우 자식 테이블의 값을
        어떻게 처리할 지 설정하는 옵션
        
      - ON DELETE RESTRICTED (기본값) : 삭제제한옵션, 자식 테이블에서 사용중인 데이터는 
                                       부모테이블에서 삭제가 되지 않는다.
      - ON DELETE SET NULL : 부모 테이블에서 삭제 시, 자식테이블에서 사용중인 데이터가
                             NULL 값으로 변경됨.
      - ON DELETE CASCADE : 부모 테이블에서 삭제 시, 자식테이블에서 사용중인 데이터가
                            있으면, 자식 데이터도 삭제.    
*/
DROP TABLE MEM;

-- 외래키 설정 뒤에 삭제 옵션을 추가
CREATE TABLE MEM (
    MEM_NO NUMBER PRIMARY KEY,  
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(30),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE SET NULL,   
    UNIQUE(MEM_ID)
    
);

INSERT INTO MEM
VALUES (1, 'USER1', 'PASS1', '홍길동', NULL, NULL, NULL);
INSERT INTO MEM
VALUES (2, 'USER2', 'PASS2', '홍길순', NULL, NULL, 100);
INSERT INTO MEM
VALUES (3, 'USER3', 'PASS3', '홍홍홍', NULL, NULL, 200);
INSERT INTO MEM
VALUES (4, 'USER4', 'PASS4', '홍하나', NULL, NULL, 100);

-- MEM_GRADE 테이블에서 GRADE_CODE가 100인 데이터를 삭제
SELECT * FROM MEM_GRADE
WHERE GRADE_CODE = 100;

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 100;
--> 부모테이블에서 삭제 후, 자식테이블의 데이터가 NULL로 변경되었음.
ROLLBACK;

DROP TABLE MEM;

CREATE TABLE MEM (
    MEM_NO NUMBER PRIMARY KEY,  
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(30),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE,   
    UNIQUE(MEM_ID)
    
);

INSERT INTO MEM
VALUES (1, 'USER1', 'PASS1', '홍길동', NULL, NULL, NULL);
INSERT INTO MEM
VALUES (2, 'USER2', 'PASS2', '홍길순', NULL, NULL, 100);
INSERT INTO MEM
VALUES (3, 'USER3', 'PASS3', '홍홍홍', NULL, NULL, 200);
INSERT INTO MEM
VALUES (4, 'USER4', 'PASS4', '홍하나', NULL, NULL, 100);

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 100;
--> 부모테이블에서 삭제 시 자식테이블에서도 사용 중인 데이터가 있으면 같이 삭제가 됨.  (주의..)
--------------------------------------------------------------------------------
/*
    * 기본값  (DEFAULT)
        - 제약조건은 아님.
        - 데이터 추가 시 NULL이 아닌 기본값을 추가하고자 할 때 사용
        
        [정의방법]
        컬럼명 자료형 DEFAULT 기본값
        
        [데이터 추가 시]
        VALUES(.., DEFAULT, ..)
*/    
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    MEM_NO NUMBER PRIMARY KEY, 
    MEM_NAME VARCHAR2(20)NOT NULL,
    MEM_AGE NUMBER,
    HOBBY VARCHAR2(20) DEFAULT '없음',
    UPDATE_DATE DATE DEFAULT SYSDATE
);

-- 데이터 추가: INSERT INTO 테이블명 VALUES (값1, 값2, ...);
INSERT INTO MEMBER VALUES(1, '홍길동', 18, '독서', DEFAULT);
INSERT INTO MEMBER VALUES(2, '홍길순', 25, DEFAULT, '24/01/15');

-- 데이터 추가(2) : INSERTR INTO 테이블명 (컬럼명1, 컬럼명2) VALUES(값1, 값2);
INSERT INTO MEMBER(MEM_NO, MEM_NAME) VALUES (3, '홍하나');
--> 제시하지 않은 컬럼에 대한 값은 기본적으로 NULL로 저장됨.
--  DEFAULT 설정이 된 컬럼의 경우 기본값으로 저장됨.
--------------------------------------------------------------------------------
-- 접속 계정 변경: kh 계정으로 변경
--  (우측 상단 계정 정보만 변경)

-- 기존 테이블(EMPLOYEE)을 복사하듯이 테이블 생성: 서브쿼리 사용.
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE);

SELECT * FROM EMPLOYEE_COPY;

/*
    * 테이블을 생성한 후에 제약 조건을 설정하는 방법
    ALTER TABLE 테이블명 변경할_내용
    
    - PRIMARY KEY : ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명);
    - FOREIGN KEY : ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 참조할테이블명 [(참조할컬럼명)];
    - UNIQUE : ALTER TABLE 테이블명 ADD UNIQUE(컬럼명);
    - CHECK : ALTER TABLE 테이블명 ADD CHECK(컬럼에 대한 조건식);
    - NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
*/
-- EMPLOYEE_COPY 테이블에 기본키 EMP_ID
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);
-- EMPLOYEE_COPY 테이블에 외래키 DEPT_CODE (DEPARTMENT.DEPT_ID)
ALTER TABLE EMPLOYEE_COPY ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID);
-- EMPLOYEE_COPY 테이블에 외래키 JOB_CODE (JOB.JOB_CODE)
ALTER TABLE EMPLOYEE_COPY ADD FOREIGN KEY(JOB_CODE) REFERENCES JOB(JOB_CODE);
-- DEPARTMENT 테이블에 외래키 LOCATION_ID (LOCATION.LOCAL_CODE)
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION(LOCAL_CODE);

