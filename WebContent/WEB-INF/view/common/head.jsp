<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%= application.getContextPath() %>"/> --%>
<head>
	<meta charset="UTF-8" />
	<title>인테리어 집꾸미기는 니방내방</title>
	<link rel="stylesheet" type="text/css" href="${css}/style.css" />
<!-- function 선언 -->
	<script>
		/* function Common(){
			this.move = function (domain, action, page) {
				console.log('클릭 테스트 성공 ${context}');
				alert('클릭 테스트 성공 ${context}');
				return location.href = "${context}/" + domain + ".do?action=" + action + "&page=" + page;
			}
			this.sendForm = function (domain, action, page){
				return false;
			}
		} */
		
		// anonymous function : function 이름 제거
		var common = new (function (){
			this.move = function (domain, action, page) {
				console.log('클릭 function 테스트 성공 ${context}');
				alert('클릭 function테스트 성공 ${context}');
				return location.href = "${context}/" + domain + ".do?action=" + action + "&page=" + page;
			}
		});
			
		var member = new (function (){
			var memId,ssn,password;
			this.setMemId = function(x){
				this.memId = x;
			}
			this.setSsn = function(x){
				this.ssn = x;
			}
			this.setPassword = function(x){
				this.password = x;
			}
			this.getMemId = function(){
				return this.memId;
			}
			this.getSsn = function(){
				return this.ssn;
			}
			this.getPassword = function(){
				return this.password;
			}
			this.loginValidation = function () {
				alert('유효성 체크 중!');
				if(this.memId == 0){
					alert('아이디를 입력해주세요.');
					return false;
				}else if(this.password === ''){
					alert('비밀번호를 입력해주세요.');
					return false;
				}else if(this.memId != null && this.password != null){
					alert('로그인!');
					return true;
				}
			}
		});
	</script>
</head>