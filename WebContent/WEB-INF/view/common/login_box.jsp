<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login_box">
	<a id="move_loging_form">LOGIN</a>
	&nbsp;&nbsp;&nbsp;
	<a id="move_join_form">JOIN</a>
</div>
<script>
	document.getElementById('move_loging_form').addEventListener('click', function() {
		alert('로그인 클릭 이벤트 체크');
		router.move({context : '${context}', domain : 'member', action : 'move', page : 'user_login_form'});
	});
	document.getElementById('move_join_form').addEventListener('click', function() {
		alert('가입 클릭 이벤트 체크');
		router.move({context : '${context}', domain : 'member', action : 'move', page : 'join_form'});
	});
</script>