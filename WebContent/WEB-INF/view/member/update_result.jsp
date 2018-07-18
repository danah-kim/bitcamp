<%@page import="org.apache.catalina.tribes.membership.MemberImpl"%>
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
	<title>비밀번호 변경 결과</title>
</head>
<body>
<%
	MemberBean member =	new MemberBean();
	member.setMemId(request.getParameter("update_id"));
	if(MemberServiceImpl.getInstance().findByID(member)==null){
%>
		<h3>일치하는 아이디가 없습니다.</h3>
		<form action="<%= ctx %>/member.do" class="form_box">
			<input type="hidden" name="action" value="move" />
			<input type="hidden" name="page" value="update_form"/>
			<button type="submit" >이전화면으로</button>
		</form>
	<%
		}else 
			if(request.getParameter("update_old_password")==request.getParameter("update_new_password")) {
			%>
				<h3>기존 비밀번호와 변경할 비밀번호가 일치합니다</h3>
				<form action="<%= ctx %>/member.do" class="form_box">
					<input type="hidden" name="action" value="move" />
					<input type="hidden" name="page" value="update_form"/>
					<button type="submit" >이전화면으로</button>
				</form><%
			}else 
				if(request.getParameter("update_old_password").equals(member.getPassWord())
						&& request.getParameter("update_old_password")!=request.getParameter("update_new_password")) {
					member = MemberServiceImpl.getInstance().findByID(member);
					member.setPassWord(request.getParameter("update_new_password"));
					MemberServiceImpl.getInstance().modifyMember(member);
					%>
					<h3>변경완료</h3>
					<form action="../../../index.jsp" class="form_box">
						<button type="submit" >메인화면으로</button>
					</form><%
					}else {%>
						<h3>기존비밀번호가 일치하지 않습니다.</h3>
						<form action="<%= ctx %>/member.do" class="form_box">
							<input type="hidden" name="action" value="move" />
							<input type="hidden" name="page" value="update_form"/>
							<button type="submit" >이전화면으로</button>
						</form><%	}%>	
</body>
</html>