function loginUi(x){
	return '<div class="loginContent" id="login1">'
//+ '	<form id="loginForm">'
+ '	  <div class="loginImgcontainer">'
+ '	    <img src="'+x+'/resources/img/profileImg.png" alt="profileImg">'
+ '	  </div>'
	+ ''
+ '	  <div class="loginContainer">'
+ '	    <label for="id"><b>Userid</b></label>'
+ '	    <input required class="loginInfo" type="text" placeholder="Enter Username" id="id">'
	+ ''
+ '	    <label for="pw"><b>Password</b></label>'
+ '	    <input required class="loginInfo" type="text" placeholder="Enter Password" id="pw">'
	        + ''
//+ '	    <button type="button" class="formBtn" id="loginBtn" >Login</button>'
+ '	  </div>'
//+ '	</form>'
+ '</div>';
}