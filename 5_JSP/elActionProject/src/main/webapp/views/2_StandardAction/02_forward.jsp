<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>02_forward 페이지입니다.</h1>
	
	<jsp:forward page="footer.jsp"/>
	<%-- url 유지되면서 포워딩된 페이지가 표시됨 --%>
</body>
</html>