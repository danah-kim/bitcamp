<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀이름으로 검색</title>
</head>
<body>
	<form action="<%= ctx %>/member.do">
		<p>팀이름으로 검색 : 
			<select name="search_team_id">
				<option value="ATEAM">Ateam</option>
				<option value="HTEAM">Hteam</option>
				<option value="CTEAM">Cteam</option>
				<option value="STEAM">Steam</option>
			</select>
			<input type="hidden" name="action" value="search"/>
			<input type="hidden" name="page" value="search_team_result"/>
			<input type="submit" value="검색"/>
		</p>
	</form>
</body>
</html>