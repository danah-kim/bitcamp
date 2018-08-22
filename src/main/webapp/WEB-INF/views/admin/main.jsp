<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/header.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/titleBox.jsp"/>
			<jsp:include page="menuBox.jsp"/>
		</div> 
		<div id="content">
			<jsp:include page="../member/search.jsp"/>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer.jsp"/>
		</div>
	</div>
<script>
	admin.main('${context}');
</script>
</body>
</html>