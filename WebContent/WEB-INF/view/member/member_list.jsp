<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "domain.*" %>
<%
	String ctx = application.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원목록</title>
	<link rel="stylesheet" type="text/css" href="../../css/style.css"/>
</head>
<body>
	<%
		List<MemberBean> list = MemberServiceImpl
		.getInstance()
		.memberList();
	%>
	<h3>전체회원수 : <%= list.size() %>명</h3>
	<table id="mbl_tab_layout">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>팀아이디</th>
			<th>역할</th>
			<th>주민번호</th>
			<th>나이</th>
		</tr>
		<% 
				for(MemberBean m : list){
		%>
		<tr>
			<td><%=	m.getName() %></td>
			<td><%= m.getMemId() %></td>
			<td><%= m.getPassWord() %></td>
			<td><%= m.getTeamId() %></td>
			<td><%= m.getRoll() %></td>
			<td><%= m.getSsn() %></td>
			<td><%= m.getAge() %></td>
		</tr><%}%>
	</table>
	<br />
	<form action="<%= ctx %>/member.do" class="form_box">
		<input type="hidden" name="action" value="move"/>
		<input type="hidden" name="page" value=""/>
		<button type="submit" >메인화면으로</button>
	</form>
</body>
</html>