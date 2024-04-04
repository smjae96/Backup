<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.notice.model.vo.Notice" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<style>
	.outer { background-color: black; color: white;
			width: 1000px; height: 500px; margin: auto; margin-top: 50px;
		}
	.outer table {
		border: 1px solid white;
		border-collapse: collapse;
	}
	
	.outer > table tr, .outer > table td {
		border: 1px solid white; 
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer" align="center">
		<br>
		<h2 align="center">공지사항 상세보기</h2>
		<br>
		
		<table>
			<tr>
				<th width="70">제목</th>
				<td colspan="3" width="400"><%--= n.getNoticeTitle() --%>${notice.noticeTitle }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%--= n.getNoticeWriter() --%>${notice.noticeWriter }</td>
				<th>작성일</th>
				<td><%--= n.getCreateDate() --%>${notice.createDate }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<p style="height: 150px"><%--= n.getNoticeContent() --%>${notice.noticeContent }</p>
				</td>
			</tr>
		</table>
		<br><br>
		<div>
			<a href="<%= contextPath %>/list.no" class="btn btn-info">목록으로 돌아가기</a>
			<%-- 로그인한 계정이 관리자인 경우에만 수정하기/삭제하기 버튼이 표시되도록 --%>
			<%-- if(loginUser != null && loginUser.getUserId().equals(n.getNoticeWriter())) { --%>	<c:if test="${loginUser != null and loginUser.userId eq notice.noticeWriter }">
				<a href="<%= contextPath %>/updateForm.no?num=<%--= n.getNoticeNo() --%>${notice.noticeNo}" class="btn btn-warning">수정하기</a>
				<a href="<%= contextPath %>/delete.no?num=<%--= n.getNoticeNo() --%>${notice.noticeNo}" class="btn btn-danger">삭제하기</a>
				
			</c:if>
			
		</div>
	</div>
</body>
</html>