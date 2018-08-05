/*(function() {
	
}());*/

// 에러나면 바로 보여주겠음
"use strict";

let router = (()=>{
	return {move : x => {
		location.href = 
			x.context + '/' 
			+ x.domain
			+ '.do?action=' + x.action 
			+ '&page=' + x.page;
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
		},
		addClass : (dom,cName) => {
			var arr = cName.split(" ");
			if (arr.indexOf(cName) == -1) {
				dom.className += " " + cName;
			}
		}
	};
})();

var admin = (() => {
	return{
		check : x => {
			router.move({
				context : x, 
				domain : 'admin', 
				action : 'list', 
				page : 'main'});
			/*router.move({
				context : x, 
				domain : 'admin', 
				action : 'count', 
				page : 'main'})*/
			/*var isAdmin = confirm('관리자입니까');
			if(isAdmin){
				var password = prompt('관리자비번을 입력바랍니다');
				if(password == 1){
						alert('관리자페이지 이동');
						router.move({
							context : x, 
							domain : 'admin', 
							action : 'list', 
							page : 'main'});
				}
			}else{
				alert('관리자만 접근이 허용 됩니다.');
			}*/
		},
		main : x => {
			service.addClass(
				document.getElementById('admin_content_box'),
				'admin_content '
			);
			service.addClass(
				document.getElementById('adminSearchSelect'),
				'adminSelect '
			);
			service.addClass(
				document.getElementById('adminSearchFormBox'),
				'adminSearchForm '
			);
			service.addClass(
				document.getElementById('adminSearchFormBox').word,
				'adminSearchFormText '
			);
			service.addClass(
				document.getElementById('adminSearchBtn'),
				'adminSearchBtn '
			);
			service.addClass(
				document.getElementById('admin_context_box_table'),
				'adminList '
			);
			service.addClass(
				document.getElementById('admin_list_tab_box'),
				'adminListTable '
			);
			service.addClass(
				document.getElementById('admin_list_tab_meta'),
				'adminListTableMeta '
			);
				
			document.getElementById('adminSearchBtn').addEventListener('click', function(){
				var form = document.getElementById('adminSearchFormBox');
				var s = document.getElementById('adminSearchSelect');
				var condition = s.options[s.selectedIndex].value;
				alert(condition);
				alert(form.word.value);
				form.method = "get"; 
				form.submit();
				
				/*location.href = x + '/admin.do?action=' + ((condition === 'userid') ? 
					'retrive&page=memberDetail&search_id='
					: ('search&page=main&condition=' + condition+ '&word=')
					+ form.word.value);*/
				router.move({
					context : x,
					domain : 'admin',
					action : (condition === 'userid') ?
					'retrive'
					: 'search',
					page : ((condition === 'userid') ?
						'memberDetail&search_id='
						: 'main&condition=' + condition+ '&word=') + form.word.value
				});

			});

			for(var i of document.querySelectorAll('.username')){				
				i.style.color = 'red';
				i.style.cursor = 'pointer';
				i.addEventListener('click', function(){
					alert('클릭'+this.getAttribute('id'));
					router.move({
						context : x, 
						domain : 'admin', 
						action : 'retrive', 
						page: 'memberDetail&search_id='+ this.getAttribute('id')});
				});
			}
			
			/*var tc = '${count}';
		    var tp = ((tc-1) / pr) + 1;
		    var pr = 5;
		    var pn = 1;
		    var sp = ((p-1)/tp)*tp+1;
		    var ep = sp + pr -1; 
			
			document.getElementById('pageNum').value = pageSet[n];
			
			for(var i of document.querySelectorAll('.pageNum')){
				
			}
			
			document.getElementById('nextPage').addEventListener('click', function(){
				router.move({
					context : x, 
					domain : 'admin', 
					action : 'move', 
					page: 'main'});
				n++;
			});*/
			
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
		join : x => {
			document.getElementById('joinFormBut').addEventListener('click',function(){
				var form = document.getElementById('joinFormBox');
				var y = service.null_chk([
					form.id.value,
					form.pw.value,
					form.name.value,
					form.birth.value,
					form.gender.value
					]);
				
/*				중복체크 기능
				document.getElementById('joinIdChkBtn').addEventListener('click', function(){
					document.getElementById(joinIDChkText);
				});*/
				
				if(y.checker){
					setSsn(form.birth.value+'-'+form.gender.value);
					setGender(form.gender.value);
					setAge(form.birth.value);

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
					
					form.action = x+"/member.do";
					form.method = "get";
					form.submit(); 
				}else{alert(y.text);}
			});
		},
		login : x => {
			document.getElementById('loginFormBtn').addEventListener('click',function(){
				var form = document.getElementById('loginFormBox');
				var y = service.null_chk([form.id.value, form.pw.value]);
				var node
				
				if (y.checker) {
					alert('유효성 체크 통과!');
					
					node = document.createElement('p');
					node.innerHTML = '<input type="hidden" name="action" value="login"/>';
					form.appendChild(node);
					
					form.action = x+"/member.do";
					form.method = "get";
					form.submit();
				} else {
					alert(y.text);
				}
			});
		},
		update : x => {
			alert('수정버튼 클릭');
			for(var i of document.querySelectorAll('.teamid')){
				if(i.value === x[2]){
					i.checked = true;
				}
			}
			
			/*for(var i=1; i<=4; i++){
				if(document.getElementById('teamid_'+i).value === x[1]){
					document.getElementById('teamid_'+i).checked = true;
				}
			}*/
			
			for(var i of document.getElementById('roll')){
				alert(i.value+"///"+x[3]);
				if(i.value === x[3]){
					i.setAttribute("selected", "selected");
				}
			}
			
			/*var roll = document.getElementById('roll');
			for(var i=0; i<roll.options.length; i++){
				if(roll.options[i].value === x[1]){
					roll.options[i].setAttribute("selected", "selected");
				}
			}*/
			
			document.getElementById('updateFormBut').addEventListener('click', function(){
				var form = document.getElementById('updateFormBox');
				var y = {action : 'update'};
				
				if(form.old_pw.value === ''){
					alert('기존 비밀번호를 입력해 주세요.');
				}else if(x[1] !== form.old_pw.value){
					alert('기존 비밀번호가 일치하지 않습니다.');
				}else if(form.new_pw.value === form.old_pw.value) {
					alert('기존 비밀번호와 변경 비밀번호가 동일합니다.');
				}else{
					form.new_pw.value 
						= form.new_pw.value 
						|| form.old_pw.value;

				for(var key in y){
					var node = document.createElement('input');
					node.setAttribute('type', 'hidden');
					node.setAttribute('name', key);
					node.setAttribute('value', y[key]);
					form.appendChild(node);
				}

				form.action = x[0]+"/member.do";
				form.method = "post";
				form.submit();
				}
			});
		},
		delete : x => {
			document.getElementById('deleteFormBut').addEventListener('click', function() {
				alert('삭제버튼 클릭');
				var form = document.getElementById('deleteFormBox');
				var y = service.null_chk([form.pw1.value, form.pw2.value]);

				if(!y.checker){
					alert(y.text);
				}else if(form.pw1.value !== form.pw2.value){
					alert('기존비밀번호와 확인 비밀번호가 일치하지 않습니다.');
				}else if(x[2] !== form.pw1.value){
					alert('기존비밀번호가 일치하지 않습니다.');
				}else{
					alert('탈퇴완료');
					
					var node = document.createElement('input');
					node.innerHTML = '<input type="hidden" name="action" value="delete"/>';
					form.appendChild(node);
					
					form.action = x+"/member.do";
					form.method = "post";
					form.submit();
				}
			});
		}
	};
})();