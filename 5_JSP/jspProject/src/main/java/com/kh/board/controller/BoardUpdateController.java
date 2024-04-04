package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.bo")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxSize = 10 * 1024 * 1024;
		String savePath = request.getSession().getServletContext().getRealPath("/resources/b_upfiles/");
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize
																, "utf-8", new MyFileRenamePolicy());
		String category = multiRequest.getParameter("category");	// 카테고리 번호
		String title = multiRequest.getParameter("title");			// 게시글 제목
		String content = multiRequest.getParameter("content");		// 게시글 내용
		int boardNo = Integer.parseInt(multiRequest.getParameter("num"));
		int userNo = Integer.parseInt(multiRequest.getParameter("num"));	
		
		Board board = new Board();
		board.setCategoryNo(category);
		board.setBoardTitle(title);
		board.setBoardContent(content);
		board.setBoardWriter(String.valueOf(userNo));
		board.setBoardNo(boardNo);
		
		Attachment attachment = null;
		if(multiRequest.getOriginalFileName("upfile") != null) {
			attachment = new Attachment();
			
			attachment.setOriginName(multiRequest.getOriginalFileName("upfile"));
			attachment.setChangeName(multiRequest.getFilesystemName("upfile"));		// 키값에 해당하는 첨부파일의 실제 저장된 경로를 알려주는 메소드
			attachment.setFilePath("resources/b_upfiles/");
		}
		
		int result = new BoardService().updateBoard(board, attachment);
		request.setAttribute("attachment", attachment);
		if(result != 0) {	
			request.getSession().setAttribute("alertMsg", "게시글 수정 성공!");
			// /jsp/list.bo?cpage=1 url로 재요청
			response.sendRedirect(request.getContextPath() + "/list.bo?cpage=1");
			
	
		} else {			// 게시글 등록 실패 => 첨부파일이 있을 경우 파일 삭제, 에러페이지로 응답
			
			if(attachment != null) {	// 첨부파일이 있는 경우
				new File(savePath + attachment.getChangeName()).delete();	// 파일 삭제하는 메소드 : delete()
			}
			request.setAttribute("errorMsg", "게시글 수정 실패!");
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
