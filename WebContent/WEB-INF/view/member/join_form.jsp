<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
memId, name, passWord, ssn
-->
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<form class="join_form_box" action="${context}/member.do" onsubmit="return new Common.sendForm()">
		<h1>회원가입</h1>
		<table id="join_table">
			<tr>
				<td id="join_id"> 아이디</td>
				<td>
					<input type="text" name="join_id">
					<%-- <input type="button"
				<%if(MemberServiceImpl.getInstance().iDDualCheck(request.getParameter("join_id"))){
					%>onclick="alert('사용가능한 아이디 입니다.')"<%
					}else{
						%>onclick="alert('사용불가능한 아이디 입니다.')"<% 
					}%>
				value="중복확인"> --%>
				</td>
			</tr>
			<tr>
				<td id="join_password">비밀번호</td>
				<td>
					<input type="text" name="join_pw">
				</td>
			</tr>
			<tr>
				<td id="join_name"> 이름</td>
				<td>
					<input type="text" name="join_name">
				</td>
			</tr>
			<tr>
				<td id="join_birth"> 생년월일</td>
				<td>
					<input type="text" 
						   name="join_birth"
						   placeholder="생년월일(6자)" 
						   maxlength="6"
                           title = "990101 형식으로 입력해주세요" >
				</td>
			</tr>
			<tr>
				<td id="join_gender"> 성별</td>
				<td>
					<input type="radio" name="join_gender" value="-1">남자
					<input type="radio" name="join_gender" value="-2">여자
				</td>
			</tr>
		</table>
			<input type="hidden" name="action" value="join"/>	
			<input type="submit" onclick="alert('환영합니다!')" value="가입하기">
			<p></p>
		</form>
	</div>
</body>
</html>