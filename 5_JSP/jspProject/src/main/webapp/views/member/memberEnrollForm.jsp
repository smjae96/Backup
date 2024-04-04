<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        margin: auto;
        margin-top: 50px;
    }
    /* margin: auto; => 왼쪽,오른쪽 동일한 비율로 가운데로 정렬 */
    #enroll-form table {
        margin: auto;
    }
    #enroll-form input {
        margin: 5px;
    }
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

    <div>
        <br>
        <h2 align="center">회원가입</h2>
        <form action="<%= contextPath %>/insert.me" id="enroll-form" method="post">
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" required></td>
                    <td><button type="button" onclick="checkUserId()">중복확인</button></td>
                </tr>
                <tr>
                    <td>* 비밀번호</td>
                    <td><input type="password" name="userPwd" maxlength="15" required id="pw"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 비밀번호 확인</td>
                    <td><input type="password" name="userPwdCheck" maxlength="15" required id="pw2"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" maxlength="6" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" placeholder="- 포함해서 입력"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" name="email" ></td>
                    <td></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address" ></td>
                    <td></td>
                </tr>
                <tr>
                    <td>관심분야</td>
                    <td colspan="2">
                        <input type="checkbox" name="interest" id="sports" value="운동">
                        <label for="sports">운동</label>
        
                        <input type="checkbox" name="interest" id="climbing" value="등산">
                        <label for="climbing">등산</label>
        
                        <input type="checkbox" name="interest" id="fishing" value="낚시">
                        <label for="fishing">낚시</label>
                        <br>
                        <input type="checkbox" name="interest" id="cooking" value="요리">
                        <label for="cooking">요리</label>
        
                        <input type="checkbox" name="interest" id="game" value="게임">
                        <label for="game">게임</label>
        
                        <input type="checkbox" name="interest" id="movie" value="영화">
                        <label for="movie">영화</label>
                    </td>
                </tr>
            </table>
        
            <br><br>
        
            <div align = "center">
                <button type="submit" onclick="return checkPwd();" disabled id=signUp>회원가입</button>
                <button type="reset">초기화</button>
            </div>
        
            <br><br>
        
        </form>
        <script>
            function checkPwd() {
                // 비밀번호, 비밀번호 확인 요소 접근해서 값을 꺼내온 뒤
                let userPwd = document.querySelector("#enroll-form input[name=userPwd]");
                let userPwdCheck = document.querySelector("#enroll-form input[name=userPwdCheck]");
                // let pw = document.getElementById("pw").value;
                // let pw2 = document.getElementById("pw2").value;

                // 다른 경우 false를 리턴.
                if(userPwd.value != userPwdCheck.value) {
                    alert("비밀번호가 일치하지 않습니다!")
                    document.getElementById("pw2").focus();
                    return false;
                }
            }
            
            function checkUserId() {
            	// 입력된 아이디 값 꺼내오기(id 속성이 enroll-form인 form 태그 안의 name 속성이 userId인 input 태그로 접근) --> 왜냐하면 로그인 영역에도 name=userId인 input태그가 있기 때문
            	const $userId = $("#enroll-form input[name=userId]");
            	
            	$.ajax({
            		url : 'idCheck.me',
            		type : 'get',
            		data : { checkId: $userId.val() },	// 전달데이터의 키값: checkId, 데이터값: userId
            		success : function(result) {	// 중복되는 값이 있을 때는 YYY  , 없을 때는 NNN 응답
            			// 중복되지 않은 경우, 사용자에게 "해당 아이디를 사용하시겠습니까?" 질문 후
            			// 			사용하는 경우 회원가입 버튼 활성화
                        
            			if(result == 'NNN') {
            				let conf = confirm('사용하실 수 있는 아이디입니다. 해당 아이디를 사용하시겠습니까?')
            				if(conf == true) {
                                $("#enroll-form : submit").attr("disabled", false);
                                $userId.attr("readonly", true);
                            } else {
                                $userId.focus();
                            }
                            
            			} else {
                            alert('이미 등록된 아이디입니다!')
                            $userId.focus();
                        }
            					
            		},
            		error : function(err) {
            			console.log("아이디 중복체크 통신 실패!");
            			console.log(err);
            		}
            	});
            }
        </script>
    </div>
</body>
</html>