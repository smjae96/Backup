
-- ����� ���� �߰� : ������ �������� �����ϰ� �߰�
ALTER SESSION SET "_ORACLE_SCRIPT"=true;
CREATE USER workbook IDENTIFIED BY workbook;
-- ���� �߰� �� ���ѵ� ��������� ��.
GRANT RESOURCE, CONNECT, DBA TO workbook;

-- ����� ���� �߰�
-- CREATE USER ������̸�(ID) IDENTIFIED BY ��й�ȣ
CREATE USER DDL IDENTIFIED BY ddl;

-- ���� ����
-- GRANT [���ѵ�....] TO ������̸�(ID);
-- RESOURCE, CONNECT, DBA
GRANT RESOURCE, CONNECT, DBA TO DDL;