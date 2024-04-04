function test() {
    alert("테스트함수 호출");
}

function documentWrite() {
    document.write('<b>화면에 출력</b><br><h2>태그가 먹힐까?</h2>');

    let table="<table border= '1'>";
        table+= "<tr>";
        table+= "<td>1</td>";
        table+= "<td>2</td>";
        table+= "</tr>";
        table+= "</table>";
    
    document.write(table);
}

function tagValue() {
    // id 속성값이 area1인 div의 내용물을 가져와서 콘솔에 찍고 싶음.
    // 특정 요소의 값을 가지고 온다거나 변경하고자 할 때
    // 우선적으로 해당 요소 객체를 소스코드상으로 끌고와야함.
    let divEl = document.getElementById("area1");
    // div 요소 자체를 코드상으로 끌고와서 변수에 담음 => 요소객체

    // 변수에 값이 담겨있나 확인
    console.log(divEl); 
    console.dir(divEl);
    // 해당 값의 디렉토리 구조를 보고자 할 때

    // 선택된 요소 내에 정보들을 알아내고자 한다면?
    // .속성명으로 정보를 알아낼 수 있음
    console.log(divEl.id);
    console.log(divEl.className);

    // .innerHTML, .innerText로 content영역에 값을 알아낼 수 있음.
    console.log(divEl.innerHTML);
    // 요소의 content영역 안의 html태그들까지 다 포함하여 문자열로 출력
    console.log(divEl.innerText);
    // 요소의 content내의 실제 텍스트 내용만 포함하여 문자열로 출력

    divEl.innerHTML="<b>innerHTML<br>로 속성값을 변경하였음.</b>";
    console.log("변경후 : "+divEl.innerHTML);
    // innerHTML로 문자열 내용 변경하면, 출력할 문구에 HTML 태그가 있을 경우
    // 태그가 인식되어 스타일 적용.
    // 속성값이 잘 변경되었음.

    divEl.innerText="<b>innerText로 속성값을 변경했음</b>";
    console.log("변경후 : "+divEl.innerText);
    // innerText로 문자열 내용을 변경하면, 출력할 문구에 html태그가 있을 경우
    // 태그로 인식하지 않고, 문자열로 그대로 출력됨.
}
function question2() {
    let answer = prompt('오늘 점심은 뭡니까?');

    console.log(answer);

    // 문서 내에 html 형식으로 값을 출력하는 함수: innerHtml, innerText
   // area1 아이디 속성을 가진 요소에 사용자가 입력한 데이터를 출력
   // 오늘 (answer)를 먹었습니다.
   // + answer => 글자색을 다르게 표시
    let value = document.getElementById("area1");
    value.innerHTML = '오늘<span style="color: red;">'+answer+'</span>를(을) 먹었습니다.';
    
}
function idCheck() {
    // 우선적으로, 요소 자체를 끌고옴
    let userIdEl = document.getElementById("userId");
    // 사용자가 입력한 아이디값
    let userId = userIdEl.value;
    let divEl = document.getElementById("idCheck");

    if(userId=="user01") {
        //중복된 아이디일 경우
        divEl.innerHTML='사용불가한 아이디입니다.';
        alert('사용불가능한 아이디입니다.');
    } else {
        //사용가능한 아이
        divEl.innerHTML='사용가능한 아이디입니다.';
        alert('사용 가능한 아이디입니다.')
    }
}

function arrayTest1() {
    let arr = ["홍길동", "서울", 20, true, [1,2,3]];    // 배열객체

    console.log(arr);
    console.log(arr[2]);
    console.log(arr[3]);
    console.log(arr[4]);
    // 자료형이 달라도 배열에 담을 수 있다.

    console.log(arr[4][0]); // [1,2,3] 중 1
    // 배열객체 안의 배열의 인덱스로 접근하여 값을 출력

    let area1 = document.getElementById("area1");

    for(let i=0; i<arr.length; i++) {
        area1.innerHTML += "<br>"+arr[i]+"<br>";
    }
    // for in문 활용도 가능함.
    for(let i in arr) {
        area1.innerHTML += arr[i] + "<br>"
    }
}
function arrayTest2() {
    let arr1 = new Array(); // 크기가 0인 빈 배열
    let arr2 = new Array(3);    // 크기가 3인 빈 배열
    let arr3 = []; // 크기가 0인 빈 배열

    console.log(arr1); // []
    console.log(arr2); // (3) [빈*3]
    console.log(arr3); // []

    // 배열에 값 대입
    arr1[0] = "바나나";
    arr1[1] = "사과";
    // ...
    arr1[10] = "키위";

    console.log(arr1); // length : 11
    // (11) ['바나나', '사과', 빈x8, '키위]
    // 바나나, 사과, 키위의 값이 잘 들어가 있는 것을 볼 수 있다.
    // 나머지는 비어 있다(2~9번째 인덱스값 8개)

    arr2[0] = "자동차";
    arr2[1] = "기차";
    arr2[2] = "도보";
    arr2[3] = "비행기";

    console.log(arr2);  // length : 4
    // 배열 선언시의 크기보다 더 많은 값을 삽입할 수 있다.

    // 배열 선언과 동시에 초기화
    let arr4 = new Array("홍길동")

}

function indexOfTest() {
    let indexof = document.getElementById("indexOf")

    let arr = ["사과", "딸기", "바나나", "복숭아", "파인애플"];
}