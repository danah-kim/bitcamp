<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp"/>
			<jsp:include page="menu_box.jsp"/>
		</div> 
		<div id="content">
		<%
			String condition = "TEAM_ID";
			List<MemberBean> list = (List<MemberBean>)request.getAttribute("team");
		%>
			<h3>검색결과</h3>
			
				<table id="main_tab_layout">
					<tr>
						<th>팀아이디</th>
						<th>이름</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>역할</th>
						<th>주민번호</th>
						<th>나이</th>
					</tr>
					<tr>
						<% for(MemberBean m : list){
							%><td><%= m.getTeamId() %></td>
							<td><%=	m.getName() %></td>
							<td><%= m.getMemId() %></td>
							<td><%= m.getPassWord() %></td>
							<td><%= m.getRoll() %></td>
							<td><%= m.getSsn() %></td>
							<td><%= m.getAge() %></td>
					</tr><%}%>
				</table>
				<br />
				<form class="search_team_result_form_box" action="${context}/member.do" onsubmit="return new Common().sendForm()">
				<input type="hidden" name="action" value="move"/>
				<input type="hidden" name="page" value="move"/>
				<button id="search_team_result_form_but" type="button">메인화면으로</button>
				</form>
	</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
	<script>
		document.getElementById('search_team_result_form_but').addEventListener('click', Function(){
			document.getElementById('search_team_result_form_box').action = '${context}/member.do';
			document.getElementById('search_team_result_form_box').method = 'get';
			document.getElementById('search_team_result_form_box').submit();
		})
	</script>
</body>
</html>