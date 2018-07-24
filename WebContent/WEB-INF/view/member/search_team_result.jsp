<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀이름으로 검색 결과</title>
</head>
<body>
<%
	String condition = "TEAM_ID";
	List<MemberBean> list = (List<MemberBean>)request.getAttribute("team");
%>
<h3>검색결과</h3>

	<table id="main_tab_layout">
		<tr>
			<th>팀아이디</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>역할</th>
			<th>주민번호</th>
			<th>나이</th>
		</tr>
		<tr>
			<% for(MemberBean m : list){
				%><td><%= m.getTeamId() %></td>
				<td><%=	m.getName() %></td>
				<td><%= m.getMemId() %></td>
				<td><%= m.getPassWord() %></td>
				<td><%= m.getRoll() %></td>
				<td><%= m.getSsn() %></td>
				<td><%= m.getAge() %></td>
		</tr><%}%>
	</table>
	<br />
	<form class="form_box" action="${context}/member.do" onsubmit="return sendForm()">
	<input type="hidden" name="action" value="move"/>
	<input type="hidden" name="page" value="move"/>
		<button type="submit" >메인화면으로</button>
	</form>
</body>
</html>