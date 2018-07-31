<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<!-- function 사용 -->
	<div>
		<h1>로그인</h1>
		<form id="login_form_box">
			<p class="login_input_box_font">ID : </p>
			<input class="login_input_box" type="text" name="user_id">
			<br/>
			<p class="login_input_box_font">PW : </p>
			<input class="login_input_box" type="text" name="user_pw">
			<p><br/></p>
			<input id="login_form_but" type="button" value="제출">
		</form>
	</div>
	<script>
		document.getElementById('login_form_but').addEventListener('click',function(){
			x = service.null_chk([document.getElementById('login_form_box').user_id.value, document.getElementById('login_form_box').user_pw.value]);
			if (x.checker) {
				alert('유효성 체크 통과!');
				
				var node = document.createElement('input');
				node.innerHTML = '<input type="hidden" name="action" value="login"/>';
				document.getElementById('login_form_box').appendChild(node);
				
				document.getElementById('login_form_box').action = "${context}/member.do";
				document.getElementById('login_form_box').method = "post";
				document.getElementById('login_form_box').submit();
			} else {
				alert(x.text);
			}
		});
	</script>
</body>
</html>