<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Project</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous">
</script>
</head>
<body>
	<h1>AJAX 통신</h1>
	<p>
		<i>"Asynchronous Javascript And XML"</i>의 약자로 <br> 서버로부터 데이터를 가져와
		전체 페이지를 바꾸지 않고 일부만 로드하여 변경하도록 하는 기법<br> <br> 기존에는 a태그를
		사용하거나, form태그의 submit 요청 방식은 "동기식" 요청 => 응답페이지가 전달되어야 확인 가능<br> <br>
		<br> * 동기식 vs 비동기식<br> - 동기식
	<ul>
		<li>요청 처리 후 해당 응답페이지가 전달된 후에 그 다음 작업 가능</li>
		<li>서버에 요청한 결과에 따라 응답이 지연되면 무작정 기다려야 함 (하얀 화면으로 표시)</li>
		<li>전체 페이지를 응답하기 때문에 기본적으로 페이지가 깜박거림이 있음</li>
	</ul>
	- 비동기식 (ajax)
	<ul>
		<li>현재 페이지를 그대로 유지하면서 추가적으로 필요한 요청이 있는 경우 사용</li>
		<li>요청 시 다른 페이지로 변경되지 않음 (현재 페이지가 유지됨)</li>
		<li>요청을 하고 해당 응답(데이터)이 돌아올 때까지 기다리지 않고, 다른 작업을 할 수 있음</li>
		<li>페이지 깜박거림이 없음!</li>
	</ul>
	ex) 검색어 자동완성, 아이디 중복체크, 찜하기/해제하기, 추천, 댓글 등등..
	<br>
	<br> * 비동기식 단점
	<br>
	<ol>
		<li>현재 페이지에 지속적으로 리소스가 쌓임 => 페이지가 느려질 수 있음</li>
		<li>오류 발생 시 디버깅 어려움</li>
		<li>요청 처리 후 응답된 데이터를 가지고 새로운 요소(태그)를 만들어서 화면에 표시해야 함 => DOM 요소들을
			새로 만드는 구문을 잘 익혀둬야함.</li>
	</ol>
	<br>
	<br> * AJAX 구현 방식
	<br> - 순수 자바스크립트 방식 (브라우저마다 방식을 다르게 해야할 수도 있음)
	<br> - jQuery 방식 (코드가 간결하고 사용하기 쉬움)
	</p>
	<pre>
        * jQuery 방식으로 AJAX 통신

        $.ajax({
            속성명: 속성값,
            속성명: 속성값,
            속성명: 속성값,
            ...
        });

        - 주요 속성
            + url : 요청할 주소(url)
            + type/method : 요청 전송 방식 (get/post)
            + data : 요청 시 전달할 값
            + success : 통신 성공 시 실행할 함수 정의
            + error : 통신 실패 시 실행할 함수 정의
            + complete : 통신 성공/실패 상관없이 무조건 실행할 함수 정의

        - 부수적인 속성
            + async : 서버와의 비동기 처리 방식 설정 여부 (기본값: true)
            + contentType : 요청 시 데이터 인코딩 방식 (request 데이터 인코딩)
            + dataType : 서버에서 응답 시 전달되는 데이터 형식 설정, 값이 없다면 자동으로 판단됨
                            * xml : 트리 형태의 데이터 구조
                            * json : 맵 형태의 데이터 구조 (일반적인 데이터 구조)
                            * script : 자바스크립트 및 일반 문자열 형태 데이터
                            * html : html 태그 자체를 리턴하는 방식
                            * text : 문자열 데이터
            + accept : 파라미터 타입 설정 ( 사용자 특화된 파라미터 타입 설정 가능 )
            + beforeSend : 요청 전 실행되는 이벤트 콜백 함수 (데이터 가공 및 헤더 관련 설정)
            + cache : 요청 및 결과값을 스코프(scope)에서 가지고 있지 않게 하는 것 (기본값: true)
            + contents : jQuery에서 응답의 데이터를 파싱하는 방식 정의
            + crossDomain : 다른 도메인 호출 가능 여부 설정 (기본값: false)
            + dataFilter : 응답을 받았을 때 정상적인 값을 리턴할 수 있도록 데이터와 데이터 타입 설정
            + global : 기본 이벤트 사용 여부 (ajaxStart, ajaxStop), 버퍼링 같이 시작과 끝을 나타낼때 선처리 작업
            + password : 서버에 접속 권한(비밀번호)이 필요한 경우 설정
            + processData : 서버로 보내는 값에 대한 형태 설정 여부 (기본 데이터를 원하는 경우 false로 설정)
            + timeout : 서버 요청 시 응답 대기 시간 (단위: milisecond)
    </pre>
	<hr>
	<h1>jQuery 방식을 이용한 AJAX 테스트</h1>

	<h3>1. 버튼 클릭 시 get 방식으로 서버에 요청 및 응답</h3>
	입력 :
	<input type="text" id="input1">
	<button id="btn1">전송</button>
	<br> 응답 :
	<span id="output1">응답 없음</span>

	<script>
        $(function() {
            $("#btn1").click(function(){
                // 기존 동기식 통신
                // location.href = 'jqAjax1.do?input='+ $("#input1").val() + '&test=1000';

                // 비동기식 통신(ajax)
                $.ajax({
                    url: 'jqAjax1.do',
                    data: {
                        input: $("#input1").val()
                    },
                    type: 'get',
                    success: function(result){    // 통신 성공 시 실행할 함수
                        console.log("통신 성공");
                        // document.getElementById("output1").innerHTML = result;
                        $("#output1").html(result); 
                        console.log(result)
                    },
                    error: function() {     // 통신 실패 시 실행할 함수
                        console.log("통신 실패")
                    },
                    complete: function() {  // 통신 성공/실패 상관없이 무조건 실행할 함수
                        console.log("통신 성공/실패 상관없이 실행")
                    }
                });
            });
        })
    </script>

	<br>

	<h3>2. 버튼 클릭 시 post방식으로 서버에 여러 개 데이터 전송 및 응답</h3>
	이름:
	<input type="text" id="name">
	<br> 나이:
	<input type="number" id="age">
	<br>
	<button onclick="sendPostData()">전송</button>
	<!--  1) 문자열로 응답받았을 경우 처리 
    응답 : <div id="output2"></div>
    <script>
        // 함수 정의 방식
        const sendPostData = () => {
            $.ajax({
                url: 'jqAjax2.do',
                data: {
                    name: $("#name").val(),
                    age: $("#age").val()
                },
                type: 'post',
                success: function(result) {
                    console.log(typeof result)
                    // .innerHTML ==> .html()
                    // .innerText ==> .text()
                    $("#output2").html(result);

                    // 입력받은 요소를 초기화
                    // .value ==> .val()
                    $("#name").val("");
                    $("#age").val("");
                },
                error: function(err) {
                    console.log("POST 테스트#1 통신 실패!");
                    console.log(err);
                }
            })
        }
    </script>
    -->
	응답 :
	<ul id="output2">
		<script>
        // 함수 정의 방식
        const sendPostData = () => {
            $.ajax({
                url: 'jqAjax2.do',
                data: {
                    name: $("#name").val(),
                    age: $("#age").val()
                },
                type: 'post',
                success: function(result) {
                    console.log(typeof result)
                    
                    // JSONArray 타입으로 응답 시 처리 => ["홍길동", 20]
                    /*
                    for(let val of result) {
                    	$("#output2").append("<li>" + val + "</li>");
                    }
                    */
                    // JSONObject 타입으로 응답 시 처리 => { name : "홍길동", age: 20 }
                    const value = "<li>" + result.name + "</li>"
                    			+ "<li>" + result.age + "</li>"
              		$("#output2").html(value);
              		
                },
                error: function(err) {
                    console.log("POST 테스트#1 통신 실패!");
                    console.log(err);
                }
            })
        }
    </script>
	</ul>

    <br>
    <h3>3. 서버에 데이터 전송 후 vo객체로 응답받기</h3>
    회원 번호 : <input type="number" id="userNo">
    <button onclick="searchUser()">조회</button>
    <div id="output3"></div>
    <script>
        function searchUser() {
            $.ajax({
                url: 'jqAjax3.do', 
                data: { userNo: $("#userNo").val()},
                success: function(result) {   
                    console.log(typeof result, result);
                    // $("#output3").html(result.)
                },
                error: function() {
                    console.log("통신 실패#3 : 회원번호 조회")
                }
            })

        }
    </script>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>