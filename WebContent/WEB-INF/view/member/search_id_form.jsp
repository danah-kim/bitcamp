<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>아이디로 검색</title>
</head>
<body>
	<form action="${context}/member.do" onsubmit="return sendForm()">
		<p>이름 : 
			<input type="text" name="search_id"/>
			<input type="hidden" name="action" value="retrive"/>
			<input type="hidden" name="page" value="search_id_result"/>
			<input type="submit" value="검색"/>
		</p>
	</form>
</body>
</html>