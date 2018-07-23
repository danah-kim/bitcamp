<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%= application.getContextPath() %>"/>
<% 
	MemberBean member = (MemberBean)request.getAttribute("user");
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>MYPAGE</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
	<h3> 현재 회원수 : <mark>22</mark>명</h3>
	<div>
		<table id="main_tab_layout">
			<tr id="main_tab_head_size">
				<td colspan="2" class="text_center" id="main_tab_head_text">GMS<br></td>
			</tr>
			<tr id="main_tab_body">
				<td id="main_tab_body_left_size">
					<p class="text_center">
						<img id="main_img_size" src="resources/img/home/test.jpg" alt="이미지">
						</p>
				</td>
				<td class="text_center" >
					<p><%= member.getName() %>의 마이페이지 진입</p>
					<ul>
						<li>
							<a href="${ctx}/member.do?action=move&page=update_form">비밀번호 변경</a></br>
						</li>
						<li>
							<a href="${ctx}/member.do?action=move&page=delete_form">회원탈퇴</a></br>
						</li>
						<li>
							<a href="${ctx}/member.do?action=move&page=move">로그아웃</a></br>
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