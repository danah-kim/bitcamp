<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀이름으로 검색</title>
</head>
<body>
	<form action="search_team_result.jsp">
		<p>팀이름으로 검색 : 
			<select name="search_team_id">
				<option value="ATEAM">Ateam</option>
				<option value="HTEAM">Hteam</option>
				<option value="CTEAM">Cteam</option>
				<option value="STEAM">Steam</option>
			</select>
			<input type="submit" value="검색"/>
		</p>
	</form>
</body>
</html>