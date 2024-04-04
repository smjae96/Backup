/*
        함수 (FUNCTION)   : 전달된 컬럼 값을 사용하여 함수를 실행한 결과를 반환
        
        - 단일행 함수
            : N개의 값을 읽어들여서 N개의 결과값을 반환 (매 행마다 함수 실행결과를 반환)
        - 그룹 함수
            : N개의 값을 읽어들여서 1개의 결과값을 반환 (그룹 지어서 그룹 별로 함수 실행결과를 반환)
            
        => SELECT 절에 단일행 함수랑 그룹함수를 함께 사용 할 수 없음!!
           결과 행의 개수가 다르기 때문
           
        => 함수식 사용 위치 : SELECT절, WHERE절, ORDER BY절, GROUP BY절, HAVING절   
*/          
-- ================================ 단일행 함수 ========================================
/* 
    <문자 처리 함수> : CHAR, VARCHAR, .. 
    
    * 글자 수 반환 : LENGTH / LENGTHB    => 결과 값 NUMBER 타입(숫자)
        - LENGTH(컬럼명 | '문자열 값') : 해당 문자열의 글자 수 
        - LENGTHB(컬럼명 | '문자열 값') : 해당 문자열의 바이트 수 
        
            + 영문자, 숫자, 특수문자 : 1byte
            + 한글 ('박' , '이', 'ㅎ') : 3byte
*/
-- 가상 테이블 역할 : DUAL
SELECT LENGTH('오라클'), LENGTHB('오라클') || 'byte'
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE') || 'byte' -- 함수 사용 시 대소문자 상관없다!
FROM DUAL;

-- 직원 테이블에서 직원명의 글자 수와 바이트 수, 이메일의 글자 수, 바이트 수
SELECT EMP_NAME , LENGTH(EMP_NAME) "직원명의 글자 수", LENGTHB(EMP_NAME)||'byte' "직원명의 바이트 수"
        , EMAIL, LENGTH(EMAIL) "이메일의 글자 수", LENGTHB(EMAIL)||'byte' "이메일의 바이트 수"
FROM EMPLOYEE;
---------------------------------------------------------------------------------------------------
/*
    * INSTR : 문자열에 특정 문자의 시작위치를 찾아서 반환
    
    INSTR(컬럼명 | '문자열 값', '찾고자하는 문자', [찾을_위치_시작_값(1), [찾고자 하는 문자의 순번(1)]])
    => 결과 값은 NUMBER타입(숫자). 해당 문자의 위치 값.
    
    - 찾을 위치의 시작 값
        * 1 : 앞에서부터 찾기
        * -1 : 뒤에서부터 찾기
*/    
-- 테스트 문자열 : AABAACAABAA / 가상 테이블 : DUAL
--  * B 문자 위치 찾기
--  **오라클은 1부터 시작**
SELECT INSTR('AABAACAABAA', 'B') FROM DUAL;  -- 3번째 위치
-- => 시작위치 : 1, 순번 : 1

-- * B 문자를 뒤에서부터 찾기
--   => 뒤에서부터 찾은 뒤, 위치는 문자열 첫번째 위치가 기준이 되어 결과가 반환
SELECT INSTR('AABAACAABAA', 'B', -1) FROM DUAL; -- 9번째 위치

-- * B 문자를 앞에서부터 찾는데, 2번째로 찾은 위치
SELECT INSTR('AABAACAABAA', 'B', 1, 2) FROM DUAL;   -- 9번째 위치(앞에서부터 찾았을 때 두번째 B의 위치)

-- * B 문자를 뒤에서부터 찾는데, 2번째로 찾은 위치
SELECT INSTR('AABAACAABAA', 'B', -1, 2) FROM DUAL;  -- 3번째 위치 (뒤에서부터 찾았을 때 두번째 B의 위치)

-- * B 문자를 뒤에서부터 찾는데, 3번째로 찾은 위치
SELECT INSTR('AABAACAABAA', 'B', -1, 3) FROM DUAL;  -- 0번째 위치 => 조건에 맞는 위치를 찾지 못했다.
-- 뒤에서부터 3번째 위치에 있는 'B' 값은 없다!

-- 직원 테이블에서 이메일, 이메일 내 '_' 첫번째로 찾은 위치, '@' 문자의 위치 조회
SELECT EMAIL, INSTR(EMAIL, '_', 1, 1) "_ 위치" , INSTR(EMAIL, '@') "@ 위치"
FROM EMPLOYEE;
--------------------------------------------------------------------------------
/*
    * SUBSTR : 문자열에서 특정 문자열을 추출해서 반환
    
    SUBSTR(컬럼명 | '문자열 값', 시작위치, 추출할_문자_개수) => 결과 값이 character타입(문자)
    - 추출할_문자_개수 부분을 생략할 경우 끝까지 추출한다.
    
    -   시작위치 : -값을 줄 수 있다.  (뒤에서부터 시작위치를 찾는 것)
*/
-- 샘플 데이터 : 'This too shall pass.' -- 이 또한 지나가리라.
SELECT SUBSTR('This too shall pass', 10) FROM DUAL;     -- 결과: shal pass
SELECT SUBSTR('This too shall pass', 6,3) from dual;    -- 결과: too

SELECT SUBSTR('This too shall pass', -11, 3) FROM DUAL; -- 결과: sha

-- 직원 테이블에서 사원명, 사원 주민번호, 성별 (해당 위치의 값) 조회
SELECT EMP_NAME, EMP_NO,SUBSTR(EMP_NO, 8, 1) 성별
FROM EMPLOYEE;

-- 여자 사원들만 조회
SELECT EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '남', '3' , '남', '2', '여', '4', '여') 성별
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1)= '2' OR SUBSTR(EMP_NO, 8, 1) = '4';



-- 남자 사원들만 조회
SELECT EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '남', '3' , '남', '2', '여', '4', '여') 성별
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

-- 'smjae96@gmail.com'
-- 직원 테이블 직원명, 이메일, 이메일 아이디 모든 데이터 조회
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1 ) "이메일 아이디"
FROM EMPLOYEE;

----------------------------------------------------------------------------------------

/*
    * LPAD / RPAD : 문자열을 조회할 때 통일감 있게 조회하고자 할 때 사용
    
    RPAD(컬럼명 | '문자열 값', 최종적으로_반환할_문자열의_길이, [덧붙이고자 하는 문자(공백)])
    =>  결과 값 CHARACTER타입 (문자)
    LPAD( ...
    
    - 문자열에 덧붙이고자 하는 문자를 왼쪽 또는 오른쪽에 추가하여 최종 N 길이의 문자열 반환
*/    
-- 전체 직원의 직원명, 이메일 조회 (이메일 데이터의 경우 총 길이를 20으로 두고, 오른쪽 정렬)
SELECT EMP_NAME, LPAD(EMAIL, 20) 이메일 FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL, 20, '#') 이메일 FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(EMAIL, 20, '#') 이메일 FROM EMPLOYEE;

-- 샘플 데이터 : '870927-1' => '870927-1******'  | 가상 테이블: DUAL
SELECT RPAD('870927-1', 14, '*') FROM DUAL;

-- 직원 테이블에서 직원명, 주민번호를 모든 데이터 조회 (주민번호 뒷번호 첫번째까지만 표시, 나머지는 *로 표시)
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') 주민번호 
FROM EMPLOYEE;

-- 뒷번호를 다 가리고 싶으면...? // 연결연산자(||) 사용하는 방법도 있음.
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 7) || '*******' "주민번호" 
FROM EMPLOYEE;
--------------------------------------------------------------------------------
/*
   * LTRIM / RTRIM : 문자열에서 특정 문자를 제거한 나머지를 반환
   
   LTRIM(컬럼명 | '문자열 값', [제거하고자 하는 문자(공백)]) => 결과 값 CHARACTER타입(문자)
   RTRIM(...
   
   - 문자열의 왼쪽 또는 오른쪽에서 제거하고자 하는 문자들을 제거한 뒤 나머지 문자열을 반환
*/    
SELECT LTRIM('        K   H   ') FROM DUAL; -- 제거하고자 하는 문자를 입력하지 않으면 공백이 제거됨.

SELECT LTRIM('321321123123K123H123', '123') FROM DUAL;

SELECT LTRIM('ACABACCKH', 'ABC') FROM DUAL; -- 제시한 문자는 문자열이 아니라 문자들

/*
    * TRIM : 문자열의 앞/뒤/양쪽에 있는 특정 문자를 제거한 나머지 문자열을 반환
    
    TRIM(컬럼명 | '문자열 값')     -- 양쪽에서 공백 제거
    TRIM(특정문자 FROM 문자열)     -- 문자열에서 특정 문자를 양쪽에서 제거
    TRIM([LEADING | TRAILING | BOTH] 특정문자 FROM 문자열)
        * LEADING : 앞에서 특정 문자 제거 => LTRIM 유사
        * TRAILING : 뒤에서 특정 문자 제거 => RTRIM 유사
        * BOTH : 양쪽에서 특정 문자 제거 => 키워드 생략 시 적용(기본값)
*/
SELECT TRIM('       K   H   ') as 테스트 FROM DUAL;

SELECT TRIM('Z' FROM 'ZZZZZZZZZZZZkhZZZZZZZZZZZ') FROM DUAL;

SELECT TRIM(LEADING 'Z' FROM 'ZZZZZZZZZZZZkhZZZZZZZZZZZ') FROM DUAL;

SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZZZZZZZZkhZZZZZZZZZZZ') FROM DUAL;

SELECT TRIM(BOTH 'Z' FROM 'ZZZZZZZZZZZZkhZZZZZZZZZZZ') FROM DUAL;
--------------------------------------------------------------------------------
/*
    * 대/소문자 변환 관련 함수 : LOWER / UPPER / INITCAP
    
            LOWER|UPPER|INITCAP(컬럼명 | '문자열 값') => 결과 값은 CHARACTER 타입
            - LOWER : 문자열의 모든 문자를 소문자로 변환하여 반환
            - UPPER : 문자열의 모든 문자를 대문자로 변환하여 반환
            - INITCAP : 띄어쓰기를 기준으로 첫 글자마다 대문자로 변환하여 반환
*/    
-- 'This too shall pass.' | 가상 테이블: DUAL
SELECT LOWER('This too shall pass.') "소문자 변환"
FROM DUAL;

SELECT UPPER('This too shall pass.') "대문자 변환"
FROM DUAL;

SELECT INITCAP('This too shall pass.') "띄어쓰기 기준 첫 글자 대문자 변환"
FROM DUAL;
--------------------------------------------------------------------------------
/*
    * CONCAT : 문자열 두 개를 전달받아 하나로 합친 후 결과 반환
    
    CONCAT(문자열A, 문자열B) => 결과값 CHARACTER타입(문자)
*/
SELECT CONCAT('집에', ' 가고싶다') "CONCAT_TEST"
FROM DUAL;

SELECT '집에' || ' 가고싶다' "연결연산자 사용" FROM DUAL;
--------------------------------------------------------------------------------
/*
    * REPLACE : 문자열 내에서 특정 문자열을 제시한 문자열로 변환하여 리턴
        => 결과 값은 CHARACTER타입 (문자)
        
    REPLACE(문자열|컬럼, 특정_문자열, 제시한_문자열)    
        - 특정_문자열: 변환 전 문자열
        - 제시한_문자열: 변환 할 문자열
    + 데이터 수정 시에는 주의할 필요가 있다! ("변환 전 문자열" 모두 바뀌기 때문에)    
*/
-- 이메일 주소에서 'KH.or.kr' 이 부분을 'gmail.com'으로 변환하여 조회
SELECT EMP_NAME, EMAIL FROM EMPLOYEE;

SELECT EMP_NAME, EMAIL, REPLACE(EMAIL, 'KH.or.kr' , 'gmail.com') 
FROM EMPLOYEE;

--==============================================================================
/*
    *숫자 관련 함수
    
    - ABS : 숫자의 절대값을 구해주는 함수
    
    ABS(숫자_데이터 | 컬럼) => 결과 값 NUMBER타입 (숫자)
*/    
SELECT ABS(-10) "-10의 절대값" FROM DUAL;
SELECT ABS(-3.14) "-3.14의 절대값" FROM DUAL;
--------------------------------------------------------------------------------
/*
    - MOD : 두 수를 나눈 나머지 값을 반환해주는 함수
    
    MOD(숫자_데이터1, 숫자_데이터2) => 결과 값 NUMBER타입(숫자)
*/
SELECT MOD(10, 3) "10을 3으로 나눈 나머지" FROM DUAL;   -- 결과: 1
SELECT MOD(3, 10) "3을 10으로 나눈 나머지" FROM DUAL;   -- 결과: 3
SELECT MOD(10.5, 3) "10.5를 3으로 나눈 나머지" FROM DUAL;   -- 결과: 1.5
--------------------------------------------------------------------------------
/*
        - ROUND : 반올림한 결과를 반환 => 결과 값 NUMBER타입(숫자)
        
        ROUND(숫자_데이터, [소수점 위치(0)])
*/        
SELECT ROUND(123.456) FROM DUAL;    -- 소수점 위치 생략 -> 0이 기본 값
SELECT ROUND(123.456, 1) FROM DUAL; -- 결과: 123.5
SELECT ROUND(123.456, -1) FROM DUAL;    -- 결과: 120

/*
    - CEIL : 올림처리를 해서 반환
        * 소수점을 제거하면서 올림 처리
    CEIL(숫자_데이터)
*/    
SELECT CEIL(123.456) FROM DUAL;     -- 결과: 124

/*
    - FLOOR : 버림 처리를 하는 함수
        * 소수점을 제거하면서 버림(내림) 처리
        * 소수점을 제거하고 작은 값을 반환 (음수일 때 사용 주의)
    FLOOR(숫자_데이터)
*/
SELECT FLOOR(123.456) FROM DUAL;    -- 결과: 123
SELECT FLOOR(-3.14) FROM DUAL;  -- 결과: -4
/* 
    - TRUNC : 버림 처리를 하는 함수
        * 위치를 지정할 수 있음
    TRUNC(숫자_데이터, [위치])
*/    
SELECT TRUNC(123.456) FROM DUAL; -- 결과: 123
SELECT TRUNC(123.456,1) FROM DUAL; -- 결과: 123.4
SELECT TRUNC(123.456, -1) FROM DUAL; -- 결과: 120
SELECT TRUNC(-3.14) FROM DUAL;  -- 결과: -3
-- =============================================================================

/*
    * 날짜 관련 함수
    
    - SYSDATE : 시스템의 현재 날짜 및 시간을 반환
    
*/  
SELECT SYSDATE FROM DUAL;   -- 현재 날짜 조회 : YY/MM/DD 형식으로 조회됨.

/*

    - MONTHS_BETWEEN 두 날짜 사이의 개월 수
    
    MONTHS_BETWEEN(날짜A(DATE타입), 날짜B(DATE타입)) => 결과 값 NUMBER타입(숫자)
*/    
-- 직원 테이블에서 사원명, 입사일, 근무일수, 근무개월 수 조회
SELECT EMP_NAME 사원명, HIRE_DATE 입사일, ABS(TRUNC(SYSDATE-HIRE_DATE)) 근무일수, 
       CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))||'개월차' "근속개월"
FROM EMPLOYEE;

/* 
    - ADD_MONTH : 특정 날짜에 N개월 수를 더해서 반환
    
    ADD_MONTHS(특정_날짜, N) => 결과 값 DATE타입(날짜)
*/
SELECT ADD_MONTHS(SYSDATE, 5) "5개월뒤" 
FROM DUAL;

-- 직원 테이블에서 직원명, 입사일, 입사 후 3개월 뒤의 날짜 조회
SELECT EMP_NAME 직원명, HIRE_DATE 입사일, ADD_MONTHS(HIRE_DATE, 3) "수습 종료일"
FROM EMPLOYEE;

/*
    - NEXT_DAY : 특정 날짜 이후 가장 가까운 요일의 날짜를 반환
    
    NEXT_DAY(특정_날짜, 요일_정보)
    * 요일_정보
        + '월요일', '화요일', ... '일요일'
        + '월', '화', ... '일'
        + 1,2, ..., 7 : 1(일요일), ... 7(토요일)
        + 'MONDAY', 'TUESDAY', ... , 'SATURDAY'
*/
-- 언어 변경 : ALTER SESSION SET NLS_LANGUAGE = (국적);
-- * 한국어 : KOREAN, 영어 : AMERICAN
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
SELECT NEXT_DAY(SYSDATE, '금') FROM DUAL;

SELECT NEXT_DAY(SYSDATE, '금요일') FROM DUAL;

SELECT NEXT_DAY(SYSDATE, 6) FROM DUAL; -- 언어 상관 없이 사용 가능

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
SELECT NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE = KOREAN;

/*
    - LAST_DAY : 해당 월의 마지막 날짜를 반환해주는 함수
    
    LAST_DAY(날짜_데이터) => 결과 값은 DATE타입(날짜)
*/    
SELECT LAST_DAY(SYSDATE) "이번달의 마지막 날" FROM DUAL;

-- 직원테이블에서 직원명, 입사일, 입사한 달의 마지막 날, 입사한 달의 근무일 수 조회
SELECT EMP_NAME 직원명, HIRE_DATE "입사일", LAST_DAY(HIRE_DATE) "입사한 달의 마지막 날"
        , LAST_DAY(HIRE_DATE)-HIRE_DATE+1 "입사한 달의 근무일 수"
FROM EMPLOYEE;

/*
    -EXTRACT : 특정 날짜로부터 년도/월/일 에 해당하는 값을 추출
    
    + 연도 추출 : EXTRACT(YEAR FROM 특정_날짜)
    + 월 추출  : EXTRACT(MONTH FROM 특정_날짜)
    + 일 추출  : EXTRACT(DAY FROM 특정_날짜)
    => 결과 값은 NUMBER타입(숫자)
*/
-- 직원 정보에서 사원명, 입사년도, 입사월, 입사일을 조회 (입사년도>입사월>입사일 기준으로 정렬)
SELECT EMP_NAME 사원명, EXTRACT(YEAR FROM HIRE_DATE)입사년도, EXTRACT(MONTH FROM HIRE_DATE) 입사월,
        EXTRACT(DAY FROM HIRE_DATE) 입사일
FROM EMPLOYEE
ORDER BY 입사년도, 입사월, 입사일; -- 정렬 할 때는 별칭/컬럼 번호(순서)으로도 정렬 가능!
-- ORDER BY 2, 3, 4;

--==============================================================================

/*
    * 형변환 함수 : 데이터 타입을 변환해주는 함수 
*/    

/*
    - TO_CHAR : 숫자 또는 날짜 타입의 값을 문자 타입으로 변환해주는 함수
    
    TO_CHAR(숫자 또는 날짜 값(컬럼), [포맷]) => 결과 값이 CHARACTER타입(문자)
*/
-- 숫자 타입 -> 문자 타입
SELECT 1234 "숫자 타입", TO_CHAR(1234) "변환 후 데이터" FROM DUAL; -- 숫자는 오른쪽 정렬, 문자는 왼쪽 정렬됨.
--  5칸 공간을 확보, 오른쪽 정렬, 빈칸 공백
SELECT TO_CHAR(01234,'99999') "1234" FROM DUAL; -- 9 : 가변적인 처리 (맨 앞에 0이 있을 경우 제거)
SELECT TO_CHAR(1234, '00000') "1234" FROM DUAL; -- 0 : 확보된 공간만큼 값이 없을 경우 0으로 채움

-- 화폐
SELECT TO_CHAR(1234, 'L99999') "현재 화폐 단위" FROM DUAL; -- 현재 설정된 나라의 화폐 단위 (L: Local)
SELECT TO_CHAR(1234, '$99999') "달러 단위 표시" FROM DUAL;
--  123,456,789
SELECT TO_CHAR(123456789, '999,999,999') "세글자 씩 구분" FROM DUAL;

-- 직원 정보에서 사원명, 월급, 연봉 조회(원화 표시)
--  사원명 |   월급  |   연봉  |
--  홍길동 |4,000,000 | \50,000,000 |
SELECT EMP_NAME 사원명, TO_CHAR(SALARY, 'L999,999,999') "월급" ,
        TO_CHAR((SALARY*12), 'L999,999,999,999') "연봉"
FROM EMPLOYEE;

-- 날짜 타입 -> 문자 타입
-- 현재 날짜 조회
SELECT SYSDATE, TO_CHAR(SYSDATE) FROM DUAL;
-- (날짜) YYYY : 연도, MM : 월, DD : 일
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
-- (시간) HH : 시, MI : 분, SS : 초
SELECT SYSDATE, TO_CHAR(SYSDATE, 'HH:MI:SS') FROM DUAL;
-- 24시간 단위 : HH24
SELECT SYSDATE, TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL;

-- 직원 테이블에서 직원명, 입사일 (XXXX년 XX월 XX일) 조회
--      * 포맷 위치에는 정해진 형식만 사용 가능! 문자를 넣을 경우에는 끈따옴표("")로 묶어서 작성
SELECT EMP_NAME 직원명, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') 입사일 -- ""(큰따옴표)로 문자열 값을 넣어서 내가 원하는 형식대로 출력 가능.
FROM EMPLOYEE; 

-- 년도와 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'YYYY') ,
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR')         -- 해당 날짜의 연도를 영어로 조회
FROM DUAL;

-- 월에 관련된 포맷
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MON'),         -- 해당 월의 'X월' 형식으로 조회
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'RM')           -- 해당 월을 로마 숫자로 조회
FROM DUAL;       

-- 일에 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'DD'),          -- 이번 달의 몇 번째 일 수
       TO_CHAR(SYSDATE, 'DDD'),         -- 이번 해의 몇 번째 일 수 
       TO_CHAR(SYSDATE, 'D')            -- 이번 주의 몇 번째 일 수(요일 정보 1: 일요일, 2: 월요일, 3: 화요일 ... 7:토요일)
FROM DUAL;       

-- 요일에 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'DAY'),      -- X요일 : X요일 형식으로 조회
        TO_CHAR(SYSDATE, 'DY')       -- X   : 요일에 대한 한글자만 조회
FROM DUAL;
--------------------------------------------------------------------------------
/*
        *TO_DATE : 숫자 또는 문자타입의 데이터를 날짜타입 변환해주는 함수
        
        TO_DATE(숫자 또는 문자 데이터, [포맷]) => 결과 값 DATE타입(날짜)    
*/        
SELECT TO_DATE(20240124) FROM DUAL;     -- 숫자타입 -> 날짜타입
SELECT TO_DATE('20240124') FROM DUAL;   -- 문자타입 -> 날짜타입

--SELECT TO_DATE('20240124 140650')       -- 시간 데이터를 추가하면 포맷을 지정해야 함!
--SELECT TO_DATE('20240124 140650' , 'YYYYMMDD HH24MISS') -- 입력한 데이터 포맷을 지정.
--SELECT TO_CHAR(TO_DATE('140940' , 'HH24MISS'), 'HH:MI:SS')  -- 문자타입의 시간 데이터를 날짜타입으로 변환
                                             -- => TO_CHAR는 변환된 내용 확인용으로 사용함.
--SELECT TO_CHAR(TO_DATE('870124', 'YYMMDD'), 'YYYY-MM-DD')  -- 결과: 2087-01-24                                            
SELECT TO_CHAR(TO_DATE('870124', 'RRMMDD'), 'YYYY-MM-DD')    --50년 미만이면 20xx, 50년 이상이면 19xx으로 반환                                         
FROM DUAL;
-- =============================================================================
/*
    * TO_NUMBER: 문자 타입의 데이터를 숫자 타입으로 변환해주는 함수
    
    TO_NUMBER(문자_데이터, [포맷])
*/
SELECT '12345678', TO_NUMBER('12345678') FROM DUAL;

SELECT '100000' + '55000' FROM DUAL; -- 155000 (O) ? 10000055000 ? // 산술 연산시 숫자로 이루어진 문자타입이 숫자타입으로 자동형변환 됨!
SELECT '100,000' + '55,000' FROM DUAL; -- 실행 오류!
SELECT TO_CHAR(TO_NUMBER('100,000', '999,999') + TO_NUMBER('55,000' , '999,999'), '999,999') FROM DUAL;
-- =============================================================================
/* 
    * NULL 처리 함수 : 데이터 값이 null인 경우 처리해주는 함수
*/    
-- NVL : null 인 데이터 값을 다른 값으로 표시해주는 함수
--    NVL(컬럼, NULL인 경우 표시할 데이터(값))
SELECT EMP_NAME, SALARY, NVL(BONUS,0) BONUS FROM EMPLOYEE;
-- 직원명, 보너스 포함 연봉 조회 (보너스가 없는 경우에는 기본 연봉으로 조회)
SELECT EMP_NAME, NVL(SALARY*(1+BONUS)*12, SALARY*12) "보너스 포함 연봉"
FROM EMPLOYEE;

SELECT EMP_NAME, TO_CHAR((SALARY+ (SALARY*NVL(BONUS, 0)))*12, 'L999,999,999') "보너스 포함 연봉"
FROM EMPLOYEE;

-- 직원명, 부서코드 조회 (부서배치 받지 못한 직원은 "부서없음"으로 표시되도록 조회)
SELECT EMP_NAME, NVL(DEPT_CODE, '부서없음') "부서코드"
FROM EMPLOYEE;

-- NVL2 : 해당 컬럼에 값이 잇을 경우 A라는 값을 표시하고,
--                    값이 없을 경우(NULL인 경우) B라는 값을 표시해주는 함수
--      NVL2(컬럼, A, B)
SELECT EMP_NAME, SALARY, NVL2(BONUS, 'O', 'X') "보너스 유무" FROM EMPLOYEE;

SELECT EMP_NAME "직원명", NVL2(DEPT_CODE, '배정완료', '미배정') "부서배정여부" FROM EMPLOYEE;

-- NULLIF : 두 비교 대상의 값이 일치하면 NULL을 반환하고, 일치하지 않으면 첫번째 항목(비교대상1)을 반환
--  NULLIF(비교대상1, 비교대상2)
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;
--==============================================================================
/*
    * 선택 함수
        - DECODE(비교대상 컬럼_데이터, 비교값1, 결과값1, 비교값2, 결과값2, .... , 결과값N )
        
        @자바에서의 switch-case문과 유사
        switch(비교대상) {
            case 비교값1 :
                실행코드;
            case 비교값2 :
                실행코드;
        }        
*/
-- 직원 정보 사원번호, 사원명, 주민번호, 성별 조회
SELECT EMP_ID 사원번호, EMP_NAME 사원명, EMP_NO 주민번호, 
        DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '남', '2', '여', '3', '남', '4', '여', '외계인') 성별
FROM EMPLOYEE;

-- 직원의 급여 조회 시 부서별로 보너스 추가하여 연봉 조회
-- D1 : 보너스 + 0.05
-- D2 : 보너스 + 0.03
-- D5 : 보너스 + 0.02
SELECT EMP_NAME 사원명, DEPT_CODE 부서코드, DECODE(DEPT_CODE, 'D1', TO_CHAR(NVL(SALARY*12*(BONUS+0.05+1), SALARY*12*(1+0.05))), 'D2', TO_CHAR(NVL(SALARY*12*(BONUS+0.03+1), SALARY*12*(1+0.03))),
                'D3', TO_CHAR(NVL(SALARY*12*(BONUS+0.02+1), SALARY*12*(1+0.02))), TO_CHAR(NVL(SALARY*12*(BONUS+1), SALARY*12)))||'원' "연봉"
FROM EMPLOYEE
ORDER BY DEPT_CODE;

SELECT EMP_NAME 사원명, DEPT_CODE 부서코드, NVL(SALARY*(1+BONUS)*12, SALARY*12) "기존 연봉",
    (SALARY + (SALARY*(NVL(BONUS,0) + DECODE(DEPT_CODE, 'D1', 0.05, 'D2', 0.03, 'D5', 0.02, 0))))*12 "보너스 추가 연봉"
FROM EMPLOYEE;    

/*
    * CASE WHEN THEN
    
    CASE WHEN 조건식1 THEN 결과값1
         WHEN 조건식2 THEN 결과값2
         ...
         ELSE 결과값N
    END
    
    => 자바에서 if ~ else 와 유사
*/

-- 직원 월급 기준 500만원 이상 "고급", 350만원 이상 "중급", 그 이하는 "초급" 조회
SELECT EMP_NAME 사원명, TO_CHAR(SALARY, 'L999,999,999') "월급",
    CASE WHEN SALARY >= 5000000 THEN '고급'
         WHEN SALARY >= 3500000 THEN '중급'
         ELSE '초급'
    END "인력구분"
FROM EMPLOYEE;         
-- =============================================================================
/*
  * 그룹 함수 : N개의 값을 전달받아 1개의 결과를 반환해주는 함수  
*/    
-- 1) SUM(숫자타입의 컬럼) : 해당 값들의 총 합을 구하여 반환해주는 함수
--  * 직원들의 총 급여
SELECT SUM(SALARY) FROM EMPLOYEE;
-- * 남자직원들의 총 급여
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');
-- * 과장급 사원들의 총 급여 (JOB_CODE: J5)
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE JOB_CODE = 'J5';

-- 2) AVG(숫자타입의 컬럼) : 해당 값들의 평균을 구하여 반환해주는 함수
SELECT ROUND(AVG(SALARY)) FROM EMPLOYEE;

-- 3) 최대 값(MAX)  / 최소 값(MIN)
--    MAX(모든 타입 가능) : 내림차순 첫번째 데이터
--    MIN(모든 타입 가능) : 오름차순 첫번째 데이터
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE) FROM EMPLOYEE;

SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE) FROM EMPLOYEE;

-- 4) COUNT(*|컬럼|DISTINCT 컬럼) : 해당 조건에 맞는 행의 개수를 반환해주는 함수
-- 전체 사원 수
SELECT COUNT(*) FROM EMPLOYEE;
-- 여자 사원 수
SELECT COUNT(*) FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');
-- 보너스를 받은 직원 수
SELECT COUNT(*) FROM EMPLOYEE
WHERE BONUS IS NOT NULL;
-- 현재 사원들이 총 몇개의 부서에 분포되었는 지 조회
SELECT COUNT(DISTINCT DEPT_CODE) FROM EMPLOYEE; -- 개수를 셀 때 null은 제외된다.
















--======================== 개인 연습 ==============================
-- * 포괄조인(JOIN), 외부조인(JOIN)
SELECT * FROM EMPLOYEE ORDER BY DEPT_CODE;
SELECT * FROM DEPARTMENT;

-- ANSI 구문 (1)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- 부서 코드(DEPT_CODE, DEPT_ID)가 NULL이어도 EMPLOYEE 테이블의 정보는 무조건 출력

-- 오라클 전용 구문 (1)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+); -- 기준으로 삼고자 하는 테이블의 반대편 테이블의 컬럼 뒤에 (+) 붙인다.
                                -- 즉, EMPLOYEE 테이블을 기준으로 하고 싶으면, DEPARTMENT테이블의 컬럼인 DEPT_ID에 (+) 붙임.
-- ANSI 구문 (2)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- 부서 코드(DEPT_CODE, DEPT_ID)가 NULL이어도 DEPARTMENT 테이블의 정보는 무조건 출력됨.

-- 오라클 전용 구문 (2)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID; -- DEPARTMENT 테이블을 기준으로 하고 싶으면, EMPLOYEE테이블의 컬럼인 DEPT_CODE에 (+) 붙임.

-- FULL JOIN : 두 테이블이 가진 모든 행을 조회할 수 있음(단, 오라클 전용 구문은 안됨.)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID); -- 부서 코드(DEPT_CODE, DEPT_ID)가 NULL이어도 EMPLOYEE테이블과 DEPARTMENT 테이블의 정보 무조건 출력.


-- * CASE WHEN THEN 활용하기 
SELECT EMP_NAME, EMP_NO,
    CASE WHEN SUBSTR(EMP_NO, 8, 1) = '1' OR SUBSTR(EMP_NO, 8, 1) = '3' THEN '남자'
        WHEN SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4' THEN '여자'
        ELSE '외계인'
        END "성별"
FROM EMPLOYEE;    


SELECT JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

SELECT JOB_CODE , COUNT(*) "총 사원수", COUNT(BONUS) " 보너스를 받는 사원 수", 
        SUM(SALARY) 급여합, ROUND(AVG(SALARY)) 평균급여, MIN(SALARY) 최저급여, 
        MAX(SALARY) 최대급여
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

SELECT DEPT_CODE , COUNT(*), COUNT(BONUS), SUM(SALARY), ROUND(AVG(SALARY)),
        MIN(SALARY), MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY 1;

-- GROUP BY 절에 여러칼럼 기술 가능!
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;

-- HAVING 절 : 그룹에 대한 조건을 제시할 때 사용되는 구문. GROUP BY 와 WHERE 동시 사용 불가능하기 때문임!
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY)>= 3000000;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

-- 부서별 보너스를 받는 사원이 없는 부서만을 조회하는 부서코드, 보너스를 받는 사원의 수(0명) 조회
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

-- 비등가 조인문
-- > 오라클 전용구문
SELECT EMP_NAME, SALARY, MAX_SAL
FROM EMPLOYEE, SAL_GRADE
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

-- > ANSI 구문
SELECT EMP_NAME, SALARY, MAX_SAL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);

SELECT * FROM SAL_GRADE;

-- 자체조인(SELF JOIN) ?? 
-- 같은 테이블을 다시 한번 조인하는 경우
-- 전체 사원의 사번, 사원명, 사원부서코드 ==> EMPLOYEE E
-- 사수의 사번, 사수명, 사수부서코드 ==> EMPLOYEE M
-- > 오라클 전용 구문
SELECT E.EMP_ID 사원사번, E.EMP_NAME 사원이름, E.DEPT_CODE 사원부서코드,
        M.EMP_ID 사수사번, M.EMP_NAME 사수이름, M.DEPT_CODE 사수부서코드
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;


-- > ANSI 구문
SELECT E.EMP_ID 사원사번, E.EMP_NAME 사원이름, E.DEPT_CODE 사원부서코드,
        M.EMP_ID 사수사번, M.EMP_NAME 사수이름, M.DEPT_CODE 사수부서코드
FROM EMPLOYEE E
JOIN EMPLOYEE M ON(E.MANAGER_ID = M.EMP_ID);      -- LEFT JOIN 할 경우 사수가 없는 사람들도 모두 출력됨. 
                                                  -- RIGHT JOIN 할 경우 사수가 되지 못한 사람들도 모두 출력됨.
                                                     
-- 다중조인 : 2개 이상의 테이블을 가지고 JOIN 할 때
-- > 사번, 사원명, 부서명, 직급명 조회
SELECT * FROM EMPLOYEE; -- DEPT_CODE / JOB_CODE
SELECT * FROM DEPARTMENT; -- DEPT_ID
SELECT * FROM JOB;  -- JOB_CODE

-- >> 오라클 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE E.DEPT_CODE = DEPT_ID
AND E.JOB_CODE = J.JOB_CODE;

-- >> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE); -- 두 컬럼의 이름이 같을 경우 USING(컬럼명) 사용!

-- > 사번, 사원명, 부서명, 지역명 조회
SELECT * FROM EMPLOYEE;     // DEPT_CODE
SELECT * FROM DEPARTMENT;   // DEPT_ID / LOCATION_ID
SELECT * FROM LOCATION;     // LOCAL_CODE

-- >> 오라클 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE;

-- >> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON ( DEPT_CODE = DEPT_ID)
JOIN LOCATION ON ( LOCATION_ID = LOCAL_CODE);

-- 1. 사번, 사원명, 부서명, 지역명, 국가명 조회
SELECT * FROM EMPLOYEE;  -- DEPT_CODE
SELECT * FROM department;   -- DEPT_ID / LOCATION_ID
SELECT * FROM location; -- LOCAL_CODE / NATIONAL_CODE
SELECT * FROM national; -- NATIONAL_CODE
-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION L, NATIONAL N
WHERE DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE
AND L.NATIONAL_CODE = N.NATIONAL_CODE;

-->> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

-- 2. 사번, 사원명, 부서명(DEPT_TITLE), 직급명(JOB_NAME), 지역명(LOCAL_NAME), 국가명(NATIONAL_NAME) 조회
SELECT * FROM EMPLOYEE;     -- DEPT_CODE  // JOB_CODE
SELECT * FROM DEPARTMENT;   -- DEPT_ID  / LOCATION_ID
SELECT * FROM JOB;          -- JOB_CODE
SELECT * FROM LOCATION;     -- LOCAL_CODE // NATIONAL_CODE
SELECT * FROM NATIONAL;     -- NATIONAL_CODE
SELECT * FROM SAL_GRADE;

-- >> 오라클 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J, LOCATION L, NATIONAL N
WHERE E.DEPT_CODE = DEPT_ID
AND E.JOB_CODE = J.JOB_CODE
AND LOCATION_ID = LOCAL_CODE
AND L.NATIONAL_CODE = N.NATIONAL_CODE;

-- >> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

-- >> EMPLOYEE 테이블에서 이름, 연봉, 총수령액(보너스포함), 실수령액(총수령액 - (연봉*세금 3%)) 조회
SELECT EMP_NAME 이름, SALARY*12 연봉, NVL(SALARY*12*(1+BONUS), SALARY*12) 총수령액, 
NVL(SALARY*12*(1+BONUS)- (SALARY*12*0.03), SALARY*12-(SALARY*0.03)) 실수령액
FROM EMPLOYEE;

-- >> EMPLOYEE 테이블에서 실수령액이 5천만원 이상인 사원의 이름, 월급, 실수령액, 고용일 조회
SELECT EMP_NAME, SALARY, (SALARY+SALARY*NVL(BONUS,0))*12 - SALARY*12*0.03 "실수령액", HIRE_DATE
FROM EMPLOYEE
WHERE (SALARY+SALARY*NVL(BONUS,0))*12 - SALARY*12*0.03>= 50000000;

SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5','D9') AND HIRE_DATE < '2002/01/01';

SELECT EMP_NAME 사원명, SUBSTR(EMP_NO, 1, 2) 생년, SUBSTR(EMP_NO, 3, 2) 생월, SUBSTR(EMP_NO, 5, 2) 생일
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

SELECT *
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20;

SELECT EMP_NAME, TO_CHAR(SALARY, 'L999,999,999')
FROM EMPLOYEE;

SELECT EMP_NAME, DEPT_CODE, SUBSTR(EMP_NO, 1, 6)--TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'YYMMDD'), 'YY"년" MM"월" DD"일"')
FROM EMPLOYEE;

SELECT EMP_NAME, DEPT_CODE, TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,6),'YYMMDD'), 'YY"년" MM"월" DD"일"')
FROM EMPLOYEE;
SELECT *
FROM EMPLOYEE;