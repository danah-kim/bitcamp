<!-- start 자바 servlet 불러오기 -->
<%
	/* 어플리케이션 경로명, ctx를 입력하면 해당 경로로 가라는 메소드 */
	String ctx = application.getContextPath();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>인테리어 집꾸미기는 니방내방</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
	<h3> 현재 회원수 : <mark>22</mark>명</h3>
	<div>
		<table id="main_tab_layout">
			<tr id="main_tab_head_size">
				<td colspan="2" class="text_center" id="main_tab_head_text" >GMS</td>
			</tr>
			<tr id="main_tab_body">
				<td id="main_tab_body_left_size">
					<p class="text_center">
						<img id="main_img_size" src="resources/img/home/test.jpg" alt="이미지">
					</p>
				</td>
				<td class="text_center" >
				<!-- ul>li*리스트개수-->
					<ul>
						<li>
							<!-- 주소창에 표시될 값을 입력 -->
							<a href="<%=ctx%>/member/user_login_form.do">사용자 로그인</a>
						</li>
						<li>
							<a href="<%=ctx%>/member/admin_login.do">관리자 로그인</a>
						</li>
						<li>
							<a href="<%=ctx%>/member/join_form.do">회원가입</a>
						</li>
						<li>
							<a href="<%=ctx%>/member/member_list.do">회원목록</a>
						</li>
						<li>
							<a href="<%=ctx%>/member/search_team_form.do">팀이름으로 검색</a>
						</li>
						<li>
							<a href="<%=ctx%>/member/search_id_form.do">아이디로 검색</a>
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