/*
    * 시퀀스  (SEQUENCE)
     : 자동으로 번호를 발생시켜주는 역할을 하는 객체
       정수 값을 순차적으로 일정값씩 증가시키면서 생성.
       
       ex) 회원번호, 학번, 사번, ... (기본키)
*/
/*
    - 시퀀스 생성 방법
    
        CREATE SEQUENCE 시퀀스명
        [START WITH 시작숫자]        --> 처음 발생시킬 시작 값 지정. (기본값 : 1)
        [INCREMENT BY 숫자]         --> 얼마씩 증가시킬지에 대한 값 (기본값 : 1)
        [MAXVALUE 숫자]             --> 최대값 (기본값: ... 셀 수 없을만큼 큼..)
        [MINVALUE 숫자]             --> 최소값 (기본값: 1)
        [CYCLE | NOCYCLE]           --> 값 순환여부 지정 (기본값: NOCYCLE)
        [NOCACHE | CACHE 바이트크기] --> 캐시메모리 할당 (기본값: CACHE 20)
        
            * 캐시메모리 : 미리 발생될 값들을 생성해서 저장해두는 공간.
                          매번 호출될 때마다 새로 번호를 생성하는 게 아니라
                          캐시 메모리 공간에 미리 생성된 값들을 가져다 쓸 수 있는 것. (속도가 빠름)
                          - 접속을 해제하면, 캐시메모리에 미리 만들어 둔 번호들은 다 날아감!
            
      [참고] 
      - 이름을 지어줄 때 참고
         * 테이블 : TB_XXX
         * 뷰    : VW_XXX
         * 시퀀스 : SEQ_XXX
         * 트리거 : TRG_XXX
*/
-- SEQ_TEST 라는 이름의 시퀀스를 생성해보자.
CREATE SEQUENCE SEQ_TEST;
--  *--------------------------------------------------
--  시퀀스 목록 조회   (현재 사용자가 소유하고 있는 시퀀스)
SELECT * FROM USER_SEQUENCES;
--  *--------------------------------------------------

-- SEQ_EMPNO 라는 이름의 시퀀스를 생성하는데,
--  300부터 시작하고 5씩 증가하며 최대값이 310. 순환하지 않고 캐시메모리도 사용하지 않음.
CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCACHE;
--------------------------------------------------------------------------------
/*
    - 시퀀스 사용
    
        + 시퀀스명.CURRVAL : 현재 시퀀스 값 ( 마지막으로 성공한 NEXTVAL의 수행한 값 )
        + 시퀀스명.NEXTVAL : 시퀀스 값에 일정 값을 증가시켜 발생한 값
                            -> 현재 시퀀스 값 + (INCREMENT BY 값)
*/    
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 오류 발생! NEXTVAL 사용하기 전에 CURRVAL 사용하면 오류가 발생.

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 오류 발생. MAXVALUE인 310에서 더 이상 증가할 수 없기 때문.
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 310
--------------------------------------------------------------------------------
/*
    - 시퀀스 구조 변경 (ALTER)
    
    [표현식]
            ALTER SEQUENCE 시퀀스명
            [INCREMENT BY 숫자]       -- 증가시킬 값 (기본값: 1)
            [MAXVALUE 숫자]           -- 최대값 (기본값: .. 셀 수 없을 정도로 큼..)
            [MINVALUE 숫자]           -- 최소값 (기본값: 1)
            [CYCLE | NOCYCLE]        -- 값의 순환여부 (기본값 : NOCYCLE)
            [NOCACHE | CACHE 바이트크기] -- 캐시메모리 사용여부 (기본값 : CACHE 20)
            
            * START WITH (시작숫자) 는 변경이 불가!
*/
-- SEQ_EMPNO 설정 중 증가 값을 10으로 변경하고, 최대값을 400으로 변경.
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;     -- 여전히 오류가 발생중

ALTER SEQUENCE SEQ_EMPNO
INCREMENT BY 10
MAXVALUE 400;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;     -- 최대값 변경 후 320. (기존 마지막 시퀀스 값 : 310)

-- 시퀀스 삭제 : DROP SEQUENCE 시퀀스명;
DROP SEQUENCE SEQ_EMPNO;

SELECT * FROM USER_SEQUENCES;
--------------------------------------------------------------------------------
/*
        - EMPLOYEE 테이블에 시퀀스 적용해보기.
                * 시퀀스 사용 컬럼: 사원번호 (EMP_ID)
        시퀀스 사용법 : 시퀀스 이름.NEXTVAL        
*/
-- 시퀀스 생성
CREATE SEQUENCE SEQ_EID
   START WITH 400     -- 시작번호 400
   NOCACHE;            -- 캐시메모리 사용하지 않음

-- 데이터 추가 시 시퀀스 사용 (NEXTVAL)
INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
VALUES (SEQ_EID.NEXTVAL, '홍길순', '111111-2111111', 'J3', SYSDATE);

SELECT * FROM EMPLOYEE;






