function checkId() {
    let area1 = document.getElementById("area1");

    // console.log(document.getElementById("userId").value);
    document.getElementById("area1").innerHTML = "";
    if(document.getElementById("userId").value != "") {
        if(document.getElementById("userId").value == "user01") {
            area1.innerHTML = "이미 존재하는 아이디입니다."
            area1.style.color = 'red';
        } else{
            if(document.getElementById("userId").value.indexOf(' ') != -1) {
                document.getElementById("userId").value = document.getElementById("userId").value.replace(' ', '');
                area1.innerHTML = "공백을 빼고 입력하세요!"
            } else {
                area1.innerHTML = "사용가능한 아이디입니다."
                area1.style.color = 'green';
            }
            
        }
    }
    
    
}

function checkPw() {
    let area3 = document.getElementById("area3");

    let userPw = document.getElementById("userPw");
    let userPwCheck = document.getElementById("userPwCheck");
    document.getElementById("area3").innerHTML = "";
    if(userPwCheck.value != "") {
        if(userPw.value == userPwCheck.value) {
            area3.innerHTML = "비밀번호가 일치합니다."
            area3.style.color = 'green';
        } else {
            area3.innerHTML = "비밀번호가 일치하지 않습니다."
            area3.style.color = 'red';
        }
    }
      
}

function signUp() {
    let userId = document.getElementById("userId");
    let userPw = document.getElementById("userPw");
    let userPwCheck = document.getElementById("userPwCheck");
    let name = document.getElementById("name");
    let area1 = document.getElementById("area1");
    let area2 = document.getElementById("area2");
    let area3 = document.getElementById("area3");
    let area4 = document.getElementById("area4");
    
    
    if(userId.value == null || userId.value == "") {
        alert("아이디를 입력하세요!");
        userId.focus();
    } else if(userPw.value == "") {
        alert("비밀번호를 입력하세요!");
    } else if(userPwCheck.value == "") {
        console.log(userPw.value + "1");
        console.log(userPwCheck.value+"2");
        alert("비밀번호 확인을 입력하세요!");
    } else if(name.value == "") {
        alert("이름을 입력하세요!");
    } else {
        if(userId.value == "user01") {
            alert("사용할 수 없는 아이디입니다.");
            userId.focus();
        } else if(userPw.value != userPwCheck.value) {
            alert("비밀번호가 일치하지 않습니다.");
            userPwCheck.focus();
        } else {
            alert(name.value + "님, 회원가입이 성공적으로 완료되었습니다^^");
            userId.value = "";
            userPw.value = "";
            userPwCheck.value = "";
            name.value = "";
            area1.innerHTML = "";
            area3.innerHTML = "";
        }
    }
}

// function test1() {
//     console.log("onkeydown:" + document.getElementById("userId").value);
// }

// function test2() {
//     console.log("onkeyup:" + document.getElementById("userId").value);
// }

// function test3() {
//     console.log("onkeypress:" + document.getElementById("userId").value);
// }
// function blurTest() {
//     console.log("blurTest:" + document.getElementById("userId").value);
// }

// function signup() {

// }