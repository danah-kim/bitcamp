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
			<h3>검색결과</h3><br />
			<table id="main_tab_layout">
					<tr>
						<th>팀아이디 : </th>
						<th>이름 : </th>
						<th>아이디 : </th>
						<th>비밀번호 : </th>
						<th>역할 : </th>
						<th>주민번호 : </th>
						<th>나이 : </th>
					</tr>
					<tr>
						<td>${id.teamId}</td>
						<td>${id.name}</td>
						<td>${id.memId}</td>
						<td>${id.passWord}</td>
						<td>${id.roll}</td>
						<td>${id.ssn}</td>
						<td>${id.age}</td>
					</tr>
			</table>

			<form id="search_id_result_box">
				<button id="search_id_result_but" type="button" >메인화면으로</button>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
	<script>
		document.getElementById('search_id_result_but').addEventListener('click', function(){
			var x = [{type : 'hidden', name : 'action', value : 'move'},
				{type : 'hidden', name : 'page', value : 'move'}];
	
			form.action = '${context}/admin.do';
			form.method = 'get';
			
			for(var i=0; i<2; i++){
				var node = document.createElement('input');
				node.setAttribute('type', arr[i].type);
				node.setAttribute('name', arr[i].name);
				node.setAttribute('value', arr[i].value);
				form.appendChild(node);
			}
			
			document.getElementById('search_id_result_box').submit();
		});
	</script>
</body>
</html>