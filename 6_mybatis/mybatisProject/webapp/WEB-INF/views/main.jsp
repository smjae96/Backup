<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- common/menubar.jsp 이 페이지를 현재 페이지에 포함되도록 --%>
	<jsp:include page="common/menubar.jsp"/> <%-- "/WEB-INF/views/common/menubar.jsp 로 쓸 수 없다. WEB-INF로 직접 접근 안됨! 그래서 forward 방식 사용했음. --%>
</body>
</html>