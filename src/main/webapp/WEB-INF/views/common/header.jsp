<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                            <li><a id="loginBtn" href="#"><i class="fa fa-sign-in"></i></a></li>
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

    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="site-branding flex flex-column align-items-center">
                    <h1 class="site-title"><a href="index.html" rel="home">Danah</a></h1>
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
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-behance"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
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
</header><!-- .site-header -->