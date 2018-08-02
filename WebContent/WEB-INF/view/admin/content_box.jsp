<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="admin_content_box" >
	<div id="admin_context_box_search">
		<form id="admin_search_form_box">
			<select id="admin_search_select" name="admin_search_select">
				<option value="none">검색조건</option>
				<option value="userid">아이디</option>
				<option value="name">이  름</option>
				<option value="teamName">팀  명</option>
			</select>
			<input id="admin_search_text" type="text" placeholder="검색어 입력" name="word"/>
			<input id="admin_search_btn" type="button" value="검색"/>
		</form>
	<p><br/></p>
	</div>
	<div id="admin_context_box_table">
		<table id="admin_list_tab_box">
			<tr id="admin_list_tab_meta">
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>역할</th>
				<th>팀아이디</th>
			</tr>
			<c:forEach items="${list}" var="i">
			<tr>
				<td>${i.memId}</td>
				<%-- <td><a href="${context}/admin.do?action=Retrive&page=memberDetail&search_id=${i.memId}" style="cursor: pointer;">${i.name}</a></td> --%>
				<td><a class="username" id="${i.memId}" style="cursor: pointer;">${i.name}</a></td>
				<td>${i.age}</td>
				<td>${i.gender}</td>
				<td>${i.roll}</td>
				<td>${i.teamId}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
<script>
	admin.main('${context}');
	alert(${list});
</script>