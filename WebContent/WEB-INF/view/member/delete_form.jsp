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
			<form id="delete_form_box">
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
				<input id="delete_form_but" type="button" value="회원탈퇴"/>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer_box.jsp"/>
		</div>
	</div>
<script>
	
	document.getElementById('delete_form_but').addEventListener('click', function() {
		alert('삭제버튼 클릭');
		var form = document.getElementById('delete_form_box');
		var x = service.null_chk([form.pw1.value, form.pw2.value]);

		if(!x.checker){
			alert(x.text);
		}else if(form.pw1.value !== form.pw2.value){
			alert('기존비밀번호와 확인 비밀번호가 일치하지 않습니다.');
		}else if('${user.passWord}' !== form.pw1.value){
			alert('기존비밀번호가 일치하지 않습니다.');
		}else{
			alert('탈퇴완료');
			
			var node = document.createElement('input');
			node.innerHTML = '<input type="hidden" name="action" value="delete"/>';
			form.appendChild(node);
			
			form.action = "${context}/member.do";
			form.method = "post";
			form.submit();
		}
	});
</script>
</body>
</html>