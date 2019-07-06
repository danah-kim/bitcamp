<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-17" data-genuitec-path="/gms/src/main/webapp/WEB-INF/views/member/remove.jsp">
	<h3>회원 탈퇴</h3>
	<form id="removeform">
		<table>
			<tr>
				<td >아이디</td>
				<td id='userid'></td>
			</tr>
			<tr>
				<td class="removeInfo" id='password' >비밀번호</td>
				<td>
					<input type="text" name="password"/>
				</td>
			</tr>
		</table><br />
		<input class="formBtn" id="removeBtn" type="button" value="회원탈퇴"/>
	</form>
</div>