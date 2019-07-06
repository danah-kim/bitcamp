<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content">
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
		</table>
		<br />
		<input class="formBtn" id="removeBtn" type="button" value="회원탈퇴"/>
	</form>
</div>
<script>
$('#removeBtn').click (function () {
	$('removeForm')
	.append('<input type="hidden" name="userid" value="' + user.get('userid') + '"/>')
	.attr({
		action : '${context}' + "/member/remove",
		method : "POST"
	})
	.submit();
});
</script>