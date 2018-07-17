<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>아이디로 검색</title>
</head>
<body>
	<form action="<%= ctx %>/member/search_id_result.do">
		<p>이름 : 
			<input type="text" name="search_id"/>
			<input type="submit" value="검색"/>
		</p>
	</form>
</body>
</html>