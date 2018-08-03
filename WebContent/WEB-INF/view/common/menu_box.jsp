<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu_box">
	<ul id="menu">
		<li><a id="moveMain">HOME</a></li>
		<!-- <li><a href="">ABOUT</a></li> -->
		<li><a id="moveAdmin">ADMIN</a></li>
	</ul>
</div>
<script>
	document.getElementById('moveMain').addEventListener('click', function(){
		router.move({context : '${context}', domain : 'member', action : 'move', page : 'move'});
	});
	document.getElementById('moveAdmin').addEventListener('click', function(){
		admin.check('${context}');
	});
</script>