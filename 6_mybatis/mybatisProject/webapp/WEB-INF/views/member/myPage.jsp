<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="../common/menubar.jsp"/>

<div class="outer">
		<br>
		<h1 align="center">마이페이지</h1>
		<br>
		<form action="update.me" method="post">
			<table align="center">
				<tr>
					<td>* 아이디</td>
					<td>
						<input type="text" name="userId" value=${loginUser.userId } readonly>
					</td>
				</tr>
				<tr>
					<td>* 패스워드</td>
					<td>
						<input type="password" name="userPwd" value=${loginUser.userPwd } required>
					</td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td>
						<input type="text" name="userName" value=${loginUser.userName } required>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td>
						<input type="email" name="email" value=${loginUser.email }>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;생년월일</td>
					<td>
						<input type="text" name="birthday" placeholder="yymmdd(6자리)" readonly value=${loginUser.birthday }>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;성별</td>
					<td align="center">
					<c:choose>
						<c:when test="${loginUser.gender eq 'M'}">
							<input type="radio" name="gender" value="M" checked onclick="return(false)" > 남
							<input type="radio" name="gender" value="F"  onclick="return(false)"> 여
						</c:when>
						<c:otherwise>
							<input type="radio" name="gender" value="M"  onclick="return(false)"> 남
							<input type="radio" name="gender" value="F" checked onclick="return(false)"> 여
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;연락처</td>
					<td>
						<input type="text" name="phone" placeholder="-포함" value=${loginUSer.phone }>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;주소</td>
					<td>
						<input type="text" name="address" value=${loginUser.address }>
					</td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="submit">회원 정보수정</button>
				<button type="button" onclick="deleteMember()">회원 탈퇴</button>
			</div>
		</form>
	</div>
</body>
<script>
	function deleteMember() {
		console.log("abcde");
		location.href = "delete.me?userId="+"${loginUser.userId }";
	}
</script>
</html>