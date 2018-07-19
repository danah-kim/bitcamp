<%@page import="org.apache.catalina.tribes.membership.MemberImpl"%>
<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호 변경 결과</title>
</head>
<body>
	<h3>변경완료</h3>
	<form action="../../../index.jsp" class="form_box">
		<button type="submit" >메인화면으로</button>
	</form>
</body>
</html>