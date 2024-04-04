
function test() {
    let resultEle = document.getElementById("test");

    let userInfo = "이름 : " + document.getElementById("name").value + "<br>"
                + "아이디 : " + document.getElementById("userId").value + "<br>"
                + "비밀번호 : " + document.getElementById("userPw").value + "<br>"
                + "연락처 : " + document.getElementById("phone").value;

    resultEle.innerHTML = userInfo + "<br>이름:" + document.getElementById("name").value + "<br>"
    + "아이디:" + document.getElementById("userId").value + "<br>"
    + "비밀번호:" + document.getElementById("userPw").value + "<br>"
    + "연락처:" + document.getElementById("phone").value + "<br>";
    
    resultEle.style = "color : red"

}
