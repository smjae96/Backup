package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.board.model.vo.Reply;
import com.kh.board.service.BoardService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/AjaxReplyInsertController")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyContent = request.getParameter("reply");
		String boardNo = request.getParameter("boardNo");
		Member m = (Member)(request.getSession().getAttribute("loginUser"));
		int userNo = m.getUserNo();	
		Reply reply = new Reply();
		reply.setReplyContent(replyContent);
		reply.setReplyWriter(String.valueOf(userNo));
		reply.setRefBno(Integer.parseInt(boardNo));
		int result = new BoardService().insertReply(reply);
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result", result);
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonObj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}