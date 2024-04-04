<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignIn</title>
</head>
<style>
    body {

        margin: 20%;
        background-color: rgb(248, 213, 219);
    }

    main {
        max-width: 800px;
        margin: 20px auto;
        padding: 20px;
        background-color: rgb(248, 213, 219);
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    
</style>
<body>
<% String userId = (String)request.getAttribute("userId");
String userPw = (String)request.getAttribute("userPw");
String userPwCheck = (String)request.getAttribute("userPwCheck");
String name = (String)request.getAttribute("name");
String phone = (String)request.getAttribute("phone");  %>
<main>
	<% if(name.equals("") || name == null) {
		out.println(userId+"님 환영 합니다^^");
		} else {
			out.println(userId+"("+name+")님 환영합니다^^");
		}%>
</main>


</body>
</html>