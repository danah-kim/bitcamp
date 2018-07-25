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
			<input type="hidden" name="action" value="login"/>
	 		<input type="hidden" name="page" value="mypage"/>
			<input id="login_form_but" type="button" value="제출">
		</form>
	</div>
	<script>
		document.getElementById('login_form_but').addEventListener('click',function(){
			var form = document.getElementById('login_form_box');
			form.action = "${context}/member.do";
			form.method = "post";
			alert('입력한 Id / pw : ' + form.user_id.value + "/" + form.user_pw.value);
			member.setMemId(form.user_id.value);
			member.setPassword(form.user_pw.value);
			if(member.loginValidation()){form.submit();}
		});
	</script>
</body>
</html>