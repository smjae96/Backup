<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.*, java.util.ArrayList, com.kh.board.model.vo.Category" %>
<% Board b = (Board)request.getAttribute("board");
   Attachment at = (Attachment)request.getAttribute("attachment");	
   ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<style>
    .outer {
        background: black; color: white;
        width: 1000px; height: 600px;
        margin: auto; margin-top: 50px;
    }
    form table { border: 1px solid white;}
    form input, form textarea {width: 100%; }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="outer" align="center">
        <br>
        <h2>일반게시판 수정하기</h2>
        <br>

        <form action="<%= contextPath %>/update.bo" method="post", enctype="multipart/form-data">
        	<input type="hidden" name="num" value= "<%=b.getBoardNo() %>">
            <table>
            <tr>
					<th>카테고리</th>
					<td>
						<%-- Category 테이블에서 조회된 항목을 표시 --%>
						
						<select name="category">
						<% if(!list.isEmpty()) { %>
						<% for(int i=0; i<list.size(); i++) { %>
							<option value="<%= list.get(i).getCategoryNo() %>"><%=list.get(i).getCategoryName() %></option>
						<% } }%>	
						</select>
					</td>
				</tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" value = "<%= b.getBoardTitle() %>" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" cols="30" rows="10" required style="resize: none;"><%= b.getBoardContent() %></textarea></td>
                </tr>
                <tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="upfile"/>
					</td>
					
				</tr>
            </table>
            <br><br>
            <div>
                <button type="submit">수정하기</button>
                <button type="button" onclick="history.back()">뒤로가기</button>
            </div>
        </form>
    </div>
</body>
</html>