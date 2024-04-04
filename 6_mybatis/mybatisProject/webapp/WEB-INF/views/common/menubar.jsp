<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis</title>
<style>
    .login-area a {
        text-decoration: none;
        color: black;
        font-size: 12px;
    }

    .nav-area {
        background: #ffd9e5; color: white; height: 50px;
    }
    .menu {
        display: table-cell; width: 250px; height: 50px; vertical-align: middle;
        font-size: 20px; font-weight: bold;
    }
    .menu:hover {
        background: rgb(245, 245, 151);
        cursor: pointer;
    }
    /* 공통적으로 사용되는 css */
    .outer {
        width: 1000px;
        background: #ffd9e5;
        color: white;
        margin: auto;
        margin-top: 50px;
    }
</style>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous">
</script>
<!-- bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- bootstrap JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<c:if test="${alertMsg != null }">
		<script>
			alert("${alertMsg}")
		</script>
		<c:remove var="alertMsg" scope="session" />
	</c:if>
    <h1 align="center">Welcome to Mybatis World</h1>
    <br>
    <div class="login-area" align="right">
        <!-- 로그인 전 표시할 부분-->
        <!-- choose-when-otherwise 쓸 때는 그 내부에 주석이 들어가면 안됨. -->
        <c:choose>
			<c:when test="${loginUser == null}">
        <form action="login.me" method="post">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="userId"></td>
                    <td rowspan="2">
                        <button type="submit" style="height: 50px;">로그인</button>
                    </td>
                </tr>
                <tr>
                    <td>패스워드</td>
                    <td><input type="password" name="userPwd"></td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <a href="enrollForm.me">회원가입</a>
                        <a href="">아이디/비밀번호찾기</a>
                    </td>
                </tr>
            </table>
        </form>
        </c:when>
        <c:otherwise>
        <div>
            <table>
                <tr>
                    <td colspan="2">
                        <h3>${loginUser.userName }님 환영합니다^^</h3>
                    </td>
                </tr>
                <tr align="center">
                    <td><a href="mypage.me">마이페이지</a></td>
                    <td><a href="logout.me">로그아웃</a></td>
                </tr>
            </table>
        </div>
        </c:otherwise>
    </c:choose>
    </div>
    	
    <br>
    <div class="nav-area" align="center">
        <div class="menu">HOME</div>
        <div class="menu">공지사항</div>
        <div class="menu" onclick="board()">게시판</div>
        <div class="menu">ETC</div>
    </div>
</body>
<script>
	function board() {
		location.href = "list.bo?cpage=1";
	}
</script>
</html>