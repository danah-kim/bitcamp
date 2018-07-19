<%@page import="service.*"%>
<%@page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>
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
	MemberServiceImpl.getInstance().login(m);
	if(m!=null){
		%>
		<h3>로그인 성공</h3>
			<form action="<%= ctx %>/member.do" class="form_box">
				<input type="hidden" name="action" value="move"/>
				<input type="hidden" name="page" value="mypage"/>
				<button type="submit" >메인화면으로</button>
			</form>
		<%
	}else{
		 %>
		 <h3>로그인 실패</h3>
		 <form action="<%= ctx %>/member.do" class="form_box">
		 	<input type="hidden" name="action" value="move"/>
		 	<input type="hidden" name="page" value="user_login_form" />
			<button type="submit" >이전화면으로</button>
		</form>
		 <%
	}
%>

</body>
</html>