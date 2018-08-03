<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="admin_content_box" >
	<div id="admin_context_box_search">
		<form id="adminSearchFormBox">
			<select id="admin_search_select" name="admin_search_select">
				<option value="none">검색조건</option>
				<option value="userid">아이디</option>
				<option value="name">이  름</option>
				<option value="teamName">팀  명</option>
			</select>
			<input id="admin_search_text" type="text" placeholder="검색어 입력" name="word"/>
			<input id="adminSearchBtn" type="button" value="검색"/>
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
			<tr>
				<td colspan="6">
					전체 회원수 : ${count}
					<br />
					<span class="pageNum" id="pageNum"></span>
					<span id="nextPage">다음</span>
					<%-- <c:forEach begin="1" end="${count}" var="i" step="1">
						<span class="pageNum" id="pageNum"></span>
						<c:if test="${i%5 == 0 && i>=5}">
							<span id="nextPage">다음</span>
						</c:if>
					</c:forEach> --%>
				</td>
			</tr>
		</table>
	</div>
</div>
<script>
	admin.main('${context}');
</script>