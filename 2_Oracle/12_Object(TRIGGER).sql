/*
    * 트리거 (TRIGGER)
      : 지정한 테이블에 DML(INSERT, UPDATE, DELETE)문에 의해 변경사항이 있을 때 (테이블에 이벤트가 발생했을 때)
        자동으로 매번 실행할 내용을 미리 정의해 두는 것.
        
        ex) 회원 탈퇴 시 기존 회원테이블에 데이터 삭제(DELETE)하고, 
            탈퇴 회원 테이블에 데이터 추가(INSERT)해야 할 때 자동으로 실행함
            
            신고횟수가 특정 값을 넘어갔을 때 해당 회원을 블랙리스트로 처리
            
            입출고에 대한 데이터를 기록할 때 해당 상품에 대한 재고 수량을 갱신해야 할 때
            
    * 트리거의 종류
        - SQL문의 실행 시기에 따른 분류
            + BEFORE TRIGGER : 지정한 테이블에 이벤트가 발생하기 전에 트리거 실행
            + AFTER TRIGGER  : 지정한 테이블에 이벤트가 발생한 후에 트리거 실행
        - SQL문에 의해 영향을 받는 각 행에 따른 분류
            + 문장 트리거    : 이벤트가 발생한 SQL문에 대해 딱 한 번만 트리거 실행
            + 행 트리거      : 해당 SQL문을 실행할 때마다 매번 트리거 실행
                                (옵션 중 FOR EACH ROW 설정해야 함)
                                
                                :OLD - BEFORE UPDATE(수정 전 자료), BEFORE DELETE (삭제 전 자료)
                                :NEW - AFTER INSERT(추가 된 자료), AFTER UPDATE (수정 후 자료)
                                
    * 트리거 구조( 생성 구문 )
        CREATE [OR REPLACE] TRIGGER 이름 
        BEFORE|AFTER INSERT|UPDATE|DELETE ON 테이블명
        [FOR EACH ROW]
        [DECLARE] -- 변수 및 상수 선언, 초기화
        BEGIN     -- 실행부 (SQL문, 조건문, 반복문, ...)
                  -- 이벤트 발생 시 자동으로 처리할 구문
        [EXCEPTION] -- 예외처리부
        END;
        /    
*/
-- EMPLOYEE 테이블에 데이터가 추가될때마다 '신입사원님 환영합니다!' 출력
CREATE TRIGGER TRG_EMP
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN   
    DBMS_OUTPUT.PUT_LINE('신입사원님 환영합니다!');
END;
/
DROP TRIGGER TRG_EMP;



CREATE TRIGGER TRG_EMP
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
        DBMS_OUTPUT.PUT_LINE('신입사원님 환영합니다!');
END;
/

SELECT * FROM EMPLOYEE;


INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES (503, '이순신', '111111-1111111', 'D7', 'J7', SYSDATE);

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES (504, '김유신', '111111-1111111', 'D8', 'J7', SYSDATE);
--------------------------------------------------------------------------------
-- 상품입고 및 출고 관련

-- 1) 테이블, 시퀀스 생성
DROP TABLE TB_PRODUCT;
DROP TABLE TB_PRODETAIL;
DROP SEQUENCE SEQ_PCODE;
DROP SEQUENCE SEQ_DECODE;
-- 상품을 보관하기 위한 테이블
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY,       -- 상품번호
    PNAME VARCHAR2(30) NOT NULL,    -- 상품명
    BRAND VARCHAR2(30) NOT NULL,    -- 브랜드
    PRICE NUMBER,                   -- 상품가격
    STOCK NUMBER DEFAULT 0          -- 재고수량
);    

SELECT * FROM TB_PRODUCT;

-- 상품번호 컬럼에 사용할 시퀀스 ( 200번부터 시작, 5씩 증가, 캐시메모리X)
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5
NOCACHE;


-- 샘플 데이터 추가
INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '갤럭시S24', '샘송', 1300000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '아이폰15', '사과', 1900000, 10);
INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '대륙폰', '샤우미', 700000, 30);

COMMIT;     -- DB에 반영


-- 상품 입출고 상세 이력 테이블
CREATE TABLE TB_PRODETAIL (
    DECODE NUMBER CONSTRAINT PK PRIMARY KEY,          -- 이력 번호
    PCODE NUMBER CONSTRAINT FOREIGNK REFERENCES TB_PRODUCT ON DELETE CASCADE, -- 상품 번호
    PDATE DATE NOT NULL,                -- 입출고일
    AMOUNT NUMBER NOT NULL,             -- 입출고수량
    STATUS CHAR(6) CHECK(STATUS IN ('입고', '출고'))    -- 상태
);
-- TB_PRODETAIL 테이블의 DECODE 컬럼에 대한 시퀀스 (SEQ_DECODE) - 캐시메모리X
CREATE SEQUENCE SEQ_DECODE 
NOCACHE;

-- TB_PRODETAIL (200번 상품, 오늘날짜, 10개 입고) 데이터 추가
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 200, SYSDATE, 10, '입고');

-- TB_PRODUCT 입고된 상품의 재고 업데이트
UPDATE TB_PRODUCT
SET STOCK = STOCK + 10
WHERE PCODE = 200;

COMMIT;

-- 205번 상품 오늘 날짜로 20개 입고
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 205, SYSDATE, 20, '입고');

UPDATE TB_PRODUCT
SET STOCK = STOCK + 10
WHERE PCODE = 200;

ROLLBACK;           -- 업데이트를 잘못해서 ROLLBACK;

INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 205, SYSDATE, 20, '입고');

UPDATE TB_PRODUCT
SET STOCK = STOCK + 20
WHERE PCODE = 205;

COMMIT;
------------------------------
-- TB_PRODETAIL 테이블에 INSERT 이벤트 발생 시
-- TB_PRODUCT 테이블에 매번 재고 수량 UPDATE => 자동으로 수행되게끔 트리거 생성
/*
        - UPDATE 조건
        
            * 상품이 입고된 경우 => 해당 상품을 찾아서 재고 수량 증가
                UPDATE TB_PRODUCT
                SET STOCK = STOCK + 입고수량(TB_PRODETAIL.AMOUNT)
                WHERE PCODE = 입고된상품번호(TB_PRODETAIL.PCODE)
            * 상품이 출고된 경우 => 해당 상품을 찾아서 재고 수량 감소
                UPDATE TB_PRODUCT
                SET STOCK = STOCK - 출고수량(TB_PRODETAIL.AMOUNT)
                WHERE PCODE = 출고된상품번호(TB_PRODETAIL.PCODE)
*/           
SELECT * FROM TB_PRODETAIL;
SELECT * FROM TB_PRODUCT;


CREATE TRIGGER TRG_PRO
AFTER INSERT ON TB_PRODETATIL
FOR EACH ROW
DECLARE
    STOCK TB_PRODUCT.STOCK%TYPE;
BEGIN
    IF :NEW.STATUS = '입고' THEN 
    UPDATE TB_PRODUCT
    SET STOCK = STOCK + :NEW.AMOUNT
    WHERE PCODE = :NEW.PCODE;
    ELSIF :NEW.STATUS = '출고' THEN
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
    IF :NEW.STATUS = '입고' THEN          -- 추가된 후 자료 이므로 :NEW를 통해 TB_PRODETAIL 테이블의 컬럼에 접근.
    UPDATE TB_PRODUCT
    SET STOCK = STOCK + :NEW.AMOUNT
    WHERE PCODE = :NEW.PCODE;
    END IF;
    IF :NEW.STATUS = '출고' THEN
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

    IF :NEW.STATUS = '입고' THEN          -- 추가된 후 자료 이므로 :NEW를 통해 TB_PRODETAIL 테이블의 컬럼에 접근.
        UPDSTOCK := ORGSTOCK + :NEW.AMOUNT;
    END IF;
    IF :NEW.STATUS = '출고' THEN
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
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 210, SYSDATE, 7, '출고');
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 200, SYSDATE, 10, '출고');
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 210, SYSDATE, 7, '입고');


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










