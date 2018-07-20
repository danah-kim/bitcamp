<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>아이디 검색 결과</title>
</head>
<body>
	<%
	MemberBean member = (MemberBean)request.getAttribute("id");
	%>
	<h3>검색결과</h3><br />
	<%
		if(member==null){
		%>검색결과가 없습니다
		<form action="<%= ctx %>/member.do" class="form_box">
				<input type="hidden" name="action" value="move"/>
				<input type="hidden" name="page" value="move"/>
				<button type="submit" >메인화면으로</button>
			</form>
		<%
		} 
		else{
			%><%= member %><%
		}%>
</body>
</html>