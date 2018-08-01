<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content_box">
	<table id="content_box_tab">
		<tr id="content_box_meta">
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
<script>
	document.getElementById('content_box_meta').className = 'bg_color_yellow';
	var x = document.querySelectorAll('.username');
	for(i in x){
		x[i].style.color = 'red';
		x[i].style.cursor = 'pointer';
		x[i].addEventListener('click', function(){
			alert('클릭'+this.getAttribute('id'));
			location.href="${context}/admin.do?action=Retrive&page=memberDetail&search_id=" + this.getAttribute('id');
		});
	}
</script>