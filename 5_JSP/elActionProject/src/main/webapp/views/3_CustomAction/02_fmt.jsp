<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt Library</title>
</head>
<body>
	<h1>fmt Library</h1>
	
	<h3>* formatNumber</h3>
	<p>
		숫자 관련된 데이터의 포맷을 지정<br>
		- 표현하려는 데이터의 형식을 통화기호, % 등 원하는 형식에 맞게 지정하는 태그<br>
		<br>
		(fmt:formatNumber value="출력할값" [groupingUsed="true|false"]
										 [type="percent|currency"]
									 	 [currencySymbol="통화기호문자"])
	<br>
	<ul>
		<li>groupingUsed : 세자리마다 구분자로 콤마(,)를 사용하여 표시할 지 여부 (기본값 : true)</li>
		<li>type : 백분율(%), 통화기호 형식 지정</li>
		<li>currencySymbol : 통화기호 문자 지정</li>
	</ul> 
	</p>
	<hr>
	
	<!-- num1 = 999999999, num2 = 0.77, num3 = 50000 -->
	<c:set var="num1" value="999999999"/>
	<c:set var="num2" value="0.57" />
	<c:set var="num3" value="50000" />
	
	num1 데이터 그대로 출력 : ${num1 } <br>
	세자리 마다 구분하여 출력 : <fmt:formatNumber value="${num1 }"/> <br>
	(jstl 사용)그대로 출력 : <fmt:formatNumber value="${num1 }" groupingUsed="false"/> <br>
	<br>
	percent : <fmt:formatNumber value="${num2 }" type="percent" /><br>
	currency : <fmt:formatNumber value="${num3 }" type="currency" /><br>
	currencySymbol $ 사용 : <fmt:formatNumber value="${num3 }" type="currency" currencySymbol="$"/><br>
	<hr>
	
	<h3>* formatDate</h3>
	<p>
		날짜 및 시간 데이터의 포맷 지정 (단, java.util.Date 객체 사용)
	</p>
	
	<!--  now 변수에 현재 날짜시간을 저장 -->
	<c:set var="now" value="<%= new Date() %>"/>
	
	그대로 출력 : ${now }<br>
	<ul>
		<li>현재 날짜 : <fmt:formatDate value="${now }" /></li>	<!-- type 속성 생략 시 날짜만 표시됨 -->
		<li>현재 시간 : <fmt:formatDate value="${now }" type="time" /></li>
		<li>현재 날짜+시간 : <fmt:formatDate value="${now }" type="both" /></li>
		<li>Medium 스타일 : <fmt:formatDate value="${now }" type="both" dateStyle="medium" timeStyle="medium"/></li>
		<li>Long 스타일 : <fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"/></li>
		<li>Full 스타일 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/></li>
		<li>Short 스타일 : <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/></li>
		<li>나만의 스타일 : <fmt:formatDate value="${now }" type="both" pattern="yyyy-MM-dd(E) HH:mm:ss(a)"/></li>
	</ul>
</body>
</html>