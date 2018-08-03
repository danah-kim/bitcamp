<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu_box">
	<ul id="menu">
		<li><a id="moveMypage">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a id="moveMemberUpdate">정보변경</a></li>
		<li><a id="moveMain">로그아웃</a></li>
		<li><a id="moveMemberDelete">회원탈퇴</a></li>

	</ul>
</div>
<script>
	document.getElementById('moveMypage').addEventListener('click', function(){
		router.move({context : x, domain : 'member', action : 'move', page : 'mypage'});
	});
	document.getElementById('moveMain').addEventListener('click', function(){
		alert('메인이동')
		router.move({context : x, domain : 'member', action : 'move', page : 'move'});
	});
	document.getElementById('moveMemberUpdate').addEventListener('click', function(){
		alert('정보변경 이동');
		router.move({context : x, domain : 'member', action : 'move', page : 'update_form'});
	});
	document.getElementById('moveMemberDelete').addEventListener('click', function(){
		alert('회원탈퇴 이동')
		router.move({context : x, domain : 'member', action : 'move', page : 'delete_form'});
	});
</script>