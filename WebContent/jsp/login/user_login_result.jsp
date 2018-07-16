<%@page import="service.*"%>
<%@page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- connection info "jdbc:oracle:thin:@localhost:1521:xe", "danah", "1234" -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>로그인 결과 화면</title>
	<link rel="stylesheet" type="text/css" href="css/style.css?ver=1"/>
</head>
<body>

<%
	MemberBean m = new MemberBean();
	m.setMemId(request.getParameter("user_id"));
	m.setPassWord(request.getParameter("user_pw"));
	m = MemberServiceImpl.getInstance().login(m);
	if(m!=null){
		%>
		<h3>로그인 성공</h3>
		<ul>
			<li>
				<a href="../../update/update_form.jsp">비밀번호 변경</a>
			</li>
			<li>
				<a href="../../delete/delete_form.jsp">회원탈퇴</a>
			</li>
		</ul>
		<%
	}else{
		 %>
		 <h3>로그인 실패</h3>
		 <%
	}
%>

</body>
</html>