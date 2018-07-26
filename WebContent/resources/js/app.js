(function() {
	
}());



var router = (()=>{
	alert('?@?@?');
// key default value is String
	return {move : x => {
		location.href = x[0] + "/" + x[1] 
		+ ".do?action=" + x[2] 
		+ "&page=" + x[3];
		}
	};
})();

var service = (()=>{
	return {
		login_validation : x => {
			if(x[0] == 0){
				alert('아이디를 입력해주세요.');
				return false;
			}else if(x[1] === ''){
				alert('비밀번호를 입력해주세요.');
				return false;
			}else if(x[0] != null && x[1] != null){
				alert('로그인!');
				return true;
			}
		},
		join_validation : x =>{
			
		}
	};
})();

/*function Member(){
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
}*/