<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<script>
	function move(domain, action, page) {
		console.log('클릭 테스트 성공 ${context}')
		alert('클릭 테스트 성공 ${context}')
		location.href = "${context}/" + domain + ".do?action=" + action + "&page=" + page
		<% System.out.println("context값 : "+request.getContextPath()); %>
		<% System.out.println("domain값 : "+request.getParameter("domain")); %>
		<% System.out.println("move값 : "+request.getParameter("move")); %>
		<% System.out.println("page값 : "+request.getParameter("page")); %>
	}

</script>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp"/>
			<jsp:include page="menu_box.jsp"/>
		</div> 
<!-- End Header -->
		<div id="content">
			<jsp:include page="content_box.jsp"/>
		</div>
<!-- End Content -->
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
</body>
</html>