"use strict";

var router = (()=>{
	return {
		move : x => {
			for(var i of document.querySelectorAll('.menuBtn')){
				i.addEventListener('click', function(){
					var y;
					switch (this.getAttribute('id')) {
						case 'moveMain':
							y = '/common.do?action=move&page=main';
							break;
						case 'moveAdminMain':
							y = '/admin.do?action=search&page=main';
							break;
						case 'moveMeberMain':
							y = '/member.do?action=move&page=main';
							break;
						case 'moveAdmin':
							if(confirm('관리자입니까')){
								var password = prompt('관리자비번을 입력바랍니다');
								if(password == 1){
									alert('관리자페이지 이동');
									y = '/admin.do?action=search&page=search';
								}
							}else{
								alert('관리자만 접근이 허용 됩니다.');
							}
							break;
						case 'moveJoin':
							y = '/member.do?action=move&page=add';
							break;
						case 'moveMemberModify':
							y = '/member.do?action=move&page=modify';
							break;
						case 'moveMemberRemove':
							y = '/member.do?action=move&page=remove';
							break;
						case 'moveLogin':
							y = '/member.do?action=move&page=login';
							break;
						case 'moveLogout':
							y = '/member.do?action=logout&page=main';
							break;
						default:
							break;
					}
					location.href = x + y;
				})
			}
		}
	};
})();

var service = (()=>{
	return {
		nullChk : x =>{
			var i = 0;
			var json = {
					checker : true,
					text : '필수입력값이 입력되지 않았습니다.'
			};
			for (i in x){
				if(x[i] === '') json.checker = false;
			}
			return json;
		},
		addClass : (dom, cName) => {
			if(document.getElementById(searchBtn)){
				var arr = cName.split(" ");
				if (arr.indexOf(cName) == -1) {
					dom.className += " " + cName;
				}
			}
		}
	};
})();

var common = (() => {
	return{
		main : x => {
			router.move(x);
		}	
	};
})();

var admin = (() => {
	return{
		main : x => {
			router.move(x);
			service.addClass(
				document.getElementById('searchSelect'),
				'searchSelect '
			);
			service.addClass(
				document.getElementById('searchText'),
				'searchText '
			);
			service.addClass(
				document.getElementById('searchBtn'),
				'searchBtn '
			);
			service.addClass(
				document.getElementById('contextBoxTable'),
				'searchList '
			);
			service.addClass(
				document.getElementById('searchListTabBox'),
				'searchListTable '
			);
			service.addClass(
				document.getElementById('searchListTabMeta'),
				'searchListTableMeta '
			);
			var search = document.querySelectorAll('.searchInfo');
			for(var i of document.querySelectorAll('.formBtn')){
				i.addEventListener('click', function() {
					switch (this.getAttribute('id')) {
						case 'searchBtn':
							var form = document.getElementById('searchFormBox');
							form.method = "get"; 
							form.submit();
							location.href = x
								+ '/admin.do?action=search&page=main'
								+ '&condition=' + search[0].value 
								+ '&word=' + search[1].value;
							break;
						default:
							break;
					}
				});
			}
			for(var i of document.querySelectorAll('.userName')){
				i.style.color = 'red';
				i.style.cursor = 'pointer';
				i.addEventListener('click', function(){
					location.href = x
						+ '/member.do?action=retrieve&page=retrieve'
						+ '&condition=' + this.getAttribute('id');
				});
			}
			for(var i of document.querySelectorAll('.pageNum')){
				i.style.cursor = 'pointer';
				i.addEventListener('click', function(){
					location.href = x
						+ '/admin.do?action=search&page=main'
						+ '&pageNum=' + this.getAttribute('id')
						+ '&condition=' + search[0].getAttribute('id')
						+ '&word=' + search[1].getAttribute('id');
				});
			}
			for(var i of document.querySelectorAll('.pageBtn')){
				i.addEventListener('click', function(){
					location.href = x
						+ '/admin.do?action=search&page=main'
						+ '&pageNum=' + this.getAttribute('id')
						+ '&condition=' + search[0].getAttribute('id')
						+ '&word=' + search[1].getAttribute('id');
				});
			}
		}
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
		main : x => {
			router.move(x);
			for(var i of document.querySelectorAll('.formBtn')){
				switch (this.getAttribute('id')) {
					case 'loginBtn':
					case 'addBtn':
						document.getElementById('content').style.background = "transparent";
						break;
					case 'modifyBtn':
						var info = document.querySelectorAll('.modifyInfo');
						for(var i of document.querySelectorAll('.teamId')){
							if(i.value === info[2].getAttribute('id')){
								i.checked = true;
							}
						}
						for(var i of document.getElementById('roll')){
							if(i.value === info[3].getAttribute('id')){
								i.setAttribute("selected", "selected");
							}
						}
						break;
					default:
						break;
				}
				i.addEventListener('click', function(){
					switch(this.getAttribute('id')){
						case 'loginBtn':
							var form = document.getElementById('loginBox');
							var y = service.nullChk([form.userId.value, form.passWord.value]);
							var node
							if (y.checker) {
								node = document.createElement('p');
								node.innerHTML = '<input type="hidden" name="action" value="login"/>';
								form.appendChild(node);
								
								form.action = x+"/member.do";
								form.method = "post";
								form.submit();
							} else {
								alert(y.text);
							}
							break;
						case 'addBtn' :
							var form = document.getElementById('addBox');
							var y = service.nullChk([
										form.id.value,
										form.pw.value,
										form.name.value,
										form.birth.value,
										form.gender.value]);
							/*중복체크 기능
							document.getElementById('joinIdChkBtn').addEventListener('click', function(){
								document.getElementById(joinIDChkText);
							});*/
							if(y.checker){
								setSsn(form.birth.value+'-'+form.gender.value);
								setGender(form.gender.value);
								setAge(form.birth.value);
								form.gender.value = getGender();
								var arr = [{type : 'hidden', name : 'age', value : member.getAge()},
											{type : 'hidden', name : 'ssn', value : member.getSsn()},
											{type : 'hidden', name : 'action', value : 'add'}];
								for(var i in arr){
									var node = document.createElement('input');
													node.setAttribute('type', arr[i].type);
													node.setAttribute('name', arr[i].name);
													node.setAttribute('value', arr[i].value);
													form.appendChild(node);
								}
								form.action = x+"/member.do";
								form.method = "post";
								form.submit(); 
							}else{alert(y.text);
							}
							break;
						case 'modifyBtn' :
							var form = document.getElementById('modifyBox');
							var info = document.querySelectorAll('.modifyInfo');
							var y = {action : 'modify'};
							
							if(form.oldPw.value === ''){
								alert('기존 비밀번호를 입력해 주세요.');
							}else if(info[1].getAttribute('id') !== form.oldPw.value){
									alert('기존 비밀번호가 일치하지 않습니다.');
							}else if(form.newPw.value === form.oldPw.value) {
								alert('기존 비밀번호와 변경 비밀번호가 동일합니다.');
							}else{
								form.newPw.value = form.newPw.value || form.oldPw.value;
								for(var key in y){
									var node = document.createElement('input');
									node.setAttribute('type', 'hidden');
									node.setAttribute('name', key);
									node.setAttribute('value', y[key]);
									form.appendChild(node);
								}
								form.action = x+"/member.do";
								form.method = "post";
								form.submit();
							}
							break;
						case 'removeBtn' :
							var info = document.querySelectorAll('.deleteInfo');
							var form = document.getElementById('removeBox');
							var y = service.nullChk([form.pw1.value, form.pw2.value]);
							if(!y.checker){
								alert(y.text);
							}else if(form.pw1.value !== form.pw2.value){
								alert('기존비밀번호와 확인 비밀번호가 일치하지 않습니다.');
							}else if(info[0].getAttribute('id') !== form.pw1.value){
								alert('기존비밀번호가 일치하지 않습니다.');
							}else{
								alert('탈퇴완료');
								var node = document.createElement('input');
								node.innerHTML = '<input type="hidden" name="action" value="remove"/>';
								form.appendChild(node);
								form.action = x+"/member.do";
								form.method = "post";
								form.submit();
							}
							break;
						default:
							break;
					}
				});
			}
		}
	};
})();