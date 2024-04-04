<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#list-area {
	color: black;
}
tbody tr:hover {
	background: red;
	cursor:pointer;
}

</style>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>
<div class="outer" align="center">
		<br>
		<h1 style="color: black;">게시판</h1>
		<br>
		
		<div id="search-area">
		</div>
		<br>
		
		<table id="list-area">
			<thead align="center">
				<tr>
					<th>글번호</th>
					<th width="400">제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
				<c:when test="${not empty list }">
				<c:forEach var="b" items="${list }">
				<tr align="center">
					<td>${b.boardNo }</td>
					<td>${b.boardTitle }</td>
					<td>${b.boardWriter }</td>
					<td>${b.count }</td>
					<td>${b.createDate }</td>
				</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5">조회된 게시글이 없습니다.</td>
					</tr>
				</c:otherwise>
				</c:choose>
			</tbody>
			
		</table>
		<br>
		
		<div id="paging-area">
		<c:if test='${pi.currentPage > 1 }'>
			<a href="list.bo?cpage=${pi.currentPage - 1}">[이전]</a>
		</c:if>
			<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
			<c:choose>
			<c:when test='${pi.currentPage eq i }'>
			<a href="list.bo?cpage=${i }" onclick="return(false)">[${i}]</a>
			</c:when>
			<c:otherwise>
			<a href="list.bo?cpage=${i }">[${i}]</a>
			</c:otherwise>
			</c:choose>
			</c:forEach>
		<c:if test='${pi.currentPage < pi.maxPage }'>
			<a href="list.bo?cpage=${pi.currentPage +1 }">[다음]</a>
		</c:if>
		</div>
		<br>	
</div>
</body>
<script>
					$(function() {
						$("#list-area>tbody>tr").click(function(){
							location.href= 'detail.bo?bno=' + $(this).children().eq(0).text();
						});
					});
</script>
</html>