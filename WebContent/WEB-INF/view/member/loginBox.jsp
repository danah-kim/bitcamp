<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="loginBox">
	<c:choose>
		<c:when test="${pageName eq 'search'}">
		</c:when>	
		<c:when test="${user ne null}">
			<a class="menuBtn" id="moveLogout">LOGOUT</a>
		</c:when>	
		<c:otherwise>
			<a class="menuBtn" id="moveLogin">LOGIN</a>
			&nbsp;&nbsp;&nbsp;
			<a class="menuBtn" id="moveJoin">JOIN</a>
		</c:otherwise>
	</c:choose>
</div>