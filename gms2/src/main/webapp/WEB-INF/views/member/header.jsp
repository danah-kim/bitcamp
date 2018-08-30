<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="outer-container">
	<header class="site-header">
		<div class="top-header-bar">
		    <div class="container-fluid">
		        <div class="row">
		            <div class="col-lg-6 flex align-items-center">
		                <div class="header-bar-text d-none d-lg-block">
		                    <p>Hello world, My name is danah</p>
		                </div><!-- .header-bar-text -->
		            </div><!-- .col -->
		
		            <div class="col-12 col-lg-6 flex justify-content-between justify-content-lg-end align-items-center">
		                <div class="header-bar-social d-none d-md-block">
		                    <ul class="flex align-items-center">
		                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
		                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
		                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
		                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
		                        <li class="dropdown">
		                        	<a id="myMenu" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
		                        		<i class="fa fa-list-alt"></i>
		                        	</a>
		                        	<ul class="dropdown-menu" role="menu">
		                        		<li role="presentation"><a id="boardWriteMenu" role="menuitem" tabindex="-1">게시글쓰기</a></li>
		                        		<li role="presentation"><a id="boardListMenu" role="menuitem" tabindex="-1">게시글목록</a></li>
		                        	</ul>
		                        </li>
		                        <li class="dropdown">
		                        	<a id="myMenu" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
		                        		<i class="fa fa-user"></i>
		                        	</a>
		                        	<ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
		                        		<li role="presentation"><a id="modifyMenu" role="menuitem" tabindex="-1">정보수정</a></li>
		                        		<li role="presentation"><a id="removeMenu" role="menuitem" tabindex="-1">탈퇴</a></li>
		                        	</ul>
		                        </li>
		                        <li><a id="logoutMenu"><i class="fa fa-sign-out"></i></a></li>
		                    </ul>
		                </div><!-- .header-bar-social -->
		
		                <div class="header-bar-search d-none d-md-block">
		                    <form>
		                        <input type="search" placeholder="Search">
		                    </form>
		                </div><!-- .header-bar-search -->
		            </div><!-- .col -->
		        </div><!-- .row -->
		    </div><!-- .container-fluid -->
		</div><!-- .top-header-bar -->
	</header>
</div>
<script>
$('#boardWriteMenu').click (function(){
	alert('게시글쓰기');
	location.href = '${context}/move/member/member/register';
});
$('#boardListMenu').click (function(){
	alert('게시글목록');
	location.href = '${context}/move/member/member/listAll';
});
$('#modifyMenu').click (function(){
	location.href = '${context}/move/member/member/modify';
});
$('#removeMenu').click (function(){
	location.href = '${context}/move/member/member/remove';
});
$('#logoutMenu').click (function(){
	location.href = '${context}/member/logout';
	sessionStorage.clear();
});
</script>