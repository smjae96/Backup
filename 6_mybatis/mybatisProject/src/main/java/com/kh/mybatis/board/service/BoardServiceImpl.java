package com.kh.mybatis.board.service;

import static com.kh.mybatis.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.Reply;

public class BoardServiceImpl implements BoardService{
	
	BoardDao bDao = new BoardDao();

	@Override
	public int selectListCount() {
		SqlSession sqlSession = /*Template.*/getSqlSession();
		int count = bDao.selectListCount(sqlSession);
		sqlSession.close();
		return count;
		
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		int result = bDao.increaseCount(sqlSession, boardNo);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		Board bo = bDao.selectBoard(sqlSession, boardNo);
		sqlSession.close();
		return bo;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Reply> list = bDao.selectReplyList(sqlSession, boardNo);
		sqlSession.close();
		return list;
	}

	@Override
	public int insertReply(Reply reply) {
		SqlSession sqlSession = getSqlSession();
		int result = bDao.insertReply(sqlSession, reply);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

}
