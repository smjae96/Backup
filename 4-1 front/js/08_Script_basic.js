// 함수 정의
// function 함수명(매개변수) { 실행할 스크립트 내용 }
function alertHi() {
    alert('안녕하세요');
}
function consoleLog() {
    console.log('콘솔창에 출력')
}
function question() {
    /*
        confirm(질문창)
        let 변수명 = [window.]confirm("질문할 내용") 
        변수명 => 예,OK,확인(true)/아니요,CANCEL,취소(false)
    */
   // 질문내용: 저장하시겠습니까?
   //   - 예 => 콘솔창에 "저장되었습니다." 출력
   //   - 아니오 => 콘솔창에 "취소되었습니다." 출력

   /*
    * 조건문 => if (조건식) { // 참일때 } else { // 거짓일때 }
    */

   let isSaved = confirm('저장하시겠습니까?');

   if(isSaved) {
    console.log('저장되었습니다.');
   } else {
    console.log('취소되었습니다.');
   }

}

function question2() {
    /*
        prompt : 질문을 하고 사용자에게 입력을 받을 수 있는 창
        let 변수명 = [window.]prompt("질문내용");
        질문에 대한 답변을 입력받아 문자열로 반환
        변수명 => 문자열 타입의 어떤 입력 값
    */
   let value = prompt('오늘 점심 메뉴는 무엇입니까?');

   console.log(value);

   // 문서 내에 html 형식으로 값을 출력하는 함수: innerHtml, innerText
   // area1 아이디 속성을 가진 요소에 사용자가 입력한 데이터를 출력
   // 오늘 (value)를 먹었습니다.
   // + value => 글자색을 다르게 표시

   /*
    1) area1 아이디 속성을 가진 요소에 접근 (document.getElementById('area1'))
    2) 변수명.innerHTML 또는 변수명.innerText = ".....";
    */
   (document.getElementById("area1").innerHTML = "오늘 <span style='color:red;'>" +value+"를 먹었습니다.");
}

function loginTest() {
    // userId라는 id속성을 가진 요소에 접근
    let userId = document.getElementById("userId");
    let idValue = userId.value; // #userId 가 가지고 있는 값
    console.log(userId);
    console.log(idValue);

    let userPw = document.getElementById("userPw");
    let pwValue = userPw.value; // #userPw 가 가지고 있는 값

    let result = document.getElementById("userInfo");
    result.value = idValue + "/" +  pwValue;

    userId.value = '';
    userPw.value = '';
}


