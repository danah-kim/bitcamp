<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>USER_LOGIN</title>
	<link rel="stylesheet" type="text/css" href="../../css/style.css?ver=1"/>
</head>
<body>
	<div>
		<h1>로그인</h1>
		<form class="login_form_box" action="user_login_result.jsp">
			<p class="login_input_box_font">ID : </p>
			<input class="login_input_box" type="text" name="user_id">
			<br/>
			<p class="login_input_box_font">PW : </p>
			<input class="login_input_box" type="text" name="user_pw">
			<p><br/></p>
			<input id="submit_but" type="submit" value="제출">
		</form>
	</div>
</body>
</html>