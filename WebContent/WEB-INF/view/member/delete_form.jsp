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
			<h3>회원 탈퇴</h3>
			<form id="deleteFormBox">
				<table>
					<tr>
						<td>아이디</td>
						<td>${user.memId}</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<input type="text" name="pw1"/>
						</td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td>
							<input type="text" name="pw2"/>
						</td>
					</tr>
				</table>
				<br />
				<input type="hidden" name="action" value="delete"/>
				<input id="deleteFormBut" type="button" value="회원탈퇴"/>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
<script>
	member.delete(['${context}','${user.passWord}']);
</script>
</body>
</html>