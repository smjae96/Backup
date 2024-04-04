<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.model.vo.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>* 기존 방식인 스크립트릿과 표현식을 이용해서 각 scope에 있는 데이터 출력</h3>
	<%--
	<%
		// classRoom, student, academy, teacher
		String classRoom = (String)request.getAttribute("classRoom");
		Person student = (Person)request.getAttribute("student");
		
		String academy = (String)session.getAttribute("academy");
		Person teacher = (Person)session.getAttribute("teacher");
		
		String scopeR = (String)request.getAttribute("scope");
		String scopeS = (String)session.getAttribute("scope");
		String scopeA = (String)application.getAttribute("scope");
	%>
	<p>
		학원명 : <%= academy %> <br>
		강의장 : ${classRoom } <br>
		강사 : <%= teacher.getName() + " , " + teacher.getAge() + " , " + teacher.getGender() %>
		<br><br>
		수강생 정보
		<ul>
			<li>이름 : <%= student.getName() %></li>
			<li>나이 : ${student.getAge() }</li>
			<li>성별 : ${student.getGender() }</li>
		</ul>
	</p>
	 --%>
	 <h3>* EL을 사용하여 각 scope의 데이터 출력하기</h3>
	 <p>
	 	EL을 이용하면 getXXX 메소드를 사용하지 않고, EL구문 내에서 해당 키 값만 제시하면 바로 접근 가능 <br>
	 	기본적으로 EL은 jsp 내장 객체를 구분하지 않고, 모든 내장 객체에 키 값을 검색하여 존재하는 경우
	 	해당 데이터를 가지고옴. 
	 </p>
	 <p>
		학원명 : ${academy } <br>
		강의장 : ${classRoom } <br>
		강사 : ${teacher.name },  ${teacher.age },  ${teacher.gender}
		<!-- 
			teacher 데이터에 접근하면 Person 객체로,
				해당 객체의 필드에 담긴 값을 출력하고자 할 때 .필드명으로 접근하면 됨
				=> 내부적으로 해당 필드의 getter 메소드를 찾아서 실행
				!! 주의 !! : getter 메소드는 항상 필수적으로 정의가 되어 있어야 함
		 -->
		<br><br>
		수강생 정보
		<ul>
			<li>이름 :${student.name }</li>
			<li>나이 : ${student.age }</li>
			<li>성별 : ${student.gender }</li>
		</ul>
	</p>
	<br>
	<h3>* EL 사용 시 내장 객체들에 동일한 키 값으로 저장된 데이터에 접근하기</h3>
	scope 값: ${scope } <br>
	<!-- 
		EL에서는 공유 범위가 가장 작은 scope에서부터 해당 키값을 검색
			page => request => session => application
			
		만약, 모든 영역에서 찾지 못할 경우..
				=> 아무것도 출력되지 않음. (오류 x)
	 -->
	 test 값 : ${test } <br>
	 <br>
	 <h3>* 직접 scope를 지정하여 접근하기</h3>
	 <%
	 	pageContext.setAttribute("scope", "page");
	 %>
	 
	 page scope : ${ scope } 또는 ${ pageScope.scope }<br>
	 request scope : ${ requestScope.scope }<br>
	 session scope : ${sessionScope.scope }<br>
	 application scope : ${applicationScope.scope }
	 <br><br>
	 <!-- 
	 		각 영역에 동일한 키값으로 데이터를 저장한 경우,
	 		scope를 직접 지정하여 해당 키의 데이터를 가져올 수 있음 (xxxScope.키값)
	 		
	 		키값만 사용하는 경우 원하는 데이터를 조회하지 못할 수 있음
	  -->
	  접근을 잘못할 경우... (session 객체에 classRoom 데이터 조회) <br>
	  => ${ sessionScope.classRoom }
</body>
</html>