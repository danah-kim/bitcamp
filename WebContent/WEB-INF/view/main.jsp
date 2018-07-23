<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="common/head.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="common/title_box.jsp"/>
			<jsp:include page="common/login_box.jsp"/>
			<jsp:include page="common/menu_box.jsp"/>
		</div> 
<!-- End Header -->
		<div id="content">
			<jsp:include page="common/content_box.jsp"/>
		</div>
<!-- End Content -->
		<div id="footer">
			<jsp:include page="common/footer_box.jsp"/>
		</div>
	</div>
</body>
</html>