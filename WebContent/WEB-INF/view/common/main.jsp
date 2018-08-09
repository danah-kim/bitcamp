<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"/>
<body>
<!-- move를 전역 메소드 처리 -->
	<div id="wrapper">
		<div id="header">
			<jsp:include page="titleBox.jsp"/>
			<jsp:include page="loginBox.jsp"/>
			<jsp:include page="menuBox.jsp"/>
		</div> 
<!-- End Header -->
		<div id="content">
			<jsp:include page="contentBox.jsp"/>
		</div>
<!-- End Content -->
		<div id="footer">
			<jsp:include page="footerBox.jsp"/>
		</div>
	</div>
<script>
	common.main('${context}');
</script>
</body>
</html>