package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JqAjax1Controller
 */
@WebServlet("/jqAjax1.do")
public class JqAjax1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjax1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("input");
		
		System.out.println("전달된 데이터: " + input);
		
		// 요청에 대한 처리가 완료되었다 가정하고, 응답할 데이터 전달(문자열)
		String responseData = "전달된 값 - " + input + ", 길이 - " + input.length();
		
		// 응답 데이터 돌려주기
		response.setContentType("text/html; charset=utf-8");		// 응답데이터의 타입, 인코딩 설정
		response.getWriter().print(responseData);					// 전달할 데이터 응답(돌려주기)
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
