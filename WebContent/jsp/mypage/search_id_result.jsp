<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>아이디 검색 결과</title>
</head>
<body>
	<%
	MemberBean member = new MemberBean();
	member.setMemId(request.getParameter("search_id"));
	member = MemberServiceImpl.getInstance().findByID(member);
	%>
	<h3>검색결과</h3><br />
	<%
		if(member==null){
		%>검색결과가 없습니다<%
		} 
		else{
			%><%= member %><%
		}%>
</body>
</html>