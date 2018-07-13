<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
memId, name, passWord, ssn
-->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입 화면</title>
	<link rel="stylesheet" type="text/css" href="../../css/style.css" />
</head>
<body>
	<div class="margin_center">
		<form action="join_result.jsp" class="form_box">
			<h1>회원가입</h1>
			<p> 아이디 : <input type="text" name="join_id">
				<%-- <button type="button"
				<%if(MemberServiceImpl.getInstance().findByID(id)){
					%>onclick="alert('사용가능한 아이디 입니다.')"<%
					}else{
						
					}%>
				onclick="alert('사용불가능한 아이디 입니다.')">중복확인</button> --%></p>
			<p> 비밀번호 : <input type="text" name="join_pw"></p>
			<p> 이름 : <input type="text" name="join_name"></p>
<!-- 			<p> 팀 : <select name="join_team">
						<option value="ATEAM">Ateam</option>
						<option value="HTEAM">Hteam</option>
						<option value="CTEAM">Ceam</option>
						<option value="STEAM">Steam</option>
				   </select></p> -->
			<p> 생년월일 : <input type="text" name="join_birth" pattern = "\d{6}\" 
                              title = "990101 형식으로 입력해주세요" ></p>
			<p> 성별 : <input type="radio" name="join_gender" value="-1">남자
					<input type="radio" name="join_gender" value="-2">여자</p>
			<input type="submit" onclick="alert('환영합니다!')" value="가입하기">
			<p></p>
		</form>
	</div>
</body>
</html>