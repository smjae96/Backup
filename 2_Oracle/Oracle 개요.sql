-- ���� �ּ�
/*
    ���� �� �ּ�
*/

-- RESULT SET => �ڵ带 �����ϸ� ������ ��� ��

-- ��ɹ� ����   : ����� �����ư �Ǵ� CTRL + ENTER
-- ���� ��� �����鿡 ���ؼ� ��ȸ�ϴ� ��ɹ�
SELECT * FROM DBA_USERS;
-- select * from dba_users;

-- 12�������� ����� ����� ���� �߰� ���� ��å�� 11 ���� ������ ���� ����ϰ��� �� ��.
-- �Ʒ� ��ɾ� ���� �� �߰�
ALTER SESSION SET "_ORACLE_SCRIPT"=true;

-- ����� ���� �߰� (������ �������θ� ����!)
-- * CREATE USER ������ IDENTIFIED BY ��й�ȣ;
--   - ��й�ȣ�� ��ҹ��� ���е�.

CREATE USER kh IDENTIFIED BY kh;

-- ����� ������ ���� �ο�
-- * GRANT ����1, ����2, ... TO ������
--   * CONNECT : ���� ����
--   * RESOURCE : ������ ó��(�߰�/����/����/��ȸ..) ����
--   * DBA :������ ó�� ����
GRANT RESOURCE, CONNECT, DBA TO kh;



