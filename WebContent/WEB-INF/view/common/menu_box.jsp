<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu_box">
	<ul id="menu">
		<li><a id="move_home"">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a id="move_admin">ADMIN</a></li>
	</ul>
</div>
<script>
	document.getElementById('move_home').addEventListener('click', function(){
		alert('메인 이동');
		common.move('member','move','move');
	});

	document.getElementById('move_admin').addEventListener('click', function(){
		alert('관리자페이지 이동');
		common.move('admin','move','main');
	});
</script>