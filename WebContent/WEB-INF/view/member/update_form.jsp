<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp"/>
			<jsp:include page="menu_box.jsp"/>
		</div> 
		<div id="content">
			<h3>개인정보 변경</h3>
			<form id="update_form_box">
				<table>
					<tr>
						<td>아이디</td>
						<td>${user.memId}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${user.name}</td>
					</tr>
					<tr>
						<td>기존 비밀번호</td>
						<td>
							<input type="text" name="old_pw" placeholder="****"/>
						</td>
					</tr>
					<tr>
						<td>변경 비밀번호</td>
						<td>
							<input type="text" name="new_pw"/>
						</td>
					</tr>
					<tr>
						<td>팀 변경(현재팀 : ${user.teamId})</td>
						<td>
							<input type="radio" id="teamid_1" name="teamid" value="ATEAM"/>걍놀자
							<input type="radio" id="teamid_2" name="teamid" value="HTEAM"/>지은이네
							<input type="radio" id="teamid_3" name="teamid" value="STEAM"/>왕거북이
							<input type="radio" id="teamid_4" name="teamid" value="CTEAM"/>코딩짱
						</td>
					</tr>
					<tr>
						<td>역할 변경(현재역할 : ${user.roll})</td>
						<td>
							<select id="roll" name="roll">
								<option value="Leader">팀장</option>
								<option value="front">프론트개발</option>
								<option value="back">백단개발</option>
								<option value="android">안드로이드개발</option>
								<option value="minfe">민폐</option>
							</select>
						</td>
					</tr>
				</table><br/>
				<input id="update_form_but" type="button" value="변경하기"/>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
<script>
	for(var i=1; i<=4; i++){
		if(document.getElementById('teamid_'+i).value === '${user.teamId}'){
			document.getElementById('teamid_'+i).checked = true;
		}
	}
	
	var roll = document.getElementById('roll');

	for(var i=0; i<roll.options.length; i++){
		if(roll.options[i].value === '${user.roll}'){
			roll.options[i].setAttribute("selected", "selected");
		}
	}
	
	document.getElementById('update_form_but').addEventListener('click', function(){
		if(document.getElementById('update_form_box').old_pw.value === ''){
			alert('기존 비밀번호를 입력해 주세요.');
		}else if('${user.passWord}' !== document.getElementById('delete_form_box').old_pw.value){
			alert('기존 비밀번호가 일치하지 않습니다.');
		}else if(document.getElementById('update_form_box').new_pw.value === document.getElementById('update_form_box').old_pw.value) {
			alert('기존 비밀번호와 변경 비밀번호가 동일합니다.');
		}else{
			document.getElementById('update_form_box').new_pw.value 
				= document.getElementById('update_form_box').new_pw.value 
				|| document.getElementById('update_form_box').old_pw.value;

			var node = document.createElement('input');
			node.innerHTML = '<input type="hidden" name="action" value="update"/>';
			document.getElementById('update_form_box').appendChild(node);

			document.getElementById('update_form_box').action = "${context}/member.do";
			document.getElementById('update_form_box').method = "post";
			document.getElementById('update_form_box').submit();
		}
	});
</script>
</body>
</html>