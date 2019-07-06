<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="menuBox" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-8" data-genuitec-path="/gms/src/main/webapp/WEB-INF/views/common/menuBox.jsp">
	<ul id="menu">
	<c:choose>
		<c:when test="${user ne null}">
			<li><a class="menuBtn" id="moveMeberMain">HOME</a></li>
			<li><a class="menuBtn" id="moveMemberModify">정보변경</a></li>
			<li><a class="menuBtn" id="moveMemberRemove">회원탈퇴</a></li>
		</c:when>
		<c:otherwise>
			<li><a class="menuBtn" id="moveMain">HOME</a></li>
			<li><a class="menuBtn" id="moveAdmin">ADMIN</a></li>
		</c:otherwise>
	</c:choose>
	</ul>
</div>