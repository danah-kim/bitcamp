<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>로그인</title>
	<link rel="stylesheet" type="text/css" href="../../css/style.css?ver=1"/>
</head>
<body>
	<div>
		<h1>로그인</h1>
		<form class="login_form_box" action="<%= ctx %>/member.do">
			<p class="login_input_box_font">ID : </p>
			<input class="login_input_box" type="text" name="user_id">
			<br/>
			<p class="login_input_box_font">PW : </p>
			<input class="login_input_box" type="text" name="user_pw">
			<p><br/></p>
			<input type="hidden" name="action" value="login"/>
			<input type="hidden" name="page" value="user_login_result"/>
			<input id="submit_but" type="submit" value="제출">
		</form>
	</div>
</body>
</html>