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
	m.setRoll("");
	MemberServiceImpl.getInstance().createMember(m);
	%>
	<h3>가입완료</h3>
	<form action="../login/user_login_form.jsp" class="form_box">
		<button type="submit" >로그인 하기</button>
	</form>
</body>
</html>