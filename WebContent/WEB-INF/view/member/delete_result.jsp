<%@page import="service.MemberService"%>
<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원탈퇴 결과</title>
</head>
<body>
<%
	MemberBean member = new MemberBean();
	member.setMemId(request.getParameter("delete_id"));
	if(MemberServiceImpl.getInstance().findByID(member)==null){
		%>
		<h3>일치하는 아이디가 없습니다.</h3>
		<form action="<%= ctx %>/member.do" class="form_box">
			<input type="hidden" name="action" value="move"/>
			<input type="hidden" name="page" value="delete_form"/>
			<button type="submit" >이전화면으로</button>
		</form>
		<%
	}else 
		if(request.getParameter("delete_password")!=MemberServiceImpl.getInstance().findByID(member).getPassWord()) {
			%>
			<h3>기존 비밀번호가 일치하지 않습니다.</h3>
			<form action="<%= ctx %>/member.do" class="form_box">
				<input type="hidden" name="action" value="move"/>
				<input type="hidden" name="page" value="delete_form"/>
				<button type="submit" >이전화면으로</button>
			</form><%
			}else 
				if(request.getParameter("delete_password") != request.getParameter("delete_check_password")) {
					%>
					<h3>기존 비밀번호와 확인 비밀번호가 일치하지 않습니다.</h3>
					<form action="<%= ctx %>/member.do" class="form_box">
						<input type="hidden" name="action" value="move"/>
						<input type="hidden" name="page" value="delete_form"/>
						<button type="submit" >이전화면으로</button>
					</form><%
					}else 
						if(request.getParameter("delete_password") == request.getParameter("delete_check_password")
						&& request.getParameter("delete_password").equals(MemberServiceImpl.getInstance().findByID(member).getPassWord())) {
							member = MemberServiceImpl.getInstance().findByID(member);
							MemberServiceImpl.getInstance().removeMember(member);
						%>
						<h3>탈퇴완료</h3>
						<form action="../../../index.jsp" class="form_box">
							<button type="submit" >메인화면으로</button>
						</form><%
						}else { }%>
</body>
</html>