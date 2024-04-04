<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Result</title>
</head>
<body>
	<%
		String name = (String)request.getAttribute("name");
		String phone = (String)request.getAttribute("phone");
		String address = (String)request.getAttribute("address");
		String requestion = (String)request.getAttribute("requestion");
		
		String menu = (String)request.getAttribute("menu");
		String[] topping = (String[])request.getAttribute("topping");
		String[] side = (String[])request.getAttribute("side");
	%>
    <h1>피자 주문 내역</h1>
    <br>
    <h3>주문자 정보</h3>
    <%-- <% out.print(address) %> --%>
    <br><br>
    <div style="color:blue"><%= request.getAttribute("address") %></div>
    <div style="color:blue"><%= request.getAttribute("phone") %></div>
    <br><br>
    <h3>요청 사항</h3>
    <% if(requestion.isEmpty()) { %>
    	없음
   	<% } else { %>
   		<%= requestion %>
	<% } %>			
    <hr>
    <h3>주문 정보</h3>
    <%= menu %>
    <ul>
    	<li>
    		토핑 추가 항목
    		<% if (topping == null) { %>
    			없음
   			<% } else { %>
   				<ul>
   					<% for(String toppings: topping) { %>
   						<li><%= toppings %></li>
					<% } %>
   				</ul>	
			<% }%>
		</li>
		<li>
			사이드 선택 항목
			<% if (side == null) { %>
				없음
			<% } else { %>
				<ul>
					<% for (String sides : side) { %>
						<li><%= sides %></li>
					 <%} %>
				</ul> 
			<% } %>
		</li> 
	</ul>
	<hr>
	<h2><%= name %>님!</h1>
	<h2>즐거운 식사 되세요.</h1>
    	
    
    
    


</body>
</html>