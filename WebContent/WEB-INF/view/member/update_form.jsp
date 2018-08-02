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
			<form id="updateFormBox">
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
							<input class= "teamid" type="radio" name="teamid" value="ATEAM"/>걍놀자
							<input class= "teamid" type="radio" name="teamid" value="HTEAM"/>지은이네
							<input class= "teamid" type="radio" name="teamid" value="STEAM"/>왕거북이
							<input class= "teamid" type="radio" name="teamid" value="CTEAM"/>코딩짱
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
				<input id="updateFormBut" type="button" value="변경하기"/>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
<script>
	member.update(['${context}','${user.passWord}','${user.teamId}','${user.roll}']);
</script>
</body>
</html>