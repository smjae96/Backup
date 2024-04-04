<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.Board, com.kh.board.model.vo.*" %>
<%
Board b = (Board)request.getAttribute("board");
Attachment a = (Attachment)request.getAttribute("attachment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<style>
	.outer { background-color: black; color: white;
			width: 1000px; height: 800px; margin: auto; margin-top: 50px;
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
		<h2 align="center">일반게시글 상세보기</h2>
		<br>
		
		<table>
			<tr>
				<th>카테고리</th>
				<td><%--= b.getCategoryNo() --%>${board.categoryNo }</td>
				<th>제목</th>
				<td><%--= b.getBoardTitle() --%>${board.boardTitle }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%--= b.getBoardWriter() --%>${board.boardWriter }</td>
				<th>작성일</th>
				<td><%--= b.getCreateDate() --%>${board.createDate }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<p style="height: 200px"><%--= b.getBoardContent() --%>${board.boardContent }</p>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">
					<%-- 첨부파일이 없는 경우 --%>
					<%-- if(a == null) { --%> <c:choose>
					<c:when test="${attachment == null }">
					첨부파일이 없습니다.
					<%-- } else { --%>
					</c:when>
					<c:otherwise>
					<%-- 첨부파일이 있는 경우 --%>
					<a download href="<%=contextPath %>/<%--= a.getFilePath() --%>${attachment.filePath}${attachment.changeName}<%--= a.getChangeName()--%>">${attachment.originName}<%--= a.getOriginName() --%></a>
					<%-- } --%>
					</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
		<br><br>
		<div align="center">
			<a href="javascript:window.history.back();" class="btn btn-info">목록으로 돌아가기</a>
			<%-- 로그인한 사용자와 게시글 작성자가 동일한 경우 표시 --%>
			<%-- if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())) { --%> <c:if test="${loginUser != null and loginUser.userId eq board.boardWriter }">
				<a href="<%= contextPath %>/updateForm.bo?bno=<%--= b.getBoardNo() --%>${board.boardNo}" class="btn btn-warning">수정하기</a>
				<a href="<%= contextPath %>/delete.bo?bno=<%--= b.getBoardNo() --%>${board.boardNo }&attach=<%--= a --%>${attachment}" class="btn btn-danger">삭제하기</a>
			<%-- } --%></c:if>
		</div>
		<br>
		<div id="reply-area">
			<table border="1" align="center">
				<thead>
					<tr>
						<th>댓글작성</th>
						<td>
							<textarea rows="3" cols="50" style="resize:none;"></textarea>
						</td>
						<td>
							<button>댓글 등록</button>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%--= loginUser.getUserId() --%>{$ loginUser.userId}</td>
						<td>@@댓글내용@@</td>
						<td>@@작성일@@</td>
					</tr>
				</tbody>
			</table>
			<script>
				$(function(){
					// 페이지가 로드되었을 때 아래 함수 호출
					selectReplyList();
				});
				
				function selectReplyList() {
					// rlist.do 로 요청하여 결과를 댓글 목록에 표시
					//  - 전달 데이터 => boardNo
				}
			</script>
		</div>
	</div>
</html>