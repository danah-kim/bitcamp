<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호 변경</title>
	<link rel="stylesheet" type="text/css" href="../../css/style.css"/>
</head>
<body>
	<h3>비밀번호 변경</h3>
		<form action="<%= ctx %>/member.do">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="update_id"/>
			</td>
		</tr>
		<tr>
			<td>기존 비밀번호</td>
			<td>
				<input type="text" name="update_old_password"/>
			</td>
		</tr>
		<tr>
			<td>변경 비밀번호</td>
			<td>
				<input type="text" name="update_new_password"/>
			</td>
		</tr>
	</table>
	<br />
	<input type="hidden" name="action" value="memberUpdate"/>
	<input type="hidden" name="page" value="update_result"/>
	<input type="submit" value="비밀번호 변경"/>
	</form>
</body>
</html>