/*
    * ������  (SEQUENCE)
     : �ڵ����� ��ȣ�� �߻������ִ� ������ �ϴ� ��ü
       ���� ���� ���������� �������� ������Ű�鼭 ����.
       
       ex) ȸ����ȣ, �й�, ���, ... (�⺻Ű)
*/
/*
    - ������ ���� ���
    
        CREATE SEQUENCE ��������
        [START WITH ���ۼ���]        --> ó�� �߻���ų ���� �� ����. (�⺻�� : 1)
        [INCREMENT BY ����]         --> �󸶾� ������ų���� ���� �� (�⺻�� : 1)
        [MAXVALUE ����]             --> �ִ밪 (�⺻��: ... �� �� ������ŭ ŭ..)
        [MINVALUE ����]             --> �ּҰ� (�⺻��: 1)
        [CYCLE | NOCYCLE]           --> �� ��ȯ���� ���� (�⺻��: NOCYCLE)
        [NOCACHE | CACHE ����Ʈũ��] --> ĳ�ø޸� �Ҵ� (�⺻��: CACHE 20)
        
            * ĳ�ø޸� : �̸� �߻��� ������ �����ؼ� �����صδ� ����.
                          �Ź� ȣ��� ������ ���� ��ȣ�� �����ϴ� �� �ƴ϶�
                          ĳ�� �޸� ������ �̸� ������ ������ ������ �� �� �ִ� ��. (�ӵ��� ����)
                          - ������ �����ϸ�, ĳ�ø޸𸮿� �̸� ����� �� ��ȣ���� �� ���ư�!
            
      [����] 
      - �̸��� ������ �� ����
         * ���̺� : TB_XXX
         * ��    : VW_XXX
         * ������ : SEQ_XXX
         * Ʈ���� : TRG_XXX
*/
-- SEQ_TEST ��� �̸��� �������� �����غ���.
CREATE SEQUENCE SEQ_TEST;
--  *--------------------------------------------------
--  ������ ��� ��ȸ   (���� ����ڰ� �����ϰ� �ִ� ������)
SELECT * FROM USER_SEQUENCES;
--  *--------------------------------------------------

-- SEQ_EMPNO ��� �̸��� �������� �����ϴµ�,
--  300���� �����ϰ� 5�� �����ϸ� �ִ밪�� 310. ��ȯ���� �ʰ� ĳ�ø޸𸮵� ������� ����.
CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCACHE;
--------------------------------------------------------------------------------
/*
    - ������ ���
    
        + ��������.CURRVAL : ���� ������ �� ( ���������� ������ NEXTVAL�� ������ �� )
        + ��������.NEXTVAL : ������ ���� ���� ���� �������� �߻��� ��
                            -> ���� ������ �� + (INCREMENT BY ��)
*/    
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- ���� �߻�! NEXTVAL ����ϱ� ���� CURRVAL ����ϸ� ������ �߻�.

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- ���� �߻�. MAXVALUE�� 310���� �� �̻� ������ �� ���� ����.
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 310
--------------------------------------------------------------------------------
/*
    - ������ ���� ���� (ALTER)
    
    [ǥ����]
            ALTER SEQUENCE ��������
            [INCREMENT BY ����]       -- ������ų �� (�⺻��: 1)
            [MAXVALUE ����]           -- �ִ밪 (�⺻��: .. �� �� ���� ������ ŭ..)
            [MINVALUE ����]           -- �ּҰ� (�⺻��: 1)
            [CYCLE | NOCYCLE]        -- ���� ��ȯ���� (�⺻�� : NOCYCLE)
            [NOCACHE | CACHE ����Ʈũ��] -- ĳ�ø޸� ��뿩�� (�⺻�� : CACHE 20)
            
            * START WITH (���ۼ���) �� ������ �Ұ�!
*/
-- SEQ_EMPNO ���� �� ���� ���� 10���� �����ϰ�, �ִ밪�� 400���� ����.
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;     -- ������ ������ �߻���

ALTER SEQUENCE SEQ_EMPNO
INCREMENT BY 10
MAXVALUE 400;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;     -- �ִ밪 ���� �� 320. (���� ������ ������ �� : 310)

-- ������ ���� : DROP SEQUENCE ��������;
DROP SEQUENCE SEQ_EMPNO;

SELECT * FROM USER_SEQUENCES;
--------------------------------------------------------------------------------
/*
        - EMPLOYEE ���̺� ������ �����غ���.
                * ������ ��� �÷�: �����ȣ (EMP_ID)
        ������ ���� : ������ �̸�.NEXTVAL        
*/
-- ������ ����
CREATE SEQUENCE SEQ_EID
   START WITH 400     -- ���۹�ȣ 400
   NOCACHE;            -- ĳ�ø޸� ������� ����

-- ������ �߰� �� ������ ��� (NEXTVAL)
INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
VALUES (SEQ_EID.NEXTVAL, 'ȫ���', '111111-2111111', 'J3', SYSDATE);

SELECT * FROM EMPLOYEE;






