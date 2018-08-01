<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp"/>
			<jsp:include page="../admin/menu_box.jsp"/>
		</div> 
		<div id="content">
			<form id="search_team_form_box">
				<p>팀이름으로 검색 : 
					<select name="search_team_id">
						<option value="ATEAM">Ateam</option>
						<option value="HTEAM">Hteam</option>
						<option value="CTEAM">Cteam</option>
						<option value="STEAM">Steam</option>
					</select>
					<input type="hidden" name="action" value="search"/>
					<input type="hidden" name="page" value="search_team_result"/>
					<button id="search_team_form_but" type="button">검색</button>
				</p>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
	<script>
		document.getElementById('search_team_form_but').addEventListener('click', Function(){
			document.getElementById('search_team_form_box').action = '${context}/member.do';
			document.getElementById('search_team_form_box').method = 'get';
			document.getElementById('search_team_form_box').submit();
		})
	</script>
</body>
</html>