<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content">
	<h3>개인정보 변경</h3>
	<form id="modifyBox">
		<table>
			<tr>
				<td class="modifyInfo" id='${user.userid}' >아이디</td>
				<td>${user.userid}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>변경 비밀번호</td>
				<td>
					<input type="text" name="password"/>
				</td>
			</tr>
			<tr>
				<td class="modifyInfo" id='${user.teamid}' >팀 변경(현재팀 : ${user.teamid})</td>
				<td>
					<input class= "teamid" type="radio" name="teamid" value="ATEAM"/>걍놀자
					<input class= "teamid" type="radio" name="teamid" value="HTEAM"/>지은이네
					<input class= "teamid" type="radio" name="teamid" value="STEAM"/>왕거북이
					<input class= "teamid" type="radio" name="teamid" value="CTEAM"/>코딩짱
				</td>
			</tr>
			<tr>
				<td class="modifyInfo" id='${user.roll}' >역할 변경(현재역할 : ${user.roll})</td>
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
		<input class="formBtn" id="modifyBtn" type="button" value="변경하기"/>
	</form>
</div>
<form method="POST" enctype="multipart/form-data" action="${context}/member.do?action=fileupload&page=retrieve">
  파일업로드 : <input type="file" name="upfile"><br/>
  <input type="submit" value="파일업로드">
</form>
<script>
	$('input[name="teamid"]').val([user.get('teamid')]);
	$('#roll').val(user.get('roll')).prop('selected', true);
	$('#modifyBtn').click (function () {
		alert('버튼클릭');
		$('#modifyForm')
		.append('<input type="hidden" name="userid" value="' + user.get('userid') + '"/>')
		.attr({
			action : '${context}' +"/member/modify",
			method : "POST"})
		.submit();
	});
	
</script>