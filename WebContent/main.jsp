<!-- start 자바 util 불러오기 -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!-- end 자바 util -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- start 초기화 -->
<%!
	int a = 4;
	int b = 3;
	int c = 0;
%>
<!-- end 초기화 -->
<!-- start 연산 -->
<%
	c = a + b;
%>
<!-- end 연산 -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>MYHOME</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>

	<!-- table>tr*행갯수>td*열갯수 -->
	<table id="main_tab_layout" class="width_full; margin_auto">
		<tr id="tab_head">
			<td colspan="2" class="text_center" id="tab_head_text" >GMS</td>
		</tr>
		<tr id="tab_body">
			<td id="tab_body_left_size">
				<p class="text_center">
					<img id="img_size" src="img/home/test.jpg" alt="이미지">
				</p>
			</td>
			<td class="text_center" >
			<!-- ul>li*리스트개수-->
				<ul>
					<li>
						<a href="jsp/login/user_login_form.jsp">사용자 로그인</a>
					</li>
					<li>
						<a href="jsp/login/admin_login.jsp">관리자 로그인</a>
					</li>
					<li>
						<a href="jsp/join/join_form.jsp">회원가입</a>
					</li>
				</ul>
			</td>
		</tr>
		<tr id="tab_foot">
			<td colspan="2">
				<address class="footer_address">
      				<a target="_blank" class="footer_address_item" href="http://bucketplace.co.kr/">상호명 : (주)버킷플레이스</a><br>
      				<a target="_blank" class="footer_address_item" href="mailto:contact@bucketplace.net">이메일 : contact@bucketplace.net</a><br>
     			 	<span class="footer_address_item">대표이사 : 이승재</span><br>
     			 	<span class="footer_address_item">사업자등록번호 : 119-86-91245</span><br>
    			  	<span class="footer_address_item">통신판매업신고번호 : 제2018-서울서초-0580호</span><br>
    			  	<span class="footer_address_item">주소 : 서울특별시 서초구 강남대로 373 홍우빌딩 14층 버킷플레이스</span>
				</address>
			</td>
		</tr>
	</table>
</body>
</html>