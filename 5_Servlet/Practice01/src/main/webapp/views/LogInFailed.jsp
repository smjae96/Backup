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
        background-color: rgb(248, 213, 219);
        display: flex;
        flex-direction: column;
        align-items: center;
        
        
    }

    

    .btns {
        width: 400px;
        height: 50px;
        margin: 20px;
        border-radius: 30px;
        border: 1px solid;
        color: white;
        font-size: 20px;
        font-weight: 900;
    }

    #btn-back {
        background-color: rgb(248, 138, 156);
        border-color: rgb(248, 138, 156);
        box-shadow: 4px 4px 4px rgb(235, 111, 132);
        cursor: pointer;
    }
</style>

<body>
    <main>
        
            <div>잘못된 정보입니다. 다시 시도해주세요.</div>          
            <button id="btn-back" class="btns" onclick="location.href='views/loginForm.html'">뒤로가기</button>
        
    </main>
</body>

</html>
