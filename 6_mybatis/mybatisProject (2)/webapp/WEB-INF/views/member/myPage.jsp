<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h1 align="center">마이페이지</h1>
		<br>
		<form action="#" method="post">
			<table align="center">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="userId" value="${ loginUser.userId }" readonly>
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="password" name="userPwd" value="${ loginUser.userPwd }" readonly>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="userName" value="${ loginUser.userName }" readonly>
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="email" name="email" value="${ loginUser.email }">
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" name="birthday" value="${ loginUser.birthday }" placeholder="yymmdd(6자리)">
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;성별</td>
					<td align="center">
						<input type="radio" name="gender" value="M" <c:if test="${ loginUser.gender eq 'M' }"> checked </c:if>> 남
						<input type="radio" name="gender" value="F" <c:if test="${ loginUser.gender eq 'F' }"> checked </c:if>> 여
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<input type="text" name="phone" value="${ loginUser.phone }" placeholder="-포함">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address" value="${ loginUser.address }">
					</td>
				</tr>
			</table>
			<br>		
		</form>
	</div>
</body>
</html>