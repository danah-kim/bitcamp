fuction menuBox(){
	return
		'<div id="menuBox">'
		+ '<ul id="menu">'
		+ '<c:choose>'
		+ '	<c:when test="${user ne null}">'
		+ '		<li><a class="menuBtn" id="moveMeberMain">HOME</a></li>'
		+ '		<li><a class="menuBtn" id="moveMemberModify">정보변경</a></li>'
		+ '		<li><a class="menuBtn" id="moveMemberRemove">회원탈퇴</a></li>'
		+ '	</c:when>'
		+ '	<c:otherwise>'
		+ '		<li><a class="menuBtn" id="moveMain">HOME</a></li>'
		+ '		<li><a class="menuBtn" id="moveAdmin">ADMIN</a></li>'
		+ '	</c:otherwise>'
		+ '</c:choose>'
		+ '</ul>'
		+ '</div>';
}