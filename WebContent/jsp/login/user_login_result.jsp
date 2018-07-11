<%@page import="service.*"%>
<%@page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- connection info "jdbc:oracle:thin:@localhost:1521:xe", "danah", "1234" -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>

<%
	MemberBean m = new MemberBean();
	m.setMemId(request.getParameter("user_id"));
	m.setPassWord(request.getParameter("user_pw"));
	m = MemberServiceImpl.getInstance().login(m);
	if(m!=null){
		%>
		로그인 성공
		<%
	}else{
		 %>
		 로그인 실패
		 <%
	}
%>

</body>
</html>