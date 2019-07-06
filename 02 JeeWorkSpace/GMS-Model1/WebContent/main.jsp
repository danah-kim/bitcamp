<!-- start 자바 util 불러오기 -->
<%@page import="service.MemberServiceImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!-- end 자바 util -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- start 초기화 -->
<%!
	String now = new SimpleDateFormat("yyyy년 mm월 dd일 hh시 mm분 ss초").format(new Date());
	int count = MemberServiceImpl.getInstance().countMember();
%>
<!-- end 초기화 -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>인테리어 집꾸미기는 니방내방</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<h3>현재 시간 : <%= now %>	// 현재 회원수 : <%= count %></h3>
	<!-- table>tr*행갯수>td*열갯수 -->
	<div>
		<table id="main_tab_layout">
			<tr id="main_tab_head_size">
				<td colspan="2" class="text_center" id="main_tab_head_text" >GMS</td>
			</tr>
			<tr id="main_tab_body">
				<td id="main_tab_body_left_size">
					<p class="text_center">
						<img id="main_img_size" src="img/home/test.jpg" alt="이미지">
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
						<li>
							<a href="jsp/mypage/member_list.jsp">회원목록</a>
						</li>
						<li>
							<a href="jsp/mypage/search_team_form.jsp">팀이름으로 검색</a>
						</li>
						<li>
							<a href="jsp/mypage/search_id_form.jsp">아이디로 검색</a>
						</li>
					</ul>
				</td>
			</tr>
			<tr id="main_tab_foot">
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
	</div>
</body>
</html>