"use strict";
var app = app || {};
app = {
	init : x => {
		console.log('step1');
		app.session.context(x);
		app.onCreate();
	},
	onCreate : ()=>{
		console.log('step3');
		app.setContentView();
		$('#addMenu').click (() => {
			location.href = app.x() + '/move/auth/member/add';
		});
		$('#modifyMenu').click (()=>{
			location.href = app.x() + '/move/member/member/modify';
		});
		$('#removeMenu').click (()=>{
			location.href = app.x() + '/move/member/member/remove';
		});
		$('#loginMenu').click (() => {
			location.href = app.x() + '/move/auth/member/login';
		});
		$('#logoutMenu').click (() => {
			location.href = app.x() + '/member/logout';
		});
		$('#addBtn').click (() => {
			alert('가입버튼클릭');
			/*var form = document.getElementById('addBox');
			form.action = app.x() +"/member/add";
			form.method = "post";
			form.submit();*/
			$('#addForm')
			.attr({
				action : app.x()+"/member/add", 
				method : "POST"})
			.submit();
		});
		$('#searchBtn').click (() => {
			var search = $('.searchInfo');
			$('#searchForm')
			.attr({
				action : app.x()+ '/member/serach'
					+ '/condition=' + search[0].value 
					+ '/word=' + search[1].value,
				method : "GET"})
			.submit();
		});
		$('#modifyBtn').click (() => {
			$('#newPw').val($('#newPw').val() || $('#oldPw').val());
			$('#modifyForm')
			.attr({
				action : app.x()+"/member/modify",
				method : "POST"})
			.submit();
		});
		$('#removeBtn').click (() => {
			var info = $('.removeInfo');
			if($('#pw1').val() !== $('#pw2').val()){
				alert('기존비밀번호와 확인 비밀번호가 일치하지 않습니다.');
			}else if(info[0].getAttribute('id') !== $('#pw1').val()){
				alert('기존비밀번호가 일치하지 않습니다.');
			}else{
				alert('탈퇴완료');
				$('removeForm')
				.attr({
					action : app.x() + "/member/remove",
					method : "POST"
				})
				.submit();
			}
		});
		$('#loginBtn').click (() => {
			$('#loginForm')
			.attr({
				action : app.x() + "/member/login",
				method : "POST"
			})
			.submit();
		});
		$('#logoutMenu').click (() => {
			location.href = app.x() + '/member/logout';
		});
	},
	setContentView : ()=>{
		console.log('step4'+ app.session.path('js'));
		$('#id').text(sessionStorage.getItem('userid'));
		$('#name').text(sessionStorage.getItem('name'));
		$('#teamid').text('팀 변경(현재팀 : ' + sessionStorage.getItem('teamid')+' )');
		$('#roll').text('역할 변경(현재역할 : ' + sessionStorage.getItem('roll') + ' )');
		$('.teamId').each(() => {
			if($(this) === sessionStorage.getItem('teamid')){
				$(this).prop("checked", true);
			}
		})
		$('roll').each(() => {
			if($(this) === sessionStorage.getItem('roll')){
				$(this).attr("selected", "selected");
			}
		})
		
		for(var i of $('roll')){
			
		}
	}
};
app.session = {
	context : x => {
		console.log('step2 : ' + x);
		sessionStorage.setItem('context', x);
		sessionStorage.setItem('js', '/resources/js');
		sessionStorage.setItem('css', '/resources/css');
		sessionStorage.setItem('img', '/resources/img');
	},
	path : x => {
		return sessionStorage.getItem(x);
	}
};
app.x = ()=>{
	return app.session.path('context');
};
app.j = ()=>{
	return app.session.path('js');
};
app.c = ()=>{
	return app.session.path('css');
};
app.i = ()=>{
	return app.session.path('img');
};

var user = user || {};
user = {
		
	session : x => {
		if ($('#user') != null) {
			sessionStorage.setItem('userid', x.userid);
			sessionStorage.setItem('name', x.name);
			sessionStorage.setItem('age', x.age);
			sessionStorage.setItem('gender', x.gender);
			sessionStorage.setItem('teamid', x.teamid);
			sessionStorage.setItem('roll', x.roll);
		} else {
			session.remove("userId");
		}
	}
}