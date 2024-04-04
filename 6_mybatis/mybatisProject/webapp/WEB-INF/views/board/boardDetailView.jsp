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
	
	<div class="outer" align="center">
		<br>
		<h1>게시판 상세조회</h1>
		<br>
		
		<table border="1">
			<tr>
				<td width="100">글번호</td>
				<td width="500">${board.boardNo }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${board.boardTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.boardWriter }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${board.count }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${board.createDate }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td height="100">${board.boardContent }</td>
			</tr>
		</table>
		
		<br>
		
		<%-- ajax 사용하지 않고, 동기식 방식으로 데이터를 가지고 올것. --%>
		<table border="1">
		<c:if test="${loginUser != null }">
			<form action="insert.rp" method="post">
			<tr>
				
				<td width="100">댓글작성</td>
				<td width="400">
					<input type="hidden" name="boardNo" value="${board.boardNo }" />
					<input type="hidden" name="userNo" value="${loginUser.userNo }" />
					<textarea name="replyContent"></textarea>	
				</td>
				<td width="100">
					<button type="submit">등록</button>
				</td>
			</tr>
			</form>
			</c:if>
			<tr>
				<%-- 댓글 총 수 표시 --%>
				<td colspan="3"><b>댓글(${replyList.size()})</b></td>
			</tr>
			<%-- 댓글 목록 --%>
			<c:forEach var="i" items="${replyList }">
			<tr>
				<td width="100">${i.replyWriter }</td>
				<td width="400">${i.replyContent }</td>
				<td width="100">${i.createDate }</td>
			</tr>
			</c:forEach>
		</table>
		<br><br>
	</div>
</body>

</html>