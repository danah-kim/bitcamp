<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
memId, name, passWord, ssn
-->
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<form id="join_form_box">
		<h1>회원가입</h1>
		<table id="join_table">
			<tr>
				<td id="join_id"> 아이디</td>
				<td>
					<input type="text" name="id">
					<input id="join_id_chk" type="button" value="중복확인">
				</td>
			</tr>
			<tr>
				<td id="join_password">비밀번호</td>
				<td>
					<input type="text" name="pw">
				</td>
			</tr>
			<tr>
				<td id="join_name"> 이름</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td id="join_birth"> 생년월일</td>
				<td>
					<input type="text" 
						   name="birth"
						   placeholder="생년월일(6자)" 
						   maxlength="6"
                           title = "990101 형식으로 입력해주세요" >
                           -
                    <input type="text" name="gender" maxlength="1" />
				</td>
			</tr>
			<tr>
				<td> 소속팀</td>
				<td>
					<input type="radio" name="teamid" value="ATEAM"/>걍놀자
					<input type="radio" name="teamid" value="HTEAM"/>지은이네
					<input type="radio" name="teamid" value="STEAM"/>왕거북이
					<input type="radio" name="teamid" value="CTEAM"/>코딩짱
				</td>
			</tr>
			<tr>
				<td> 프로젝트 역할</td>
				<td>
					<select name="roll">
						<option value="">없음</option>
						<option value="Leader">팀장</option>
						<option value="front">프론트개발</option>
						<option value="back">백단개발</option>
						<option value="android">안드로이드개발</option>
						<option value="minfe">민폐</option>
					</select>
				</td>
			</tr>
			<tr>
				<td> 수강과목</td>
				<td>
					<input type="checkbox" name="subject" value="clang" checked="checked"/>C언어
					<input type="checkbox" name="subject" value="JSP"/>JSP
					<input type="checkbox" name="subject" value="PHP"/>PHP
					<input type="checkbox" name="subject" value="nodejs"/>NodeJs
					<input type="checkbox" name="subject" value="linux"/>Linux
					<input type="checkbox" name="subject" value="html"/>HTML
					<input type="checkbox" name="subject" value="spring"/>Spring
				</td>
			</tr>
		</table>
		<br>
			<input id="join_form_but" type="button" value="가입하기">
			<p></p>
		</form>
	</div>
	<script>
		document.getElementById('join_form_but').addEventListener('click',function(){
			var form = document.getElementById('join_form_box');
			
			var x = service.null_chk([
				form.id.value,
				form.pw.value,
				form.name.value,
				form.birth.value,
				form.gender.value
				]);
			if(x.checker){
				member.join([
					form.birth.value,
					form.gender.value]);

				var arr = [{type : 'hidden', name : 'age', value : member.getAge()},
						{type : 'hidden', name : 'ssn', value : member.getSsn()},
						{type : 'hidden', name : 'gender', value : member.getGender()},
						{type : 'hidden', name : 'action', value : 'join'}];
				
				for(var i=0; i<4; i++){
					var node = document.createElement('input');
					node.setAttribute('type', arr[i].type );
					node.setAttribute('name', arr[i].name);
					node.setAttribute('value', arr[i].value);
					form.appendChild(node);
				}
				
				form.action = "${context}/member.do";
				form.method = "post";
				form.submit(); 
			}else{alert(x.text);}
		});
	</script>
</body>
</html>