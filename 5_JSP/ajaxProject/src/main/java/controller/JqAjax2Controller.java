package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class JqAjax2Controller
 */
@WebServlet("/jqAjax2.do")
public class JqAjax2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjax2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ajax는 인코딩을 자동으로 해줌
		// request.setCharacterEncoding("UTF-8");
		
		
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		// 1. 문자열 하나의 데이터로 응답
		/*
		// 응답 하기 전에, 데이터에 한글이 포함된 경우 인코딩 설정
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print("이름: "+ name + ", 나이: " + age);
		*/
		
		
		// 2. 응답 데이터를 여러 개 보내기
		/*
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(name);
		response.getWriter().print(age);
		// => 위와 같이 응답할 경우 success:function 의 매개변수로 하나의 문자열이 전달
		*/
		
		// 3. 객체 형태로 응답
		/**
		 * 여러 개의 데이터를 응답하고자 할 때, "JSON" 형태로 응답(JavaScript Object Notation: 자바스크립트의 객체 표기법)
		 * - ajax 통신을 할 때 자주 사용되는 포맷 중 하나.
		 * 
		 *  > 자바스크립트 배열 객체 : [value1, value2, value3] => JSONArray
		 *  > 자바스크립트 일반 객체 : { key1: value1, key2: value2, key3: value3} => JSONObject
		 *  
		 *  - 라이브러리 추가 필요! json-simple-x.x.x.jar
		 *  > (https://code.google.com/archive/p/json-simple/downloads)
		 *  -- src/main/webapp/WEB-INF/lib 경로에 라이브러리 추가
		 */
		
		// * 배열 객체(JSONArray)로 응답 --> ArrayList와 유사
		/*
		JSONArray jsonArr = new JSONArray();	// 빈 배열이 생성됨: []
		jsonArr.add(name);						// 이름에 대한 데이터를 배열에 추가: ["홍길동"]
		jsonArr.add(age);						// 나이에 대한 데이터를 배열에 추가: ["홍길동", 20]
		
//		response.setContentType("text/html; charset=UTF-8");	// => text/html 작성 시 응답 데이터가 String 타입으로 전달
		response.setContentType("application/json; charset=UTF-8");	// => mime type을 JSON 형식으로 응답할 때 설정 (application/json)
		response.getWriter().print(jsonArr);
		*/
		
		// * 일반 객체(JSONObject)로 응답 --> HashMap과 유사
		JSONObject jsonObj = new JSONObject();			// 빈 객체가 생성
		jsonObj.put("name", name);						// 이름에 대한 데이터를 키:밸류 형태로 추가 { name : "홍길동" }
		jsonObj.put("age", age);						// 나이에 대한 데이터를 키:밸류 형태로 추가 { name : "홍길동" , age : 20 }
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonObj);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
