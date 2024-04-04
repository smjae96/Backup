select * from member;

select * from notice
where status = 'Y';

-- 공지사항 번호, 공지사항 제목, 작성자ID, 조회수, 공지사항 작성일 조회
select notice_no, notice_title, user_id, count, create_date
from notice, member
where notice_writer = user_no
and notice.status = 'Y';

select notice_no, notice_title, user_id, count, create_date
from notice
join member on(notice_writer = user_no)
where notice.status = 'Y'
order by notice_no desc;


-- notice_no 기준으로 count 조회 (1,2)
select notice_no, notice_title, notice_content, user_id, count, create_date
from notice join member on(notice_writer = user_no)
where notice_no = 1 and notice.status = 'Y';

-- update : notice_no가 1인 공지사항의 조회수를 +1
update notice set count = count+1
where notice_no = 1;

rollback;

select count(*) count
from board
where board_type = 1
and status = 'Y'
;

-- 게시글 번호, 게시글 제목, 작성자ID, 조회수, 카테고리명, 작성일(2024/03/20)
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

-- 게시글 관련 정보 추가
insert into board (board_no
                    , board_type
                    , category_no
                    , board_title
                    , board_content
                    , board_writer )
values ( SEQ_BNO.NEXTVAL, 1, 사용자가_선택한_카테고리번호, 사용자가_입력한_제목, 사용자가_입력한_내용, 로그인한_사용자회원번호NO);

-- 첨부파일 있는 경우 파일 정보 추가
insert into attachment (file_no
                        , ref_bno
                        , origin_name
                        , change_name
                        , file_path )
values ( SEQ_FNO.NEXTVAL, SEQ_BNO.CURRVAL, 원본파일명, 수정된파일명, 첨부파일_저장경로 );         


-- 상세보기 페이지 접근 시 조회수를 증가
update board set count = count+1 
where board_no = ? and status = 'Y';

-- 게시글 정보 조회 : 게시글번호, 카테고리명, 제목, 내용, 작성자, 작성일(YYYY/MM/DD)
select board_no, category_name, board_title, board_content, user_id, to_char(create_date, 'YYYY/MM/DD') create_date
from board
join category using(category_no)
join member on(board_writer = user_no)
where board_no = ?;

-- 첨부파일 조회 : 해당 게시글의 첨부파일 정보 (파일번호, 원본명, 저장된파일명, 저장경로)
select file_no, origin_name, change_name, file_path
from attachment
where ref_bno = ?

                