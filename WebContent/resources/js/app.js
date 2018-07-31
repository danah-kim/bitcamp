/*(function() {
	
}());*/

// 에러나면 바로 보여주겠음
"use strict";

let router = (()=>{
// key default value is String
	return {move : x => {
		location.href = 
			x.context + '/' 
			+ x.domain
			+ '.do?action=' + x.action 
			+ '&page=' + x.page;
		System.out.print(move());
		}
	};
})();

let service = (()=>{
	return {
		null_chk : x =>{
			let i = 0;
			let json = {
					checker : true,
					text : '필수입력값이 입력되지 않았습니다.'
			};
			
			for (i in x){
				if(x[i] === '') json.checker = false;
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

let member = (()=>{
	let _id,_pw,_name,_gender,_ssn,_age,_teamid,_roll,_subjec,join;
	let setId = x => {this._id = x;}
	let setPw = x => {this._pw = x;}
	let setName = x => {this._name = x;}
	let setGender = x => {
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
	let setSsn = x => {this._ssn = x;}
	let setAge = x => {this._age = new Date().getFullYear() - +(19 + x.substring(0, 2)) + 1;}
	let setTeamid = x => {this._teamid = x;}
	let setRoll = x => {this._roll = x;}
	let setSubject = x => {this._subject = x;}
	let getId = () => {return this._id;}
	let getPw = () => {return this._pw;}
	let getName = () => {return this._name;}
	let getGender = () => {return this._gender;}
	let getSsn = () => {return this._ssn;}
	let getAge = () => {return this._age;}
	let getTeamid = () => {return this._teamid;}
	let getRoll = () => {return this._roll;}
	let getSubject = () => {return this._subject;}
	
	return {
		setId,
		setPw,
		setName,
		setGender,
		setSsn,
		setAge,
		setTeamid,
		setRoll,
		setSubject,
		getId,
		getPw,
		getName,
		getGender,
		getSsn,
		getAge,
		getTeamid,
		getRoll,
		getSubject,
		join : x => {
			setSsn(x[0]+'-'+x[1]);
			setGender(x[1]);
			setAge(x[0]);
			}
		};
})();