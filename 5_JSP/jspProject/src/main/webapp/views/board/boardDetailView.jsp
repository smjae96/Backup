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
			width: 1000px; height: 1500px; margin: auto; margin-top: 50px;
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
				<td><%= b.getCategoryNo() %></td>
				<th>제목</th>
				<td><%= b.getBoardTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%= b.getBoardWriter() %></td>
				<th>작성일</th>
				<td><%= b.getCreateDate() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<p style="height: 200px"><%= b.getBoardContent() %></p>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">
					<%-- 첨부파일이 없는 경우 --%>
					<% if(a == null) { %>
					첨부파일이 없습니다.
					<% } else { %>
					<%-- 첨부파일이 있는 경우 --%>
					<a download href="<%=contextPath %>/<%= a.getFilePath() %><%= a.getChangeName()%>"><%= a.getOriginName() %></a>
					<% } %>
				</td>
			</tr>
		</table>
		<br><br>
		<div align="center">
			<a href="javascript:window.history.back();" class="btn btn-info">목록으로 돌아가기</a>
			<%-- 로그인한 사용자와 게시글 작성자가 동일한 경우 표시 --%>
			<% if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())) { %>
				<a href="<%= contextPath %>/updateForm.bo?bno=<%= b.getBoardNo() %>" class="btn btn-warning">수정하기</a>
				<a href="<%= contextPath %>/delete.bo?bno=<%= b.getBoardNo() %>&attach=<%= a %>" class="btn btn-danger">삭제하기</a>
			<% } %>
		</div>
		<br>
		<div id="reply-area">
			<table border="1" align="center">
				<thead>
					<tr>
						<th>댓글작성</th>
						<td>
							<textarea rows="3" cols="50" style="resize:none;" id="reply-input"></textarea>
						</td>
						<td>
							<button id="btn1">댓글 등록</button>
						</td>
					</tr>
				</thead>
				<tbody id="replyList">
				</tbody>
			</table>
			<script>
			let replyList = document.getElementById("replyList");
				$(function(){
					$("#btn1").click(function() {
						$.ajax({
							url: '<%=contextPath%>/AjaxReplyInsertController',
							data: {
								reply : $("#reply-input").val(),
								boardNo : <%= b.getBoardNo()%>
							},
							type: 'get',
							success: function(result) {
								if(result.result == 1) {
									alert("댓글 작성 성공!")
								} else {
									alert("댓글 작성 실패!")
									return;
								}
								
							},
							error: function() {
								console.log("댓글 작성 실패")
							}
							
						})
					})
					
					// 페이지가 로드되었을 때 아래 함수 호출
					selectReplyList();
				});
				
				function selectReplyList() {
					// rlist.do 로 요청하여 결과를 댓글 목록에 표시
					//  - 전달 데이터 => boardNo
					$(function(){
						$.ajax({
							url: '<%=contextPath%>/rlist.do',
							data: {
								boardNo : <%= b.getBoardNo() %>
							}, 
							type: 'get',
							success: function(result) {
								let childNodes = '';
								console.log(result);
								for(let i=0; i<result.length; i++) {
									
									childNodes +=
									"<tr>"+
									"<td>"+ result[i].replyWriter+"</td>"+	
									"<td>"+result[i].replyContent+"</td>"+
									"<td>"+result[i].createDate+"</td>"+
									"</tr>"
								}
								replyList.innerHTML = childNodes
							},
							error: function() {
								console.log("댓글 조회 실패!")
							}
						})
					})
					
				}
			</script>
		</div>
	</div>
</html>