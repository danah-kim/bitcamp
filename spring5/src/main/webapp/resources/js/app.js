"use strict";
var app = app || {};
var user = user || {};
app = {
	init : x => {
		console.log('step1');
		app.session.context(x);
		app.onCreate();
		user.onCreate();
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
			sessionStorage.clear();
		});
		$('#addBtn').click (() => {
			alert('가입버튼클릭');
			$('#addForm')
			.attr({
				action : app.x()+"/member/add", 
				method : "POST"})
			.submit();
		});
		$('#searchBtn').click (() => {
			alert('검색버튼클릭');
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
			alert('수정버튼클릭');
			$('#modifyForm')
			.append('<input type="hidden" name="userid" value="' + user.get('userid') + '"/>')
			.attr({
				action : app.x()+"/member/modify",
				method : "POST"})
			.submit();
		});
		$('#removeBtn').click (() => {
			alert('삭제버튼클릭');
			$('removeForm')
			.append('<input type="hidden" name="userid" value="' + user.get('userid') + '"/>')
			.attr({
				action : app.x() + "/member/remove",
				method : "POST"
			})
			.submit();
		});
		$('#loginBtn').click (() => {
			$('#loginForm')
			.attr({
				action : app.x() + "/member/login",
				method : "POST"
			})
			.submit();
		});
	},
	setContentView : ()=>{
		console.log('step4'+ app.session.path('js'));
	}
};

user = {
	session : x => {
		$.each(x, (k, v)=>{
			sessionStorage.setItem(k, v);
		});
	},
	get : x =>{
		return sessionStorage.getItem(x);
	},
	onCreate : () => {
		alert('세션확인'+user.get('userid'));
		$('#userid').text(user.get('userid'));
		$('#name').text(user.get('name'));
		$('#infoTeamid').append(user.get('teamid'));
		$('#infoRoll').append(user.get('roll'));
		$('input[name="teamid"]').val([user.get('teamid')]);
		$('#roll').val(user.get('roll')).prop('selected', true);
	}
}