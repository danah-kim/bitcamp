<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="contentBox"  data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-19" data-genuitec-path="/gms/src/main/webapp/WEB-INF/views/member/search.jsp">
	<div id="contextBoxSearch">
		<form id="searchForm">
			<select class="searchInfo" id="${column}" name="searchSelect">
				<option value="">검색조건</option>
				<option value="MEM_ID">아이디</option>
				<option value="NAME">이   름</option>
				<option value="TEAM_ID">팀아이디</option>
				<option value="GENDER">성   별</option>
				<option value="ROLL">역   할</option>
			</select>
			<input class="searchInfo" id="${value}" type="text" placeholder="검색어 입력" name="word"/>
			<input class="formBtn" id="searchBtn" type="button" value="검색"/>
		</form>
	<p><br/></p>
	</div>
	<div id="contextBoxTable">
		<table id="searchListTabBox">
			<tr id="searchListTabMeta">
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>역할</th>
				<th>팀아이디</th>
				<th>과목</th>
			</tr>
			<c:forEach items="${list}" var="i">
			<tr>
				<td>${i.memId}</td>
				<td><a class="userName" id="${i.memId}" style="cursor: pointer;">${i.name}</a></td>
				<td>${i.age}</td>
				<td>${i.gender}</td>
				<td>${i.roll}</td>
				<td>${i.teamId}</td>
				<td>${i.subject}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
					전체 회원수 : ${page.totalRecode}
					<br />
					<ul class="pageBox">
						<c:if test="${page.existPre}">
							<li class="pageBtn" id='${page.pre}'>이전</li>
						</c:if>
						<li id="paging">
							<c:forEach begin='${page.startPage}' end='${page.endPage}' step='1' varStatus='i'>
								<a class= "pageNum" id = '${i.index}' style="cursor: pointer;">${i.index}</a>
							</c:forEach>
						</li>
						<c:if test="${page.existNext}">
							<li class="pageBtn" id='${page.next}'>다음</li>
						</c:if>
					</ul>
				</td>
			</tr>
		</table>
	</div>
</div>