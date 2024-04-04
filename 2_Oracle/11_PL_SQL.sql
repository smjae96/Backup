/*
    * PL/SQL : PROCEDURE LANGUAGE EXTENSION TO SQL
    
    오라클에서 내장되어 있는 절차적 언어
    SQL문장 내에서 변수 정의, 조건(IF), 반복(FOR, WHILE) 등을 지원하여 SQL의 단점을 보완
    다수의 SQL문을 한번에 실행 가능
    
    * PL/SQL 구조
    
        [선언부]       : DECLARE 로 시작. 변수나 상수를 선언 및 초기화하는 부분
        실행부         : BEGIN으로 시작. SQL문이나 제어문(조건문, 반복문)등을 기술하는 부분
        [예외처리부]   : EXCEPTION로 시작. 예외 발생 시 해결하기 위한 구문을 미리 작성하는 부분  
*/
--  * 화면에 표시하기 설정
SET SERVEROUTPUT ON;

--  * 화면에 HELLO ORACLE 출력   DBMS_OUTPUT.PUT_LINE(출력할 내용);

BEGIN
    -- System.out.println("Hello world"); 
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE!');
END;
/
--------------------------------------------------------------------------------
/*
    1. DECLARE 선언부
        : 변수 또는 상수를 선언 하는 부분 ( 선언과 동시에 초기화 가능 )
        
        - (데이터)타입 선언 종류
          + 일반 타입
          + 래퍼런스 타입
          + ROW 타입
*/    
/*
    [1] 일반 타입 변수
        [표현식]
                변수명 [CONSTANT] 자료형 [:= 값]; 
                -- 상수 선언 시 CONSTANT 작성
                -- 초기화 시 ":= 값" 형식으로 작성
*/    
DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
    
BEGIN
    -- 변수에 값을 대입
    EID := 100;
    ENAME := '심재윤';
    
    -- EID, ENAME, PI 변수의 값을 출력
    -- 특정 문자와 변수를 같이 출력하고자 할 때는 연결연산자(||)
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID || ' ENAME : ' || ENAME || ' PI : ' || PI);
END;
/
-- 값을 입력받아 변수에 대입
DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    -- 값을 입력받을 때 '&대체변수명' 형식으로 작성
    EID := &번호;
    ENAME := '심재윤';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/
--------------------------------------------------------------------------------
/*
    [2] 래퍼런스 타입 변수
        : 어떤 테이블의 어떤 컬럼의 데이터타입을 참조해서 해당 타입으로 변수를 지정
        
        [표현식]
                변수명 테이블명.컬럼명%TYPE;
                
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    EID := 500;
    ENAME := '심재윤';
    SALARY := 5000000;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SALARY);
END;
/



DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    -- EMPLOYEE 테이블에서 사번이 200번인 사원의 사번, 사원명, 월급 조회
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SALARY      -- 각 컬럼의 결과 값을 변수에 대입.
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;        -- 사번을 입력받아 그 결과를 변수에 대입. 
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SALARY);
END;
/
----------------------------- 문제 ---------------------------------------------
/*
    래퍼런스 타입 변수로 EID, ENAME, JCODE, SAL, DTITLE을 선언하고
    각 자료형을 EMPLOYEE (EMP_ID, EMP_NAME, JOB_CODE, SALARY),
                DEPARTMENT(DEPT_TITLE) 등을 참조하도록 한 뒤
    사용자가 입력한 사번의 사원 정보를 조회하여 변수에 담아 출력            
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
    where emp_id = &사번;
    
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
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('직급코드 : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || DTITLE);

END;
/
--------------------------------------------------------------------------------
/*
    [3] ROW 타입 변수 선언
        : 테이블의 한 행에 대한 모든 컬럼값을 한꺼번에 담을 수 있는 변수
        
        [표현식]
                변수명 테이블명%ROWTYPE;
*/
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    -- 해당 사원의 사원명, 급여, 보너스 출력   (해당 데이터는 테이블의 컬럼명을 사용하여 출력할 수 있음)
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || E.SALARY);
    -- NULL 처리 함수를 사용.
    DBMS_OUTPUT.PUT_LINE('보너스 : ' || NVL(E.BONUS, 0));
END;
/
--------------------------------------------------------------------------------
/*
    2. BEGIN 실행부
    
    [1] 조건문
    
        - 단일 IF문: IF 조건식 THEN 실행내용 END IF;
        - IF ~ ELSE 문 : IF 조건식 THEN 실행내용 ELSE 실행내용 END IF;
        - IF ~ ELSIF 문 : IF 조건식1 THEN 실행내용1 ELSIF 조건식2 THEN 실행내용2 ... [ELSE 실행내용] END IF;
        - CASE ~ WHEN ~ THEN 문
            : CASE 비교대상 WHEN 동등비교값1 THEN 결과값1 WHEN 동등비교값2 THEN 결과값2 ... ELSE 결과값 END;
*/
-- 사번을 입력받은 후 해당 사원의 사번, 이름, 급여, 보너스율 출력
-- (IF ~ ELSE문) 보너스율이 0인 경우 "보너스를 받지 않는 사원이다."를 출력하고,
--                                      0이 아닌 경우 "보너스율 : .X"를 출력하자.
declare
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    salary employee.salary%type;
    bonus employee.bonus%type;
begin
    select emp_id, emp_name, salary, bonus
    into eid, ename, salary, bonus
    from employee
    where emp_id = &사번;
    
    if bonus = 0 then dbms_output.put_line('보너스를 받지 않는 사원이다.');
    else dbms_output.put_line('보너스율 : ' || bonus);
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
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    IF BONUS = 0 THEN DBMS_OUTPUT.PUT_LINE('보너스가 없는 사원입니다.');
    END IF;
    DBMS_OUTPUT.PUT_LINE('보너스율 : ' || BONUS);   
END;
/
-- (IF ~ ELSE문) 보너스율이 0인 경우 "보너스를 받지 않는 사원이다."를 출력하고,
--                                      0이 아닌 경우 "보너스율 : .X"를 출력하자.
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS,0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    IF BONUS = 0 THEN DBMS_OUTPUT.PUT_LINE('보너스를 받지 않는 사원이다.');
    ELSE DBMS_OUTPUT.PUT_LINE('보너스율 : 0' || BONUS);  
    END IF;
     
END;
/
--------------------------------------------------------------------------------
-- 실습문제
/*
    DECLARE
        -- 래퍼런스타입변수 (EID, ENAME, DTITLE, NCODE)
                    참조컬럼 (EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE)
        -- 일반타입변수 (TEAM 문자열) -- '국내팀' 또는 '해외팀' 저장할 예정
    BEGIN
        -- 사용자가 입력한 사번의 사원의 사번, 이름, 부서명, 근무국가코드 조회 후 변수에  대입
        
        -- 조건으로,, 
                NCODE 값이 KO일 경우 '국내팀'을 TEAM 변수에 대입
                          KO가 아닐 경우 '해외팀'을 TEAM 변수에 대입
        -- 출력 : 사번, 이름, 부서, 소속에 대해 출력
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
    where emp_id = &사번;
    
    if ncode = 'KO' THEN TEAM := '국내팀';
    ELSE TEAM := '해외팀';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID || ', 이름 : ' || ENAME || ', 부서 : ' || DTITLE || ', 소속 : ' || TEAM);
END;
/
    
    
SELECT * FROM NATIONAL;
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE "NATIONAL".NATIONAL_CODE%TYPE;        -- NATIONAL은 PL/SQL에서 따로 쓰는 방식이 있어서 NATIONAL 테이블로부터 컬럼을 참조할 때는 "NATIONAL"로 사용해주어야 한다.
    TEAM VARCHAR2(20);
    NNAME "NATIONAL".NATIONAL_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE, DECODE(NATIONAL_CODE, 'KO', '국내팀', '해외팀'), NATIONAL_NAME
    INTO EID, ENAME, DTITLE, NCODE, TEAM, NNAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE)
    WHERE EMP_ID = &사번;
    
    IF NCODE = 'KO' THEN TEAM:= '국내팀';
    ELSE TEAM:= '해외팀';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('부서 : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('소속 : ' || TEAM);
    DBMS_OUTPUT.PUT_LINE('국가명 : ' || NNAME);
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
    WHERE EMP_ID = &사번;
    
    
    TEAM:= '해외팀';
    
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('부서 : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('소속 : ' || TEAM);
    DBMS_OUTPUT.PUT_LINE('국가명 : ' || NNAME);
END;
/

--------------------------------------------------------------------------------
-- 사용자에게 점수를 입력받아 범위별로 학점을 출력
DECLARE
    SCORE NUMBER;
    GRADE CHAR(1);
BEGIN
    SCORE := &점수;
    
    -- 90점 이상 'A', 80점 이상 'B', 70점 이상 'C', 60점 이상 'D', 나머지는 'F'
    IF SCORE >=90 THEN GRADE := 'A';
    ELSIF SCORE>=80 THEN GRADE := 'B';
    ELSIF SCORE>=70 THEN GRADE := 'C';
    ELSIF SCORE>=60 THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('점수는 ' || SCORE || '이고, 학점은 ' || GRADE || '입니다.');
END;
/
----------------------------------------------------------------------------------
-- 사용자에게 사번을 입력받아 해당 사원의 급여를 조회하여
--      급여가 500만원 이상이면 '고급'
--      급여가 300만원 이상이면 '중급'
--          그 외에는 '초급'으로 등급을 분류하여
--  '해당 사원의 급여 등급은 XX입니다.' 출력할 수 있도록 작성해보자.
DECLARE
    SALARY EMPLOYEE.SALARY%TYPE;
    GRADE VARCHAR2(20);
BEGIN
    SELECT SALARY
    INTO SALARY
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    IF SALARY >= 5000000 THEN GRADE:= '고급';
    ELSIF SALARY >= 3000000 THEN GRADE:= '중급';
    ELSE GRADE:= '초급';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('해당 사원의 급여는 ' || SALARY || '원이고, 등급은 ' || GRADE || '입니다.');
END;
/



DECLARE
    SALARY EMPLOYEE.SALARY%TYPE;
    GRADE VARCHAR(20);
BEGIN
    SELECT SALARY
    INTO SALARY
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    IF SALARY >= 5000000 THEN GRADE := '고급';
    ELSIF SALARY >= 3000000 THEN GRADE := '중급';
    ELSE GRADE := '초급';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('해당 사원의 급여 등급은 ' ||GRADE ||'입니다.');
END;
/
--------------------------------------------------------------------------------
-- 사번을 입력받아 해당 사원의 부서코드를 기준으로 부서명을 출력. (JOIN 하지 않고)
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;

DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DTITLE VARCHAR2(50);
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DTITLE := CASE EMP.DEPT_CODE
            WHEN 'D1' THEN '인사관리부'
            WHEN 'D2' THEN '회계관리부'
            WHEN 'D3' THEN '마케팅부'
            WHEN 'D4' THEN '국내영업부'
            WHEN 'D5' THEN '해외영업1부'
            WHEN 'D6' THEN '해외영업2부'
            WHEN 'D7' THEN '해외영업3부'
            WHEN 'D8' THEN '기술지원부'
            WHEN 'D9' THEN '총무부'
            ELSE '부서없음'
            END;
            
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME ||' 사원의 부서명은 ' ||DTITLE || '입니다.');
END;
/



DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DTITLE VARCHAR2(50);    -- 문자타입의 데이터 대입할 예정
BEGIN
    SELECT * 
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DTITLE := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '인사관리부'
                WHEN 'D2' THEN '회계관리부'
                WHEN 'D3' THEN '마케팅부'
                WHEN 'D4' THEN '국내영업부'
                WHEN 'D5' THEN '해외영업1부'
                WHEN 'D6' THEN '해외영업2부'
                WHEN 'D7' THEN '해외영업3부'
                WHEN 'D8' THEN '기술지원부'
                WHEN 'D9' THEN '총무부'
                ELSE '부서 없음'
                END;
         DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME || '사원의 부서명은 ' || DTITLE || '입니다.');
END;
/
---------------------------------------------------------------------------------
/*
    [2] 반복문
    
        - 기본 구문 : LOOP 반복할 구문 * 반복문을 빠져나갈 구문 END LOOP;
            * 반복문을 빠져나갈 구문
                1) IF 조건식 THEN EXIT; END IF;
                2) EXIT WHEN 조건식; 
        - FOR LOOP문 :         
            FOR 변수 IN [REVERSE] 초기값..최종값
            LOOP 반복할 구문 [* 반복문을 빠져나갈 구문] END LOOP;
            * REVERSE : 최종값부터 초기값까지 반복
        - WHILE LOOP문 :
            WHILE 반복문이 수행될 조건식
            LOOP 반복할 구문 END LOOP;
*/        
-- 기본 구문
-- 'HELLO ORACLE!' 5번만 출력
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
-- FOR LOOP 문
BEGIN
    FOR I IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/

-- REVERSE 옵션 추가
BEGIN
    FOR I IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/
----------------------------------------
DROP TABLE TEST;

-- TEST 테이블 생성
CREATE TABLE TEST (
    TNO NUMBER PRIMARY KEY,
    TDATE DATE
);    
-- SEQ_TNO 시퀀스 생성

CREATE SEQUENCE SEQ_TNO 
INCREMENT BY 2
MAXVALUE 1000
NOCYCLE
NOCACHE;

-- TEST 테이블에 (TNO: 시퀀스를 사용 TDATE: 현재 날짜/시간) 100개 추가
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
-- 1부터 5까지 출력하기
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
    3. 예외처리부
        * 예외 (EXCEPTION) : 실행 중 발생하는 오류
        
    [표현식]    
            EXCEPTION
                WHEN 예외명1 THEN 예외처리구문1;
                WHEN 예외명2 THEN 예외처리구문2;
                ...
                WHEN OTHERS THEN 예외처리구문N;
                
            * 오라클에서 미리 정의한 예외들.. => 시스템 예외
                - NO_DATA_FOUND : 조회한 결과가 없을 때
                - TOO_MANY_ROWS : 조회한 결과가 여러 행일 때 (변수에 대입할 때..)
                - ZERO_DIVIDE   : 0으로 값을 나누려고 할 때
                - DUP_VAL_ON_INDEX : UNIQUE 조건에 위배될 때 (중복되는 경우)
                ...
*/
-- 사용자에게 숫자를 입력받아 10을 그 숫자로 나눈 결과를 출력해보자.
DECLARE
    RESULT NUMBER;
BEGIN
   RESULT := &숫자;
    
    DBMS_OUTPUT.PUT_LINE(10/RESULT);
EXCEPTION
    WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('0으로 나눌 수 없습니다.');
    
END;
/





DECLARE
    RESULT NUMBER;
BEGIN
    -- int result = 10 / x;
    RESULT := 10 /&숫자;
    DBMS_OUTPUT.PUT_LINE('결과는 ' || RESULT || '입니다.');
EXCEPTION
    -- WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('0으로는 나눌 수 없습니다.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('0으로는 나눌 수 없습니다.');
END;
/
-- EMPLOYEE 테이블에 EMP_ID 컬럼에 기본키(PRIMARY KEY) 설정 - UNIQUE + NOT NULL 설정
ALTER TABLE EMPLOYEE
ADD PRIMARY KEY(EMP_ID);

-- UNIQUE 조건

BEGIN
    UPDATE EMPLOYEE 
    SET EMP_ID = '&변경할사번'  -- => ' 사번200' --> 10BYTE 따라서 공백 없이 입력해 줘야 한다. 
                                                --      공백이 있으면 그 뒤로는 값으로 입력을 처리하기 때문
                                                --      & 뒤에는 공백이 없도록 해야 함.    
    WHERE EMP_NAME = '노옹철';
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('사번은 중복된 값이 들어갈 수 없습니다.');
END;
/
------------------------ 문제 ---------------------------------------------------
-- 사수의 사번을 입력받아 해당 사원의 사번, 이름을 출력해보자.
-- 사번 : XXX
-- 이름 : XXX
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EID, ENAME
    FROM EMPLOYEE
    WHERE MANAGER_ID = &사수사번;

    DBMS_OUTPUT.PUT_LINE('사번 : '|| EID || ', 이름 : ' ||ENAME);

EXCEPTION
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('해당 사수를 가진 사원이 없습니다.');
    WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('해당 사수를 가진 사원이 너무 많습니다.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('오류 발생');

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
    WHERE MANAGER_ID = '&사수사번';     -- 문자타입을 입력받을 때는 작은따옴표('')로 감싸준다.
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('해당 사수를 가진 사원이 없습니다.');
    WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('해당 사수를 가진 사원이 너무 많습니다.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('오류가 발생했습니다. 관리자에게 문의하십시오.');

END;
/
    
    

    










