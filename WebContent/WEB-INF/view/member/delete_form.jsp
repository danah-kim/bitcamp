<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원 탈퇴</title>
	<link rel="stylesheet" type="text/css" href="../../css/style.css"/>
</head>
<body>
	<h3>회원 탈퇴</h3>
	<form action="<%= ctx %>/member.do">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="delete_id"/>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="text" name="delete_password"/>
			</td>
		</tr>
	</table>
	<br />
	<input type="hidden" name="action" value="delete"/>
	<input type="submit" onclick="alert('탈퇴완료!')" value="회원탈퇴"/>
	</form>
</body>
</html>