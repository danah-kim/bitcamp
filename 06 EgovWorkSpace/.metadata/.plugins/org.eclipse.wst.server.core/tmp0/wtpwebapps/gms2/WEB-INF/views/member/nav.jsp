<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="site-branding flex flex-column align-items-center">
                <h1 class="site-title"><a rel="home">Danah</a></h1>
                <p class="site-description">Personal Portfolio</p>
            </div><!-- .site-branding -->
 
            <nav class="site-navigation">
                <div class="hamburger-menu d-lg-none">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div><!-- .hamburger-menu -->
 
                <ul class="flex-lg flex-lg-row justify-content-lg-center align-content-lg-center">
                    <li class="current-menu-item"><a href="index.html">Home</a></li>
                    <li><a href="#">features</a></li>
                    <li><a href="#">Portfolio</a></li>
                    <li><a href="#">blog</a></li>
                    <li><a href="#">about me</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
 
                <div class="header-bar-social d-md-none">
                    <ul class="flex justify-content-center align-items-center">
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
 
                <div class="header-bar-search d-md-none">
                    <form>
                        <input type="search" placeholder="Search">
                    </form>
                </div><!-- .header-bar-search -->
            </nav><!-- .site-navigation -->
        </div><!-- .col -->
    </div><!-- .row -->
</div><!-- .container -->
<script>
$('.site-title').click (function(){
	location.href = '${context}/move/member/member/retrieve';
});
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
});
</script>