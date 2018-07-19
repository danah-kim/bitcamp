<%@page import="service.*"%>
<%@page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입 결과화면</title>
</head>
<body>
	<h3>가입완료</h3>
	<form action="<%= ctx %>/member.do" class="form_box">
		<input type="hidden" name="action" value="join"/>
		<input type="hidden" name="page" value="user_login_form"/>
		<button type="submit" >로그인 하기</button>
	</form>
</body>
</html>