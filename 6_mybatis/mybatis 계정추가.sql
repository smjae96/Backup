-- mybatis/mybatis ���� �߰�
create user C##mybatis identified by mybatis; 
--�ּұ���
grant resource, connect to C##mybatis;
--���̺� �����̽� ����
alter user c##mybatis default tablespace users quota unlimited on users;