(function() {
	
}());

var router = (()=>{
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
		null_chk : x =>{
			var i = 0;
			var json = {
					checker : true,
					text : '필수입력값이 없습니다.'
			};
			for (i in x){
				if(x[i] === ''){
					json.checker = false;
				}
			}
			return json;
		}
/*		null_chk : member =>{
			var count = 0;
			for (x in member){
				if(member[x] === ''){
					count += 1;
				}
			}
			if(count == 0){
				alert('로그인');
				return true;
				}else{
					alert('입력해주세요');
					return false;
					}
			}*/
	};
})();

var member = (()=>{
	var _id,_pw,_name,_gender,_ssn,_age,_teamid,_roll,_subjec,join;
	var setId = x => {this._id = x;}
	var setPw = x => {this._pw = x;}
	var setName = x => {this._name = x;}
	var setGender = x => {
		var rs;
		switch (x) {
			case '1':
			case '3':
			case '5':
				rs = "남자";
				break;
			case '2':
			case '4':
			case '6':
				rs = "여자";
				break;
			default:
				rs = "?";
				break;
			}
		this._gender = rs;}
	var setSsn = x => {this._ssn = x;}
	var setAge = x => {
		this._age = new Date().getFullYear() - Number(19 + x.substring(0, 2)) + 1;}
	var setTeamid = x => {this._teamid = x;}
	var setRoll = x => {this._roll = x;}
	var setSubject = x => {this._subject = x;}
	var getId = () => {return this._id;}
	var getPw = () => {return this._pw;}
	var getName = () => {return this._name;}
	var getGender = () => {return this._gender;}
	var getSsn = () => {return this._ssn;}
	var getAge = () => {return this._age;}
	var getTeamid = () => {return this._teamid;}
	var getRoll = () => {return this._roll;}
	var getSubject = () => {return this._subject;}
	return {
		setId : setId,
		setPw : setPw,
		setName : setName,
		setGender : setGender,
		setSsn : setSsn,
		setAge : setAge,
		setTeamid : setTeamid,
		setRoll : setRoll,
		setSubject : setSubject,
		getId : getId,
		getPw : getPw,
		getName : getName,
		getGender : getGender,
		getSsn : getSsn,
		getAge : getAge,
		getTeamid : getTeamid,
		getRoll : getRoll,
		getSubject : getSubject,
		join : x => {
			setSsn(x[0]+'-'+x[1]);
			setGender(x[1]);
			setAge(x[0]);
			}
		};
})();