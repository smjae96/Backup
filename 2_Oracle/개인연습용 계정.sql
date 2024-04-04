-- 시퀀스 연습


-- [참고] 현재 계정이 소유하고 있는 시퀀스들의 구조를 보고자 할 때
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
START WITH 300 -- 300부터 시작
INCREMENT BY 5 -- 5씩 증가
MAXVALUE 310 -- 310이 최대
NOCYCLE
NOCACHE;


SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 300 : 마지막으로 성공한 NEXTVAL의 값

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 305

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 310

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 지정한 MAXVALUE 값 초과했기 때문에 오류 발생! (실패!)
SELECT SEQ_EMPNO.CURRVAL FROM DUAL;

-- 시퀀스 구조 변경
/*
ALTER SEQUENCE 시퀀스명
[INCREMENT BY 숫자]            -- 몇 씩 증가시킬껀지 (기본값 1)
[MAXVALUE 숫자]                -- 최대값 지정 (기본값 겁나큼...)
[MINVALUE 숫자]                -- 최소값 지정 (기본값 1)
[CYCLE|NOCYCLE]               -- 값 순환 여부 지정 (기본값 NOCYCLE) => 최대값 찍고 처음부터 다시 돌아와서 시작할 수 있게함
[NOCACHE|CACHE 바이트크기]      -- 캐시메모리 할당 (기본값 CACHE 20)

** START WITH 는 변경 불가!!!
*/
ALTER SEQUENCE SEQ_EMPNO
    INCREMENT BY 10
    MAXVALUE 400;
                
SELECT * FROM USER_SEQUENCES;
                 
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310 + 10 => 320

-- 시퀀스 삭제
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
       , '홍길동'
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
       , '차은우'
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

오라클 자체에 내장되어 있는 절차적 언어
SQL 문장 내에서 변수의 정의, 조건처리(IF), 반복처리(LOOP, FOR, WHILE)등을 지원하여 SQL의
단점 보완
다수의 SQL문을 한 번에 실행 가능(BLOCK 구조) + 예외처리도 가능

* PL / SQL 구조
- [선언부] : DECLARE 변수나 상수를 선언 및 초기화 하는 부분
- 실행부 : BEGIN으로 시작, 무조건 있어야함! SQL문 또는 제어문 (조건문, 반복문) 등의 로직을
            기술하는 부분
- [예외처리부] : EXCEPTION으로 시작, 예외 발생 시 해결하기 위한 구문을 미리 기술해둘 수 
                있는 구문.
*/

 SET SERVEROUTPUT ON;


-- * 간단하게 화면에 HELLO ORACLE 출력! HELLO WORLD 출력했던 것 처럼..
BEGIN
    -- System.out.println("HELLO ORACLE");
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
    DBMS_OUTPUT.PUT_LINE('심재윤');
END;        -- *필수!
/           -- *필수!    

/* 
    1. DECLARE 선언부
    변수 및 상수 선언하는 공간(선언과 동시에 초기화도 가능)
    일반타입변수, 레퍼런스타입변수, ROW타입변수
    
    1-1) 일반타입 변수 선언 및 초기화
        [표현식]
        변수명[CONSTANT -> 상수가 됨] 자료형 [:=값];
*/

DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    --EID := 800;
    --ENAME := '차은우';
    
    EID := &번호;
    ENAME := '&이름';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);

END;
/

/* 
    
    1-2) 레퍼런스(참조) 변수 선언 및 초기화(어떤 테이블의 어떤 컬럼의 데이터 타입을 참조해서
         그 타입으로 지정)
        [표현식]
        변수명 테이블명.컬럼명%TYPE;
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    -- EID := '300';
    -- ENAME := '심재윤';
    -- SAL := 3000000;
    
    -- 사번이 200번인 사원의 사번, 사원명, 급여 조회해서 각 변수에 대입
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SAL
    FROM EMPLOYEE
    --WHERE EMP_ID = '200';
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);

END;
/

/*  --실습문제
레퍼런스 타입 변수로 EID, ENAME, JCODE, SAL, DTITLE을 선언하고 각 자료형이 EMPLOYEE,
DEPARTMENT 테이블을 참조하도록 사용자가 입력한 사번의 사원의 사번, 사원명, 직급코드, 급여,
부서명을 조회 한 후 각 변수에 담아서 출력.
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
    WHERE EMP_NAME = '&사원명';
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('직급코드 : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || DTITLE);
END;
/
    
/*
    1-3) ROW타입 변수 선언
    테이블의 한 행에 대한 모든 컬럼값을 한꺼번에 담을 수 있는 변수
    [표현식]
    변수명 테이블명%ROWTYPE;
*/
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT * -- 모든컬럼에 해당하는 값을 넣어야함
    INTO E
    FROM EMPLOYEE
    WHERE EMP_NAME = '&사원명';
    
--      DBMS_OUTPUT.PUT_LINE(E);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('사번 : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || E.SALARY);
    DBMS_OUTPUT.PUT_LINE('보너스 : ' || NVL('0'||E.BONUS, 0));
    DBMS_OUTPUT.PUT_LINE('주민번호 : ' || E.EMP_NO);
     
    
END;
/

--2. BEGIN 실행부

/*
    <조건문>
1) IF 조건식 THEN 실행내용 END IF; (단독IF문);
-- 사번 입력받은 후 해당 사원의 사번, 이름, 급여, 보너스율(%) 출력.
-- 단, 보너스를 받지 않는 사원은 보너스율 출력 전 '보너스를 지급받지 않는 사원입니다.' 출력.
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
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);

    IF BONUS = 0
    THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다.');
    END IF;
    DBMS_OUTPUT.PUT_LINE('보너스율 : ' || '0'||BONUS);
END;
/

/*
    2) IF 조건식 THEN 실행내용 ELSE 실행내용 END IF; (IF-ELSE문)
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
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE ('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE ('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE ('급여 : ' || SALARY);
    
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다.');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('보너스율 : ' || '0'||BONUS);
    END IF;
END;
/

/*
-- 실습문제 : 레퍼런스타입 변수(EID, ENAME, DTITLE, NCODE)
            참조할 테이블 : EMPLOYEE, DEPARTMENT, NATIONAL
            일반타입 변수 (TEAM 문자열) => 이따가 '국내팀' 또는 '해외팀' 담을 예정
*/
SELECT * FROM NATIONAL;
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE LOCATION.NATIONAL_CODE%TYPE;      -- LOCATION.NATIONAL_CODE를 써야함. WHY?
    
    TEAM VARCHAR2(10);
BEGIN
    -- 사용자가 입력한 사번의 사원의 사번, 이름, 부서명, 근무국가코드 조회 후 각 변수에 대입.
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EID, ENAME, DTITLE, NCODE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE)
    WHERE EMP_ID = &사번;
    
    IF NCODE = 'KO'
        THEN TEAM := '국내팀';
    ELSE TEAM := '해외팀';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('근무국가코드 : ' || NCODE);
    DBMS_OUTPUT.PUT_LINE('소속팀 : ' || TEAM);
END;
/
    
/*
    3) IF 조건식1 THEN 실행내용1 ELSIF 조건식2 THEN 실행내용2 ELSE 실행내용 END IF 
        (IF - ELSE IF - ELSE문)
     -- 점수를 입력받아 SCORE 변수에 저장한 후
     -- 90점 이상은 'A', 80점 이상은 'B', 70점 이상은 'C', 60점 이상은 'D', 60점 미만은 'F'로 처리 후
     -- GRADE 변수에 저장
     -- '당신의 점수는 XX점이고, 학점은 X학점입니다.'
*/     
DECLARE
    SCORE NUMBER;
    GRADE VARCHAR2(1);
BEGIN
    SCORE := &변수;
    IF SCORE >= 90 THEN GRADE := 'A';
    ELSIF SCORE >= 80 THEN GRADE := 'B';
    ELSIF SCORE >= 70 THEN GRADE := 'C';
    ELSIF SCORE >= 60 THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '점이고, 학점은 ' || GRADE || '학점입니다.');
    
END;
/

/*
    4) CASE 비교대상자 WHEN 동등비교할 값1 THEN 결과값1 WHEN 비교값2 THEN 결과값2 ... 
        ELSE 결과값 END;
*/
SELECT * FROM DEPARTMENT;
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(30); -- 부서명 보관 변수
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DNAME := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '인사관리부'
                WHEN 'D2' THEN '회계관리부'
                WHEN 'D3' THEN '마케팅부'
                WHEN 'D4' THEN '국내영업부'
                WHEN 'D9' THEN '총무부'
                ELSE '해외영업팀'
            END;
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME || '은(는) ' || DNAME || '입니다.');

END;
/

/*
-- 실습문제
    1. 사원의 연봉을 구하는 PL/SQL 블럭 작성, 보너스가 있는 사원은 보너스도 포함하여 계산
    보너스가 없으면 보너스 미포함연봉
    보너스가 있으면 보너스포함연봉
    출력에서
    급여 이름 \(원화)999,999,999 (80000000  선동일 \124,800,800)
*/    
SELECT * FROM EMPLOYEE;
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    YEAR_SAL NUMBER;
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    IF EMP.BONUS IS NULL THEN YEAR_SAL := EMP.SALARY*12;
    ELSE YEAR_SAL := EMP.SALARY*(1+EMP.BONUS)*12;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(EMP.SALARY || ' ' || EMP.EMP_NAME || ' ' || TRIM(TO_CHAR(YEAR_SAL, 'L999,999,999')));
END;
/

/*
    <반복문> - BEGIN 안에서 작성
1) BASIC LOOP문
    [표현식]
    LOOP
    반복적으로 실행할 구문
    * 반복문을 빠져나갈 수 있는 구문
    END LOOP;

* 반복문을 빠져나갈 수 있는 구문(2가지)
 1. IF 조건식 THEN EXIT END IF;
 2. EXIT WHEN 조건식;
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
2) FOR LOOP 문
    [표현식]
    FOR 변수 IN [REVERSE-> 값을 점점 작아지게 하고 싶으면..]초기값..최종값
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
    FOR I IN 1..100 -- 기본적으로 1씩 증가
    LOOP
        INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL, SYSDATE);
    END LOOP;
END;
/
SELECT * FROM TEST;

/*
    3) WHILE LOOP문
        [표현식]
        WHILE 반복문이 수행될 조건
        LOOP
        반복적으로 실행될 구문
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
    3. 예외처리부
    
    예외(EXCEPTION): 실행 중 발생하는 오류
        [표현식]
        EXCEPTION
        WHEN 예외명1 THEN 예외처리구문1;
        WHEN 예외명2 THEN 예외처리구문2;
        ...
        WHEN OTHERS THEN 예외처리구문N;
    
    * 예외명에 뭘 써야할까?
    * 시스템 예외(오라클에서 미리 정의해둔 예외)
    - NO_DATA_FOUND : SELECT 한 결과가 한 행도 없을 경우
    - TOO_MANY_ROWS : SELECT 한 결과가 여러 행일 경우
    - ZERO_DIVIDE : 0으로 나눌 때
    - DUP_VAL_ON_INDEX : UNIQUE 제약조건에 위배됐을 경우
*/    
    -- 사용자가 입력한 수로 나눗셈 연산한 결과 출력
    DECLARE
        RESULT NUMBER;
    BEGIN
        RESULT := 10 / &숫자;
        DBMS_OUTPUT.PUT_LINE('결과 : ' || RESULT);
    EXCEPTION
        WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('나누기 연산시 0으로 나눌 수 없습니다.');
    END;
    /
   
   -- UNIQUE 제약조건 위배
   BEGIN
        UPDATE EMPLOYEE
        SET EMP_ID = &변경할사번
        WHERE EMP_NAME = '노옹철';
        
   EXCEPTION 
        WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('이미 존재하는 사번입니다.');
    END;
    /
    
    -- SELECT 한 결과가 여러 행일 경우
    -- SELECT 한 결과가 한 행도 없을 경우
    DECLARE
        EID EMPLOYEE.EMP_ID%TYPE;
        ENAME EMPLOYEE.EMP_NAME%TYPE;
    BEGIN
        SELECT EMP_ID, EMP_NAME
        INTO EID, ENAME
        FROM EMPLOYEE
        WHERE MANAGER_ID = &사수사번;   -- 200 : 너무 많은 행 조회됨 / 202 : 조회되는 행이 없음.
        
        DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
        DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
        
        EXCEPTION
        WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('너무 많은 행이 조회됐습니다.');
        WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('해당 사수를 가진 사원이 없습니다.');
END;
/

    




-- <트리거 TRIGGER >
/*
    내가 지정한 테이블에 INSERT, UPDATE, DELETE 등 DML문에 의해 변경사항이 생길 때
    (테이블에 이벤트가 발생했을 때)
    자동으로 매번 실행할 내용을 미리 정의해둘 수 있는 객체.
    
    EX) 회원 탈퇴 시 기존의 회원테이블에 데이터를 DELETE 후 곧바로 탈퇴한 회원들만
    따로 보관하는 테이블에 자동으로 INSERT 처리해야 된다!
    신고 횟수가 일정 수를 넘었을 때 묵시적으로 해당 회원을 블랙리스트로 처리되게끔
    입출고에 대한 데이터가 기록(INSERT)될 때마다 해당 상품에 대한 재고수량 매번 수정(UPDATE)해야 될 때.
*/

/*
    * 트리거 종류
    
    - SQL문의 실행시기에 따른 분류
    > BEFORE TRIGGER : 내가 지정한 테이블에 이벤트가 발생되기 전에 트리거 실행
    > AFTER TRIGGER : 내가 지정한 테이블에 이벤트가 발생한 후에 트리거 실행
    
    - SQL문에 의해 영향을 받는 각 행에 따른 분류
    > STATEMENT TRIGGER(문장트리거) : 이벤트가 발생한 SQL문에 대해 딱 한번만 트리거 실행
    > ROW TRIGGER(행 트리거): 해당 SQL문 실행할 때마다 매번 트리거 실행
                            (FOR EACH ROW 옵션 기술해야됨)
                >: OLD - BEFORE UPDATE(수정전 자료), BEFORE DELETE(삭제전 자료)
                >: NEW = AFTER INSERT(추가된 자료), AFTER UPDATE(수정후 자료)
                
        [표현식]
        CREATE [OR REPLACE] TRIGGER 트리거명
        BEFORE|AFTER INSERT|UPDATE|DELETE ON 테이블명 -- BEFORE 사용 시: 테이블에 INSERT|UPDATE|DELETE가 발생하기 전에 트리거 실행.
                                                     -- ARTER 사용 시: 테이블에 INSERT|UPDATE|DELETE가 발생한 후에 트리거 실행.
        [FOR EACH ROW]
        자동으로 실행할 내용;
        ㄴ [DECLARE  
                변수선언]
            BEGIN
                실행내용(해당 위에 지정된 이벤트 발생 시 묵시적으로 (자동으로) 실행할 구문)
            [EXCEPTION
                예외처리구문;]
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
-- EMPLOYEE 테이블에 새로운 행이 INSERT 될 때마다 자동으로 메시지 출력되는 트리거 정의
CREATE OR REPLACE TRIGGER TRG_01
BEFORE INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원님 환영합니다!');
END;
/
SELECT * FROM EMPLOYEE;
INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES(402, '이이이', '111112-1015123', 'J1');

ROLLBACK;

-- 상품 입고 및 출고 관련 예시
/*
-->> 테스트를 위한 테이블 및 시퀀스 생성

--1. 상품에 대한 데이터 보관할 테이블 (TB_PRODUCT)
*/
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY,       -- 상품번호
    PNAME VARCHAR2(30) NOT NULL,    -- 상품명
    BRAND VARCHAR2(30) NOT NULL,    -- 브랜드
    PRICE NUMBER,                   -- 가격
    STOCK NUMBER DEFAULT 0          -- 재고수량
);
SELECT * FROM TB_PRODUCT;
-- 상품번호 중복 안되게끔 매번 새로운 번호 발생시키는 시퀀스 (SEQ_PCODE)
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5
NOCACHE;
-- 샘플데이터 추가
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시23', '삼성', 1400000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '아이폰14', '애플', 1300000, 10);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '대륙폰', '샤오미', 600000, 20);

COMMIT;

-- 2. 상품 입출고 상세 이력 테이블 (TB_PRODETAIL)
-- 어떤 상품이 어떤 날짜에 몇개가 입고 또는 출고가 되었는지에 대한 데이터를 기록하는 테이블

CREATE TABLE TB_PRODETAIL(
    DCODE NUMBER PRIMARY KEY,               --이력번호
    PCODE NUMBER REFERENCES TB_PRODUCT,     --상품번호
    PDATE DATE NOT NULL,                    -- 상품입출고일
    AMOUNT NUMBER NOT NULL,                 -- 입출고수량
    STATUS CHAR(6) CHECK(STATUS IN ('입고', '출고'))    -- 상태(입고/출고)
);    

-- 이력번호로 매번 새로운 번호 발생시켜서 들어갈 수 있게 도와주는 시퀀스 (SEQ_DCODE)
CREATE SEQUENCE SEQ_DCODE
NOCACHE;


-- 상품 입출고 구현하기!
/* 트리거를 사용하여 구현
-- TB_PRODETAIL 테이블에 INSERT 이벤트 발생 시
-- TB_PRODUCT 테이블에 매번 자동으로 재고수량 UPDATE 되게끔 트리거 정의.

-- 상품이 입고된 경우 => 해당 상품 찾아서 재고수량 증가 UPDATE
UPDATE TB_PRODUCT
SET STOCK = STOCK + 현재입고된수량(INSERT된 자료의 AMOUNT값)
WHERE PCODE = 입고된상품번호(INSERT된 자료의 PCODE값);

-- 상품이 출고된 경우 => 해당 상품 찾아서 재고수량 감소 UPDATE
UPDATE TB_PRODUCT
SET STOCK = STOCK - 현재출고된수량(INSERT된 자료의 AMOUNT값)
WHERE PCODE = 출고된상품번호(INSERT된 자료의 PCODE값);
*/

-- :NEW 써야함
CREATE OR REPLACE TRIGGER TRG_02
