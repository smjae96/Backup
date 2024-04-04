select * from member;

select * from notice
where status = 'Y';

-- �������� ��ȣ, �������� ����, �ۼ���ID, ��ȸ��, �������� �ۼ��� ��ȸ
select notice_no, notice_title, user_id, count, create_date
from notice, member
where notice_writer = user_no
and notice.status = 'Y';

select notice_no, notice_title, user_id, count, create_date
from notice
join member on(notice_writer = user_no)
where notice.status = 'Y'
order by notice_no desc;


-- notice_no �������� count ��ȸ (1,2)
select notice_no, notice_title, notice_content, user_id, count, create_date
from notice join member on(notice_writer = user_no)
where notice_no = 1 and notice.status = 'Y';

-- update : notice_no�� 1�� ���������� ��ȸ���� +1
update notice set count = count+1
where notice_no = 1;

rollback;

select count(*) count
from board
where board_type = 1
and status = 'Y'
;

-- �Խñ� ��ȣ, �Խñ� ����, �ۼ���ID, ��ȸ��, ī�װ���, �ۼ���(2024/03/20)
select *
from (select rownum rnum, r.*
from
(select  board_no, board_title, user_id, count, category_name, to_char(create_date, 'YYYY/MM/DD') create_date
from board
join member on(board_writer = user_no)
join category using (category_no)
where board.status = 'Y' and board_type = 1
order by create_date desc
) r
)
where rnum between 1 and 10;

update notice
set status = 'N'
where notice_no = ?;

-- �Խñ� ���� ���� �߰�
insert into board (board_no
                    , board_type
                    , category_no
                    , board_title
                    , board_content
                    , board_writer )
values ( SEQ_BNO.NEXTVAL, 1, ����ڰ�_������_ī�װ���ȣ, ����ڰ�_�Է���_����, ����ڰ�_�Է���_����, �α�����_�����ȸ����ȣNO);

-- ÷������ �ִ� ��� ���� ���� �߰�
insert into attachment (file_no
                        , ref_bno
                        , origin_name
                        , change_name
                        , file_path )
values ( SEQ_FNO.NEXTVAL, SEQ_BNO.CURRVAL, �������ϸ�, ���������ϸ�, ÷������_������ );         


-- �󼼺��� ������ ���� �� ��ȸ���� ����
update board set count = count+1 
where board_no = ? and status = 'Y';

-- �Խñ� ���� ��ȸ : �Խñ۹�ȣ, ī�װ���, ����, ����, �ۼ���, �ۼ���(YYYY/MM/DD)
select board_no, category_name, board_title, board_content, user_id, to_char(create_date, 'YYYY/MM/DD') create_date
from board
join category using(category_no)
join member on(board_writer = user_no)
where board_no = ?;

-- ÷������ ��ȸ : �ش� �Խñ��� ÷������ ���� (���Ϲ�ȣ, ������, ��������ϸ�, ������)
select file_no, origin_name, change_name, file_path
from attachment
where ref_bno = ?

                