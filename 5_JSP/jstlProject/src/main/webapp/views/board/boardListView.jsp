<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.kh.common.model.PageInfo, java.util.ArrayList, com.kh.board.model.vo.Board"%>
<%
PageInfo pi = (PageInfo) request.getAttribute("pi");

ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<style>
.outer {
	background: black;
	color: white;
	width: 1000px;
	height: 600px;
	margin: auto;
	margin-top: 50px;
}

.list-area {
	border: 1px solid white;
	text-align: center;
}

.list-area>tbody>tr:hover {
	background: darkgray;
	cursor: pointer;
}
</style>
</head>

<body>
	<%@ include file="../common/menubar.jsp"%>
	<div class="outer">
		<br>
		<h2 align="center">일반 게시판</h2>
		<br>
		<%-- 로그인 한 경우만 글쓰기 버튼이 표시되도록 --%>
		<%--
		if (loginUser != null) { 
		--%><c:if test="${loginUser != null }">
		<div align="right" style="width: 850px;">
			<a href="<%=contextPath%>/enroll.bo" class="btn btn-sm btn-secondary">글쓰기</a>
		</div>
		<br>
		<%--
		}
		--%></c:if>
		<table align="center" class="list-area">
			<thead>
				<tr>
					<th width="70">글번호</th>
					<th width="80">카테고리</th>
					<th width="300">제목</th>
					<th width="100">작성자</th>
					<th width="50">조회수</th>
					<th width="100">작성일</th>
				</tr>
			</thead>
			<%--
			if (!list.isEmpty()) {
			--%> <c:choose>
				<c:when test="${not empty list }">
			<%--
			for (Board b : list) {
			--%> <c:forEach var="b" items="${list }">
			<tbody>
				<tr>
					<td><%--=b.getBoardNo()--%>${b.boardNo }</td>
					<td><%--=b.getCategoryNo()--%>${b.categoryNo }</td>
					<td><%--=b.getBoardTitle()--%>${b.boardTitle }</td>
					<td><%--=b.getBoardWriter()--%>${b.boardWriter }</td>
					<td><%--=b.getCount()--%>${b.count }</td>
					<td><%--=b.getCreateDate()--%>${b.createDate }</td>
				</tr>
				<%--
				}
				} else {
				--%>
				</c:forEach>
				</c:when>
				<c:otherwise>
				<%-- 조회된 결과(list)에 따라서 데이터를 표시 --%>
				<%-- 게시글이 없는 경우 --%>
				<tr>
					<td colspan="6">조회된 게시글이 없습니다.</td>
				</tr>
				<%--
				}
				--%></c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<br>
		<br>
		<%--
		int i = 0;
		--%><c:set var="i" value="0"/>

		<div align="center" class="pagination"
			style="diplay: flex; justify-content: center;">
			<li
				class="page-item <%--if (pi.getCurrentPage() == 1) {--%> <c:if test='${pi.currentPage eq 1 }'> disabled<%-- } --%> </c:if>"
				id="previous"><a class="page-link"
				href="<%=contextPath%>/list.bo?cpage=<%-- =pi.getCurrentPage() - 1--%>${pi.currentPage }">&lt;</a></li>
			<%--
			for (i = pi.getStartPage(); i <= pi.getEndPage(); i++) {
			--%> <c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">

			<li
				class="page-item <%--if (pi.getCurrentPage() == i) {--%><c:if test='${pi.currentPage eq i }'> disabled<%-- }--%> </c:if>"><a
				class="page-link" href="<%=contextPath%>/list.bo?cpage=<%--=i--%>${i}"><%--=i--%>${i}</a></li>
			<%--
			}
			--%></c:forEach>
			<li
				class="page-item <%--if (pi.getCurrentPage() == pi.getMaxPage()) {--%><c:if test='${pi.currentPage eq pi.maxPage }'> disabled <%-- } --%></c:if>"
				id="next"><a class="page-link"
				href="<%=contextPath%>/list.bo?cpage=<%--=pi.getCurrentPage() + 1--%>">${pi.currentPage + 1 }&gt;</a></li>
		</div>
	</div>
	<script>
					$(function() {
						$(".list-area>tbody>tr").click(function(){
							location.href= '<%= contextPath %>/detail.bo?bno=' + $(this).children().eq(0).text();
						});
					});
	</script>
</body>

</html>