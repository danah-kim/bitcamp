<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>USER_LOGIN</title>
	<link rel="stylesheet" type="text/css" href="../../css/style.css" />
</head>
<body>
	<div class="margin_center">
		<h1>로그인</h1>
		<form action="user_login_result.jsp" class="form_box">
			<p class="input_box_font">ID : </p>
			<input class="input_box" type="text" name="user_id">
			<br/>
			<p class="input_box_font">PW : </p>
			<input class="input_box" type="text" name="user_pw">
			<p><br/></p>
			<input id="submit_but" type="submit" value="제출">
		</form>
	</div>
</body>
</html>