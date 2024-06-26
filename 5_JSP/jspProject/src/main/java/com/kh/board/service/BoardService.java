package com.kh.board.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.board.model.vo.Reply;
import com.kh.common.model.PageInfo;

public class BoardService {

	public int selectListCount() {
		int count = 0;
		Connection conn = getConnection();
		
		count = new BoardDao().selectListCount(conn);	// => select (DQL)
		
		close(conn);
		
		return count;
	}
	
	public ArrayList<Board> selectList(PageInfo pi) {
		ArrayList<Board> list = new ArrayList<>();
		
		Connection conn = getConnection();
		list = new BoardDao().selectList(conn, pi);	// select (DQL)
		
		close(conn);
		
		
		return list;
	}
	
	public ArrayList<Category> selectCategoryList() {
		ArrayList<Category> list = new ArrayList<>();
		
		Connection conn = getConnection();
		list = new BoardDao().selectCategoryList(conn);
		
		close(conn);
		return list;
	}

	public int insertBoard(Board board, Attachment attachment) {
		int result = 0;
		Connection conn = getConnection();
		result = new BoardDao().insertBoard(conn, board);
		int result2 = 1;		// 첨부파일이 없는 경우도 있기때문에 1로 초기화
		if(attachment != null && result > 0) {
			result2 = new BoardDao().insertAttachment(conn, attachment);
		}
		if(result >0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result * result2;
	}

	public Board selectBoardDetail(int boardNo) {
		Connection conn = getConnection();
		Board b = null;
		int result = 0;
		result = new BoardDao().updateBoardCount(conn, boardNo);
		if(result != 0) {
			commit(conn);
			b = new BoardDao().selectBoardDetail(conn, boardNo);
		} else {
			rollback(conn);
		}
		
		return b;
	}

	public Attachment selectAttachment(int boardNo) {
		Connection conn = getConnection();
		Attachment atc = null;
		
		atc = new BoardDao().selectAttachment(conn, boardNo);
		close(conn);
		
		
		return atc;
	}

	public int deleteBoard(int boardNo, Attachment at) {
		Connection conn = getConnection();
		int result = 0;
		int result2 = 1;
		result = new BoardDao().deleteBoard(conn, boardNo);
		if(at != null) {
			result2 = new BoardDao().deleteAttachment(conn, at.getRefBno());
		}
		if(result != 0 && result2 != 0) {
			commit(conn);
			
		} else {
			rollback(conn);
		}
		close(conn);
		return result * result2;
	}

	public int updateBoard(Board board, Attachment attachment) {
		int result = 0;
		Connection conn = getConnection();
		result = new BoardDao().updateBoard(conn, board);
		
		int result2 = 1;
		if(attachment != null) {
			result2 = new BoardDao().updateAttachment(conn, attachment);
		}
		if(result != 0 && result2 != 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result * result2;
		
		
	}

	public int insertReply(Reply reply) {
		int result = 0;
		Connection conn = getConnection();
		result = new BoardDao().insertReply(conn, reply);
		
		if(result !=0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Reply> selectReplyList(int bNo) {
		Connection conn = getConnection();
		ArrayList<Reply> list = new ArrayList<>();
		
		list = new BoardDao().selectReplyList(conn, bNo);
		close(conn);
		
		return list;
	}


}
