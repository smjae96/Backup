function calculate() {
    let result = document.getElementById("result");
    let firstValue = document.getElementById("first-value");
    let math = document.getElementById("math");
    let secondValue = document.getElementById("second-value");
    result.style.background = ""

    if(math.value == "+") {
        result.value = parseInt(firstValue.value) + parseInt(secondValue.value);
    } else if(math.value == "-") {
        result.value = parseInt(firstValue.value) - parseInt(secondValue.value);
    } else if(math.value == "*") {
        result.value = parseInt(firstValue.value) * parseInt(secondValue.value);
    } else if(math.value == "/") {
        if(parseInt(secondValue.value) == 0) {
            result.value = "연산불가";
            result.style.background = "red";
        } else {
            result.value = parseInt(firstValue.value) / parseInt(secondValue.value);
        }  
    } else {
        if(parseInt(secondValue.value) == 0) {
            result.value = "연산불가";
            result.style.background = "red";
        } else {
            result.value = parseInt(firstValue.value) % parseInt(secondValue.value);
        }  
    }
    
}

function test4() {
    var area4 = document.getElementById("area4");

    var name = "홍길동"; // 변수
    var dog = { // 객체
        name : "토토",
        kind : "푸들",
        eat : function(food) {
            area4.innerHTML += this.kind + " 종류인 " + this.name + "가 " + food + "를 먹고 있어요.<br>";

        }
    };
    dog.eat("apple");
}