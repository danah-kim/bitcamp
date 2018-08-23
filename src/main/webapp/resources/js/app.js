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
		$('#loginMenu').click (() => {
			location.href = app.x() + '/move/auth/member/login';
		});
		$('#logoutMenu').click (() => {
			location.href = app.x() + '/member/logout';
		});
		$('#myMenu').click (() => {
			location.href = app.x() + '/move/member/member/retrieve';
		});
		$('#addBtn').click (() => {
			location.href = app.x() + '/member/add';
		});
		$('#loginBtn').click (() => {
			location.href = app.x() + '/member/login';
		});
		$('#logoutBtn').click (() => {
			location.href = app.x() + '/member/logout';
		});

	},
	setContentView : ()=>{
		console.log('step4'+ app.session.path('js'));
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