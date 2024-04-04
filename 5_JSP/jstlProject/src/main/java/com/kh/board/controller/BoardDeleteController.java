package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Attachment;
import com.kh.board.service.BoardService;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/delete.bo")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardNo = Integer.parseInt(request.getParameter("bno"));
		String attach = request.getParameter("attach");
		
		Attachment at = null;
		
		if(!attach.equals("null")) {
			// 첨부파일이 있는 경우
			at = new Attachment();
			
			at.setRefBno(boardNo);
		}
		int result = new BoardService().deleteBoard(boardNo, at);
		HttpSession session = request.getSession();
		if(result != 0) {
			session.setAttribute("alertMsg", "해당 일반게시글이 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.bo?cpage=1");
		} else {
			request.setAttribute("errorMsg", "게시글 삭제 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
