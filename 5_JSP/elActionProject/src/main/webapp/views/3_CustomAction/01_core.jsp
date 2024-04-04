<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.model.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core Library</title>
</head>
<body>
	<h1> JSTL Core Library </h1>
	
	<h3>1. 변수 (속성 == Attribute)</h3>
	<pre>
		* 변수 선언과 동시에 초기화 (c:set var="변수명" value="데이터(값)" [scope="객체영역"])
			- 변수를 선언하고 초기값을 대입하는 기능 제공
			- 해당 변수를 어떤 scope에 저장할 지 지정 가능 (생략 시 pageScope에 저장)
		=> 따라서, 해당 scope에 setAttribute를 통해 key/value 형태로 데이터를 저장하는 것과 동일하게 처리됨.
		=> c:set 으로 선언된 변수는 EL로만 접근 가능 (스크립팅 원소로 접근 불가)
		
		- 변수 타입을 별도로 지정하지 않음
		- 초기값을 반드시 지정해줘야 함
	</pre>
	<%-- num1 이라는 변수에 10이라는 값을 저장 --%>
	<c:set var="num1" value="10"/>
	<%-- pageScope.setAttriubte("num1", "10"); --%>
	<%-- request영역에 num2 변수에 20이라는 값을 저장 --%>
	<c:set var="num2" value="20" scope="request"/>
	<%-- request.setAttribute("num2", "20"); --%>
	num1 : ${num1}<br>
	num2 : ${num2}<br>
	
	<%-- num1과 num2의 합을 저장한 addNum 변수를 session 영역에 저장 --%>
	<c:set var="addNum" value="${num1 + num2}" scope="session"/>
	addNum : ${addNum}<br>
	
	<%-- num1, num2, addNum --%>
	> ${pageScope.num1 }<br>
	> ${requestScope.num2 }<br>
	> ${sessionScope.addNum }<br>
	> ${requestScope.addNum }<br>
	
	<%-- value 속성 대신 시작태그와 종료태그 사이에 초기값 지정 --%>
	<c:set var="addNum" scope="request" >999</c:set>
	> ${requestScope.addNum }
	<hr>
	
	<pre>
		* 변수 삭제 (c:remove var="제거하고자하는_변수명" [scope=""])
			- 해당 scope 영역에 해당 변수를 찾아 제거하는 태그
			- scope 속성을 생략 시 모든 scope영역에서 해당 변수를 모두 제거
		=> 따라서, 해당 scope에 .removeAttribute를 통해 제거하는 것과 동일하게 처리됨.
	</pre>
	- 제거 전 addNum : ${ addNum }<br>
	* 특정 scope를 지정하여 삭제<br>
	<%-- request 영역의 addNum 변수를 제거 --%>
	<c:remove var="addNum" scope="request"/>
	- request 영역에서 제거 후 addNum : ${addNum }<br>
	<br>
	* 모든 scope에서 제거<br>
	<%-- 모든 addNum 변수를 제거 --%>
	<c:remove var="addNum" />
	- 모두 제거 후 addNum : ${ addNum }<br>
	<hr>
	<pre>
		* 변수(데이터) 출력 (c:out value="출력하고자하는_값" [default="기본값"] [escapeXml="true|false"])
			-데이터를 출력하고자 할 때 사용하는 태그
	</pre>
	
	<%-- addNum 변수에 저장된 값 출력 --%>
	<c:out value="${addNum }"/>
	<c:out value="${addNum }" default="없음"/>
	<br>
	<%-- outData 라는 변수에 "<b>강조하는 태그!</b>" 저장 후 out태그를 사용하여 화면에 출력 --%>
	<c:set var="outData"><b>강조하는 태그!</b></c:set>
	<c:out value="${outData }"/><br>
	<c:out value="${outData }" escapeXml="false"/>
	<%-- escapeXml 속성 생략 시 기본값: true => 출력데이터에 태그가 포함된 경우 해석안됨(문자열로 처리됨) --%>
	<hr>
	
	<h3>2. 조건문 - if (c:if test="조건식")</h3>
	<pre>
		* Java 의 if문과 비슷한 역할을 하는 태그
		* 조건식은 test 속성에 작성 (이때, 조건식은 EL구문을 사용해야 함!)
	</pre>
	<%-- 스크립트릿 방식 : num1의 값이 num2의 값보다 큰지? --%>
	<%-- JSTL로 선언한 변수로는 접근 불가!
	<% if (num1 > num2) { %>
	<% } %>
	--%>
	
	<%-- num1이 num2보다 크다면 "num1이 num2보다 크다." --%>
	<c:if test="${num1 gt num2 }">num1이 num2보다 크다</c:if>
	<c:if test="${num1 lt num2 }">num1이 num2보다 작다</c:if>
	
	<c:set var="hi" value="안녕!" />
	<%--
	<% if(hi.equals("안녕!")) { %>
	<% } %>
	 --%>
	 <%-- hi 변수의 값이 안녕! 과 일치하면 "hi hi hi"를 출력 
	 	  일치하지 않으면 "bye bye bye "를 출력--%>
 	  <br>
	 <c:if test="${hi eq '안녕!'}">hi hi hi<br></c:if>
	 <c:if test='${hi ne "안녕!" }'>bye bye bye<br></c:if>
	 <br>
	 <h3>3. 조건문 - Choose (c:choose, c:when, c:otherwise)</h3>
	 <pre>
	 	* Java의 if-else, if-else if 문과 비슷한 역할을 하는 태그
	 	* 각 조건들을 c:choose 하위 요소로 c:when 을 사용하여 작성
	 	* else의 역할 => c:otherwise
	 </pre>
	 <%-- num1이 20보다 크면 "num1은 20보다 큽니다." 
	 			10보다 크면 "num1은 10이상입니다."
 				그렇지 않으면 "num1은 10보다 작습니다."
	--%>
	 <c:choose>
	 	<c:when test="${num1 gt 20 }">num1은 20보다 큽니다.</c:when>
	 	<c:when test="${num1 ge 10 }">num1은 10이상입니다.</c:when>
	 	<c:otherwise>num1은 10보다 작습니다.</c:otherwise>
	 </c:choose>
	 <hr>
	 <h3>4. 반복문 - forEach</h3>
	 <pre>
	 	for loop 문 - (c:forEach var="변수명" begin="초기값" end="끝값" [step="반복 시 증가값"])
	 	
	 	향상된 for문 - (c:forEach var="변수명" items="순차적으로 접근하고자 하는 객체(배열/컬렉션)"
										   [varStatus="현재 접근된 요소의 상태값을 보관하는 변수명"]                                                  )								
	 </pre>
	 <%-- 
	 <%for(int i=1; i<=10; i++) { %>
	 	<p>i의 값은 ---&gt; <%= i %></p>	
	 <%	}	%>
	 --%>
	 
	 <c:forEach var="i" begin="1" end="10"><p>i의 값은 ---&gt; ${i}</p></c:forEach>
	 
	 <%-- h1 ~ h6 태그를 출력 "나는 hx 태그입니다." --%>
	 <c:forEach var="i" begin="1" end="6"><h${i }>나는 h${i }태그입니다.</h${i }></c:forEach>	
	 <c:set var="fruits">사과, 딸기, 바나나, 메론</c:set>
	 
	 fruits 변수의 값 : ${fruits }
	 
	 <ul>
	 	<c:forEach var="f" items="${fruits }">
	 		<li>${f}</li>
	 	</c:forEach>
	 </ul>
	 <%-- 
	 	* colors 라는 변수에 4가지 색상을 콤마(,)로 구분하여 저장 
	 	  목록 태그로 나열하고 글자 색을 해당 색상으로 표시	
	 --%>
	 <c:set var="col">red, blue, yellow, green</c:set>
	 <ul>
	 	<c:forEach var="color" items="${col }">
	 		<li style="color: ${color}">${color}</li>
	 	</c:forEach>
	 </ul>
	 <%
	 	ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("아이유", 30, "여자"));
	 	list.add(new Person("윤하", 35, "여자"));
	 	list.add(new Person("차은우", 27, "남자"));
	 %>
	 <c:set var="pList" value="<%= list %>" scope="request"/>
	 <%-- request.setAttribute("pList", list) --%>
	 <c:choose>
	 <c:when test="${empty pList }">조회된 리스트가 없습니다.</c:when>
	 <c:otherwise>
	 <table border= "1">
	 	<thead>
	 		<tr>
	 			<th>No</th>
	 			<th>이름</th>
	 			<th>나이</th>
	 			<th>성별</th>
	 		</tr>
 		</thead>
 		<tbody>
 			<c:forEach var="p" items="${pList }" varStatus="status">
 			<%-- varStatus라는 속성은 현재 접근된 항목의 상태 정보를 확인할 수 있음 --%>
 			<tr>
 				<%-- <td>${status.index }</td>  --%> <%-- index 속성: 0부터 시작 --%>
 				<td>${status.count }</td> <%-- count 속성: 1부터 시작 --%>
 				<td>${p.name }</td>
 				<td>${p.age }</td>
 				<td>${p.gender }</td>
 			</tr>
 			</c:forEach>
 		</tbody>
	 </table>
	 </c:otherwise>
	 </c:choose>
	 <br>
	 <h3>5. 반복문 - forTokens</h3>	<%-- 특정 구분자를 통해서 순차적으로 접근하고자 할 때 --%>
	 <pre>
	 	* (c:forTokens var="변수명" items="분리하고자하는문자열" delims="구분자 ")
	 	
	 	- 구분자를 통해서 분리된 각각의 문자열에 순차적으로 접근하여 반복문을 수행
	 	- 콤마(,)가 아닌 다른 구분자를 통해 문자열을 분리하고자 할 때 사용
	 	- Java에서 문자열.split("구분자") 또는 StringTokenizer와 비슷한 기능
	 </pre>
	 
	 <%-- movie 변수에 5개 작성 (구분자 : , . / )--%>
	 <c:set var="movie">해리포터, 곡성 . 아바타2 / 영화2 / 영화3</c:set>
	 <%-- 순서있는 목록태그로 영화 목록 출력 --%>
	 <h4>영화목록</h4>
	 <ol>
	 	<c:forTokens var="m" items= "${movie }" delims=",./">
	 		<li>${m}</li>
	 	</c:forTokens>
	 </ol>
	 
	 <h3>6. url, query String 관련 - url, param</h3>
	 <pre>
	 	* url 경로를 생성하고, query String을 정의해 둘 수 있는 태그
	 	
	 	c:url var="변수명" value="요청할 url"
	 		c:param name="키값" value="데이터(전달값)" /
	 		c:param name="키값" value="데이터(전달값)" /
	 	/c:url
	 </pre>
	 
	 <a href="list.do?cpage=1&num=2">기존 방식</a> <br>
	 <%-- 변수명: listUrl --%>
	 <c:url var="listUrl" value="list.do">
	 	<c:param name="cpage" value="1" />
	 	<c:param name="num" value="2" />
	 </c:url>
	 <a href="${ listUrl }">jstl(c:url)을 사용한 방식</a>
</body>
</html>