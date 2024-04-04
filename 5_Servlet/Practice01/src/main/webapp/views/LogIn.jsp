<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    background-color: rgb(248, 213, 219)
    
    
}

form {
    display: flex;
    flex-direction: column;
    align-items: center;

}
</style>
<body>
    <main>
        <form>
            <div><%= request.getAttribute("userId")%>님, 로그인에 성공했습니다.</div>
        </form>
    </main>
</body>
</html>