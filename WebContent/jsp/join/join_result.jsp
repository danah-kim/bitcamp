<%@page import="service.*"%>
<%@page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입 결과화면</title>
</head>
<body>
	<%
	MemberBean m = new MemberBean();
	m.setMemId(request.getParameter("join_id"));
	m.setPassWord(request.getParameter("join_pw"));
	m.setName(request.getParameter("join_name"));
	m.setSsn(request.getParameter("join_birth")+request.getParameter("join_gender"));
	m.setTeamId("");
	MemberServiceImpl.getInstance().createMember(m);
	%>
	<%= m %>
</body>
</html>