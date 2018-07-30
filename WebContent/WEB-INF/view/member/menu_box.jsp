<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu_box">
	<ul id="menu">
		<li><a id="move_mypage">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a id="move_member_update">정보변경</a></li>
		<li><a id="move_main">로그아웃</a></li>
		<li><a id="move_member_delete">회원탈퇴</a></li>

	</ul>
</div>
<script>
	document.getElementById('move_mypage').addEventListener('click', function(){
		router.move({context : '${context}', domain : 'member', action : 'move', page : 'mypage'});
	});
	document.getElementById('move_member_update').addEventListener('click', function(){
		alert('정보변경 이동');
		router.move({context : '${context}', domain : 'member', action : 'move', page : 'update_form'});
	});
	document.getElementById('move_member_delete').addEventListener('click', function(){
		alert('회원탈퇴 이동');
		router.move({context : '${context}', domian : 'member', action : 'move', page : 'delete_form'});
	});
	document.getElementById('move_main').addEventListener('click', function(){
		alert('로그아웃')
		router.move({context : '${context}', domain : 'member', action : 'move', page : 'move'});
	});
</script>