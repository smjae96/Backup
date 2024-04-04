
function changeTotal() {
    // 전체선택 체크박스 요소 가져오기 => id 속성으로 가져오기!
    let totalChk = document.getElementById("total");
    console.log(totalChk.checked); // 체크된 상태에서는 true, 체크 해제된 상태에서는 false 반환.
    
    // 전체선택 체크박스의 변화에 따라 모든 체크박스 상태를 바꾸고자 할 때
    let allCheckBox = document.getElementsByName("hobby");

    // foreach문과 동일하게 동작하는 방식
    for(let checkbox of allCheckBox) {
        checkbox.checked = totalChk.checked;
    }
}
function checkBoxTrigger() {
    let allChecked = true;
    let hobbyList = document.getElementsByName("hobby");

    for(let hobby of hobbyList) {
        // 체크박스 중에 체크해제가 된 항목이 있을 경우
        if(!hobby.checked && hobby.id != 'total') {
            // allChecked 변수의 값을 false로 변경
            allChecked = false;
        }
    }

    for(let i=0; i<hobbyList.length; i++) {
        if(!hobbyList[i].checked && i != 0) {
            allChecked = false;
        }
    }

    // if(hobbyList[0].checked && hobbyList[1].checked && hobbyList[2].checked) {
    //         allChecked = true;
    // }

    let totalChk = document.getElementById("total");
    totalChk.checked = allChecked;
}

function categoryChoose() {
    let answer = document.getElementById("area1");
    let categoryList =  document.getElementsByName("hobby");
    console.log(categoryList);

    answer.innerHTML = "";
    for(let i=0; i<categoryList.length; i++) {
        if(categoryList[i].checked && i!=0) {
            answer.innerHTML += categoryList[i].value + " "
        }

    }
    

    // let check = document.getElementById("area1");
    // check.innerHTML = categoryList;
}