package com.kh.mybatis.board.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.Reply;

public interface BoardService {
	
	// 게시글 조회
	public abstract int selectListCount();
	
	public abstract ArrayList<Board> selectList(PageInfo pi);
	
	// 게시판 상세조회
	public abstract int increaseCount(int boardNo);
	
	public abstract Board selectBoard(int boardNo);
	
	//댓글목록 조회
	public abstract ArrayList<Reply> selectReplyList(int boardNo);
	
	// 댓글 추가
	public abstract int insertReply(Reply reply);
	
}
