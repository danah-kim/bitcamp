<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="admin_content_box" >
	<div id="admin_context_box_search">
		<form id="adminSearchFormBox">
			<select id="adminSearchSelect" name="adminSearchSelect">
				<option value="none">검색조건</option>
				<option value="userid">아이디</option>
				<option value="name">이  름</option>
				<option value="teamName">팀  명</option>
				<option value="gender">성  별</option>
				<option value="roll">역  할</option>
			</select>
			<input id="adminSearchText" type="text" placeholder="검색어 입력" name="word"/>
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
				<%-- <td><a href="${context}/admin.do?action=retrive&page=memberDetail&search_id="+ this.getAttribute('id') style="cursor: pointer;">${i.name}</a></td> --%>
				<td><a class="userName" id="${i.memId}" style="cursor: pointer;">${i.name}</a></td>
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
					<ul class="pageBox">
						<c:if test="${existPrev}">
						<li>
							<a id='prePage'>이전</a>
						</li>
						</c:if>
						<c:forEach begin='${startPage}' end='${endPage}' step='1' varStatus='i'>
							<li>
								<a class= "pageNum" id = '${i.index}' style="cursor: pointer;">${i.index}</a>
							</li>
						</c:forEach>
						<c:if test="${existNext}">
						<li>
							<a id='nextPage'>다음</a>
						</li>
						</c:if>
					</ul>
				</td>
			</tr>
		</table>
	</div>
</div>
<script>
	admin.main({context : '${context}', 
				startPage : '${startPage}',
				endPage : '${endPage}',
				totalPage : '${totalPage}'
	});
</script>