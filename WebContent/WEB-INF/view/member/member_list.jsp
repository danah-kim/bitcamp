<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "domain.*" %>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp"/>
			<jsp:include page="../common/menu_box.jsp"/>
		</div> 
		<div id="content">
			<%-- <h3>전체회원수 : <%= list.size() %>명</h3> --%>
			<table id="member_list_form_box">
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>팀아이디</th>
					<th>역할</th>
					<th>주민번호</th>
					<th>나이</th>
				</tr>
				<%-- <% 
						for(MemberBean m : list){
				%> --%>
				<%-- <tr>
					<td><%=	m.getName() %></td>
					<td><%= m.getMemId() %></td>
					<td><%= m.getPassWord() %></td>
					<td><%= m.getTeamId() %></td>
					<td><%= m.getRoll() %></td>
					<td><%= m.getSsn() %></td>
					<td><%= m.getAge() %></td>
				</tr><%}%> --%>
			</table>
			<br />
			<form id="member_list_form_box">
				<input type="hidden" name="action" value="move"/>
				<input type="hidden" name="page" value="move"/>
				<button type="member_list_form_but" >메인화면으로</button>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
	<script>
		var list = (List<MemberBean>)request.getAttribute("list");

		document.getElementById('member_list_form_but').addEventListener('click', Function(){
			document.getElementById('member_list_form_box').action = '${context}/member.do';
			document.getElementById('member_list_form_box').method = 'get';
			document.getElementById('member_list_form_box').submit();
		})
	</script>
</body>
</html>