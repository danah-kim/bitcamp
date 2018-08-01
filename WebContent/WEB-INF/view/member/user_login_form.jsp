<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>

<div id="login_content">
	<h2>Login Form</h2>
	<form id="login_form_box">
	  <div class="login_imgcontainer">
	    <img src="resources/img/home/img_avatar2.png" alt="Avatar" class="avatar">
	  </div>
	
	  <div class="login_container">
	    <label for="id"><b>Userid</b></label>
	    <input type="text" placeholder="Enter Username" name="id" required>
	
	    <label for="pw"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="pw" required>
	        
	    <button type="button" id="login_form_btn" >Login</button>
	    <!-- <label>
	      <input type="checkbox" checked="checked" name="remember"> Remember me
	    </label> -->
	  </div>
	
	  <div class="login_container">
	    <button type="button" id="login_cancelbtn">Cancel</button>
	    <!-- <span class="psw">Forgot <a href="#">password?</a></span> -->
	  </div>
	</form>
</div>
	<script>
		document.getElementById('login_form_btn').addEventListener('click',function(){
			var form = document.getElementById('login_form_box');
			var x = service.null_chk([form.id.value, form.pw.value]);
			var node
			
			if (x.checker) {
				alert('유효성 체크 통과!');
				
				node = document.createElement('p');
				node.innerHTML = '<input type="hidden" name="action" value="login"/>';
				form.appendChild(node);
				
				form.action = "${context}/member.do";
				form.method = "post";
				form.submit();
			} else {
				alert(x.text);
			}
		});
		document.getElementById('login_cancelbtn').addEventListener('click',function(){
			router.move({context : '${context}', domain : 'member', action : 'move', page : 'move'});
		});
	</script>
</body>
</html>