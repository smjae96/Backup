/*
        �Լ� (FUNCTION)   : ���޵� �÷� ���� ����Ͽ� �Լ��� ������ ����� ��ȯ
        
        - ������ �Լ�
            : N���� ���� �о�鿩�� N���� ������� ��ȯ (�� �ึ�� �Լ� �������� ��ȯ)
        - �׷� �Լ�
            : N���� ���� �о�鿩�� 1���� ������� ��ȯ (�׷� ��� �׷� ���� �Լ� �������� ��ȯ)
            
        => SELECT ���� ������ �Լ��� �׷��Լ��� �Բ� ��� �� �� ����!!
           ��� ���� ������ �ٸ��� ����
           
        => �Լ��� ��� ��ġ : SELECT��, WHERE��, ORDER BY��, GROUP BY��, HAVING��   
*/          
-- ================================ ������ �Լ� ========================================
/* 
    <���� ó�� �Լ�> : CHAR, VARCHAR, .. 
    
    * ���� �� ��ȯ : LENGTH / LENGTHB    => ��� �� NUMBER Ÿ��(����)
        - LENGTH(�÷��� | '���ڿ� ��') : �ش� ���ڿ��� ���� �� 
        - LENGTHB(�÷��� | '���ڿ� ��') : �ش� ���ڿ��� ����Ʈ �� 
        
            + ������, ����, Ư������ : 1byte
            + �ѱ� ('��' , '��', '��') : 3byte
*/
-- ���� ���̺� ���� : DUAL
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ') || 'byte'
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE') || 'byte' -- �Լ� ��� �� ��ҹ��� �������!
FROM DUAL;

-- ���� ���̺��� �������� ���� ���� ����Ʈ ��, �̸����� ���� ��, ����Ʈ ��
SELECT EMP_NAME , LENGTH(EMP_NAME) "�������� ���� ��", LENGTHB(EMP_NAME)||'byte' "�������� ����Ʈ ��"
        , EMAIL, LENGTH(EMAIL) "�̸����� ���� ��", LENGTHB(EMAIL)||'byte' "�̸����� ����Ʈ ��"
FROM EMPLOYEE;
---------------------------------------------------------------------------------------------------
/*
    * INSTR : ���ڿ��� Ư�� ������ ������ġ�� ã�Ƽ� ��ȯ
    
    INSTR(�÷��� | '���ڿ� ��', 'ã�����ϴ� ����', [ã��_��ġ_����_��(1), [ã���� �ϴ� ������ ����(1)]])
    => ��� ���� NUMBERŸ��(����). �ش� ������ ��ġ ��.
    
    - ã�� ��ġ�� ���� ��
        * 1 : �տ������� ã��
        * -1 : �ڿ������� ã��
*/    
-- �׽�Ʈ ���ڿ� : AABAACAABAA / ���� ���̺� : DUAL
--  * B ���� ��ġ ã��
--  **����Ŭ�� 1���� ����**
SELECT INSTR('AABAACAABAA', 'B') FROM DUAL;  -- 3��° ��ġ
-- => ������ġ : 1, ���� : 1

-- * B ���ڸ� �ڿ������� ã��
--   => �ڿ������� ã�� ��, ��ġ�� ���ڿ� ù��° ��ġ�� ������ �Ǿ� ����� ��ȯ
SELECT INSTR('AABAACAABAA', 'B', -1) FROM DUAL; -- 9��° ��ġ

-- * B ���ڸ� �տ������� ã�µ�, 2��°�� ã�� ��ġ
SELECT INSTR('AABAACAABAA', 'B', 1, 2) FROM DUAL;   -- 9��° ��ġ(�տ������� ã���� �� �ι�° B�� ��ġ)

-- * B ���ڸ� �ڿ������� ã�µ�, 2��°�� ã�� ��ġ
SELECT INSTR('AABAACAABAA', 'B', -1, 2) FROM DUAL;  -- 3��° ��ġ (�ڿ������� ã���� �� �ι�° B�� ��ġ)

-- * B ���ڸ� �ڿ������� ã�µ�, 3��°�� ã�� ��ġ
SELECT INSTR('AABAACAABAA', 'B', -1, 3) FROM DUAL;  -- 0��° ��ġ => ���ǿ� �´� ��ġ�� ã�� ���ߴ�.
-- �ڿ������� 3��° ��ġ�� �ִ� 'B' ���� ����!

-- ���� ���̺��� �̸���, �̸��� �� '_' ù��°�� ã�� ��ġ, '@' ������ ��ġ ��ȸ
SELECT EMAIL, INSTR(EMAIL, '_', 1, 1) "_ ��ġ" , INSTR(EMAIL, '@') "@ ��ġ"
FROM EMPLOYEE;
--------------------------------------------------------------------------------
/*
    * SUBSTR : ���ڿ����� Ư�� ���ڿ��� �����ؼ� ��ȯ
    
    SUBSTR(�÷��� | '���ڿ� ��', ������ġ, ������_����_����) => ��� ���� characterŸ��(����)
    - ������_����_���� �κ��� ������ ��� ������ �����Ѵ�.
    
    -   ������ġ : -���� �� �� �ִ�.  (�ڿ������� ������ġ�� ã�� ��)
*/
-- ���� ������ : 'This too shall pass.' -- �� ���� ����������.
SELECT SUBSTR('This too shall pass', 10) FROM DUAL;     -- ���: shal pass
SELECT SUBSTR('This too shall pass', 6,3) from dual;    -- ���: too

SELECT SUBSTR('This too shall pass', -11, 3) FROM DUAL; -- ���: sha

-- ���� ���̺��� �����, ��� �ֹι�ȣ, ���� (�ش� ��ġ�� ��) ��ȸ
SELECT EMP_NAME, EMP_NO,SUBSTR(EMP_NO, 8, 1) ����
FROM EMPLOYEE;

-- ���� ����鸸 ��ȸ
SELECT EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '��', '3' , '��', '2', '��', '4', '��') ����
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1)= '2' OR SUBSTR(EMP_NO, 8, 1) = '4';



-- ���� ����鸸 ��ȸ
SELECT EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '��', '3' , '��', '2', '��', '4', '��') ����
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

-- 'smjae96@gmail.com'
-- ���� ���̺� ������, �̸���, �̸��� ���̵� ��� ������ ��ȸ
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1 ) "�̸��� ���̵�"
FROM EMPLOYEE;

----------------------------------------------------------------------------------------

/*
    * LPAD / RPAD : ���ڿ��� ��ȸ�� �� ���ϰ� �ְ� ��ȸ�ϰ��� �� �� ���
    
    RPAD(�÷��� | '���ڿ� ��', ����������_��ȯ��_���ڿ���_����, [�����̰��� �ϴ� ����(����)])
    =>  ��� �� CHARACTERŸ�� (����)
    LPAD( ...
    
    - ���ڿ��� �����̰��� �ϴ� ���ڸ� ���� �Ǵ� �����ʿ� �߰��Ͽ� ���� N ������ ���ڿ� ��ȯ
*/    
-- ��ü ������ ������, �̸��� ��ȸ (�̸��� �������� ��� �� ���̸� 20���� �ΰ�, ������ ����)
SELECT EMP_NAME, LPAD(EMAIL, 20) �̸��� FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL, 20, '#') �̸��� FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(EMAIL, 20, '#') �̸��� FROM EMPLOYEE;

-- ���� ������ : '870927-1' => '870927-1******'  | ���� ���̺�: DUAL
SELECT RPAD('870927-1', 14, '*') FROM DUAL;

-- ���� ���̺��� ������, �ֹι�ȣ�� ��� ������ ��ȸ (�ֹι�ȣ �޹�ȣ ù��°������ ǥ��, �������� *�� ǥ��)
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') �ֹι�ȣ 
FROM EMPLOYEE;

-- �޹�ȣ�� �� ������ ������...? // ���Ῥ����(||) ����ϴ� ����� ����.
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 7) || '*******' "�ֹι�ȣ" 
FROM EMPLOYEE;
--------------------------------------------------------------------------------
/*
   * LTRIM / RTRIM : ���ڿ����� Ư�� ���ڸ� ������ �������� ��ȯ
   
   LTRIM(�÷��� | '���ڿ� ��', [�����ϰ��� �ϴ� ����(����)]) => ��� �� CHARACTERŸ��(����)
   RTRIM(...
   
   - ���ڿ��� ���� �Ǵ� �����ʿ��� �����ϰ��� �ϴ� ���ڵ��� ������ �� ������ ���ڿ��� ��ȯ
*/    
SELECT LTRIM('        K   H   ') FROM DUAL; -- �����ϰ��� �ϴ� ���ڸ� �Է����� ������ ������ ���ŵ�.

SELECT LTRIM('321321123123K123H123', '123') FROM DUAL;

SELECT LTRIM('ACABACCKH', 'ABC') FROM DUAL; -- ������ ���ڴ� ���ڿ��� �ƴ϶� ���ڵ�

/*
    * TRIM : ���ڿ��� ��/��/���ʿ� �ִ� Ư�� ���ڸ� ������ ������ ���ڿ��� ��ȯ
    
    TRIM(�÷��� | '���ڿ� ��')     -- ���ʿ��� ���� ����
    TRIM(Ư������ FROM ���ڿ�)     -- ���ڿ����� Ư�� ���ڸ� ���ʿ��� ����
    TRIM([LEADING | TRAILING | BOTH] Ư������ FROM ���ڿ�)
        * LEADING : �տ��� Ư�� ���� ���� => LTRIM ����
        * TRAILING : �ڿ��� Ư�� ���� ���� => RTRIM ����
        * BOTH : ���ʿ��� Ư�� ���� ���� => Ű���� ���� �� ����(�⺻��)
*/
SELECT TRIM('       K   H   ') as �׽�Ʈ FROM DUAL;

SELECT TRIM('Z' FROM 'ZZZZZZZZZZZZkhZZZZZZZZZZZ') FROM DUAL;

SELECT TRIM(LEADING 'Z' FROM 'ZZZZZZZZZZZZkhZZZZZZZZZZZ') FROM DUAL;

SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZZZZZZZZkhZZZZZZZZZZZ') FROM DUAL;

SELECT TRIM(BOTH 'Z' FROM 'ZZZZZZZZZZZZkhZZZZZZZZZZZ') FROM DUAL;
--------------------------------------------------------------------------------
/*
    * ��/�ҹ��� ��ȯ ���� �Լ� : LOWER / UPPER / INITCAP
    
            LOWER|UPPER|INITCAP(�÷��� | '���ڿ� ��') => ��� ���� CHARACTER Ÿ��
            - LOWER : ���ڿ��� ��� ���ڸ� �ҹ��ڷ� ��ȯ�Ͽ� ��ȯ
            - UPPER : ���ڿ��� ��� ���ڸ� �빮�ڷ� ��ȯ�Ͽ� ��ȯ
            - INITCAP : ���⸦ �������� ù ���ڸ��� �빮�ڷ� ��ȯ�Ͽ� ��ȯ
*/    
-- 'This too shall pass.' | ���� ���̺�: DUAL
SELECT LOWER('This too shall pass.') "�ҹ��� ��ȯ"
FROM DUAL;

SELECT UPPER('This too shall pass.') "�빮�� ��ȯ"
FROM DUAL;

SELECT INITCAP('This too shall pass.') "���� ���� ù ���� �빮�� ��ȯ"
FROM DUAL;
--------------------------------------------------------------------------------
/*
    * CONCAT : ���ڿ� �� ���� ���޹޾� �ϳ��� ��ģ �� ��� ��ȯ
    
    CONCAT(���ڿ�A, ���ڿ�B) => ����� CHARACTERŸ��(����)
*/
SELECT CONCAT('����', ' ����ʹ�') "CONCAT_TEST"
FROM DUAL;

SELECT '����' || ' ����ʹ�' "���Ῥ���� ���" FROM DUAL;
--------------------------------------------------------------------------------
/*
    * REPLACE : ���ڿ� ������ Ư�� ���ڿ��� ������ ���ڿ��� ��ȯ�Ͽ� ����
        => ��� ���� CHARACTERŸ�� (����)
        
    REPLACE(���ڿ�|�÷�, Ư��_���ڿ�, ������_���ڿ�)    
        - Ư��_���ڿ�: ��ȯ �� ���ڿ�
        - ������_���ڿ�: ��ȯ �� ���ڿ�
    + ������ ���� �ÿ��� ������ �ʿ䰡 �ִ�! ("��ȯ �� ���ڿ�" ��� �ٲ�� ������)    
*/
-- �̸��� �ּҿ��� 'KH.or.kr' �� �κ��� 'gmail.com'���� ��ȯ�Ͽ� ��ȸ
SELECT EMP_NAME, EMAIL FROM EMPLOYEE;

SELECT EMP_NAME, EMAIL, REPLACE(EMAIL, 'KH.or.kr' , 'gmail.com') 
FROM EMPLOYEE;

--==============================================================================
/*
    *���� ���� �Լ�
    
    - ABS : ������ ���밪�� �����ִ� �Լ�
    
    ABS(����_������ | �÷�) => ��� �� NUMBERŸ�� (����)
*/    
SELECT ABS(-10) "-10�� ���밪" FROM DUAL;
SELECT ABS(-3.14) "-3.14�� ���밪" FROM DUAL;
--------------------------------------------------------------------------------
/*
    - MOD : �� ���� ���� ������ ���� ��ȯ���ִ� �Լ�
    
    MOD(����_������1, ����_������2) => ��� �� NUMBERŸ��(����)
*/
SELECT MOD(10, 3) "10�� 3���� ���� ������" FROM DUAL;   -- ���: 1
SELECT MOD(3, 10) "3�� 10���� ���� ������" FROM DUAL;   -- ���: 3
SELECT MOD(10.5, 3) "10.5�� 3���� ���� ������" FROM DUAL;   -- ���: 1.5
--------------------------------------------------------------------------------
/*
        - ROUND : �ݿø��� ����� ��ȯ => ��� �� NUMBERŸ��(����)
        
        ROUND(����_������, [�Ҽ��� ��ġ(0)])
*/        
SELECT ROUND(123.456) FROM DUAL;    -- �Ҽ��� ��ġ ���� -> 0�� �⺻ ��
SELECT ROUND(123.456, 1) FROM DUAL; -- ���: 123.5
SELECT ROUND(123.456, -1) FROM DUAL;    -- ���: 120

/*
    - CEIL : �ø�ó���� �ؼ� ��ȯ
        * �Ҽ����� �����ϸ鼭 �ø� ó��
    CEIL(����_������)
*/    
SELECT CEIL(123.456) FROM DUAL;     -- ���: 124

/*
    - FLOOR : ���� ó���� �ϴ� �Լ�
        * �Ҽ����� �����ϸ鼭 ����(����) ó��
        * �Ҽ����� �����ϰ� ���� ���� ��ȯ (������ �� ��� ����)
    FLOOR(����_������)
*/
SELECT FLOOR(123.456) FROM DUAL;    -- ���: 123
SELECT FLOOR(-3.14) FROM DUAL;  -- ���: -4
/* 
    - TRUNC : ���� ó���� �ϴ� �Լ�
        * ��ġ�� ������ �� ����
    TRUNC(����_������, [��ġ])
*/    
SELECT TRUNC(123.456) FROM DUAL; -- ���: 123
SELECT TRUNC(123.456,1) FROM DUAL; -- ���: 123.4
SELECT TRUNC(123.456, -1) FROM DUAL; -- ���: 120
SELECT TRUNC(-3.14) FROM DUAL;  -- ���: -3
-- =============================================================================

/*
    * ��¥ ���� �Լ�
    
    - SYSDATE : �ý����� ���� ��¥ �� �ð��� ��ȯ
    
*/  
SELECT SYSDATE FROM DUAL;   -- ���� ��¥ ��ȸ : YY/MM/DD �������� ��ȸ��.

/*

    - MONTHS_BETWEEN �� ��¥ ������ ���� ��
    
    MONTHS_BETWEEN(��¥A(DATEŸ��), ��¥B(DATEŸ��)) => ��� �� NUMBERŸ��(����)
*/    
-- ���� ���̺��� �����, �Ի���, �ٹ��ϼ�, �ٹ����� �� ��ȸ
SELECT EMP_NAME �����, HIRE_DATE �Ի���, ABS(TRUNC(SYSDATE-HIRE_DATE)) �ٹ��ϼ�, 
       CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))||'������' "�ټӰ���"
FROM EMPLOYEE;

/* 
    - ADD_MONTH : Ư�� ��¥�� N���� ���� ���ؼ� ��ȯ
    
    ADD_MONTHS(Ư��_��¥, N) => ��� �� DATEŸ��(��¥)
*/
SELECT ADD_MONTHS(SYSDATE, 5) "5������" 
FROM DUAL;

-- ���� ���̺��� ������, �Ի���, �Ի� �� 3���� ���� ��¥ ��ȸ
SELECT EMP_NAME ������, HIRE_DATE �Ի���, ADD_MONTHS(HIRE_DATE, 3) "���� ������"
FROM EMPLOYEE;

/*
    - NEXT_DAY : Ư�� ��¥ ���� ���� ����� ������ ��¥�� ��ȯ
    
    NEXT_DAY(Ư��_��¥, ����_����)
    * ����_����
        + '������', 'ȭ����', ... '�Ͽ���'
        + '��', 'ȭ', ... '��'
        + 1,2, ..., 7 : 1(�Ͽ���), ... 7(�����)
        + 'MONDAY', 'TUESDAY', ... , 'SATURDAY'
*/
-- ��� ���� : ALTER SESSION SET NLS_LANGUAGE = (����);
-- * �ѱ��� : KOREAN, ���� : AMERICAN
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL;

SELECT NEXT_DAY(SYSDATE, '�ݿ���') FROM DUAL;

SELECT NEXT_DAY(SYSDATE, 6) FROM DUAL; -- ��� ��� ���� ��� ����

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
SELECT NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE = KOREAN;

/*
    - LAST_DAY : �ش� ���� ������ ��¥�� ��ȯ���ִ� �Լ�
    
    LAST_DAY(��¥_������) => ��� ���� DATEŸ��(��¥)
*/    
SELECT LAST_DAY(SYSDATE) "�̹����� ������ ��" FROM DUAL;

-- �������̺��� ������, �Ի���, �Ի��� ���� ������ ��, �Ի��� ���� �ٹ��� �� ��ȸ
SELECT EMP_NAME ������, HIRE_DATE "�Ի���", LAST_DAY(HIRE_DATE) "�Ի��� ���� ������ ��"
        , LAST_DAY(HIRE_DATE)-HIRE_DATE+1 "�Ի��� ���� �ٹ��� ��"
FROM EMPLOYEE;

/*
    -EXTRACT : Ư�� ��¥�κ��� �⵵/��/�� �� �ش��ϴ� ���� ����
    
    + ���� ���� : EXTRACT(YEAR FROM Ư��_��¥)
    + �� ����  : EXTRACT(MONTH FROM Ư��_��¥)
    + �� ����  : EXTRACT(DAY FROM Ư��_��¥)
    => ��� ���� NUMBERŸ��(����)
*/
-- ���� �������� �����, �Ի�⵵, �Ի��, �Ի����� ��ȸ (�Ի�⵵>�Ի��>�Ի��� �������� ����)
SELECT EMP_NAME �����, EXTRACT(YEAR FROM HIRE_DATE)�Ի�⵵, EXTRACT(MONTH FROM HIRE_DATE) �Ի��,
        EXTRACT(DAY FROM HIRE_DATE) �Ի���
FROM EMPLOYEE
ORDER BY �Ի�⵵, �Ի��, �Ի���; -- ���� �� ���� ��Ī/�÷� ��ȣ(����)���ε� ���� ����!
-- ORDER BY 2, 3, 4;

--==============================================================================

/*
    * ����ȯ �Լ� : ������ Ÿ���� ��ȯ���ִ� �Լ� 
*/    

/*
    - TO_CHAR : ���� �Ǵ� ��¥ Ÿ���� ���� ���� Ÿ������ ��ȯ���ִ� �Լ�
    
    TO_CHAR(���� �Ǵ� ��¥ ��(�÷�), [����]) => ��� ���� CHARACTERŸ��(����)
*/
-- ���� Ÿ�� -> ���� Ÿ��
SELECT 1234 "���� Ÿ��", TO_CHAR(1234) "��ȯ �� ������" FROM DUAL; -- ���ڴ� ������ ����, ���ڴ� ���� ���ĵ�.
--  5ĭ ������ Ȯ��, ������ ����, ��ĭ ����
SELECT TO_CHAR(01234,'99999') "1234" FROM DUAL; -- 9 : �������� ó�� (�� �տ� 0�� ���� ��� ����)
SELECT TO_CHAR(1234, '00000') "1234" FROM DUAL; -- 0 : Ȯ���� ������ŭ ���� ���� ��� 0���� ä��

-- ȭ��
SELECT TO_CHAR(1234, 'L99999') "���� ȭ�� ����" FROM DUAL; -- ���� ������ ������ ȭ�� ���� (L: Local)
SELECT TO_CHAR(1234, '$99999') "�޷� ���� ǥ��" FROM DUAL;
--  123,456,789
SELECT TO_CHAR(123456789, '999,999,999') "������ �� ����" FROM DUAL;

-- ���� �������� �����, ����, ���� ��ȸ(��ȭ ǥ��)
--  ����� |   ����  |   ����  |
--  ȫ�浿 |4,000,000 | \50,000,000 |
SELECT EMP_NAME �����, TO_CHAR(SALARY, 'L999,999,999') "����" ,
        TO_CHAR((SALARY*12), 'L999,999,999,999') "����"
FROM EMPLOYEE;

-- ��¥ Ÿ�� -> ���� Ÿ��
-- ���� ��¥ ��ȸ
SELECT SYSDATE, TO_CHAR(SYSDATE) FROM DUAL;
-- (��¥) YYYY : ����, MM : ��, DD : ��
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
-- (�ð�) HH : ��, MI : ��, SS : ��
SELECT SYSDATE, TO_CHAR(SYSDATE, 'HH:MI:SS') FROM DUAL;
-- 24�ð� ���� : HH24
SELECT SYSDATE, TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL;

-- ���� ���̺��� ������, �Ի��� (XXXX�� XX�� XX��) ��ȸ
--      * ���� ��ġ���� ������ ���ĸ� ��� ����! ���ڸ� ���� ��쿡�� ������ǥ("")�� ��� �ۼ�
SELECT EMP_NAME ������, TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��"') �Ի��� -- ""(ū����ǥ)�� ���ڿ� ���� �־ ���� ���ϴ� ���Ĵ�� ��� ����.
FROM EMPLOYEE; 

-- �⵵�� ���õ� ����
SELECT TO_CHAR(SYSDATE, 'YYYY') ,
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR')         -- �ش� ��¥�� ������ ����� ��ȸ
FROM DUAL;

-- ���� ���õ� ����
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MON'),         -- �ش� ���� 'X��' �������� ��ȸ
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'RM')           -- �ش� ���� �θ� ���ڷ� ��ȸ
FROM DUAL;       

-- �Ͽ� ���õ� ����
SELECT TO_CHAR(SYSDATE, 'DD'),          -- �̹� ���� �� ��° �� ��
       TO_CHAR(SYSDATE, 'DDD'),         -- �̹� ���� �� ��° �� �� 
       TO_CHAR(SYSDATE, 'D')            -- �̹� ���� �� ��° �� ��(���� ���� 1: �Ͽ���, 2: ������, 3: ȭ���� ... 7:�����)
FROM DUAL;       

-- ���Ͽ� ���õ� ����
SELECT TO_CHAR(SYSDATE, 'DAY'),      -- X���� : X���� �������� ��ȸ
        TO_CHAR(SYSDATE, 'DY')       -- X   : ���Ͽ� ���� �ѱ��ڸ� ��ȸ
FROM DUAL;
--------------------------------------------------------------------------------
/*
        *TO_DATE : ���� �Ǵ� ����Ÿ���� �����͸� ��¥Ÿ�� ��ȯ���ִ� �Լ�
        
        TO_DATE(���� �Ǵ� ���� ������, [����]) => ��� �� DATEŸ��(��¥)    
*/        
SELECT TO_DATE(20240124) FROM DUAL;     -- ����Ÿ�� -> ��¥Ÿ��
SELECT TO_DATE('20240124') FROM DUAL;   -- ����Ÿ�� -> ��¥Ÿ��

--SELECT TO_DATE('20240124 140650')       -- �ð� �����͸� �߰��ϸ� ������ �����ؾ� ��!
--SELECT TO_DATE('20240124 140650' , 'YYYYMMDD HH24MISS') -- �Է��� ������ ������ ����.
--SELECT TO_CHAR(TO_DATE('140940' , 'HH24MISS'), 'HH:MI:SS')  -- ����Ÿ���� �ð� �����͸� ��¥Ÿ������ ��ȯ
                                             -- => TO_CHAR�� ��ȯ�� ���� Ȯ�ο����� �����.
--SELECT TO_CHAR(TO_DATE('870124', 'YYMMDD'), 'YYYY-MM-DD')  -- ���: 2087-01-24                                            
SELECT TO_CHAR(TO_DATE('870124', 'RRMMDD'), 'YYYY-MM-DD')    --50�� �̸��̸� 20xx, 50�� �̻��̸� 19xx���� ��ȯ                                         
FROM DUAL;
-- =============================================================================
/*
    * TO_NUMBER: ���� Ÿ���� �����͸� ���� Ÿ������ ��ȯ���ִ� �Լ�
    
    TO_NUMBER(����_������, [����])
*/
SELECT '12345678', TO_NUMBER('12345678') FROM DUAL;

SELECT '100000' + '55000' FROM DUAL; -- 155000 (O) ? 10000055000 ? // ��� ����� ���ڷ� �̷���� ����Ÿ���� ����Ÿ������ �ڵ�����ȯ ��!
SELECT '100,000' + '55,000' FROM DUAL; -- ���� ����!
SELECT TO_CHAR(TO_NUMBER('100,000', '999,999') + TO_NUMBER('55,000' , '999,999'), '999,999') FROM DUAL;
-- =============================================================================
/* 
    * NULL ó�� �Լ� : ������ ���� null�� ��� ó�����ִ� �Լ�
*/    
-- NVL : null �� ������ ���� �ٸ� ������ ǥ�����ִ� �Լ�
--    NVL(�÷�, NULL�� ��� ǥ���� ������(��))
SELECT EMP_NAME, SALARY, NVL(BONUS,0) BONUS FROM EMPLOYEE;
-- ������, ���ʽ� ���� ���� ��ȸ (���ʽ��� ���� ��쿡�� �⺻ �������� ��ȸ)
SELECT EMP_NAME, NVL(SALARY*(1+BONUS)*12, SALARY*12) "���ʽ� ���� ����"
FROM EMPLOYEE;

SELECT EMP_NAME, TO_CHAR((SALARY+ (SALARY*NVL(BONUS, 0)))*12, 'L999,999,999') "���ʽ� ���� ����"
FROM EMPLOYEE;

-- ������, �μ��ڵ� ��ȸ (�μ���ġ ���� ���� ������ "�μ�����"���� ǥ�õǵ��� ��ȸ)
SELECT EMP_NAME, NVL(DEPT_CODE, '�μ�����') "�μ��ڵ�"
FROM EMPLOYEE;

-- NVL2 : �ش� �÷��� ���� ���� ��� A��� ���� ǥ���ϰ�,
--                    ���� ���� ���(NULL�� ���) B��� ���� ǥ�����ִ� �Լ�
--      NVL2(�÷�, A, B)
SELECT EMP_NAME, SALARY, NVL2(BONUS, 'O', 'X') "���ʽ� ����" FROM EMPLOYEE;

SELECT EMP_NAME "������", NVL2(DEPT_CODE, '�����Ϸ�', '�̹���') "�μ���������" FROM EMPLOYEE;

-- NULLIF : �� �� ����� ���� ��ġ�ϸ� NULL�� ��ȯ�ϰ�, ��ġ���� ������ ù��° �׸�(�񱳴��1)�� ��ȯ
--  NULLIF(�񱳴��1, �񱳴��2)
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;
--==============================================================================
/*
    * ���� �Լ�
        - DECODE(�񱳴�� �÷�_������, �񱳰�1, �����1, �񱳰�2, �����2, .... , �����N )
        
        @�ڹٿ����� switch-case���� ����
        switch(�񱳴��) {
            case �񱳰�1 :
                �����ڵ�;
            case �񱳰�2 :
                �����ڵ�;
        }        
*/
-- ���� ���� �����ȣ, �����, �ֹι�ȣ, ���� ��ȸ
SELECT EMP_ID �����ȣ, EMP_NAME �����, EMP_NO �ֹι�ȣ, 
        DECODE(SUBSTR(EMP_NO, 8, 1), '1' , '��', '2', '��', '3', '��', '4', '��', '�ܰ���') ����
FROM EMPLOYEE;

-- ������ �޿� ��ȸ �� �μ����� ���ʽ� �߰��Ͽ� ���� ��ȸ
-- D1 : ���ʽ� + 0.05
-- D2 : ���ʽ� + 0.03
-- D5 : ���ʽ� + 0.02
SELECT EMP_NAME �����, DEPT_CODE �μ��ڵ�, DECODE(DEPT_CODE, 'D1', TO_CHAR(NVL(SALARY*12*(BONUS+0.05+1), SALARY*12*(1+0.05))), 'D2', TO_CHAR(NVL(SALARY*12*(BONUS+0.03+1), SALARY*12*(1+0.03))),
                'D3', TO_CHAR(NVL(SALARY*12*(BONUS+0.02+1), SALARY*12*(1+0.02))), TO_CHAR(NVL(SALARY*12*(BONUS+1), SALARY*12)))||'��' "����"
FROM EMPLOYEE
ORDER BY DEPT_CODE;

SELECT EMP_NAME �����, DEPT_CODE �μ��ڵ�, NVL(SALARY*(1+BONUS)*12, SALARY*12) "���� ����",
    (SALARY + (SALARY*(NVL(BONUS,0) + DECODE(DEPT_CODE, 'D1', 0.05, 'D2', 0.03, 'D5', 0.02, 0))))*12 "���ʽ� �߰� ����"
FROM EMPLOYEE;    

/*
    * CASE WHEN THEN
    
    CASE WHEN ���ǽ�1 THEN �����1
         WHEN ���ǽ�2 THEN �����2
         ...
         ELSE �����N
    END
    
    => �ڹٿ��� if ~ else �� ����
*/

-- ���� ���� ���� 500���� �̻� "���", 350���� �̻� "�߱�", �� ���ϴ� "�ʱ�" ��ȸ
SELECT EMP_NAME �����, TO_CHAR(SALARY, 'L999,999,999') "����",
    CASE WHEN SALARY >= 5000000 THEN '���'
         WHEN SALARY >= 3500000 THEN '�߱�'
         ELSE '�ʱ�'
    END "�η±���"
FROM EMPLOYEE;         
-- =============================================================================
/*
  * �׷� �Լ� : N���� ���� ���޹޾� 1���� ����� ��ȯ���ִ� �Լ�  
*/    
-- 1) SUM(����Ÿ���� �÷�) : �ش� ������ �� ���� ���Ͽ� ��ȯ���ִ� �Լ�
--  * �������� �� �޿�
SELECT SUM(SALARY) FROM EMPLOYEE;
-- * ������������ �� �޿�
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');
-- * ����� ������� �� �޿� (JOB_CODE: J5)
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE JOB_CODE = 'J5';

-- 2) AVG(����Ÿ���� �÷�) : �ش� ������ ����� ���Ͽ� ��ȯ���ִ� �Լ�
SELECT ROUND(AVG(SALARY)) FROM EMPLOYEE;

-- 3) �ִ� ��(MAX)  / �ּ� ��(MIN)
--    MAX(��� Ÿ�� ����) : �������� ù��° ������
--    MIN(��� Ÿ�� ����) : �������� ù��° ������
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE) FROM EMPLOYEE;

SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE) FROM EMPLOYEE;

-- 4) COUNT(*|�÷�|DISTINCT �÷�) : �ش� ���ǿ� �´� ���� ������ ��ȯ���ִ� �Լ�
-- ��ü ��� ��
SELECT COUNT(*) FROM EMPLOYEE;
-- ���� ��� ��
SELECT COUNT(*) FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');
-- ���ʽ��� ���� ���� ��
SELECT COUNT(*) FROM EMPLOYEE
WHERE BONUS IS NOT NULL;
-- ���� ������� �� ��� �μ��� �����Ǿ��� �� ��ȸ
SELECT COUNT(DISTINCT DEPT_CODE) FROM EMPLOYEE; -- ������ �� �� null�� ���ܵȴ�.
















--======================== ���� ���� ==============================
-- * ��������(JOIN), �ܺ�����(JOIN)
SELECT * FROM EMPLOYEE ORDER BY DEPT_CODE;
SELECT * FROM DEPARTMENT;

-- ANSI ���� (1)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- �μ� �ڵ�(DEPT_CODE, DEPT_ID)�� NULL�̾ EMPLOYEE ���̺��� ������ ������ ���

-- ����Ŭ ���� ���� (1)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+); -- �������� ����� �ϴ� ���̺��� �ݴ��� ���̺��� �÷� �ڿ� (+) ���δ�.
                                -- ��, EMPLOYEE ���̺��� �������� �ϰ� ������, DEPARTMENT���̺��� �÷��� DEPT_ID�� (+) ����.
-- ANSI ���� (2)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- �μ� �ڵ�(DEPT_CODE, DEPT_ID)�� NULL�̾ DEPARTMENT ���̺��� ������ ������ ��µ�.

-- ����Ŭ ���� ���� (2)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID; -- DEPARTMENT ���̺��� �������� �ϰ� ������, EMPLOYEE���̺��� �÷��� DEPT_CODE�� (+) ����.

-- FULL JOIN : �� ���̺��� ���� ��� ���� ��ȸ�� �� ����(��, ����Ŭ ���� ������ �ȵ�.)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID); -- �μ� �ڵ�(DEPT_CODE, DEPT_ID)�� NULL�̾ EMPLOYEE���̺�� DEPARTMENT ���̺��� ���� ������ ���.


-- * CASE WHEN THEN Ȱ���ϱ� 
SELECT EMP_NAME, EMP_NO,
    CASE WHEN SUBSTR(EMP_NO, 8, 1) = '1' OR SUBSTR(EMP_NO, 8, 1) = '3' THEN '����'
        WHEN SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4' THEN '����'
        ELSE '�ܰ���'
        END "����"
FROM EMPLOYEE;    


SELECT JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

SELECT JOB_CODE , COUNT(*) "�� �����", COUNT(BONUS) " ���ʽ��� �޴� ��� ��", 
        SUM(SALARY) �޿���, ROUND(AVG(SALARY)) ��ձ޿�, MIN(SALARY) �����޿�, 
        MAX(SALARY) �ִ�޿�
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

SELECT DEPT_CODE , COUNT(*), COUNT(BONUS), SUM(SALARY), ROUND(AVG(SALARY)),
        MIN(SALARY), MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY 1;

-- GROUP BY ���� ����Į�� ��� ����!
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;

-- HAVING �� : �׷쿡 ���� ������ ������ �� ���Ǵ� ����. GROUP BY �� WHERE ���� ��� �Ұ����ϱ� ������!
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY)>= 3000000;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

-- �μ��� ���ʽ��� �޴� ����� ���� �μ����� ��ȸ�ϴ� �μ��ڵ�, ���ʽ��� �޴� ����� ��(0��) ��ȸ
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

-- �� ���ι�
-- > ����Ŭ ���뱸��
SELECT EMP_NAME, SALARY, MAX_SAL
FROM EMPLOYEE, SAL_GRADE
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

-- > ANSI ����
SELECT EMP_NAME, SALARY, MAX_SAL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);

SELECT * FROM SAL_GRADE;

-- ��ü����(SELF JOIN) ?? 
-- ���� ���̺��� �ٽ� �ѹ� �����ϴ� ���
-- ��ü ����� ���, �����, ����μ��ڵ� ==> EMPLOYEE E
-- ����� ���, �����, ����μ��ڵ� ==> EMPLOYEE M
-- > ����Ŭ ���� ����
SELECT E.EMP_ID ������, E.EMP_NAME ����̸�, E.DEPT_CODE ����μ��ڵ�,
        M.EMP_ID ������, M.EMP_NAME ����̸�, M.DEPT_CODE ����μ��ڵ�
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;


-- > ANSI ����
SELECT E.EMP_ID ������, E.EMP_NAME ����̸�, E.DEPT_CODE ����μ��ڵ�,
        M.EMP_ID ������, M.EMP_NAME ����̸�, M.DEPT_CODE ����μ��ڵ�
FROM EMPLOYEE E
JOIN EMPLOYEE M ON(E.MANAGER_ID = M.EMP_ID);      -- LEFT JOIN �� ��� ����� ���� ����鵵 ��� ��µ�. 
                                                  -- RIGHT JOIN �� ��� ����� ���� ���� ����鵵 ��� ��µ�.
                                                     
-- �������� : 2�� �̻��� ���̺��� ������ JOIN �� ��
-- > ���, �����, �μ���, ���޸� ��ȸ
SELECT * FROM EMPLOYEE; -- DEPT_CODE / JOB_CODE
SELECT * FROM DEPARTMENT; -- DEPT_ID
SELECT * FROM JOB;  -- JOB_CODE

-- >> ����Ŭ ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE E.DEPT_CODE = DEPT_ID
AND E.JOB_CODE = J.JOB_CODE;

-- >> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE); -- �� �÷��� �̸��� ���� ��� USING(�÷���) ���!

-- > ���, �����, �μ���, ������ ��ȸ
SELECT * FROM EMPLOYEE;     // DEPT_CODE
SELECT * FROM DEPARTMENT;   // DEPT_ID / LOCATION_ID
SELECT * FROM LOCATION;     // LOCAL_CODE

-- >> ����Ŭ ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE;

-- >> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON ( DEPT_CODE = DEPT_ID)
JOIN LOCATION ON ( LOCATION_ID = LOCAL_CODE);

-- 1. ���, �����, �μ���, ������, ������ ��ȸ
SELECT * FROM EMPLOYEE;  -- DEPT_CODE
SELECT * FROM department;   -- DEPT_ID / LOCATION_ID
SELECT * FROM location; -- LOCAL_CODE / NATIONAL_CODE
SELECT * FROM national; -- NATIONAL_CODE
-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION L, NATIONAL N
WHERE DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE
AND L.NATIONAL_CODE = N.NATIONAL_CODE;

-->> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

-- 2. ���, �����, �μ���(DEPT_TITLE), ���޸�(JOB_NAME), ������(LOCAL_NAME), ������(NATIONAL_NAME) ��ȸ
SELECT * FROM EMPLOYEE;     -- DEPT_CODE  // JOB_CODE
SELECT * FROM DEPARTMENT;   -- DEPT_ID  / LOCATION_ID
SELECT * FROM JOB;          -- JOB_CODE
SELECT * FROM LOCATION;     -- LOCAL_CODE // NATIONAL_CODE
SELECT * FROM NATIONAL;     -- NATIONAL_CODE
SELECT * FROM SAL_GRADE;

-- >> ����Ŭ ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J, LOCATION L, NATIONAL N
WHERE E.DEPT_CODE = DEPT_ID
AND E.JOB_CODE = J.JOB_CODE
AND LOCATION_ID = LOCAL_CODE
AND L.NATIONAL_CODE = N.NATIONAL_CODE;

-- >> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

-- >> EMPLOYEE ���̺��� �̸�, ����, �Ѽ��ɾ�(���ʽ�����), �Ǽ��ɾ�(�Ѽ��ɾ� - (����*���� 3%)) ��ȸ
SELECT EMP_NAME �̸�, SALARY*12 ����, NVL(SALARY*12*(1+BONUS), SALARY*12) �Ѽ��ɾ�, 
NVL(SALARY*12*(1+BONUS)- (SALARY*12*0.03), SALARY*12-(SALARY*0.03)) �Ǽ��ɾ�
FROM EMPLOYEE;

-- >> EMPLOYEE ���̺��� �Ǽ��ɾ��� 5õ���� �̻��� ����� �̸�, ����, �Ǽ��ɾ�, ����� ��ȸ
SELECT EMP_NAME, SALARY, (SALARY+SALARY*NVL(BONUS,0))*12 - SALARY*12*0.03 "�Ǽ��ɾ�", HIRE_DATE
FROM EMPLOYEE
WHERE (SALARY+SALARY*NVL(BONUS,0))*12 - SALARY*12*0.03>= 50000000;

SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5','D9') AND HIRE_DATE < '2002/01/01';

SELECT EMP_NAME �����, SUBSTR(EMP_NO, 1, 2) ����, SUBSTR(EMP_NO, 3, 2) ����, SUBSTR(EMP_NO, 5, 2) ����
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

SELECT *
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20;

SELECT EMP_NAME, TO_CHAR(SALARY, 'L999,999,999')
FROM EMPLOYEE;

SELECT EMP_NAME, DEPT_CODE, SUBSTR(EMP_NO, 1, 6)--TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'YYMMDD'), 'YY"��" MM"��" DD"��"')
FROM EMPLOYEE;

SELECT EMP_NAME, DEPT_CODE, TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,6),'YYMMDD'), 'YY"��" MM"��" DD"��"')
FROM EMPLOYEE;
SELECT *
FROM EMPLOYEE;