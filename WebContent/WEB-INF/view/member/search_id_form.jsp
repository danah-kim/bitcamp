<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp"/>
			<jsp:include page="menu_box.jsp"/>
		</div> 
		<div id="content">
			<form id="search_id_form_box">
				<p>이름 : 
					<input type="text" name="search_id"/>
					<input type="hidden" name="action" value="retrive"/>
					<input type="hidden" name="page" value="search_id_result"/>
					<button id="search_id_form_but" type="button">검색</button>
				</p>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
	<script>
		document.getElementById(search_id_form_but).addEventListener('click', Function(){
			document.getElementById(search_id_form_box).action = '${context}/member.do';
			document.getElementById(search_id_form_box).method = 'get';
			document.getElementById(search_id_form_box).submit();
		})
	</script>
</body>
</html>