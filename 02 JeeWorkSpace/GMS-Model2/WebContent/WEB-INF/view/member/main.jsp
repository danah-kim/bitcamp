<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/titleBox.jsp"/>
			<c:choose>
				<c:when test="${pageName eq 'login' || pageName eq 'add'}">
				</c:when>	
				<c:otherwise>
					<jsp:include page="loginBox.jsp"/>
					<jsp:include page="../common/menuBox.jsp"/>
				</c:otherwise>
			</c:choose>
		</div>
		<div id="content">
			<c:choose>
				<c:when test="${pageName eq 'add'}">
					<jsp:include page="add.jsp"/>
				</c:when>
				<c:when test="${pageName eq 'login'}">
					<jsp:include page="login.jsp"/>
				</c:when>
				<c:when test="${pageName eq 'search'}">
					<jsp:include page="search.jsp"/>
				</c:when>
				<c:when test="${pageName eq 'modify'}">
					<jsp:include page="modify.jsp"/>
				</c:when>
				<c:when test="${pageName eq 'remove'}">
					<jsp:include page="remove.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="retrieve.jsp"/>
				</c:otherwise>
			</c:choose>
		</div>
		<div id="footer">
		<c:choose>
				<c:when test="${pageName eq 'login'}">
				</c:when>
				<c:otherwise>
					<jsp:include page="../common/footerBox.jsp"/>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
<script>
	member.main('${context}');
</script>
</html>