<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>

<div class="loginContent">
	<h2>Login Form</h2>
	<form id="loginFormBox">
	  <div class="loginImgcontainer">
	    <img src="resources/img/home/img_avatar2.png" alt="Avatar" class="avatar">
	  </div>
	
	  <div class="loginContainer">
	    <label for="id"><b>Userid</b></label>
	    <input type="text" placeholder="Enter Username" name="id" required>
	
	    <label for="pw"><b>Password</b></label>
	    <input type="text" placeholder="Enter Password" name="pw" required>
	        
	    <button type="button" id="loginFormBtn" >Login</button>
	    <!-- <label>
	      <input type="checkbox" checked="checked" name="remember"> Remember me
	    </label> -->

	    <button type="button" id="loginCancelbtn">Cancel</button>
	    <!-- <span class="psw">Forgot <a href="#">password?</a></span> -->
	  </div>
	</form>
</div>
<script>
	member.login('${context}');
</script>
</body>
</html>