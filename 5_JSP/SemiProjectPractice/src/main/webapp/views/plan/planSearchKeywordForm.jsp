<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.kh.plan.model.vo.Plan"%>

<%
ArrayList<Plan> list = (ArrayList<Plan>) session.getAttribute("planList");
ArrayList<Plan> listKeyWord = (ArrayList<Plan>) session.getAttribute("planListKeyWord");
String contextPath = request.getContextPath();
String userId = (String) session.getAttribute("userId");
int count = 0;
int nCount = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan 작성하기</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script src="https://kit.fontawesome.com/eee69deb72.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" href="css/plan.css">
<script src="js/plan.js"></script>
<style>
	.plan-complete {
		text-decoration: line-through;
		text-decoration-thickness: 3px; 
	}
	a {
		text-decoration: none;
	}
</style>
</head>
<body>

	<header>
		<h1>
			<b>Plan 작성하기</b>
		</h1>
		<!-- <div>
        <span class="onoff-switch-container">
            <button id="darkModeToggle">다크 모드 On/Off</button>
            <input type="checkbox" name="onoff-switch" id="onoff-switch1" />
            <label for="onoff-switch1">다크 모드</label>
        </span>
    </div> -->
		<div id="icons" style="max-width: 800px; margin: 20px auto;">
			<button class="btn btn-secondary btn-sm" type="button"
				data-bs-toggle="dropdown" aria-expanded="false">
				<i class="fas fa-cog" style="color: black; font-size: 30px;"></i> <span
					class="visually-hidden">Toggle Dropdown</span>
			</button>
			<ul class="dropdown-menu">
			</ul>
			<button class="btn btn-secondary btn-sm" type="button"
				data-bs-toggle="dropdown" aria-expanded="false">
				<!-- onclick="showInfo()" > -->
				<i class="fas fa-user" style="color: black; font-size: 30px;"></i> <span
					class="visually-hidden">Toggle Dropdown</span>
			</button>
			<ul class="dropdown-menu" id="dropdown-menu"
				style="flex-direction: column; justify-content: flex-end; padding-bottom: 0px; height: 96px;">
				<li
					style="border: 0px solid black; text-align: center; height: 55px;">
					<i class="fas fa-user" style="color: black; font-size: 30px;"></i>
					<div><%= userId %> 님</div>
				</li>
				<div style="display: flex; text-align: center;">
					<li
						style="width: 50%; font-size: small; margin-bottom: 0px; border-radius: 0px; border-bottom: 0px; border-left: 0px; border-right: 0px">
						<b><a href="/views/plan/signin.html">로그아웃</a></b>
					</li>
					<li
						style="width: 50%; font-size: small; margin-bottom: 0px; border-radius: 0px; border-bottom: 0px; border-right: 0px; background-color: black; color: #fff;">
						<b><a href="/views/plan/mypage.html">마이페이지</a></b>
					</li>
				</div>
			</ul>
			<!-- <button class="btn2">
            <i class="fas fa-user"></i>
        </button> -->
			<button class="btn btn-secondary btn-sm" type="button"
				data-bs-toggle="dropdown" aria-expanded="false">
				<i class="fas fa-chart-bar" style="color: black; font-size: 30px;"></i>
				<span class="visually-hidden">Toggle Dropdown</span>
			</button>
			<ul class="dropdown-menu"></ul>
		</div>
		<!-- <div class="dropdown-menu-profile">
        <div style=" width: 320px; height: 100%; background: #fff;">
            <div class="dropdown-profile">
                <i class="fas fa-user"></i>
            </div>
            <div class="profile-buttons"></div>
        </div>
    </div> -->

	</header>

	<main>

		<form id="planner-form" action="/SemiProjectPractice/search.pl"
			method="POST">

			<div style="width: 100%; font-size: 15px;">
				<input type="text" id="search" name="search"
					placeholder='검색하실 제목을 입력하세요.'
					style="width: 95%; height: 40.5px; font-size: 15px; padding-left: 20px;">
				<button
					style="background-color: #fff; font-size: 20px; width: 10px;"
					type="submit">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</div>
		</form>
		<form action="/SemiProjectPractice/insert.pl" method="POST">
			<br> <br>
						<div class="complete_box">
				<div>
					<div>
						<div class="not-yet-complete">
							<span class="not-completed" id="not-completed">
							<% 
								if (list != null) {
									for (int i = 0; i < list.size(); i++) {
										if(list.get(i).getComplete().equals("N")) {
											nCount++;
										}
									}
								}
							%><%= nCount %></span>
						</div>
						<div class="task-to-do">
							<b>완료할 작업 수</b>
						</div>
					</div>
				</div>
				<div>
					<div>
						<div class="complete-yes">
							<span class="completed" id="completed">
							<% 
								if (list != null) {
									for (int i = 0; i < list.size(); i++) {
										if(list.get(i).getComplete().equals("Y")) {
											count++;
										}
									}
								}
							%><%= count %></span>
						</div>
						<div class="tasks-completed">
							<b>완료한 작업 수</b>
						</div>
					</div>
				</div>
			</div>
			<br> <label for="title"></label> <input type="hidden"
				name="userId" value="validUserId0"> <input type="text"
				id="title" name="title" required
				placeholder='+ "Plan 제목" 추가하기, 시작일과 종료일을 설정하고 [저장] 버튼을 누르면 "Plan 제목"이 추가됩니다.' readonly>
			<br>
			<div style="width: 100%;">
				<div class="time-box">
					<div style="width: 100%;">
						<div>
							<div style="display: flex;">
								<div style="width: 35%; text-align: center;">시작일</div>
								<div style="width: 35%; text-align: center;">마감일</div>
							</div>
							<div style="display: flex;">
								<input type="date" name="startDate" id="startDate"
									class="startAlarm" required> <input type="date"
									name="endDate" id="endDate" class="endAlarm" required>
							</div>
						</div>
					</div>
					<div style="display: flex; width: 100%; justify-content: right;">
						<div>
							<div style="display: flex;">
								<div style="width: 100%; text-align: center; margin-left: 15px;">마감알람일</div>
							</div>
							<div style="display: flex;">
								<input type="checkbox" id="endAlarmDateBoolean"
									name="checkAlarmDate" class="endAlarm" name="endAlarmBoolean" onchange="is_checked()">
								<input type="date"
									class="endAlarm" name="remindAlarmDate" id="endAlarmDate"
									style="width: 133px;" readonly>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br>
			<button type="submit" value="저장" id="save"
				onclick="return submitPlanner2();" disabled>저장</button>
		</form>
		<div id="plannerList">
			<div id="planLists">
				<div style="text-align: left;">PlanList</div>
				<button class="btn btn-secondary btn-sm" type="button"
					data-bs-toggle="dropdown" aria-expanded="false"
					style="background-color: #fff;">
					<!-- <button class="btn3"> -->
					<i class="fa-solid fa-arrow-down-wide-short"
						style="color: black; font-size: 30px;"></i> <span
						class="visually-hidden">Toggle Dropdown</span>
				</button>
				<ul class="dropdown-menu">
					<li style="border: 0px;" onclick="">&nbsp;마감일 오름차순</li>
					<li style="border: 0px;" onclick="">&nbsp;마감일 내림차순</li>
					<li style="border: 0px;" onclick="">&nbsp;시작일 오름차순</li>
					<li style="border: 0px;" onclick="">&nbsp;시작일 내림차순</li>
				</ul>
			</div>
			<ul id="plannersEle">
			<%
				if (listKeyWord != null) {
					for (int i = 0; i < listKeyWord.size(); i++) {
				%>

				<li>
					<div class="plannerItem">
						<div style="display: flex;">
							<input type="checkbox" name="complete" value="complete"
								class="com_radio" onchange="completePlanner(<%= listKeyWord.get(i).getPlanId() %>)"
								<% if(listKeyWord.get(i).getComplete().equals("Y")) {
									
								%> checked <%} %>
								> <strong 
								<% if(listKeyWord.get(i).getComplete().equals("Y")) {
									
								%> class='plan-complete'<%} %>><%= listKeyWord.get(i).getTitle() %></strong>
						</div>
						<div class="plannerDate">
							<span><%= listKeyWord.get(i).getEndDate() %></span>
						</div>
						<span class="deleteButton" onclick="deletePlanner(<%=listKeyWord.get(i).getPlanId() %>)"><b>X</b></span>
					</div>
				</li>

				<%
				  }
				}
				%>
				<%-- 
				<%
				if (listKeyWord != null) {
					for (int i = 0; i < listKeyWord.size(); i++) {
				%>

				<li>
					<div class="plannerItem">
						<div style="display: flex;">
							<input type="radio" name="complete" value="complete"
								id="com_radio" onchange="deletePlanner(<%=i %>)"> <strong><%= listKeyWord.get(i).getTitle() %></strong>
						</div>
						<div class="plannerDate">
							<span><%= listKeyWord.get(i).getEndDate() %></span>
						</div>
						<span class="deleteButton" onclick="deletePlanner(<%= listKeyWord.get(i).getPlanId() %>)"><b>X</b></span>
					</div>
				</li>

				<%
				  }
				}
				%>--%>
			</ul>
			
		</div>
	</main>

	<script>
	
	function is_checked() {
		if(document.getElementById("endAlarmDateBoolean").checked == true) {
			document.getElementById("endAlarmDate").readOnly = false;
		} else if(document.getElementById("endAlarmDateBoolean").checked == false) {
			document.getElementById("endAlarmDate").readOnly = true;
			document.getElementById("endAlarmDate").value = "";
		}
	}
	function deletePlanner(index) {

		location.href = '<%= contextPath %>/delete.pl?userId=validUserId0&planId='+index;
		

	}
	
	function completePlanner(index) {
		
		location.href = '<%= contextPath %>/complete.pl?userId=validUserId0&planId='+index;
		
	}
		// const planners = [];
		var now_utc = Date.now()
		var timeOff = new Date().getTimezoneOffset() * 60000;
		var today = new Date(now_utc - timeOff).toISOString().split("T")[0];

		document.getElementById("startDate").setAttribute("min", today);
		document.getElementById("endDate").setAttribute("min", today);
		document.getElementById("endAlarmDate").setAttribute("min", today);
	</script>

	<script>
		function submitPlanner2() {
			const title = document.getElementById('title').value;
			let startDate = document.getElementById('startDate').value;
			let endDate = document.getElementById('endDate').value;
			let endAlarmDateBoolean = document
					.getElementById('endAlarmDateBoolean')
			let endAlarmDate = document.getElementById('endAlarmDate').value;

			if (!title) {
				alert('제목을 입력해주세요!');

				document.getElementById('title').focus();
				return false;
			}

			if (!startDate) {
				startDate = getCurrentDate();

			}

			if (!endDate) {

				endDate = getCurrentDate();
			}

			if (startDate > endDate) {

				alert('마감 날짜를 다시 설정해주세요!');
				return false;
			}

			if (startDate > endAlarmDate) {

				alert('마감 알람 날짜를 다시 설정해주세요!');
				return false;
			}

			if (endAlarmDateBoolean.checked && !endAlarmDate) {

				endAlarmDate = getCurrentDate();
			}

			// const planner = { title, startDate, endDate, endAlarmDate };

			// planners.push(planner);

			// updatePlannerList();

			// document.getElementById('title').value = '';

			// document.getElementById('startDate').value = '';

			// document.getElementById('endDate').value = '';

			// document.getElementById('endAlarmDate').value = '';

			// initializeDateInput()
		}
	</script>

</body>
</html>